package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.PiecesRecus;
import sn.ssi.sigmap.repository.PiecesRecusRepository;
import sn.ssi.sigmap.service.PiecesRecusService;
import sn.ssi.sigmap.service.dto.PiecesRecusDTO;
import sn.ssi.sigmap.service.mapper.PiecesRecusMapper;

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
 * Integration tests for the {@link PiecesRecusResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PiecesRecusResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Integer DEFAULT_GARANTIE = 1;
    private static final Integer UPDATED_GARANTIE = 2;

    @Autowired
    private PiecesRecusRepository piecesRecusRepository;

    @Autowired
    private PiecesRecusMapper piecesRecusMapper;

    @Autowired
    private PiecesRecusService piecesRecusService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPiecesRecusMockMvc;

    private PiecesRecus piecesRecus;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PiecesRecus createEntity(EntityManager em) {
        PiecesRecus piecesRecus = new PiecesRecus()
            .libelle(DEFAULT_LIBELLE)
            .description(DEFAULT_DESCRIPTION)
            .garantie(DEFAULT_GARANTIE);
        return piecesRecus;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PiecesRecus createUpdatedEntity(EntityManager em) {
        PiecesRecus piecesRecus = new PiecesRecus()
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION)
            .garantie(UPDATED_GARANTIE);
        return piecesRecus;
    }

    @BeforeEach
    public void initTest() {
        piecesRecus = createEntity(em);
    }

    @Test
    @Transactional
    public void createPiecesRecus() throws Exception {
        int databaseSizeBeforeCreate = piecesRecusRepository.findAll().size();
        // Create the PiecesRecus
        PiecesRecusDTO piecesRecusDTO = piecesRecusMapper.toDto(piecesRecus);
        restPiecesRecusMockMvc.perform(post("/api/pieces-recuses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesRecusDTO)))
            .andExpect(status().isCreated());

        // Validate the PiecesRecus in the database
        List<PiecesRecus> piecesRecusList = piecesRecusRepository.findAll();
        assertThat(piecesRecusList).hasSize(databaseSizeBeforeCreate + 1);
        PiecesRecus testPiecesRecus = piecesRecusList.get(piecesRecusList.size() - 1);
        assertThat(testPiecesRecus.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testPiecesRecus.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testPiecesRecus.getGarantie()).isEqualTo(DEFAULT_GARANTIE);
    }

    @Test
    @Transactional
    public void createPiecesRecusWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = piecesRecusRepository.findAll().size();

        // Create the PiecesRecus with an existing ID
        piecesRecus.setId(1L);
        PiecesRecusDTO piecesRecusDTO = piecesRecusMapper.toDto(piecesRecus);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPiecesRecusMockMvc.perform(post("/api/pieces-recuses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesRecusDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PiecesRecus in the database
        List<PiecesRecus> piecesRecusList = piecesRecusRepository.findAll();
        assertThat(piecesRecusList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPiecesRecuses() throws Exception {
        // Initialize the database
        piecesRecusRepository.saveAndFlush(piecesRecus);

        // Get all the piecesRecusList
        restPiecesRecusMockMvc.perform(get("/api/pieces-recuses?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(piecesRecus.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].garantie").value(hasItem(DEFAULT_GARANTIE)));
    }
    
    @Test
    @Transactional
    public void getPiecesRecus() throws Exception {
        // Initialize the database
        piecesRecusRepository.saveAndFlush(piecesRecus);

        // Get the piecesRecus
        restPiecesRecusMockMvc.perform(get("/api/pieces-recuses/{id}", piecesRecus.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(piecesRecus.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.garantie").value(DEFAULT_GARANTIE));
    }
    @Test
    @Transactional
    public void getNonExistingPiecesRecus() throws Exception {
        // Get the piecesRecus
        restPiecesRecusMockMvc.perform(get("/api/pieces-recuses/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePiecesRecus() throws Exception {
        // Initialize the database
        piecesRecusRepository.saveAndFlush(piecesRecus);

        int databaseSizeBeforeUpdate = piecesRecusRepository.findAll().size();

        // Update the piecesRecus
        PiecesRecus updatedPiecesRecus = piecesRecusRepository.findById(piecesRecus.getId()).get();
        // Disconnect from session so that the updates on updatedPiecesRecus are not directly saved in db
        em.detach(updatedPiecesRecus);
        updatedPiecesRecus
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION)
            .garantie(UPDATED_GARANTIE);
        PiecesRecusDTO piecesRecusDTO = piecesRecusMapper.toDto(updatedPiecesRecus);

        restPiecesRecusMockMvc.perform(put("/api/pieces-recuses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesRecusDTO)))
            .andExpect(status().isOk());

        // Validate the PiecesRecus in the database
        List<PiecesRecus> piecesRecusList = piecesRecusRepository.findAll();
        assertThat(piecesRecusList).hasSize(databaseSizeBeforeUpdate);
        PiecesRecus testPiecesRecus = piecesRecusList.get(piecesRecusList.size() - 1);
        assertThat(testPiecesRecus.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testPiecesRecus.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testPiecesRecus.getGarantie()).isEqualTo(UPDATED_GARANTIE);
    }

    @Test
    @Transactional
    public void updateNonExistingPiecesRecus() throws Exception {
        int databaseSizeBeforeUpdate = piecesRecusRepository.findAll().size();

        // Create the PiecesRecus
        PiecesRecusDTO piecesRecusDTO = piecesRecusMapper.toDto(piecesRecus);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPiecesRecusMockMvc.perform(put("/api/pieces-recuses")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesRecusDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PiecesRecus in the database
        List<PiecesRecus> piecesRecusList = piecesRecusRepository.findAll();
        assertThat(piecesRecusList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePiecesRecus() throws Exception {
        // Initialize the database
        piecesRecusRepository.saveAndFlush(piecesRecus);

        int databaseSizeBeforeDelete = piecesRecusRepository.findAll().size();

        // Delete the piecesRecus
        restPiecesRecusMockMvc.perform(delete("/api/pieces-recuses/{id}", piecesRecus.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PiecesRecus> piecesRecusList = piecesRecusRepository.findAll();
        assertThat(piecesRecusList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
