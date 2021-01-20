package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.AppelOffre;
import sn.ssi.sigmap.repository.AppelOffreRepository;
import sn.ssi.sigmap.service.AppelOffreService;
import sn.ssi.sigmap.service.dto.AppelOffreDTO;
import sn.ssi.sigmap.service.mapper.AppelOffreMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AppelOffreResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppelOffreResourceIT {

    private static final LocalDate DEFAULT_APO_DATECREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATECREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_AUTORISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_AUTORISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_DEMANDE_AUTORISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_DEMANDE_AUTORISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_REJET = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_REJET = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_MISE_AUTORISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_MISE_AUTORISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_STOP_PROCEDURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_STOP_PROCEDURE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_AFFECTATION_DOSSIER = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_AFFECTATION_DOSSIER = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_PV_OUVERTUREPLI = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_PV_OUVERTUREPLI = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_APO_DATE_VERSEMENT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_APO_DATE_VERSEMENT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_PUB_LISTE_RESTREINTE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PUB_LISTE_RESTREINTE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_APO_PROJET = "AAAAAAAAAA";
    private static final String UPDATED_APO_PROJET = "BBBBBBBBBB";

    private static final String DEFAULT_APO_OBJET = "AAAAAAAAAA";
    private static final String UPDATED_APO_OBJET = "BBBBBBBBBB";

    private static final String DEFAULT_APO_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_APO_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_APO_NUMERO_PRET_CREDIT = "AAAAAAAAAA";
    private static final String UPDATED_APO_NUMERO_PRET_CREDIT = "BBBBBBBBBB";

    private static final String DEFAULT_APO_COMMENTAIRE_AUTORISATION = "AAAAAAAAAA";
    private static final String UPDATED_APO_COMMENTAIRE_AUTORISATION = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_MISE_AUTORISATION = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_MISE_AUTORISATION = "BBBBBBBBBB";

    private static final String DEFAULT_NUMERO_MARCHE = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO_MARCHE = "BBBBBBBBBB";

    private static final String DEFAULT_MOTIF_STOP_PROCEDURE = "AAAAAAAAAA";
    private static final String UPDATED_MOTIF_STOP_PROCEDURE = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_PV = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_PV = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_APO_AUTORISATION_PREALABLE = "AAAAAAAAAA";
    private static final String UPDATED_APO_AUTORISATION_PREALABLE = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_AUTORISATION_PREALABLE = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_AUTORISATION_PREALABLE = "BBBBBBBBBB";

    private static final String DEFAULT_APO_REFERENCE_REQUETE_AC = "AAAAAAAAAA";
    private static final String UPDATED_APO_REFERENCE_REQUETE_AC = "BBBBBBBBBB";

    private static final String DEFAULT_APO_RAPPORT_SPECIAL = "AAAAAAAAAA";
    private static final String UPDATED_APO_RAPPORT_SPECIAL = "BBBBBBBBBB";

    private static final String DEFAULT_APO_REFERENCE_COMMUNICATION = "AAAAAAAAAA";
    private static final String UPDATED_APO_REFERENCE_COMMUNICATION = "BBBBBBBBBB";

    private static final String DEFAULT_APO_RELEVE_CONSEIL = "AAAAAAAAAA";
    private static final String UPDATED_APO_RELEVE_CONSEIL = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_RAPPORT_SPECIAL = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_RAPPORT_SPECIAL = "BBBBBBBBBB";

    private static final String DEFAULT_APO_FICHIER_RELEVE_CONSEIL = "AAAAAAAAAA";
    private static final String UPDATED_APO_FICHIER_RELEVE_CONSEIL = "BBBBBBBBBB";

    private static final String DEFAULT_PUB_LISTE_RESTREINTE = "AAAAAAAAAA";
    private static final String UPDATED_PUB_LISTE_RESTREINTE = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_LISTE_RESTREINTE = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_LISTE_RESTREINTE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_APO_MONTANT_ESTIME = new BigDecimal(1);
    private static final BigDecimal UPDATED_APO_MONTANT_ESTIME = new BigDecimal(2);

    private static final BigDecimal DEFAULT_APO_MONTANT_VERSEMENT = new BigDecimal(1);
    private static final BigDecimal UPDATED_APO_MONTANT_VERSEMENT = new BigDecimal(2);

    private static final Integer DEFAULT_APO_RESPONSABLE_DCMP = 1;
    private static final Integer UPDATED_APO_RESPONSABLE_DCMP = 2;

    private static final Integer DEFAULT_ETAT_SEUIL = 1;
    private static final Integer UPDATED_ETAT_SEUIL = 2;

    private static final String DEFAULT_APO_STATUT = "AAAAAAAAAA";
    private static final String UPDATED_APO_STATUT = "BBBBBBBBBB";

    private static final String DEFAULT_APO_VALIDE = "AAAAAAAAAA";
    private static final String UPDATED_APO_VALIDE = "BBBBBBBBBB";

    private static final Integer DEFAULT_APO_NBRE_DAO = 1;
    private static final Integer UPDATED_APO_NBRE_DAO = 2;

    private static final Integer DEFAULT_APO_NBRE_DC = 1;
    private static final Integer UPDATED_APO_NBRE_DC = 2;

    private static final Integer DEFAULT_APO_ETAT_VALIDATION = 1;
    private static final Integer UPDATED_APO_ETAT_VALIDATION = 2;

    private static final Long DEFAULT_AUTIRITE_ID = 1L;
    private static final Long UPDATED_AUTIRITE_ID = 2L;

    private static final Long DEFAULT_REALISATION_ID = 1L;
    private static final Long UPDATED_REALISATION_ID = 2L;

    private static final Long DEFAULT_MODEPASSATION_ID = 1L;
    private static final Long UPDATED_MODEPASSATION_ID = 2L;

    private static final Long DEFAULT_TYPEMARCHE_ID = 1L;
    private static final Long UPDATED_TYPEMARCHE_ID = 2L;

    private static final Long DEFAULT_MODESELECTION_ID = 1L;
    private static final Long UPDATED_MODESELECTION_ID = 2L;

    @Autowired
    private AppelOffreRepository appelOffreRepository;

    @Autowired
    private AppelOffreMapper appelOffreMapper;

    @Autowired
    private AppelOffreService appelOffreService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppelOffreMockMvc;

    private AppelOffre appelOffre;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppelOffre createEntity(EntityManager em) {
        AppelOffre appelOffre = new AppelOffre()
            .apoDatecreation(DEFAULT_APO_DATECREATION)
            .apoDateAutorisation(DEFAULT_APO_DATE_AUTORISATION)
            .apoDateDemandeAutorisation(DEFAULT_APO_DATE_DEMANDE_AUTORISATION)
            .apoDateRejet(DEFAULT_APO_DATE_REJET)
            .apoDateMiseAutorisation(DEFAULT_APO_DATE_MISE_AUTORISATION)
            .dateStopProcedure(DEFAULT_DATE_STOP_PROCEDURE)
            .dateAffectationDossier(DEFAULT_DATE_AFFECTATION_DOSSIER)
            .apoDatePVOuverturepli(DEFAULT_APO_DATE_PV_OUVERTUREPLI)
            .apoDateVersement(DEFAULT_APO_DATE_VERSEMENT)
            .datePubListeRestreinte(DEFAULT_DATE_PUB_LISTE_RESTREINTE)
            .apoProjet(DEFAULT_APO_PROJET)
            .apoObjet(DEFAULT_APO_OBJET)
            .apoReference(DEFAULT_APO_REFERENCE)
            .apoNumeroPretCredit(DEFAULT_APO_NUMERO_PRET_CREDIT)
            .apoCommentaireAutorisation(DEFAULT_APO_COMMENTAIRE_AUTORISATION)
            .apoFichierMiseAutorisation(DEFAULT_APO_FICHIER_MISE_AUTORISATION)
            .numeroMarche(DEFAULT_NUMERO_MARCHE)
            .motifStopProcedure(DEFAULT_MOTIF_STOP_PROCEDURE)
            .apoFichierPV(DEFAULT_APO_FICHIER_PV)
            .apoFichierValidation(DEFAULT_APO_FICHIER_VALIDATION)
            .apoAutorisationPrealable(DEFAULT_APO_AUTORISATION_PREALABLE)
            .apoFichierAutorisationPrealable(DEFAULT_APO_FICHIER_AUTORISATION_PREALABLE)
            .apoReferenceRequeteAc(DEFAULT_APO_REFERENCE_REQUETE_AC)
            .apoRapportSpecial(DEFAULT_APO_RAPPORT_SPECIAL)
            .apoReferenceCommunication(DEFAULT_APO_REFERENCE_COMMUNICATION)
            .apoReleveConseil(DEFAULT_APO_RELEVE_CONSEIL)
            .apoFichierRapportSpecial(DEFAULT_APO_FICHIER_RAPPORT_SPECIAL)
            .apoFichierReleveConseil(DEFAULT_APO_FICHIER_RELEVE_CONSEIL)
            .pubListeRestreinte(DEFAULT_PUB_LISTE_RESTREINTE)
            .fichierListeRestreinte(DEFAULT_FICHIER_LISTE_RESTREINTE)
            .apoMontantEstime(DEFAULT_APO_MONTANT_ESTIME)
            .apoMontantVersement(DEFAULT_APO_MONTANT_VERSEMENT)
            .apoResponsableDCMP(DEFAULT_APO_RESPONSABLE_DCMP)
            .etatSeuil(DEFAULT_ETAT_SEUIL)
            .apoStatut(DEFAULT_APO_STATUT)
            .apoValide(DEFAULT_APO_VALIDE)
            .apoNbreDAO(DEFAULT_APO_NBRE_DAO)
            .apoNbreDC(DEFAULT_APO_NBRE_DC)
            .apoEtatValidation(DEFAULT_APO_ETAT_VALIDATION)
            .autiriteId(DEFAULT_AUTIRITE_ID)
            .realisationId(DEFAULT_REALISATION_ID)
            .modepassationId(DEFAULT_MODEPASSATION_ID)
            .typemarcheId(DEFAULT_TYPEMARCHE_ID)
            .modeselectionId(DEFAULT_MODESELECTION_ID);
        return appelOffre;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppelOffre createUpdatedEntity(EntityManager em) {
        AppelOffre appelOffre = new AppelOffre()
            .apoDatecreation(UPDATED_APO_DATECREATION)
            .apoDateAutorisation(UPDATED_APO_DATE_AUTORISATION)
            .apoDateDemandeAutorisation(UPDATED_APO_DATE_DEMANDE_AUTORISATION)
            .apoDateRejet(UPDATED_APO_DATE_REJET)
            .apoDateMiseAutorisation(UPDATED_APO_DATE_MISE_AUTORISATION)
            .dateStopProcedure(UPDATED_DATE_STOP_PROCEDURE)
            .dateAffectationDossier(UPDATED_DATE_AFFECTATION_DOSSIER)
            .apoDatePVOuverturepli(UPDATED_APO_DATE_PV_OUVERTUREPLI)
            .apoDateVersement(UPDATED_APO_DATE_VERSEMENT)
            .datePubListeRestreinte(UPDATED_DATE_PUB_LISTE_RESTREINTE)
            .apoProjet(UPDATED_APO_PROJET)
            .apoObjet(UPDATED_APO_OBJET)
            .apoReference(UPDATED_APO_REFERENCE)
            .apoNumeroPretCredit(UPDATED_APO_NUMERO_PRET_CREDIT)
            .apoCommentaireAutorisation(UPDATED_APO_COMMENTAIRE_AUTORISATION)
            .apoFichierMiseAutorisation(UPDATED_APO_FICHIER_MISE_AUTORISATION)
            .numeroMarche(UPDATED_NUMERO_MARCHE)
            .motifStopProcedure(UPDATED_MOTIF_STOP_PROCEDURE)
            .apoFichierPV(UPDATED_APO_FICHIER_PV)
            .apoFichierValidation(UPDATED_APO_FICHIER_VALIDATION)
            .apoAutorisationPrealable(UPDATED_APO_AUTORISATION_PREALABLE)
            .apoFichierAutorisationPrealable(UPDATED_APO_FICHIER_AUTORISATION_PREALABLE)
            .apoReferenceRequeteAc(UPDATED_APO_REFERENCE_REQUETE_AC)
            .apoRapportSpecial(UPDATED_APO_RAPPORT_SPECIAL)
            .apoReferenceCommunication(UPDATED_APO_REFERENCE_COMMUNICATION)
            .apoReleveConseil(UPDATED_APO_RELEVE_CONSEIL)
            .apoFichierRapportSpecial(UPDATED_APO_FICHIER_RAPPORT_SPECIAL)
            .apoFichierReleveConseil(UPDATED_APO_FICHIER_RELEVE_CONSEIL)
            .pubListeRestreinte(UPDATED_PUB_LISTE_RESTREINTE)
            .fichierListeRestreinte(UPDATED_FICHIER_LISTE_RESTREINTE)
            .apoMontantEstime(UPDATED_APO_MONTANT_ESTIME)
            .apoMontantVersement(UPDATED_APO_MONTANT_VERSEMENT)
            .apoResponsableDCMP(UPDATED_APO_RESPONSABLE_DCMP)
            .etatSeuil(UPDATED_ETAT_SEUIL)
            .apoStatut(UPDATED_APO_STATUT)
            .apoValide(UPDATED_APO_VALIDE)
            .apoNbreDAO(UPDATED_APO_NBRE_DAO)
            .apoNbreDC(UPDATED_APO_NBRE_DC)
            .apoEtatValidation(UPDATED_APO_ETAT_VALIDATION)
            .autiriteId(UPDATED_AUTIRITE_ID)
            .realisationId(UPDATED_REALISATION_ID)
            .modepassationId(UPDATED_MODEPASSATION_ID)
            .typemarcheId(UPDATED_TYPEMARCHE_ID)
            .modeselectionId(UPDATED_MODESELECTION_ID);
        return appelOffre;
    }

    @BeforeEach
    public void initTest() {
        appelOffre = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppelOffre() throws Exception {
        int databaseSizeBeforeCreate = appelOffreRepository.findAll().size();
        // Create the AppelOffre
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);
        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isCreated());

        // Validate the AppelOffre in the database
        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeCreate + 1);
        AppelOffre testAppelOffre = appelOffreList.get(appelOffreList.size() - 1);
        assertThat(testAppelOffre.getApoDatecreation()).isEqualTo(DEFAULT_APO_DATECREATION);
        assertThat(testAppelOffre.getApoDateAutorisation()).isEqualTo(DEFAULT_APO_DATE_AUTORISATION);
        assertThat(testAppelOffre.getApoDateDemandeAutorisation()).isEqualTo(DEFAULT_APO_DATE_DEMANDE_AUTORISATION);
        assertThat(testAppelOffre.getApoDateRejet()).isEqualTo(DEFAULT_APO_DATE_REJET);
        assertThat(testAppelOffre.getApoDateMiseAutorisation()).isEqualTo(DEFAULT_APO_DATE_MISE_AUTORISATION);
        assertThat(testAppelOffre.getDateStopProcedure()).isEqualTo(DEFAULT_DATE_STOP_PROCEDURE);
        assertThat(testAppelOffre.getDateAffectationDossier()).isEqualTo(DEFAULT_DATE_AFFECTATION_DOSSIER);
        assertThat(testAppelOffre.getApoDatePVOuverturepli()).isEqualTo(DEFAULT_APO_DATE_PV_OUVERTUREPLI);
        assertThat(testAppelOffre.getApoDateVersement()).isEqualTo(DEFAULT_APO_DATE_VERSEMENT);
        assertThat(testAppelOffre.getDatePubListeRestreinte()).isEqualTo(DEFAULT_DATE_PUB_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getApoProjet()).isEqualTo(DEFAULT_APO_PROJET);
        assertThat(testAppelOffre.getApoObjet()).isEqualTo(DEFAULT_APO_OBJET);
        assertThat(testAppelOffre.getApoReference()).isEqualTo(DEFAULT_APO_REFERENCE);
        assertThat(testAppelOffre.getApoNumeroPretCredit()).isEqualTo(DEFAULT_APO_NUMERO_PRET_CREDIT);
        assertThat(testAppelOffre.getApoCommentaireAutorisation()).isEqualTo(DEFAULT_APO_COMMENTAIRE_AUTORISATION);
        assertThat(testAppelOffre.getApoFichierMiseAutorisation()).isEqualTo(DEFAULT_APO_FICHIER_MISE_AUTORISATION);
        assertThat(testAppelOffre.getNumeroMarche()).isEqualTo(DEFAULT_NUMERO_MARCHE);
        assertThat(testAppelOffre.getMotifStopProcedure()).isEqualTo(DEFAULT_MOTIF_STOP_PROCEDURE);
        assertThat(testAppelOffre.getApoFichierPV()).isEqualTo(DEFAULT_APO_FICHIER_PV);
        assertThat(testAppelOffre.getApoFichierValidation()).isEqualTo(DEFAULT_APO_FICHIER_VALIDATION);
        assertThat(testAppelOffre.getApoAutorisationPrealable()).isEqualTo(DEFAULT_APO_AUTORISATION_PREALABLE);
        assertThat(testAppelOffre.getApoFichierAutorisationPrealable()).isEqualTo(DEFAULT_APO_FICHIER_AUTORISATION_PREALABLE);
        assertThat(testAppelOffre.getApoReferenceRequeteAc()).isEqualTo(DEFAULT_APO_REFERENCE_REQUETE_AC);
        assertThat(testAppelOffre.getApoRapportSpecial()).isEqualTo(DEFAULT_APO_RAPPORT_SPECIAL);
        assertThat(testAppelOffre.getApoReferenceCommunication()).isEqualTo(DEFAULT_APO_REFERENCE_COMMUNICATION);
        assertThat(testAppelOffre.getApoReleveConseil()).isEqualTo(DEFAULT_APO_RELEVE_CONSEIL);
        assertThat(testAppelOffre.getApoFichierRapportSpecial()).isEqualTo(DEFAULT_APO_FICHIER_RAPPORT_SPECIAL);
        assertThat(testAppelOffre.getApoFichierReleveConseil()).isEqualTo(DEFAULT_APO_FICHIER_RELEVE_CONSEIL);
        assertThat(testAppelOffre.getPubListeRestreinte()).isEqualTo(DEFAULT_PUB_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getFichierListeRestreinte()).isEqualTo(DEFAULT_FICHIER_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getApoMontantEstime()).isEqualTo(DEFAULT_APO_MONTANT_ESTIME);
        assertThat(testAppelOffre.getApoMontantVersement()).isEqualTo(DEFAULT_APO_MONTANT_VERSEMENT);
        assertThat(testAppelOffre.getApoResponsableDCMP()).isEqualTo(DEFAULT_APO_RESPONSABLE_DCMP);
        assertThat(testAppelOffre.getEtatSeuil()).isEqualTo(DEFAULT_ETAT_SEUIL);
        assertThat(testAppelOffre.getApoStatut()).isEqualTo(DEFAULT_APO_STATUT);
        assertThat(testAppelOffre.getApoValide()).isEqualTo(DEFAULT_APO_VALIDE);
        assertThat(testAppelOffre.getApoNbreDAO()).isEqualTo(DEFAULT_APO_NBRE_DAO);
        assertThat(testAppelOffre.getApoNbreDC()).isEqualTo(DEFAULT_APO_NBRE_DC);
        assertThat(testAppelOffre.getApoEtatValidation()).isEqualTo(DEFAULT_APO_ETAT_VALIDATION);
        assertThat(testAppelOffre.getAutiriteId()).isEqualTo(DEFAULT_AUTIRITE_ID);
        assertThat(testAppelOffre.getRealisationId()).isEqualTo(DEFAULT_REALISATION_ID);
        assertThat(testAppelOffre.getModepassationId()).isEqualTo(DEFAULT_MODEPASSATION_ID);
        assertThat(testAppelOffre.getTypemarcheId()).isEqualTo(DEFAULT_TYPEMARCHE_ID);
        assertThat(testAppelOffre.getModeselectionId()).isEqualTo(DEFAULT_MODESELECTION_ID);
    }

    @Test
    @Transactional
    public void createAppelOffreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appelOffreRepository.findAll().size();

        // Create the AppelOffre with an existing ID
        appelOffre.setId(1L);
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppelOffre in the database
        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkApoDatecreationIsRequired() throws Exception {
        int databaseSizeBeforeTest = appelOffreRepository.findAll().size();
        // set the field null
        appelOffre.setApoDatecreation(null);

        // Create the AppelOffre, which fails.
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);


        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkApoReferenceIsRequired() throws Exception {
        int databaseSizeBeforeTest = appelOffreRepository.findAll().size();
        // set the field null
        appelOffre.setApoReference(null);

        // Create the AppelOffre, which fails.
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);


        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAutiriteIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appelOffreRepository.findAll().size();
        // set the field null
        appelOffre.setAutiriteId(null);

        // Create the AppelOffre, which fails.
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);


        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRealisationIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appelOffreRepository.findAll().size();
        // set the field null
        appelOffre.setRealisationId(null);

        // Create the AppelOffre, which fails.
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);


        restAppelOffreMockMvc.perform(post("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAppelOffres() throws Exception {
        // Initialize the database
        appelOffreRepository.saveAndFlush(appelOffre);

        // Get all the appelOffreList
        restAppelOffreMockMvc.perform(get("/api/appel-offres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appelOffre.getId().intValue())))
            .andExpect(jsonPath("$.[*].apoDatecreation").value(hasItem(DEFAULT_APO_DATECREATION.toString())))
            .andExpect(jsonPath("$.[*].apoDateAutorisation").value(hasItem(DEFAULT_APO_DATE_AUTORISATION.toString())))
            .andExpect(jsonPath("$.[*].apoDateDemandeAutorisation").value(hasItem(DEFAULT_APO_DATE_DEMANDE_AUTORISATION.toString())))
            .andExpect(jsonPath("$.[*].apoDateRejet").value(hasItem(DEFAULT_APO_DATE_REJET.toString())))
            .andExpect(jsonPath("$.[*].apoDateMiseAutorisation").value(hasItem(DEFAULT_APO_DATE_MISE_AUTORISATION.toString())))
            .andExpect(jsonPath("$.[*].dateStopProcedure").value(hasItem(DEFAULT_DATE_STOP_PROCEDURE.toString())))
            .andExpect(jsonPath("$.[*].dateAffectationDossier").value(hasItem(DEFAULT_DATE_AFFECTATION_DOSSIER.toString())))
            .andExpect(jsonPath("$.[*].apoDatePVOuverturepli").value(hasItem(DEFAULT_APO_DATE_PV_OUVERTUREPLI.toString())))
            .andExpect(jsonPath("$.[*].apoDateVersement").value(hasItem(DEFAULT_APO_DATE_VERSEMENT.toString())))
            .andExpect(jsonPath("$.[*].datePubListeRestreinte").value(hasItem(DEFAULT_DATE_PUB_LISTE_RESTREINTE.toString())))
            .andExpect(jsonPath("$.[*].apoProjet").value(hasItem(DEFAULT_APO_PROJET)))
            .andExpect(jsonPath("$.[*].apoObjet").value(hasItem(DEFAULT_APO_OBJET)))
            .andExpect(jsonPath("$.[*].apoReference").value(hasItem(DEFAULT_APO_REFERENCE)))
            .andExpect(jsonPath("$.[*].apoNumeroPretCredit").value(hasItem(DEFAULT_APO_NUMERO_PRET_CREDIT)))
            .andExpect(jsonPath("$.[*].apoCommentaireAutorisation").value(hasItem(DEFAULT_APO_COMMENTAIRE_AUTORISATION)))
            .andExpect(jsonPath("$.[*].apoFichierMiseAutorisation").value(hasItem(DEFAULT_APO_FICHIER_MISE_AUTORISATION)))
            .andExpect(jsonPath("$.[*].numeroMarche").value(hasItem(DEFAULT_NUMERO_MARCHE)))
            .andExpect(jsonPath("$.[*].motifStopProcedure").value(hasItem(DEFAULT_MOTIF_STOP_PROCEDURE)))
            .andExpect(jsonPath("$.[*].apoFichierPV").value(hasItem(DEFAULT_APO_FICHIER_PV)))
            .andExpect(jsonPath("$.[*].apoFichierValidation").value(hasItem(DEFAULT_APO_FICHIER_VALIDATION)))
            .andExpect(jsonPath("$.[*].apoAutorisationPrealable").value(hasItem(DEFAULT_APO_AUTORISATION_PREALABLE)))
            .andExpect(jsonPath("$.[*].apoFichierAutorisationPrealable").value(hasItem(DEFAULT_APO_FICHIER_AUTORISATION_PREALABLE)))
            .andExpect(jsonPath("$.[*].apoReferenceRequeteAc").value(hasItem(DEFAULT_APO_REFERENCE_REQUETE_AC)))
            .andExpect(jsonPath("$.[*].apoRapportSpecial").value(hasItem(DEFAULT_APO_RAPPORT_SPECIAL)))
            .andExpect(jsonPath("$.[*].apoReferenceCommunication").value(hasItem(DEFAULT_APO_REFERENCE_COMMUNICATION)))
            .andExpect(jsonPath("$.[*].apoReleveConseil").value(hasItem(DEFAULT_APO_RELEVE_CONSEIL)))
            .andExpect(jsonPath("$.[*].apoFichierRapportSpecial").value(hasItem(DEFAULT_APO_FICHIER_RAPPORT_SPECIAL)))
            .andExpect(jsonPath("$.[*].apoFichierReleveConseil").value(hasItem(DEFAULT_APO_FICHIER_RELEVE_CONSEIL)))
            .andExpect(jsonPath("$.[*].pubListeRestreinte").value(hasItem(DEFAULT_PUB_LISTE_RESTREINTE)))
            .andExpect(jsonPath("$.[*].fichierListeRestreinte").value(hasItem(DEFAULT_FICHIER_LISTE_RESTREINTE)))
            .andExpect(jsonPath("$.[*].apoMontantEstime").value(hasItem(DEFAULT_APO_MONTANT_ESTIME.intValue())))
            .andExpect(jsonPath("$.[*].apoMontantVersement").value(hasItem(DEFAULT_APO_MONTANT_VERSEMENT.intValue())))
            .andExpect(jsonPath("$.[*].apoResponsableDCMP").value(hasItem(DEFAULT_APO_RESPONSABLE_DCMP)))
            .andExpect(jsonPath("$.[*].etatSeuil").value(hasItem(DEFAULT_ETAT_SEUIL)))
            .andExpect(jsonPath("$.[*].apoStatut").value(hasItem(DEFAULT_APO_STATUT)))
            .andExpect(jsonPath("$.[*].apoValide").value(hasItem(DEFAULT_APO_VALIDE)))
            .andExpect(jsonPath("$.[*].apoNbreDAO").value(hasItem(DEFAULT_APO_NBRE_DAO)))
            .andExpect(jsonPath("$.[*].apoNbreDC").value(hasItem(DEFAULT_APO_NBRE_DC)))
            .andExpect(jsonPath("$.[*].apoEtatValidation").value(hasItem(DEFAULT_APO_ETAT_VALIDATION)))
            .andExpect(jsonPath("$.[*].autiriteId").value(hasItem(DEFAULT_AUTIRITE_ID.intValue())))
            .andExpect(jsonPath("$.[*].realisationId").value(hasItem(DEFAULT_REALISATION_ID.intValue())))
            .andExpect(jsonPath("$.[*].modepassationId").value(hasItem(DEFAULT_MODEPASSATION_ID.intValue())))
            .andExpect(jsonPath("$.[*].typemarcheId").value(hasItem(DEFAULT_TYPEMARCHE_ID.intValue())))
            .andExpect(jsonPath("$.[*].modeselectionId").value(hasItem(DEFAULT_MODESELECTION_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getAppelOffre() throws Exception {
        // Initialize the database
        appelOffreRepository.saveAndFlush(appelOffre);

        // Get the appelOffre
        restAppelOffreMockMvc.perform(get("/api/appel-offres/{id}", appelOffre.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appelOffre.getId().intValue()))
            .andExpect(jsonPath("$.apoDatecreation").value(DEFAULT_APO_DATECREATION.toString()))
            .andExpect(jsonPath("$.apoDateAutorisation").value(DEFAULT_APO_DATE_AUTORISATION.toString()))
            .andExpect(jsonPath("$.apoDateDemandeAutorisation").value(DEFAULT_APO_DATE_DEMANDE_AUTORISATION.toString()))
            .andExpect(jsonPath("$.apoDateRejet").value(DEFAULT_APO_DATE_REJET.toString()))
            .andExpect(jsonPath("$.apoDateMiseAutorisation").value(DEFAULT_APO_DATE_MISE_AUTORISATION.toString()))
            .andExpect(jsonPath("$.dateStopProcedure").value(DEFAULT_DATE_STOP_PROCEDURE.toString()))
            .andExpect(jsonPath("$.dateAffectationDossier").value(DEFAULT_DATE_AFFECTATION_DOSSIER.toString()))
            .andExpect(jsonPath("$.apoDatePVOuverturepli").value(DEFAULT_APO_DATE_PV_OUVERTUREPLI.toString()))
            .andExpect(jsonPath("$.apoDateVersement").value(DEFAULT_APO_DATE_VERSEMENT.toString()))
            .andExpect(jsonPath("$.datePubListeRestreinte").value(DEFAULT_DATE_PUB_LISTE_RESTREINTE.toString()))
            .andExpect(jsonPath("$.apoProjet").value(DEFAULT_APO_PROJET))
            .andExpect(jsonPath("$.apoObjet").value(DEFAULT_APO_OBJET))
            .andExpect(jsonPath("$.apoReference").value(DEFAULT_APO_REFERENCE))
            .andExpect(jsonPath("$.apoNumeroPretCredit").value(DEFAULT_APO_NUMERO_PRET_CREDIT))
            .andExpect(jsonPath("$.apoCommentaireAutorisation").value(DEFAULT_APO_COMMENTAIRE_AUTORISATION))
            .andExpect(jsonPath("$.apoFichierMiseAutorisation").value(DEFAULT_APO_FICHIER_MISE_AUTORISATION))
            .andExpect(jsonPath("$.numeroMarche").value(DEFAULT_NUMERO_MARCHE))
            .andExpect(jsonPath("$.motifStopProcedure").value(DEFAULT_MOTIF_STOP_PROCEDURE))
            .andExpect(jsonPath("$.apoFichierPV").value(DEFAULT_APO_FICHIER_PV))
            .andExpect(jsonPath("$.apoFichierValidation").value(DEFAULT_APO_FICHIER_VALIDATION))
            .andExpect(jsonPath("$.apoAutorisationPrealable").value(DEFAULT_APO_AUTORISATION_PREALABLE))
            .andExpect(jsonPath("$.apoFichierAutorisationPrealable").value(DEFAULT_APO_FICHIER_AUTORISATION_PREALABLE))
            .andExpect(jsonPath("$.apoReferenceRequeteAc").value(DEFAULT_APO_REFERENCE_REQUETE_AC))
            .andExpect(jsonPath("$.apoRapportSpecial").value(DEFAULT_APO_RAPPORT_SPECIAL))
            .andExpect(jsonPath("$.apoReferenceCommunication").value(DEFAULT_APO_REFERENCE_COMMUNICATION))
            .andExpect(jsonPath("$.apoReleveConseil").value(DEFAULT_APO_RELEVE_CONSEIL))
            .andExpect(jsonPath("$.apoFichierRapportSpecial").value(DEFAULT_APO_FICHIER_RAPPORT_SPECIAL))
            .andExpect(jsonPath("$.apoFichierReleveConseil").value(DEFAULT_APO_FICHIER_RELEVE_CONSEIL))
            .andExpect(jsonPath("$.pubListeRestreinte").value(DEFAULT_PUB_LISTE_RESTREINTE))
            .andExpect(jsonPath("$.fichierListeRestreinte").value(DEFAULT_FICHIER_LISTE_RESTREINTE))
            .andExpect(jsonPath("$.apoMontantEstime").value(DEFAULT_APO_MONTANT_ESTIME.intValue()))
            .andExpect(jsonPath("$.apoMontantVersement").value(DEFAULT_APO_MONTANT_VERSEMENT.intValue()))
            .andExpect(jsonPath("$.apoResponsableDCMP").value(DEFAULT_APO_RESPONSABLE_DCMP))
            .andExpect(jsonPath("$.etatSeuil").value(DEFAULT_ETAT_SEUIL))
            .andExpect(jsonPath("$.apoStatut").value(DEFAULT_APO_STATUT))
            .andExpect(jsonPath("$.apoValide").value(DEFAULT_APO_VALIDE))
            .andExpect(jsonPath("$.apoNbreDAO").value(DEFAULT_APO_NBRE_DAO))
            .andExpect(jsonPath("$.apoNbreDC").value(DEFAULT_APO_NBRE_DC))
            .andExpect(jsonPath("$.apoEtatValidation").value(DEFAULT_APO_ETAT_VALIDATION))
            .andExpect(jsonPath("$.autiriteId").value(DEFAULT_AUTIRITE_ID.intValue()))
            .andExpect(jsonPath("$.realisationId").value(DEFAULT_REALISATION_ID.intValue()))
            .andExpect(jsonPath("$.modepassationId").value(DEFAULT_MODEPASSATION_ID.intValue()))
            .andExpect(jsonPath("$.typemarcheId").value(DEFAULT_TYPEMARCHE_ID.intValue()))
            .andExpect(jsonPath("$.modeselectionId").value(DEFAULT_MODESELECTION_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAppelOffre() throws Exception {
        // Get the appelOffre
        restAppelOffreMockMvc.perform(get("/api/appel-offres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppelOffre() throws Exception {
        // Initialize the database
        appelOffreRepository.saveAndFlush(appelOffre);

        int databaseSizeBeforeUpdate = appelOffreRepository.findAll().size();

        // Update the appelOffre
        AppelOffre updatedAppelOffre = appelOffreRepository.findById(appelOffre.getId()).get();
        // Disconnect from session so that the updates on updatedAppelOffre are not directly saved in db
        em.detach(updatedAppelOffre);
        updatedAppelOffre
            .apoDatecreation(UPDATED_APO_DATECREATION)
            .apoDateAutorisation(UPDATED_APO_DATE_AUTORISATION)
            .apoDateDemandeAutorisation(UPDATED_APO_DATE_DEMANDE_AUTORISATION)
            .apoDateRejet(UPDATED_APO_DATE_REJET)
            .apoDateMiseAutorisation(UPDATED_APO_DATE_MISE_AUTORISATION)
            .dateStopProcedure(UPDATED_DATE_STOP_PROCEDURE)
            .dateAffectationDossier(UPDATED_DATE_AFFECTATION_DOSSIER)
            .apoDatePVOuverturepli(UPDATED_APO_DATE_PV_OUVERTUREPLI)
            .apoDateVersement(UPDATED_APO_DATE_VERSEMENT)
            .datePubListeRestreinte(UPDATED_DATE_PUB_LISTE_RESTREINTE)
            .apoProjet(UPDATED_APO_PROJET)
            .apoObjet(UPDATED_APO_OBJET)
            .apoReference(UPDATED_APO_REFERENCE)
            .apoNumeroPretCredit(UPDATED_APO_NUMERO_PRET_CREDIT)
            .apoCommentaireAutorisation(UPDATED_APO_COMMENTAIRE_AUTORISATION)
            .apoFichierMiseAutorisation(UPDATED_APO_FICHIER_MISE_AUTORISATION)
            .numeroMarche(UPDATED_NUMERO_MARCHE)
            .motifStopProcedure(UPDATED_MOTIF_STOP_PROCEDURE)
            .apoFichierPV(UPDATED_APO_FICHIER_PV)
            .apoFichierValidation(UPDATED_APO_FICHIER_VALIDATION)
            .apoAutorisationPrealable(UPDATED_APO_AUTORISATION_PREALABLE)
            .apoFichierAutorisationPrealable(UPDATED_APO_FICHIER_AUTORISATION_PREALABLE)
            .apoReferenceRequeteAc(UPDATED_APO_REFERENCE_REQUETE_AC)
            .apoRapportSpecial(UPDATED_APO_RAPPORT_SPECIAL)
            .apoReferenceCommunication(UPDATED_APO_REFERENCE_COMMUNICATION)
            .apoReleveConseil(UPDATED_APO_RELEVE_CONSEIL)
            .apoFichierRapportSpecial(UPDATED_APO_FICHIER_RAPPORT_SPECIAL)
            .apoFichierReleveConseil(UPDATED_APO_FICHIER_RELEVE_CONSEIL)
            .pubListeRestreinte(UPDATED_PUB_LISTE_RESTREINTE)
            .fichierListeRestreinte(UPDATED_FICHIER_LISTE_RESTREINTE)
            .apoMontantEstime(UPDATED_APO_MONTANT_ESTIME)
            .apoMontantVersement(UPDATED_APO_MONTANT_VERSEMENT)
            .apoResponsableDCMP(UPDATED_APO_RESPONSABLE_DCMP)
            .etatSeuil(UPDATED_ETAT_SEUIL)
            .apoStatut(UPDATED_APO_STATUT)
            .apoValide(UPDATED_APO_VALIDE)
            .apoNbreDAO(UPDATED_APO_NBRE_DAO)
            .apoNbreDC(UPDATED_APO_NBRE_DC)
            .apoEtatValidation(UPDATED_APO_ETAT_VALIDATION)
            .autiriteId(UPDATED_AUTIRITE_ID)
            .realisationId(UPDATED_REALISATION_ID)
            .modepassationId(UPDATED_MODEPASSATION_ID)
            .typemarcheId(UPDATED_TYPEMARCHE_ID)
            .modeselectionId(UPDATED_MODESELECTION_ID);
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(updatedAppelOffre);

        restAppelOffreMockMvc.perform(put("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isOk());

        // Validate the AppelOffre in the database
        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeUpdate);
        AppelOffre testAppelOffre = appelOffreList.get(appelOffreList.size() - 1);
        assertThat(testAppelOffre.getApoDatecreation()).isEqualTo(UPDATED_APO_DATECREATION);
        assertThat(testAppelOffre.getApoDateAutorisation()).isEqualTo(UPDATED_APO_DATE_AUTORISATION);
        assertThat(testAppelOffre.getApoDateDemandeAutorisation()).isEqualTo(UPDATED_APO_DATE_DEMANDE_AUTORISATION);
        assertThat(testAppelOffre.getApoDateRejet()).isEqualTo(UPDATED_APO_DATE_REJET);
        assertThat(testAppelOffre.getApoDateMiseAutorisation()).isEqualTo(UPDATED_APO_DATE_MISE_AUTORISATION);
        assertThat(testAppelOffre.getDateStopProcedure()).isEqualTo(UPDATED_DATE_STOP_PROCEDURE);
        assertThat(testAppelOffre.getDateAffectationDossier()).isEqualTo(UPDATED_DATE_AFFECTATION_DOSSIER);
        assertThat(testAppelOffre.getApoDatePVOuverturepli()).isEqualTo(UPDATED_APO_DATE_PV_OUVERTUREPLI);
        assertThat(testAppelOffre.getApoDateVersement()).isEqualTo(UPDATED_APO_DATE_VERSEMENT);
        assertThat(testAppelOffre.getDatePubListeRestreinte()).isEqualTo(UPDATED_DATE_PUB_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getApoProjet()).isEqualTo(UPDATED_APO_PROJET);
        assertThat(testAppelOffre.getApoObjet()).isEqualTo(UPDATED_APO_OBJET);
        assertThat(testAppelOffre.getApoReference()).isEqualTo(UPDATED_APO_REFERENCE);
        assertThat(testAppelOffre.getApoNumeroPretCredit()).isEqualTo(UPDATED_APO_NUMERO_PRET_CREDIT);
        assertThat(testAppelOffre.getApoCommentaireAutorisation()).isEqualTo(UPDATED_APO_COMMENTAIRE_AUTORISATION);
        assertThat(testAppelOffre.getApoFichierMiseAutorisation()).isEqualTo(UPDATED_APO_FICHIER_MISE_AUTORISATION);
        assertThat(testAppelOffre.getNumeroMarche()).isEqualTo(UPDATED_NUMERO_MARCHE);
        assertThat(testAppelOffre.getMotifStopProcedure()).isEqualTo(UPDATED_MOTIF_STOP_PROCEDURE);
        assertThat(testAppelOffre.getApoFichierPV()).isEqualTo(UPDATED_APO_FICHIER_PV);
        assertThat(testAppelOffre.getApoFichierValidation()).isEqualTo(UPDATED_APO_FICHIER_VALIDATION);
        assertThat(testAppelOffre.getApoAutorisationPrealable()).isEqualTo(UPDATED_APO_AUTORISATION_PREALABLE);
        assertThat(testAppelOffre.getApoFichierAutorisationPrealable()).isEqualTo(UPDATED_APO_FICHIER_AUTORISATION_PREALABLE);
        assertThat(testAppelOffre.getApoReferenceRequeteAc()).isEqualTo(UPDATED_APO_REFERENCE_REQUETE_AC);
        assertThat(testAppelOffre.getApoRapportSpecial()).isEqualTo(UPDATED_APO_RAPPORT_SPECIAL);
        assertThat(testAppelOffre.getApoReferenceCommunication()).isEqualTo(UPDATED_APO_REFERENCE_COMMUNICATION);
        assertThat(testAppelOffre.getApoReleveConseil()).isEqualTo(UPDATED_APO_RELEVE_CONSEIL);
        assertThat(testAppelOffre.getApoFichierRapportSpecial()).isEqualTo(UPDATED_APO_FICHIER_RAPPORT_SPECIAL);
        assertThat(testAppelOffre.getApoFichierReleveConseil()).isEqualTo(UPDATED_APO_FICHIER_RELEVE_CONSEIL);
        assertThat(testAppelOffre.getPubListeRestreinte()).isEqualTo(UPDATED_PUB_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getFichierListeRestreinte()).isEqualTo(UPDATED_FICHIER_LISTE_RESTREINTE);
        assertThat(testAppelOffre.getApoMontantEstime()).isEqualTo(UPDATED_APO_MONTANT_ESTIME);
        assertThat(testAppelOffre.getApoMontantVersement()).isEqualTo(UPDATED_APO_MONTANT_VERSEMENT);
        assertThat(testAppelOffre.getApoResponsableDCMP()).isEqualTo(UPDATED_APO_RESPONSABLE_DCMP);
        assertThat(testAppelOffre.getEtatSeuil()).isEqualTo(UPDATED_ETAT_SEUIL);
        assertThat(testAppelOffre.getApoStatut()).isEqualTo(UPDATED_APO_STATUT);
        assertThat(testAppelOffre.getApoValide()).isEqualTo(UPDATED_APO_VALIDE);
        assertThat(testAppelOffre.getApoNbreDAO()).isEqualTo(UPDATED_APO_NBRE_DAO);
        assertThat(testAppelOffre.getApoNbreDC()).isEqualTo(UPDATED_APO_NBRE_DC);
        assertThat(testAppelOffre.getApoEtatValidation()).isEqualTo(UPDATED_APO_ETAT_VALIDATION);
        assertThat(testAppelOffre.getAutiriteId()).isEqualTo(UPDATED_AUTIRITE_ID);
        assertThat(testAppelOffre.getRealisationId()).isEqualTo(UPDATED_REALISATION_ID);
        assertThat(testAppelOffre.getModepassationId()).isEqualTo(UPDATED_MODEPASSATION_ID);
        assertThat(testAppelOffre.getTypemarcheId()).isEqualTo(UPDATED_TYPEMARCHE_ID);
        assertThat(testAppelOffre.getModeselectionId()).isEqualTo(UPDATED_MODESELECTION_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingAppelOffre() throws Exception {
        int databaseSizeBeforeUpdate = appelOffreRepository.findAll().size();

        // Create the AppelOffre
        AppelOffreDTO appelOffreDTO = appelOffreMapper.toDto(appelOffre);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppelOffreMockMvc.perform(put("/api/appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppelOffre in the database
        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppelOffre() throws Exception {
        // Initialize the database
        appelOffreRepository.saveAndFlush(appelOffre);

        int databaseSizeBeforeDelete = appelOffreRepository.findAll().size();

        // Delete the appelOffre
        restAppelOffreMockMvc.perform(delete("/api/appel-offres/{id}", appelOffre.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppelOffre> appelOffreList = appelOffreRepository.findAll();
        assertThat(appelOffreList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
