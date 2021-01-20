package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.CategorieAppelOffre;
import sn.ssi.sigmap.repository.CategorieAppelOffreRepository;
import sn.ssi.sigmap.service.CategorieAppelOffreService;
import sn.ssi.sigmap.service.dto.CategorieAppelOffreDTO;
import sn.ssi.sigmap.service.mapper.CategorieAppelOffreMapper;

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
 * Integration tests for the {@link CategorieAppelOffreResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CategorieAppelOffreResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_NIVEAU = 1;
    private static final Integer UPDATED_NIVEAU = 2;

    @Autowired
    private CategorieAppelOffreRepository categorieAppelOffreRepository;

    @Autowired
    private CategorieAppelOffreMapper categorieAppelOffreMapper;

    @Autowired
    private CategorieAppelOffreService categorieAppelOffreService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCategorieAppelOffreMockMvc;

    private CategorieAppelOffre categorieAppelOffre;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CategorieAppelOffre createEntity(EntityManager em) {
        CategorieAppelOffre categorieAppelOffre = new CategorieAppelOffre()
            .libelle(DEFAULT_LIBELLE)
            .niveau(DEFAULT_NIVEAU);
        return categorieAppelOffre;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CategorieAppelOffre createUpdatedEntity(EntityManager em) {
        CategorieAppelOffre categorieAppelOffre = new CategorieAppelOffre()
            .libelle(UPDATED_LIBELLE)
            .niveau(UPDATED_NIVEAU);
        return categorieAppelOffre;
    }

    @BeforeEach
    public void initTest() {
        categorieAppelOffre = createEntity(em);
    }

    @Test
    @Transactional
    public void createCategorieAppelOffre() throws Exception {
        int databaseSizeBeforeCreate = categorieAppelOffreRepository.findAll().size();
        // Create the CategorieAppelOffre
        CategorieAppelOffreDTO categorieAppelOffreDTO = categorieAppelOffreMapper.toDto(categorieAppelOffre);
        restCategorieAppelOffreMockMvc.perform(post("/api/categorie-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(categorieAppelOffreDTO)))
            .andExpect(status().isCreated());

        // Validate the CategorieAppelOffre in the database
        List<CategorieAppelOffre> categorieAppelOffreList = categorieAppelOffreRepository.findAll();
        assertThat(categorieAppelOffreList).hasSize(databaseSizeBeforeCreate + 1);
        CategorieAppelOffre testCategorieAppelOffre = categorieAppelOffreList.get(categorieAppelOffreList.size() - 1);
        assertThat(testCategorieAppelOffre.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testCategorieAppelOffre.getNiveau()).isEqualTo(DEFAULT_NIVEAU);
    }

    @Test
    @Transactional
    public void createCategorieAppelOffreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = categorieAppelOffreRepository.findAll().size();

        // Create the CategorieAppelOffre with an existing ID
        categorieAppelOffre.setId(1L);
        CategorieAppelOffreDTO categorieAppelOffreDTO = categorieAppelOffreMapper.toDto(categorieAppelOffre);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCategorieAppelOffreMockMvc.perform(post("/api/categorie-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(categorieAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CategorieAppelOffre in the database
        List<CategorieAppelOffre> categorieAppelOffreList = categorieAppelOffreRepository.findAll();
        assertThat(categorieAppelOffreList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCategorieAppelOffres() throws Exception {
        // Initialize the database
        categorieAppelOffreRepository.saveAndFlush(categorieAppelOffre);

        // Get all the categorieAppelOffreList
        restCategorieAppelOffreMockMvc.perform(get("/api/categorie-appel-offres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(categorieAppelOffre.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].niveau").value(hasItem(DEFAULT_NIVEAU)));
    }
    
    @Test
    @Transactional
    public void getCategorieAppelOffre() throws Exception {
        // Initialize the database
        categorieAppelOffreRepository.saveAndFlush(categorieAppelOffre);

        // Get the categorieAppelOffre
        restCategorieAppelOffreMockMvc.perform(get("/api/categorie-appel-offres/{id}", categorieAppelOffre.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(categorieAppelOffre.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.niveau").value(DEFAULT_NIVEAU));
    }
    @Test
    @Transactional
    public void getNonExistingCategorieAppelOffre() throws Exception {
        // Get the categorieAppelOffre
        restCategorieAppelOffreMockMvc.perform(get("/api/categorie-appel-offres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCategorieAppelOffre() throws Exception {
        // Initialize the database
        categorieAppelOffreRepository.saveAndFlush(categorieAppelOffre);

        int databaseSizeBeforeUpdate = categorieAppelOffreRepository.findAll().size();

        // Update the categorieAppelOffre
        CategorieAppelOffre updatedCategorieAppelOffre = categorieAppelOffreRepository.findById(categorieAppelOffre.getId()).get();
        // Disconnect from session so that the updates on updatedCategorieAppelOffre are not directly saved in db
        em.detach(updatedCategorieAppelOffre);
        updatedCategorieAppelOffre
            .libelle(UPDATED_LIBELLE)
            .niveau(UPDATED_NIVEAU);
        CategorieAppelOffreDTO categorieAppelOffreDTO = categorieAppelOffreMapper.toDto(updatedCategorieAppelOffre);

        restCategorieAppelOffreMockMvc.perform(put("/api/categorie-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(categorieAppelOffreDTO)))
            .andExpect(status().isOk());

        // Validate the CategorieAppelOffre in the database
        List<CategorieAppelOffre> categorieAppelOffreList = categorieAppelOffreRepository.findAll();
        assertThat(categorieAppelOffreList).hasSize(databaseSizeBeforeUpdate);
        CategorieAppelOffre testCategorieAppelOffre = categorieAppelOffreList.get(categorieAppelOffreList.size() - 1);
        assertThat(testCategorieAppelOffre.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testCategorieAppelOffre.getNiveau()).isEqualTo(UPDATED_NIVEAU);
    }

    @Test
    @Transactional
    public void updateNonExistingCategorieAppelOffre() throws Exception {
        int databaseSizeBeforeUpdate = categorieAppelOffreRepository.findAll().size();

        // Create the CategorieAppelOffre
        CategorieAppelOffreDTO categorieAppelOffreDTO = categorieAppelOffreMapper.toDto(categorieAppelOffre);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCategorieAppelOffreMockMvc.perform(put("/api/categorie-appel-offres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(categorieAppelOffreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CategorieAppelOffre in the database
        List<CategorieAppelOffre> categorieAppelOffreList = categorieAppelOffreRepository.findAll();
        assertThat(categorieAppelOffreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCategorieAppelOffre() throws Exception {
        // Initialize the database
        categorieAppelOffreRepository.saveAndFlush(categorieAppelOffre);

        int databaseSizeBeforeDelete = categorieAppelOffreRepository.findAll().size();

        // Delete the categorieAppelOffre
        restCategorieAppelOffreMockMvc.perform(delete("/api/categorie-appel-offres/{id}", categorieAppelOffre.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CategorieAppelOffre> categorieAppelOffreList = categorieAppelOffreRepository.findAll();
        assertThat(categorieAppelOffreList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
