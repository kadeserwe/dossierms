package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.NaturesGarantie;
import sn.ssi.sigmap.repository.NaturesGarantieRepository;
import sn.ssi.sigmap.service.NaturesGarantieService;
import sn.ssi.sigmap.service.dto.NaturesGarantieDTO;
import sn.ssi.sigmap.service.mapper.NaturesGarantieMapper;

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
 * Integration tests for the {@link NaturesGarantieResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class NaturesGarantieResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    @Autowired
    private NaturesGarantieRepository naturesGarantieRepository;

    @Autowired
    private NaturesGarantieMapper naturesGarantieMapper;

    @Autowired
    private NaturesGarantieService naturesGarantieService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restNaturesGarantieMockMvc;

    private NaturesGarantie naturesGarantie;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NaturesGarantie createEntity(EntityManager em) {
        NaturesGarantie naturesGarantie = new NaturesGarantie()
            .libelle(DEFAULT_LIBELLE);
        return naturesGarantie;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NaturesGarantie createUpdatedEntity(EntityManager em) {
        NaturesGarantie naturesGarantie = new NaturesGarantie()
            .libelle(UPDATED_LIBELLE);
        return naturesGarantie;
    }

    @BeforeEach
    public void initTest() {
        naturesGarantie = createEntity(em);
    }

    @Test
    @Transactional
    public void createNaturesGarantie() throws Exception {
        int databaseSizeBeforeCreate = naturesGarantieRepository.findAll().size();
        // Create the NaturesGarantie
        NaturesGarantieDTO naturesGarantieDTO = naturesGarantieMapper.toDto(naturesGarantie);
        restNaturesGarantieMockMvc.perform(post("/api/natures-garanties")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturesGarantieDTO)))
            .andExpect(status().isCreated());

        // Validate the NaturesGarantie in the database
        List<NaturesGarantie> naturesGarantieList = naturesGarantieRepository.findAll();
        assertThat(naturesGarantieList).hasSize(databaseSizeBeforeCreate + 1);
        NaturesGarantie testNaturesGarantie = naturesGarantieList.get(naturesGarantieList.size() - 1);
        assertThat(testNaturesGarantie.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
    }

    @Test
    @Transactional
    public void createNaturesGarantieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = naturesGarantieRepository.findAll().size();

        // Create the NaturesGarantie with an existing ID
        naturesGarantie.setId(1L);
        NaturesGarantieDTO naturesGarantieDTO = naturesGarantieMapper.toDto(naturesGarantie);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNaturesGarantieMockMvc.perform(post("/api/natures-garanties")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturesGarantieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NaturesGarantie in the database
        List<NaturesGarantie> naturesGarantieList = naturesGarantieRepository.findAll();
        assertThat(naturesGarantieList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllNaturesGaranties() throws Exception {
        // Initialize the database
        naturesGarantieRepository.saveAndFlush(naturesGarantie);

        // Get all the naturesGarantieList
        restNaturesGarantieMockMvc.perform(get("/api/natures-garanties?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(naturesGarantie.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)));
    }
    
    @Test
    @Transactional
    public void getNaturesGarantie() throws Exception {
        // Initialize the database
        naturesGarantieRepository.saveAndFlush(naturesGarantie);

        // Get the naturesGarantie
        restNaturesGarantieMockMvc.perform(get("/api/natures-garanties/{id}", naturesGarantie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(naturesGarantie.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE));
    }
    @Test
    @Transactional
    public void getNonExistingNaturesGarantie() throws Exception {
        // Get the naturesGarantie
        restNaturesGarantieMockMvc.perform(get("/api/natures-garanties/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNaturesGarantie() throws Exception {
        // Initialize the database
        naturesGarantieRepository.saveAndFlush(naturesGarantie);

        int databaseSizeBeforeUpdate = naturesGarantieRepository.findAll().size();

        // Update the naturesGarantie
        NaturesGarantie updatedNaturesGarantie = naturesGarantieRepository.findById(naturesGarantie.getId()).get();
        // Disconnect from session so that the updates on updatedNaturesGarantie are not directly saved in db
        em.detach(updatedNaturesGarantie);
        updatedNaturesGarantie
            .libelle(UPDATED_LIBELLE);
        NaturesGarantieDTO naturesGarantieDTO = naturesGarantieMapper.toDto(updatedNaturesGarantie);

        restNaturesGarantieMockMvc.perform(put("/api/natures-garanties")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturesGarantieDTO)))
            .andExpect(status().isOk());

        // Validate the NaturesGarantie in the database
        List<NaturesGarantie> naturesGarantieList = naturesGarantieRepository.findAll();
        assertThat(naturesGarantieList).hasSize(databaseSizeBeforeUpdate);
        NaturesGarantie testNaturesGarantie = naturesGarantieList.get(naturesGarantieList.size() - 1);
        assertThat(testNaturesGarantie.getLibelle()).isEqualTo(UPDATED_LIBELLE);
    }

    @Test
    @Transactional
    public void updateNonExistingNaturesGarantie() throws Exception {
        int databaseSizeBeforeUpdate = naturesGarantieRepository.findAll().size();

        // Create the NaturesGarantie
        NaturesGarantieDTO naturesGarantieDTO = naturesGarantieMapper.toDto(naturesGarantie);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNaturesGarantieMockMvc.perform(put("/api/natures-garanties")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(naturesGarantieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NaturesGarantie in the database
        List<NaturesGarantie> naturesGarantieList = naturesGarantieRepository.findAll();
        assertThat(naturesGarantieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNaturesGarantie() throws Exception {
        // Initialize the database
        naturesGarantieRepository.saveAndFlush(naturesGarantie);

        int databaseSizeBeforeDelete = naturesGarantieRepository.findAll().size();

        // Delete the naturesGarantie
        restNaturesGarantieMockMvc.perform(delete("/api/natures-garanties/{id}", naturesGarantie.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<NaturesGarantie> naturesGarantieList = naturesGarantieRepository.findAll();
        assertThat(naturesGarantieList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
