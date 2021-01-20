package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.NaturePrix;
import sn.ssi.sigmap.repository.NaturePrixRepository;
import sn.ssi.sigmap.service.NaturePrixService;
import sn.ssi.sigmap.service.dto.NaturePrixDTO;
import sn.ssi.sigmap.service.mapper.NaturePrixMapper;

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
 * Integration tests for the {@link NaturePrixResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NaturePrixResourceIT {

    private static final String DEFAULT_NAT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NAT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_NAT_LIBELLE = "BBBBBBBBBB";

    @Autowired
    private NaturePrixRepository naturePrixRepository;

    @Autowired
    private NaturePrixMapper naturePrixMapper;

    @Autowired
    private NaturePrixService naturePrixService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNaturePrixMockMvc;

    private NaturePrix naturePrix;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NaturePrix createEntity(EntityManager em) {
        NaturePrix naturePrix = new NaturePrix()
            .natCode(DEFAULT_NAT_CODE)
            .natLibelle(DEFAULT_NAT_LIBELLE);
        return naturePrix;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NaturePrix createUpdatedEntity(EntityManager em) {
        NaturePrix naturePrix = new NaturePrix()
            .natCode(UPDATED_NAT_CODE)
            .natLibelle(UPDATED_NAT_LIBELLE);
        return naturePrix;
    }

    @BeforeEach
    public void initTest() {
        naturePrix = createEntity(em);
    }

    @Test
    @Transactional
    public void createNaturePrix() throws Exception {
        int databaseSizeBeforeCreate = naturePrixRepository.findAll().size();
        // Create the NaturePrix
        NaturePrixDTO naturePrixDTO = naturePrixMapper.toDto(naturePrix);
        restNaturePrixMockMvc.perform(post("/api/nature-prixes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturePrixDTO)))
            .andExpect(status().isCreated());

        // Validate the NaturePrix in the database
        List<NaturePrix> naturePrixList = naturePrixRepository.findAll();
        assertThat(naturePrixList).hasSize(databaseSizeBeforeCreate + 1);
        NaturePrix testNaturePrix = naturePrixList.get(naturePrixList.size() - 1);
        assertThat(testNaturePrix.getNatCode()).isEqualTo(DEFAULT_NAT_CODE);
        assertThat(testNaturePrix.getNatLibelle()).isEqualTo(DEFAULT_NAT_LIBELLE);
    }

    @Test
    @Transactional
    public void createNaturePrixWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = naturePrixRepository.findAll().size();

        // Create the NaturePrix with an existing ID
        naturePrix.setId(1L);
        NaturePrixDTO naturePrixDTO = naturePrixMapper.toDto(naturePrix);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNaturePrixMockMvc.perform(post("/api/nature-prixes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturePrixDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NaturePrix in the database
        List<NaturePrix> naturePrixList = naturePrixRepository.findAll();
        assertThat(naturePrixList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllNaturePrixes() throws Exception {
        // Initialize the database
        naturePrixRepository.saveAndFlush(naturePrix);

        // Get all the naturePrixList
        restNaturePrixMockMvc.perform(get("/api/nature-prixes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(naturePrix.getId().intValue())))
            .andExpect(jsonPath("$.[*].natCode").value(hasItem(DEFAULT_NAT_CODE)))
            .andExpect(jsonPath("$.[*].natLibelle").value(hasItem(DEFAULT_NAT_LIBELLE)));
    }
    
    @Test
    @Transactional
    public void getNaturePrix() throws Exception {
        // Initialize the database
        naturePrixRepository.saveAndFlush(naturePrix);

        // Get the naturePrix
        restNaturePrixMockMvc.perform(get("/api/nature-prixes/{id}", naturePrix.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(naturePrix.getId().intValue()))
            .andExpect(jsonPath("$.natCode").value(DEFAULT_NAT_CODE))
            .andExpect(jsonPath("$.natLibelle").value(DEFAULT_NAT_LIBELLE));
    }
    @Test
    @Transactional
    public void getNonExistingNaturePrix() throws Exception {
        // Get the naturePrix
        restNaturePrixMockMvc.perform(get("/api/nature-prixes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNaturePrix() throws Exception {
        // Initialize the database
        naturePrixRepository.saveAndFlush(naturePrix);

        int databaseSizeBeforeUpdate = naturePrixRepository.findAll().size();

        // Update the naturePrix
        NaturePrix updatedNaturePrix = naturePrixRepository.findById(naturePrix.getId()).get();
        // Disconnect from session so that the updates on updatedNaturePrix are not directly saved in db
        em.detach(updatedNaturePrix);
        updatedNaturePrix
            .natCode(UPDATED_NAT_CODE)
            .natLibelle(UPDATED_NAT_LIBELLE);
        NaturePrixDTO naturePrixDTO = naturePrixMapper.toDto(updatedNaturePrix);

        restNaturePrixMockMvc.perform(put("/api/nature-prixes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturePrixDTO)))
            .andExpect(status().isOk());

        // Validate the NaturePrix in the database
        List<NaturePrix> naturePrixList = naturePrixRepository.findAll();
        assertThat(naturePrixList).hasSize(databaseSizeBeforeUpdate);
        NaturePrix testNaturePrix = naturePrixList.get(naturePrixList.size() - 1);
        assertThat(testNaturePrix.getNatCode()).isEqualTo(UPDATED_NAT_CODE);
        assertThat(testNaturePrix.getNatLibelle()).isEqualTo(UPDATED_NAT_LIBELLE);
    }

    @Test
    @Transactional
    public void updateNonExistingNaturePrix() throws Exception {
        int databaseSizeBeforeUpdate = naturePrixRepository.findAll().size();

        // Create the NaturePrix
        NaturePrixDTO naturePrixDTO = naturePrixMapper.toDto(naturePrix);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNaturePrixMockMvc.perform(put("/api/nature-prixes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturePrixDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NaturePrix in the database
        List<NaturePrix> naturePrixList = naturePrixRepository.findAll();
        assertThat(naturePrixList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNaturePrix() throws Exception {
        // Initialize the database
        naturePrixRepository.saveAndFlush(naturePrix);

        int databaseSizeBeforeDelete = naturePrixRepository.findAll().size();

        // Delete the naturePrix
        restNaturePrixMockMvc.perform(delete("/api/nature-prixes/{id}", naturePrix.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NaturePrix> naturePrixList = naturePrixRepository.findAll();
        assertThat(naturePrixList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
