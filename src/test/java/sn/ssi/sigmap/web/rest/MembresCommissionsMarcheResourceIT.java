package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.MembresCommissionsMarche;
import sn.ssi.sigmap.repository.MembresCommissionsMarcheRepository;
import sn.ssi.sigmap.service.MembresCommissionsMarcheService;
import sn.ssi.sigmap.service.dto.MembresCommissionsMarcheDTO;
import sn.ssi.sigmap.service.mapper.MembresCommissionsMarcheMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link MembresCommissionsMarcheResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class MembresCommissionsMarcheResourceIT {

    private static final String DEFAULT_NOM = "AAAAAAAAAA";
    private static final String UPDATED_NOM = "BBBBBBBBBB";

    private static final String DEFAULT_PRENOM = "AAAAAAAAAA";
    private static final String UPDATED_PRENOM = "BBBBBBBBBB";

    private static final String DEFAULT_FONCTION = "AAAAAAAAAA";
    private static final String UPDATED_FONCTION = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_GESTION = "AAAAAAAAAA";
    private static final String UPDATED_GESTION = "BBBBBBBBBB";

    private static final String DEFAULT_STATUT = "AAAAAAAAAA";
    private static final String UPDATED_STATUT = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_MEMBRE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_MEMBRE = "BBBBBBBBBB";

    private static final String DEFAULT_ARRETE = "AAAAAAAAAA";
    private static final String UPDATED_ARRETE = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_ARRETE = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_ARRETE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_PHOTO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PHOTO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_PHOTO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PHOTO_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGINE = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ETAPE_PI = 1;
    private static final Integer UPDATED_ETAPE_PI = 2;

    private static final Integer DEFAULT_FLAG_PRESIDENT = 1;
    private static final Integer UPDATED_FLAG_PRESIDENT = 2;

    private static final Integer DEFAULT_ACTIF = 1;
    private static final Integer UPDATED_ACTIF = 2;

    private static final Integer DEFAULT_POSITION = 1;
    private static final Integer UPDATED_POSITION = 2;

    private static final Integer DEFAULT_RECONDUIT = 1;
    private static final Integer UPDATED_RECONDUIT = 2;

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    private static final Long DEFAULT_MEMBRE = 1L;
    private static final Long UPDATED_MEMBRE = 2L;

    private static final LocalDate DEFAULT_DATE_ARRETE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_ARRETE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private MembresCommissionsMarcheRepository membresCommissionsMarcheRepository;

    @Autowired
    private MembresCommissionsMarcheMapper membresCommissionsMarcheMapper;

    @Autowired
    private MembresCommissionsMarcheService membresCommissionsMarcheService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMembresCommissionsMarcheMockMvc;

    private MembresCommissionsMarche membresCommissionsMarche;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MembresCommissionsMarche createEntity(EntityManager em) {
        MembresCommissionsMarche membresCommissionsMarche = new MembresCommissionsMarche()
            .nom(DEFAULT_NOM)
            .prenom(DEFAULT_PRENOM)
            .fonction(DEFAULT_FONCTION)
            .telephone(DEFAULT_TELEPHONE)
            .email(DEFAULT_EMAIL)
            .gestion(DEFAULT_GESTION)
            .statut(DEFAULT_STATUT)
            .typeMembre(DEFAULT_TYPE_MEMBRE)
            .arrete(DEFAULT_ARRETE)
            .fichierArrete(DEFAULT_FICHIER_ARRETE)
            .photo(DEFAULT_PHOTO)
            .photoContentType(DEFAULT_PHOTO_CONTENT_TYPE)
            .type(DEFAULT_TYPE)
            .origine(DEFAULT_ORIGINE)
            .etapePI(DEFAULT_ETAPE_PI)
            .flagPresident(DEFAULT_FLAG_PRESIDENT)
            .actif(DEFAULT_ACTIF)
            .position(DEFAULT_POSITION)
            .reconduit(DEFAULT_RECONDUIT)
            .autoriteId(DEFAULT_AUTORITE_ID)
            .membre(DEFAULT_MEMBRE)
            .dateArrete(DEFAULT_DATE_ARRETE);
        return membresCommissionsMarche;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MembresCommissionsMarche createUpdatedEntity(EntityManager em) {
        MembresCommissionsMarche membresCommissionsMarche = new MembresCommissionsMarche()
            .nom(UPDATED_NOM)
            .prenom(UPDATED_PRENOM)
            .fonction(UPDATED_FONCTION)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .gestion(UPDATED_GESTION)
            .statut(UPDATED_STATUT)
            .typeMembre(UPDATED_TYPE_MEMBRE)
            .arrete(UPDATED_ARRETE)
            .fichierArrete(UPDATED_FICHIER_ARRETE)
            .photo(UPDATED_PHOTO)
            .photoContentType(UPDATED_PHOTO_CONTENT_TYPE)
            .type(UPDATED_TYPE)
            .origine(UPDATED_ORIGINE)
            .etapePI(UPDATED_ETAPE_PI)
            .flagPresident(UPDATED_FLAG_PRESIDENT)
            .actif(UPDATED_ACTIF)
            .position(UPDATED_POSITION)
            .reconduit(UPDATED_RECONDUIT)
            .autoriteId(UPDATED_AUTORITE_ID)
            .membre(UPDATED_MEMBRE)
            .dateArrete(UPDATED_DATE_ARRETE);
        return membresCommissionsMarche;
    }

    @BeforeEach
    public void initTest() {
        membresCommissionsMarche = createEntity(em);
    }

    @Test
    @Transactional
    public void createMembresCommissionsMarche() throws Exception {
        int databaseSizeBeforeCreate = membresCommissionsMarcheRepository.findAll().size();
        // Create the MembresCommissionsMarche
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO = membresCommissionsMarcheMapper.toDto(membresCommissionsMarche);
        restMembresCommissionsMarcheMockMvc.perform(post("/api/membres-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(membresCommissionsMarcheDTO)))
            .andExpect(status().isCreated());

        // Validate the MembresCommissionsMarche in the database
        List<MembresCommissionsMarche> membresCommissionsMarcheList = membresCommissionsMarcheRepository.findAll();
        assertThat(membresCommissionsMarcheList).hasSize(databaseSizeBeforeCreate + 1);
        MembresCommissionsMarche testMembresCommissionsMarche = membresCommissionsMarcheList.get(membresCommissionsMarcheList.size() - 1);
        assertThat(testMembresCommissionsMarche.getNom()).isEqualTo(DEFAULT_NOM);
        assertThat(testMembresCommissionsMarche.getPrenom()).isEqualTo(DEFAULT_PRENOM);
        assertThat(testMembresCommissionsMarche.getFonction()).isEqualTo(DEFAULT_FONCTION);
        assertThat(testMembresCommissionsMarche.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testMembresCommissionsMarche.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testMembresCommissionsMarche.getGestion()).isEqualTo(DEFAULT_GESTION);
        assertThat(testMembresCommissionsMarche.getStatut()).isEqualTo(DEFAULT_STATUT);
        assertThat(testMembresCommissionsMarche.getTypeMembre()).isEqualTo(DEFAULT_TYPE_MEMBRE);
        assertThat(testMembresCommissionsMarche.getArrete()).isEqualTo(DEFAULT_ARRETE);
        assertThat(testMembresCommissionsMarche.getFichierArrete()).isEqualTo(DEFAULT_FICHIER_ARRETE);
        assertThat(testMembresCommissionsMarche.getPhoto()).isEqualTo(DEFAULT_PHOTO);
        assertThat(testMembresCommissionsMarche.getPhotoContentType()).isEqualTo(DEFAULT_PHOTO_CONTENT_TYPE);
        assertThat(testMembresCommissionsMarche.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testMembresCommissionsMarche.getOrigine()).isEqualTo(DEFAULT_ORIGINE);
        assertThat(testMembresCommissionsMarche.getEtapePI()).isEqualTo(DEFAULT_ETAPE_PI);
        assertThat(testMembresCommissionsMarche.getFlagPresident()).isEqualTo(DEFAULT_FLAG_PRESIDENT);
        assertThat(testMembresCommissionsMarche.getActif()).isEqualTo(DEFAULT_ACTIF);
        assertThat(testMembresCommissionsMarche.getPosition()).isEqualTo(DEFAULT_POSITION);
        assertThat(testMembresCommissionsMarche.getReconduit()).isEqualTo(DEFAULT_RECONDUIT);
        assertThat(testMembresCommissionsMarche.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
        assertThat(testMembresCommissionsMarche.getMembre()).isEqualTo(DEFAULT_MEMBRE);
        assertThat(testMembresCommissionsMarche.getDateArrete()).isEqualTo(DEFAULT_DATE_ARRETE);
    }

    @Test
    @Transactional
    public void createMembresCommissionsMarcheWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = membresCommissionsMarcheRepository.findAll().size();

        // Create the MembresCommissionsMarche with an existing ID
        membresCommissionsMarche.setId(1L);
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO = membresCommissionsMarcheMapper.toDto(membresCommissionsMarche);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMembresCommissionsMarcheMockMvc.perform(post("/api/membres-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(membresCommissionsMarcheDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MembresCommissionsMarche in the database
        List<MembresCommissionsMarche> membresCommissionsMarcheList = membresCommissionsMarcheRepository.findAll();
        assertThat(membresCommissionsMarcheList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllMembresCommissionsMarches() throws Exception {
        // Initialize the database
        membresCommissionsMarcheRepository.saveAndFlush(membresCommissionsMarche);

        // Get all the membresCommissionsMarcheList
        restMembresCommissionsMarcheMockMvc.perform(get("/api/membres-commissions-marches?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(membresCommissionsMarche.getId().intValue())))
            .andExpect(jsonPath("$.[*].nom").value(hasItem(DEFAULT_NOM)))
            .andExpect(jsonPath("$.[*].prenom").value(hasItem(DEFAULT_PRENOM)))
            .andExpect(jsonPath("$.[*].fonction").value(hasItem(DEFAULT_FONCTION)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].gestion").value(hasItem(DEFAULT_GESTION)))
            .andExpect(jsonPath("$.[*].statut").value(hasItem(DEFAULT_STATUT)))
            .andExpect(jsonPath("$.[*].typeMembre").value(hasItem(DEFAULT_TYPE_MEMBRE)))
            .andExpect(jsonPath("$.[*].arrete").value(hasItem(DEFAULT_ARRETE)))
            .andExpect(jsonPath("$.[*].fichierArrete").value(hasItem(DEFAULT_FICHIER_ARRETE)))
            .andExpect(jsonPath("$.[*].photoContentType").value(hasItem(DEFAULT_PHOTO_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].photo").value(hasItem(Base64Utils.encodeToString(DEFAULT_PHOTO))))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].origine").value(hasItem(DEFAULT_ORIGINE)))
            .andExpect(jsonPath("$.[*].etapePI").value(hasItem(DEFAULT_ETAPE_PI)))
            .andExpect(jsonPath("$.[*].flagPresident").value(hasItem(DEFAULT_FLAG_PRESIDENT)))
            .andExpect(jsonPath("$.[*].actif").value(hasItem(DEFAULT_ACTIF)))
            .andExpect(jsonPath("$.[*].position").value(hasItem(DEFAULT_POSITION)))
            .andExpect(jsonPath("$.[*].reconduit").value(hasItem(DEFAULT_RECONDUIT)))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())))
            .andExpect(jsonPath("$.[*].membre").value(hasItem(DEFAULT_MEMBRE.intValue())))
            .andExpect(jsonPath("$.[*].dateArrete").value(hasItem(DEFAULT_DATE_ARRETE.toString())));
    }
    
    @Test
    @Transactional
    public void getMembresCommissionsMarche() throws Exception {
        // Initialize the database
        membresCommissionsMarcheRepository.saveAndFlush(membresCommissionsMarche);

        // Get the membresCommissionsMarche
        restMembresCommissionsMarcheMockMvc.perform(get("/api/membres-commissions-marches/{id}", membresCommissionsMarche.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(membresCommissionsMarche.getId().intValue()))
            .andExpect(jsonPath("$.nom").value(DEFAULT_NOM))
            .andExpect(jsonPath("$.prenom").value(DEFAULT_PRENOM))
            .andExpect(jsonPath("$.fonction").value(DEFAULT_FONCTION))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.gestion").value(DEFAULT_GESTION))
            .andExpect(jsonPath("$.statut").value(DEFAULT_STATUT))
            .andExpect(jsonPath("$.typeMembre").value(DEFAULT_TYPE_MEMBRE))
            .andExpect(jsonPath("$.arrete").value(DEFAULT_ARRETE))
            .andExpect(jsonPath("$.fichierArrete").value(DEFAULT_FICHIER_ARRETE))
            .andExpect(jsonPath("$.photoContentType").value(DEFAULT_PHOTO_CONTENT_TYPE))
            .andExpect(jsonPath("$.photo").value(Base64Utils.encodeToString(DEFAULT_PHOTO)))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.origine").value(DEFAULT_ORIGINE))
            .andExpect(jsonPath("$.etapePI").value(DEFAULT_ETAPE_PI))
            .andExpect(jsonPath("$.flagPresident").value(DEFAULT_FLAG_PRESIDENT))
            .andExpect(jsonPath("$.actif").value(DEFAULT_ACTIF))
            .andExpect(jsonPath("$.position").value(DEFAULT_POSITION))
            .andExpect(jsonPath("$.reconduit").value(DEFAULT_RECONDUIT))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()))
            .andExpect(jsonPath("$.membre").value(DEFAULT_MEMBRE.intValue()))
            .andExpect(jsonPath("$.dateArrete").value(DEFAULT_DATE_ARRETE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingMembresCommissionsMarche() throws Exception {
        // Get the membresCommissionsMarche
        restMembresCommissionsMarcheMockMvc.perform(get("/api/membres-commissions-marches/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMembresCommissionsMarche() throws Exception {
        // Initialize the database
        membresCommissionsMarcheRepository.saveAndFlush(membresCommissionsMarche);

        int databaseSizeBeforeUpdate = membresCommissionsMarcheRepository.findAll().size();

        // Update the membresCommissionsMarche
        MembresCommissionsMarche updatedMembresCommissionsMarche = membresCommissionsMarcheRepository.findById(membresCommissionsMarche.getId()).get();
        // Disconnect from session so that the updates on updatedMembresCommissionsMarche are not directly saved in db
        em.detach(updatedMembresCommissionsMarche);
        updatedMembresCommissionsMarche
            .nom(UPDATED_NOM)
            .prenom(UPDATED_PRENOM)
            .fonction(UPDATED_FONCTION)
            .telephone(UPDATED_TELEPHONE)
            .email(UPDATED_EMAIL)
            .gestion(UPDATED_GESTION)
            .statut(UPDATED_STATUT)
            .typeMembre(UPDATED_TYPE_MEMBRE)
            .arrete(UPDATED_ARRETE)
            .fichierArrete(UPDATED_FICHIER_ARRETE)
            .photo(UPDATED_PHOTO)
            .photoContentType(UPDATED_PHOTO_CONTENT_TYPE)
            .type(UPDATED_TYPE)
            .origine(UPDATED_ORIGINE)
            .etapePI(UPDATED_ETAPE_PI)
            .flagPresident(UPDATED_FLAG_PRESIDENT)
            .actif(UPDATED_ACTIF)
            .position(UPDATED_POSITION)
            .reconduit(UPDATED_RECONDUIT)
            .autoriteId(UPDATED_AUTORITE_ID)
            .membre(UPDATED_MEMBRE)
            .dateArrete(UPDATED_DATE_ARRETE);
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO = membresCommissionsMarcheMapper.toDto(updatedMembresCommissionsMarche);

        restMembresCommissionsMarcheMockMvc.perform(put("/api/membres-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(membresCommissionsMarcheDTO)))
            .andExpect(status().isOk());

        // Validate the MembresCommissionsMarche in the database
        List<MembresCommissionsMarche> membresCommissionsMarcheList = membresCommissionsMarcheRepository.findAll();
        assertThat(membresCommissionsMarcheList).hasSize(databaseSizeBeforeUpdate);
        MembresCommissionsMarche testMembresCommissionsMarche = membresCommissionsMarcheList.get(membresCommissionsMarcheList.size() - 1);
        assertThat(testMembresCommissionsMarche.getNom()).isEqualTo(UPDATED_NOM);
        assertThat(testMembresCommissionsMarche.getPrenom()).isEqualTo(UPDATED_PRENOM);
        assertThat(testMembresCommissionsMarche.getFonction()).isEqualTo(UPDATED_FONCTION);
        assertThat(testMembresCommissionsMarche.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testMembresCommissionsMarche.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testMembresCommissionsMarche.getGestion()).isEqualTo(UPDATED_GESTION);
        assertThat(testMembresCommissionsMarche.getStatut()).isEqualTo(UPDATED_STATUT);
        assertThat(testMembresCommissionsMarche.getTypeMembre()).isEqualTo(UPDATED_TYPE_MEMBRE);
        assertThat(testMembresCommissionsMarche.getArrete()).isEqualTo(UPDATED_ARRETE);
        assertThat(testMembresCommissionsMarche.getFichierArrete()).isEqualTo(UPDATED_FICHIER_ARRETE);
        assertThat(testMembresCommissionsMarche.getPhoto()).isEqualTo(UPDATED_PHOTO);
        assertThat(testMembresCommissionsMarche.getPhotoContentType()).isEqualTo(UPDATED_PHOTO_CONTENT_TYPE);
        assertThat(testMembresCommissionsMarche.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testMembresCommissionsMarche.getOrigine()).isEqualTo(UPDATED_ORIGINE);
        assertThat(testMembresCommissionsMarche.getEtapePI()).isEqualTo(UPDATED_ETAPE_PI);
        assertThat(testMembresCommissionsMarche.getFlagPresident()).isEqualTo(UPDATED_FLAG_PRESIDENT);
        assertThat(testMembresCommissionsMarche.getActif()).isEqualTo(UPDATED_ACTIF);
        assertThat(testMembresCommissionsMarche.getPosition()).isEqualTo(UPDATED_POSITION);
        assertThat(testMembresCommissionsMarche.getReconduit()).isEqualTo(UPDATED_RECONDUIT);
        assertThat(testMembresCommissionsMarche.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
        assertThat(testMembresCommissionsMarche.getMembre()).isEqualTo(UPDATED_MEMBRE);
        assertThat(testMembresCommissionsMarche.getDateArrete()).isEqualTo(UPDATED_DATE_ARRETE);
    }

    @Test
    @Transactional
    public void updateNonExistingMembresCommissionsMarche() throws Exception {
        int databaseSizeBeforeUpdate = membresCommissionsMarcheRepository.findAll().size();

        // Create the MembresCommissionsMarche
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO = membresCommissionsMarcheMapper.toDto(membresCommissionsMarche);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMembresCommissionsMarcheMockMvc.perform(put("/api/membres-commissions-marches")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(membresCommissionsMarcheDTO)))
            .andExpect(status().isBadRequest());

        // Validate the MembresCommissionsMarche in the database
        List<MembresCommissionsMarche> membresCommissionsMarcheList = membresCommissionsMarcheRepository.findAll();
        assertThat(membresCommissionsMarcheList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMembresCommissionsMarche() throws Exception {
        // Initialize the database
        membresCommissionsMarcheRepository.saveAndFlush(membresCommissionsMarche);

        int databaseSizeBeforeDelete = membresCommissionsMarcheRepository.findAll().size();

        // Delete the membresCommissionsMarche
        restMembresCommissionsMarcheMockMvc.perform(delete("/api/membres-commissions-marches/{id}", membresCommissionsMarche.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<MembresCommissionsMarche> membresCommissionsMarcheList = membresCommissionsMarcheRepository.findAll();
        assertThat(membresCommissionsMarcheList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
