package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Devise;
import sn.ssi.sigmap.repository.DeviseRepository;
import sn.ssi.sigmap.service.DeviseService;
import sn.ssi.sigmap.service.dto.DeviseDTO;
import sn.ssi.sigmap.service.mapper.DeviseMapper;

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
 * Integration tests for the {@link DeviseResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DeviseResourceIT {

    private static final BigDecimal DEFAULT_DEV_TAUX_CONVERSION = new BigDecimal(1);
    private static final BigDecimal UPDATED_DEV_TAUX_CONVERSION = new BigDecimal(2);

    @Autowired
    private DeviseRepository deviseRepository;

    @Autowired
    private DeviseMapper deviseMapper;

    @Autowired
    private DeviseService deviseService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDeviseMockMvc;

    private Devise devise;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Devise createEntity(EntityManager em) {
        Devise devise = new Devise()
            .devTauxConversion(DEFAULT_DEV_TAUX_CONVERSION);
        return devise;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Devise createUpdatedEntity(EntityManager em) {
        Devise devise = new Devise()
            .devTauxConversion(UPDATED_DEV_TAUX_CONVERSION);
        return devise;
    }

    @BeforeEach
    public void initTest() {
        devise = createEntity(em);
    }

    @Test
    @Transactional
    public void createDevise() throws Exception {
        int databaseSizeBeforeCreate = deviseRepository.findAll().size();
        // Create the Devise
        DeviseDTO deviseDTO = deviseMapper.toDto(devise);
        restDeviseMockMvc.perform(post("/api/devises")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(deviseDTO)))
            .andExpect(status().isCreated());

        // Validate the Devise in the database
        List<Devise> deviseList = deviseRepository.findAll();
        assertThat(deviseList).hasSize(databaseSizeBeforeCreate + 1);
        Devise testDevise = deviseList.get(deviseList.size() - 1);
        assertThat(testDevise.getDevTauxConversion()).isEqualTo(DEFAULT_DEV_TAUX_CONVERSION);
    }

    @Test
    @Transactional
    public void createDeviseWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = deviseRepository.findAll().size();

        // Create the Devise with an existing ID
        devise.setId(1L);
        DeviseDTO deviseDTO = deviseMapper.toDto(devise);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDeviseMockMvc.perform(post("/api/devises")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(deviseDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Devise in the database
        List<Devise> deviseList = deviseRepository.findAll();
        assertThat(deviseList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDevises() throws Exception {
        // Initialize the database
        deviseRepository.saveAndFlush(devise);

        // Get all the deviseList
        restDeviseMockMvc.perform(get("/api/devises?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(devise.getId().intValue())))
            .andExpect(jsonPath("$.[*].devTauxConversion").value(hasItem(DEFAULT_DEV_TAUX_CONVERSION.intValue())));
    }
    
    @Test
    @Transactional
    public void getDevise() throws Exception {
        // Initialize the database
        deviseRepository.saveAndFlush(devise);

        // Get the devise
        restDeviseMockMvc.perform(get("/api/devises/{id}", devise.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(devise.getId().intValue()))
            .andExpect(jsonPath("$.devTauxConversion").value(DEFAULT_DEV_TAUX_CONVERSION.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDevise() throws Exception {
        // Get the devise
        restDeviseMockMvc.perform(get("/api/devises/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDevise() throws Exception {
        // Initialize the database
        deviseRepository.saveAndFlush(devise);

        int databaseSizeBeforeUpdate = deviseRepository.findAll().size();

        // Update the devise
        Devise updatedDevise = deviseRepository.findById(devise.getId()).get();
        // Disconnect from session so that the updates on updatedDevise are not directly saved in db
        em.detach(updatedDevise);
        updatedDevise
            .devTauxConversion(UPDATED_DEV_TAUX_CONVERSION);
        DeviseDTO deviseDTO = deviseMapper.toDto(updatedDevise);

        restDeviseMockMvc.perform(put("/api/devises")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(deviseDTO)))
            .andExpect(status().isOk());

        // Validate the Devise in the database
        List<Devise> deviseList = deviseRepository.findAll();
        assertThat(deviseList).hasSize(databaseSizeBeforeUpdate);
        Devise testDevise = deviseList.get(deviseList.size() - 1);
        assertThat(testDevise.getDevTauxConversion()).isEqualTo(UPDATED_DEV_TAUX_CONVERSION);
    }

    @Test
    @Transactional
    public void updateNonExistingDevise() throws Exception {
        int databaseSizeBeforeUpdate = deviseRepository.findAll().size();

        // Create the Devise
        DeviseDTO deviseDTO = deviseMapper.toDto(devise);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDeviseMockMvc.perform(put("/api/devises")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(deviseDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Devise in the database
        List<Devise> deviseList = deviseRepository.findAll();
        assertThat(deviseList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDevise() throws Exception {
        // Initialize the database
        deviseRepository.saveAndFlush(devise);

        int databaseSizeBeforeDelete = deviseRepository.findAll().size();

        // Delete the devise
        restDeviseMockMvc.perform(delete("/api/devises/{id}", devise.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Devise> deviseList = deviseRepository.findAll();
        assertThat(deviseList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
