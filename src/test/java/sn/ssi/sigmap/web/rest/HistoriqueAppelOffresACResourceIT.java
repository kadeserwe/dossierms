package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.HistoriqueAppelOffresAC;
import sn.ssi.sigmap.repository.HistoriqueAppelOffresACRepository;
import sn.ssi.sigmap.service.HistoriqueAppelOffresACService;
import sn.ssi.sigmap.service.dto.HistoriqueAppelOffresACDTO;
import sn.ssi.sigmap.service.mapper.HistoriqueAppelOffresACMapper;

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
 * Integration tests for the {@link HistoriqueAppelOffresACResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class HistoriqueAppelOffresACResourceIT {

    private static final String DEFAULT_HISTOAC_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_HISTOAC_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_HISTOAC_COMMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_HISTOAC_COMMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_HISTOAC_FICHIERVALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_HISTOAC_FICHIERVALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_HISTOAC_BORDERAU = "AAAAAAAAAA";
    private static final String UPDATED_HISTOAC_BORDERAU = "BBBBBBBBBB";

    private static final String DEFAULT_HISTO_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_HISTO_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_HISTO_COMMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_HISTO_COMMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_HISTO_FICHIERVALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_HISTO_FICHIERVALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_DAO_FICHIER = "AAAAAAAAAA";
    private static final String UPDATED_DAO_FICHIER = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGINE = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_HISTOAC_DATEVALIDATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HISTOAC_DATEVALIDATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HISTOAC_DATECREATIONDOSSIER = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HISTOAC_DATECREATIONDOSSIER = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HISTO_DATEVALIDATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HISTO_DATEVALIDATION = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_HISTOAC_ATTRIBUTION = 1;
    private static final Integer UPDATED_HISTOAC_ATTRIBUTION = 2;

    private static final Integer DEFAULT_HISTOAC_AC = 1;
    private static final Integer UPDATED_HISTOAC_AC = 2;

    private static final String DEFAULT_VALIDERPAR_NOM = "AAAAAAAAAA";
    private static final String UPDATED_VALIDERPAR_NOM = "BBBBBBBBBB";

    private static final String DEFAULT_VALIDERPAR_PRENOM = "AAAAAAAAAA";
    private static final String UPDATED_VALIDERPAR_PRENOM = "BBBBBBBBBB";

    private static final Long DEFAULT_USER_ID = 1L;
    private static final Long UPDATED_USER_ID = 2L;

    private static final Long DEFAULT_AUTIRITE_ID = 1L;
    private static final Long UPDATED_AUTIRITE_ID = 2L;

    @Autowired
    private HistoriqueAppelOffresACRepository historiqueAppelOffresACRepository;

    @Autowired
    private HistoriqueAppelOffresACMapper historiqueAppelOffresACMapper;

    @Autowired
    private HistoriqueAppelOffresACService historiqueAppelOffresACService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restHistoriqueAppelOffresACMockMvc;

    private HistoriqueAppelOffresAC historiqueAppelOffresAC;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static HistoriqueAppelOffresAC createEntity(EntityManager em) {
        HistoriqueAppelOffresAC historiqueAppelOffresAC = new HistoriqueAppelOffresAC()
            .histoacValidation(DEFAULT_HISTOAC_VALIDATION)
            .histoacCommentaire(DEFAULT_HISTOAC_COMMENTAIRE)
            .histoacFichiervalidation(DEFAULT_HISTOAC_FICHIERVALIDATION)
            .histoacBorderau(DEFAULT_HISTOAC_BORDERAU)
            .histoValidation(DEFAULT_HISTO_VALIDATION)
            .histoCommentaire(DEFAULT_HISTO_COMMENTAIRE)
            .histoFichiervalidation(DEFAULT_HISTO_FICHIERVALIDATION)
            .daoFichier(DEFAULT_DAO_FICHIER)
            .origine(DEFAULT_ORIGINE)
            .histoacDatevalidation(DEFAULT_HISTOAC_DATEVALIDATION)
            .histoacDatecreationdossier(DEFAULT_HISTOAC_DATECREATIONDOSSIER)
            .histoDatevalidation(DEFAULT_HISTO_DATEVALIDATION)
            .histoacAttribution(DEFAULT_HISTOAC_ATTRIBUTION)
            .histoacAc(DEFAULT_HISTOAC_AC)
            .validerparNom(DEFAULT_VALIDERPAR_NOM)
            .validerparPrenom(DEFAULT_VALIDERPAR_PRENOM)
            .userId(DEFAULT_USER_ID)
            .autiriteId(DEFAULT_AUTIRITE_ID);
        return historiqueAppelOffresAC;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static HistoriqueAppelOffresAC createUpdatedEntity(EntityManager em) {
        HistoriqueAppelOffresAC historiqueAppelOffresAC = new HistoriqueAppelOffresAC()
            .histoacValidation(UPDATED_HISTOAC_VALIDATION)
            .histoacCommentaire(UPDATED_HISTOAC_COMMENTAIRE)
            .histoacFichiervalidation(UPDATED_HISTOAC_FICHIERVALIDATION)
            .histoacBorderau(UPDATED_HISTOAC_BORDERAU)
            .histoValidation(UPDATED_HISTO_VALIDATION)
            .histoCommentaire(UPDATED_HISTO_COMMENTAIRE)
            .histoFichiervalidation(UPDATED_HISTO_FICHIERVALIDATION)
            .daoFichier(UPDATED_DAO_FICHIER)
            .origine(UPDATED_ORIGINE)
            .histoacDatevalidation(UPDATED_HISTOAC_DATEVALIDATION)
            .histoacDatecreationdossier(UPDATED_HISTOAC_DATECREATIONDOSSIER)
            .histoDatevalidation(UPDATED_HISTO_DATEVALIDATION)
            .histoacAttribution(UPDATED_HISTOAC_ATTRIBUTION)
            .histoacAc(UPDATED_HISTOAC_AC)
            .validerparNom(UPDATED_VALIDERPAR_NOM)
            .validerparPrenom(UPDATED_VALIDERPAR_PRENOM)
            .userId(UPDATED_USER_ID)
            .autiriteId(UPDATED_AUTIRITE_ID);
        return historiqueAppelOffresAC;
    }

    @BeforeEach
    public void initTest() {
        historiqueAppelOffresAC = createEntity(em);
    }

    @Test
    @Transactional
    public void createHistoriqueAppelOffresAC() throws Exception {
        int databaseSizeBeforeCreate = historiqueAppelOffresACRepository.findAll().size();
        // Create the HistoriqueAppelOffresAC
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO = historiqueAppelOffresACMapper.toDto(historiqueAppelOffresAC);
        restHistoriqueAppelOffresACMockMvc.perform(post("/api/historique-appel-offres-acs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(historiqueAppelOffresACDTO)))
            .andExpect(status().isCreated());

        // Validate the HistoriqueAppelOffresAC in the database
        List<HistoriqueAppelOffresAC> historiqueAppelOffresACList = historiqueAppelOffresACRepository.findAll();
        assertThat(historiqueAppelOffresACList).hasSize(databaseSizeBeforeCreate + 1);
        HistoriqueAppelOffresAC testHistoriqueAppelOffresAC = historiqueAppelOffresACList.get(historiqueAppelOffresACList.size() - 1);
        assertThat(testHistoriqueAppelOffresAC.getHistoacValidation()).isEqualTo(DEFAULT_HISTOAC_VALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacCommentaire()).isEqualTo(DEFAULT_HISTOAC_COMMENTAIRE);
        assertThat(testHistoriqueAppelOffresAC.getHistoacFichiervalidation()).isEqualTo(DEFAULT_HISTOAC_FICHIERVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacBorderau()).isEqualTo(DEFAULT_HISTOAC_BORDERAU);
        assertThat(testHistoriqueAppelOffresAC.getHistoValidation()).isEqualTo(DEFAULT_HISTO_VALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoCommentaire()).isEqualTo(DEFAULT_HISTO_COMMENTAIRE);
        assertThat(testHistoriqueAppelOffresAC.getHistoFichiervalidation()).isEqualTo(DEFAULT_HISTO_FICHIERVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getDaoFichier()).isEqualTo(DEFAULT_DAO_FICHIER);
        assertThat(testHistoriqueAppelOffresAC.getOrigine()).isEqualTo(DEFAULT_ORIGINE);
        assertThat(testHistoriqueAppelOffresAC.getHistoacDatevalidation()).isEqualTo(DEFAULT_HISTOAC_DATEVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacDatecreationdossier()).isEqualTo(DEFAULT_HISTOAC_DATECREATIONDOSSIER);
        assertThat(testHistoriqueAppelOffresAC.getHistoDatevalidation()).isEqualTo(DEFAULT_HISTO_DATEVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacAttribution()).isEqualTo(DEFAULT_HISTOAC_ATTRIBUTION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacAc()).isEqualTo(DEFAULT_HISTOAC_AC);
        assertThat(testHistoriqueAppelOffresAC.getValiderparNom()).isEqualTo(DEFAULT_VALIDERPAR_NOM);
        assertThat(testHistoriqueAppelOffresAC.getValiderparPrenom()).isEqualTo(DEFAULT_VALIDERPAR_PRENOM);
        assertThat(testHistoriqueAppelOffresAC.getUserId()).isEqualTo(DEFAULT_USER_ID);
        assertThat(testHistoriqueAppelOffresAC.getAutiriteId()).isEqualTo(DEFAULT_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void createHistoriqueAppelOffresACWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = historiqueAppelOffresACRepository.findAll().size();

        // Create the HistoriqueAppelOffresAC with an existing ID
        historiqueAppelOffresAC.setId(1L);
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO = historiqueAppelOffresACMapper.toDto(historiqueAppelOffresAC);

        // An entity with an existing ID cannot be created, so this API call must fail
        restHistoriqueAppelOffresACMockMvc.perform(post("/api/historique-appel-offres-acs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(historiqueAppelOffresACDTO)))
            .andExpect(status().isBadRequest());

        // Validate the HistoriqueAppelOffresAC in the database
        List<HistoriqueAppelOffresAC> historiqueAppelOffresACList = historiqueAppelOffresACRepository.findAll();
        assertThat(historiqueAppelOffresACList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllHistoriqueAppelOffresACS() throws Exception {
        // Initialize the database
        historiqueAppelOffresACRepository.saveAndFlush(historiqueAppelOffresAC);

        // Get all the historiqueAppelOffresACList
        restHistoriqueAppelOffresACMockMvc.perform(get("/api/historique-appel-offres-acs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(historiqueAppelOffresAC.getId().intValue())))
            .andExpect(jsonPath("$.[*].histoacValidation").value(hasItem(DEFAULT_HISTOAC_VALIDATION)))
            .andExpect(jsonPath("$.[*].histoacCommentaire").value(hasItem(DEFAULT_HISTOAC_COMMENTAIRE)))
            .andExpect(jsonPath("$.[*].histoacFichiervalidation").value(hasItem(DEFAULT_HISTOAC_FICHIERVALIDATION)))
            .andExpect(jsonPath("$.[*].histoacBorderau").value(hasItem(DEFAULT_HISTOAC_BORDERAU)))
            .andExpect(jsonPath("$.[*].histoValidation").value(hasItem(DEFAULT_HISTO_VALIDATION)))
            .andExpect(jsonPath("$.[*].histoCommentaire").value(hasItem(DEFAULT_HISTO_COMMENTAIRE)))
            .andExpect(jsonPath("$.[*].histoFichiervalidation").value(hasItem(DEFAULT_HISTO_FICHIERVALIDATION)))
            .andExpect(jsonPath("$.[*].daoFichier").value(hasItem(DEFAULT_DAO_FICHIER)))
            .andExpect(jsonPath("$.[*].origine").value(hasItem(DEFAULT_ORIGINE)))
            .andExpect(jsonPath("$.[*].histoacDatevalidation").value(hasItem(DEFAULT_HISTOAC_DATEVALIDATION.toString())))
            .andExpect(jsonPath("$.[*].histoacDatecreationdossier").value(hasItem(DEFAULT_HISTOAC_DATECREATIONDOSSIER.toString())))
            .andExpect(jsonPath("$.[*].histoDatevalidation").value(hasItem(DEFAULT_HISTO_DATEVALIDATION.toString())))
            .andExpect(jsonPath("$.[*].histoacAttribution").value(hasItem(DEFAULT_HISTOAC_ATTRIBUTION)))
            .andExpect(jsonPath("$.[*].histoacAc").value(hasItem(DEFAULT_HISTOAC_AC)))
            .andExpect(jsonPath("$.[*].validerparNom").value(hasItem(DEFAULT_VALIDERPAR_NOM)))
            .andExpect(jsonPath("$.[*].validerparPrenom").value(hasItem(DEFAULT_VALIDERPAR_PRENOM)))
            .andExpect(jsonPath("$.[*].userId").value(hasItem(DEFAULT_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].autiriteId").value(hasItem(DEFAULT_AUTIRITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getHistoriqueAppelOffresAC() throws Exception {
        // Initialize the database
        historiqueAppelOffresACRepository.saveAndFlush(historiqueAppelOffresAC);

        // Get the historiqueAppelOffresAC
        restHistoriqueAppelOffresACMockMvc.perform(get("/api/historique-appel-offres-acs/{id}", historiqueAppelOffresAC.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(historiqueAppelOffresAC.getId().intValue()))
            .andExpect(jsonPath("$.histoacValidation").value(DEFAULT_HISTOAC_VALIDATION))
            .andExpect(jsonPath("$.histoacCommentaire").value(DEFAULT_HISTOAC_COMMENTAIRE))
            .andExpect(jsonPath("$.histoacFichiervalidation").value(DEFAULT_HISTOAC_FICHIERVALIDATION))
            .andExpect(jsonPath("$.histoacBorderau").value(DEFAULT_HISTOAC_BORDERAU))
            .andExpect(jsonPath("$.histoValidation").value(DEFAULT_HISTO_VALIDATION))
            .andExpect(jsonPath("$.histoCommentaire").value(DEFAULT_HISTO_COMMENTAIRE))
            .andExpect(jsonPath("$.histoFichiervalidation").value(DEFAULT_HISTO_FICHIERVALIDATION))
            .andExpect(jsonPath("$.daoFichier").value(DEFAULT_DAO_FICHIER))
            .andExpect(jsonPath("$.origine").value(DEFAULT_ORIGINE))
            .andExpect(jsonPath("$.histoacDatevalidation").value(DEFAULT_HISTOAC_DATEVALIDATION.toString()))
            .andExpect(jsonPath("$.histoacDatecreationdossier").value(DEFAULT_HISTOAC_DATECREATIONDOSSIER.toString()))
            .andExpect(jsonPath("$.histoDatevalidation").value(DEFAULT_HISTO_DATEVALIDATION.toString()))
            .andExpect(jsonPath("$.histoacAttribution").value(DEFAULT_HISTOAC_ATTRIBUTION))
            .andExpect(jsonPath("$.histoacAc").value(DEFAULT_HISTOAC_AC))
            .andExpect(jsonPath("$.validerparNom").value(DEFAULT_VALIDERPAR_NOM))
            .andExpect(jsonPath("$.validerparPrenom").value(DEFAULT_VALIDERPAR_PRENOM))
            .andExpect(jsonPath("$.userId").value(DEFAULT_USER_ID.intValue()))
            .andExpect(jsonPath("$.autiriteId").value(DEFAULT_AUTIRITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingHistoriqueAppelOffresAC() throws Exception {
        // Get the historiqueAppelOffresAC
        restHistoriqueAppelOffresACMockMvc.perform(get("/api/historique-appel-offres-acs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateHistoriqueAppelOffresAC() throws Exception {
        // Initialize the database
        historiqueAppelOffresACRepository.saveAndFlush(historiqueAppelOffresAC);

        int databaseSizeBeforeUpdate = historiqueAppelOffresACRepository.findAll().size();

        // Update the historiqueAppelOffresAC
        HistoriqueAppelOffresAC updatedHistoriqueAppelOffresAC = historiqueAppelOffresACRepository.findById(historiqueAppelOffresAC.getId()).get();
        // Disconnect from session so that the updates on updatedHistoriqueAppelOffresAC are not directly saved in db
        em.detach(updatedHistoriqueAppelOffresAC);
        updatedHistoriqueAppelOffresAC
            .histoacValidation(UPDATED_HISTOAC_VALIDATION)
            .histoacCommentaire(UPDATED_HISTOAC_COMMENTAIRE)
            .histoacFichiervalidation(UPDATED_HISTOAC_FICHIERVALIDATION)
            .histoacBorderau(UPDATED_HISTOAC_BORDERAU)
            .histoValidation(UPDATED_HISTO_VALIDATION)
            .histoCommentaire(UPDATED_HISTO_COMMENTAIRE)
            .histoFichiervalidation(UPDATED_HISTO_FICHIERVALIDATION)
            .daoFichier(UPDATED_DAO_FICHIER)
            .origine(UPDATED_ORIGINE)
            .histoacDatevalidation(UPDATED_HISTOAC_DATEVALIDATION)
            .histoacDatecreationdossier(UPDATED_HISTOAC_DATECREATIONDOSSIER)
            .histoDatevalidation(UPDATED_HISTO_DATEVALIDATION)
            .histoacAttribution(UPDATED_HISTOAC_ATTRIBUTION)
            .histoacAc(UPDATED_HISTOAC_AC)
            .validerparNom(UPDATED_VALIDERPAR_NOM)
            .validerparPrenom(UPDATED_VALIDERPAR_PRENOM)
            .userId(UPDATED_USER_ID)
            .autiriteId(UPDATED_AUTIRITE_ID);
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO = historiqueAppelOffresACMapper.toDto(updatedHistoriqueAppelOffresAC);

        restHistoriqueAppelOffresACMockMvc.perform(put("/api/historique-appel-offres-acs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(historiqueAppelOffresACDTO)))
            .andExpect(status().isOk());

        // Validate the HistoriqueAppelOffresAC in the database
        List<HistoriqueAppelOffresAC> historiqueAppelOffresACList = historiqueAppelOffresACRepository.findAll();
        assertThat(historiqueAppelOffresACList).hasSize(databaseSizeBeforeUpdate);
        HistoriqueAppelOffresAC testHistoriqueAppelOffresAC = historiqueAppelOffresACList.get(historiqueAppelOffresACList.size() - 1);
        assertThat(testHistoriqueAppelOffresAC.getHistoacValidation()).isEqualTo(UPDATED_HISTOAC_VALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacCommentaire()).isEqualTo(UPDATED_HISTOAC_COMMENTAIRE);
        assertThat(testHistoriqueAppelOffresAC.getHistoacFichiervalidation()).isEqualTo(UPDATED_HISTOAC_FICHIERVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacBorderau()).isEqualTo(UPDATED_HISTOAC_BORDERAU);
        assertThat(testHistoriqueAppelOffresAC.getHistoValidation()).isEqualTo(UPDATED_HISTO_VALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoCommentaire()).isEqualTo(UPDATED_HISTO_COMMENTAIRE);
        assertThat(testHistoriqueAppelOffresAC.getHistoFichiervalidation()).isEqualTo(UPDATED_HISTO_FICHIERVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getDaoFichier()).isEqualTo(UPDATED_DAO_FICHIER);
        assertThat(testHistoriqueAppelOffresAC.getOrigine()).isEqualTo(UPDATED_ORIGINE);
        assertThat(testHistoriqueAppelOffresAC.getHistoacDatevalidation()).isEqualTo(UPDATED_HISTOAC_DATEVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacDatecreationdossier()).isEqualTo(UPDATED_HISTOAC_DATECREATIONDOSSIER);
        assertThat(testHistoriqueAppelOffresAC.getHistoDatevalidation()).isEqualTo(UPDATED_HISTO_DATEVALIDATION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacAttribution()).isEqualTo(UPDATED_HISTOAC_ATTRIBUTION);
        assertThat(testHistoriqueAppelOffresAC.getHistoacAc()).isEqualTo(UPDATED_HISTOAC_AC);
        assertThat(testHistoriqueAppelOffresAC.getValiderparNom()).isEqualTo(UPDATED_VALIDERPAR_NOM);
        assertThat(testHistoriqueAppelOffresAC.getValiderparPrenom()).isEqualTo(UPDATED_VALIDERPAR_PRENOM);
        assertThat(testHistoriqueAppelOffresAC.getUserId()).isEqualTo(UPDATED_USER_ID);
        assertThat(testHistoriqueAppelOffresAC.getAutiriteId()).isEqualTo(UPDATED_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingHistoriqueAppelOffresAC() throws Exception {
        int databaseSizeBeforeUpdate = historiqueAppelOffresACRepository.findAll().size();

        // Create the HistoriqueAppelOffresAC
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO = historiqueAppelOffresACMapper.toDto(historiqueAppelOffresAC);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restHistoriqueAppelOffresACMockMvc.perform(put("/api/historique-appel-offres-acs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(historiqueAppelOffresACDTO)))
            .andExpect(status().isBadRequest());

        // Validate the HistoriqueAppelOffresAC in the database
        List<HistoriqueAppelOffresAC> historiqueAppelOffresACList = historiqueAppelOffresACRepository.findAll();
        assertThat(historiqueAppelOffresACList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteHistoriqueAppelOffresAC() throws Exception {
        // Initialize the database
        historiqueAppelOffresACRepository.saveAndFlush(historiqueAppelOffresAC);

        int databaseSizeBeforeDelete = historiqueAppelOffresACRepository.findAll().size();

        // Delete the historiqueAppelOffresAC
        restHistoriqueAppelOffresACMockMvc.perform(delete("/api/historique-appel-offres-acs/{id}", historiqueAppelOffresAC.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<HistoriqueAppelOffresAC> historiqueAppelOffresACList = historiqueAppelOffresACRepository.findAll();
        assertThat(historiqueAppelOffresACList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
