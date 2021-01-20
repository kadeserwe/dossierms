package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.LotsSoumissionnaire;
import sn.ssi.sigmap.repository.LotsSoumissionnaireRepository;
import sn.ssi.sigmap.service.LotsSoumissionnaireService;
import sn.ssi.sigmap.service.dto.LotsSoumissionnaireDTO;
import sn.ssi.sigmap.service.mapper.LotsSoumissionnaireMapper;

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
 * Integration tests for the {@link LotsSoumissionnaireResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class LotsSoumissionnaireResourceIT {

    private static final String DEFAULT_RAISONSOCIALE = "AAAAAAAAAA";
    private static final String UPDATED_RAISONSOCIALE = "BBBBBBBBBB";

    private static final String DEFAULT_NUMERO = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_LOTSOUMIS = "AAAAAAAAAA";
    private static final String UPDATED_LOTSOUMIS = "BBBBBBBBBB";

    private static final String DEFAULT_LOTRECU = "AAAAAAAAAA";
    private static final String UPDATED_LOTRECU = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_ELIMINE = "AAAAAAAAAA";
    private static final String UPDATED_ELIMINE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MONTANT_OFFERT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_OFFERT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_DEFINITIF = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_DEFINITIF = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_GARANTIE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_GARANTIE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_TVA = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_TVA = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_DOUANE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_DOUANE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_TTC = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_TTC = new BigDecimal(2);

    private static final Integer DEFAULT_RABAIS = 1;
    private static final Integer UPDATED_RABAIS = 2;

    private static final Integer DEFAULT_RANG = 1;
    private static final Integer UPDATED_RANG = 2;

    private static final BigDecimal DEFAULT_SCORE_TECHNIQUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_SCORE_TECHNIQUE = new BigDecimal(2);

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

    private static final LocalDate DEFAULT_DATE_DEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_CLASSEMENT_GENERAL = 1;
    private static final Integer UPDATED_CLASSEMENT_GENERAL = 2;

    private static final Integer DEFAULT_CLASSEMEN_TECHNIQUE = 1;
    private static final Integer UPDATED_CLASSEMEN_TECHNIQUE = 2;

    private static final Integer DEFAULT_ETAT_PRESELECTION = 1;
    private static final Integer UPDATED_ETAT_PRESELECTION = 2;

    private static final Integer DEFAULT_ETAT_EXAMEN_PRELIMINAIRE = 1;
    private static final Integer UPDATED_ETAT_EXAMEN_PRELIMINAIRE = 2;

    private static final Integer DEFAULT_CRITERE_QUALIFICATION = 1;
    private static final Integer UPDATED_CRITERE_QUALIFICATION = 2;

    private static final Integer DEFAULT_ATTRIBUTAIRE_PROVISOIRE = 1;
    private static final Integer UPDATED_ATTRIBUTAIRE_PROVISOIRE = 2;

    private static final Integer DEFAULT_PLIL_VALIDE = 1;
    private static final Integer UPDATED_PLIL_VALIDE = 2;

    private static final Integer DEFAULT_LETTRE_SOUMISSION = 1;
    private static final Integer UPDATED_LETTRE_SOUMISSION = 2;

    private static final Integer DEFAULT_OFFRE_TECHNIQUE = 1;
    private static final Integer UPDATED_OFFRE_TECHNIQUE = 2;

    private static final Integer DEFAULT_OFFRE_FINANCIERE = 1;
    private static final Integer UPDATED_OFFRE_FINANCIERE = 2;

    private static final Integer DEFAULT_PLINUMERO = 1;
    private static final Integer UPDATED_PLINUMERO = 2;

    @Autowired
    private LotsSoumissionnaireRepository lotsSoumissionnaireRepository;

    @Autowired
    private LotsSoumissionnaireMapper lotsSoumissionnaireMapper;

    @Autowired
    private LotsSoumissionnaireService lotsSoumissionnaireService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restLotsSoumissionnaireMockMvc;

    private LotsSoumissionnaire lotsSoumissionnaire;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static LotsSoumissionnaire createEntity(EntityManager em) {
        LotsSoumissionnaire lotsSoumissionnaire = new LotsSoumissionnaire()
            .raisonsociale(DEFAULT_RAISONSOCIALE)
            .numero(DEFAULT_NUMERO)
            .email(DEFAULT_EMAIL)
            .commentaire(DEFAULT_COMMENTAIRE)
            .lotsoumis(DEFAULT_LOTSOUMIS)
            .lotrecu(DEFAULT_LOTRECU)
            .libelle(DEFAULT_LIBELLE)
            .elimine(DEFAULT_ELIMINE)
            .montantOffert(DEFAULT_MONTANT_OFFERT)
            .montantDefinitif(DEFAULT_MONTANT_DEFINITIF)
            .montantGarantie(DEFAULT_MONTANT_GARANTIE)
            .montantTVA(DEFAULT_MONTANT_TVA)
            .montantDouane(DEFAULT_MONTANT_DOUANE)
            .montantTTC(DEFAULT_MONTANT_TTC)
            .rabais(DEFAULT_RABAIS)
            .rang(DEFAULT_RANG)
            .scoreTechnique(DEFAULT_SCORE_TECHNIQUE)
            .scoreFinancier(DEFAULT_SCORE_FINANCIER)
            .prixEvalue(DEFAULT_PRIX_EVALUE)
            .scoreTechniquePondere(DEFAULT_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(DEFAULT_SCORE_FINANCIER_PONDERE)
            .scoreFinal(DEFAULT_SCORE_FINAL)
            .dateDepot(DEFAULT_DATE_DEPOT)
            .classementGeneral(DEFAULT_CLASSEMENT_GENERAL)
            .classemenTechnique(DEFAULT_CLASSEMEN_TECHNIQUE)
            .etatPreselection(DEFAULT_ETAT_PRESELECTION)
            .etatExamenPreliminaire(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(DEFAULT_CRITERE_QUALIFICATION)
            .attributaireProvisoire(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)
            .plilValide(DEFAULT_PLIL_VALIDE)
            .lettreSoumission(DEFAULT_LETTRE_SOUMISSION)
            .offreTechnique(DEFAULT_OFFRE_TECHNIQUE)
            .offreFinanciere(DEFAULT_OFFRE_FINANCIERE)
            .plinumero(DEFAULT_PLINUMERO);
        return lotsSoumissionnaire;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static LotsSoumissionnaire createUpdatedEntity(EntityManager em) {
        LotsSoumissionnaire lotsSoumissionnaire = new LotsSoumissionnaire()
            .raisonsociale(UPDATED_RAISONSOCIALE)
            .numero(UPDATED_NUMERO)
            .email(UPDATED_EMAIL)
            .commentaire(UPDATED_COMMENTAIRE)
            .lotsoumis(UPDATED_LOTSOUMIS)
            .lotrecu(UPDATED_LOTRECU)
            .libelle(UPDATED_LIBELLE)
            .elimine(UPDATED_ELIMINE)
            .montantOffert(UPDATED_MONTANT_OFFERT)
            .montantDefinitif(UPDATED_MONTANT_DEFINITIF)
            .montantGarantie(UPDATED_MONTANT_GARANTIE)
            .montantTVA(UPDATED_MONTANT_TVA)
            .montantDouane(UPDATED_MONTANT_DOUANE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .rabais(UPDATED_RABAIS)
            .rang(UPDATED_RANG)
            .scoreTechnique(UPDATED_SCORE_TECHNIQUE)
            .scoreFinancier(UPDATED_SCORE_FINANCIER)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .scoreTechniquePondere(UPDATED_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(UPDATED_SCORE_FINANCIER_PONDERE)
            .scoreFinal(UPDATED_SCORE_FINAL)
            .dateDepot(UPDATED_DATE_DEPOT)
            .classementGeneral(UPDATED_CLASSEMENT_GENERAL)
            .classemenTechnique(UPDATED_CLASSEMEN_TECHNIQUE)
            .etatPreselection(UPDATED_ETAT_PRESELECTION)
            .etatExamenPreliminaire(UPDATED_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .plilValide(UPDATED_PLIL_VALIDE)
            .lettreSoumission(UPDATED_LETTRE_SOUMISSION)
            .offreTechnique(UPDATED_OFFRE_TECHNIQUE)
            .offreFinanciere(UPDATED_OFFRE_FINANCIERE)
            .plinumero(UPDATED_PLINUMERO);
        return lotsSoumissionnaire;
    }

    @BeforeEach
    public void initTest() {
        lotsSoumissionnaire = createEntity(em);
    }

    @Test
    @Transactional
    public void createLotsSoumissionnaire() throws Exception {
        int databaseSizeBeforeCreate = lotsSoumissionnaireRepository.findAll().size();
        // Create the LotsSoumissionnaire
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO = lotsSoumissionnaireMapper.toDto(lotsSoumissionnaire);
        restLotsSoumissionnaireMockMvc.perform(post("/api/lots-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(lotsSoumissionnaireDTO)))
            .andExpect(status().isCreated());

        // Validate the LotsSoumissionnaire in the database
        List<LotsSoumissionnaire> lotsSoumissionnaireList = lotsSoumissionnaireRepository.findAll();
        assertThat(lotsSoumissionnaireList).hasSize(databaseSizeBeforeCreate + 1);
        LotsSoumissionnaire testLotsSoumissionnaire = lotsSoumissionnaireList.get(lotsSoumissionnaireList.size() - 1);
        assertThat(testLotsSoumissionnaire.getRaisonsociale()).isEqualTo(DEFAULT_RAISONSOCIALE);
        assertThat(testLotsSoumissionnaire.getNumero()).isEqualTo(DEFAULT_NUMERO);
        assertThat(testLotsSoumissionnaire.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testLotsSoumissionnaire.getCommentaire()).isEqualTo(DEFAULT_COMMENTAIRE);
        assertThat(testLotsSoumissionnaire.getLotsoumis()).isEqualTo(DEFAULT_LOTSOUMIS);
        assertThat(testLotsSoumissionnaire.getLotrecu()).isEqualTo(DEFAULT_LOTRECU);
        assertThat(testLotsSoumissionnaire.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testLotsSoumissionnaire.getElimine()).isEqualTo(DEFAULT_ELIMINE);
        assertThat(testLotsSoumissionnaire.getMontantOffert()).isEqualTo(DEFAULT_MONTANT_OFFERT);
        assertThat(testLotsSoumissionnaire.getMontantDefinitif()).isEqualTo(DEFAULT_MONTANT_DEFINITIF);
        assertThat(testLotsSoumissionnaire.getMontantGarantie()).isEqualTo(DEFAULT_MONTANT_GARANTIE);
        assertThat(testLotsSoumissionnaire.getMontantTVA()).isEqualTo(DEFAULT_MONTANT_TVA);
        assertThat(testLotsSoumissionnaire.getMontantDouane()).isEqualTo(DEFAULT_MONTANT_DOUANE);
        assertThat(testLotsSoumissionnaire.getMontantTTC()).isEqualTo(DEFAULT_MONTANT_TTC);
        assertThat(testLotsSoumissionnaire.getRabais()).isEqualTo(DEFAULT_RABAIS);
        assertThat(testLotsSoumissionnaire.getRang()).isEqualTo(DEFAULT_RANG);
        assertThat(testLotsSoumissionnaire.getScoreTechnique()).isEqualTo(DEFAULT_SCORE_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getScoreFinancier()).isEqualTo(DEFAULT_SCORE_FINANCIER);
        assertThat(testLotsSoumissionnaire.getPrixEvalue()).isEqualTo(DEFAULT_PRIX_EVALUE);
        assertThat(testLotsSoumissionnaire.getScoreTechniquePondere()).isEqualTo(DEFAULT_SCORE_TECHNIQUE_PONDERE);
        assertThat(testLotsSoumissionnaire.getScoreFinancierPondere()).isEqualTo(DEFAULT_SCORE_FINANCIER_PONDERE);
        assertThat(testLotsSoumissionnaire.getScoreFinal()).isEqualTo(DEFAULT_SCORE_FINAL);
        assertThat(testLotsSoumissionnaire.getDateDepot()).isEqualTo(DEFAULT_DATE_DEPOT);
        assertThat(testLotsSoumissionnaire.getClassementGeneral()).isEqualTo(DEFAULT_CLASSEMENT_GENERAL);
        assertThat(testLotsSoumissionnaire.getClassemenTechnique()).isEqualTo(DEFAULT_CLASSEMEN_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getEtatPreselection()).isEqualTo(DEFAULT_ETAT_PRESELECTION);
        assertThat(testLotsSoumissionnaire.getEtatExamenPreliminaire()).isEqualTo(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE);
        assertThat(testLotsSoumissionnaire.getCritereQualification()).isEqualTo(DEFAULT_CRITERE_QUALIFICATION);
        assertThat(testLotsSoumissionnaire.getAttributaireProvisoire()).isEqualTo(DEFAULT_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testLotsSoumissionnaire.getPlilValide()).isEqualTo(DEFAULT_PLIL_VALIDE);
        assertThat(testLotsSoumissionnaire.getLettreSoumission()).isEqualTo(DEFAULT_LETTRE_SOUMISSION);
        assertThat(testLotsSoumissionnaire.getOffreTechnique()).isEqualTo(DEFAULT_OFFRE_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getOffreFinanciere()).isEqualTo(DEFAULT_OFFRE_FINANCIERE);
        assertThat(testLotsSoumissionnaire.getPlinumero()).isEqualTo(DEFAULT_PLINUMERO);
    }

    @Test
    @Transactional
    public void createLotsSoumissionnaireWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = lotsSoumissionnaireRepository.findAll().size();

        // Create the LotsSoumissionnaire with an existing ID
        lotsSoumissionnaire.setId(1L);
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO = lotsSoumissionnaireMapper.toDto(lotsSoumissionnaire);

        // An entity with an existing ID cannot be created, so this API call must fail
        restLotsSoumissionnaireMockMvc.perform(post("/api/lots-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(lotsSoumissionnaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the LotsSoumissionnaire in the database
        List<LotsSoumissionnaire> lotsSoumissionnaireList = lotsSoumissionnaireRepository.findAll();
        assertThat(lotsSoumissionnaireList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllLotsSoumissionnaires() throws Exception {
        // Initialize the database
        lotsSoumissionnaireRepository.saveAndFlush(lotsSoumissionnaire);

        // Get all the lotsSoumissionnaireList
        restLotsSoumissionnaireMockMvc.perform(get("/api/lots-soumissionnaires?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(lotsSoumissionnaire.getId().intValue())))
            .andExpect(jsonPath("$.[*].raisonsociale").value(hasItem(DEFAULT_RAISONSOCIALE)))
            .andExpect(jsonPath("$.[*].numero").value(hasItem(DEFAULT_NUMERO)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].commentaire").value(hasItem(DEFAULT_COMMENTAIRE)))
            .andExpect(jsonPath("$.[*].lotsoumis").value(hasItem(DEFAULT_LOTSOUMIS)))
            .andExpect(jsonPath("$.[*].lotrecu").value(hasItem(DEFAULT_LOTRECU)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].elimine").value(hasItem(DEFAULT_ELIMINE)))
            .andExpect(jsonPath("$.[*].montantOffert").value(hasItem(DEFAULT_MONTANT_OFFERT.intValue())))
            .andExpect(jsonPath("$.[*].montantDefinitif").value(hasItem(DEFAULT_MONTANT_DEFINITIF.intValue())))
            .andExpect(jsonPath("$.[*].montantGarantie").value(hasItem(DEFAULT_MONTANT_GARANTIE.intValue())))
            .andExpect(jsonPath("$.[*].montantTVA").value(hasItem(DEFAULT_MONTANT_TVA.intValue())))
            .andExpect(jsonPath("$.[*].montantDouane").value(hasItem(DEFAULT_MONTANT_DOUANE.intValue())))
            .andExpect(jsonPath("$.[*].montantTTC").value(hasItem(DEFAULT_MONTANT_TTC.intValue())))
            .andExpect(jsonPath("$.[*].rabais").value(hasItem(DEFAULT_RABAIS)))
            .andExpect(jsonPath("$.[*].rang").value(hasItem(DEFAULT_RANG)))
            .andExpect(jsonPath("$.[*].scoreTechnique").value(hasItem(DEFAULT_SCORE_TECHNIQUE.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinancier").value(hasItem(DEFAULT_SCORE_FINANCIER.intValue())))
            .andExpect(jsonPath("$.[*].prixEvalue").value(hasItem(DEFAULT_PRIX_EVALUE.intValue())))
            .andExpect(jsonPath("$.[*].scoreTechniquePondere").value(hasItem(DEFAULT_SCORE_TECHNIQUE_PONDERE.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinancierPondere").value(hasItem(DEFAULT_SCORE_FINANCIER_PONDERE.intValue())))
            .andExpect(jsonPath("$.[*].scoreFinal").value(hasItem(DEFAULT_SCORE_FINAL.intValue())))
            .andExpect(jsonPath("$.[*].dateDepot").value(hasItem(DEFAULT_DATE_DEPOT.toString())))
            .andExpect(jsonPath("$.[*].classementGeneral").value(hasItem(DEFAULT_CLASSEMENT_GENERAL)))
            .andExpect(jsonPath("$.[*].classemenTechnique").value(hasItem(DEFAULT_CLASSEMEN_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].etatPreselection").value(hasItem(DEFAULT_ETAT_PRESELECTION)))
            .andExpect(jsonPath("$.[*].etatExamenPreliminaire").value(hasItem(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE)))
            .andExpect(jsonPath("$.[*].critereQualification").value(hasItem(DEFAULT_CRITERE_QUALIFICATION)))
            .andExpect(jsonPath("$.[*].attributaireProvisoire").value(hasItem(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].plilValide").value(hasItem(DEFAULT_PLIL_VALIDE)))
            .andExpect(jsonPath("$.[*].lettreSoumission").value(hasItem(DEFAULT_LETTRE_SOUMISSION)))
            .andExpect(jsonPath("$.[*].offreTechnique").value(hasItem(DEFAULT_OFFRE_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].offreFinanciere").value(hasItem(DEFAULT_OFFRE_FINANCIERE)))
            .andExpect(jsonPath("$.[*].plinumero").value(hasItem(DEFAULT_PLINUMERO)));
    }
    
    @Test
    @Transactional
    public void getLotsSoumissionnaire() throws Exception {
        // Initialize the database
        lotsSoumissionnaireRepository.saveAndFlush(lotsSoumissionnaire);

        // Get the lotsSoumissionnaire
        restLotsSoumissionnaireMockMvc.perform(get("/api/lots-soumissionnaires/{id}", lotsSoumissionnaire.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(lotsSoumissionnaire.getId().intValue()))
            .andExpect(jsonPath("$.raisonsociale").value(DEFAULT_RAISONSOCIALE))
            .andExpect(jsonPath("$.numero").value(DEFAULT_NUMERO))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.commentaire").value(DEFAULT_COMMENTAIRE))
            .andExpect(jsonPath("$.lotsoumis").value(DEFAULT_LOTSOUMIS))
            .andExpect(jsonPath("$.lotrecu").value(DEFAULT_LOTRECU))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.elimine").value(DEFAULT_ELIMINE))
            .andExpect(jsonPath("$.montantOffert").value(DEFAULT_MONTANT_OFFERT.intValue()))
            .andExpect(jsonPath("$.montantDefinitif").value(DEFAULT_MONTANT_DEFINITIF.intValue()))
            .andExpect(jsonPath("$.montantGarantie").value(DEFAULT_MONTANT_GARANTIE.intValue()))
            .andExpect(jsonPath("$.montantTVA").value(DEFAULT_MONTANT_TVA.intValue()))
            .andExpect(jsonPath("$.montantDouane").value(DEFAULT_MONTANT_DOUANE.intValue()))
            .andExpect(jsonPath("$.montantTTC").value(DEFAULT_MONTANT_TTC.intValue()))
            .andExpect(jsonPath("$.rabais").value(DEFAULT_RABAIS))
            .andExpect(jsonPath("$.rang").value(DEFAULT_RANG))
            .andExpect(jsonPath("$.scoreTechnique").value(DEFAULT_SCORE_TECHNIQUE.intValue()))
            .andExpect(jsonPath("$.scoreFinancier").value(DEFAULT_SCORE_FINANCIER.intValue()))
            .andExpect(jsonPath("$.prixEvalue").value(DEFAULT_PRIX_EVALUE.intValue()))
            .andExpect(jsonPath("$.scoreTechniquePondere").value(DEFAULT_SCORE_TECHNIQUE_PONDERE.intValue()))
            .andExpect(jsonPath("$.scoreFinancierPondere").value(DEFAULT_SCORE_FINANCIER_PONDERE.intValue()))
            .andExpect(jsonPath("$.scoreFinal").value(DEFAULT_SCORE_FINAL.intValue()))
            .andExpect(jsonPath("$.dateDepot").value(DEFAULT_DATE_DEPOT.toString()))
            .andExpect(jsonPath("$.classementGeneral").value(DEFAULT_CLASSEMENT_GENERAL))
            .andExpect(jsonPath("$.classemenTechnique").value(DEFAULT_CLASSEMEN_TECHNIQUE))
            .andExpect(jsonPath("$.etatPreselection").value(DEFAULT_ETAT_PRESELECTION))
            .andExpect(jsonPath("$.etatExamenPreliminaire").value(DEFAULT_ETAT_EXAMEN_PRELIMINAIRE))
            .andExpect(jsonPath("$.critereQualification").value(DEFAULT_CRITERE_QUALIFICATION))
            .andExpect(jsonPath("$.attributaireProvisoire").value(DEFAULT_ATTRIBUTAIRE_PROVISOIRE))
            .andExpect(jsonPath("$.plilValide").value(DEFAULT_PLIL_VALIDE))
            .andExpect(jsonPath("$.lettreSoumission").value(DEFAULT_LETTRE_SOUMISSION))
            .andExpect(jsonPath("$.offreTechnique").value(DEFAULT_OFFRE_TECHNIQUE))
            .andExpect(jsonPath("$.offreFinanciere").value(DEFAULT_OFFRE_FINANCIERE))
            .andExpect(jsonPath("$.plinumero").value(DEFAULT_PLINUMERO));
    }
    @Test
    @Transactional
    public void getNonExistingLotsSoumissionnaire() throws Exception {
        // Get the lotsSoumissionnaire
        restLotsSoumissionnaireMockMvc.perform(get("/api/lots-soumissionnaires/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateLotsSoumissionnaire() throws Exception {
        // Initialize the database
        lotsSoumissionnaireRepository.saveAndFlush(lotsSoumissionnaire);

        int databaseSizeBeforeUpdate = lotsSoumissionnaireRepository.findAll().size();

        // Update the lotsSoumissionnaire
        LotsSoumissionnaire updatedLotsSoumissionnaire = lotsSoumissionnaireRepository.findById(lotsSoumissionnaire.getId()).get();
        // Disconnect from session so that the updates on updatedLotsSoumissionnaire are not directly saved in db
        em.detach(updatedLotsSoumissionnaire);
        updatedLotsSoumissionnaire
            .raisonsociale(UPDATED_RAISONSOCIALE)
            .numero(UPDATED_NUMERO)
            .email(UPDATED_EMAIL)
            .commentaire(UPDATED_COMMENTAIRE)
            .lotsoumis(UPDATED_LOTSOUMIS)
            .lotrecu(UPDATED_LOTRECU)
            .libelle(UPDATED_LIBELLE)
            .elimine(UPDATED_ELIMINE)
            .montantOffert(UPDATED_MONTANT_OFFERT)
            .montantDefinitif(UPDATED_MONTANT_DEFINITIF)
            .montantGarantie(UPDATED_MONTANT_GARANTIE)
            .montantTVA(UPDATED_MONTANT_TVA)
            .montantDouane(UPDATED_MONTANT_DOUANE)
            .montantTTC(UPDATED_MONTANT_TTC)
            .rabais(UPDATED_RABAIS)
            .rang(UPDATED_RANG)
            .scoreTechnique(UPDATED_SCORE_TECHNIQUE)
            .scoreFinancier(UPDATED_SCORE_FINANCIER)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .scoreTechniquePondere(UPDATED_SCORE_TECHNIQUE_PONDERE)
            .scoreFinancierPondere(UPDATED_SCORE_FINANCIER_PONDERE)
            .scoreFinal(UPDATED_SCORE_FINAL)
            .dateDepot(UPDATED_DATE_DEPOT)
            .classementGeneral(UPDATED_CLASSEMENT_GENERAL)
            .classemenTechnique(UPDATED_CLASSEMEN_TECHNIQUE)
            .etatPreselection(UPDATED_ETAT_PRESELECTION)
            .etatExamenPreliminaire(UPDATED_ETAT_EXAMEN_PRELIMINAIRE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .plilValide(UPDATED_PLIL_VALIDE)
            .lettreSoumission(UPDATED_LETTRE_SOUMISSION)
            .offreTechnique(UPDATED_OFFRE_TECHNIQUE)
            .offreFinanciere(UPDATED_OFFRE_FINANCIERE)
            .plinumero(UPDATED_PLINUMERO);
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO = lotsSoumissionnaireMapper.toDto(updatedLotsSoumissionnaire);

        restLotsSoumissionnaireMockMvc.perform(put("/api/lots-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(lotsSoumissionnaireDTO)))
            .andExpect(status().isOk());

        // Validate the LotsSoumissionnaire in the database
        List<LotsSoumissionnaire> lotsSoumissionnaireList = lotsSoumissionnaireRepository.findAll();
        assertThat(lotsSoumissionnaireList).hasSize(databaseSizeBeforeUpdate);
        LotsSoumissionnaire testLotsSoumissionnaire = lotsSoumissionnaireList.get(lotsSoumissionnaireList.size() - 1);
        assertThat(testLotsSoumissionnaire.getRaisonsociale()).isEqualTo(UPDATED_RAISONSOCIALE);
        assertThat(testLotsSoumissionnaire.getNumero()).isEqualTo(UPDATED_NUMERO);
        assertThat(testLotsSoumissionnaire.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testLotsSoumissionnaire.getCommentaire()).isEqualTo(UPDATED_COMMENTAIRE);
        assertThat(testLotsSoumissionnaire.getLotsoumis()).isEqualTo(UPDATED_LOTSOUMIS);
        assertThat(testLotsSoumissionnaire.getLotrecu()).isEqualTo(UPDATED_LOTRECU);
        assertThat(testLotsSoumissionnaire.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testLotsSoumissionnaire.getElimine()).isEqualTo(UPDATED_ELIMINE);
        assertThat(testLotsSoumissionnaire.getMontantOffert()).isEqualTo(UPDATED_MONTANT_OFFERT);
        assertThat(testLotsSoumissionnaire.getMontantDefinitif()).isEqualTo(UPDATED_MONTANT_DEFINITIF);
        assertThat(testLotsSoumissionnaire.getMontantGarantie()).isEqualTo(UPDATED_MONTANT_GARANTIE);
        assertThat(testLotsSoumissionnaire.getMontantTVA()).isEqualTo(UPDATED_MONTANT_TVA);
        assertThat(testLotsSoumissionnaire.getMontantDouane()).isEqualTo(UPDATED_MONTANT_DOUANE);
        assertThat(testLotsSoumissionnaire.getMontantTTC()).isEqualTo(UPDATED_MONTANT_TTC);
        assertThat(testLotsSoumissionnaire.getRabais()).isEqualTo(UPDATED_RABAIS);
        assertThat(testLotsSoumissionnaire.getRang()).isEqualTo(UPDATED_RANG);
        assertThat(testLotsSoumissionnaire.getScoreTechnique()).isEqualTo(UPDATED_SCORE_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getScoreFinancier()).isEqualTo(UPDATED_SCORE_FINANCIER);
        assertThat(testLotsSoumissionnaire.getPrixEvalue()).isEqualTo(UPDATED_PRIX_EVALUE);
        assertThat(testLotsSoumissionnaire.getScoreTechniquePondere()).isEqualTo(UPDATED_SCORE_TECHNIQUE_PONDERE);
        assertThat(testLotsSoumissionnaire.getScoreFinancierPondere()).isEqualTo(UPDATED_SCORE_FINANCIER_PONDERE);
        assertThat(testLotsSoumissionnaire.getScoreFinal()).isEqualTo(UPDATED_SCORE_FINAL);
        assertThat(testLotsSoumissionnaire.getDateDepot()).isEqualTo(UPDATED_DATE_DEPOT);
        assertThat(testLotsSoumissionnaire.getClassementGeneral()).isEqualTo(UPDATED_CLASSEMENT_GENERAL);
        assertThat(testLotsSoumissionnaire.getClassemenTechnique()).isEqualTo(UPDATED_CLASSEMEN_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getEtatPreselection()).isEqualTo(UPDATED_ETAT_PRESELECTION);
        assertThat(testLotsSoumissionnaire.getEtatExamenPreliminaire()).isEqualTo(UPDATED_ETAT_EXAMEN_PRELIMINAIRE);
        assertThat(testLotsSoumissionnaire.getCritereQualification()).isEqualTo(UPDATED_CRITERE_QUALIFICATION);
        assertThat(testLotsSoumissionnaire.getAttributaireProvisoire()).isEqualTo(UPDATED_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testLotsSoumissionnaire.getPlilValide()).isEqualTo(UPDATED_PLIL_VALIDE);
        assertThat(testLotsSoumissionnaire.getLettreSoumission()).isEqualTo(UPDATED_LETTRE_SOUMISSION);
        assertThat(testLotsSoumissionnaire.getOffreTechnique()).isEqualTo(UPDATED_OFFRE_TECHNIQUE);
        assertThat(testLotsSoumissionnaire.getOffreFinanciere()).isEqualTo(UPDATED_OFFRE_FINANCIERE);
        assertThat(testLotsSoumissionnaire.getPlinumero()).isEqualTo(UPDATED_PLINUMERO);
    }

    @Test
    @Transactional
    public void updateNonExistingLotsSoumissionnaire() throws Exception {
        int databaseSizeBeforeUpdate = lotsSoumissionnaireRepository.findAll().size();

        // Create the LotsSoumissionnaire
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO = lotsSoumissionnaireMapper.toDto(lotsSoumissionnaire);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restLotsSoumissionnaireMockMvc.perform(put("/api/lots-soumissionnaires")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(lotsSoumissionnaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the LotsSoumissionnaire in the database
        List<LotsSoumissionnaire> lotsSoumissionnaireList = lotsSoumissionnaireRepository.findAll();
        assertThat(lotsSoumissionnaireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteLotsSoumissionnaire() throws Exception {
        // Initialize the database
        lotsSoumissionnaireRepository.saveAndFlush(lotsSoumissionnaire);

        int databaseSizeBeforeDelete = lotsSoumissionnaireRepository.findAll().size();

        // Delete the lotsSoumissionnaire
        restLotsSoumissionnaireMockMvc.perform(delete("/api/lots-soumissionnaires/{id}", lotsSoumissionnaire.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<LotsSoumissionnaire> lotsSoumissionnaireList = lotsSoumissionnaireRepository.findAll();
        assertThat(lotsSoumissionnaireList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
