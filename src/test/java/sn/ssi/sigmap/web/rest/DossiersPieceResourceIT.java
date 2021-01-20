package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.DossiersPiece;
import sn.ssi.sigmap.repository.DossiersPieceRepository;
import sn.ssi.sigmap.service.DossiersPieceService;
import sn.ssi.sigmap.service.dto.DossiersPieceDTO;
import sn.ssi.sigmap.service.mapper.DossiersPieceMapper;

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
 * Integration tests for the {@link DossiersPieceResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DossiersPieceResourceIT {

    @Autowired
    private DossiersPieceRepository dossiersPieceRepository;

    @Autowired
    private DossiersPieceMapper dossiersPieceMapper;

    @Autowired
    private DossiersPieceService dossiersPieceService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDossiersPieceMockMvc;

    private DossiersPiece dossiersPiece;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersPiece createEntity(EntityManager em) {
        DossiersPiece dossiersPiece = new DossiersPiece();
        return dossiersPiece;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersPiece createUpdatedEntity(EntityManager em) {
        DossiersPiece dossiersPiece = new DossiersPiece();
        return dossiersPiece;
    }

    @BeforeEach
    public void initTest() {
        dossiersPiece = createEntity(em);
    }

    @Test
    @Transactional
    public void createDossiersPiece() throws Exception {
        int databaseSizeBeforeCreate = dossiersPieceRepository.findAll().size();
        // Create the DossiersPiece
        DossiersPieceDTO dossiersPieceDTO = dossiersPieceMapper.toDto(dossiersPiece);
        restDossiersPieceMockMvc.perform(post("/api/dossiers-pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersPieceDTO)))
            .andExpect(status().isCreated());

        // Validate the DossiersPiece in the database
        List<DossiersPiece> dossiersPieceList = dossiersPieceRepository.findAll();
        assertThat(dossiersPieceList).hasSize(databaseSizeBeforeCreate + 1);
        DossiersPiece testDossiersPiece = dossiersPieceList.get(dossiersPieceList.size() - 1);
    }

    @Test
    @Transactional
    public void createDossiersPieceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dossiersPieceRepository.findAll().size();

        // Create the DossiersPiece with an existing ID
        dossiersPiece.setId(1L);
        DossiersPieceDTO dossiersPieceDTO = dossiersPieceMapper.toDto(dossiersPiece);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDossiersPieceMockMvc.perform(post("/api/dossiers-pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersPieceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersPiece in the database
        List<DossiersPiece> dossiersPieceList = dossiersPieceRepository.findAll();
        assertThat(dossiersPieceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDossiersPieces() throws Exception {
        // Initialize the database
        dossiersPieceRepository.saveAndFlush(dossiersPiece);

        // Get all the dossiersPieceList
        restDossiersPieceMockMvc.perform(get("/api/dossiers-pieces?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dossiersPiece.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getDossiersPiece() throws Exception {
        // Initialize the database
        dossiersPieceRepository.saveAndFlush(dossiersPiece);

        // Get the dossiersPiece
        restDossiersPieceMockMvc.perform(get("/api/dossiers-pieces/{id}", dossiersPiece.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dossiersPiece.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDossiersPiece() throws Exception {
        // Get the dossiersPiece
        restDossiersPieceMockMvc.perform(get("/api/dossiers-pieces/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDossiersPiece() throws Exception {
        // Initialize the database
        dossiersPieceRepository.saveAndFlush(dossiersPiece);

        int databaseSizeBeforeUpdate = dossiersPieceRepository.findAll().size();

        // Update the dossiersPiece
        DossiersPiece updatedDossiersPiece = dossiersPieceRepository.findById(dossiersPiece.getId()).get();
        // Disconnect from session so that the updates on updatedDossiersPiece are not directly saved in db
        em.detach(updatedDossiersPiece);
        DossiersPieceDTO dossiersPieceDTO = dossiersPieceMapper.toDto(updatedDossiersPiece);

        restDossiersPieceMockMvc.perform(put("/api/dossiers-pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersPieceDTO)))
            .andExpect(status().isOk());

        // Validate the DossiersPiece in the database
        List<DossiersPiece> dossiersPieceList = dossiersPieceRepository.findAll();
        assertThat(dossiersPieceList).hasSize(databaseSizeBeforeUpdate);
        DossiersPiece testDossiersPiece = dossiersPieceList.get(dossiersPieceList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingDossiersPiece() throws Exception {
        int databaseSizeBeforeUpdate = dossiersPieceRepository.findAll().size();

        // Create the DossiersPiece
        DossiersPieceDTO dossiersPieceDTO = dossiersPieceMapper.toDto(dossiersPiece);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDossiersPieceMockMvc.perform(put("/api/dossiers-pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersPieceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersPiece in the database
        List<DossiersPiece> dossiersPieceList = dossiersPieceRepository.findAll();
        assertThat(dossiersPieceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDossiersPiece() throws Exception {
        // Initialize the database
        dossiersPieceRepository.saveAndFlush(dossiersPiece);

        int databaseSizeBeforeDelete = dossiersPieceRepository.findAll().size();

        // Delete the dossiersPiece
        restDossiersPieceMockMvc.perform(delete("/api/dossiers-pieces/{id}", dossiersPiece.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DossiersPiece> dossiersPieceList = dossiersPieceRepository.findAll();
        assertThat(dossiersPieceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
