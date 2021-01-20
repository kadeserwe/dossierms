package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.RetraitRegistreDAO;
import sn.ssi.sigmap.repository.RetraitRegistreDAORepository;
import sn.ssi.sigmap.service.RetraitRegistreDAOService;
import sn.ssi.sigmap.service.dto.RetraitRegistreDAODTO;
import sn.ssi.sigmap.service.mapper.RetraitRegistreDAOMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link RetraitRegistreDAOResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class RetraitRegistreDAOResourceIT {

    private static final String DEFAULT_NOM_SOUMISSIONNAIRE = "AAAAAAAAAA";
    private static final String UPDATED_NOM_SOUMISSIONNAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_MODE_PAIEMENT = "AAAAAAAAAA";
    private static final String UPDATED_MODE_PAIEMENT = "BBBBBBBBBB";

    private static final String DEFAULT_NINEA = "AAAAAAAAAA";
    private static final String UPDATED_NINEA = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_MONTANT_VERSE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_VERSE = new BigDecimal(2);

    private static final LocalDate DEFAULT_DATE_RETRAIT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_RETRAIT = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private RetraitRegistreDAORepository retraitRegistreDAORepository;

    @Autowired
    private RetraitRegistreDAOMapper retraitRegistreDAOMapper;

    @Autowired
    private RetraitRegistreDAOService retraitRegistreDAOService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restRetraitRegistreDAOMockMvc;

    private RetraitRegistreDAO retraitRegistreDAO;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RetraitRegistreDAO createEntity(EntityManager em) {
        RetraitRegistreDAO retraitRegistreDAO = new RetraitRegistreDAO()
            .nomSoumissionnaire(DEFAULT_NOM_SOUMISSIONNAIRE)
            .telephone(DEFAULT_TELEPHONE)
            .email(DEFAULT_EMAIL)
            .modePaiement(DEFAULT_MODE_PAIEMENT)
            .ninea(DEFAULT_NINEA)
            .montantVerse(DEFAULT_MONTANT_VERSE)
            .dateRetrait(DEFAULT_DATE_RETRAIT);
        return retraitRegistreDAO;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RetraitRegistreDAO createUpdatedEntity(EntityManager em) {
        RetraitRegistreDAO retraitRegistreDAO = new RetraitRegistreDAO()
            .nomSoumissionnaire(UPDATED_NOM_SOUMISSIONNAIRE)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .modePaiement(UPDATED_MODE_PAIEMENT)
            .ninea(UPDATED_NINEA)
            .montantVerse(UPDATED_MONTANT_VERSE)
            .dateRetrait(UPDATED_DATE_RETRAIT);
        return retraitRegistreDAO;
    }

    @BeforeEach
    public void initTest() {
        retraitRegistreDAO = createEntity(em);
    }

    @Test
    @Transactional
    public void createRetraitRegistreDAO() throws Exception {
        int databaseSizeBeforeCreate = retraitRegistreDAORepository.findAll().size();
        // Create the RetraitRegistreDAO
        RetraitRegistreDAODTO retraitRegistreDAODTO = retraitRegistreDAOMapper.toDto(retraitRegistreDAO);
        restRetraitRegistreDAOMockMvc.perform(post("/api/retrait-registre-daos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(retraitRegistreDAODTO)))
            .andExpect(status().isCreated());

        // Validate the RetraitRegistreDAO in the database
        List<RetraitRegistreDAO> retraitRegistreDAOList = retraitRegistreDAORepository.findAll();
        assertThat(retraitRegistreDAOList).hasSize(databaseSizeBeforeCreate + 1);
        RetraitRegistreDAO testRetraitRegistreDAO = retraitRegistreDAOList.get(retraitRegistreDAOList.size() - 1);
        assertThat(testRetraitRegistreDAO.getNomSoumissionnaire()).isEqualTo(DEFAULT_NOM_SOUMISSIONNAIRE);
        assertThat(testRetraitRegistreDAO.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testRetraitRegistreDAO.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testRetraitRegistreDAO.getModePaiement()).isEqualTo(DEFAULT_MODE_PAIEMENT);
        assertThat(testRetraitRegistreDAO.getNinea()).isEqualTo(DEFAULT_NINEA);
        assertThat(testRetraitRegistreDAO.getMontantVerse()).isEqualTo(DEFAULT_MONTANT_VERSE);
        assertThat(testRetraitRegistreDAO.getDateRetrait()).isEqualTo(DEFAULT_DATE_RETRAIT);
    }

    @Test
    @Transactional
    public void createRetraitRegistreDAOWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = retraitRegistreDAORepository.findAll().size();

        // Create the RetraitRegistreDAO with an existing ID
        retraitRegistreDAO.setId(1L);
        RetraitRegistreDAODTO retraitRegistreDAODTO = retraitRegistreDAOMapper.toDto(retraitRegistreDAO);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRetraitRegistreDAOMockMvc.perform(post("/api/retrait-registre-daos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(retraitRegistreDAODTO)))
            .andExpect(status().isBadRequest());

        // Validate the RetraitRegistreDAO in the database
        List<RetraitRegistreDAO> retraitRegistreDAOList = retraitRegistreDAORepository.findAll();
        assertThat(retraitRegistreDAOList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRetraitRegistreDAOS() throws Exception {
        // Initialize the database
        retraitRegistreDAORepository.saveAndFlush(retraitRegistreDAO);

        // Get all the retraitRegistreDAOList
        restRetraitRegistreDAOMockMvc.perform(get("/api/retrait-registre-daos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(retraitRegistreDAO.getId().intValue())))
            .andExpect(jsonPath("$.[*].nomSoumissionnaire").value(hasItem(DEFAULT_NOM_SOUMISSIONNAIRE)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].modePaiement").value(hasItem(DEFAULT_MODE_PAIEMENT)))
            .andExpect(jsonPath("$.[*].ninea").value(hasItem(DEFAULT_NINEA)))
            .andExpect(jsonPath("$.[*].montantVerse").value(hasItem(DEFAULT_MONTANT_VERSE.intValue())))
            .andExpect(jsonPath("$.[*].dateRetrait").value(hasItem(DEFAULT_DATE_RETRAIT.toString())));
    }
    
    @Test
    @Transactional
    public void getRetraitRegistreDAO() throws Exception {
        // Initialize the database
        retraitRegistreDAORepository.saveAndFlush(retraitRegistreDAO);

        // Get the retraitRegistreDAO
        restRetraitRegistreDAOMockMvc.perform(get("/api/retrait-registre-daos/{id}", retraitRegistreDAO.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(retraitRegistreDAO.getId().intValue()))
            .andExpect(jsonPath("$.nomSoumissionnaire").value(DEFAULT_NOM_SOUMISSIONNAIRE))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.modePaiement").value(DEFAULT_MODE_PAIEMENT))
            .andExpect(jsonPath("$.ninea").value(DEFAULT_NINEA))
            .andExpect(jsonPath("$.montantVerse").value(DEFAULT_MONTANT_VERSE.intValue()))
            .andExpect(jsonPath("$.dateRetrait").value(DEFAULT_DATE_RETRAIT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingRetraitRegistreDAO() throws Exception {
        // Get the retraitRegistreDAO
        restRetraitRegistreDAOMockMvc.perform(get("/api/retrait-registre-daos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRetraitRegistreDAO() throws Exception {
        // Initialize the database
        retraitRegistreDAORepository.saveAndFlush(retraitRegistreDAO);

        int databaseSizeBeforeUpdate = retraitRegistreDAORepository.findAll().size();

        // Update the retraitRegistreDAO
        RetraitRegistreDAO updatedRetraitRegistreDAO = retraitRegistreDAORepository.findById(retraitRegistreDAO.getId()).get();
        // Disconnect from session so that the updates on updatedRetraitRegistreDAO are not directly saved in db
        em.detach(updatedRetraitRegistreDAO);
        updatedRetraitRegistreDAO
            .nomSoumissionnaire(UPDATED_NOM_SOUMISSIONNAIRE)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .modePaiement(UPDATED_MODE_PAIEMENT)
            .ninea(UPDATED_NINEA)
            .montantVerse(UPDATED_MONTANT_VERSE)
            .dateRetrait(UPDATED_DATE_RETRAIT);
        RetraitRegistreDAODTO retraitRegistreDAODTO = retraitRegistreDAOMapper.toDto(updatedRetraitRegistreDAO);

        restRetraitRegistreDAOMockMvc.perform(put("/api/retrait-registre-daos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(retraitRegistreDAODTO)))
            .andExpect(status().isOk());

        // Validate the RetraitRegistreDAO in the database
        List<RetraitRegistreDAO> retraitRegistreDAOList = retraitRegistreDAORepository.findAll();
        assertThat(retraitRegistreDAOList).hasSize(databaseSizeBeforeUpdate);
        RetraitRegistreDAO testRetraitRegistreDAO = retraitRegistreDAOList.get(retraitRegistreDAOList.size() - 1);
        assertThat(testRetraitRegistreDAO.getNomSoumissionnaire()).isEqualTo(UPDATED_NOM_SOUMISSIONNAIRE);
        assertThat(testRetraitRegistreDAO.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testRetraitRegistreDAO.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testRetraitRegistreDAO.getModePaiement()).isEqualTo(UPDATED_MODE_PAIEMENT);
        assertThat(testRetraitRegistreDAO.getNinea()).isEqualTo(UPDATED_NINEA);
        assertThat(testRetraitRegistreDAO.getMontantVerse()).isEqualTo(UPDATED_MONTANT_VERSE);
        assertThat(testRetraitRegistreDAO.getDateRetrait()).isEqualTo(UPDATED_DATE_RETRAIT);
    }

    @Test
    @Transactional
    public void updateNonExistingRetraitRegistreDAO() throws Exception {
        int databaseSizeBeforeUpdate = retraitRegistreDAORepository.findAll().size();

        // Create the RetraitRegistreDAO
        RetraitRegistreDAODTO retraitRegistreDAODTO = retraitRegistreDAOMapper.toDto(retraitRegistreDAO);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRetraitRegistreDAOMockMvc.perform(put("/api/retrait-registre-daos")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(retraitRegistreDAODTO)))
            .andExpect(status().isBadRequest());

        // Validate the RetraitRegistreDAO in the database
        List<RetraitRegistreDAO> retraitRegistreDAOList = retraitRegistreDAORepository.findAll();
        assertThat(retraitRegistreDAOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRetraitRegistreDAO() throws Exception {
        // Initialize the database
        retraitRegistreDAORepository.saveAndFlush(retraitRegistreDAO);

        int databaseSizeBeforeDelete = retraitRegistreDAORepository.findAll().size();

        // Delete the retraitRegistreDAO
        restRetraitRegistreDAOMockMvc.perform(delete("/api/retrait-registre-daos/{id}", retraitRegistreDAO.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<RetraitRegistreDAO> retraitRegistreDAOList = retraitRegistreDAORepository.findAll();
        assertThat(retraitRegistreDAOList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
