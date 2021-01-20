package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Critere;
import sn.ssi.sigmap.repository.CritereRepository;
import sn.ssi.sigmap.service.CritereService;
import sn.ssi.sigmap.service.dto.CritereDTO;
import sn.ssi.sigmap.service.mapper.CritereMapper;

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
 * Integration tests for the {@link CritereResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CritereResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    @Autowired
    private CritereRepository critereRepository;

    @Autowired
    private CritereMapper critereMapper;

    @Autowired
    private CritereService critereService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCritereMockMvc;

    private Critere critere;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Critere createEntity(EntityManager em) {
        Critere critere = new Critere()
            .libelle(DEFAULT_LIBELLE)
            .autoriteId(DEFAULT_AUTORITE_ID);
        return critere;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Critere createUpdatedEntity(EntityManager em) {
        Critere critere = new Critere()
            .libelle(UPDATED_LIBELLE)
            .autoriteId(UPDATED_AUTORITE_ID);
        return critere;
    }

    @BeforeEach
    public void initTest() {
        critere = createEntity(em);
    }

    @Test
    @Transactional
    public void createCritere() throws Exception {
        int databaseSizeBeforeCreate = critereRepository.findAll().size();
        // Create the Critere
        CritereDTO critereDTO = critereMapper.toDto(critere);
        restCritereMockMvc.perform(post("/api/criteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereDTO)))
            .andExpect(status().isCreated());

        // Validate the Critere in the database
        List<Critere> critereList = critereRepository.findAll();
        assertThat(critereList).hasSize(databaseSizeBeforeCreate + 1);
        Critere testCritere = critereList.get(critereList.size() - 1);
        assertThat(testCritere.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testCritere.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void createCritereWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = critereRepository.findAll().size();

        // Create the Critere with an existing ID
        critere.setId(1L);
        CritereDTO critereDTO = critereMapper.toDto(critere);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCritereMockMvc.perform(post("/api/criteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Critere in the database
        List<Critere> critereList = critereRepository.findAll();
        assertThat(critereList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCriteres() throws Exception {
        // Initialize the database
        critereRepository.saveAndFlush(critere);

        // Get all the critereList
        restCritereMockMvc.perform(get("/api/criteres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(critere.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getCritere() throws Exception {
        // Initialize the database
        critereRepository.saveAndFlush(critere);

        // Get the critere
        restCritereMockMvc.perform(get("/api/criteres/{id}", critere.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(critere.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingCritere() throws Exception {
        // Get the critere
        restCritereMockMvc.perform(get("/api/criteres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCritere() throws Exception {
        // Initialize the database
        critereRepository.saveAndFlush(critere);

        int databaseSizeBeforeUpdate = critereRepository.findAll().size();

        // Update the critere
        Critere updatedCritere = critereRepository.findById(critere.getId()).get();
        // Disconnect from session so that the updates on updatedCritere are not directly saved in db
        em.detach(updatedCritere);
        updatedCritere
            .libelle(UPDATED_LIBELLE)
            .autoriteId(UPDATED_AUTORITE_ID);
        CritereDTO critereDTO = critereMapper.toDto(updatedCritere);

        restCritereMockMvc.perform(put("/api/criteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereDTO)))
            .andExpect(status().isOk());

        // Validate the Critere in the database
        List<Critere> critereList = critereRepository.findAll();
        assertThat(critereList).hasSize(databaseSizeBeforeUpdate);
        Critere testCritere = critereList.get(critereList.size() - 1);
        assertThat(testCritere.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testCritere.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingCritere() throws Exception {
        int databaseSizeBeforeUpdate = critereRepository.findAll().size();

        // Create the Critere
        CritereDTO critereDTO = critereMapper.toDto(critere);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCritereMockMvc.perform(put("/api/criteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Critere in the database
        List<Critere> critereList = critereRepository.findAll();
        assertThat(critereList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCritere() throws Exception {
        // Initialize the database
        critereRepository.saveAndFlush(critere);

        int databaseSizeBeforeDelete = critereRepository.findAll().size();

        // Delete the critere
        restCritereMockMvc.perform(delete("/api/criteres/{id}", critere.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Critere> critereList = critereRepository.findAll();
        assertThat(critereList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
