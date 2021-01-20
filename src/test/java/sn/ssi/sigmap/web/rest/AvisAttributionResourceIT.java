package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.AvisAttribution;
import sn.ssi.sigmap.repository.AvisAttributionRepository;
import sn.ssi.sigmap.service.AvisAttributionService;
import sn.ssi.sigmap.service.dto.AvisAttributionDTO;
import sn.ssi.sigmap.service.mapper.AvisAttributionMapper;

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
 * Integration tests for the {@link AvisAttributionResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AvisAttributionResourceIT {

    private static final String DEFAULT_ATTRI_OBJET = "AAAAAAAAAA";
    private static final String UPDATED_ATTRI_OBJET = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRI_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ATTRI_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRITEXTE = "AAAAAAAAAA";
    private static final String UPDATED_ATTRITEXTE = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRI_REF = "AAAAAAAAAA";
    private static final String UPDATED_ATTRI_REF = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRIFICHIER = "AAAAAAAAAA";
    private static final String UPDATED_ATTRIFICHIER = "BBBBBBBBBB";

    private static final String DEFAULT_ATTRI_RAISONSOCIAL = "AAAAAAAAAA";
    private static final String UPDATED_ATTRI_RAISONSOCIAL = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_ATTRI_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ATTRI_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_ATTRIDATEPUBLICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ATTRIDATEPUBLICATION = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ATTRI_PUB = 1;
    private static final Integer UPDATED_ATTRI_PUB = 2;

    private static final Long DEFAULT_AUTIRITE_ID = 1L;
    private static final Long UPDATED_AUTIRITE_ID = 2L;

    @Autowired
    private AvisAttributionRepository avisAttributionRepository;

    @Autowired
    private AvisAttributionMapper avisAttributionMapper;

    @Autowired
    private AvisAttributionService avisAttributionService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAvisAttributionMockMvc;

    private AvisAttribution avisAttribution;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AvisAttribution createEntity(EntityManager em) {
        AvisAttribution avisAttribution = new AvisAttribution()
            .attriObjet(DEFAULT_ATTRI_OBJET)
            .attriType(DEFAULT_ATTRI_TYPE)
            .attritexte(DEFAULT_ATTRITEXTE)
            .attriRef(DEFAULT_ATTRI_REF)
            .attrifichier(DEFAULT_ATTRIFICHIER)
            .attriRaisonsocial(DEFAULT_ATTRI_RAISONSOCIAL)
            .attriDate(DEFAULT_ATTRI_DATE)
            .attridatepublication(DEFAULT_ATTRIDATEPUBLICATION)
            .attriPub(DEFAULT_ATTRI_PUB)
            .autiriteId(DEFAULT_AUTIRITE_ID);
        return avisAttribution;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AvisAttribution createUpdatedEntity(EntityManager em) {
        AvisAttribution avisAttribution = new AvisAttribution()
            .attriObjet(UPDATED_ATTRI_OBJET)
            .attriType(UPDATED_ATTRI_TYPE)
            .attritexte(UPDATED_ATTRITEXTE)
            .attriRef(UPDATED_ATTRI_REF)
            .attrifichier(UPDATED_ATTRIFICHIER)
            .attriRaisonsocial(UPDATED_ATTRI_RAISONSOCIAL)
            .attriDate(UPDATED_ATTRI_DATE)
            .attridatepublication(UPDATED_ATTRIDATEPUBLICATION)
            .attriPub(UPDATED_ATTRI_PUB)
            .autiriteId(UPDATED_AUTIRITE_ID);
        return avisAttribution;
    }

    @BeforeEach
    public void initTest() {
        avisAttribution = createEntity(em);
    }

    @Test
    @Transactional
    public void createAvisAttribution() throws Exception {
        int databaseSizeBeforeCreate = avisAttributionRepository.findAll().size();
        // Create the AvisAttribution
        AvisAttributionDTO avisAttributionDTO = avisAttributionMapper.toDto(avisAttribution);
        restAvisAttributionMockMvc.perform(post("/api/avis-attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avisAttributionDTO)))
            .andExpect(status().isCreated());

        // Validate the AvisAttribution in the database
        List<AvisAttribution> avisAttributionList = avisAttributionRepository.findAll();
        assertThat(avisAttributionList).hasSize(databaseSizeBeforeCreate + 1);
        AvisAttribution testAvisAttribution = avisAttributionList.get(avisAttributionList.size() - 1);
        assertThat(testAvisAttribution.getAttriObjet()).isEqualTo(DEFAULT_ATTRI_OBJET);
        assertThat(testAvisAttribution.getAttriType()).isEqualTo(DEFAULT_ATTRI_TYPE);
        assertThat(testAvisAttribution.getAttritexte()).isEqualTo(DEFAULT_ATTRITEXTE);
        assertThat(testAvisAttribution.getAttriRef()).isEqualTo(DEFAULT_ATTRI_REF);
        assertThat(testAvisAttribution.getAttrifichier()).isEqualTo(DEFAULT_ATTRIFICHIER);
        assertThat(testAvisAttribution.getAttriRaisonsocial()).isEqualTo(DEFAULT_ATTRI_RAISONSOCIAL);
        assertThat(testAvisAttribution.getAttriDate()).isEqualTo(DEFAULT_ATTRI_DATE);
        assertThat(testAvisAttribution.getAttridatepublication()).isEqualTo(DEFAULT_ATTRIDATEPUBLICATION);
        assertThat(testAvisAttribution.getAttriPub()).isEqualTo(DEFAULT_ATTRI_PUB);
        assertThat(testAvisAttribution.getAutiriteId()).isEqualTo(DEFAULT_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void createAvisAttributionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = avisAttributionRepository.findAll().size();

        // Create the AvisAttribution with an existing ID
        avisAttribution.setId(1L);
        AvisAttributionDTO avisAttributionDTO = avisAttributionMapper.toDto(avisAttribution);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAvisAttributionMockMvc.perform(post("/api/avis-attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avisAttributionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AvisAttribution in the database
        List<AvisAttribution> avisAttributionList = avisAttributionRepository.findAll();
        assertThat(avisAttributionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAvisAttributions() throws Exception {
        // Initialize the database
        avisAttributionRepository.saveAndFlush(avisAttribution);

        // Get all the avisAttributionList
        restAvisAttributionMockMvc.perform(get("/api/avis-attributions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(avisAttribution.getId().intValue())))
            .andExpect(jsonPath("$.[*].attriObjet").value(hasItem(DEFAULT_ATTRI_OBJET)))
            .andExpect(jsonPath("$.[*].attriType").value(hasItem(DEFAULT_ATTRI_TYPE)))
            .andExpect(jsonPath("$.[*].attritexte").value(hasItem(DEFAULT_ATTRITEXTE)))
            .andExpect(jsonPath("$.[*].attriRef").value(hasItem(DEFAULT_ATTRI_REF)))
            .andExpect(jsonPath("$.[*].attrifichier").value(hasItem(DEFAULT_ATTRIFICHIER)))
            .andExpect(jsonPath("$.[*].attriRaisonsocial").value(hasItem(DEFAULT_ATTRI_RAISONSOCIAL)))
            .andExpect(jsonPath("$.[*].attriDate").value(hasItem(DEFAULT_ATTRI_DATE.toString())))
            .andExpect(jsonPath("$.[*].attridatepublication").value(hasItem(DEFAULT_ATTRIDATEPUBLICATION.toString())))
            .andExpect(jsonPath("$.[*].attriPub").value(hasItem(DEFAULT_ATTRI_PUB)))
            .andExpect(jsonPath("$.[*].autiriteId").value(hasItem(DEFAULT_AUTIRITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getAvisAttribution() throws Exception {
        // Initialize the database
        avisAttributionRepository.saveAndFlush(avisAttribution);

        // Get the avisAttribution
        restAvisAttributionMockMvc.perform(get("/api/avis-attributions/{id}", avisAttribution.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(avisAttribution.getId().intValue()))
            .andExpect(jsonPath("$.attriObjet").value(DEFAULT_ATTRI_OBJET))
            .andExpect(jsonPath("$.attriType").value(DEFAULT_ATTRI_TYPE))
            .andExpect(jsonPath("$.attritexte").value(DEFAULT_ATTRITEXTE))
            .andExpect(jsonPath("$.attriRef").value(DEFAULT_ATTRI_REF))
            .andExpect(jsonPath("$.attrifichier").value(DEFAULT_ATTRIFICHIER))
            .andExpect(jsonPath("$.attriRaisonsocial").value(DEFAULT_ATTRI_RAISONSOCIAL))
            .andExpect(jsonPath("$.attriDate").value(DEFAULT_ATTRI_DATE.toString()))
            .andExpect(jsonPath("$.attridatepublication").value(DEFAULT_ATTRIDATEPUBLICATION.toString()))
            .andExpect(jsonPath("$.attriPub").value(DEFAULT_ATTRI_PUB))
            .andExpect(jsonPath("$.autiriteId").value(DEFAULT_AUTIRITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAvisAttribution() throws Exception {
        // Get the avisAttribution
        restAvisAttributionMockMvc.perform(get("/api/avis-attributions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAvisAttribution() throws Exception {
        // Initialize the database
        avisAttributionRepository.saveAndFlush(avisAttribution);

        int databaseSizeBeforeUpdate = avisAttributionRepository.findAll().size();

        // Update the avisAttribution
        AvisAttribution updatedAvisAttribution = avisAttributionRepository.findById(avisAttribution.getId()).get();
        // Disconnect from session so that the updates on updatedAvisAttribution are not directly saved in db
        em.detach(updatedAvisAttribution);
        updatedAvisAttribution
            .attriObjet(UPDATED_ATTRI_OBJET)
            .attriType(UPDATED_ATTRI_TYPE)
            .attritexte(UPDATED_ATTRITEXTE)
            .attriRef(UPDATED_ATTRI_REF)
            .attrifichier(UPDATED_ATTRIFICHIER)
            .attriRaisonsocial(UPDATED_ATTRI_RAISONSOCIAL)
            .attriDate(UPDATED_ATTRI_DATE)
            .attridatepublication(UPDATED_ATTRIDATEPUBLICATION)
            .attriPub(UPDATED_ATTRI_PUB)
            .autiriteId(UPDATED_AUTIRITE_ID);
        AvisAttributionDTO avisAttributionDTO = avisAttributionMapper.toDto(updatedAvisAttribution);

        restAvisAttributionMockMvc.perform(put("/api/avis-attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avisAttributionDTO)))
            .andExpect(status().isOk());

        // Validate the AvisAttribution in the database
        List<AvisAttribution> avisAttributionList = avisAttributionRepository.findAll();
        assertThat(avisAttributionList).hasSize(databaseSizeBeforeUpdate);
        AvisAttribution testAvisAttribution = avisAttributionList.get(avisAttributionList.size() - 1);
        assertThat(testAvisAttribution.getAttriObjet()).isEqualTo(UPDATED_ATTRI_OBJET);
        assertThat(testAvisAttribution.getAttriType()).isEqualTo(UPDATED_ATTRI_TYPE);
        assertThat(testAvisAttribution.getAttritexte()).isEqualTo(UPDATED_ATTRITEXTE);
        assertThat(testAvisAttribution.getAttriRef()).isEqualTo(UPDATED_ATTRI_REF);
        assertThat(testAvisAttribution.getAttrifichier()).isEqualTo(UPDATED_ATTRIFICHIER);
        assertThat(testAvisAttribution.getAttriRaisonsocial()).isEqualTo(UPDATED_ATTRI_RAISONSOCIAL);
        assertThat(testAvisAttribution.getAttriDate()).isEqualTo(UPDATED_ATTRI_DATE);
        assertThat(testAvisAttribution.getAttridatepublication()).isEqualTo(UPDATED_ATTRIDATEPUBLICATION);
        assertThat(testAvisAttribution.getAttriPub()).isEqualTo(UPDATED_ATTRI_PUB);
        assertThat(testAvisAttribution.getAutiriteId()).isEqualTo(UPDATED_AUTIRITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingAvisAttribution() throws Exception {
        int databaseSizeBeforeUpdate = avisAttributionRepository.findAll().size();

        // Create the AvisAttribution
        AvisAttributionDTO avisAttributionDTO = avisAttributionMapper.toDto(avisAttribution);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAvisAttributionMockMvc.perform(put("/api/avis-attributions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avisAttributionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AvisAttribution in the database
        List<AvisAttribution> avisAttributionList = avisAttributionRepository.findAll();
        assertThat(avisAttributionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAvisAttribution() throws Exception {
        // Initialize the database
        avisAttributionRepository.saveAndFlush(avisAttribution);

        int databaseSizeBeforeDelete = avisAttributionRepository.findAll().size();

        // Delete the avisAttribution
        restAvisAttributionMockMvc.perform(delete("/api/avis-attributions/{id}", avisAttribution.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AvisAttribution> avisAttributionList = avisAttributionRepository.findAll();
        assertThat(avisAttributionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
