package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.RepresentantServTech;
import sn.ssi.sigmap.repository.RepresentantServTechRepository;
import sn.ssi.sigmap.service.RepresentantServTechService;
import sn.ssi.sigmap.service.dto.RepresentantServTechDTO;
import sn.ssi.sigmap.service.mapper.RepresentantServTechMapper;

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
 * Integration tests for the {@link RepresentantServTechResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class RepresentantServTechResourceIT {

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
    private RepresentantServTechRepository representantServTechRepository;

    @Autowired
    private RepresentantServTechMapper representantServTechMapper;

    @Autowired
    private RepresentantServTechService representantServTechService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRepresentantServTechMockMvc;

    private RepresentantServTech representantServTech;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RepresentantServTech createEntity(EntityManager em) {
        RepresentantServTech representantServTech = new RepresentantServTech()
            .representant(DEFAULT_REPRESENTANT)
            .qualite(DEFAULT_QUALITE)
            .presence(DEFAULT_PRESENCE)
            .dateConvocation(DEFAULT_DATE_CONVOCATION)
            .etape(DEFAULT_ETAPE);
        return representantServTech;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RepresentantServTech createUpdatedEntity(EntityManager em) {
        RepresentantServTech representantServTech = new RepresentantServTech()
            .representant(UPDATED_REPRESENTANT)
            .qualite(UPDATED_QUALITE)
            .presence(UPDATED_PRESENCE)
            .dateConvocation(UPDATED_DATE_CONVOCATION)
            .etape(UPDATED_ETAPE);
        return representantServTech;
    }

    @BeforeEach
    public void initTest() {
        representantServTech = createEntity(em);
    }

    @Test
    @Transactional
    public void createRepresentantServTech() throws Exception {
        int databaseSizeBeforeCreate = representantServTechRepository.findAll().size();
        // Create the RepresentantServTech
        RepresentantServTechDTO representantServTechDTO = representantServTechMapper.toDto(representantServTech);
        restRepresentantServTechMockMvc.perform(post("/api/representant-serv-teches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(representantServTechDTO)))
            .andExpect(status().isCreated());

        // Validate the RepresentantServTech in the database
        List<RepresentantServTech> representantServTechList = representantServTechRepository.findAll();
        assertThat(representantServTechList).hasSize(databaseSizeBeforeCreate + 1);
        RepresentantServTech testRepresentantServTech = representantServTechList.get(representantServTechList.size() - 1);
        assertThat(testRepresentantServTech.getRepresentant()).isEqualTo(DEFAULT_REPRESENTANT);
        assertThat(testRepresentantServTech.getQualite()).isEqualTo(DEFAULT_QUALITE);
        assertThat(testRepresentantServTech.getPresence()).isEqualTo(DEFAULT_PRESENCE);
        assertThat(testRepresentantServTech.getDateConvocation()).isEqualTo(DEFAULT_DATE_CONVOCATION);
        assertThat(testRepresentantServTech.getEtape()).isEqualTo(DEFAULT_ETAPE);
    }

    @Test
    @Transactional
    public void createRepresentantServTechWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = representantServTechRepository.findAll().size();

        // Create the RepresentantServTech with an existing ID
        representantServTech.setId(1L);
        RepresentantServTechDTO representantServTechDTO = representantServTechMapper.toDto(representantServTech);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRepresentantServTechMockMvc.perform(post("/api/representant-serv-teches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(representantServTechDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RepresentantServTech in the database
        List<RepresentantServTech> representantServTechList = representantServTechRepository.findAll();
        assertThat(representantServTechList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRepresentantServTeches() throws Exception {
        // Initialize the database
        representantServTechRepository.saveAndFlush(representantServTech);

        // Get all the representantServTechList
        restRepresentantServTechMockMvc.perform(get("/api/representant-serv-teches?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(representantServTech.getId().intValue())))
            .andExpect(jsonPath("$.[*].representant").value(hasItem(DEFAULT_REPRESENTANT)))
            .andExpect(jsonPath("$.[*].qualite").value(hasItem(DEFAULT_QUALITE)))
            .andExpect(jsonPath("$.[*].presence").value(hasItem(DEFAULT_PRESENCE)))
            .andExpect(jsonPath("$.[*].dateConvocation").value(hasItem(DEFAULT_DATE_CONVOCATION.toString())))
            .andExpect(jsonPath("$.[*].etape").value(hasItem(DEFAULT_ETAPE)));
    }
    
    @Test
    @Transactional
    public void getRepresentantServTech() throws Exception {
        // Initialize the database
        representantServTechRepository.saveAndFlush(representantServTech);

        // Get the representantServTech
        restRepresentantServTechMockMvc.perform(get("/api/representant-serv-teches/{id}", representantServTech.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(representantServTech.getId().intValue()))
            .andExpect(jsonPath("$.representant").value(DEFAULT_REPRESENTANT))
            .andExpect(jsonPath("$.qualite").value(DEFAULT_QUALITE))
            .andExpect(jsonPath("$.presence").value(DEFAULT_PRESENCE))
            .andExpect(jsonPath("$.dateConvocation").value(DEFAULT_DATE_CONVOCATION.toString()))
            .andExpect(jsonPath("$.etape").value(DEFAULT_ETAPE));
    }
    @Test
    @Transactional
    public void getNonExistingRepresentantServTech() throws Exception {
        // Get the representantServTech
        restRepresentantServTechMockMvc.perform(get("/api/representant-serv-teches/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRepresentantServTech() throws Exception {
        // Initialize the database
        representantServTechRepository.saveAndFlush(representantServTech);

        int databaseSizeBeforeUpdate = representantServTechRepository.findAll().size();

        // Update the representantServTech
        RepresentantServTech updatedRepresentantServTech = representantServTechRepository.findById(representantServTech.getId()).get();
        // Disconnect from session so that the updates on updatedRepresentantServTech are not directly saved in db
        em.detach(updatedRepresentantServTech);
        updatedRepresentantServTech
            .representant(UPDATED_REPRESENTANT)
            .qualite(UPDATED_QUALITE)
            .presence(UPDATED_PRESENCE)
            .dateConvocation(UPDATED_DATE_CONVOCATION)
            .etape(UPDATED_ETAPE);
        RepresentantServTechDTO representantServTechDTO = representantServTechMapper.toDto(updatedRepresentantServTech);

        restRepresentantServTechMockMvc.perform(put("/api/representant-serv-teches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(representantServTechDTO)))
            .andExpect(status().isOk());

        // Validate the RepresentantServTech in the database
        List<RepresentantServTech> representantServTechList = representantServTechRepository.findAll();
        assertThat(representantServTechList).hasSize(databaseSizeBeforeUpdate);
        RepresentantServTech testRepresentantServTech = representantServTechList.get(representantServTechList.size() - 1);
        assertThat(testRepresentantServTech.getRepresentant()).isEqualTo(UPDATED_REPRESENTANT);
        assertThat(testRepresentantServTech.getQualite()).isEqualTo(UPDATED_QUALITE);
        assertThat(testRepresentantServTech.getPresence()).isEqualTo(UPDATED_PRESENCE);
        assertThat(testRepresentantServTech.getDateConvocation()).isEqualTo(UPDATED_DATE_CONVOCATION);
        assertThat(testRepresentantServTech.getEtape()).isEqualTo(UPDATED_ETAPE);
    }

    @Test
    @Transactional
    public void updateNonExistingRepresentantServTech() throws Exception {
        int databaseSizeBeforeUpdate = representantServTechRepository.findAll().size();

        // Create the RepresentantServTech
        RepresentantServTechDTO representantServTechDTO = representantServTechMapper.toDto(representantServTech);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRepresentantServTechMockMvc.perform(put("/api/representant-serv-teches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(representantServTechDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RepresentantServTech in the database
        List<RepresentantServTech> representantServTechList = representantServTechRepository.findAll();
        assertThat(representantServTechList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRepresentantServTech() throws Exception {
        // Initialize the database
        representantServTechRepository.saveAndFlush(representantServTech);

        int databaseSizeBeforeDelete = representantServTechRepository.findAll().size();

        // Delete the representantServTech
        restRepresentantServTechMockMvc.perform(delete("/api/representant-serv-teches/{id}", representantServTech.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<RepresentantServTech> representantServTechList = representantServTechRepository.findAll();
        assertThat(representantServTechList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
