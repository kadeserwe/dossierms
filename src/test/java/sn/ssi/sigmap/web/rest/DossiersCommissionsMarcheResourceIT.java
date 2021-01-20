package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.DossiersCommissionsMarche;
import sn.ssi.sigmap.repository.DossiersCommissionsMarcheRepository;
import sn.ssi.sigmap.service.DossiersCommissionsMarcheService;
import sn.ssi.sigmap.service.dto.DossiersCommissionsMarcheDTO;
import sn.ssi.sigmap.service.mapper.DossiersCommissionsMarcheMapper;

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
 * Integration tests for the {@link DossiersCommissionsMarcheResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DossiersCommissionsMarcheResourceIT {

    private static final Integer DEFAULT_FLAG_PRESENCE_EVALUATION = 1;
    private static final Integer UPDATED_FLAG_PRESENCE_EVALUATION = 2;

    private static final Integer DEFAULT_ETAPE_PI = 1;
    private static final Integer UPDATED_ETAPE_PI = 2;

    @Autowired
    private DossiersCommissionsMarcheRepository dossiersCommissionsMarcheRepository;

    @Autowired
    private DossiersCommissionsMarcheMapper dossiersCommissionsMarcheMapper;

    @Autowired
    private DossiersCommissionsMarcheService dossiersCommissionsMarcheService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDossiersCommissionsMarcheMockMvc;

    private DossiersCommissionsMarche dossiersCommissionsMarche;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersCommissionsMarche createEntity(EntityManager em) {
        DossiersCommissionsMarche dossiersCommissionsMarche = new DossiersCommissionsMarche()
            .flagPresenceEvaluation(DEFAULT_FLAG_PRESENCE_EVALUATION)
            .etapePI(DEFAULT_ETAPE_PI);
        return dossiersCommissionsMarche;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersCommissionsMarche createUpdatedEntity(EntityManager em) {
        DossiersCommissionsMarche dossiersCommissionsMarche = new DossiersCommissionsMarche()
            .flagPresenceEvaluation(UPDATED_FLAG_PRESENCE_EVALUATION)
            .etapePI(UPDATED_ETAPE_PI);
        return dossiersCommissionsMarche;
    }

    @BeforeEach
    public void initTest() {
        dossiersCommissionsMarche = createEntity(em);
    }

    @Test
    @Transactional
    public void createDossiersCommissionsMarche() throws Exception {
        int databaseSizeBeforeCreate = dossiersCommissionsMarcheRepository.findAll().size();
        // Create the DossiersCommissionsMarche
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO = dossiersCommissionsMarcheMapper.toDto(dossiersCommissionsMarche);
        restDossiersCommissionsMarcheMockMvc.perform(post("/api/dossiers-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersCommissionsMarcheDTO)))
            .andExpect(status().isCreated());

        // Validate the DossiersCommissionsMarche in the database
        List<DossiersCommissionsMarche> dossiersCommissionsMarcheList = dossiersCommissionsMarcheRepository.findAll();
        assertThat(dossiersCommissionsMarcheList).hasSize(databaseSizeBeforeCreate + 1);
        DossiersCommissionsMarche testDossiersCommissionsMarche = dossiersCommissionsMarcheList.get(dossiersCommissionsMarcheList.size() - 1);
        assertThat(testDossiersCommissionsMarche.getFlagPresenceEvaluation()).isEqualTo(DEFAULT_FLAG_PRESENCE_EVALUATION);
        assertThat(testDossiersCommissionsMarche.getEtapePI()).isEqualTo(DEFAULT_ETAPE_PI);
    }

    @Test
    @Transactional
    public void createDossiersCommissionsMarcheWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dossiersCommissionsMarcheRepository.findAll().size();

        // Create the DossiersCommissionsMarche with an existing ID
        dossiersCommissionsMarche.setId(1L);
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO = dossiersCommissionsMarcheMapper.toDto(dossiersCommissionsMarche);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDossiersCommissionsMarcheMockMvc.perform(post("/api/dossiers-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersCommissionsMarcheDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersCommissionsMarche in the database
        List<DossiersCommissionsMarche> dossiersCommissionsMarcheList = dossiersCommissionsMarcheRepository.findAll();
        assertThat(dossiersCommissionsMarcheList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDossiersCommissionsMarches() throws Exception {
        // Initialize the database
        dossiersCommissionsMarcheRepository.saveAndFlush(dossiersCommissionsMarche);

        // Get all the dossiersCommissionsMarcheList
        restDossiersCommissionsMarcheMockMvc.perform(get("/api/dossiers-commissions-marches?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dossiersCommissionsMarche.getId().intValue())))
            .andExpect(jsonPath("$.[*].flagPresenceEvaluation").value(hasItem(DEFAULT_FLAG_PRESENCE_EVALUATION)))
            .andExpect(jsonPath("$.[*].etapePI").value(hasItem(DEFAULT_ETAPE_PI)));
    }
    
    @Test
    @Transactional
    public void getDossiersCommissionsMarche() throws Exception {
        // Initialize the database
        dossiersCommissionsMarcheRepository.saveAndFlush(dossiersCommissionsMarche);

        // Get the dossiersCommissionsMarche
        restDossiersCommissionsMarcheMockMvc.perform(get("/api/dossiers-commissions-marches/{id}", dossiersCommissionsMarche.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dossiersCommissionsMarche.getId().intValue()))
            .andExpect(jsonPath("$.flagPresenceEvaluation").value(DEFAULT_FLAG_PRESENCE_EVALUATION))
            .andExpect(jsonPath("$.etapePI").value(DEFAULT_ETAPE_PI));
    }
    @Test
    @Transactional
    public void getNonExistingDossiersCommissionsMarche() throws Exception {
        // Get the dossiersCommissionsMarche
        restDossiersCommissionsMarcheMockMvc.perform(get("/api/dossiers-commissions-marches/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDossiersCommissionsMarche() throws Exception {
        // Initialize the database
        dossiersCommissionsMarcheRepository.saveAndFlush(dossiersCommissionsMarche);

        int databaseSizeBeforeUpdate = dossiersCommissionsMarcheRepository.findAll().size();

        // Update the dossiersCommissionsMarche
        DossiersCommissionsMarche updatedDossiersCommissionsMarche = dossiersCommissionsMarcheRepository.findById(dossiersCommissionsMarche.getId()).get();
        // Disconnect from session so that the updates on updatedDossiersCommissionsMarche are not directly saved in db
        em.detach(updatedDossiersCommissionsMarche);
        updatedDossiersCommissionsMarche
            .flagPresenceEvaluation(UPDATED_FLAG_PRESENCE_EVALUATION)
            .etapePI(UPDATED_ETAPE_PI);
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO = dossiersCommissionsMarcheMapper.toDto(updatedDossiersCommissionsMarche);

        restDossiersCommissionsMarcheMockMvc.perform(put("/api/dossiers-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersCommissionsMarcheDTO)))
            .andExpect(status().isOk());

        // Validate the DossiersCommissionsMarche in the database
        List<DossiersCommissionsMarche> dossiersCommissionsMarcheList = dossiersCommissionsMarcheRepository.findAll();
        assertThat(dossiersCommissionsMarcheList).hasSize(databaseSizeBeforeUpdate);
        DossiersCommissionsMarche testDossiersCommissionsMarche = dossiersCommissionsMarcheList.get(dossiersCommissionsMarcheList.size() - 1);
        assertThat(testDossiersCommissionsMarche.getFlagPresenceEvaluation()).isEqualTo(UPDATED_FLAG_PRESENCE_EVALUATION);
        assertThat(testDossiersCommissionsMarche.getEtapePI()).isEqualTo(UPDATED_ETAPE_PI);
    }

    @Test
    @Transactional
    public void updateNonExistingDossiersCommissionsMarche() throws Exception {
        int databaseSizeBeforeUpdate = dossiersCommissionsMarcheRepository.findAll().size();

        // Create the DossiersCommissionsMarche
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO = dossiersCommissionsMarcheMapper.toDto(dossiersCommissionsMarche);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDossiersCommissionsMarcheMockMvc.perform(put("/api/dossiers-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersCommissionsMarcheDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersCommissionsMarche in the database
        List<DossiersCommissionsMarche> dossiersCommissionsMarcheList = dossiersCommissionsMarcheRepository.findAll();
        assertThat(dossiersCommissionsMarcheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDossiersCommissionsMarche() throws Exception {
        // Initialize the database
        dossiersCommissionsMarcheRepository.saveAndFlush(dossiersCommissionsMarche);

        int databaseSizeBeforeDelete = dossiersCommissionsMarcheRepository.findAll().size();

        // Delete the dossiersCommissionsMarche
        restDossiersCommissionsMarcheMockMvc.perform(delete("/api/dossiers-commissions-marches/{id}", dossiersCommissionsMarche.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DossiersCommissionsMarche> dossiersCommissionsMarcheList = dossiersCommissionsMarcheRepository.findAll();
        assertThat(dossiersCommissionsMarcheList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
