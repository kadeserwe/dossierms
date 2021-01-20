package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.DossierAppelOffre;
import sn.ssi.sigmap.repository.DossierAppelOffreRepository;
import sn.ssi.sigmap.service.DossierAppelOffreService;
import sn.ssi.sigmap.service.dto.DossierAppelOffreDTO;
import sn.ssi.sigmap.service.mapper.DossierAppelOffreMapper;

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
 * Integration tests for the {@link DossierAppelOffreResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DossierAppelOffreResourceIT {

    private static final String DEFAULT_DOS_LIEU_DEPOT_DOSSIER = "AAAAAAAAAA";
    private static final String UPDATED_DOS_LIEU_DEPOT_DOSSIER = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_ADRESSE_RETRAIT = "AAAAAAAAAA";
    private static final String UPDATED_DOS_ADRESSE_RETRAIT = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_CONDITION_ACQUISTION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_CONDITION_ACQUISTION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_ALLOTISSEMENT = "AAAAAAAAAA";
    private static final String UPDATED_DOS_ALLOTISSEMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_LOT_DIVISIBLE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_LOT_DIVISIBLE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRE_MISE_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_MISE_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRE_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_FICHIER_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_FICHIER_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRE_PUBLICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_PUBLICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENT_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENT_SIGNATURE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_REF_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_REF_SIGNATURE = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENT_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENT_APPROBATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_REF_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_REF_APPROBATION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DOS_DATE_DEBUT_RETRAIT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_DEBUT_RETRAIT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_LIMITE_DEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_LIMITE_DEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_HEURELIMITEDEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_HEURELIMITEDEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_REJET = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_REJET = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_PUBLICATION_PROVISOIRE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_PUBLICATION_PROVISOIRE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_PUBLICATION_DEFINITIVE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_PUBLICATION_DEFINITIVE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_DEMANDE_PUBLICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_DEMANDE_PUBLICATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOS_COMMENTAIRE_DEMANDE_PUBLICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_DEMANDE_PUBLICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_FICHIER_DEMANDE_PUBLICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_FICHIER_DEMANDE_PUBLICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_LIEU_ACQUISITION_DAO = "AAAAAAAAAA";
    private static final String UPDATED_DOS_LIEU_ACQUISITION_DAO = "BBBBBBBBBB";

    private static final Integer DEFAULT_TELECHARGER_DAO = 1;
    private static final Integer UPDATED_TELECHARGER_DAO = 2;

    private static final LocalDate DEFAULT_DOS_DATE_OUVERTUE_DESPLIS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_OUVERTUE_DESPLIS = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_HEURE_OUVERTURE_DES_PLIS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_HEURE_OUVERTURE_DES_PLIS = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_PUBLICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_PUBLICATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOS_FICCHIER_PUBLICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_FICCHIER_PUBLICATION = "BBBBBBBBBB";

    private static final Long DEFAULT_AUTIRITE_ID = 1L;
    private static final Long UPDATED_AUTIRITE_ID = 2L;

    private static final BigDecimal DEFAULT_DOS_MONTANT_GARANTIE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DOS_MONTANT_GARANTIE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DOS_MONTANT_DAO = new BigDecimal(1);
    private static final BigDecimal UPDATED_DOS_MONTANT_DAO = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DOS_MONTANT_ESTIME = new BigDecimal(1);
    private static final BigDecimal UPDATED_DOS_MONTANT_ESTIME = new BigDecimal(2);

    private static final String DEFAULT_DOS_INCIDENTS = "AAAAAAAAAA";
    private static final String UPDATED_DOS_INCIDENTS = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_REMISE_DOSSIER_TECHNIQUE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_REMISE_DOSSIER_TECHNIQUE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_LIMITE_DOSSIER_TECHNIQUE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_LIMITE_DOSSIER_TECHNIQUE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_COMMENTAIRE_DELAI_TECHNIQUE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE_DELAI_TECHNIQUE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DOS_DATE_MISE_VALIDATION_ATTRIBUTION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_MISE_VALIDATION_ATTRIBUTION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOS_ETAT_VALIDATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_ETAT_VALIDATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_BORDEREAU = "AAAAAAAAAA";
    private static final String UPDATED_DOS_BORDEREAU = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_FICHIER_MISE_VALIDATION_PREQUALIF = "AAAAAAAAAA";
    private static final String UPDATED_DOS_FICHIER_MISE_VALIDATION_PREQUALIF = "BBBBBBBBBB";

    private static final String DEFAULT_DOSFICHIER_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_DOSFICHIER_SIGNATURE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DOS_DATE_SIGNATURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_SIGNATURE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_MISE_VALIDATION_SIGNATURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_MISE_VALIDATION_SIGNATURE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_ATTRIBUTION_DEFINITIVE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_ATTRIBUTION_DEFINITIVE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DOS_DATE_DEMANDE_APPROBATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_DEMANDE_APPROBATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOS_COMMENT_DEMANDE_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENT_DEMANDE_APPROBATION = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_APPROBATION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DOS_DATE_NOTIFICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DOS_DATE_NOTIFICATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DOS_COMMENT_NOTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENT_NOTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_REF_NOTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_REF_NOTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_FICHIER_NOTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_DOS_FICHIER_NOTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE = "BBBBBBBBBB";

    @Autowired
    private DossierAppelOffreRepository dossierAppelOffreRepository;

    @Autowired
    private DossierAppelOffreMapper dossierAppelOffreMapper;

    @Autowired
    private DossierAppelOffreService dossierAppelOffreService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDossierAppelOffreMockMvc;

    private DossierAppelOffre dossierAppelOffre;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossierAppelOffre createEntity(EntityManager em) {
        DossierAppelOffre dossierAppelOffre = new DossierAppelOffre()
            .dosLieuDepotDossier(DEFAULT_DOS_LIEU_DEPOT_DOSSIER)
            .dosReference(DEFAULT_DOS_REFERENCE)
            .dosAdresseRetrait(DEFAULT_DOS_ADRESSE_RETRAIT)
            .dosConditionAcquistion(DEFAULT_DOS_CONDITION_ACQUISTION)
            .dosAllotissement(DEFAULT_DOS_ALLOTISSEMENT)
            .dosLotDivisible(DEFAULT_DOS_LOT_DIVISIBLE)
            .dosCommentaireMiseValidation(DEFAULT_DOS_COMMENTAIRE_MISE_VALIDATION)
            .dosCommentaireValidation(DEFAULT_DOS_COMMENTAIRE_VALIDATION)
            .dosFichierValidation(DEFAULT_DOS_FICHIER_VALIDATION)
            .dosCommentairePublicationProvisoire(DEFAULT_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE)
            .dosCommentairesPublicationDefinitive(DEFAULT_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE)
            .dosCommentairePublication(DEFAULT_DOS_COMMENTAIRE_PUBLICATION)
            .dosCommentSignature(DEFAULT_DOS_COMMENT_SIGNATURE)
            .dosRefSignature(DEFAULT_DOS_REF_SIGNATURE)
            .dosCommentApprobation(DEFAULT_DOS_COMMENT_APPROBATION)
            .dosRefApprobation(DEFAULT_DOS_REF_APPROBATION)
            .dosDateDebutRetrait(DEFAULT_DOS_DATE_DEBUT_RETRAIT)
            .dosDateLimiteDepot(DEFAULT_DOS_DATE_LIMITE_DEPOT)
            .dosHeurelimitedepot(DEFAULT_DOS_HEURELIMITEDEPOT)
            .dosDateCreation(DEFAULT_DOS_DATE_CREATION)
            .dosDateRejet(DEFAULT_DOS_DATE_REJET)
            .dosDatePublicationProvisoire(DEFAULT_DOS_DATE_PUBLICATION_PROVISOIRE)
            .dosDatePublicationDefinitive(DEFAULT_DOS_DATE_PUBLICATION_DEFINITIVE)
            .dosDateDemandePublication(DEFAULT_DOS_DATE_DEMANDE_PUBLICATION)
            .dosCommentaireDemandePublication(DEFAULT_DOS_COMMENTAIRE_DEMANDE_PUBLICATION)
            .dosFichierDemandePublication(DEFAULT_DOS_FICHIER_DEMANDE_PUBLICATION)
            .dosLieuAcquisitionDAO(DEFAULT_DOS_LIEU_ACQUISITION_DAO)
            .telechargerDAO(DEFAULT_TELECHARGER_DAO)
            .dosDateOuvertueDesplis(DEFAULT_DOS_DATE_OUVERTUE_DESPLIS)
            .dosHeureOuvertureDesPlis(DEFAULT_DOS_HEURE_OUVERTURE_DES_PLIS)
            .dosDatePublication(DEFAULT_DOS_DATE_PUBLICATION)
            .dosFicchierPublication(DEFAULT_DOS_FICCHIER_PUBLICATION)
            .autiriteId(DEFAULT_AUTIRITE_ID)
            .dosMontantGarantie(DEFAULT_DOS_MONTANT_GARANTIE)
            .dosMontantDao(DEFAULT_DOS_MONTANT_DAO)
            .dosMontantEstime(DEFAULT_DOS_MONTANT_ESTIME)
            .dosIncidents(DEFAULT_DOS_INCIDENTS)
            .dateRemiseDossierTechnique(DEFAULT_DATE_REMISE_DOSSIER_TECHNIQUE)
            .dateLimiteDossierTechnique(DEFAULT_DATE_LIMITE_DOSSIER_TECHNIQUE)
            .commentaireDelaiTechnique(DEFAULT_COMMENTAIRE_DELAI_TECHNIQUE)
            .dosDateMiseValidationAttribution(DEFAULT_DOS_DATE_MISE_VALIDATION_ATTRIBUTION)
            .dosEtatValidation(DEFAULT_DOS_ETAT_VALIDATION)
            .dosBordereau(DEFAULT_DOS_BORDEREAU)
            .dosFichierMiseValidationPrequalif(DEFAULT_DOS_FICHIER_MISE_VALIDATION_PREQUALIF)
            .dosfichierSignature(DEFAULT_DOSFICHIER_SIGNATURE)
            .dosDateSignature(DEFAULT_DOS_DATE_SIGNATURE)
            .dosDateMiseValidationSignature(DEFAULT_DOS_DATE_MISE_VALIDATION_SIGNATURE)
            .dosDateAttributionDefinitive(DEFAULT_DOS_DATE_ATTRIBUTION_DEFINITIVE)
            .dosDateDemandeApprobation(DEFAULT_DOS_DATE_DEMANDE_APPROBATION)
            .dosCommentDemandeApprobation(DEFAULT_DOS_COMMENT_DEMANDE_APPROBATION)
            .fichierApprobation(DEFAULT_FICHIER_APPROBATION)
            .dosDateNotification(DEFAULT_DOS_DATE_NOTIFICATION)
            .dosCommentNotification(DEFAULT_DOS_COMMENT_NOTIFICATION)
            .dosRefNotification(DEFAULT_DOS_REF_NOTIFICATION)
            .dosFichierNotification(DEFAULT_DOS_FICHIER_NOTIFICATION)
            .dosCommentaireAttributionDefinitive(DEFAULT_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
        return dossierAppelOffre;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossierAppelOffre createUpdatedEntity(EntityManager em) {
        DossierAppelOffre dossierAppelOffre = new DossierAppelOffre()
            .dosLieuDepotDossier(UPDATED_DOS_LIEU_DEPOT_DOSSIER)
            .dosReference(UPDATED_DOS_REFERENCE)
            .dosAdresseRetrait(UPDATED_DOS_ADRESSE_RETRAIT)
            .dosConditionAcquistion(UPDATED_DOS_CONDITION_ACQUISTION)
            .dosAllotissement(UPDATED_DOS_ALLOTISSEMENT)
            .dosLotDivisible(UPDATED_DOS_LOT_DIVISIBLE)
            .dosCommentaireMiseValidation(UPDATED_DOS_COMMENTAIRE_MISE_VALIDATION)
            .dosCommentaireValidation(UPDATED_DOS_COMMENTAIRE_VALIDATION)
            .dosFichierValidation(UPDATED_DOS_FICHIER_VALIDATION)
            .dosCommentairePublicationProvisoire(UPDATED_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE)
            .dosCommentairesPublicationDefinitive(UPDATED_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE)
            .dosCommentairePublication(UPDATED_DOS_COMMENTAIRE_PUBLICATION)
            .dosCommentSignature(UPDATED_DOS_COMMENT_SIGNATURE)
            .dosRefSignature(UPDATED_DOS_REF_SIGNATURE)
            .dosCommentApprobation(UPDATED_DOS_COMMENT_APPROBATION)
            .dosRefApprobation(UPDATED_DOS_REF_APPROBATION)
            .dosDateDebutRetrait(UPDATED_DOS_DATE_DEBUT_RETRAIT)
            .dosDateLimiteDepot(UPDATED_DOS_DATE_LIMITE_DEPOT)
            .dosHeurelimitedepot(UPDATED_DOS_HEURELIMITEDEPOT)
            .dosDateCreation(UPDATED_DOS_DATE_CREATION)
            .dosDateRejet(UPDATED_DOS_DATE_REJET)
            .dosDatePublicationProvisoire(UPDATED_DOS_DATE_PUBLICATION_PROVISOIRE)
            .dosDatePublicationDefinitive(UPDATED_DOS_DATE_PUBLICATION_DEFINITIVE)
            .dosDateDemandePublication(UPDATED_DOS_DATE_DEMANDE_PUBLICATION)
            .dosCommentaireDemandePublication(UPDATED_DOS_COMMENTAIRE_DEMANDE_PUBLICATION)
            .dosFichierDemandePublication(UPDATED_DOS_FICHIER_DEMANDE_PUBLICATION)
            .dosLieuAcquisitionDAO(UPDATED_DOS_LIEU_ACQUISITION_DAO)
            .telechargerDAO(UPDATED_TELECHARGER_DAO)
            .dosDateOuvertueDesplis(UPDATED_DOS_DATE_OUVERTUE_DESPLIS)
            .dosHeureOuvertureDesPlis(UPDATED_DOS_HEURE_OUVERTURE_DES_PLIS)
            .dosDatePublication(UPDATED_DOS_DATE_PUBLICATION)
            .dosFicchierPublication(UPDATED_DOS_FICCHIER_PUBLICATION)
            .autiriteId(UPDATED_AUTIRITE_ID)
            .dosMontantGarantie(UPDATED_DOS_MONTANT_GARANTIE)
            .dosMontantDao(UPDATED_DOS_MONTANT_DAO)
            .dosMontantEstime(UPDATED_DOS_MONTANT_ESTIME)
            .dosIncidents(UPDATED_DOS_INCIDENTS)
            .dateRemiseDossierTechnique(UPDATED_DATE_REMISE_DOSSIER_TECHNIQUE)
            .dateLimiteDossierTechnique(UPDATED_DATE_LIMITE_DOSSIER_TECHNIQUE)
            .commentaireDelaiTechnique(UPDATED_COMMENTAIRE_DELAI_TECHNIQUE)
            .dosDateMiseValidationAttribution(UPDATED_DOS_DATE_MISE_VALIDATION_ATTRIBUTION)
            .dosEtatValidation(UPDATED_DOS_ETAT_VALIDATION)
            .dosBordereau(UPDATED_DOS_BORDEREAU)
            .dosFichierMiseValidationPrequalif(UPDATED_DOS_FICHIER_MISE_VALIDATION_PREQUALIF)
            .dosfichierSignature(UPDATED_DOSFICHIER_SIGNATURE)
            .dosDateSignature(UPDATED_DOS_DATE_SIGNATURE)
            .dosDateMiseValidationSignature(UPDATED_DOS_DATE_MISE_VALIDATION_SIGNATURE)
            .dosDateAttributionDefinitive(UPDATED_DOS_DATE_ATTRIBUTION_DEFINITIVE)
            .dosDateDemandeApprobation(UPDATED_DOS_DATE_DEMANDE_APPROBATION)
            .dosCommentDemandeApprobation(UPDATED_DOS_COMMENT_DEMANDE_APPROBATION)
            .fichierApprobation(UPDATED_FICHIER_APPROBATION)
            .dosDateNotification(UPDATED_DOS_DATE_NOTIFICATION)
            .dosCommentNotification(UPDATED_DOS_COMMENT_NOTIFICATION)
            .dosRefNotification(UPDATED_DOS_REF_NOTIFICATION)
            .dosFichierNotification(UPDATED_DOS_FICHIER_NOTIFICATION)
            .dosCommentaireAttributionDefinitive(UPDATED_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
        return dossierAppelOffre;
    }

    @BeforeEach
    public void initTest() {
        dossierAppelOffre = createEntity(em);
    }

    @Test
    @Transactional
    public void createDossierAppelOffre() throws Exception {
        int databaseSizeBeforeCreate = dossierAppelOffreRepository.findAll().size();
        // Create the DossierAppelOffre
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(dossierAppelOffre);
        restDossierAppelOffreMockMvc.perform(post("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isCreated());

        // Validate the DossierAppelOffre in the database
        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeCreate + 1);
        DossierAppelOffre testDossierAppelOffre = dossierAppelOffreList.get(dossierAppelOffreList.size() - 1);
        assertThat(testDossierAppelOffre.getDosLieuDepotDossier()).isEqualTo(DEFAULT_DOS_LIEU_DEPOT_DOSSIER);
        assertThat(testDossierAppelOffre.getDosReference()).isEqualTo(DEFAULT_DOS_REFERENCE);
        assertThat(testDossierAppelOffre.getDosAdresseRetrait()).isEqualTo(DEFAULT_DOS_ADRESSE_RETRAIT);
        assertThat(testDossierAppelOffre.getDosConditionAcquistion()).isEqualTo(DEFAULT_DOS_CONDITION_ACQUISTION);
        assertThat(testDossierAppelOffre.getDosAllotissement()).isEqualTo(DEFAULT_DOS_ALLOTISSEMENT);
        assertThat(testDossierAppelOffre.getDosLotDivisible()).isEqualTo(DEFAULT_DOS_LOT_DIVISIBLE);
        assertThat(testDossierAppelOffre.getDosCommentaireMiseValidation()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_MISE_VALIDATION);
        assertThat(testDossierAppelOffre.getDosCommentaireValidation()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_VALIDATION);
        assertThat(testDossierAppelOffre.getDosFichierValidation()).isEqualTo(DEFAULT_DOS_FICHIER_VALIDATION);
        assertThat(testDossierAppelOffre.getDosCommentairePublicationProvisoire()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE);
        assertThat(testDossierAppelOffre.getDosCommentairesPublicationDefinitive()).isEqualTo(DEFAULT_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosCommentairePublication()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosCommentSignature()).isEqualTo(DEFAULT_DOS_COMMENT_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosRefSignature()).isEqualTo(DEFAULT_DOS_REF_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosCommentApprobation()).isEqualTo(DEFAULT_DOS_COMMENT_APPROBATION);
        assertThat(testDossierAppelOffre.getDosRefApprobation()).isEqualTo(DEFAULT_DOS_REF_APPROBATION);
        assertThat(testDossierAppelOffre.getDosDateDebutRetrait()).isEqualTo(DEFAULT_DOS_DATE_DEBUT_RETRAIT);
        assertThat(testDossierAppelOffre.getDosDateLimiteDepot()).isEqualTo(DEFAULT_DOS_DATE_LIMITE_DEPOT);
        assertThat(testDossierAppelOffre.getDosHeurelimitedepot()).isEqualTo(DEFAULT_DOS_HEURELIMITEDEPOT);
        assertThat(testDossierAppelOffre.getDosDateCreation()).isEqualTo(DEFAULT_DOS_DATE_CREATION);
        assertThat(testDossierAppelOffre.getDosDateRejet()).isEqualTo(DEFAULT_DOS_DATE_REJET);
        assertThat(testDossierAppelOffre.getDosDatePublicationProvisoire()).isEqualTo(DEFAULT_DOS_DATE_PUBLICATION_PROVISOIRE);
        assertThat(testDossierAppelOffre.getDosDatePublicationDefinitive()).isEqualTo(DEFAULT_DOS_DATE_PUBLICATION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosDateDemandePublication()).isEqualTo(DEFAULT_DOS_DATE_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosCommentaireDemandePublication()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosFichierDemandePublication()).isEqualTo(DEFAULT_DOS_FICHIER_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosLieuAcquisitionDAO()).isEqualTo(DEFAULT_DOS_LIEU_ACQUISITION_DAO);
        assertThat(testDossierAppelOffre.getTelechargerDAO()).isEqualTo(DEFAULT_TELECHARGER_DAO);
        assertThat(testDossierAppelOffre.getDosDateOuvertueDesplis()).isEqualTo(DEFAULT_DOS_DATE_OUVERTUE_DESPLIS);
        assertThat(testDossierAppelOffre.getDosHeureOuvertureDesPlis()).isEqualTo(DEFAULT_DOS_HEURE_OUVERTURE_DES_PLIS);
        assertThat(testDossierAppelOffre.getDosDatePublication()).isEqualTo(DEFAULT_DOS_DATE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosFicchierPublication()).isEqualTo(DEFAULT_DOS_FICCHIER_PUBLICATION);
        assertThat(testDossierAppelOffre.getAutiriteId()).isEqualTo(DEFAULT_AUTIRITE_ID);
        assertThat(testDossierAppelOffre.getDosMontantGarantie()).isEqualTo(DEFAULT_DOS_MONTANT_GARANTIE);
        assertThat(testDossierAppelOffre.getDosMontantDao()).isEqualTo(DEFAULT_DOS_MONTANT_DAO);
        assertThat(testDossierAppelOffre.getDosMontantEstime()).isEqualTo(DEFAULT_DOS_MONTANT_ESTIME);
        assertThat(testDossierAppelOffre.getDosIncidents()).isEqualTo(DEFAULT_DOS_INCIDENTS);
        assertThat(testDossierAppelOffre.getDateRemiseDossierTechnique()).isEqualTo(DEFAULT_DATE_REMISE_DOSSIER_TECHNIQUE);
        assertThat(testDossierAppelOffre.getDateLimiteDossierTechnique()).isEqualTo(DEFAULT_DATE_LIMITE_DOSSIER_TECHNIQUE);
        assertThat(testDossierAppelOffre.getCommentaireDelaiTechnique()).isEqualTo(DEFAULT_COMMENTAIRE_DELAI_TECHNIQUE);
        assertThat(testDossierAppelOffre.getDosDateMiseValidationAttribution()).isEqualTo(DEFAULT_DOS_DATE_MISE_VALIDATION_ATTRIBUTION);
        assertThat(testDossierAppelOffre.getDosEtatValidation()).isEqualTo(DEFAULT_DOS_ETAT_VALIDATION);
        assertThat(testDossierAppelOffre.getDosBordereau()).isEqualTo(DEFAULT_DOS_BORDEREAU);
        assertThat(testDossierAppelOffre.getDosFichierMiseValidationPrequalif()).isEqualTo(DEFAULT_DOS_FICHIER_MISE_VALIDATION_PREQUALIF);
        assertThat(testDossierAppelOffre.getDosfichierSignature()).isEqualTo(DEFAULT_DOSFICHIER_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateSignature()).isEqualTo(DEFAULT_DOS_DATE_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateMiseValidationSignature()).isEqualTo(DEFAULT_DOS_DATE_MISE_VALIDATION_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateAttributionDefinitive()).isEqualTo(DEFAULT_DOS_DATE_ATTRIBUTION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosDateDemandeApprobation()).isEqualTo(DEFAULT_DOS_DATE_DEMANDE_APPROBATION);
        assertThat(testDossierAppelOffre.getDosCommentDemandeApprobation()).isEqualTo(DEFAULT_DOS_COMMENT_DEMANDE_APPROBATION);
        assertThat(testDossierAppelOffre.getFichierApprobation()).isEqualTo(DEFAULT_FICHIER_APPROBATION);
        assertThat(testDossierAppelOffre.getDosDateNotification()).isEqualTo(DEFAULT_DOS_DATE_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosCommentNotification()).isEqualTo(DEFAULT_DOS_COMMENT_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosRefNotification()).isEqualTo(DEFAULT_DOS_REF_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosFichierNotification()).isEqualTo(DEFAULT_DOS_FICHIER_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosCommentaireAttributionDefinitive()).isEqualTo(DEFAULT_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
    }

    @Test
    @Transactional
    public void createDossierAppelOffreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dossierAppelOffreRepository.findAll().size();

        // Create the DossierAppelOffre with an existing ID
        dossierAppelOffre.setId(1L);
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(dossierAppelOffre);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDossierAppelOffreMockMvc.perform(post("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossierAppelOffre in the database
        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkDosReferenceIsRequired() throws Exception {
        int databaseSizeBeforeTest = dossierAppelOffreRepository.findAll().size();
        // set the field null
        dossierAppelOffre.setDosReference(null);

        // Create the DossierAppelOffre, which fails.
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(dossierAppelOffre);


        restDossierAppelOffreMockMvc.perform(post("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAutiriteIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = dossierAppelOffreRepository.findAll().size();
        // set the field null
        dossierAppelOffre.setAutiriteId(null);

        // Create the DossierAppelOffre, which fails.
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(dossierAppelOffre);


        restDossierAppelOffreMockMvc.perform(post("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDossierAppelOffres() throws Exception {
        // Initialize the database
        dossierAppelOffreRepository.saveAndFlush(dossierAppelOffre);

        // Get all the dossierAppelOffreList
        restDossierAppelOffreMockMvc.perform(get("/api/dossier-appel-offres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dossierAppelOffre.getId().intValue())))
            .andExpect(jsonPath("$.[*].dosLieuDepotDossier").value(hasItem(DEFAULT_DOS_LIEU_DEPOT_DOSSIER)))
            .andExpect(jsonPath("$.[*].dosReference").value(hasItem(DEFAULT_DOS_REFERENCE)))
            .andExpect(jsonPath("$.[*].dosAdresseRetrait").value(hasItem(DEFAULT_DOS_ADRESSE_RETRAIT)))
            .andExpect(jsonPath("$.[*].dosConditionAcquistion").value(hasItem(DEFAULT_DOS_CONDITION_ACQUISTION)))
            .andExpect(jsonPath("$.[*].dosAllotissement").value(hasItem(DEFAULT_DOS_ALLOTISSEMENT)))
            .andExpect(jsonPath("$.[*].dosLotDivisible").value(hasItem(DEFAULT_DOS_LOT_DIVISIBLE)))
            .andExpect(jsonPath("$.[*].dosCommentaireMiseValidation").value(hasItem(DEFAULT_DOS_COMMENTAIRE_MISE_VALIDATION)))
            .andExpect(jsonPath("$.[*].dosCommentaireValidation").value(hasItem(DEFAULT_DOS_COMMENTAIRE_VALIDATION)))
            .andExpect(jsonPath("$.[*].dosFichierValidation").value(hasItem(DEFAULT_DOS_FICHIER_VALIDATION)))
            .andExpect(jsonPath("$.[*].dosCommentairePublicationProvisoire").value(hasItem(DEFAULT_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].dosCommentairesPublicationDefinitive").value(hasItem(DEFAULT_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE)))
            .andExpect(jsonPath("$.[*].dosCommentairePublication").value(hasItem(DEFAULT_DOS_COMMENTAIRE_PUBLICATION)))
            .andExpect(jsonPath("$.[*].dosCommentSignature").value(hasItem(DEFAULT_DOS_COMMENT_SIGNATURE)))
            .andExpect(jsonPath("$.[*].dosRefSignature").value(hasItem(DEFAULT_DOS_REF_SIGNATURE)))
            .andExpect(jsonPath("$.[*].dosCommentApprobation").value(hasItem(DEFAULT_DOS_COMMENT_APPROBATION)))
            .andExpect(jsonPath("$.[*].dosRefApprobation").value(hasItem(DEFAULT_DOS_REF_APPROBATION)))
            .andExpect(jsonPath("$.[*].dosDateDebutRetrait").value(hasItem(DEFAULT_DOS_DATE_DEBUT_RETRAIT.toString())))
            .andExpect(jsonPath("$.[*].dosDateLimiteDepot").value(hasItem(DEFAULT_DOS_DATE_LIMITE_DEPOT.toString())))
            .andExpect(jsonPath("$.[*].dosHeurelimitedepot").value(hasItem(DEFAULT_DOS_HEURELIMITEDEPOT.toString())))
            .andExpect(jsonPath("$.[*].dosDateCreation").value(hasItem(DEFAULT_DOS_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].dosDateRejet").value(hasItem(DEFAULT_DOS_DATE_REJET.toString())))
            .andExpect(jsonPath("$.[*].dosDatePublicationProvisoire").value(hasItem(DEFAULT_DOS_DATE_PUBLICATION_PROVISOIRE.toString())))
            .andExpect(jsonPath("$.[*].dosDatePublicationDefinitive").value(hasItem(DEFAULT_DOS_DATE_PUBLICATION_DEFINITIVE.toString())))
            .andExpect(jsonPath("$.[*].dosDateDemandePublication").value(hasItem(DEFAULT_DOS_DATE_DEMANDE_PUBLICATION.toString())))
            .andExpect(jsonPath("$.[*].dosCommentaireDemandePublication").value(hasItem(DEFAULT_DOS_COMMENTAIRE_DEMANDE_PUBLICATION)))
            .andExpect(jsonPath("$.[*].dosFichierDemandePublication").value(hasItem(DEFAULT_DOS_FICHIER_DEMANDE_PUBLICATION)))
            .andExpect(jsonPath("$.[*].dosLieuAcquisitionDAO").value(hasItem(DEFAULT_DOS_LIEU_ACQUISITION_DAO)))
            .andExpect(jsonPath("$.[*].telechargerDAO").value(hasItem(DEFAULT_TELECHARGER_DAO)))
            .andExpect(jsonPath("$.[*].dosDateOuvertueDesplis").value(hasItem(DEFAULT_DOS_DATE_OUVERTUE_DESPLIS.toString())))
            .andExpect(jsonPath("$.[*].dosHeureOuvertureDesPlis").value(hasItem(DEFAULT_DOS_HEURE_OUVERTURE_DES_PLIS.toString())))
            .andExpect(jsonPath("$.[*].dosDatePublication").value(hasItem(DEFAULT_DOS_DATE_PUBLICATION.toString())))
            .andExpect(jsonPath("$.[*].dosFicchierPublication").value(hasItem(DEFAULT_DOS_FICCHIER_PUBLICATION)))
            .andExpect(jsonPath("$.[*].autiriteId").value(hasItem(DEFAULT_AUTIRITE_ID.intValue())))
            .andExpect(jsonPath("$.[*].dosMontantGarantie").value(hasItem(DEFAULT_DOS_MONTANT_GARANTIE.intValue())))
            .andExpect(jsonPath("$.[*].dosMontantDao").value(hasItem(DEFAULT_DOS_MONTANT_DAO.intValue())))
            .andExpect(jsonPath("$.[*].dosMontantEstime").value(hasItem(DEFAULT_DOS_MONTANT_ESTIME.intValue())))
            .andExpect(jsonPath("$.[*].dosIncidents").value(hasItem(DEFAULT_DOS_INCIDENTS)))
            .andExpect(jsonPath("$.[*].dateRemiseDossierTechnique").value(hasItem(DEFAULT_DATE_REMISE_DOSSIER_TECHNIQUE.toString())))
            .andExpect(jsonPath("$.[*].dateLimiteDossierTechnique").value(hasItem(DEFAULT_DATE_LIMITE_DOSSIER_TECHNIQUE.toString())))
            .andExpect(jsonPath("$.[*].commentaireDelaiTechnique").value(hasItem(DEFAULT_COMMENTAIRE_DELAI_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].dosDateMiseValidationAttribution").value(hasItem(DEFAULT_DOS_DATE_MISE_VALIDATION_ATTRIBUTION.toString())))
            .andExpect(jsonPath("$.[*].dosEtatValidation").value(hasItem(DEFAULT_DOS_ETAT_VALIDATION)))
            .andExpect(jsonPath("$.[*].dosBordereau").value(hasItem(DEFAULT_DOS_BORDEREAU)))
            .andExpect(jsonPath("$.[*].dosFichierMiseValidationPrequalif").value(hasItem(DEFAULT_DOS_FICHIER_MISE_VALIDATION_PREQUALIF)))
            .andExpect(jsonPath("$.[*].dosfichierSignature").value(hasItem(DEFAULT_DOSFICHIER_SIGNATURE)))
            .andExpect(jsonPath("$.[*].dosDateSignature").value(hasItem(DEFAULT_DOS_DATE_SIGNATURE.toString())))
            .andExpect(jsonPath("$.[*].dosDateMiseValidationSignature").value(hasItem(DEFAULT_DOS_DATE_MISE_VALIDATION_SIGNATURE.toString())))
            .andExpect(jsonPath("$.[*].dosDateAttributionDefinitive").value(hasItem(DEFAULT_DOS_DATE_ATTRIBUTION_DEFINITIVE.toString())))
            .andExpect(jsonPath("$.[*].dosDateDemandeApprobation").value(hasItem(DEFAULT_DOS_DATE_DEMANDE_APPROBATION.toString())))
            .andExpect(jsonPath("$.[*].dosCommentDemandeApprobation").value(hasItem(DEFAULT_DOS_COMMENT_DEMANDE_APPROBATION)))
            .andExpect(jsonPath("$.[*].fichierApprobation").value(hasItem(DEFAULT_FICHIER_APPROBATION)))
            .andExpect(jsonPath("$.[*].dosDateNotification").value(hasItem(DEFAULT_DOS_DATE_NOTIFICATION.toString())))
            .andExpect(jsonPath("$.[*].dosCommentNotification").value(hasItem(DEFAULT_DOS_COMMENT_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].dosRefNotification").value(hasItem(DEFAULT_DOS_REF_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].dosFichierNotification").value(hasItem(DEFAULT_DOS_FICHIER_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].dosCommentaireAttributionDefinitive").value(hasItem(DEFAULT_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE)));
    }
    
    @Test
    @Transactional
    public void getDossierAppelOffre() throws Exception {
        // Initialize the database
        dossierAppelOffreRepository.saveAndFlush(dossierAppelOffre);

        // Get the dossierAppelOffre
        restDossierAppelOffreMockMvc.perform(get("/api/dossier-appel-offres/{id}", dossierAppelOffre.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dossierAppelOffre.getId().intValue()))
            .andExpect(jsonPath("$.dosLieuDepotDossier").value(DEFAULT_DOS_LIEU_DEPOT_DOSSIER))
            .andExpect(jsonPath("$.dosReference").value(DEFAULT_DOS_REFERENCE))
            .andExpect(jsonPath("$.dosAdresseRetrait").value(DEFAULT_DOS_ADRESSE_RETRAIT))
            .andExpect(jsonPath("$.dosConditionAcquistion").value(DEFAULT_DOS_CONDITION_ACQUISTION))
            .andExpect(jsonPath("$.dosAllotissement").value(DEFAULT_DOS_ALLOTISSEMENT))
            .andExpect(jsonPath("$.dosLotDivisible").value(DEFAULT_DOS_LOT_DIVISIBLE))
            .andExpect(jsonPath("$.dosCommentaireMiseValidation").value(DEFAULT_DOS_COMMENTAIRE_MISE_VALIDATION))
            .andExpect(jsonPath("$.dosCommentaireValidation").value(DEFAULT_DOS_COMMENTAIRE_VALIDATION))
            .andExpect(jsonPath("$.dosFichierValidation").value(DEFAULT_DOS_FICHIER_VALIDATION))
            .andExpect(jsonPath("$.dosCommentairePublicationProvisoire").value(DEFAULT_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE))
            .andExpect(jsonPath("$.dosCommentairesPublicationDefinitive").value(DEFAULT_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE))
            .andExpect(jsonPath("$.dosCommentairePublication").value(DEFAULT_DOS_COMMENTAIRE_PUBLICATION))
            .andExpect(jsonPath("$.dosCommentSignature").value(DEFAULT_DOS_COMMENT_SIGNATURE))
            .andExpect(jsonPath("$.dosRefSignature").value(DEFAULT_DOS_REF_SIGNATURE))
            .andExpect(jsonPath("$.dosCommentApprobation").value(DEFAULT_DOS_COMMENT_APPROBATION))
            .andExpect(jsonPath("$.dosRefApprobation").value(DEFAULT_DOS_REF_APPROBATION))
            .andExpect(jsonPath("$.dosDateDebutRetrait").value(DEFAULT_DOS_DATE_DEBUT_RETRAIT.toString()))
            .andExpect(jsonPath("$.dosDateLimiteDepot").value(DEFAULT_DOS_DATE_LIMITE_DEPOT.toString()))
            .andExpect(jsonPath("$.dosHeurelimitedepot").value(DEFAULT_DOS_HEURELIMITEDEPOT.toString()))
            .andExpect(jsonPath("$.dosDateCreation").value(DEFAULT_DOS_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.dosDateRejet").value(DEFAULT_DOS_DATE_REJET.toString()))
            .andExpect(jsonPath("$.dosDatePublicationProvisoire").value(DEFAULT_DOS_DATE_PUBLICATION_PROVISOIRE.toString()))
            .andExpect(jsonPath("$.dosDatePublicationDefinitive").value(DEFAULT_DOS_DATE_PUBLICATION_DEFINITIVE.toString()))
            .andExpect(jsonPath("$.dosDateDemandePublication").value(DEFAULT_DOS_DATE_DEMANDE_PUBLICATION.toString()))
            .andExpect(jsonPath("$.dosCommentaireDemandePublication").value(DEFAULT_DOS_COMMENTAIRE_DEMANDE_PUBLICATION))
            .andExpect(jsonPath("$.dosFichierDemandePublication").value(DEFAULT_DOS_FICHIER_DEMANDE_PUBLICATION))
            .andExpect(jsonPath("$.dosLieuAcquisitionDAO").value(DEFAULT_DOS_LIEU_ACQUISITION_DAO))
            .andExpect(jsonPath("$.telechargerDAO").value(DEFAULT_TELECHARGER_DAO))
            .andExpect(jsonPath("$.dosDateOuvertueDesplis").value(DEFAULT_DOS_DATE_OUVERTUE_DESPLIS.toString()))
            .andExpect(jsonPath("$.dosHeureOuvertureDesPlis").value(DEFAULT_DOS_HEURE_OUVERTURE_DES_PLIS.toString()))
            .andExpect(jsonPath("$.dosDatePublication").value(DEFAULT_DOS_DATE_PUBLICATION.toString()))
            .andExpect(jsonPath("$.dosFicchierPublication").value(DEFAULT_DOS_FICCHIER_PUBLICATION))
            .andExpect(jsonPath("$.autiriteId").value(DEFAULT_AUTIRITE_ID.intValue()))
            .andExpect(jsonPath("$.dosMontantGarantie").value(DEFAULT_DOS_MONTANT_GARANTIE.intValue()))
            .andExpect(jsonPath("$.dosMontantDao").value(DEFAULT_DOS_MONTANT_DAO.intValue()))
            .andExpect(jsonPath("$.dosMontantEstime").value(DEFAULT_DOS_MONTANT_ESTIME.intValue()))
            .andExpect(jsonPath("$.dosIncidents").value(DEFAULT_DOS_INCIDENTS))
            .andExpect(jsonPath("$.dateRemiseDossierTechnique").value(DEFAULT_DATE_REMISE_DOSSIER_TECHNIQUE.toString()))
            .andExpect(jsonPath("$.dateLimiteDossierTechnique").value(DEFAULT_DATE_LIMITE_DOSSIER_TECHNIQUE.toString()))
            .andExpect(jsonPath("$.commentaireDelaiTechnique").value(DEFAULT_COMMENTAIRE_DELAI_TECHNIQUE))
            .andExpect(jsonPath("$.dosDateMiseValidationAttribution").value(DEFAULT_DOS_DATE_MISE_VALIDATION_ATTRIBUTION.toString()))
            .andExpect(jsonPath("$.dosEtatValidation").value(DEFAULT_DOS_ETAT_VALIDATION))
            .andExpect(jsonPath("$.dosBordereau").value(DEFAULT_DOS_BORDEREAU))
            .andExpect(jsonPath("$.dosFichierMiseValidationPrequalif").value(DEFAULT_DOS_FICHIER_MISE_VALIDATION_PREQUALIF))
            .andExpect(jsonPath("$.dosfichierSignature").value(DEFAULT_DOSFICHIER_SIGNATURE))
            .andExpect(jsonPath("$.dosDateSignature").value(DEFAULT_DOS_DATE_SIGNATURE.toString()))
            .andExpect(jsonPath("$.dosDateMiseValidationSignature").value(DEFAULT_DOS_DATE_MISE_VALIDATION_SIGNATURE.toString()))
            .andExpect(jsonPath("$.dosDateAttributionDefinitive").value(DEFAULT_DOS_DATE_ATTRIBUTION_DEFINITIVE.toString()))
            .andExpect(jsonPath("$.dosDateDemandeApprobation").value(DEFAULT_DOS_DATE_DEMANDE_APPROBATION.toString()))
            .andExpect(jsonPath("$.dosCommentDemandeApprobation").value(DEFAULT_DOS_COMMENT_DEMANDE_APPROBATION))
            .andExpect(jsonPath("$.fichierApprobation").value(DEFAULT_FICHIER_APPROBATION))
            .andExpect(jsonPath("$.dosDateNotification").value(DEFAULT_DOS_DATE_NOTIFICATION.toString()))
            .andExpect(jsonPath("$.dosCommentNotification").value(DEFAULT_DOS_COMMENT_NOTIFICATION))
            .andExpect(jsonPath("$.dosRefNotification").value(DEFAULT_DOS_REF_NOTIFICATION))
            .andExpect(jsonPath("$.dosFichierNotification").value(DEFAULT_DOS_FICHIER_NOTIFICATION))
            .andExpect(jsonPath("$.dosCommentaireAttributionDefinitive").value(DEFAULT_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE));
    }
    @Test
    @Transactional
    public void getNonExistingDossierAppelOffre() throws Exception {
        // Get the dossierAppelOffre
        restDossierAppelOffreMockMvc.perform(get("/api/dossier-appel-offres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDossierAppelOffre() throws Exception {
        // Initialize the database
        dossierAppelOffreRepository.saveAndFlush(dossierAppelOffre);

        int databaseSizeBeforeUpdate = dossierAppelOffreRepository.findAll().size();

        // Update the dossierAppelOffre
        DossierAppelOffre updatedDossierAppelOffre = dossierAppelOffreRepository.findById(dossierAppelOffre.getId()).get();
        // Disconnect from session so that the updates on updatedDossierAppelOffre are not directly saved in db
        em.detach(updatedDossierAppelOffre);
        updatedDossierAppelOffre
            .dosLieuDepotDossier(UPDATED_DOS_LIEU_DEPOT_DOSSIER)
            .dosReference(UPDATED_DOS_REFERENCE)
            .dosAdresseRetrait(UPDATED_DOS_ADRESSE_RETRAIT)
            .dosConditionAcquistion(UPDATED_DOS_CONDITION_ACQUISTION)
            .dosAllotissement(UPDATED_DOS_ALLOTISSEMENT)
            .dosLotDivisible(UPDATED_DOS_LOT_DIVISIBLE)
            .dosCommentaireMiseValidation(UPDATED_DOS_COMMENTAIRE_MISE_VALIDATION)
            .dosCommentaireValidation(UPDATED_DOS_COMMENTAIRE_VALIDATION)
            .dosFichierValidation(UPDATED_DOS_FICHIER_VALIDATION)
            .dosCommentairePublicationProvisoire(UPDATED_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE)
            .dosCommentairesPublicationDefinitive(UPDATED_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE)
            .dosCommentairePublication(UPDATED_DOS_COMMENTAIRE_PUBLICATION)
            .dosCommentSignature(UPDATED_DOS_COMMENT_SIGNATURE)
            .dosRefSignature(UPDATED_DOS_REF_SIGNATURE)
            .dosCommentApprobation(UPDATED_DOS_COMMENT_APPROBATION)
            .dosRefApprobation(UPDATED_DOS_REF_APPROBATION)
            .dosDateDebutRetrait(UPDATED_DOS_DATE_DEBUT_RETRAIT)
            .dosDateLimiteDepot(UPDATED_DOS_DATE_LIMITE_DEPOT)
            .dosHeurelimitedepot(UPDATED_DOS_HEURELIMITEDEPOT)
            .dosDateCreation(UPDATED_DOS_DATE_CREATION)
            .dosDateRejet(UPDATED_DOS_DATE_REJET)
            .dosDatePublicationProvisoire(UPDATED_DOS_DATE_PUBLICATION_PROVISOIRE)
            .dosDatePublicationDefinitive(UPDATED_DOS_DATE_PUBLICATION_DEFINITIVE)
            .dosDateDemandePublication(UPDATED_DOS_DATE_DEMANDE_PUBLICATION)
            .dosCommentaireDemandePublication(UPDATED_DOS_COMMENTAIRE_DEMANDE_PUBLICATION)
            .dosFichierDemandePublication(UPDATED_DOS_FICHIER_DEMANDE_PUBLICATION)
            .dosLieuAcquisitionDAO(UPDATED_DOS_LIEU_ACQUISITION_DAO)
            .telechargerDAO(UPDATED_TELECHARGER_DAO)
            .dosDateOuvertueDesplis(UPDATED_DOS_DATE_OUVERTUE_DESPLIS)
            .dosHeureOuvertureDesPlis(UPDATED_DOS_HEURE_OUVERTURE_DES_PLIS)
            .dosDatePublication(UPDATED_DOS_DATE_PUBLICATION)
            .dosFicchierPublication(UPDATED_DOS_FICCHIER_PUBLICATION)
            .autiriteId(UPDATED_AUTIRITE_ID)
            .dosMontantGarantie(UPDATED_DOS_MONTANT_GARANTIE)
            .dosMontantDao(UPDATED_DOS_MONTANT_DAO)
            .dosMontantEstime(UPDATED_DOS_MONTANT_ESTIME)
            .dosIncidents(UPDATED_DOS_INCIDENTS)
            .dateRemiseDossierTechnique(UPDATED_DATE_REMISE_DOSSIER_TECHNIQUE)
            .dateLimiteDossierTechnique(UPDATED_DATE_LIMITE_DOSSIER_TECHNIQUE)
            .commentaireDelaiTechnique(UPDATED_COMMENTAIRE_DELAI_TECHNIQUE)
            .dosDateMiseValidationAttribution(UPDATED_DOS_DATE_MISE_VALIDATION_ATTRIBUTION)
            .dosEtatValidation(UPDATED_DOS_ETAT_VALIDATION)
            .dosBordereau(UPDATED_DOS_BORDEREAU)
            .dosFichierMiseValidationPrequalif(UPDATED_DOS_FICHIER_MISE_VALIDATION_PREQUALIF)
            .dosfichierSignature(UPDATED_DOSFICHIER_SIGNATURE)
            .dosDateSignature(UPDATED_DOS_DATE_SIGNATURE)
            .dosDateMiseValidationSignature(UPDATED_DOS_DATE_MISE_VALIDATION_SIGNATURE)
            .dosDateAttributionDefinitive(UPDATED_DOS_DATE_ATTRIBUTION_DEFINITIVE)
            .dosDateDemandeApprobation(UPDATED_DOS_DATE_DEMANDE_APPROBATION)
            .dosCommentDemandeApprobation(UPDATED_DOS_COMMENT_DEMANDE_APPROBATION)
            .fichierApprobation(UPDATED_FICHIER_APPROBATION)
            .dosDateNotification(UPDATED_DOS_DATE_NOTIFICATION)
            .dosCommentNotification(UPDATED_DOS_COMMENT_NOTIFICATION)
            .dosRefNotification(UPDATED_DOS_REF_NOTIFICATION)
            .dosFichierNotification(UPDATED_DOS_FICHIER_NOTIFICATION)
            .dosCommentaireAttributionDefinitive(UPDATED_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(updatedDossierAppelOffre);

        restDossierAppelOffreMockMvc.perform(put("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isOk());

        // Validate the DossierAppelOffre in the database
        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeUpdate);
        DossierAppelOffre testDossierAppelOffre = dossierAppelOffreList.get(dossierAppelOffreList.size() - 1);
        assertThat(testDossierAppelOffre.getDosLieuDepotDossier()).isEqualTo(UPDATED_DOS_LIEU_DEPOT_DOSSIER);
        assertThat(testDossierAppelOffre.getDosReference()).isEqualTo(UPDATED_DOS_REFERENCE);
        assertThat(testDossierAppelOffre.getDosAdresseRetrait()).isEqualTo(UPDATED_DOS_ADRESSE_RETRAIT);
        assertThat(testDossierAppelOffre.getDosConditionAcquistion()).isEqualTo(UPDATED_DOS_CONDITION_ACQUISTION);
        assertThat(testDossierAppelOffre.getDosAllotissement()).isEqualTo(UPDATED_DOS_ALLOTISSEMENT);
        assertThat(testDossierAppelOffre.getDosLotDivisible()).isEqualTo(UPDATED_DOS_LOT_DIVISIBLE);
        assertThat(testDossierAppelOffre.getDosCommentaireMiseValidation()).isEqualTo(UPDATED_DOS_COMMENTAIRE_MISE_VALIDATION);
        assertThat(testDossierAppelOffre.getDosCommentaireValidation()).isEqualTo(UPDATED_DOS_COMMENTAIRE_VALIDATION);
        assertThat(testDossierAppelOffre.getDosFichierValidation()).isEqualTo(UPDATED_DOS_FICHIER_VALIDATION);
        assertThat(testDossierAppelOffre.getDosCommentairePublicationProvisoire()).isEqualTo(UPDATED_DOS_COMMENTAIRE_PUBLICATION_PROVISOIRE);
        assertThat(testDossierAppelOffre.getDosCommentairesPublicationDefinitive()).isEqualTo(UPDATED_DOS_COMMENTAIRES_PUBLICATION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosCommentairePublication()).isEqualTo(UPDATED_DOS_COMMENTAIRE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosCommentSignature()).isEqualTo(UPDATED_DOS_COMMENT_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosRefSignature()).isEqualTo(UPDATED_DOS_REF_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosCommentApprobation()).isEqualTo(UPDATED_DOS_COMMENT_APPROBATION);
        assertThat(testDossierAppelOffre.getDosRefApprobation()).isEqualTo(UPDATED_DOS_REF_APPROBATION);
        assertThat(testDossierAppelOffre.getDosDateDebutRetrait()).isEqualTo(UPDATED_DOS_DATE_DEBUT_RETRAIT);
        assertThat(testDossierAppelOffre.getDosDateLimiteDepot()).isEqualTo(UPDATED_DOS_DATE_LIMITE_DEPOT);
        assertThat(testDossierAppelOffre.getDosHeurelimitedepot()).isEqualTo(UPDATED_DOS_HEURELIMITEDEPOT);
        assertThat(testDossierAppelOffre.getDosDateCreation()).isEqualTo(UPDATED_DOS_DATE_CREATION);
        assertThat(testDossierAppelOffre.getDosDateRejet()).isEqualTo(UPDATED_DOS_DATE_REJET);
        assertThat(testDossierAppelOffre.getDosDatePublicationProvisoire()).isEqualTo(UPDATED_DOS_DATE_PUBLICATION_PROVISOIRE);
        assertThat(testDossierAppelOffre.getDosDatePublicationDefinitive()).isEqualTo(UPDATED_DOS_DATE_PUBLICATION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosDateDemandePublication()).isEqualTo(UPDATED_DOS_DATE_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosCommentaireDemandePublication()).isEqualTo(UPDATED_DOS_COMMENTAIRE_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosFichierDemandePublication()).isEqualTo(UPDATED_DOS_FICHIER_DEMANDE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosLieuAcquisitionDAO()).isEqualTo(UPDATED_DOS_LIEU_ACQUISITION_DAO);
        assertThat(testDossierAppelOffre.getTelechargerDAO()).isEqualTo(UPDATED_TELECHARGER_DAO);
        assertThat(testDossierAppelOffre.getDosDateOuvertueDesplis()).isEqualTo(UPDATED_DOS_DATE_OUVERTUE_DESPLIS);
        assertThat(testDossierAppelOffre.getDosHeureOuvertureDesPlis()).isEqualTo(UPDATED_DOS_HEURE_OUVERTURE_DES_PLIS);
        assertThat(testDossierAppelOffre.getDosDatePublication()).isEqualTo(UPDATED_DOS_DATE_PUBLICATION);
        assertThat(testDossierAppelOffre.getDosFicchierPublication()).isEqualTo(UPDATED_DOS_FICCHIER_PUBLICATION);
        assertThat(testDossierAppelOffre.getAutiriteId()).isEqualTo(UPDATED_AUTIRITE_ID);
        assertThat(testDossierAppelOffre.getDosMontantGarantie()).isEqualTo(UPDATED_DOS_MONTANT_GARANTIE);
        assertThat(testDossierAppelOffre.getDosMontantDao()).isEqualTo(UPDATED_DOS_MONTANT_DAO);
        assertThat(testDossierAppelOffre.getDosMontantEstime()).isEqualTo(UPDATED_DOS_MONTANT_ESTIME);
        assertThat(testDossierAppelOffre.getDosIncidents()).isEqualTo(UPDATED_DOS_INCIDENTS);
        assertThat(testDossierAppelOffre.getDateRemiseDossierTechnique()).isEqualTo(UPDATED_DATE_REMISE_DOSSIER_TECHNIQUE);
        assertThat(testDossierAppelOffre.getDateLimiteDossierTechnique()).isEqualTo(UPDATED_DATE_LIMITE_DOSSIER_TECHNIQUE);
        assertThat(testDossierAppelOffre.getCommentaireDelaiTechnique()).isEqualTo(UPDATED_COMMENTAIRE_DELAI_TECHNIQUE);
        assertThat(testDossierAppelOffre.getDosDateMiseValidationAttribution()).isEqualTo(UPDATED_DOS_DATE_MISE_VALIDATION_ATTRIBUTION);
        assertThat(testDossierAppelOffre.getDosEtatValidation()).isEqualTo(UPDATED_DOS_ETAT_VALIDATION);
        assertThat(testDossierAppelOffre.getDosBordereau()).isEqualTo(UPDATED_DOS_BORDEREAU);
        assertThat(testDossierAppelOffre.getDosFichierMiseValidationPrequalif()).isEqualTo(UPDATED_DOS_FICHIER_MISE_VALIDATION_PREQUALIF);
        assertThat(testDossierAppelOffre.getDosfichierSignature()).isEqualTo(UPDATED_DOSFICHIER_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateSignature()).isEqualTo(UPDATED_DOS_DATE_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateMiseValidationSignature()).isEqualTo(UPDATED_DOS_DATE_MISE_VALIDATION_SIGNATURE);
        assertThat(testDossierAppelOffre.getDosDateAttributionDefinitive()).isEqualTo(UPDATED_DOS_DATE_ATTRIBUTION_DEFINITIVE);
        assertThat(testDossierAppelOffre.getDosDateDemandeApprobation()).isEqualTo(UPDATED_DOS_DATE_DEMANDE_APPROBATION);
        assertThat(testDossierAppelOffre.getDosCommentDemandeApprobation()).isEqualTo(UPDATED_DOS_COMMENT_DEMANDE_APPROBATION);
        assertThat(testDossierAppelOffre.getFichierApprobation()).isEqualTo(UPDATED_FICHIER_APPROBATION);
        assertThat(testDossierAppelOffre.getDosDateNotification()).isEqualTo(UPDATED_DOS_DATE_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosCommentNotification()).isEqualTo(UPDATED_DOS_COMMENT_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosRefNotification()).isEqualTo(UPDATED_DOS_REF_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosFichierNotification()).isEqualTo(UPDATED_DOS_FICHIER_NOTIFICATION);
        assertThat(testDossierAppelOffre.getDosCommentaireAttributionDefinitive()).isEqualTo(UPDATED_DOS_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
    }

    @Test
    @Transactional
    public void updateNonExistingDossierAppelOffre() throws Exception {
        int databaseSizeBeforeUpdate = dossierAppelOffreRepository.findAll().size();

        // Create the DossierAppelOffre
        DossierAppelOffreDTO dossierAppelOffreDTO = dossierAppelOffreMapper.toDto(dossierAppelOffre);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDossierAppelOffreMockMvc.perform(put("/api/dossier-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossierAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossierAppelOffre in the database
        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDossierAppelOffre() throws Exception {
        // Initialize the database
        dossierAppelOffreRepository.saveAndFlush(dossierAppelOffre);

        int databaseSizeBeforeDelete = dossierAppelOffreRepository.findAll().size();

        // Delete the dossierAppelOffre
        restDossierAppelOffreMockMvc.perform(delete("/api/dossier-appel-offres/{id}", dossierAppelOffre.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DossierAppelOffre> dossierAppelOffreList = dossierAppelOffreRepository.findAll();
        assertThat(dossierAppelOffreList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
