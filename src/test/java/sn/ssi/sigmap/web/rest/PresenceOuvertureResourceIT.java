package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.PresenceOuverture;
import sn.ssi.sigmap.repository.PresenceOuvertureRepository;
import sn.ssi.sigmap.service.PresenceOuvertureService;
import sn.ssi.sigmap.service.dto.PresenceOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PresenceOuvertureMapper;

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
 * Integration tests for the {@link PresenceOuvertureResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PresenceOuvertureResourceIT {

    private static final String DEFAULT_SUPPLEMENTAIRE = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLEMENTAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_REPRESENTANT = "AAAAAAAAAA";
    private static final String UPDATED_NOM_REPRESENTANT = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM_REPRESENTANT = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM_REPRESENTANT = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_STRUCTURE = "AAAAAAAAAA";
    private static final String UPDATED_NOM_STRUCTURE = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ETAPE_PI = 1;
    private static final Integer UPDATED_ETAPE_PI = 2;

    @Autowired
    private PresenceOuvertureRepository presenceOuvertureRepository;

    @Autowired
    private PresenceOuvertureMapper presenceOuvertureMapper;

    @Autowired
    private PresenceOuvertureService presenceOuvertureService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPresenceOuvertureMockMvc;

    private PresenceOuverture presenceOuverture;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PresenceOuverture createEntity(EntityManager em) {
        PresenceOuverture presenceOuverture = new PresenceOuverture()
            .supplementaire(DEFAULT_SUPPLEMENTAIRE)
            .email(DEFAULT_EMAIL)
            .telephone(DEFAULT_TELEPHONE)
            .nomRepresentant(DEFAULT_NOM_REPRESENTANT)
            .prenomRepresentant(DEFAULT_PRENOM_REPRESENTANT)
            .nomStructure(DEFAULT_NOM_STRUCTURE)
            .qualite(DEFAULT_QUALITE)
            .etapePI(DEFAULT_ETAPE_PI);
        return presenceOuverture;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PresenceOuverture createUpdatedEntity(EntityManager em) {
        PresenceOuverture presenceOuverture = new PresenceOuverture()
            .supplementaire(UPDATED_SUPPLEMENTAIRE)
            .email(UPDATED_EMAIL)
            .telephone(UPDATED_TELEPHONE)
            .nomRepresentant(UPDATED_NOM_REPRESENTANT)
            .prenomRepresentant(UPDATED_PRENOM_REPRESENTANT)
            .nomStructure(UPDATED_NOM_STRUCTURE)
            .qualite(UPDATED_QUALITE)
            .etapePI(UPDATED_ETAPE_PI);
        return presenceOuverture;
    }

    @BeforeEach
    public void initTest() {
        presenceOuverture = createEntity(em);
    }

    @Test
    @Transactional
    public void createPresenceOuverture() throws Exception {
        int databaseSizeBeforeCreate = presenceOuvertureRepository.findAll().size();
        // Create the PresenceOuverture
        PresenceOuvertureDTO presenceOuvertureDTO = presenceOuvertureMapper.toDto(presenceOuverture);
        restPresenceOuvertureMockMvc.perform(post("/api/presence-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(presenceOuvertureDTO)))
            .andExpect(status().isCreated());

        // Validate the PresenceOuverture in the database
        List<PresenceOuverture> presenceOuvertureList = presenceOuvertureRepository.findAll();
        assertThat(presenceOuvertureList).hasSize(databaseSizeBeforeCreate + 1);
        PresenceOuverture testPresenceOuverture = presenceOuvertureList.get(presenceOuvertureList.size() - 1);
        assertThat(testPresenceOuverture.getSupplementaire()).isEqualTo(DEFAULT_SUPPLEMENTAIRE);
        assertThat(testPresenceOuverture.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testPresenceOuverture.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testPresenceOuverture.getNomRepresentant()).isEqualTo(DEFAULT_NOM_REPRESENTANT);
        assertThat(testPresenceOuverture.getPrenomRepresentant()).isEqualTo(DEFAULT_PRENOM_REPRESENTANT);
        assertThat(testPresenceOuverture.getNomStructure()).isEqualTo(DEFAULT_NOM_STRUCTURE);
        assertThat(testPresenceOuverture.getQualite()).isEqualTo(DEFAULT_QUALITE);
        assertThat(testPresenceOuverture.getEtapePI()).isEqualTo(DEFAULT_ETAPE_PI);
    }

    @Test
    @Transactional
    public void createPresenceOuvertureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = presenceOuvertureRepository.findAll().size();

        // Create the PresenceOuverture with an existing ID
        presenceOuverture.setId(1L);
        PresenceOuvertureDTO presenceOuvertureDTO = presenceOuvertureMapper.toDto(presenceOuverture);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPresenceOuvertureMockMvc.perform(post("/api/presence-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(presenceOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PresenceOuverture in the database
        List<PresenceOuverture> presenceOuvertureList = presenceOuvertureRepository.findAll();
        assertThat(presenceOuvertureList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPresenceOuvertures() throws Exception {
        // Initialize the database
        presenceOuvertureRepository.saveAndFlush(presenceOuverture);

        // Get all the presenceOuvertureList
        restPresenceOuvertureMockMvc.perform(get("/api/presence-ouvertures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(presenceOuverture.getId().intValue())))
            .andExpect(jsonPath("$.[*].supplementaire").value(hasItem(DEFAULT_SUPPLEMENTAIRE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].nomRepresentant").value(hasItem(DEFAULT_NOM_REPRESENTANT)))
            .andExpect(jsonPath("$.[*].prenomRepresentant").value(hasItem(DEFAULT_PRENOM_REPRESENTANT)))
            .andExpect(jsonPath("$.[*].nomStructure").value(hasItem(DEFAULT_NOM_STRUCTURE)))
            .andExpect(jsonPath("$.[*].qualite").value(hasItem(DEFAULT_QUALITE)))
            .andExpect(jsonPath("$.[*].etapePI").value(hasItem(DEFAULT_ETAPE_PI)));
    }
    
    @Test
    @Transactional
    public void getPresenceOuverture() throws Exception {
        // Initialize the database
        presenceOuvertureRepository.saveAndFlush(presenceOuverture);

        // Get the presenceOuverture
        restPresenceOuvertureMockMvc.perform(get("/api/presence-ouvertures/{id}", presenceOuverture.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(presenceOuverture.getId().intValue()))
            .andExpect(jsonPath("$.supplementaire").value(DEFAULT_SUPPLEMENTAIRE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.nomRepresentant").value(DEFAULT_NOM_REPRESENTANT))
            .andExpect(jsonPath("$.prenomRepresentant").value(DEFAULT_PRENOM_REPRESENTANT))
            .andExpect(jsonPath("$.nomStructure").value(DEFAULT_NOM_STRUCTURE))
            .andExpect(jsonPath("$.qualite").value(DEFAULT_QUALITE))
            .andExpect(jsonPath("$.etapePI").value(DEFAULT_ETAPE_PI));
    }
    @Test
    @Transactional
    public void getNonExistingPresenceOuverture() throws Exception {
        // Get the presenceOuverture
        restPresenceOuvertureMockMvc.perform(get("/api/presence-ouvertures/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePresenceOuverture() throws Exception {
        // Initialize the database
        presenceOuvertureRepository.saveAndFlush(presenceOuverture);

        int databaseSizeBeforeUpdate = presenceOuvertureRepository.findAll().size();

        // Update the presenceOuverture
        PresenceOuverture updatedPresenceOuverture = presenceOuvertureRepository.findById(presenceOuverture.getId()).get();
        // Disconnect from session so that the updates on updatedPresenceOuverture are not directly saved in db
        em.detach(updatedPresenceOuverture);
        updatedPresenceOuverture
            .supplementaire(UPDATED_SUPPLEMENTAIRE)
            .email(UPDATED_EMAIL)
            .telephone(UPDATED_TELEPHONE)
            .nomRepresentant(UPDATED_NOM_REPRESENTANT)
            .prenomRepresentant(UPDATED_PRENOM_REPRESENTANT)
            .nomStructure(UPDATED_NOM_STRUCTURE)
            .qualite(UPDATED_QUALITE)
            .etapePI(UPDATED_ETAPE_PI);
        PresenceOuvertureDTO presenceOuvertureDTO = presenceOuvertureMapper.toDto(updatedPresenceOuverture);

        restPresenceOuvertureMockMvc.perform(put("/api/presence-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(presenceOuvertureDTO)))
            .andExpect(status().isOk());

        // Validate the PresenceOuverture in the database
        List<PresenceOuverture> presenceOuvertureList = presenceOuvertureRepository.findAll();
        assertThat(presenceOuvertureList).hasSize(databaseSizeBeforeUpdate);
        PresenceOuverture testPresenceOuverture = presenceOuvertureList.get(presenceOuvertureList.size() - 1);
        assertThat(testPresenceOuverture.getSupplementaire()).isEqualTo(UPDATED_SUPPLEMENTAIRE);
        assertThat(testPresenceOuverture.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testPresenceOuverture.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testPresenceOuverture.getNomRepresentant()).isEqualTo(UPDATED_NOM_REPRESENTANT);
        assertThat(testPresenceOuverture.getPrenomRepresentant()).isEqualTo(UPDATED_PRENOM_REPRESENTANT);
        assertThat(testPresenceOuverture.getNomStructure()).isEqualTo(UPDATED_NOM_STRUCTURE);
        assertThat(testPresenceOuverture.getQualite()).isEqualTo(UPDATED_QUALITE);
        assertThat(testPresenceOuverture.getEtapePI()).isEqualTo(UPDATED_ETAPE_PI);
    }

    @Test
    @Transactional
    public void updateNonExistingPresenceOuverture() throws Exception {
        int databaseSizeBeforeUpdate = presenceOuvertureRepository.findAll().size();

        // Create the PresenceOuverture
        PresenceOuvertureDTO presenceOuvertureDTO = presenceOuvertureMapper.toDto(presenceOuverture);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPresenceOuvertureMockMvc.perform(put("/api/presence-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(presenceOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PresenceOuverture in the database
        List<PresenceOuverture> presenceOuvertureList = presenceOuvertureRepository.findAll();
        assertThat(presenceOuvertureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePresenceOuverture() throws Exception {
        // Initialize the database
        presenceOuvertureRepository.saveAndFlush(presenceOuverture);

        int databaseSizeBeforeDelete = presenceOuvertureRepository.findAll().size();

        // Delete the presenceOuverture
        restPresenceOuvertureMockMvc.perform(delete("/api/presence-ouvertures/{id}", presenceOuverture.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PresenceOuverture> presenceOuvertureList = presenceOuvertureRepository.findAll();
        assertThat(presenceOuvertureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
