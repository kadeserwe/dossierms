package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.GarantiesSoumissionnaire;
import sn.ssi.sigmap.repository.GarantiesSoumissionnaireRepository;
import sn.ssi.sigmap.service.GarantiesSoumissionnaireService;
import sn.ssi.sigmap.service.dto.GarantiesSoumissionnaireDTO;
import sn.ssi.sigmap.service.mapper.GarantiesSoumissionnaireMapper;

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
 * Integration tests for the {@link GarantiesSoumissionnaireResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class GarantiesSoumissionnaireResourceIT {

    private static final String DEFAULT_FOURNIE = "AAAAAAAAAA";
    private static final String UPDATED_FOURNIE = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_OBSERVATIONS = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATIONS = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLELOT = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLELOT = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MONTANT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT = new BigDecimal(2);

    @Autowired
    private GarantiesSoumissionnaireRepository garantiesSoumissionnaireRepository;

    @Autowired
    private GarantiesSoumissionnaireMapper garantiesSoumissionnaireMapper;

    @Autowired
    private GarantiesSoumissionnaireService garantiesSoumissionnaireService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restGarantiesSoumissionnaireMockMvc;

    private GarantiesSoumissionnaire garantiesSoumissionnaire;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GarantiesSoumissionnaire createEntity(EntityManager em) {
        GarantiesSoumissionnaire garantiesSoumissionnaire = new GarantiesSoumissionnaire()
            .fournie(DEFAULT_FOURNIE)
            .libelle(DEFAULT_LIBELLE)
            .observations(DEFAULT_OBSERVATIONS)
            .libellelot(DEFAULT_LIBELLELOT)
            .montant(DEFAULT_MONTANT);
        return garantiesSoumissionnaire;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static GarantiesSoumissionnaire createUpdatedEntity(EntityManager em) {
        GarantiesSoumissionnaire garantiesSoumissionnaire = new GarantiesSoumissionnaire()
            .fournie(UPDATED_FOURNIE)
            .libelle(UPDATED_LIBELLE)
            .observations(UPDATED_OBSERVATIONS)
            .libellelot(UPDATED_LIBELLELOT)
            .montant(UPDATED_MONTANT);
        return garantiesSoumissionnaire;
    }

    @BeforeEach
    public void initTest() {
        garantiesSoumissionnaire = createEntity(em);
    }

    @Test
    @Transactional
    public void createGarantiesSoumissionnaire() throws Exception {
        int databaseSizeBeforeCreate = garantiesSoumissionnaireRepository.findAll().size();
        // Create the GarantiesSoumissionnaire
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO = garantiesSoumissionnaireMapper.toDto(garantiesSoumissionnaire);
        restGarantiesSoumissionnaireMockMvc.perform(post("/api/garanties-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesSoumissionnaireDTO)))
            .andExpect(status().isCreated());

        // Validate the GarantiesSoumissionnaire in the database
        List<GarantiesSoumissionnaire> garantiesSoumissionnaireList = garantiesSoumissionnaireRepository.findAll();
        assertThat(garantiesSoumissionnaireList).hasSize(databaseSizeBeforeCreate + 1);
        GarantiesSoumissionnaire testGarantiesSoumissionnaire = garantiesSoumissionnaireList.get(garantiesSoumissionnaireList.size() - 1);
        assertThat(testGarantiesSoumissionnaire.getFournie()).isEqualTo(DEFAULT_FOURNIE);
        assertThat(testGarantiesSoumissionnaire.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testGarantiesSoumissionnaire.getObservations()).isEqualTo(DEFAULT_OBSERVATIONS);
        assertThat(testGarantiesSoumissionnaire.getLibellelot()).isEqualTo(DEFAULT_LIBELLELOT);
        assertThat(testGarantiesSoumissionnaire.getMontant()).isEqualTo(DEFAULT_MONTANT);
    }

    @Test
    @Transactional
    public void createGarantiesSoumissionnaireWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = garantiesSoumissionnaireRepository.findAll().size();

        // Create the GarantiesSoumissionnaire with an existing ID
        garantiesSoumissionnaire.setId(1L);
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO = garantiesSoumissionnaireMapper.toDto(garantiesSoumissionnaire);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGarantiesSoumissionnaireMockMvc.perform(post("/api/garanties-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesSoumissionnaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the GarantiesSoumissionnaire in the database
        List<GarantiesSoumissionnaire> garantiesSoumissionnaireList = garantiesSoumissionnaireRepository.findAll();
        assertThat(garantiesSoumissionnaireList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllGarantiesSoumissionnaires() throws Exception {
        // Initialize the database
        garantiesSoumissionnaireRepository.saveAndFlush(garantiesSoumissionnaire);

        // Get all the garantiesSoumissionnaireList
        restGarantiesSoumissionnaireMockMvc.perform(get("/api/garanties-soumissionnaires?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(garantiesSoumissionnaire.getId().intValue())))
            .andExpect(jsonPath("$.[*].fournie").value(hasItem(DEFAULT_FOURNIE)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].observations").value(hasItem(DEFAULT_OBSERVATIONS)))
            .andExpect(jsonPath("$.[*].libellelot").value(hasItem(DEFAULT_LIBELLELOT)))
            .andExpect(jsonPath("$.[*].montant").value(hasItem(DEFAULT_MONTANT.intValue())));
    }
    
    @Test
    @Transactional
    public void getGarantiesSoumissionnaire() throws Exception {
        // Initialize the database
        garantiesSoumissionnaireRepository.saveAndFlush(garantiesSoumissionnaire);

        // Get the garantiesSoumissionnaire
        restGarantiesSoumissionnaireMockMvc.perform(get("/api/garanties-soumissionnaires/{id}", garantiesSoumissionnaire.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(garantiesSoumissionnaire.getId().intValue()))
            .andExpect(jsonPath("$.fournie").value(DEFAULT_FOURNIE))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.observations").value(DEFAULT_OBSERVATIONS))
            .andExpect(jsonPath("$.libellelot").value(DEFAULT_LIBELLELOT))
            .andExpect(jsonPath("$.montant").value(DEFAULT_MONTANT.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingGarantiesSoumissionnaire() throws Exception {
        // Get the garantiesSoumissionnaire
        restGarantiesSoumissionnaireMockMvc.perform(get("/api/garanties-soumissionnaires/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGarantiesSoumissionnaire() throws Exception {
        // Initialize the database
        garantiesSoumissionnaireRepository.saveAndFlush(garantiesSoumissionnaire);

        int databaseSizeBeforeUpdate = garantiesSoumissionnaireRepository.findAll().size();

        // Update the garantiesSoumissionnaire
        GarantiesSoumissionnaire updatedGarantiesSoumissionnaire = garantiesSoumissionnaireRepository.findById(garantiesSoumissionnaire.getId()).get();
        // Disconnect from session so that the updates on updatedGarantiesSoumissionnaire are not directly saved in db
        em.detach(updatedGarantiesSoumissionnaire);
        updatedGarantiesSoumissionnaire
            .fournie(UPDATED_FOURNIE)
            .libelle(UPDATED_LIBELLE)
            .observations(UPDATED_OBSERVATIONS)
            .libellelot(UPDATED_LIBELLELOT)
            .montant(UPDATED_MONTANT);
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO = garantiesSoumissionnaireMapper.toDto(updatedGarantiesSoumissionnaire);

        restGarantiesSoumissionnaireMockMvc.perform(put("/api/garanties-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesSoumissionnaireDTO)))
            .andExpect(status().isOk());

        // Validate the GarantiesSoumissionnaire in the database
        List<GarantiesSoumissionnaire> garantiesSoumissionnaireList = garantiesSoumissionnaireRepository.findAll();
        assertThat(garantiesSoumissionnaireList).hasSize(databaseSizeBeforeUpdate);
        GarantiesSoumissionnaire testGarantiesSoumissionnaire = garantiesSoumissionnaireList.get(garantiesSoumissionnaireList.size() - 1);
        assertThat(testGarantiesSoumissionnaire.getFournie()).isEqualTo(UPDATED_FOURNIE);
        assertThat(testGarantiesSoumissionnaire.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testGarantiesSoumissionnaire.getObservations()).isEqualTo(UPDATED_OBSERVATIONS);
        assertThat(testGarantiesSoumissionnaire.getLibellelot()).isEqualTo(UPDATED_LIBELLELOT);
        assertThat(testGarantiesSoumissionnaire.getMontant()).isEqualTo(UPDATED_MONTANT);
    }

    @Test
    @Transactional
    public void updateNonExistingGarantiesSoumissionnaire() throws Exception {
        int databaseSizeBeforeUpdate = garantiesSoumissionnaireRepository.findAll().size();

        // Create the GarantiesSoumissionnaire
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO = garantiesSoumissionnaireMapper.toDto(garantiesSoumissionnaire);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGarantiesSoumissionnaireMockMvc.perform(put("/api/garanties-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(garantiesSoumissionnaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the GarantiesSoumissionnaire in the database
        List<GarantiesSoumissionnaire> garantiesSoumissionnaireList = garantiesSoumissionnaireRepository.findAll();
        assertThat(garantiesSoumissionnaireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGarantiesSoumissionnaire() throws Exception {
        // Initialize the database
        garantiesSoumissionnaireRepository.saveAndFlush(garantiesSoumissionnaire);

        int databaseSizeBeforeDelete = garantiesSoumissionnaireRepository.findAll().size();

        // Delete the garantiesSoumissionnaire
        restGarantiesSoumissionnaireMockMvc.perform(delete("/api/garanties-soumissionnaires/{id}", garantiesSoumissionnaire.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<GarantiesSoumissionnaire> garantiesSoumissionnaireList = garantiesSoumissionnaireRepository.findAll();
        assertThat(garantiesSoumissionnaireList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
