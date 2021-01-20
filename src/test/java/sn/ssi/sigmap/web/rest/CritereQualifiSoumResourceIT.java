package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.CritereQualifiSoum;
import sn.ssi.sigmap.repository.CritereQualifiSoumRepository;
import sn.ssi.sigmap.service.CritereQualifiSoumService;
import sn.ssi.sigmap.service.dto.CritereQualifiSoumDTO;
import sn.ssi.sigmap.service.mapper.CritereQualifiSoumMapper;

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
 * Integration tests for the {@link CritereQualifiSoumResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CritereQualifiSoumResourceIT {

    private static final Integer DEFAULT_CONFORME = 1;
    private static final Integer UPDATED_CONFORME = 2;

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE_LOT = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE_LOT = "BBBBBBBBBB";

    @Autowired
    private CritereQualifiSoumRepository critereQualifiSoumRepository;

    @Autowired
    private CritereQualifiSoumMapper critereQualifiSoumMapper;

    @Autowired
    private CritereQualifiSoumService critereQualifiSoumService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCritereQualifiSoumMockMvc;

    private CritereQualifiSoum critereQualifiSoum;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CritereQualifiSoum createEntity(EntityManager em) {
        CritereQualifiSoum critereQualifiSoum = new CritereQualifiSoum()
            .conforme(DEFAULT_CONFORME)
            .libelle(DEFAULT_LIBELLE)
            .libelleLot(DEFAULT_LIBELLE_LOT);
        return critereQualifiSoum;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CritereQualifiSoum createUpdatedEntity(EntityManager em) {
        CritereQualifiSoum critereQualifiSoum = new CritereQualifiSoum()
            .conforme(UPDATED_CONFORME)
            .libelle(UPDATED_LIBELLE)
            .libelleLot(UPDATED_LIBELLE_LOT);
        return critereQualifiSoum;
    }

    @BeforeEach
    public void initTest() {
        critereQualifiSoum = createEntity(em);
    }

    @Test
    @Transactional
    public void createCritereQualifiSoum() throws Exception {
        int databaseSizeBeforeCreate = critereQualifiSoumRepository.findAll().size();
        // Create the CritereQualifiSoum
        CritereQualifiSoumDTO critereQualifiSoumDTO = critereQualifiSoumMapper.toDto(critereQualifiSoum);
        restCritereQualifiSoumMockMvc.perform(post("/api/critere-qualifi-soums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereQualifiSoumDTO)))
            .andExpect(status().isCreated());

        // Validate the CritereQualifiSoum in the database
        List<CritereQualifiSoum> critereQualifiSoumList = critereQualifiSoumRepository.findAll();
        assertThat(critereQualifiSoumList).hasSize(databaseSizeBeforeCreate + 1);
        CritereQualifiSoum testCritereQualifiSoum = critereQualifiSoumList.get(critereQualifiSoumList.size() - 1);
        assertThat(testCritereQualifiSoum.getConforme()).isEqualTo(DEFAULT_CONFORME);
        assertThat(testCritereQualifiSoum.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testCritereQualifiSoum.getLibelleLot()).isEqualTo(DEFAULT_LIBELLE_LOT);
    }

    @Test
    @Transactional
    public void createCritereQualifiSoumWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = critereQualifiSoumRepository.findAll().size();

        // Create the CritereQualifiSoum with an existing ID
        critereQualifiSoum.setId(1L);
        CritereQualifiSoumDTO critereQualifiSoumDTO = critereQualifiSoumMapper.toDto(critereQualifiSoum);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCritereQualifiSoumMockMvc.perform(post("/api/critere-qualifi-soums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereQualifiSoumDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CritereQualifiSoum in the database
        List<CritereQualifiSoum> critereQualifiSoumList = critereQualifiSoumRepository.findAll();
        assertThat(critereQualifiSoumList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCritereQualifiSoums() throws Exception {
        // Initialize the database
        critereQualifiSoumRepository.saveAndFlush(critereQualifiSoum);

        // Get all the critereQualifiSoumList
        restCritereQualifiSoumMockMvc.perform(get("/api/critere-qualifi-soums?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(critereQualifiSoum.getId().intValue())))
            .andExpect(jsonPath("$.[*].conforme").value(hasItem(DEFAULT_CONFORME)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].libelleLot").value(hasItem(DEFAULT_LIBELLE_LOT)));
    }
    
    @Test
    @Transactional
    public void getCritereQualifiSoum() throws Exception {
        // Initialize the database
        critereQualifiSoumRepository.saveAndFlush(critereQualifiSoum);

        // Get the critereQualifiSoum
        restCritereQualifiSoumMockMvc.perform(get("/api/critere-qualifi-soums/{id}", critereQualifiSoum.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(critereQualifiSoum.getId().intValue()))
            .andExpect(jsonPath("$.conforme").value(DEFAULT_CONFORME))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.libelleLot").value(DEFAULT_LIBELLE_LOT));
    }
    @Test
    @Transactional
    public void getNonExistingCritereQualifiSoum() throws Exception {
        // Get the critereQualifiSoum
        restCritereQualifiSoumMockMvc.perform(get("/api/critere-qualifi-soums/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCritereQualifiSoum() throws Exception {
        // Initialize the database
        critereQualifiSoumRepository.saveAndFlush(critereQualifiSoum);

        int databaseSizeBeforeUpdate = critereQualifiSoumRepository.findAll().size();

        // Update the critereQualifiSoum
        CritereQualifiSoum updatedCritereQualifiSoum = critereQualifiSoumRepository.findById(critereQualifiSoum.getId()).get();
        // Disconnect from session so that the updates on updatedCritereQualifiSoum are not directly saved in db
        em.detach(updatedCritereQualifiSoum);
        updatedCritereQualifiSoum
            .conforme(UPDATED_CONFORME)
            .libelle(UPDATED_LIBELLE)
            .libelleLot(UPDATED_LIBELLE_LOT);
        CritereQualifiSoumDTO critereQualifiSoumDTO = critereQualifiSoumMapper.toDto(updatedCritereQualifiSoum);

        restCritereQualifiSoumMockMvc.perform(put("/api/critere-qualifi-soums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereQualifiSoumDTO)))
            .andExpect(status().isOk());

        // Validate the CritereQualifiSoum in the database
        List<CritereQualifiSoum> critereQualifiSoumList = critereQualifiSoumRepository.findAll();
        assertThat(critereQualifiSoumList).hasSize(databaseSizeBeforeUpdate);
        CritereQualifiSoum testCritereQualifiSoum = critereQualifiSoumList.get(critereQualifiSoumList.size() - 1);
        assertThat(testCritereQualifiSoum.getConforme()).isEqualTo(UPDATED_CONFORME);
        assertThat(testCritereQualifiSoum.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testCritereQualifiSoum.getLibelleLot()).isEqualTo(UPDATED_LIBELLE_LOT);
    }

    @Test
    @Transactional
    public void updateNonExistingCritereQualifiSoum() throws Exception {
        int databaseSizeBeforeUpdate = critereQualifiSoumRepository.findAll().size();

        // Create the CritereQualifiSoum
        CritereQualifiSoumDTO critereQualifiSoumDTO = critereQualifiSoumMapper.toDto(critereQualifiSoum);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCritereQualifiSoumMockMvc.perform(put("/api/critere-qualifi-soums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(critereQualifiSoumDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CritereQualifiSoum in the database
        List<CritereQualifiSoum> critereQualifiSoumList = critereQualifiSoumRepository.findAll();
        assertThat(critereQualifiSoumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCritereQualifiSoum() throws Exception {
        // Initialize the database
        critereQualifiSoumRepository.saveAndFlush(critereQualifiSoum);

        int databaseSizeBeforeDelete = critereQualifiSoumRepository.findAll().size();

        // Delete the critereQualifiSoum
        restCritereQualifiSoumMockMvc.perform(delete("/api/critere-qualifi-soums/{id}", critereQualifiSoum.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CritereQualifiSoum> critereQualifiSoumList = critereQualifiSoumRepository.findAll();
        assertThat(critereQualifiSoumList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
