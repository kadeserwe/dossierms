package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.GarantiesDossier;
import sn.ssi.sigmap.repository.GarantiesDossierRepository;
import sn.ssi.sigmap.service.GarantiesDossierService;
import sn.ssi.sigmap.service.dto.GarantiesDossierDTO;
import sn.ssi.sigmap.service.mapper.GarantiesDossierMapper;

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
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link GarantiesDossierResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class GarantiesDossierResourceIT {

    private static final BigDecimal DEFAULT_POURCENTAGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_POURCENTAGE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT = new BigDecimal(2);

    private static final Long DEFAULT_AUTIRITE_ID = 1L;
    private static final Long UPDATED_AUTIRITE_ID = 2L;

    @Autowired
    private GarantiesDossierRepository garantiesDossierRepository;

    @Autowired
    private GarantiesDossierMapper garantiesDossierMapper;

    @Autowired
    private GarantiesDossierService garantiesDossierService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGarantiesDossierMockMvc;

    private GarantiesDossier garantiesDossier;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GarantiesDossier createEntity(EntityManager em) {
        GarantiesDossier garantiesDossier = new GarantiesDossier()
            .pourcentage(DEFAULT_POURCENTAGE)
            .montant(DEFAULT_MONTANT)
            .autiriteId(DEFAULT_AUTIRITE_ID);
        return garantiesDossier;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GarantiesDossier createUpdatedEntity(EntityManager em) {
        GarantiesDossier garantiesDossier = new GarantiesDossier()
            .pourcentage(UPDATED_POURCENTAGE)
            .montant(UPDATED_MONTANT)
            .autiriteId(UPDATED_AUTIRITE_ID);
        return garantiesDossier;
    }

    @BeforeEach
    public void initTest() {
        garantiesDossier = createEntity(em);
    }

    @Test
    @Transactional
    public void createGarantiesDossier() throws Exception {
        int databaseSizeBeforeCreate = garantiesDossierRepository.findAll().size();
        // Create the GarantiesDossier
        GarantiesDossierDTO garantiesDossierDTO = garantiesDossierMapper.toDto(garantiesDossier);
        restGarantiesDossierMockMvc.perform(post("/api/garanties-dossiers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesDossierDTO)))
            .andExpect(status().isCreated());

        // Validate the GarantiesDossier in the database
        List<GarantiesDossier> garantiesDossierList = garantiesDossierRepository.findAll();
        assertThat(garantiesDossierList).hasSize(databaseSizeBeforeCreate + 1);
        GarantiesDossier testGarantiesDossier = garantiesDossierList.get(garantiesDossierList.size() - 1);
        assertThat(testGarantiesDossier.getPourcentage()).isEqualTo(DEFAULT_POURCENTAGE);
        assertThat(testGarantiesDossier.getMontant()).isEqualTo(DEFAULT_MONTANT);
        assertThat(testGarantiesDossier.getAutiriteId()).isEqualTo(DEFAULT_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void createGarantiesDossierWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = garantiesDossierRepository.findAll().size();

        // Create the GarantiesDossier with an existing ID
        garantiesDossier.setId(1L);
        GarantiesDossierDTO garantiesDossierDTO = garantiesDossierMapper.toDto(garantiesDossier);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGarantiesDossierMockMvc.perform(post("/api/garanties-dossiers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesDossierDTO)))
            .andExpect(status().isBadRequest());

        // Validate the GarantiesDossier in the database
        List<GarantiesDossier> garantiesDossierList = garantiesDossierRepository.findAll();
        assertThat(garantiesDossierList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllGarantiesDossiers() throws Exception {
        // Initialize the database
        garantiesDossierRepository.saveAndFlush(garantiesDossier);

        // Get all the garantiesDossierList
        restGarantiesDossierMockMvc.perform(get("/api/garanties-dossiers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(garantiesDossier.getId().intValue())))
            .andExpect(jsonPath("$.[*].pourcentage").value(hasItem(DEFAULT_POURCENTAGE.intValue())))
            .andExpect(jsonPath("$.[*].montant").value(hasItem(DEFAULT_MONTANT.intValue())))
            .andExpect(jsonPath("$.[*].autiriteId").value(hasItem(DEFAULT_AUTIRITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getGarantiesDossier() throws Exception {
        // Initialize the database
        garantiesDossierRepository.saveAndFlush(garantiesDossier);

        // Get the garantiesDossier
        restGarantiesDossierMockMvc.perform(get("/api/garanties-dossiers/{id}", garantiesDossier.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(garantiesDossier.getId().intValue()))
            .andExpect(jsonPath("$.pourcentage").value(DEFAULT_POURCENTAGE.intValue()))
            .andExpect(jsonPath("$.montant").value(DEFAULT_MONTANT.intValue()))
            .andExpect(jsonPath("$.autiriteId").value(DEFAULT_AUTIRITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingGarantiesDossier() throws Exception {
        // Get the garantiesDossier
        restGarantiesDossierMockMvc.perform(get("/api/garanties-dossiers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGarantiesDossier() throws Exception {
        // Initialize the database
        garantiesDossierRepository.saveAndFlush(garantiesDossier);

        int databaseSizeBeforeUpdate = garantiesDossierRepository.findAll().size();

        // Update the garantiesDossier
        GarantiesDossier updatedGarantiesDossier = garantiesDossierRepository.findById(garantiesDossier.getId()).get();
        // Disconnect from session so that the updates on updatedGarantiesDossier are not directly saved in db
        em.detach(updatedGarantiesDossier);
        updatedGarantiesDossier
            .pourcentage(UPDATED_POURCENTAGE)
            .montant(UPDATED_MONTANT)
            .autiriteId(UPDATED_AUTIRITE_ID);
        GarantiesDossierDTO garantiesDossierDTO = garantiesDossierMapper.toDto(updatedGarantiesDossier);

        restGarantiesDossierMockMvc.perform(put("/api/garanties-dossiers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesDossierDTO)))
            .andExpect(status().isOk());

        // Validate the GarantiesDossier in the database
        List<GarantiesDossier> garantiesDossierList = garantiesDossierRepository.findAll();
        assertThat(garantiesDossierList).hasSize(databaseSizeBeforeUpdate);
        GarantiesDossier testGarantiesDossier = garantiesDossierList.get(garantiesDossierList.size() - 1);
        assertThat(testGarantiesDossier.getPourcentage()).isEqualTo(UPDATED_POURCENTAGE);
        assertThat(testGarantiesDossier.getMontant()).isEqualTo(UPDATED_MONTANT);
        assertThat(testGarantiesDossier.getAutiriteId()).isEqualTo(UPDATED_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingGarantiesDossier() throws Exception {
        int databaseSizeBeforeUpdate = garantiesDossierRepository.findAll().size();

        // Create the GarantiesDossier
        GarantiesDossierDTO garantiesDossierDTO = garantiesDossierMapper.toDto(garantiesDossier);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGarantiesDossierMockMvc.perform(put("/api/garanties-dossiers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesDossierDTO)))
            .andExpect(status().isBadRequest());

        // Validate the GarantiesDossier in the database
        List<GarantiesDossier> garantiesDossierList = garantiesDossierRepository.findAll();
        assertThat(garantiesDossierList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGarantiesDossier() throws Exception {
        // Initialize the database
        garantiesDossierRepository.saveAndFlush(garantiesDossier);

        int databaseSizeBeforeDelete = garantiesDossierRepository.findAll().size();

        // Delete the garantiesDossier
        restGarantiesDossierMockMvc.perform(delete("/api/garanties-dossiers/{id}", garantiesDossier.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<GarantiesDossier> garantiesDossierList = garantiesDossierRepository.findAll();
        assertThat(garantiesDossierList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
