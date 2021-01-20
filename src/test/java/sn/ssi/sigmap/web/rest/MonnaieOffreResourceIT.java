package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.MonnaieOffre;
import sn.ssi.sigmap.repository.MonnaieOffreRepository;
import sn.ssi.sigmap.service.MonnaieOffreService;
import sn.ssi.sigmap.service.dto.MonnaieOffreDTO;
import sn.ssi.sigmap.service.mapper.MonnaieOffreMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link MonnaieOffreResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class MonnaieOffreResourceIT {

    private static final String DEFAULT_MON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MON_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_MON_LIBELLE = "BBBBBBBBBB";

    @Autowired
    private MonnaieOffreRepository monnaieOffreRepository;

    @Autowired
    private MonnaieOffreMapper monnaieOffreMapper;

    @Autowired
    private MonnaieOffreService monnaieOffreService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMonnaieOffreMockMvc;

    private MonnaieOffre monnaieOffre;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MonnaieOffre createEntity(EntityManager em) {
        MonnaieOffre monnaieOffre = new MonnaieOffre()
            .monCode(DEFAULT_MON_CODE)
            .monLibelle(DEFAULT_MON_LIBELLE);
        return monnaieOffre;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MonnaieOffre createUpdatedEntity(EntityManager em) {
        MonnaieOffre monnaieOffre = new MonnaieOffre()
            .monCode(UPDATED_MON_CODE)
            .monLibelle(UPDATED_MON_LIBELLE);
        return monnaieOffre;
    }

    @BeforeEach
    public void initTest() {
        monnaieOffre = createEntity(em);
    }

    @Test
    @Transactional
    public void createMonnaieOffre() throws Exception {
        int databaseSizeBeforeCreate = monnaieOffreRepository.findAll().size();
        // Create the MonnaieOffre
        MonnaieOffreDTO monnaieOffreDTO = monnaieOffreMapper.toDto(monnaieOffre);
        restMonnaieOffreMockMvc.perform(post("/api/monnaie-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(monnaieOffreDTO)))
            .andExpect(status().isCreated());

        // Validate the MonnaieOffre in the database
        List<MonnaieOffre> monnaieOffreList = monnaieOffreRepository.findAll();
        assertThat(monnaieOffreList).hasSize(databaseSizeBeforeCreate + 1);
        MonnaieOffre testMonnaieOffre = monnaieOffreList.get(monnaieOffreList.size() - 1);
        assertThat(testMonnaieOffre.getMonCode()).isEqualTo(DEFAULT_MON_CODE);
        assertThat(testMonnaieOffre.getMonLibelle()).isEqualTo(DEFAULT_MON_LIBELLE);
    }

    @Test
    @Transactional
    public void createMonnaieOffreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = monnaieOffreRepository.findAll().size();

        // Create the MonnaieOffre with an existing ID
        monnaieOffre.setId(1L);
        MonnaieOffreDTO monnaieOffreDTO = monnaieOffreMapper.toDto(monnaieOffre);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMonnaieOffreMockMvc.perform(post("/api/monnaie-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(monnaieOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MonnaieOffre in the database
        List<MonnaieOffre> monnaieOffreList = monnaieOffreRepository.findAll();
        assertThat(monnaieOffreList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllMonnaieOffres() throws Exception {
        // Initialize the database
        monnaieOffreRepository.saveAndFlush(monnaieOffre);

        // Get all the monnaieOffreList
        restMonnaieOffreMockMvc.perform(get("/api/monnaie-offres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(monnaieOffre.getId().intValue())))
            .andExpect(jsonPath("$.[*].monCode").value(hasItem(DEFAULT_MON_CODE)))
            .andExpect(jsonPath("$.[*].monLibelle").value(hasItem(DEFAULT_MON_LIBELLE)));
    }
    
    @Test
    @Transactional
    public void getMonnaieOffre() throws Exception {
        // Initialize the database
        monnaieOffreRepository.saveAndFlush(monnaieOffre);

        // Get the monnaieOffre
        restMonnaieOffreMockMvc.perform(get("/api/monnaie-offres/{id}", monnaieOffre.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(monnaieOffre.getId().intValue()))
            .andExpect(jsonPath("$.monCode").value(DEFAULT_MON_CODE))
            .andExpect(jsonPath("$.monLibelle").value(DEFAULT_MON_LIBELLE));
    }
    @Test
    @Transactional
    public void getNonExistingMonnaieOffre() throws Exception {
        // Get the monnaieOffre
        restMonnaieOffreMockMvc.perform(get("/api/monnaie-offres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMonnaieOffre() throws Exception {
        // Initialize the database
        monnaieOffreRepository.saveAndFlush(monnaieOffre);

        int databaseSizeBeforeUpdate = monnaieOffreRepository.findAll().size();

        // Update the monnaieOffre
        MonnaieOffre updatedMonnaieOffre = monnaieOffreRepository.findById(monnaieOffre.getId()).get();
        // Disconnect from session so that the updates on updatedMonnaieOffre are not directly saved in db
        em.detach(updatedMonnaieOffre);
        updatedMonnaieOffre
            .monCode(UPDATED_MON_CODE)
            .monLibelle(UPDATED_MON_LIBELLE);
        MonnaieOffreDTO monnaieOffreDTO = monnaieOffreMapper.toDto(updatedMonnaieOffre);

        restMonnaieOffreMockMvc.perform(put("/api/monnaie-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(monnaieOffreDTO)))
            .andExpect(status().isOk());

        // Validate the MonnaieOffre in the database
        List<MonnaieOffre> monnaieOffreList = monnaieOffreRepository.findAll();
        assertThat(monnaieOffreList).hasSize(databaseSizeBeforeUpdate);
        MonnaieOffre testMonnaieOffre = monnaieOffreList.get(monnaieOffreList.size() - 1);
        assertThat(testMonnaieOffre.getMonCode()).isEqualTo(UPDATED_MON_CODE);
        assertThat(testMonnaieOffre.getMonLibelle()).isEqualTo(UPDATED_MON_LIBELLE);
    }

    @Test
    @Transactional
    public void updateNonExistingMonnaieOffre() throws Exception {
        int databaseSizeBeforeUpdate = monnaieOffreRepository.findAll().size();

        // Create the MonnaieOffre
        MonnaieOffreDTO monnaieOffreDTO = monnaieOffreMapper.toDto(monnaieOffre);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMonnaieOffreMockMvc.perform(put("/api/monnaie-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(monnaieOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MonnaieOffre in the database
        List<MonnaieOffre> monnaieOffreList = monnaieOffreRepository.findAll();
        assertThat(monnaieOffreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMonnaieOffre() throws Exception {
        // Initialize the database
        monnaieOffreRepository.saveAndFlush(monnaieOffre);

        int databaseSizeBeforeDelete = monnaieOffreRepository.findAll().size();

        // Delete the monnaieOffre
        restMonnaieOffreMockMvc.perform(delete("/api/monnaie-offres/{id}", monnaieOffre.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MonnaieOffre> monnaieOffreList = monnaieOffreRepository.findAll();
        assertThat(monnaieOffreList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
