package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.DossiersEvaluateur;
import sn.ssi.sigmap.repository.DossiersEvaluateurRepository;
import sn.ssi.sigmap.service.DossiersEvaluateurService;
import sn.ssi.sigmap.service.dto.DossiersEvaluateurDTO;
import sn.ssi.sigmap.service.mapper.DossiersEvaluateurMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DossiersEvaluateurResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DossiersEvaluateurResourceIT {

    private static final String DEFAULT_COMMISSION = "AAAAAAAAAA";
    private static final String UPDATED_COMMISSION = "BBBBBBBBBB";

    private static final String DEFAULT_NOM = "AAAAAAAAAA";
    private static final String UPDATED_NOM = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM = "BBBBBBBBBB";

    private static final Integer DEFAULT_TELEPHONE = 1;
    private static final Integer UPDATED_TELEPHONE = 2;

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_FONCTION = "AAAAAAAAAA";
    private static final String UPDATED_FONCTION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_REMISE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_REMISE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_LIMITE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_LIMITE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private DossiersEvaluateurRepository dossiersEvaluateurRepository;

    @Autowired
    private DossiersEvaluateurMapper dossiersEvaluateurMapper;

    @Autowired
    private DossiersEvaluateurService dossiersEvaluateurService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDossiersEvaluateurMockMvc;

    private DossiersEvaluateur dossiersEvaluateur;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersEvaluateur createEntity(EntityManager em) {
        DossiersEvaluateur dossiersEvaluateur = new DossiersEvaluateur()
            .commission(DEFAULT_COMMISSION)
            .nom(DEFAULT_NOM)
            .prenom(DEFAULT_PRENOM)
            .telephone(DEFAULT_TELEPHONE)
            .email(DEFAULT_EMAIL)
            .fonction(DEFAULT_FONCTION)
            .dateRemise(DEFAULT_DATE_REMISE)
            .dateLimite(DEFAULT_DATE_LIMITE);
        return dossiersEvaluateur;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersEvaluateur createUpdatedEntity(EntityManager em) {
        DossiersEvaluateur dossiersEvaluateur = new DossiersEvaluateur()
            .commission(UPDATED_COMMISSION)
            .nom(UPDATED_NOM)
            .prenom(UPDATED_PRENOM)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .fonction(UPDATED_FONCTION)
            .dateRemise(UPDATED_DATE_REMISE)
            .dateLimite(UPDATED_DATE_LIMITE);
        return dossiersEvaluateur;
    }

    @BeforeEach
    public void initTest() {
        dossiersEvaluateur = createEntity(em);
    }

    @Test
    @Transactional
    public void createDossiersEvaluateur() throws Exception {
        int databaseSizeBeforeCreate = dossiersEvaluateurRepository.findAll().size();
        // Create the DossiersEvaluateur
        DossiersEvaluateurDTO dossiersEvaluateurDTO = dossiersEvaluateurMapper.toDto(dossiersEvaluateur);
        restDossiersEvaluateurMockMvc.perform(post("/api/dossiers-evaluateurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersEvaluateurDTO)))
            .andExpect(status().isCreated());

        // Validate the DossiersEvaluateur in the database
        List<DossiersEvaluateur> dossiersEvaluateurList = dossiersEvaluateurRepository.findAll();
        assertThat(dossiersEvaluateurList).hasSize(databaseSizeBeforeCreate + 1);
        DossiersEvaluateur testDossiersEvaluateur = dossiersEvaluateurList.get(dossiersEvaluateurList.size() - 1);
        assertThat(testDossiersEvaluateur.getCommission()).isEqualTo(DEFAULT_COMMISSION);
        assertThat(testDossiersEvaluateur.getNom()).isEqualTo(DEFAULT_NOM);
        assertThat(testDossiersEvaluateur.getPrenom()).isEqualTo(DEFAULT_PRENOM);
        assertThat(testDossiersEvaluateur.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testDossiersEvaluateur.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testDossiersEvaluateur.getFonction()).isEqualTo(DEFAULT_FONCTION);
        assertThat(testDossiersEvaluateur.getDateRemise()).isEqualTo(DEFAULT_DATE_REMISE);
        assertThat(testDossiersEvaluateur.getDateLimite()).isEqualTo(DEFAULT_DATE_LIMITE);
    }

    @Test
    @Transactional
    public void createDossiersEvaluateurWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dossiersEvaluateurRepository.findAll().size();

        // Create the DossiersEvaluateur with an existing ID
        dossiersEvaluateur.setId(1L);
        DossiersEvaluateurDTO dossiersEvaluateurDTO = dossiersEvaluateurMapper.toDto(dossiersEvaluateur);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDossiersEvaluateurMockMvc.perform(post("/api/dossiers-evaluateurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersEvaluateurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersEvaluateur in the database
        List<DossiersEvaluateur> dossiersEvaluateurList = dossiersEvaluateurRepository.findAll();
        assertThat(dossiersEvaluateurList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDossiersEvaluateurs() throws Exception {
        // Initialize the database
        dossiersEvaluateurRepository.saveAndFlush(dossiersEvaluateur);

        // Get all the dossiersEvaluateurList
        restDossiersEvaluateurMockMvc.perform(get("/api/dossiers-evaluateurs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dossiersEvaluateur.getId().intValue())))
            .andExpect(jsonPath("$.[*].commission").value(hasItem(DEFAULT_COMMISSION)))
            .andExpect(jsonPath("$.[*].nom").value(hasItem(DEFAULT_NOM)))
            .andExpect(jsonPath("$.[*].prenom").value(hasItem(DEFAULT_PRENOM)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].fonction").value(hasItem(DEFAULT_FONCTION)))
            .andExpect(jsonPath("$.[*].dateRemise").value(hasItem(DEFAULT_DATE_REMISE.toString())))
            .andExpect(jsonPath("$.[*].dateLimite").value(hasItem(DEFAULT_DATE_LIMITE.toString())));
    }
    
    @Test
    @Transactional
    public void getDossiersEvaluateur() throws Exception {
        // Initialize the database
        dossiersEvaluateurRepository.saveAndFlush(dossiersEvaluateur);

        // Get the dossiersEvaluateur
        restDossiersEvaluateurMockMvc.perform(get("/api/dossiers-evaluateurs/{id}", dossiersEvaluateur.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dossiersEvaluateur.getId().intValue()))
            .andExpect(jsonPath("$.commission").value(DEFAULT_COMMISSION))
            .andExpect(jsonPath("$.nom").value(DEFAULT_NOM))
            .andExpect(jsonPath("$.prenom").value(DEFAULT_PRENOM))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.fonction").value(DEFAULT_FONCTION))
            .andExpect(jsonPath("$.dateRemise").value(DEFAULT_DATE_REMISE.toString()))
            .andExpect(jsonPath("$.dateLimite").value(DEFAULT_DATE_LIMITE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingDossiersEvaluateur() throws Exception {
        // Get the dossiersEvaluateur
        restDossiersEvaluateurMockMvc.perform(get("/api/dossiers-evaluateurs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDossiersEvaluateur() throws Exception {
        // Initialize the database
        dossiersEvaluateurRepository.saveAndFlush(dossiersEvaluateur);

        int databaseSizeBeforeUpdate = dossiersEvaluateurRepository.findAll().size();

        // Update the dossiersEvaluateur
        DossiersEvaluateur updatedDossiersEvaluateur = dossiersEvaluateurRepository.findById(dossiersEvaluateur.getId()).get();
        // Disconnect from session so that the updates on updatedDossiersEvaluateur are not directly saved in db
        em.detach(updatedDossiersEvaluateur);
        updatedDossiersEvaluateur
            .commission(UPDATED_COMMISSION)
            .nom(UPDATED_NOM)
            .prenom(UPDATED_PRENOM)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .fonction(UPDATED_FONCTION)
            .dateRemise(UPDATED_DATE_REMISE)
            .dateLimite(UPDATED_DATE_LIMITE);
        DossiersEvaluateurDTO dossiersEvaluateurDTO = dossiersEvaluateurMapper.toDto(updatedDossiersEvaluateur);

        restDossiersEvaluateurMockMvc.perform(put("/api/dossiers-evaluateurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersEvaluateurDTO)))
            .andExpect(status().isOk());

        // Validate the DossiersEvaluateur in the database
        List<DossiersEvaluateur> dossiersEvaluateurList = dossiersEvaluateurRepository.findAll();
        assertThat(dossiersEvaluateurList).hasSize(databaseSizeBeforeUpdate);
        DossiersEvaluateur testDossiersEvaluateur = dossiersEvaluateurList.get(dossiersEvaluateurList.size() - 1);
        assertThat(testDossiersEvaluateur.getCommission()).isEqualTo(UPDATED_COMMISSION);
        assertThat(testDossiersEvaluateur.getNom()).isEqualTo(UPDATED_NOM);
        assertThat(testDossiersEvaluateur.getPrenom()).isEqualTo(UPDATED_PRENOM);
        assertThat(testDossiersEvaluateur.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testDossiersEvaluateur.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testDossiersEvaluateur.getFonction()).isEqualTo(UPDATED_FONCTION);
        assertThat(testDossiersEvaluateur.getDateRemise()).isEqualTo(UPDATED_DATE_REMISE);
        assertThat(testDossiersEvaluateur.getDateLimite()).isEqualTo(UPDATED_DATE_LIMITE);
    }

    @Test
    @Transactional
    public void updateNonExistingDossiersEvaluateur() throws Exception {
        int databaseSizeBeforeUpdate = dossiersEvaluateurRepository.findAll().size();

        // Create the DossiersEvaluateur
        DossiersEvaluateurDTO dossiersEvaluateurDTO = dossiersEvaluateurMapper.toDto(dossiersEvaluateur);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDossiersEvaluateurMockMvc.perform(put("/api/dossiers-evaluateurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersEvaluateurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersEvaluateur in the database
        List<DossiersEvaluateur> dossiersEvaluateurList = dossiersEvaluateurRepository.findAll();
        assertThat(dossiersEvaluateurList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDossiersEvaluateur() throws Exception {
        // Initialize the database
        dossiersEvaluateurRepository.saveAndFlush(dossiersEvaluateur);

        int databaseSizeBeforeDelete = dossiersEvaluateurRepository.findAll().size();

        // Delete the dossiersEvaluateur
        restDossiersEvaluateurMockMvc.perform(delete("/api/dossiers-evaluateurs/{id}", dossiersEvaluateur.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DossiersEvaluateur> dossiersEvaluateurList = dossiersEvaluateurRepository.findAll();
        assertThat(dossiersEvaluateurList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
