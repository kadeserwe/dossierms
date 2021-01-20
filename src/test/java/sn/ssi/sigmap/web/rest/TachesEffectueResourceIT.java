package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.TachesEffectue;
import sn.ssi.sigmap.repository.TachesEffectueRepository;
import sn.ssi.sigmap.service.TachesEffectueService;
import sn.ssi.sigmap.service.dto.TachesEffectueDTO;
import sn.ssi.sigmap.service.mapper.TachesEffectueMapper;

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
 * Integration tests for the {@link TachesEffectueResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class TachesEffectueResourceIT {

    private static final Integer DEFAULT_ALLOTISSEMENT = 1;
    private static final Integer UPDATED_ALLOTISSEMENT = 2;

    private static final Integer DEFAULT_GARANTIE = 1;
    private static final Integer UPDATED_GARANTIE = 2;

    private static final Integer DEFAULT_PIECE_ADMINISTRATIVE = 1;
    private static final Integer UPDATED_PIECE_ADMINISTRATIVE = 2;

    private static final Integer DEFAULT_CRITERE_QUALIFICATION = 1;
    private static final Integer UPDATED_CRITERE_QUALIFICATION = 2;

    private static final Integer DEFAULT_DEVISE = 1;
    private static final Integer UPDATED_DEVISE = 2;

    private static final Integer DEFAULT_FINANCEMENT = 1;
    private static final Integer UPDATED_FINANCEMENT = 2;

    private static final Integer DEFAULT_REGISTRE_RETRAIT = 1;
    private static final Integer UPDATED_REGISTRE_RETRAIT = 2;

    private static final Integer DEFAULT_REGISTRE_DEPOT = 1;
    private static final Integer UPDATED_REGISTRE_DEPOT = 2;

    private static final Integer DEFAULT_LOTS_SOUMIS = 1;
    private static final Integer UPDATED_LOTS_SOUMIS = 2;

    private static final Integer DEFAULT_COMMISSIONS_PASSATION = 1;
    private static final Integer UPDATED_COMMISSIONS_PASSATION = 2;

    private static final Integer DEFAULT_REPRESENTANTS_SOUMIS = 1;
    private static final Integer UPDATED_REPRESENTANTS_SOUMIS = 2;

    private static final Integer DEFAULT_SERVICES_TECHNIQUES = 1;
    private static final Integer UPDATED_SERVICES_TECHNIQUES = 2;

    private static final Integer DEFAULT_OBSERVATEURS = 1;
    private static final Integer UPDATED_OBSERVATEURS = 2;

    private static final Integer DEFAULT_GARANTIE_SOUM = 1;
    private static final Integer UPDATED_GARANTIE_SOUM = 2;

    private static final Integer DEFAULT_PIECES_SOUMIS = 1;
    private static final Integer UPDATED_PIECES_SOUMIS = 2;

    private static final Integer DEFAULT_LECTURE_OFFRE = 1;
    private static final Integer UPDATED_LECTURE_OFFRE = 2;

    private static final Integer DEFAULT_COMMISSION_TECNIQUE = 1;
    private static final Integer UPDATED_COMMISSION_TECNIQUE = 2;

    private static final Integer DEFAULT_DOCUMENT = 1;
    private static final Integer UPDATED_DOCUMENT = 2;

    private static final Integer DEFAULT_EXAMEN_GARANTIE = 1;
    private static final Integer UPDATED_EXAMEN_GARANTIE = 2;

    private static final Integer DEFAULT_EXAMEN_EXHAUSTIVITE = 1;
    private static final Integer UPDATED_EXAMEN_EXHAUSTIVITE = 2;

    private static final Integer DEFAULT_EXAMEN_SIGNATURE_OFFRE = 1;
    private static final Integer UPDATED_EXAMEN_SIGNATURE_OFFRE = 2;

    private static final Integer DEFAULT_EXAMEN_CONFORMITE = 1;
    private static final Integer UPDATED_EXAMEN_CONFORMITE = 2;

    private static final Integer DEFAULT_VERIFICATION_CRITERE = 1;
    private static final Integer UPDATED_VERIFICATION_CRITERE = 2;

    private static final Integer DEFAULT_ATTRIBUTION_PROVISOIRE = 1;
    private static final Integer UPDATED_ATTRIBUTION_PROVISOIRE = 2;

    private static final Integer DEFAULT_TERME_REFERENCE = 1;
    private static final Integer UPDATED_TERME_REFERENCE = 2;

    private static final Integer DEFAULT_DEPOT_CANDIDATURE = 1;
    private static final Integer UPDATED_DEPOT_CANDIDATURE = 2;

    private static final Integer DEFAULT_PRESELECTION = 1;
    private static final Integer UPDATED_PRESELECTION = 2;

    private static final Integer DEFAULT_NOTIFICATION = 1;
    private static final Integer UPDATED_NOTIFICATION = 2;

    private static final Integer DEFAULT_COMMISSIONS_PASSATION_PI = 1;
    private static final Integer UPDATED_COMMISSIONS_PASSATION_PI = 2;

    private static final Integer DEFAULT_REPRESENTANTS_SOUMIS_PI = 1;
    private static final Integer UPDATED_REPRESENTANTS_SOUMIS_PI = 2;

    private static final Integer DEFAULT_NOTES_TECHNIQUE = 1;
    private static final Integer UPDATED_NOTES_TECHNIQUE = 2;

    private static final Integer DEFAULT_OFFRES_FINANCIERE = 1;
    private static final Integer UPDATED_OFFRES_FINANCIERE = 2;

    private static final Integer DEFAULT_PRIX_EVALUE = 1;
    private static final Integer UPDATED_PRIX_EVALUE = 2;

    private static final Integer DEFAULT_REGISTRE_DEPOT_PI = 1;
    private static final Integer UPDATED_REGISTRE_DEPOT_PI = 2;

    private static final Integer DEFAULT_CRITERE_PROVENANCE = 1;
    private static final Integer UPDATED_CRITERE_PROVENANCE = 2;

    private static final Integer DEFAULT_PROCES_VERBALE = 1;
    private static final Integer UPDATED_PROCES_VERBALE = 2;

    @Autowired
    private TachesEffectueRepository tachesEffectueRepository;

    @Autowired
    private TachesEffectueMapper tachesEffectueMapper;

    @Autowired
    private TachesEffectueService tachesEffectueService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTachesEffectueMockMvc;

    private TachesEffectue tachesEffectue;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TachesEffectue createEntity(EntityManager em) {
        TachesEffectue tachesEffectue = new TachesEffectue()
            .allotissement(DEFAULT_ALLOTISSEMENT)
            .garantie(DEFAULT_GARANTIE)
            .pieceAdministrative(DEFAULT_PIECE_ADMINISTRATIVE)
            .critereQualification(DEFAULT_CRITERE_QUALIFICATION)
            .devise(DEFAULT_DEVISE)
            .financement(DEFAULT_FINANCEMENT)
            .registreRetrait(DEFAULT_REGISTRE_RETRAIT)
            .registreDepot(DEFAULT_REGISTRE_DEPOT)
            .lotsSoumis(DEFAULT_LOTS_SOUMIS)
            .commissionsPassation(DEFAULT_COMMISSIONS_PASSATION)
            .representantsSoumis(DEFAULT_REPRESENTANTS_SOUMIS)
            .servicesTechniques(DEFAULT_SERVICES_TECHNIQUES)
            .observateurs(DEFAULT_OBSERVATEURS)
            .garantieSoum(DEFAULT_GARANTIE_SOUM)
            .piecesSoumis(DEFAULT_PIECES_SOUMIS)
            .lectureOffre(DEFAULT_LECTURE_OFFRE)
            .commissionTecnique(DEFAULT_COMMISSION_TECNIQUE)
            .document(DEFAULT_DOCUMENT)
            .examenGarantie(DEFAULT_EXAMEN_GARANTIE)
            .examenExhaustivite(DEFAULT_EXAMEN_EXHAUSTIVITE)
            .examenSignatureOffre(DEFAULT_EXAMEN_SIGNATURE_OFFRE)
            .examenConformite(DEFAULT_EXAMEN_CONFORMITE)
            .verificationCritere(DEFAULT_VERIFICATION_CRITERE)
            .attributionProvisoire(DEFAULT_ATTRIBUTION_PROVISOIRE)
            .termeReference(DEFAULT_TERME_REFERENCE)
            .depotCandidature(DEFAULT_DEPOT_CANDIDATURE)
            .preselection(DEFAULT_PRESELECTION)
            .notification(DEFAULT_NOTIFICATION)
            .commissionsPassationPI(DEFAULT_COMMISSIONS_PASSATION_PI)
            .representantsSoumisPI(DEFAULT_REPRESENTANTS_SOUMIS_PI)
            .notesTechnique(DEFAULT_NOTES_TECHNIQUE)
            .offresFinanciere(DEFAULT_OFFRES_FINANCIERE)
            .prixEvalue(DEFAULT_PRIX_EVALUE)
            .registreDepotPI(DEFAULT_REGISTRE_DEPOT_PI)
            .critereProvenance(DEFAULT_CRITERE_PROVENANCE)
            .procesVerbale(DEFAULT_PROCES_VERBALE);
        return tachesEffectue;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TachesEffectue createUpdatedEntity(EntityManager em) {
        TachesEffectue tachesEffectue = new TachesEffectue()
            .allotissement(UPDATED_ALLOTISSEMENT)
            .garantie(UPDATED_GARANTIE)
            .pieceAdministrative(UPDATED_PIECE_ADMINISTRATIVE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .devise(UPDATED_DEVISE)
            .financement(UPDATED_FINANCEMENT)
            .registreRetrait(UPDATED_REGISTRE_RETRAIT)
            .registreDepot(UPDATED_REGISTRE_DEPOT)
            .lotsSoumis(UPDATED_LOTS_SOUMIS)
            .commissionsPassation(UPDATED_COMMISSIONS_PASSATION)
            .representantsSoumis(UPDATED_REPRESENTANTS_SOUMIS)
            .servicesTechniques(UPDATED_SERVICES_TECHNIQUES)
            .observateurs(UPDATED_OBSERVATEURS)
            .garantieSoum(UPDATED_GARANTIE_SOUM)
            .piecesSoumis(UPDATED_PIECES_SOUMIS)
            .lectureOffre(UPDATED_LECTURE_OFFRE)
            .commissionTecnique(UPDATED_COMMISSION_TECNIQUE)
            .document(UPDATED_DOCUMENT)
            .examenGarantie(UPDATED_EXAMEN_GARANTIE)
            .examenExhaustivite(UPDATED_EXAMEN_EXHAUSTIVITE)
            .examenSignatureOffre(UPDATED_EXAMEN_SIGNATURE_OFFRE)
            .examenConformite(UPDATED_EXAMEN_CONFORMITE)
            .verificationCritere(UPDATED_VERIFICATION_CRITERE)
            .attributionProvisoire(UPDATED_ATTRIBUTION_PROVISOIRE)
            .termeReference(UPDATED_TERME_REFERENCE)
            .depotCandidature(UPDATED_DEPOT_CANDIDATURE)
            .preselection(UPDATED_PRESELECTION)
            .notification(UPDATED_NOTIFICATION)
            .commissionsPassationPI(UPDATED_COMMISSIONS_PASSATION_PI)
            .representantsSoumisPI(UPDATED_REPRESENTANTS_SOUMIS_PI)
            .notesTechnique(UPDATED_NOTES_TECHNIQUE)
            .offresFinanciere(UPDATED_OFFRES_FINANCIERE)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .registreDepotPI(UPDATED_REGISTRE_DEPOT_PI)
            .critereProvenance(UPDATED_CRITERE_PROVENANCE)
            .procesVerbale(UPDATED_PROCES_VERBALE);
        return tachesEffectue;
    }

    @BeforeEach
    public void initTest() {
        tachesEffectue = createEntity(em);
    }

    @Test
    @Transactional
    public void createTachesEffectue() throws Exception {
        int databaseSizeBeforeCreate = tachesEffectueRepository.findAll().size();
        // Create the TachesEffectue
        TachesEffectueDTO tachesEffectueDTO = tachesEffectueMapper.toDto(tachesEffectue);
        restTachesEffectueMockMvc.perform(post("/api/taches-effectues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tachesEffectueDTO)))
            .andExpect(status().isCreated());

        // Validate the TachesEffectue in the database
        List<TachesEffectue> tachesEffectueList = tachesEffectueRepository.findAll();
        assertThat(tachesEffectueList).hasSize(databaseSizeBeforeCreate + 1);
        TachesEffectue testTachesEffectue = tachesEffectueList.get(tachesEffectueList.size() - 1);
        assertThat(testTachesEffectue.getAllotissement()).isEqualTo(DEFAULT_ALLOTISSEMENT);
        assertThat(testTachesEffectue.getGarantie()).isEqualTo(DEFAULT_GARANTIE);
        assertThat(testTachesEffectue.getPieceAdministrative()).isEqualTo(DEFAULT_PIECE_ADMINISTRATIVE);
        assertThat(testTachesEffectue.getCritereQualification()).isEqualTo(DEFAULT_CRITERE_QUALIFICATION);
        assertThat(testTachesEffectue.getDevise()).isEqualTo(DEFAULT_DEVISE);
        assertThat(testTachesEffectue.getFinancement()).isEqualTo(DEFAULT_FINANCEMENT);
        assertThat(testTachesEffectue.getRegistreRetrait()).isEqualTo(DEFAULT_REGISTRE_RETRAIT);
        assertThat(testTachesEffectue.getRegistreDepot()).isEqualTo(DEFAULT_REGISTRE_DEPOT);
        assertThat(testTachesEffectue.getLotsSoumis()).isEqualTo(DEFAULT_LOTS_SOUMIS);
        assertThat(testTachesEffectue.getCommissionsPassation()).isEqualTo(DEFAULT_COMMISSIONS_PASSATION);
        assertThat(testTachesEffectue.getRepresentantsSoumis()).isEqualTo(DEFAULT_REPRESENTANTS_SOUMIS);
        assertThat(testTachesEffectue.getServicesTechniques()).isEqualTo(DEFAULT_SERVICES_TECHNIQUES);
        assertThat(testTachesEffectue.getObservateurs()).isEqualTo(DEFAULT_OBSERVATEURS);
        assertThat(testTachesEffectue.getGarantieSoum()).isEqualTo(DEFAULT_GARANTIE_SOUM);
        assertThat(testTachesEffectue.getPiecesSoumis()).isEqualTo(DEFAULT_PIECES_SOUMIS);
        assertThat(testTachesEffectue.getLectureOffre()).isEqualTo(DEFAULT_LECTURE_OFFRE);
        assertThat(testTachesEffectue.getCommissionTecnique()).isEqualTo(DEFAULT_COMMISSION_TECNIQUE);
        assertThat(testTachesEffectue.getDocument()).isEqualTo(DEFAULT_DOCUMENT);
        assertThat(testTachesEffectue.getExamenGarantie()).isEqualTo(DEFAULT_EXAMEN_GARANTIE);
        assertThat(testTachesEffectue.getExamenExhaustivite()).isEqualTo(DEFAULT_EXAMEN_EXHAUSTIVITE);
        assertThat(testTachesEffectue.getExamenSignatureOffre()).isEqualTo(DEFAULT_EXAMEN_SIGNATURE_OFFRE);
        assertThat(testTachesEffectue.getExamenConformite()).isEqualTo(DEFAULT_EXAMEN_CONFORMITE);
        assertThat(testTachesEffectue.getVerificationCritere()).isEqualTo(DEFAULT_VERIFICATION_CRITERE);
        assertThat(testTachesEffectue.getAttributionProvisoire()).isEqualTo(DEFAULT_ATTRIBUTION_PROVISOIRE);
        assertThat(testTachesEffectue.getTermeReference()).isEqualTo(DEFAULT_TERME_REFERENCE);
        assertThat(testTachesEffectue.getDepotCandidature()).isEqualTo(DEFAULT_DEPOT_CANDIDATURE);
        assertThat(testTachesEffectue.getPreselection()).isEqualTo(DEFAULT_PRESELECTION);
        assertThat(testTachesEffectue.getNotification()).isEqualTo(DEFAULT_NOTIFICATION);
        assertThat(testTachesEffectue.getCommissionsPassationPI()).isEqualTo(DEFAULT_COMMISSIONS_PASSATION_PI);
        assertThat(testTachesEffectue.getRepresentantsSoumisPI()).isEqualTo(DEFAULT_REPRESENTANTS_SOUMIS_PI);
        assertThat(testTachesEffectue.getNotesTechnique()).isEqualTo(DEFAULT_NOTES_TECHNIQUE);
        assertThat(testTachesEffectue.getOffresFinanciere()).isEqualTo(DEFAULT_OFFRES_FINANCIERE);
        assertThat(testTachesEffectue.getPrixEvalue()).isEqualTo(DEFAULT_PRIX_EVALUE);
        assertThat(testTachesEffectue.getRegistreDepotPI()).isEqualTo(DEFAULT_REGISTRE_DEPOT_PI);
        assertThat(testTachesEffectue.getCritereProvenance()).isEqualTo(DEFAULT_CRITERE_PROVENANCE);
        assertThat(testTachesEffectue.getProcesVerbale()).isEqualTo(DEFAULT_PROCES_VERBALE);
    }

    @Test
    @Transactional
    public void createTachesEffectueWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = tachesEffectueRepository.findAll().size();

        // Create the TachesEffectue with an existing ID
        tachesEffectue.setId(1L);
        TachesEffectueDTO tachesEffectueDTO = tachesEffectueMapper.toDto(tachesEffectue);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTachesEffectueMockMvc.perform(post("/api/taches-effectues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tachesEffectueDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TachesEffectue in the database
        List<TachesEffectue> tachesEffectueList = tachesEffectueRepository.findAll();
        assertThat(tachesEffectueList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllTachesEffectues() throws Exception {
        // Initialize the database
        tachesEffectueRepository.saveAndFlush(tachesEffectue);

        // Get all the tachesEffectueList
        restTachesEffectueMockMvc.perform(get("/api/taches-effectues?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tachesEffectue.getId().intValue())))
            .andExpect(jsonPath("$.[*].allotissement").value(hasItem(DEFAULT_ALLOTISSEMENT)))
            .andExpect(jsonPath("$.[*].garantie").value(hasItem(DEFAULT_GARANTIE)))
            .andExpect(jsonPath("$.[*].pieceAdministrative").value(hasItem(DEFAULT_PIECE_ADMINISTRATIVE)))
            .andExpect(jsonPath("$.[*].critereQualification").value(hasItem(DEFAULT_CRITERE_QUALIFICATION)))
            .andExpect(jsonPath("$.[*].devise").value(hasItem(DEFAULT_DEVISE)))
            .andExpect(jsonPath("$.[*].financement").value(hasItem(DEFAULT_FINANCEMENT)))
            .andExpect(jsonPath("$.[*].registreRetrait").value(hasItem(DEFAULT_REGISTRE_RETRAIT)))
            .andExpect(jsonPath("$.[*].registreDepot").value(hasItem(DEFAULT_REGISTRE_DEPOT)))
            .andExpect(jsonPath("$.[*].lotsSoumis").value(hasItem(DEFAULT_LOTS_SOUMIS)))
            .andExpect(jsonPath("$.[*].commissionsPassation").value(hasItem(DEFAULT_COMMISSIONS_PASSATION)))
            .andExpect(jsonPath("$.[*].representantsSoumis").value(hasItem(DEFAULT_REPRESENTANTS_SOUMIS)))
            .andExpect(jsonPath("$.[*].servicesTechniques").value(hasItem(DEFAULT_SERVICES_TECHNIQUES)))
            .andExpect(jsonPath("$.[*].observateurs").value(hasItem(DEFAULT_OBSERVATEURS)))
            .andExpect(jsonPath("$.[*].garantieSoum").value(hasItem(DEFAULT_GARANTIE_SOUM)))
            .andExpect(jsonPath("$.[*].piecesSoumis").value(hasItem(DEFAULT_PIECES_SOUMIS)))
            .andExpect(jsonPath("$.[*].lectureOffre").value(hasItem(DEFAULT_LECTURE_OFFRE)))
            .andExpect(jsonPath("$.[*].commissionTecnique").value(hasItem(DEFAULT_COMMISSION_TECNIQUE)))
            .andExpect(jsonPath("$.[*].document").value(hasItem(DEFAULT_DOCUMENT)))
            .andExpect(jsonPath("$.[*].examenGarantie").value(hasItem(DEFAULT_EXAMEN_GARANTIE)))
            .andExpect(jsonPath("$.[*].examenExhaustivite").value(hasItem(DEFAULT_EXAMEN_EXHAUSTIVITE)))
            .andExpect(jsonPath("$.[*].examenSignatureOffre").value(hasItem(DEFAULT_EXAMEN_SIGNATURE_OFFRE)))
            .andExpect(jsonPath("$.[*].examenConformite").value(hasItem(DEFAULT_EXAMEN_CONFORMITE)))
            .andExpect(jsonPath("$.[*].verificationCritere").value(hasItem(DEFAULT_VERIFICATION_CRITERE)))
            .andExpect(jsonPath("$.[*].attributionProvisoire").value(hasItem(DEFAULT_ATTRIBUTION_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].termeReference").value(hasItem(DEFAULT_TERME_REFERENCE)))
            .andExpect(jsonPath("$.[*].depotCandidature").value(hasItem(DEFAULT_DEPOT_CANDIDATURE)))
            .andExpect(jsonPath("$.[*].preselection").value(hasItem(DEFAULT_PRESELECTION)))
            .andExpect(jsonPath("$.[*].notification").value(hasItem(DEFAULT_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].commissionsPassationPI").value(hasItem(DEFAULT_COMMISSIONS_PASSATION_PI)))
            .andExpect(jsonPath("$.[*].representantsSoumisPI").value(hasItem(DEFAULT_REPRESENTANTS_SOUMIS_PI)))
            .andExpect(jsonPath("$.[*].notesTechnique").value(hasItem(DEFAULT_NOTES_TECHNIQUE)))
            .andExpect(jsonPath("$.[*].offresFinanciere").value(hasItem(DEFAULT_OFFRES_FINANCIERE)))
            .andExpect(jsonPath("$.[*].prixEvalue").value(hasItem(DEFAULT_PRIX_EVALUE)))
            .andExpect(jsonPath("$.[*].registreDepotPI").value(hasItem(DEFAULT_REGISTRE_DEPOT_PI)))
            .andExpect(jsonPath("$.[*].critereProvenance").value(hasItem(DEFAULT_CRITERE_PROVENANCE)))
            .andExpect(jsonPath("$.[*].procesVerbale").value(hasItem(DEFAULT_PROCES_VERBALE)));
    }
    
    @Test
    @Transactional
    public void getTachesEffectue() throws Exception {
        // Initialize the database
        tachesEffectueRepository.saveAndFlush(tachesEffectue);

        // Get the tachesEffectue
        restTachesEffectueMockMvc.perform(get("/api/taches-effectues/{id}", tachesEffectue.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tachesEffectue.getId().intValue()))
            .andExpect(jsonPath("$.allotissement").value(DEFAULT_ALLOTISSEMENT))
            .andExpect(jsonPath("$.garantie").value(DEFAULT_GARANTIE))
            .andExpect(jsonPath("$.pieceAdministrative").value(DEFAULT_PIECE_ADMINISTRATIVE))
            .andExpect(jsonPath("$.critereQualification").value(DEFAULT_CRITERE_QUALIFICATION))
            .andExpect(jsonPath("$.devise").value(DEFAULT_DEVISE))
            .andExpect(jsonPath("$.financement").value(DEFAULT_FINANCEMENT))
            .andExpect(jsonPath("$.registreRetrait").value(DEFAULT_REGISTRE_RETRAIT))
            .andExpect(jsonPath("$.registreDepot").value(DEFAULT_REGISTRE_DEPOT))
            .andExpect(jsonPath("$.lotsSoumis").value(DEFAULT_LOTS_SOUMIS))
            .andExpect(jsonPath("$.commissionsPassation").value(DEFAULT_COMMISSIONS_PASSATION))
            .andExpect(jsonPath("$.representantsSoumis").value(DEFAULT_REPRESENTANTS_SOUMIS))
            .andExpect(jsonPath("$.servicesTechniques").value(DEFAULT_SERVICES_TECHNIQUES))
            .andExpect(jsonPath("$.observateurs").value(DEFAULT_OBSERVATEURS))
            .andExpect(jsonPath("$.garantieSoum").value(DEFAULT_GARANTIE_SOUM))
            .andExpect(jsonPath("$.piecesSoumis").value(DEFAULT_PIECES_SOUMIS))
            .andExpect(jsonPath("$.lectureOffre").value(DEFAULT_LECTURE_OFFRE))
            .andExpect(jsonPath("$.commissionTecnique").value(DEFAULT_COMMISSION_TECNIQUE))
            .andExpect(jsonPath("$.document").value(DEFAULT_DOCUMENT))
            .andExpect(jsonPath("$.examenGarantie").value(DEFAULT_EXAMEN_GARANTIE))
            .andExpect(jsonPath("$.examenExhaustivite").value(DEFAULT_EXAMEN_EXHAUSTIVITE))
            .andExpect(jsonPath("$.examenSignatureOffre").value(DEFAULT_EXAMEN_SIGNATURE_OFFRE))
            .andExpect(jsonPath("$.examenConformite").value(DEFAULT_EXAMEN_CONFORMITE))
            .andExpect(jsonPath("$.verificationCritere").value(DEFAULT_VERIFICATION_CRITERE))
            .andExpect(jsonPath("$.attributionProvisoire").value(DEFAULT_ATTRIBUTION_PROVISOIRE))
            .andExpect(jsonPath("$.termeReference").value(DEFAULT_TERME_REFERENCE))
            .andExpect(jsonPath("$.depotCandidature").value(DEFAULT_DEPOT_CANDIDATURE))
            .andExpect(jsonPath("$.preselection").value(DEFAULT_PRESELECTION))
            .andExpect(jsonPath("$.notification").value(DEFAULT_NOTIFICATION))
            .andExpect(jsonPath("$.commissionsPassationPI").value(DEFAULT_COMMISSIONS_PASSATION_PI))
            .andExpect(jsonPath("$.representantsSoumisPI").value(DEFAULT_REPRESENTANTS_SOUMIS_PI))
            .andExpect(jsonPath("$.notesTechnique").value(DEFAULT_NOTES_TECHNIQUE))
            .andExpect(jsonPath("$.offresFinanciere").value(DEFAULT_OFFRES_FINANCIERE))
            .andExpect(jsonPath("$.prixEvalue").value(DEFAULT_PRIX_EVALUE))
            .andExpect(jsonPath("$.registreDepotPI").value(DEFAULT_REGISTRE_DEPOT_PI))
            .andExpect(jsonPath("$.critereProvenance").value(DEFAULT_CRITERE_PROVENANCE))
            .andExpect(jsonPath("$.procesVerbale").value(DEFAULT_PROCES_VERBALE));
    }
    @Test
    @Transactional
    public void getNonExistingTachesEffectue() throws Exception {
        // Get the tachesEffectue
        restTachesEffectueMockMvc.perform(get("/api/taches-effectues/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTachesEffectue() throws Exception {
        // Initialize the database
        tachesEffectueRepository.saveAndFlush(tachesEffectue);

        int databaseSizeBeforeUpdate = tachesEffectueRepository.findAll().size();

        // Update the tachesEffectue
        TachesEffectue updatedTachesEffectue = tachesEffectueRepository.findById(tachesEffectue.getId()).get();
        // Disconnect from session so that the updates on updatedTachesEffectue are not directly saved in db
        em.detach(updatedTachesEffectue);
        updatedTachesEffectue
            .allotissement(UPDATED_ALLOTISSEMENT)
            .garantie(UPDATED_GARANTIE)
            .pieceAdministrative(UPDATED_PIECE_ADMINISTRATIVE)
            .critereQualification(UPDATED_CRITERE_QUALIFICATION)
            .devise(UPDATED_DEVISE)
            .financement(UPDATED_FINANCEMENT)
            .registreRetrait(UPDATED_REGISTRE_RETRAIT)
            .registreDepot(UPDATED_REGISTRE_DEPOT)
            .lotsSoumis(UPDATED_LOTS_SOUMIS)
            .commissionsPassation(UPDATED_COMMISSIONS_PASSATION)
            .representantsSoumis(UPDATED_REPRESENTANTS_SOUMIS)
            .servicesTechniques(UPDATED_SERVICES_TECHNIQUES)
            .observateurs(UPDATED_OBSERVATEURS)
            .garantieSoum(UPDATED_GARANTIE_SOUM)
            .piecesSoumis(UPDATED_PIECES_SOUMIS)
            .lectureOffre(UPDATED_LECTURE_OFFRE)
            .commissionTecnique(UPDATED_COMMISSION_TECNIQUE)
            .document(UPDATED_DOCUMENT)
            .examenGarantie(UPDATED_EXAMEN_GARANTIE)
            .examenExhaustivite(UPDATED_EXAMEN_EXHAUSTIVITE)
            .examenSignatureOffre(UPDATED_EXAMEN_SIGNATURE_OFFRE)
            .examenConformite(UPDATED_EXAMEN_CONFORMITE)
            .verificationCritere(UPDATED_VERIFICATION_CRITERE)
            .attributionProvisoire(UPDATED_ATTRIBUTION_PROVISOIRE)
            .termeReference(UPDATED_TERME_REFERENCE)
            .depotCandidature(UPDATED_DEPOT_CANDIDATURE)
            .preselection(UPDATED_PRESELECTION)
            .notification(UPDATED_NOTIFICATION)
            .commissionsPassationPI(UPDATED_COMMISSIONS_PASSATION_PI)
            .representantsSoumisPI(UPDATED_REPRESENTANTS_SOUMIS_PI)
            .notesTechnique(UPDATED_NOTES_TECHNIQUE)
            .offresFinanciere(UPDATED_OFFRES_FINANCIERE)
            .prixEvalue(UPDATED_PRIX_EVALUE)
            .registreDepotPI(UPDATED_REGISTRE_DEPOT_PI)
            .critereProvenance(UPDATED_CRITERE_PROVENANCE)
            .procesVerbale(UPDATED_PROCES_VERBALE);
        TachesEffectueDTO tachesEffectueDTO = tachesEffectueMapper.toDto(updatedTachesEffectue);

        restTachesEffectueMockMvc.perform(put("/api/taches-effectues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tachesEffectueDTO)))
            .andExpect(status().isOk());

        // Validate the TachesEffectue in the database
        List<TachesEffectue> tachesEffectueList = tachesEffectueRepository.findAll();
        assertThat(tachesEffectueList).hasSize(databaseSizeBeforeUpdate);
        TachesEffectue testTachesEffectue = tachesEffectueList.get(tachesEffectueList.size() - 1);
        assertThat(testTachesEffectue.getAllotissement()).isEqualTo(UPDATED_ALLOTISSEMENT);
        assertThat(testTachesEffectue.getGarantie()).isEqualTo(UPDATED_GARANTIE);
        assertThat(testTachesEffectue.getPieceAdministrative()).isEqualTo(UPDATED_PIECE_ADMINISTRATIVE);
        assertThat(testTachesEffectue.getCritereQualification()).isEqualTo(UPDATED_CRITERE_QUALIFICATION);
        assertThat(testTachesEffectue.getDevise()).isEqualTo(UPDATED_DEVISE);
        assertThat(testTachesEffectue.getFinancement()).isEqualTo(UPDATED_FINANCEMENT);
        assertThat(testTachesEffectue.getRegistreRetrait()).isEqualTo(UPDATED_REGISTRE_RETRAIT);
        assertThat(testTachesEffectue.getRegistreDepot()).isEqualTo(UPDATED_REGISTRE_DEPOT);
        assertThat(testTachesEffectue.getLotsSoumis()).isEqualTo(UPDATED_LOTS_SOUMIS);
        assertThat(testTachesEffectue.getCommissionsPassation()).isEqualTo(UPDATED_COMMISSIONS_PASSATION);
        assertThat(testTachesEffectue.getRepresentantsSoumis()).isEqualTo(UPDATED_REPRESENTANTS_SOUMIS);
        assertThat(testTachesEffectue.getServicesTechniques()).isEqualTo(UPDATED_SERVICES_TECHNIQUES);
        assertThat(testTachesEffectue.getObservateurs()).isEqualTo(UPDATED_OBSERVATEURS);
        assertThat(testTachesEffectue.getGarantieSoum()).isEqualTo(UPDATED_GARANTIE_SOUM);
        assertThat(testTachesEffectue.getPiecesSoumis()).isEqualTo(UPDATED_PIECES_SOUMIS);
        assertThat(testTachesEffectue.getLectureOffre()).isEqualTo(UPDATED_LECTURE_OFFRE);
        assertThat(testTachesEffectue.getCommissionTecnique()).isEqualTo(UPDATED_COMMISSION_TECNIQUE);
        assertThat(testTachesEffectue.getDocument()).isEqualTo(UPDATED_DOCUMENT);
        assertThat(testTachesEffectue.getExamenGarantie()).isEqualTo(UPDATED_EXAMEN_GARANTIE);
        assertThat(testTachesEffectue.getExamenExhaustivite()).isEqualTo(UPDATED_EXAMEN_EXHAUSTIVITE);
        assertThat(testTachesEffectue.getExamenSignatureOffre()).isEqualTo(UPDATED_EXAMEN_SIGNATURE_OFFRE);
        assertThat(testTachesEffectue.getExamenConformite()).isEqualTo(UPDATED_EXAMEN_CONFORMITE);
        assertThat(testTachesEffectue.getVerificationCritere()).isEqualTo(UPDATED_VERIFICATION_CRITERE);
        assertThat(testTachesEffectue.getAttributionProvisoire()).isEqualTo(UPDATED_ATTRIBUTION_PROVISOIRE);
        assertThat(testTachesEffectue.getTermeReference()).isEqualTo(UPDATED_TERME_REFERENCE);
        assertThat(testTachesEffectue.getDepotCandidature()).isEqualTo(UPDATED_DEPOT_CANDIDATURE);
        assertThat(testTachesEffectue.getPreselection()).isEqualTo(UPDATED_PRESELECTION);
        assertThat(testTachesEffectue.getNotification()).isEqualTo(UPDATED_NOTIFICATION);
        assertThat(testTachesEffectue.getCommissionsPassationPI()).isEqualTo(UPDATED_COMMISSIONS_PASSATION_PI);
        assertThat(testTachesEffectue.getRepresentantsSoumisPI()).isEqualTo(UPDATED_REPRESENTANTS_SOUMIS_PI);
        assertThat(testTachesEffectue.getNotesTechnique()).isEqualTo(UPDATED_NOTES_TECHNIQUE);
        assertThat(testTachesEffectue.getOffresFinanciere()).isEqualTo(UPDATED_OFFRES_FINANCIERE);
        assertThat(testTachesEffectue.getPrixEvalue()).isEqualTo(UPDATED_PRIX_EVALUE);
        assertThat(testTachesEffectue.getRegistreDepotPI()).isEqualTo(UPDATED_REGISTRE_DEPOT_PI);
        assertThat(testTachesEffectue.getCritereProvenance()).isEqualTo(UPDATED_CRITERE_PROVENANCE);
        assertThat(testTachesEffectue.getProcesVerbale()).isEqualTo(UPDATED_PROCES_VERBALE);
    }

    @Test
    @Transactional
    public void updateNonExistingTachesEffectue() throws Exception {
        int databaseSizeBeforeUpdate = tachesEffectueRepository.findAll().size();

        // Create the TachesEffectue
        TachesEffectueDTO tachesEffectueDTO = tachesEffectueMapper.toDto(tachesEffectue);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTachesEffectueMockMvc.perform(put("/api/taches-effectues")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tachesEffectueDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TachesEffectue in the database
        List<TachesEffectue> tachesEffectueList = tachesEffectueRepository.findAll();
        assertThat(tachesEffectueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTachesEffectue() throws Exception {
        // Initialize the database
        tachesEffectueRepository.saveAndFlush(tachesEffectue);

        int databaseSizeBeforeDelete = tachesEffectueRepository.findAll().size();

        // Delete the tachesEffectue
        restTachesEffectueMockMvc.perform(delete("/api/taches-effectues/{id}", tachesEffectue.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<TachesEffectue> tachesEffectueList = tachesEffectueRepository.findAll();
        assertThat(tachesEffectueList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
