package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.PlisOuverture;
import sn.ssi.sigmap.repository.PlisOuvertureRepository;
import sn.ssi.sigmap.service.PlisOuvertureService;
import sn.ssi.sigmap.service.dto.PlisOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PlisOuvertureMapper;

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
 * Integration tests for the {@link PlisOuvertureResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PlisOuvertureResourceIT {

    private static final String DEFAULT_RAISON_SOCIALE = "AAAAAAAAAA";
    private static final String UPDATED_RAISON_SOCIALE = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESSE_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_ADRESSE_MAIL = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_RANG = "AAAAAAAAAA";
    private static final String UPDATED_RANG = "BBBBBBBBBB";

    private static final String DEFAULT_NINEA = "AAAAAAAAAA";
    private static final String UPDATED_NINEA = "BBBBBBBBBB";

    private static final String DEFAULT_NAT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NAT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MON_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MON_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PV_OFFRE_FINANCIERE = "AAAAAAAAAA";
    private static final String UPDATED_PV_OFFRE_FINANCIERE = "BBBBBBBBBB";

    private static final String DEFAULT_NEGOCIATION = "AAAAAAAAAA";
    private static final String UPDATED_NEGOCIATION = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MONTANT_OFFERT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_OFFERT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SCORE_FINANCIER = new BigDecimal(1);
    private static final BigDecimal UPDATED_SCORE_FINANCIER = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRIX_EVALUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRIX_EVALUE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SCORE_TECHNIQUE_PONDERE = new BigDecimal(1);
    private static final BigDecimal UPDATED_SCORE_TECHNIQUE_PONDERE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SCORE_FINANCIER_PONDERE = new BigDecimal(1);
    private static final BigDecimal UPDATED_SCORE_FINANCIER_PONDERE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SCORE_FINAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_SCORE_FINAL = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_DEFINITIF = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_DEFINITIF = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_TVA = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_TVA = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_DOUANE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_DOUANE = new BigDecimal(2);

    private static final LocalDate DEFAULT_DATE_DEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEUREDEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEUREDEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_RABAIS = 1;
    private static final Integer UPDATED_RABAIS = 2;

    private static final Integer DEFAULT_SCORE_TECHNIQUE = 1;
    private static final Integer UPDATED_SCORE_TECHNIQUE = 2;

    private static final Integer DEFAULT_SEUIL_ATTEINT = 1;
    private static final Integer UPDATED_SEUIL_ATTEINT = 2;

    private static final Integer DEFAULT_CLASSEMEN_TECHNIQUE = 1;
    private static final Integer UPDATED_CLASSEMEN_TECHNIQUE = 2;

    private static final Integer DEFAULT_CLASSEMENT_GENERAL = 1;
    private static final Integer UPDATED_CLASSEMENT_GENERAL = 2;

    private static final Integer DEFAULT_CANDIDAT_RESTREINT_ID = 1;
    private static final Integer UPDATED_CANDIDAT_RESTREINT_ID = 2;

    private static final Integer DEFAULT_ETAT_PRESELECTION = 1;
    private static final Integer UPDATED_ETAT_PRESELECTION = 2;

    private static final Integer DEFAULT_ETAT_EXAMEN_PRELIMINAIRE = 1;
    private static final Integer UPDATED_ETAT_EXAMEN_PRELIMINAIRE = 2;

    private static final Integer DEFAULT_CRITERE_QUALIFICATION = 1;
    private static final Integer UPDATED_CRITERE_QUALIFICATION = 2;

    private static final Integer DEFAULT_ATTRIBUTAIRE_PROVISOIRE = 1;
    private static final Integer UPDATED_ATTRIBUTAIRE_PROVISOIRE = 2;

    private static final Integer DEFAULT_OFFRE_TECHNIQUE = 1;
    private static final Integer UPDATED_OFFRE_TECHNIQUE = 2;

    private static final Integer DEFAULT_OFFRE_FINANCIERE = 1;
    private static final Integer UPDATED_OFFRE_FINANCIERE = 2;

    private static final Integer DEFAULT_LETTRE_SOUMISSION = 1;
    private static final Integer UPDATED_LETTRE_SOUMISSION = 2;

    private static final Integer DEFAULT_VALIDE = 1;
    private static final Integer UPDATED_VALIDE = 2;

    private static final Integer DEFAULT_NUMERO = 1;
    private static final Integer UPDATED_NUMERO = 2;

    private static final Integer DEFAULT_GARANTIE = 1;
    private static final Integer UPDATED_GARANTIE = 2;

    private static final Integer DEFAULT_PIECE_REQUISE = 1;
    private static final Integer UPDATED_PIECE_REQUISE = 2;

    private static final String DEFAULT_OBSERVATIONS_OFFRES = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATIONS_OFFRES = "BBBBBBBBBB";

    private static final String DEFAULT_OBSERVATIONS_CANDIDATS = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATIONS_CANDIDATS = "BBBBBBBBBB";

    private static final String DEFAULT_MODE_RECEPTION = "AAAAAAAAAA";
    private static final String UPDATED_MODE_RECEPTION = "BBBBBBBBBB";

    private static final String DEFAULT_NOTIFIE = "AAAAAAAAAA";
    private static final String UPDATED_NOTIFIE = "BBBBBBBBBB";

    private static final String DEFAULT_SIGNATURE_OFFRE = "AAAAAAAAAA";
    private static final String UPDATED_SIGNATURE_OFFRE = "BBBBBBBBBB";

    private static final String DEFAULT_EXHAUSTIVITE = "AAAAAAAAAA";
    private static final String UPDATED_EXHAUSTIVITE = "BBBBBBBBBB";

    private static final String DEFAULT_GARANTIE_SOUMISSION = "AAAAAAAAAA";
    private static final String UPDATED_GARANTIE_SOUMISSION = "BBBBBBBBBB";

    private static final String DEFAULT_CONFORMITE = "AAAAAAAAAA";
    private static final String UPDATED_CONFORMITE = "BBBBBBBBBB";

    private static final String DEFAULT_CRITERE_PROVENANCE = "AAAAAAAAAA";
    private static final String UPDATED_CRITERE_PROVENANCE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_NOTE_PRESELECTIONNE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NOTE_PRESELECTIONNE = new BigDecimal(2);

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    private static final Long DEFAULT_AJUSTEMENT = 1L;
    private static final Long UPDATED_AJUSTEMENT = 2L;

    @Autowired
    private PlisOuvertureRepository plisOuvertureRepository;

    @Autowired
    private PlisOuvertureMapper plisOuvertureMapper;

    @Autowired
    private PlisOuvertureService plisOuvertureService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPlisOuvertureMockMvc;

    private PlisOuverture plisOuverture;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PlisOuverture createEntity(EntityManager em) {
        PlisOuverture plisOuverture = new PlisOuverture()
            .raisonSociale(DEFAULT_RAISON_SOCIALE)
            .adresseMail(DEFAULT_ADRESSE_MAIL)
            .commentaire(DEFAULT_COMMENTAIRE)
            .rang(DEFAULT_RANG)
            .ninea(DEFAULT_NINEA)
            .natCode(DEFAULT_NAT_CODE)
            .monCode(DEFAULT_MON_CODE)
            .pvOffreFinanciere(DEFAULT_PV_OFFRE_FINANCIERE)
            .negociation(DEFAULT_NEGOCIATION)
            .montantOffert(DEFAULT_MONTANT_OFFERT)
            .scoreFinancier(DEFAULT_SCORE_FINANCIER)
            .prixEvalue(DEFAULT_PRIX_EVALUE)
            .scoreTechniquePondere(DEFAULT_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(DEFAULT_SCORE_FINANCIER_PONDERE)
            .scoreFinal(DEFAULT_SCORE_FINAL)
            .montantDefinitif(DEFAULT_MONTANT_DEFINITIF)
            .montantTVA(DEFAULT_MONTANT_TVA)
            .montantDouane(DEFAULT_MONTANT_DOUANE)
            .dateDepot(DEFAULT_DATE_DEPOT)
            .heuredepot(DEFAULT_HEUREDEPOT)
            .rabais(DEFAULT_RABAIS)
            .scoreTechnique(DEFAULT_SCORE_TECHNIQUE)
            .seuilAtteint(DEFAULT_SEUIL_ATTEINT)
            .classemenTechnique(DEFAULT_CLASSEMEN_TECHNIQUE)
            .classementGeneral(DEFAULT_CLASSEMENT_GENERAL)
            .candidatRestreintID(DEFAULT_CANDIDAT_RESTREINT_ID)
            .etatPreselection(DEFAULT_ETAT_PRESELECTION)
            .etatExamenPreliminaire(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(DEFAULT_CRITERE_QUALIFICATION)
            .attributaireProvisoire(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)
            .offreTechnique(DEFAULT_OFFRE_TECHNIQUE)
            .offreFinanciere(DEFAULT_OFFRE_FINANCIERE)
            .lettreSoumission(DEFAULT_LETTRE_SOUMISSION)
            .valide(DEFAULT_VALIDE)
            .numero(DEFAULT_NUMERO)
            .garantie(DEFAULT_GARANTIE)
            .pieceRequise(DEFAULT_PIECE_REQUISE)
            .observationsOffres(DEFAULT_OBSERVATIONS_OFFRES)
            .observationsCandidats(DEFAULT_OBSERVATIONS_CANDIDATS)
            .modeReception(DEFAULT_MODE_RECEPTION)
            .notifie(DEFAULT_NOTIFIE)
            .signatureOffre(DEFAULT_SIGNATURE_OFFRE)
            .exhaustivite(DEFAULT_EXHAUSTIVITE)
            .garantieSoumission(DEFAULT_GARANTIE_SOUMISSION)
            .conformite(DEFAULT_CONFORMITE)
            .critereProvenance(DEFAULT_CRITERE_PROVENANCE)
            .notePreselectionne(DEFAULT_NOTE_PRESELECTIONNE)
            .autoriteId(DEFAULT_AUTORITE_ID)
            .ajustement(DEFAULT_AJUSTEMENT);
        return plisOuverture;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PlisOuverture createUpdatedEntity(EntityManager em) {
        PlisOuverture plisOuverture = new PlisOuverture()
            .raisonSociale(UPDATED_RAISON_SOCIALE)
            .adresseMail(UPDATED_ADRESSE_MAIL)
            .commentaire(UPDATED_COMMENTAIRE)
            .rang(UPDATED_RANG)
            .ninea(UPDATED_NINEA)
            .natCode(UPDATED_NAT_CODE)
            .monCode(UPDATED_MON_CODE)
            .pvOffreFinanciere(UPDATED_PV_OFFRE_FINANCIERE)
            .negociation(UPDATED_NEGOCIATION)
            .montantOffert(UPDATED_MONTANT_OFFERT)
            .scoreFinancier(UPDATED_SCORE_FINANCIER)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .scoreTechniquePondere(UPDATED_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(UPDATED_SCORE_FINANCIER_PONDERE)
            .scoreFinal(UPDATED_SCORE_FINAL)
            .montantDefinitif(UPDATED_MONTANT_DEFINITIF)
            .montantTVA(UPDATED_MONTANT_TVA)
            .montantDouane(UPDATED_MONTANT_DOUANE)
            .dateDepot(UPDATED_DATE_DEPOT)
            .heuredepot(UPDATED_HEUREDEPOT)
            .rabais(UPDATED_RABAIS)
            .scoreTechnique(UPDATED_SCORE_TECHNIQUE)
            .seuilAtteint(UPDATED_SEUIL_ATTEINT)
            .classemenTechnique(UPDATED_CLASSEMEN_TECHNIQUE)
            .classementGeneral(UPDATED_CLASSEMENT_GENERAL)
            .candidatRestreintID(UPDATED_CANDIDAT_RESTREINT_ID)
            .etatPreselection(UPDATED_ETAT_PRESELECTION)
            .etatExamenPreliminaire(UPDATED_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .offreTechnique(UPDATED_OFFRE_TECHNIQUE)
            .offreFinanciere(UPDATED_OFFRE_FINANCIERE)
            .lettreSoumission(UPDATED_LETTRE_SOUMISSION)
            .valide(UPDATED_VALIDE)
            .numero(UPDATED_NUMERO)
            .garantie(UPDATED_GARANTIE)
            .pieceRequise(UPDATED_PIECE_REQUISE)
            .observationsOffres(UPDATED_OBSERVATIONS_OFFRES)
            .observationsCandidats(UPDATED_OBSERVATIONS_CANDIDATS)
            .modeReception(UPDATED_MODE_RECEPTION)
            .notifie(UPDATED_NOTIFIE)
            .signatureOffre(UPDATED_SIGNATURE_OFFRE)
            .exhaustivite(UPDATED_EXHAUSTIVITE)
            .garantieSoumission(UPDATED_GARANTIE_SOUMISSION)
            .conformite(UPDATED_CONFORMITE)
            .critereProvenance(UPDATED_CRITERE_PROVENANCE)
            .notePreselectionne(UPDATED_NOTE_PRESELECTIONNE)
            .autoriteId(UPDATED_AUTORITE_ID)
            .ajustement(UPDATED_AJUSTEMENT);
        return plisOuverture;
    }

    @BeforeEach
    public void initTest() {
        plisOuverture = createEntity(em);
    }

    @Test
    @Transactional
    public void createPlisOuverture() throws Exception {
        int databaseSizeBeforeCreate = plisOuvertureRepository.findAll().size();
        // Create the PlisOuverture
        PlisOuvertureDTO plisOuvertureDTO = plisOuvertureMapper.toDto(plisOuverture);
        restPlisOuvertureMockMvc.perform(post("/api/plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(plisOuvertureDTO)))
            .andExpect(status().isCreated());

        // Validate the PlisOuverture in the database
        List<PlisOuverture> plisOuvertureList = plisOuvertureRepository.findAll();
        assertThat(plisOuvertureList).hasSize(databaseSizeBeforeCreate + 1);
        PlisOuverture testPlisOuverture = plisOuvertureList.get(plisOuvertureList.size() - 1);
        assertThat(testPlisOuverture.getRaisonSociale()).isEqualTo(DEFAULT_RAISON_SOCIALE);
        assertThat(testPlisOuverture.getAdresseMail()).isEqualTo(DEFAULT_ADRESSE_MAIL);
        assertThat(testPlisOuverture.getCommentaire()).isEqualTo(DEFAULT_COMMENTAIRE);
        assertThat(testPlisOuverture.getRang()).isEqualTo(DEFAULT_RANG);
        assertThat(testPlisOuverture.getNinea()).isEqualTo(DEFAULT_NINEA);
        assertThat(testPlisOuverture.getNatCode()).isEqualTo(DEFAULT_NAT_CODE);
        assertThat(testPlisOuverture.getMonCode()).isEqualTo(DEFAULT_MON_CODE);
        assertThat(testPlisOuverture.getPvOffreFinanciere()).isEqualTo(DEFAULT_PV_OFFRE_FINANCIERE);
        assertThat(testPlisOuverture.getNegociation()).isEqualTo(DEFAULT_NEGOCIATION);
        assertThat(testPlisOuverture.getMontantOffert()).isEqualTo(DEFAULT_MONTANT_OFFERT);
        assertThat(testPlisOuverture.getScoreFinancier()).isEqualTo(DEFAULT_SCORE_FINANCIER);
        assertThat(testPlisOuverture.getPrixEvalue()).isEqualTo(DEFAULT_PRIX_EVALUE);
        assertThat(testPlisOuverture.getScoreTechniquePondere()).isEqualTo(DEFAULT_SCORE_TECHNIQUE_PONDERE);
        assertThat(testPlisOuverture.getScoreFinancierPondere()).isEqualTo(DEFAULT_SCORE_FINANCIER_PONDERE);
        assertThat(testPlisOuverture.getScoreFinal()).isEqualTo(DEFAULT_SCORE_FINAL);
        assertThat(testPlisOuverture.getMontantDefinitif()).isEqualTo(DEFAULT_MONTANT_DEFINITIF);
        assertThat(testPlisOuverture.getMontantTVA()).isEqualTo(DEFAULT_MONTANT_TVA);
        assertThat(testPlisOuverture.getMontantDouane()).isEqualTo(DEFAULT_MONTANT_DOUANE);
        assertThat(testPlisOuverture.getDateDepot()).isEqualTo(DEFAULT_DATE_DEPOT);
        assertThat(testPlisOuverture.getHeuredepot()).isEqualTo(DEFAULT_HEUREDEPOT);
        assertThat(testPlisOuverture.getRabais()).isEqualTo(DEFAULT_RABAIS);
        assertThat(testPlisOuverture.getScoreTechnique()).isEqualTo(DEFAULT_SCORE_TECHNIQUE);
        assertThat(testPlisOuverture.getSeuilAtteint()).isEqualTo(DEFAULT_SEUIL_ATTEINT);
        assertThat(testPlisOuverture.getClassemenTechnique()).isEqualTo(DEFAULT_CLASSEMEN_TECHNIQUE);
        assertThat(testPlisOuverture.getClassementGeneral()).isEqualTo(DEFAULT_CLASSEMENT_GENERAL);
        assertThat(testPlisOuverture.getCandidatRestreintID()).isEqualTo(DEFAULT_CANDIDAT_RESTREINT_ID);
        assertThat(testPlisOuverture.getEtatPreselection()).isEqualTo(DEFAULT_ETAT_PRESELECTION);
        assertThat(testPlisOuverture.getEtatExamenPreliminaire()).isEqualTo(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE);
        assertThat(testPlisOuverture.getCritereQualification()).isEqualTo(DEFAULT_CRITERE_QUALIFICATION);
        assertThat(testPlisOuverture.getAttributaireProvisoire()).isEqualTo(DEFAULT_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testPlisOuverture.getOffreTechnique()).isEqualTo(DEFAULT_OFFRE_TECHNIQUE);
        assertThat(testPlisOuverture.getOffreFinanciere()).isEqualTo(DEFAULT_OFFRE_FINANCIERE);
        assertThat(testPlisOuverture.getLettreSoumission()).isEqualTo(DEFAULT_LETTRE_SOUMISSION);
        assertThat(testPlisOuverture.getValide()).isEqualTo(DEFAULT_VALIDE);
        assertThat(testPlisOuverture.getNumero()).isEqualTo(DEFAULT_NUMERO);
        assertThat(testPlisOuverture.getGarantie()).isEqualTo(DEFAULT_GARANTIE);
        assertThat(testPlisOuverture.getPieceRequise()).isEqualTo(DEFAULT_PIECE_REQUISE);
        assertThat(testPlisOuverture.getObservationsOffres()).isEqualTo(DEFAULT_OBSERVATIONS_OFFRES);
        assertThat(testPlisOuverture.getObservationsCandidats()).isEqualTo(DEFAULT_OBSERVATIONS_CANDIDATS);
        assertThat(testPlisOuverture.getModeReception()).isEqualTo(DEFAULT_MODE_RECEPTION);
        assertThat(testPlisOuverture.getNotifie()).isEqualTo(DEFAULT_NOTIFIE);
        assertThat(testPlisOuverture.getSignatureOffre()).isEqualTo(DEFAULT_SIGNATURE_OFFRE);
        assertThat(testPlisOuverture.getExhaustivite()).isEqualTo(DEFAULT_EXHAUSTIVITE);
        assertThat(testPlisOuverture.getGarantieSoumission()).isEqualTo(DEFAULT_GARANTIE_SOUMISSION);
        assertThat(testPlisOuverture.getConformite()).isEqualTo(DEFAULT_CONFORMITE);
        assertThat(testPlisOuverture.getCritereProvenance()).isEqualTo(DEFAULT_CRITERE_PROVENANCE);
        assertThat(testPlisOuverture.getNotePreselectionne()).isEqualTo(DEFAULT_NOTE_PRESELECTIONNE);
        assertThat(testPlisOuverture.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
        assertThat(testPlisOuverture.getAjustement()).isEqualTo(DEFAULT_AJUSTEMENT);
    }

    @Test
    @Transactional
    public void createPlisOuvertureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = plisOuvertureRepository.findAll().size();

        // Create the PlisOuverture with an existing ID
        plisOuverture.setId(1L);
        PlisOuvertureDTO plisOuvertureDTO = plisOuvertureMapper.toDto(plisOuverture);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPlisOuvertureMockMvc.perform(post("/api/plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(plisOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PlisOuverture in the database
        List<PlisOuverture> plisOuvertureList = plisOuvertureRepository.findAll();
        assertThat(plisOuvertureList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPlisOuvertures() throws Exception {
        // Initialize the database
        plisOuvertureRepository.saveAndFlush(plisOuverture);

        // Get all the plisOuvertureList
        restPlisOuvertureMockMvc.perform(get("/api/plis-ouvertures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(plisOuverture.getId().intValue())))
            .andExpect(jsonPath("$.[*].raisonSociale").value(hasItem(DEFAULT_RAISON_SOCIALE)))
            .andExpect(jsonPath("$.[*].adresseMail").value(hasItem(DEFAULT_ADRESSE_MAIL)))
            .andExpect(jsonPath("$.[*].commentaire").value(hasItem(DEFAULT_COMMENTAIRE)))
            .andExpect(jsonPath("$.[*].rang").value(hasItem(DEFAULT_RANG)))
            .andExpect(jsonPath("$.[*].ninea").value(hasItem(DEFAULT_NINEA)))
            .andExpect(jsonPath("$.[*].natCode").value(hasItem(DEFAULT_NAT_CODE)))
            .andExpect(jsonPath("$.[*].monCode").value(hasItem(DEFAULT_MON_CODE)))
            .andExpect(jsonPath("$.[*].pvOffreFinanciere").value(hasItem(DEFAULT_PV_OFFRE_FINANCIERE)))
            .andExpect(jsonPath("$.[*].negociation").value(hasItem(DEFAULT_NEGOCIATION)))
            .andExpect(jsonPath("$.[*].montantOffert").value(hasItem(DEFAULT_MONTANT_OFFERT.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinancier").value(hasItem(DEFAULT_SCORE_FINANCIER.intValue())))
            .andExpect(jsonPath("$.[*].prixEvalue").value(hasItem(DEFAULT_PRIX_EVALUE.intValue())))
            .andExpect(jsonPath("$.[*].scoreTechniquePondere").value(hasItem(DEFAULT_SCORE_TECHNIQUE_PONDERE.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinancierPondere").value(hasItem(DEFAULT_SCORE_FINANCIER_PONDERE.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinal").value(hasItem(DEFAULT_SCORE_FINAL.intValue())))
            .andExpect(jsonPath("$.[*].montantDefinitif").value(hasItem(DEFAULT_MONTANT_DEFINITIF.intValue())))
            .andExpect(jsonPath("$.[*].montantTVA").value(hasItem(DEFAULT_MONTANT_TVA.intValue())))
            .andExpect(jsonPath("$.[*].montantDouane").value(hasItem(DEFAULT_MONTANT_DOUANE.intValue())))
            .andExpect(jsonPath("$.[*].dateDepot").value(hasItem(DEFAULT_DATE_DEPOT.toString())))
            .andExpect(jsonPath("$.[*].heuredepot").value(hasItem(DEFAULT_HEUREDEPOT.toString())))
            .andExpect(jsonPath("$.[*].rabais").value(hasItem(DEFAULT_RABAIS)))
            .andExpect(jsonPath("$.[*].scoreTechnique").value(hasItem(DEFAULT_SCORE_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].seuilAtteint").value(hasItem(DEFAULT_SEUIL_ATTEINT)))
            .andExpect(jsonPath("$.[*].classemenTechnique").value(hasItem(DEFAULT_CLASSEMEN_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].classementGeneral").value(hasItem(DEFAULT_CLASSEMENT_GENERAL)))
            .andExpect(jsonPath("$.[*].candidatRestreintID").value(hasItem(DEFAULT_CANDIDAT_RESTREINT_ID)))
            .andExpect(jsonPath("$.[*].etatPreselection").value(hasItem(DEFAULT_ETAT_PRESELECTION)))
            .andExpect(jsonPath("$.[*].etatExamenPreliminaire").value(hasItem(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE)))
            .andExpect(jsonPath("$.[*].critereQualification").value(hasItem(DEFAULT_CRITERE_QUALIFICATION)))
            .andExpect(jsonPath("$.[*].attributaireProvisoire").value(hasItem(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].offreTechnique").value(hasItem(DEFAULT_OFFRE_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].offreFinanciere").value(hasItem(DEFAULT_OFFRE_FINANCIERE)))
            .andExpect(jsonPath("$.[*].lettreSoumission").value(hasItem(DEFAULT_LETTRE_SOUMISSION)))
            .andExpect(jsonPath("$.[*].valide").value(hasItem(DEFAULT_VALIDE)))
            .andExpect(jsonPath("$.[*].numero").value(hasItem(DEFAULT_NUMERO)))
            .andExpect(jsonPath("$.[*].garantie").value(hasItem(DEFAULT_GARANTIE)))
            .andExpect(jsonPath("$.[*].pieceRequise").value(hasItem(DEFAULT_PIECE_REQUISE)))
            .andExpect(jsonPath("$.[*].observationsOffres").value(hasItem(DEFAULT_OBSERVATIONS_OFFRES)))
            .andExpect(jsonPath("$.[*].observationsCandidats").value(hasItem(DEFAULT_OBSERVATIONS_CANDIDATS)))
            .andExpect(jsonPath("$.[*].modeReception").value(hasItem(DEFAULT_MODE_RECEPTION)))
            .andExpect(jsonPath("$.[*].notifie").value(hasItem(DEFAULT_NOTIFIE)))
            .andExpect(jsonPath("$.[*].signatureOffre").value(hasItem(DEFAULT_SIGNATURE_OFFRE)))
            .andExpect(jsonPath("$.[*].exhaustivite").value(hasItem(DEFAULT_EXHAUSTIVITE)))
            .andExpect(jsonPath("$.[*].garantieSoumission").value(hasItem(DEFAULT_GARANTIE_SOUMISSION)))
            .andExpect(jsonPath("$.[*].conformite").value(hasItem(DEFAULT_CONFORMITE)))
            .andExpect(jsonPath("$.[*].critereProvenance").value(hasItem(DEFAULT_CRITERE_PROVENANCE)))
            .andExpect(jsonPath("$.[*].notePreselectionne").value(hasItem(DEFAULT_NOTE_PRESELECTIONNE.intValue())))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())))
            .andExpect(jsonPath("$.[*].ajustement").value(hasItem(DEFAULT_AJUSTEMENT.intValue())));
    }
    
    @Test
    @Transactional
    public void getPlisOuverture() throws Exception {
        // Initialize the database
        plisOuvertureRepository.saveAndFlush(plisOuverture);

        // Get the plisOuverture
        restPlisOuvertureMockMvc.perform(get("/api/plis-ouvertures/{id}", plisOuverture.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(plisOuverture.getId().intValue()))
            .andExpect(jsonPath("$.raisonSociale").value(DEFAULT_RAISON_SOCIALE))
            .andExpect(jsonPath("$.adresseMail").value(DEFAULT_ADRESSE_MAIL))
            .andExpect(jsonPath("$.commentaire").value(DEFAULT_COMMENTAIRE))
            .andExpect(jsonPath("$.rang").value(DEFAULT_RANG))
            .andExpect(jsonPath("$.ninea").value(DEFAULT_NINEA))
            .andExpect(jsonPath("$.natCode").value(DEFAULT_NAT_CODE))
            .andExpect(jsonPath("$.monCode").value(DEFAULT_MON_CODE))
            .andExpect(jsonPath("$.pvOffreFinanciere").value(DEFAULT_PV_OFFRE_FINANCIERE))
            .andExpect(jsonPath("$.negociation").value(DEFAULT_NEGOCIATION))
            .andExpect(jsonPath("$.montantOffert").value(DEFAULT_MONTANT_OFFERT.intValue()))
            .andExpect(jsonPath("$.scoreFinancier").value(DEFAULT_SCORE_FINANCIER.intValue()))
            .andExpect(jsonPath("$.prixEvalue").value(DEFAULT_PRIX_EVALUE.intValue()))
            .andExpect(jsonPath("$.scoreTechniquePondere").value(DEFAULT_SCORE_TECHNIQUE_PONDERE.intValue()))
            .andExpect(jsonPath("$.scoreFinancierPondere").value(DEFAULT_SCORE_FINANCIER_PONDERE.intValue()))
            .andExpect(jsonPath("$.scoreFinal").value(DEFAULT_SCORE_FINAL.intValue()))
            .andExpect(jsonPath("$.montantDefinitif").value(DEFAULT_MONTANT_DEFINITIF.intValue()))
            .andExpect(jsonPath("$.montantTVA").value(DEFAULT_MONTANT_TVA.intValue()))
            .andExpect(jsonPath("$.montantDouane").value(DEFAULT_MONTANT_DOUANE.intValue()))
            .andExpect(jsonPath("$.dateDepot").value(DEFAULT_DATE_DEPOT.toString()))
            .andExpect(jsonPath("$.heuredepot").value(DEFAULT_HEUREDEPOT.toString()))
            .andExpect(jsonPath("$.rabais").value(DEFAULT_RABAIS))
            .andExpect(jsonPath("$.scoreTechnique").value(DEFAULT_SCORE_TECHNIQUE))
            .andExpect(jsonPath("$.seuilAtteint").value(DEFAULT_SEUIL_ATTEINT))
            .andExpect(jsonPath("$.classemenTechnique").value(DEFAULT_CLASSEMEN_TECHNIQUE))
            .andExpect(jsonPath("$.classementGeneral").value(DEFAULT_CLASSEMENT_GENERAL))
            .andExpect(jsonPath("$.candidatRestreintID").value(DEFAULT_CANDIDAT_RESTREINT_ID))
            .andExpect(jsonPath("$.etatPreselection").value(DEFAULT_ETAT_PRESELECTION))
            .andExpect(jsonPath("$.etatExamenPreliminaire").value(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE))
            .andExpect(jsonPath("$.critereQualification").value(DEFAULT_CRITERE_QUALIFICATION))
            .andExpect(jsonPath("$.attributaireProvisoire").value(DEFAULT_ATTRIBUTAIRE_PROVISOIRE))
            .andExpect(jsonPath("$.offreTechnique").value(DEFAULT_OFFRE_TECHNIQUE))
            .andExpect(jsonPath("$.offreFinanciere").value(DEFAULT_OFFRE_FINANCIERE))
            .andExpect(jsonPath("$.lettreSoumission").value(DEFAULT_LETTRE_SOUMISSION))
            .andExpect(jsonPath("$.valide").value(DEFAULT_VALIDE))
            .andExpect(jsonPath("$.numero").value(DEFAULT_NUMERO))
            .andExpect(jsonPath("$.garantie").value(DEFAULT_GARANTIE))
            .andExpect(jsonPath("$.pieceRequise").value(DEFAULT_PIECE_REQUISE))
            .andExpect(jsonPath("$.observationsOffres").value(DEFAULT_OBSERVATIONS_OFFRES))
            .andExpect(jsonPath("$.observationsCandidats").value(DEFAULT_OBSERVATIONS_CANDIDATS))
            .andExpect(jsonPath("$.modeReception").value(DEFAULT_MODE_RECEPTION))
            .andExpect(jsonPath("$.notifie").value(DEFAULT_NOTIFIE))
            .andExpect(jsonPath("$.signatureOffre").value(DEFAULT_SIGNATURE_OFFRE))
            .andExpect(jsonPath("$.exhaustivite").value(DEFAULT_EXHAUSTIVITE))
            .andExpect(jsonPath("$.garantieSoumission").value(DEFAULT_GARANTIE_SOUMISSION))
            .andExpect(jsonPath("$.conformite").value(DEFAULT_CONFORMITE))
            .andExpect(jsonPath("$.critereProvenance").value(DEFAULT_CRITERE_PROVENANCE))
            .andExpect(jsonPath("$.notePreselectionne").value(DEFAULT_NOTE_PRESELECTIONNE.intValue()))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()))
            .andExpect(jsonPath("$.ajustement").value(DEFAULT_AJUSTEMENT.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingPlisOuverture() throws Exception {
        // Get the plisOuverture
        restPlisOuvertureMockMvc.perform(get("/api/plis-ouvertures/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePlisOuverture() throws Exception {
        // Initialize the database
        plisOuvertureRepository.saveAndFlush(plisOuverture);

        int databaseSizeBeforeUpdate = plisOuvertureRepository.findAll().size();

        // Update the plisOuverture
        PlisOuverture updatedPlisOuverture = plisOuvertureRepository.findById(plisOuverture.getId()).get();
        // Disconnect from session so that the updates on updatedPlisOuverture are not directly saved in db
        em.detach(updatedPlisOuverture);
        updatedPlisOuverture
            .raisonSociale(UPDATED_RAISON_SOCIALE)
            .adresseMail(UPDATED_ADRESSE_MAIL)
            .commentaire(UPDATED_COMMENTAIRE)
            .rang(UPDATED_RANG)
            .ninea(UPDATED_NINEA)
            .natCode(UPDATED_NAT_CODE)
            .monCode(UPDATED_MON_CODE)
            .pvOffreFinanciere(UPDATED_PV_OFFRE_FINANCIERE)
            .negociation(UPDATED_NEGOCIATION)
            .montantOffert(UPDATED_MONTANT_OFFERT)
            .scoreFinancier(UPDATED_SCORE_FINANCIER)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .scoreTechniquePondere(UPDATED_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(UPDATED_SCORE_FINANCIER_PONDERE)
            .scoreFinal(UPDATED_SCORE_FINAL)
            .montantDefinitif(UPDATED_MONTANT_DEFINITIF)
            .montantTVA(UPDATED_MONTANT_TVA)
            .montantDouane(UPDATED_MONTANT_DOUANE)
            .dateDepot(UPDATED_DATE_DEPOT)
            .heuredepot(UPDATED_HEUREDEPOT)
            .rabais(UPDATED_RABAIS)
            .scoreTechnique(UPDATED_SCORE_TECHNIQUE)
            .seuilAtteint(UPDATED_SEUIL_ATTEINT)
            .classemenTechnique(UPDATED_CLASSEMEN_TECHNIQUE)
            .classementGeneral(UPDATED_CLASSEMENT_GENERAL)
            .candidatRestreintID(UPDATED_CANDIDAT_RESTREINT_ID)
            .etatPreselection(UPDATED_ETAT_PRESELECTION)
            .etatExamenPreliminaire(UPDATED_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .offreTechnique(UPDATED_OFFRE_TECHNIQUE)
            .offreFinanciere(UPDATED_OFFRE_FINANCIERE)
            .lettreSoumission(UPDATED_LETTRE_SOUMISSION)
            .valide(UPDATED_VALIDE)
            .numero(UPDATED_NUMERO)
            .garantie(UPDATED_GARANTIE)
            .pieceRequise(UPDATED_PIECE_REQUISE)
            .observationsOffres(UPDATED_OBSERVATIONS_OFFRES)
            .observationsCandidats(UPDATED_OBSERVATIONS_CANDIDATS)
            .modeReception(UPDATED_MODE_RECEPTION)
            .notifie(UPDATED_NOTIFIE)
            .signatureOffre(UPDATED_SIGNATURE_OFFRE)
            .exhaustivite(UPDATED_EXHAUSTIVITE)
            .garantieSoumission(UPDATED_GARANTIE_SOUMISSION)
            .conformite(UPDATED_CONFORMITE)
            .critereProvenance(UPDATED_CRITERE_PROVENANCE)
            .notePreselectionne(UPDATED_NOTE_PRESELECTIONNE)
            .autoriteId(UPDATED_AUTORITE_ID)
            .ajustement(UPDATED_AJUSTEMENT);
        PlisOuvertureDTO plisOuvertureDTO = plisOuvertureMapper.toDto(updatedPlisOuverture);

        restPlisOuvertureMockMvc.perform(put("/api/plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(plisOuvertureDTO)))
            .andExpect(status().isOk());

        // Validate the PlisOuverture in the database
        List<PlisOuverture> plisOuvertureList = plisOuvertureRepository.findAll();
        assertThat(plisOuvertureList).hasSize(databaseSizeBeforeUpdate);
        PlisOuverture testPlisOuverture = plisOuvertureList.get(plisOuvertureList.size() - 1);
        assertThat(testPlisOuverture.getRaisonSociale()).isEqualTo(UPDATED_RAISON_SOCIALE);
        assertThat(testPlisOuverture.getAdresseMail()).isEqualTo(UPDATED_ADRESSE_MAIL);
        assertThat(testPlisOuverture.getCommentaire()).isEqualTo(UPDATED_COMMENTAIRE);
        assertThat(testPlisOuverture.getRang()).isEqualTo(UPDATED_RANG);
        assertThat(testPlisOuverture.getNinea()).isEqualTo(UPDATED_NINEA);
        assertThat(testPlisOuverture.getNatCode()).isEqualTo(UPDATED_NAT_CODE);
        assertThat(testPlisOuverture.getMonCode()).isEqualTo(UPDATED_MON_CODE);
        assertThat(testPlisOuverture.getPvOffreFinanciere()).isEqualTo(UPDATED_PV_OFFRE_FINANCIERE);
        assertThat(testPlisOuverture.getNegociation()).isEqualTo(UPDATED_NEGOCIATION);
        assertThat(testPlisOuverture.getMontantOffert()).isEqualTo(UPDATED_MONTANT_OFFERT);
        assertThat(testPlisOuverture.getScoreFinancier()).isEqualTo(UPDATED_SCORE_FINANCIER);
        assertThat(testPlisOuverture.getPrixEvalue()).isEqualTo(UPDATED_PRIX_EVALUE);
        assertThat(testPlisOuverture.getScoreTechniquePondere()).isEqualTo(UPDATED_SCORE_TECHNIQUE_PONDERE);
        assertThat(testPlisOuverture.getScoreFinancierPondere()).isEqualTo(UPDATED_SCORE_FINANCIER_PONDERE);
        assertThat(testPlisOuverture.getScoreFinal()).isEqualTo(UPDATED_SCORE_FINAL);
        assertThat(testPlisOuverture.getMontantDefinitif()).isEqualTo(UPDATED_MONTANT_DEFINITIF);
        assertThat(testPlisOuverture.getMontantTVA()).isEqualTo(UPDATED_MONTANT_TVA);
        assertThat(testPlisOuverture.getMontantDouane()).isEqualTo(UPDATED_MONTANT_DOUANE);
        assertThat(testPlisOuverture.getDateDepot()).isEqualTo(UPDATED_DATE_DEPOT);
        assertThat(testPlisOuverture.getHeuredepot()).isEqualTo(UPDATED_HEUREDEPOT);
        assertThat(testPlisOuverture.getRabais()).isEqualTo(UPDATED_RABAIS);
        assertThat(testPlisOuverture.getScoreTechnique()).isEqualTo(UPDATED_SCORE_TECHNIQUE);
        assertThat(testPlisOuverture.getSeuilAtteint()).isEqualTo(UPDATED_SEUIL_ATTEINT);
        assertThat(testPlisOuverture.getClassemenTechnique()).isEqualTo(UPDATED_CLASSEMEN_TECHNIQUE);
        assertThat(testPlisOuverture.getClassementGeneral()).isEqualTo(UPDATED_CLASSEMENT_GENERAL);
        assertThat(testPlisOuverture.getCandidatRestreintID()).isEqualTo(UPDATED_CANDIDAT_RESTREINT_ID);
        assertThat(testPlisOuverture.getEtatPreselection()).isEqualTo(UPDATED_ETAT_PRESELECTION);
        assertThat(testPlisOuverture.getEtatExamenPreliminaire()).isEqualTo(UPDATED_ETAT_EXAMEN_PRELIMINAIRE);
        assertThat(testPlisOuverture.getCritereQualification()).isEqualTo(UPDATED_CRITERE_QUALIFICATION);
        assertThat(testPlisOuverture.getAttributaireProvisoire()).isEqualTo(UPDATED_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testPlisOuverture.getOffreTechnique()).isEqualTo(UPDATED_OFFRE_TECHNIQUE);
        assertThat(testPlisOuverture.getOffreFinanciere()).isEqualTo(UPDATED_OFFRE_FINANCIERE);
        assertThat(testPlisOuverture.getLettreSoumission()).isEqualTo(UPDATED_LETTRE_SOUMISSION);
        assertThat(testPlisOuverture.getValide()).isEqualTo(UPDATED_VALIDE);
        assertThat(testPlisOuverture.getNumero()).isEqualTo(UPDATED_NUMERO);
        assertThat(testPlisOuverture.getGarantie()).isEqualTo(UPDATED_GARANTIE);
        assertThat(testPlisOuverture.getPieceRequise()).isEqualTo(UPDATED_PIECE_REQUISE);
        assertThat(testPlisOuverture.getObservationsOffres()).isEqualTo(UPDATED_OBSERVATIONS_OFFRES);
        assertThat(testPlisOuverture.getObservationsCandidats()).isEqualTo(UPDATED_OBSERVATIONS_CANDIDATS);
        assertThat(testPlisOuverture.getModeReception()).isEqualTo(UPDATED_MODE_RECEPTION);
        assertThat(testPlisOuverture.getNotifie()).isEqualTo(UPDATED_NOTIFIE);
        assertThat(testPlisOuverture.getSignatureOffre()).isEqualTo(UPDATED_SIGNATURE_OFFRE);
        assertThat(testPlisOuverture.getExhaustivite()).isEqualTo(UPDATED_EXHAUSTIVITE);
        assertThat(testPlisOuverture.getGarantieSoumission()).isEqualTo(UPDATED_GARANTIE_SOUMISSION);
        assertThat(testPlisOuverture.getConformite()).isEqualTo(UPDATED_CONFORMITE);
        assertThat(testPlisOuverture.getCritereProvenance()).isEqualTo(UPDATED_CRITERE_PROVENANCE);
        assertThat(testPlisOuverture.getNotePreselectionne()).isEqualTo(UPDATED_NOTE_PRESELECTIONNE);
        assertThat(testPlisOuverture.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
        assertThat(testPlisOuverture.getAjustement()).isEqualTo(UPDATED_AJUSTEMENT);
    }

    @Test
    @Transactional
    public void updateNonExistingPlisOuverture() throws Exception {
        int databaseSizeBeforeUpdate = plisOuvertureRepository.findAll().size();

        // Create the PlisOuverture
        PlisOuvertureDTO plisOuvertureDTO = plisOuvertureMapper.toDto(plisOuverture);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPlisOuvertureMockMvc.perform(put("/api/plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(plisOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PlisOuverture in the database
        List<PlisOuverture> plisOuvertureList = plisOuvertureRepository.findAll();
        assertThat(plisOuvertureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePlisOuverture() throws Exception {
        // Initialize the database
        plisOuvertureRepository.saveAndFlush(plisOuverture);

        int databaseSizeBeforeDelete = plisOuvertureRepository.findAll().size();

        // Delete the plisOuverture
        restPlisOuvertureMockMvc.perform(delete("/api/plis-ouvertures/{id}", plisOuverture.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PlisOuverture> plisOuvertureList = plisOuvertureRepository.findAll();
        assertThat(plisOuvertureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
