package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.ObservateursIndependant;
import sn.ssi.sigmap.repository.ObservateursIndependantRepository;
import sn.ssi.sigmap.service.ObservateursIndependantService;
import sn.ssi.sigmap.service.dto.ObservateursIndependantDTO;
import sn.ssi.sigmap.service.mapper.ObservateursIndependantMapper;

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
 * Integration tests for the {@link ObservateursIndependantResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class ObservateursIndependantResourceIT {

    private static final String DEFAULT_REPRESENTANT = "AAAAAAAAAA";
    private static final String UPDATED_REPRESENTANT = "BBBBBBBBBB";

    private static final String DEFAULT_QUALITE = "AAAAAAAAAA";
    private static final String UPDATED_QUALITE = "BBBBBBBBBB";

    private static final String DEFAULT_PRESENCE = "AAAAAAAAAA";
    private static final String UPDATED_PRESENCE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CONVOCATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CONVOCATION = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ETAPE = 1;
    private static final Integer UPDATED_ETAPE = 2;

    @Autowired
    private ObservateursIndependantRepository observateursIndependantRepository;

    @Autowired
    private ObservateursIndependantMapper observateursIndependantMapper;

    @Autowired
    private ObservateursIndependantService observateursIndependantService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restObservateursIndependantMockMvc;

    private ObservateursIndependant observateursIndependant;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ObservateursIndependant createEntity(EntityManager em) {
        ObservateursIndependant observateursIndependant = new ObservateursIndependant()
            .representant(DEFAULT_REPRESENTANT)
            .qualite(DEFAULT_QUALITE)
            .presence(DEFAULT_PRESENCE)
            .dateConvocation(DEFAULT_DATE_CONVOCATION)
            .etape(DEFAULT_ETAPE);
        return observateursIndependant;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ObservateursIndependant createUpdatedEntity(EntityManager em) {
        ObservateursIndependant observateursIndependant = new ObservateursIndependant()
            .representant(UPDATED_REPRESENTANT)
            .qualite(UPDATED_QUALITE)
            .presence(UPDATED_PRESENCE)
            .dateConvocation(UPDATED_DATE_CONVOCATION)
            .etape(UPDATED_ETAPE);
        return observateursIndependant;
    }

    @BeforeEach
    public void initTest() {
        observateursIndependant = createEntity(em);
    }

    @Test
    @Transactional
    public void createObservateursIndependant() throws Exception {
        int databaseSizeBeforeCreate = observateursIndependantRepository.findAll().size();
        // Create the ObservateursIndependant
        ObservateursIndependantDTO observateursIndependantDTO = observateursIndependantMapper.toDto(observateursIndependant);
        restObservateursIndependantMockMvc.perform(post("/api/observateurs-independants")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(observateursIndependantDTO)))
            .andExpect(status().isCreated());

        // Validate the ObservateursIndependant in the database
        List<ObservateursIndependant> observateursIndependantList = observateursIndependantRepository.findAll();
        assertThat(observateursIndependantList).hasSize(databaseSizeBeforeCreate + 1);
        ObservateursIndependant testObservateursIndependant = observateursIndependantList.get(observateursIndependantList.size() - 1);
        assertThat(testObservateursIndependant.getRepresentant()).isEqualTo(DEFAULT_REPRESENTANT);
        assertThat(testObservateursIndependant.getQualite()).isEqualTo(DEFAULT_QUALITE);
        assertThat(testObservateursIndependant.getPresence()).isEqualTo(DEFAULT_PRESENCE);
        assertThat(testObservateursIndependant.getDateConvocation()).isEqualTo(DEFAULT_DATE_CONVOCATION);
        assertThat(testObservateursIndependant.getEtape()).isEqualTo(DEFAULT_ETAPE);
    }

    @Test
    @Transactional
    public void createObservateursIndependantWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = observateursIndependantRepository.findAll().size();

        // Create the ObservateursIndependant with an existing ID
        observateursIndependant.setId(1L);
        ObservateursIndependantDTO observateursIndependantDTO = observateursIndependantMapper.toDto(observateursIndependant);

        // An entity with an existing ID cannot be created, so this API call must fail
        restObservateursIndependantMockMvc.perform(post("/api/observateurs-independants")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(observateursIndependantDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ObservateursIndependant in the database
        List<ObservateursIndependant> observateursIndependantList = observateursIndependantRepository.findAll();
        assertThat(observateursIndependantList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllObservateursIndependants() throws Exception {
        // Initialize the database
        observateursIndependantRepository.saveAndFlush(observateursIndependant);

        // Get all the observateursIndependantList
        restObservateursIndependantMockMvc.perform(get("/api/observateurs-independants?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(observateursIndependant.getId().intValue())))
            .andExpect(jsonPath("$.[*].representant").value(hasItem(DEFAULT_REPRESENTANT)))
            .andExpect(jsonPath("$.[*].qualite").value(hasItem(DEFAULT_QUALITE)))
            .andExpect(jsonPath("$.[*].presence").value(hasItem(DEFAULT_PRESENCE)))
            .andExpect(jsonPath("$.[*].dateConvocation").value(hasItem(DEFAULT_DATE_CONVOCATION.toString())))
            .andExpect(jsonPath("$.[*].etape").value(hasItem(DEFAULT_ETAPE)));
    }
    
    @Test
    @Transactional
    public void getObservateursIndependant() throws Exception {
        // Initialize the database
        observateursIndependantRepository.saveAndFlush(observateursIndependant);

        // Get the observateursIndependant
        restObservateursIndependantMockMvc.perform(get("/api/observateurs-independants/{id}", observateursIndependant.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(observateursIndependant.getId().intValue()))
            .andExpect(jsonPath("$.representant").value(DEFAULT_REPRESENTANT))
            .andExpect(jsonPath("$.qualite").value(DEFAULT_QUALITE))
            .andExpect(jsonPath("$.presence").value(DEFAULT_PRESENCE))
            .andExpect(jsonPath("$.dateConvocation").value(DEFAULT_DATE_CONVOCATION.toString()))
            .andExpect(jsonPath("$.etape").value(DEFAULT_ETAPE));
    }
    @Test
    @Transactional
    public void getNonExistingObservateursIndependant() throws Exception {
        // Get the observateursIndependant
        restObservateursIndependantMockMvc.perform(get("/api/observateurs-independants/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateObservateursIndependant() throws Exception {
        // Initialize the database
        observateursIndependantRepository.saveAndFlush(observateursIndependant);

        int databaseSizeBeforeUpdate = observateursIndependantRepository.findAll().size();

        // Update the observateursIndependant
        ObservateursIndependant updatedObservateursIndependant = observateursIndependantRepository.findById(observateursIndependant.getId()).get();
        // Disconnect from session so that the updates on updatedObservateursIndependant are not directly saved in db
        em.detach(updatedObservateursIndependant);
        updatedObservateursIndependant
            .representant(UPDATED_REPRESENTANT)
            .qualite(UPDATED_QUALITE)
            .presence(UPDATED_PRESENCE)
            .dateConvocation(UPDATED_DATE_CONVOCATION)
            .etape(UPDATED_ETAPE);
        ObservateursIndependantDTO observateursIndependantDTO = observateursIndependantMapper.toDto(updatedObservateursIndependant);

        restObservateursIndependantMockMvc.perform(put("/api/observateurs-independants")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(observateursIndependantDTO)))
            .andExpect(status().isOk());

        // Validate the ObservateursIndependant in the database
        List<ObservateursIndependant> observateursIndependantList = observateursIndependantRepository.findAll();
        assertThat(observateursIndependantList).hasSize(databaseSizeBeforeUpdate);
        ObservateursIndependant testObservateursIndependant = observateursIndependantList.get(observateursIndependantList.size() - 1);
        assertThat(testObservateursIndependant.getRepresentant()).isEqualTo(UPDATED_REPRESENTANT);
        assertThat(testObservateursIndependant.getQualite()).isEqualTo(UPDATED_QUALITE);
        assertThat(testObservateursIndependant.getPresence()).isEqualTo(UPDATED_PRESENCE);
        assertThat(testObservateursIndependant.getDateConvocation()).isEqualTo(UPDATED_DATE_CONVOCATION);
        assertThat(testObservateursIndependant.getEtape()).isEqualTo(UPDATED_ETAPE);
    }

    @Test
    @Transactional
    public void updateNonExistingObservateursIndependant() throws Exception {
        int databaseSizeBeforeUpdate = observateursIndependantRepository.findAll().size();

        // Create the ObservateursIndependant
        ObservateursIndependantDTO observateursIndependantDTO = observateursIndependantMapper.toDto(observateursIndependant);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restObservateursIndependantMockMvc.perform(put("/api/observateurs-independants")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(observateursIndependantDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ObservateursIndependant in the database
        List<ObservateursIndependant> observateursIndependantList = observateursIndependantRepository.findAll();
        assertThat(observateursIndependantList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteObservateursIndependant() throws Exception {
        // Initialize the database
        observateursIndependantRepository.saveAndFlush(observateursIndependant);

        int databaseSizeBeforeDelete = observateursIndependantRepository.findAll().size();

        // Delete the observateursIndependant
        restObservateursIndependantMockMvc.perform(delete("/api/observateurs-independants/{id}", observateursIndependant.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ObservateursIndependant> observateursIndependantList = observateursIndependantRepository.findAll();
        assertThat(observateursIndependantList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
