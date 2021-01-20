package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.DossiersSouscritere;
import sn.ssi.sigmap.repository.DossiersSouscritereRepository;
import sn.ssi.sigmap.service.DossiersSouscritereService;
import sn.ssi.sigmap.service.dto.DossiersSouscritereDTO;
import sn.ssi.sigmap.service.mapper.DossiersSouscritereMapper;

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
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DossiersSouscritereResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DossiersSouscritereResourceIT {

    private static final BigDecimal DEFAULT_NOTE = new BigDecimal(1);
    private static final BigDecimal UPDATED_NOTE = new BigDecimal(2);

    @Autowired
    private DossiersSouscritereRepository dossiersSouscritereRepository;

    @Autowired
    private DossiersSouscritereMapper dossiersSouscritereMapper;

    @Autowired
    private DossiersSouscritereService dossiersSouscritereService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDossiersSouscritereMockMvc;

    private DossiersSouscritere dossiersSouscritere;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersSouscritere createEntity(EntityManager em) {
        DossiersSouscritere dossiersSouscritere = new DossiersSouscritere()
            .note(DEFAULT_NOTE);
        return dossiersSouscritere;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DossiersSouscritere createUpdatedEntity(EntityManager em) {
        DossiersSouscritere dossiersSouscritere = new DossiersSouscritere()
            .note(UPDATED_NOTE);
        return dossiersSouscritere;
    }

    @BeforeEach
    public void initTest() {
        dossiersSouscritere = createEntity(em);
    }

    @Test
    @Transactional
    public void createDossiersSouscritere() throws Exception {
        int databaseSizeBeforeCreate = dossiersSouscritereRepository.findAll().size();
        // Create the DossiersSouscritere
        DossiersSouscritereDTO dossiersSouscritereDTO = dossiersSouscritereMapper.toDto(dossiersSouscritere);
        restDossiersSouscritereMockMvc.perform(post("/api/dossiers-souscriteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersSouscritereDTO)))
            .andExpect(status().isCreated());

        // Validate the DossiersSouscritere in the database
        List<DossiersSouscritere> dossiersSouscritereList = dossiersSouscritereRepository.findAll();
        assertThat(dossiersSouscritereList).hasSize(databaseSizeBeforeCreate + 1);
        DossiersSouscritere testDossiersSouscritere = dossiersSouscritereList.get(dossiersSouscritereList.size() - 1);
        assertThat(testDossiersSouscritere.getNote()).isEqualTo(DEFAULT_NOTE);
    }

    @Test
    @Transactional
    public void createDossiersSouscritereWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dossiersSouscritereRepository.findAll().size();

        // Create the DossiersSouscritere with an existing ID
        dossiersSouscritere.setId(1L);
        DossiersSouscritereDTO dossiersSouscritereDTO = dossiersSouscritereMapper.toDto(dossiersSouscritere);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDossiersSouscritereMockMvc.perform(post("/api/dossiers-souscriteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersSouscritereDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersSouscritere in the database
        List<DossiersSouscritere> dossiersSouscritereList = dossiersSouscritereRepository.findAll();
        assertThat(dossiersSouscritereList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDossiersSouscriteres() throws Exception {
        // Initialize the database
        dossiersSouscritereRepository.saveAndFlush(dossiersSouscritere);

        // Get all the dossiersSouscritereList
        restDossiersSouscritereMockMvc.perform(get("/api/dossiers-souscriteres?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dossiersSouscritere.getId().intValue())))
            .andExpect(jsonPath("$.[*].note").value(hasItem(DEFAULT_NOTE.intValue())));
    }
    
    @Test
    @Transactional
    public void getDossiersSouscritere() throws Exception {
        // Initialize the database
        dossiersSouscritereRepository.saveAndFlush(dossiersSouscritere);

        // Get the dossiersSouscritere
        restDossiersSouscritereMockMvc.perform(get("/api/dossiers-souscriteres/{id}", dossiersSouscritere.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dossiersSouscritere.getId().intValue()))
            .andExpect(jsonPath("$.note").value(DEFAULT_NOTE.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDossiersSouscritere() throws Exception {
        // Get the dossiersSouscritere
        restDossiersSouscritereMockMvc.perform(get("/api/dossiers-souscriteres/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDossiersSouscritere() throws Exception {
        // Initialize the database
        dossiersSouscritereRepository.saveAndFlush(dossiersSouscritere);

        int databaseSizeBeforeUpdate = dossiersSouscritereRepository.findAll().size();

        // Update the dossiersSouscritere
        DossiersSouscritere updatedDossiersSouscritere = dossiersSouscritereRepository.findById(dossiersSouscritere.getId()).get();
        // Disconnect from session so that the updates on updatedDossiersSouscritere are not directly saved in db
        em.detach(updatedDossiersSouscritere);
        updatedDossiersSouscritere
            .note(UPDATED_NOTE);
        DossiersSouscritereDTO dossiersSouscritereDTO = dossiersSouscritereMapper.toDto(updatedDossiersSouscritere);

        restDossiersSouscritereMockMvc.perform(put("/api/dossiers-souscriteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersSouscritereDTO)))
            .andExpect(status().isOk());

        // Validate the DossiersSouscritere in the database
        List<DossiersSouscritere> dossiersSouscritereList = dossiersSouscritereRepository.findAll();
        assertThat(dossiersSouscritereList).hasSize(databaseSizeBeforeUpdate);
        DossiersSouscritere testDossiersSouscritere = dossiersSouscritereList.get(dossiersSouscritereList.size() - 1);
        assertThat(testDossiersSouscritere.getNote()).isEqualTo(UPDATED_NOTE);
    }

    @Test
    @Transactional
    public void updateNonExistingDossiersSouscritere() throws Exception {
        int databaseSizeBeforeUpdate = dossiersSouscritereRepository.findAll().size();

        // Create the DossiersSouscritere
        DossiersSouscritereDTO dossiersSouscritereDTO = dossiersSouscritereMapper.toDto(dossiersSouscritere);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDossiersSouscritereMockMvc.perform(put("/api/dossiers-souscriteres")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(dossiersSouscritereDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DossiersSouscritere in the database
        List<DossiersSouscritere> dossiersSouscritereList = dossiersSouscritereRepository.findAll();
        assertThat(dossiersSouscritereList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDossiersSouscritere() throws Exception {
        // Initialize the database
        dossiersSouscritereRepository.saveAndFlush(dossiersSouscritere);

        int databaseSizeBeforeDelete = dossiersSouscritereRepository.findAll().size();

        // Delete the dossiersSouscritere
        restDossiersSouscritereMockMvc.perform(delete("/api/dossiers-souscriteres/{id}", dossiersSouscritere.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DossiersSouscritere> dossiersSouscritereList = dossiersSouscritereRepository.findAll();
        assertThat(dossiersSouscritereList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
