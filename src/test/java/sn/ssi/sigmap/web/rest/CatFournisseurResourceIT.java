package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.CatFournisseur;
import sn.ssi.sigmap.repository.CatFournisseurRepository;
import sn.ssi.sigmap.service.CatFournisseurService;
import sn.ssi.sigmap.service.dto.CatFournisseurDTO;
import sn.ssi.sigmap.service.mapper.CatFournisseurMapper;

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
 * Integration tests for the {@link CatFournisseurResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CatFournisseurResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private CatFournisseurRepository catFournisseurRepository;

    @Autowired
    private CatFournisseurMapper catFournisseurMapper;

    @Autowired
    private CatFournisseurService catFournisseurService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCatFournisseurMockMvc;

    private CatFournisseur catFournisseur;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CatFournisseur createEntity(EntityManager em) {
        CatFournisseur catFournisseur = new CatFournisseur()
            .libelle(DEFAULT_LIBELLE)
            .description(DEFAULT_DESCRIPTION);
        return catFournisseur;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CatFournisseur createUpdatedEntity(EntityManager em) {
        CatFournisseur catFournisseur = new CatFournisseur()
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION);
        return catFournisseur;
    }

    @BeforeEach
    public void initTest() {
        catFournisseur = createEntity(em);
    }

    @Test
    @Transactional
    public void createCatFournisseur() throws Exception {
        int databaseSizeBeforeCreate = catFournisseurRepository.findAll().size();
        // Create the CatFournisseur
        CatFournisseurDTO catFournisseurDTO = catFournisseurMapper.toDto(catFournisseur);
        restCatFournisseurMockMvc.perform(post("/api/cat-fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catFournisseurDTO)))
            .andExpect(status().isCreated());

        // Validate the CatFournisseur in the database
        List<CatFournisseur> catFournisseurList = catFournisseurRepository.findAll();
        assertThat(catFournisseurList).hasSize(databaseSizeBeforeCreate + 1);
        CatFournisseur testCatFournisseur = catFournisseurList.get(catFournisseurList.size() - 1);
        assertThat(testCatFournisseur.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testCatFournisseur.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void createCatFournisseurWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = catFournisseurRepository.findAll().size();

        // Create the CatFournisseur with an existing ID
        catFournisseur.setId(1L);
        CatFournisseurDTO catFournisseurDTO = catFournisseurMapper.toDto(catFournisseur);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCatFournisseurMockMvc.perform(post("/api/cat-fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catFournisseurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CatFournisseur in the database
        List<CatFournisseur> catFournisseurList = catFournisseurRepository.findAll();
        assertThat(catFournisseurList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCatFournisseurs() throws Exception {
        // Initialize the database
        catFournisseurRepository.saveAndFlush(catFournisseur);

        // Get all the catFournisseurList
        restCatFournisseurMockMvc.perform(get("/api/cat-fournisseurs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(catFournisseur.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)));
    }
    
    @Test
    @Transactional
    public void getCatFournisseur() throws Exception {
        // Initialize the database
        catFournisseurRepository.saveAndFlush(catFournisseur);

        // Get the catFournisseur
        restCatFournisseurMockMvc.perform(get("/api/cat-fournisseurs/{id}", catFournisseur.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(catFournisseur.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION));
    }
    @Test
    @Transactional
    public void getNonExistingCatFournisseur() throws Exception {
        // Get the catFournisseur
        restCatFournisseurMockMvc.perform(get("/api/cat-fournisseurs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCatFournisseur() throws Exception {
        // Initialize the database
        catFournisseurRepository.saveAndFlush(catFournisseur);

        int databaseSizeBeforeUpdate = catFournisseurRepository.findAll().size();

        // Update the catFournisseur
        CatFournisseur updatedCatFournisseur = catFournisseurRepository.findById(catFournisseur.getId()).get();
        // Disconnect from session so that the updates on updatedCatFournisseur are not directly saved in db
        em.detach(updatedCatFournisseur);
        updatedCatFournisseur
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION);
        CatFournisseurDTO catFournisseurDTO = catFournisseurMapper.toDto(updatedCatFournisseur);

        restCatFournisseurMockMvc.perform(put("/api/cat-fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catFournisseurDTO)))
            .andExpect(status().isOk());

        // Validate the CatFournisseur in the database
        List<CatFournisseur> catFournisseurList = catFournisseurRepository.findAll();
        assertThat(catFournisseurList).hasSize(databaseSizeBeforeUpdate);
        CatFournisseur testCatFournisseur = catFournisseurList.get(catFournisseurList.size() - 1);
        assertThat(testCatFournisseur.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testCatFournisseur.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    @Transactional
    public void updateNonExistingCatFournisseur() throws Exception {
        int databaseSizeBeforeUpdate = catFournisseurRepository.findAll().size();

        // Create the CatFournisseur
        CatFournisseurDTO catFournisseurDTO = catFournisseurMapper.toDto(catFournisseur);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCatFournisseurMockMvc.perform(put("/api/cat-fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(catFournisseurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CatFournisseur in the database
        List<CatFournisseur> catFournisseurList = catFournisseurRepository.findAll();
        assertThat(catFournisseurList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCatFournisseur() throws Exception {
        // Initialize the database
        catFournisseurRepository.saveAndFlush(catFournisseur);

        int databaseSizeBeforeDelete = catFournisseurRepository.findAll().size();

        // Delete the catFournisseur
        restCatFournisseurMockMvc.perform(delete("/api/cat-fournisseurs/{id}", catFournisseur.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CatFournisseur> catFournisseurList = catFournisseurRepository.findAll();
        assertThat(catFournisseurList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
