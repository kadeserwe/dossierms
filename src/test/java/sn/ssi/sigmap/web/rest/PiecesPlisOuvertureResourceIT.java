package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.PiecesPlisOuverture;
import sn.ssi.sigmap.repository.PiecesPlisOuvertureRepository;
import sn.ssi.sigmap.service.PiecesPlisOuvertureService;
import sn.ssi.sigmap.service.dto.PiecesPlisOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PiecesPlisOuvertureMapper;

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
 * Integration tests for the {@link PiecesPlisOuvertureResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PiecesPlisOuvertureResourceIT {

    private static final String DEFAULT_ETAT = "AAAAAAAAAA";
    private static final String UPDATED_ETAT = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_ETAT_CONFORME = "AAAAAAAAAA";
    private static final String UPDATED_ETAT_CONFORME = "BBBBBBBBBB";

    @Autowired
    private PiecesPlisOuvertureRepository piecesPlisOuvertureRepository;

    @Autowired
    private PiecesPlisOuvertureMapper piecesPlisOuvertureMapper;

    @Autowired
    private PiecesPlisOuvertureService piecesPlisOuvertureService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPiecesPlisOuvertureMockMvc;

    private PiecesPlisOuverture piecesPlisOuverture;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PiecesPlisOuverture createEntity(EntityManager em) {
        PiecesPlisOuverture piecesPlisOuverture = new PiecesPlisOuverture()
            .etat(DEFAULT_ETAT)
            .libelle(DEFAULT_LIBELLE)
            .etatConforme(DEFAULT_ETAT_CONFORME);
        return piecesPlisOuverture;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PiecesPlisOuverture createUpdatedEntity(EntityManager em) {
        PiecesPlisOuverture piecesPlisOuverture = new PiecesPlisOuverture()
            .etat(UPDATED_ETAT)
            .libelle(UPDATED_LIBELLE)
            .etatConforme(UPDATED_ETAT_CONFORME);
        return piecesPlisOuverture;
    }

    @BeforeEach
    public void initTest() {
        piecesPlisOuverture = createEntity(em);
    }

    @Test
    @Transactional
    public void createPiecesPlisOuverture() throws Exception {
        int databaseSizeBeforeCreate = piecesPlisOuvertureRepository.findAll().size();
        // Create the PiecesPlisOuverture
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO = piecesPlisOuvertureMapper.toDto(piecesPlisOuverture);
        restPiecesPlisOuvertureMockMvc.perform(post("/api/pieces-plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesPlisOuvertureDTO)))
            .andExpect(status().isCreated());

        // Validate the PiecesPlisOuverture in the database
        List<PiecesPlisOuverture> piecesPlisOuvertureList = piecesPlisOuvertureRepository.findAll();
        assertThat(piecesPlisOuvertureList).hasSize(databaseSizeBeforeCreate + 1);
        PiecesPlisOuverture testPiecesPlisOuverture = piecesPlisOuvertureList.get(piecesPlisOuvertureList.size() - 1);
        assertThat(testPiecesPlisOuverture.getEtat()).isEqualTo(DEFAULT_ETAT);
        assertThat(testPiecesPlisOuverture.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testPiecesPlisOuverture.getEtatConforme()).isEqualTo(DEFAULT_ETAT_CONFORME);
    }

    @Test
    @Transactional
    public void createPiecesPlisOuvertureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = piecesPlisOuvertureRepository.findAll().size();

        // Create the PiecesPlisOuverture with an existing ID
        piecesPlisOuverture.setId(1L);
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO = piecesPlisOuvertureMapper.toDto(piecesPlisOuverture);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPiecesPlisOuvertureMockMvc.perform(post("/api/pieces-plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesPlisOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PiecesPlisOuverture in the database
        List<PiecesPlisOuverture> piecesPlisOuvertureList = piecesPlisOuvertureRepository.findAll();
        assertThat(piecesPlisOuvertureList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPiecesPlisOuvertures() throws Exception {
        // Initialize the database
        piecesPlisOuvertureRepository.saveAndFlush(piecesPlisOuverture);

        // Get all the piecesPlisOuvertureList
        restPiecesPlisOuvertureMockMvc.perform(get("/api/pieces-plis-ouvertures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(piecesPlisOuverture.getId().intValue())))
            .andExpect(jsonPath("$.[*].etat").value(hasItem(DEFAULT_ETAT)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].etatConforme").value(hasItem(DEFAULT_ETAT_CONFORME)));
    }
    
    @Test
    @Transactional
    public void getPiecesPlisOuverture() throws Exception {
        // Initialize the database
        piecesPlisOuvertureRepository.saveAndFlush(piecesPlisOuverture);

        // Get the piecesPlisOuverture
        restPiecesPlisOuvertureMockMvc.perform(get("/api/pieces-plis-ouvertures/{id}", piecesPlisOuverture.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(piecesPlisOuverture.getId().intValue()))
            .andExpect(jsonPath("$.etat").value(DEFAULT_ETAT))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.etatConforme").value(DEFAULT_ETAT_CONFORME));
    }
    @Test
    @Transactional
    public void getNonExistingPiecesPlisOuverture() throws Exception {
        // Get the piecesPlisOuverture
        restPiecesPlisOuvertureMockMvc.perform(get("/api/pieces-plis-ouvertures/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePiecesPlisOuverture() throws Exception {
        // Initialize the database
        piecesPlisOuvertureRepository.saveAndFlush(piecesPlisOuverture);

        int databaseSizeBeforeUpdate = piecesPlisOuvertureRepository.findAll().size();

        // Update the piecesPlisOuverture
        PiecesPlisOuverture updatedPiecesPlisOuverture = piecesPlisOuvertureRepository.findById(piecesPlisOuverture.getId()).get();
        // Disconnect from session so that the updates on updatedPiecesPlisOuverture are not directly saved in db
        em.detach(updatedPiecesPlisOuverture);
        updatedPiecesPlisOuverture
            .etat(UPDATED_ETAT)
            .libelle(UPDATED_LIBELLE)
            .etatConforme(UPDATED_ETAT_CONFORME);
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO = piecesPlisOuvertureMapper.toDto(updatedPiecesPlisOuverture);

        restPiecesPlisOuvertureMockMvc.perform(put("/api/pieces-plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesPlisOuvertureDTO)))
            .andExpect(status().isOk());

        // Validate the PiecesPlisOuverture in the database
        List<PiecesPlisOuverture> piecesPlisOuvertureList = piecesPlisOuvertureRepository.findAll();
        assertThat(piecesPlisOuvertureList).hasSize(databaseSizeBeforeUpdate);
        PiecesPlisOuverture testPiecesPlisOuverture = piecesPlisOuvertureList.get(piecesPlisOuvertureList.size() - 1);
        assertThat(testPiecesPlisOuverture.getEtat()).isEqualTo(UPDATED_ETAT);
        assertThat(testPiecesPlisOuverture.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testPiecesPlisOuverture.getEtatConforme()).isEqualTo(UPDATED_ETAT_CONFORME);
    }

    @Test
    @Transactional
    public void updateNonExistingPiecesPlisOuverture() throws Exception {
        int databaseSizeBeforeUpdate = piecesPlisOuvertureRepository.findAll().size();

        // Create the PiecesPlisOuverture
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO = piecesPlisOuvertureMapper.toDto(piecesPlisOuverture);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPiecesPlisOuvertureMockMvc.perform(put("/api/pieces-plis-ouvertures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(piecesPlisOuvertureDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PiecesPlisOuverture in the database
        List<PiecesPlisOuverture> piecesPlisOuvertureList = piecesPlisOuvertureRepository.findAll();
        assertThat(piecesPlisOuvertureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePiecesPlisOuverture() throws Exception {
        // Initialize the database
        piecesPlisOuvertureRepository.saveAndFlush(piecesPlisOuverture);

        int databaseSizeBeforeDelete = piecesPlisOuvertureRepository.findAll().size();

        // Delete the piecesPlisOuverture
        restPiecesPlisOuvertureMockMvc.perform(delete("/api/pieces-plis-ouvertures/{id}", piecesPlisOuverture.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PiecesPlisOuverture> piecesPlisOuvertureList = piecesPlisOuvertureRepository.findAll();
        assertThat(piecesPlisOuvertureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
