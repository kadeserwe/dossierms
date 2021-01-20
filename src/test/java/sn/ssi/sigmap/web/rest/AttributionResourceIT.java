package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Attribution;
import sn.ssi.sigmap.repository.AttributionRepository;
import sn.ssi.sigmap.service.AttributionService;
import sn.ssi.sigmap.service.dto.AttributionDTO;
import sn.ssi.sigmap.service.mapper.AttributionMapper;

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
 * Integration tests for the {@link AttributionResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AttributionResourceIT {

    private static final String DEFAULT_REFERENCE_PLANDE_PASSATION = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_PLANDE_PASSATION = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_AVIS_GENERAL = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_AVIS_GENERAL = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRIBUTAIRE_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_ATTRIBUTAIRE_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTAIRE_DEFINITIF = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE_DEFINITIF = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_FICHIER_DEF = "AAAAAAAAAA";
    private static final String UPDATED_NOM_FICHIER_DEF = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRI_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ATTRI_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MONTANT_MARCHE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_MARCHE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANTDEFINITIF = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANTDEFINITIF = new BigDecimal(2);

    private static final Integer DEFAULT_MOIS_EXECUTION = 1;
    private static final Integer UPDATED_MOIS_EXECUTION = 2;

    private static final Integer DEFAULT_SEMAINE_EXECUTION = 1;
    private static final Integer UPDATED_SEMAINE_EXECUTION = 2;

    private static final Integer DEFAULT_JOURS_EXECUTION = 1;
    private static final Integer UPDATED_JOURS_EXECUTION = 2;

    private static final LocalDate DEFAULT_DATE_PUBLICATION_PROVISOIRE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PUBLICATION_PROVISOIRE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_PUBLICATION_DEFINITIVE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PUBLICATION_DEFINITIVE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATEATTRIBUTION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEATTRIBUTION = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private AttributionRepository attributionRepository;

    @Autowired
    private AttributionMapper attributionMapper;

    @Autowired
    private AttributionService attributionService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAttributionMockMvc;

    private Attribution attribution;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Attribution createEntity(EntityManager em) {
        Attribution attribution = new Attribution()
            .referencePlandePassation(DEFAULT_REFERENCE_PLANDE_PASSATION)
            .referenceAvisGeneral(DEFAULT_REFERENCE_AVIS_GENERAL)
            .attributaireProvisoire(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)
            .commentaire(DEFAULT_COMMENTAIRE)
            .commentaireDefinitif(DEFAULT_COMMENTAIRE_DEFINITIF)
            .nomFichierDef(DEFAULT_NOM_FICHIER_DEF)
            .attriType(DEFAULT_ATTRI_TYPE)
            .montantMarche(DEFAULT_MONTANT_MARCHE)
            .montantdefinitif(DEFAULT_MONTANTDEFINITIF)
            .moisExecution(DEFAULT_MOIS_EXECUTION)
            .semaineExecution(DEFAULT_SEMAINE_EXECUTION)
            .joursExecution(DEFAULT_JOURS_EXECUTION)
            .datePublicationProvisoire(DEFAULT_DATE_PUBLICATION_PROVISOIRE)
            .datePublicationDefinitive(DEFAULT_DATE_PUBLICATION_DEFINITIVE)
            .dateattribution(DEFAULT_DATEATTRIBUTION);
        return attribution;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Attribution createUpdatedEntity(EntityManager em) {
        Attribution attribution = new Attribution()
            .referencePlandePassation(UPDATED_REFERENCE_PLANDE_PASSATION)
            .referenceAvisGeneral(UPDATED_REFERENCE_AVIS_GENERAL)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .commentaire(UPDATED_COMMENTAIRE)
            .commentaireDefinitif(UPDATED_COMMENTAIRE_DEFINITIF)
            .nomFichierDef(UPDATED_NOM_FICHIER_DEF)
            .attriType(UPDATED_ATTRI_TYPE)
            .montantMarche(UPDATED_MONTANT_MARCHE)
            .montantdefinitif(UPDATED_MONTANTDEFINITIF)
            .moisExecution(UPDATED_MOIS_EXECUTION)
            .semaineExecution(UPDATED_SEMAINE_EXECUTION)
            .joursExecution(UPDATED_JOURS_EXECUTION)
            .datePublicationProvisoire(UPDATED_DATE_PUBLICATION_PROVISOIRE)
            .datePublicationDefinitive(UPDATED_DATE_PUBLICATION_DEFINITIVE)
            .dateattribution(UPDATED_DATEATTRIBUTION);
        return attribution;
    }

    @BeforeEach
    public void initTest() {
        attribution = createEntity(em);
    }

    @Test
    @Transactional
    public void createAttribution() throws Exception {
        int databaseSizeBeforeCreate = attributionRepository.findAll().size();
        // Create the Attribution
        AttributionDTO attributionDTO = attributionMapper.toDto(attribution);
        restAttributionMockMvc.perform(post("/api/attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributionDTO)))
            .andExpect(status().isCreated());

        // Validate the Attribution in the database
        List<Attribution> attributionList = attributionRepository.findAll();
        assertThat(attributionList).hasSize(databaseSizeBeforeCreate + 1);
        Attribution testAttribution = attributionList.get(attributionList.size() - 1);
        assertThat(testAttribution.getReferencePlandePassation()).isEqualTo(DEFAULT_REFERENCE_PLANDE_PASSATION);
        assertThat(testAttribution.getReferenceAvisGeneral()).isEqualTo(DEFAULT_REFERENCE_AVIS_GENERAL);
        assertThat(testAttribution.getAttributaireProvisoire()).isEqualTo(DEFAULT_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testAttribution.getCommentaire()).isEqualTo(DEFAULT_COMMENTAIRE);
        assertThat(testAttribution.getCommentaireDefinitif()).isEqualTo(DEFAULT_COMMENTAIRE_DEFINITIF);
        assertThat(testAttribution.getNomFichierDef()).isEqualTo(DEFAULT_NOM_FICHIER_DEF);
        assertThat(testAttribution.getAttriType()).isEqualTo(DEFAULT_ATTRI_TYPE);
        assertThat(testAttribution.getMontantMarche()).isEqualTo(DEFAULT_MONTANT_MARCHE);
        assertThat(testAttribution.getMontantdefinitif()).isEqualTo(DEFAULT_MONTANTDEFINITIF);
        assertThat(testAttribution.getMoisExecution()).isEqualTo(DEFAULT_MOIS_EXECUTION);
        assertThat(testAttribution.getSemaineExecution()).isEqualTo(DEFAULT_SEMAINE_EXECUTION);
        assertThat(testAttribution.getJoursExecution()).isEqualTo(DEFAULT_JOURS_EXECUTION);
        assertThat(testAttribution.getDatePublicationProvisoire()).isEqualTo(DEFAULT_DATE_PUBLICATION_PROVISOIRE);
        assertThat(testAttribution.getDatePublicationDefinitive()).isEqualTo(DEFAULT_DATE_PUBLICATION_DEFINITIVE);
        assertThat(testAttribution.getDateattribution()).isEqualTo(DEFAULT_DATEATTRIBUTION);
    }

    @Test
    @Transactional
    public void createAttributionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = attributionRepository.findAll().size();

        // Create the Attribution with an existing ID
        attribution.setId(1L);
        AttributionDTO attributionDTO = attributionMapper.toDto(attribution);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAttributionMockMvc.perform(post("/api/attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Attribution in the database
        List<Attribution> attributionList = attributionRepository.findAll();
        assertThat(attributionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAttributions() throws Exception {
        // Initialize the database
        attributionRepository.saveAndFlush(attribution);

        // Get all the attributionList
        restAttributionMockMvc.perform(get("/api/attributions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(attribution.getId().intValue())))
            .andExpect(jsonPath("$.[*].referencePlandePassation").value(hasItem(DEFAULT_REFERENCE_PLANDE_PASSATION)))
            .andExpect(jsonPath("$.[*].referenceAvisGeneral").value(hasItem(DEFAULT_REFERENCE_AVIS_GENERAL)))
            .andExpect(jsonPath("$.[*].attributaireProvisoire").value(hasItem(DEFAULT_ATTRIBUTAIRE_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].commentaire").value(hasItem(DEFAULT_COMMENTAIRE)))
            .andExpect(jsonPath("$.[*].commentaireDefinitif").value(hasItem(DEFAULT_COMMENTAIRE_DEFINITIF)))
            .andExpect(jsonPath("$.[*].nomFichierDef").value(hasItem(DEFAULT_NOM_FICHIER_DEF)))
            .andExpect(jsonPath("$.[*].attriType").value(hasItem(DEFAULT_ATTRI_TYPE)))
            .andExpect(jsonPath("$.[*].montantMarche").value(hasItem(DEFAULT_MONTANT_MARCHE.intValue())))
            .andExpect(jsonPath("$.[*].montantdefinitif").value(hasItem(DEFAULT_MONTANTDEFINITIF.intValue())))
            .andExpect(jsonPath("$.[*].moisExecution").value(hasItem(DEFAULT_MOIS_EXECUTION)))
            .andExpect(jsonPath("$.[*].semaineExecution").value(hasItem(DEFAULT_SEMAINE_EXECUTION)))
            .andExpect(jsonPath("$.[*].joursExecution").value(hasItem(DEFAULT_JOURS_EXECUTION)))
            .andExpect(jsonPath("$.[*].datePublicationProvisoire").value(hasItem(DEFAULT_DATE_PUBLICATION_PROVISOIRE.toString())))
            .andExpect(jsonPath("$.[*].datePublicationDefinitive").value(hasItem(DEFAULT_DATE_PUBLICATION_DEFINITIVE.toString())))
            .andExpect(jsonPath("$.[*].dateattribution").value(hasItem(DEFAULT_DATEATTRIBUTION.toString())));
    }
    
    @Test
    @Transactional
    public void getAttribution() throws Exception {
        // Initialize the database
        attributionRepository.saveAndFlush(attribution);

        // Get the attribution
        restAttributionMockMvc.perform(get("/api/attributions/{id}", attribution.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(attribution.getId().intValue()))
            .andExpect(jsonPath("$.referencePlandePassation").value(DEFAULT_REFERENCE_PLANDE_PASSATION))
            .andExpect(jsonPath("$.referenceAvisGeneral").value(DEFAULT_REFERENCE_AVIS_GENERAL))
            .andExpect(jsonPath("$.attributaireProvisoire").value(DEFAULT_ATTRIBUTAIRE_PROVISOIRE))
            .andExpect(jsonPath("$.commentaire").value(DEFAULT_COMMENTAIRE))
            .andExpect(jsonPath("$.commentaireDefinitif").value(DEFAULT_COMMENTAIRE_DEFINITIF))
            .andExpect(jsonPath("$.nomFichierDef").value(DEFAULT_NOM_FICHIER_DEF))
            .andExpect(jsonPath("$.attriType").value(DEFAULT_ATTRI_TYPE))
            .andExpect(jsonPath("$.montantMarche").value(DEFAULT_MONTANT_MARCHE.intValue()))
            .andExpect(jsonPath("$.montantdefinitif").value(DEFAULT_MONTANTDEFINITIF.intValue()))
            .andExpect(jsonPath("$.moisExecution").value(DEFAULT_MOIS_EXECUTION))
            .andExpect(jsonPath("$.semaineExecution").value(DEFAULT_SEMAINE_EXECUTION))
            .andExpect(jsonPath("$.joursExecution").value(DEFAULT_JOURS_EXECUTION))
            .andExpect(jsonPath("$.datePublicationProvisoire").value(DEFAULT_DATE_PUBLICATION_PROVISOIRE.toString()))
            .andExpect(jsonPath("$.datePublicationDefinitive").value(DEFAULT_DATE_PUBLICATION_DEFINITIVE.toString()))
            .andExpect(jsonPath("$.dateattribution").value(DEFAULT_DATEATTRIBUTION.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingAttribution() throws Exception {
        // Get the attribution
        restAttributionMockMvc.perform(get("/api/attributions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAttribution() throws Exception {
        // Initialize the database
        attributionRepository.saveAndFlush(attribution);

        int databaseSizeBeforeUpdate = attributionRepository.findAll().size();

        // Update the attribution
        Attribution updatedAttribution = attributionRepository.findById(attribution.getId()).get();
        // Disconnect from session so that the updates on updatedAttribution are not directly saved in db
        em.detach(updatedAttribution);
        updatedAttribution
            .referencePlandePassation(UPDATED_REFERENCE_PLANDE_PASSATION)
            .referenceAvisGeneral(UPDATED_REFERENCE_AVIS_GENERAL)
            .attributaireProvisoire(UPDATED_ATTRIBUTAIRE_PROVISOIRE)
            .commentaire(UPDATED_COMMENTAIRE)
            .commentaireDefinitif(UPDATED_COMMENTAIRE_DEFINITIF)
            .nomFichierDef(UPDATED_NOM_FICHIER_DEF)
            .attriType(UPDATED_ATTRI_TYPE)
            .montantMarche(UPDATED_MONTANT_MARCHE)
            .montantdefinitif(UPDATED_MONTANTDEFINITIF)
            .moisExecution(UPDATED_MOIS_EXECUTION)
            .semaineExecution(UPDATED_SEMAINE_EXECUTION)
            .joursExecution(UPDATED_JOURS_EXECUTION)
            .datePublicationProvisoire(UPDATED_DATE_PUBLICATION_PROVISOIRE)
            .datePublicationDefinitive(UPDATED_DATE_PUBLICATION_DEFINITIVE)
            .dateattribution(UPDATED_DATEATTRIBUTION);
        AttributionDTO attributionDTO = attributionMapper.toDto(updatedAttribution);

        restAttributionMockMvc.perform(put("/api/attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributionDTO)))
            .andExpect(status().isOk());

        // Validate the Attribution in the database
        List<Attribution> attributionList = attributionRepository.findAll();
        assertThat(attributionList).hasSize(databaseSizeBeforeUpdate);
        Attribution testAttribution = attributionList.get(attributionList.size() - 1);
        assertThat(testAttribution.getReferencePlandePassation()).isEqualTo(UPDATED_REFERENCE_PLANDE_PASSATION);
        assertThat(testAttribution.getReferenceAvisGeneral()).isEqualTo(UPDATED_REFERENCE_AVIS_GENERAL);
        assertThat(testAttribution.getAttributaireProvisoire()).isEqualTo(UPDATED_ATTRIBUTAIRE_PROVISOIRE);
        assertThat(testAttribution.getCommentaire()).isEqualTo(UPDATED_COMMENTAIRE);
        assertThat(testAttribution.getCommentaireDefinitif()).isEqualTo(UPDATED_COMMENTAIRE_DEFINITIF);
        assertThat(testAttribution.getNomFichierDef()).isEqualTo(UPDATED_NOM_FICHIER_DEF);
        assertThat(testAttribution.getAttriType()).isEqualTo(UPDATED_ATTRI_TYPE);
        assertThat(testAttribution.getMontantMarche()).isEqualTo(UPDATED_MONTANT_MARCHE);
        assertThat(testAttribution.getMontantdefinitif()).isEqualTo(UPDATED_MONTANTDEFINITIF);
        assertThat(testAttribution.getMoisExecution()).isEqualTo(UPDATED_MOIS_EXECUTION);
        assertThat(testAttribution.getSemaineExecution()).isEqualTo(UPDATED_SEMAINE_EXECUTION);
        assertThat(testAttribution.getJoursExecution()).isEqualTo(UPDATED_JOURS_EXECUTION);
        assertThat(testAttribution.getDatePublicationProvisoire()).isEqualTo(UPDATED_DATE_PUBLICATION_PROVISOIRE);
        assertThat(testAttribution.getDatePublicationDefinitive()).isEqualTo(UPDATED_DATE_PUBLICATION_DEFINITIVE);
        assertThat(testAttribution.getDateattribution()).isEqualTo(UPDATED_DATEATTRIBUTION);
    }

    @Test
    @Transactional
    public void updateNonExistingAttribution() throws Exception {
        int databaseSizeBeforeUpdate = attributionRepository.findAll().size();

        // Create the Attribution
        AttributionDTO attributionDTO = attributionMapper.toDto(attribution);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAttributionMockMvc.perform(put("/api/attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(attributionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Attribution in the database
        List<Attribution> attributionList = attributionRepository.findAll();
        assertThat(attributionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAttribution() throws Exception {
        // Initialize the database
        attributionRepository.saveAndFlush(attribution);

        int databaseSizeBeforeDelete = attributionRepository.findAll().size();

        // Delete the attribution
        restAttributionMockMvc.perform(delete("/api/attributions/{id}", attribution.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Attribution> attributionList = attributionRepository.findAll();
        assertThat(attributionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
