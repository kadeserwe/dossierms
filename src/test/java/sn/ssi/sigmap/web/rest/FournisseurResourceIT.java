package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Fournisseur;
import sn.ssi.sigmap.repository.FournisseurRepository;
import sn.ssi.sigmap.service.FournisseurService;
import sn.ssi.sigmap.service.dto.FournisseurDTO;
import sn.ssi.sigmap.service.mapper.FournisseurMapper;

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
 * Integration tests for the {@link FournisseurResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class FournisseurResourceIT {

    private static final String DEFAULT_NOM = "AAAAAAAAAA";
    private static final String UPDATED_NOM = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESSE = "AAAAAAAAAA";
    private static final String UPDATED_ADRESSE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final Integer DEFAULT_TELEPHONE = 1;
    private static final Integer UPDATED_TELEPHONE = 2;

    private static final Integer DEFAULT_NUMERO_REGISTRE_COMMERCE = 1;
    private static final Integer UPDATED_NUMERO_REGISTRE_COMMERCE = 2;

    private static final String DEFAULT_PIECEJOINTE = "AAAAAAAAAA";
    private static final String UPDATED_PIECEJOINTE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITE = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESSECOMPTABLE = "AAAAAAAAAA";
    private static final String UPDATED_ADRESSECOMPTABLE = "BBBBBBBBBB";

    private static final String DEFAULT_ADRESSEDIRIGEANT = "AAAAAAAAAA";
    private static final String UPDATED_ADRESSEDIRIGEANT = "BBBBBBBBBB";

    private static final String DEFAULT_AUTREDENOMINATION = "AAAAAAAAAA";
    private static final String UPDATED_AUTREDENOMINATION = "BBBBBBBBBB";

    private static final String DEFAULT_AUTREFORMEJURIDIQUE = "AAAAAAAAAA";
    private static final String UPDATED_AUTREFORMEJURIDIQUE = "BBBBBBBBBB";

    private static final String DEFAULT_BPCOMPTABLE = "AAAAAAAAAA";
    private static final String UPDATED_BPCOMPTABLE = "BBBBBBBBBB";

    private static final String DEFAULT_BPDEUX = "AAAAAAAAAA";
    private static final String UPDATED_BPDEUX = "BBBBBBBBBB";

    private static final String DEFAULT_BPTROIS = "AAAAAAAAAA";
    private static final String UPDATED_BPTROIS = "BBBBBBBBBB";

    private static final String DEFAULT_BPUN = "AAAAAAAAAA";
    private static final String UPDATED_BPUN = "BBBBBBBBBB";

    private static final String DEFAULT_BPSECONDAIRE = "AAAAAAAAAA";
    private static final String UPDATED_BPSECONDAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_CENTREIMPOT = "AAAAAAAAAA";
    private static final String UPDATED_CENTREIMPOT = "BBBBBBBBBB";

    private static final String DEFAULT_COMPTABLE = "AAAAAAAAAA";
    private static final String UPDATED_COMPTABLE = "BBBBBBBBBB";

    private static final String DEFAULT_DIRIGEANT = "AAAAAAAAAA";
    private static final String UPDATED_DIRIGEANT = "BBBBBBBBBB";

    private static final String DEFAULT_ENSEIGNE = "AAAAAAAAAA";
    private static final String UPDATED_ENSEIGNE = "BBBBBBBBBB";

    private static final String DEFAULT_ETSSECONDAIRE = "AAAAAAAAAA";
    private static final String UPDATED_ETSSECONDAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_INSAE = "AAAAAAAAAA";
    private static final String UPDATED_INSAE = "BBBBBBBBBB";

    private static final String DEFAULT_FORMEJURIDIQUE = "AAAAAAAAAA";
    private static final String UPDATED_FORMEJURIDIQUE = "BBBBBBBBBB";

    private static final String DEFAULT_PROPRIETAIRESIEGE = "AAAAAAAAAA";
    private static final String UPDATED_PROPRIETAIRESIEGE = "BBBBBBBBBB";

    private static final String DEFAULT_QUARTIER = "AAAAAAAAAA";
    private static final String UPDATED_QUARTIER = "BBBBBBBBBB";

    private static final String DEFAULT_NUMEROENREGISTREMENT = "AAAAAAAAAA";
    private static final String UPDATED_NUMEROENREGISTREMENT = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICEENCHARGE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICEENCHARGE = "BBBBBBBBBB";

    private static final String DEFAULT_SIEGE = "AAAAAAAAAA";
    private static final String UPDATED_SIEGE = "BBBBBBBBBB";

    private static final String DEFAULT_SIGLE = "AAAAAAAAAA";
    private static final String UPDATED_SIGLE = "BBBBBBBBBB";

    private static final String DEFAULT_TELCOMPTABLE = "AAAAAAAAAA";
    private static final String UPDATED_TELCOMPTABLE = "BBBBBBBBBB";

    private static final String DEFAULT_TELDEUX = "AAAAAAAAAA";
    private static final String UPDATED_TELDEUX = "BBBBBBBBBB";

    private static final String DEFAULT_TELDIRIGEANT = "AAAAAAAAAA";
    private static final String UPDATED_TELDIRIGEANT = "BBBBBBBBBB";

    private static final String DEFAULT_TELSECONDAIRE = "AAAAAAAAAA";
    private static final String UPDATED_TELSECONDAIRE = "BBBBBBBBBB";

    private static final String DEFAULT_TELTROIS = "AAAAAAAAAA";
    private static final String UPDATED_TELTROIS = "BBBBBBBBBB";

    private static final String DEFAULT_TELUN = "AAAAAAAAAA";
    private static final String UPDATED_TELUN = "BBBBBBBBBB";

    private static final String DEFAULT_VILLE = "AAAAAAAAAA";
    private static final String UPDATED_VILLE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPEDGE = "AAAAAAAAAA";
    private static final String UPDATED_TYPEDGE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_UTILISATEUR_LOGIN = "AAAAAAAAAA";
    private static final String UPDATED_UTILISATEUR_LOGIN = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FournisseurMapper fournisseurMapper;

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFournisseurMockMvc;

    private Fournisseur fournisseur;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Fournisseur createEntity(EntityManager em) {
        Fournisseur fournisseur = new Fournisseur()
            .nom(DEFAULT_NOM)
            .adresse(DEFAULT_ADRESSE)
            .email(DEFAULT_EMAIL)
            .telephone(DEFAULT_TELEPHONE)
            .numeroRegistreCommerce(DEFAULT_NUMERO_REGISTRE_COMMERCE)
            .piecejointe(DEFAULT_PIECEJOINTE)
            .code(DEFAULT_CODE)
            .activite(DEFAULT_ACTIVITE)
            .adressecomptable(DEFAULT_ADRESSECOMPTABLE)
            .adressedirigeant(DEFAULT_ADRESSEDIRIGEANT)
            .autredenomination(DEFAULT_AUTREDENOMINATION)
            .autreformejuridique(DEFAULT_AUTREFORMEJURIDIQUE)
            .bpcomptable(DEFAULT_BPCOMPTABLE)
            .bpdeux(DEFAULT_BPDEUX)
            .bptrois(DEFAULT_BPTROIS)
            .bpun(DEFAULT_BPUN)
            .bpsecondaire(DEFAULT_BPSECONDAIRE)
            .centreimpot(DEFAULT_CENTREIMPOT)
            .comptable(DEFAULT_COMPTABLE)
            .dirigeant(DEFAULT_DIRIGEANT)
            .enseigne(DEFAULT_ENSEIGNE)
            .etssecondaire(DEFAULT_ETSSECONDAIRE)
            .insae(DEFAULT_INSAE)
            .formejuridique(DEFAULT_FORMEJURIDIQUE)
            .proprietairesiege(DEFAULT_PROPRIETAIRESIEGE)
            .quartier(DEFAULT_QUARTIER)
            .numeroenregistrement(DEFAULT_NUMEROENREGISTREMENT)
            .serviceencharge(DEFAULT_SERVICEENCHARGE)
            .siege(DEFAULT_SIEGE)
            .sigle(DEFAULT_SIGLE)
            .telcomptable(DEFAULT_TELCOMPTABLE)
            .teldeux(DEFAULT_TELDEUX)
            .teldirigeant(DEFAULT_TELDIRIGEANT)
            .telsecondaire(DEFAULT_TELSECONDAIRE)
            .teltrois(DEFAULT_TELTROIS)
            .telun(DEFAULT_TELUN)
            .ville(DEFAULT_VILLE)
            .typedge(DEFAULT_TYPEDGE)
            .type(DEFAULT_TYPE)
            .utilisateurLogin(DEFAULT_UTILISATEUR_LOGIN)
            .fax(DEFAULT_FAX);
        return fournisseur;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Fournisseur createUpdatedEntity(EntityManager em) {
        Fournisseur fournisseur = new Fournisseur()
            .nom(UPDATED_NOM)
            .adresse(UPDATED_ADRESSE)
            .email(UPDATED_EMAIL)
            .telephone(UPDATED_TELEPHONE)
            .numeroRegistreCommerce(UPDATED_NUMERO_REGISTRE_COMMERCE)
            .piecejointe(UPDATED_PIECEJOINTE)
            .code(UPDATED_CODE)
            .activite(UPDATED_ACTIVITE)
            .adressecomptable(UPDATED_ADRESSECOMPTABLE)
            .adressedirigeant(UPDATED_ADRESSEDIRIGEANT)
            .autredenomination(UPDATED_AUTREDENOMINATION)
            .autreformejuridique(UPDATED_AUTREFORMEJURIDIQUE)
            .bpcomptable(UPDATED_BPCOMPTABLE)
            .bpdeux(UPDATED_BPDEUX)
            .bptrois(UPDATED_BPTROIS)
            .bpun(UPDATED_BPUN)
            .bpsecondaire(UPDATED_BPSECONDAIRE)
            .centreimpot(UPDATED_CENTREIMPOT)
            .comptable(UPDATED_COMPTABLE)
            .dirigeant(UPDATED_DIRIGEANT)
            .enseigne(UPDATED_ENSEIGNE)
            .etssecondaire(UPDATED_ETSSECONDAIRE)
            .insae(UPDATED_INSAE)
            .formejuridique(UPDATED_FORMEJURIDIQUE)
            .proprietairesiege(UPDATED_PROPRIETAIRESIEGE)
            .quartier(UPDATED_QUARTIER)
            .numeroenregistrement(UPDATED_NUMEROENREGISTREMENT)
            .serviceencharge(UPDATED_SERVICEENCHARGE)
            .siege(UPDATED_SIEGE)
            .sigle(UPDATED_SIGLE)
            .telcomptable(UPDATED_TELCOMPTABLE)
            .teldeux(UPDATED_TELDEUX)
            .teldirigeant(UPDATED_TELDIRIGEANT)
            .telsecondaire(UPDATED_TELSECONDAIRE)
            .teltrois(UPDATED_TELTROIS)
            .telun(UPDATED_TELUN)
            .ville(UPDATED_VILLE)
            .typedge(UPDATED_TYPEDGE)
            .type(UPDATED_TYPE)
            .utilisateurLogin(UPDATED_UTILISATEUR_LOGIN)
            .fax(UPDATED_FAX);
        return fournisseur;
    }

    @BeforeEach
    public void initTest() {
        fournisseur = createEntity(em);
    }

    @Test
    @Transactional
    public void createFournisseur() throws Exception {
        int databaseSizeBeforeCreate = fournisseurRepository.findAll().size();
        // Create the Fournisseur
        FournisseurDTO fournisseurDTO = fournisseurMapper.toDto(fournisseur);
        restFournisseurMockMvc.perform(post("/api/fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fournisseurDTO)))
            .andExpect(status().isCreated());

        // Validate the Fournisseur in the database
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        assertThat(fournisseurList).hasSize(databaseSizeBeforeCreate + 1);
        Fournisseur testFournisseur = fournisseurList.get(fournisseurList.size() - 1);
        assertThat(testFournisseur.getNom()).isEqualTo(DEFAULT_NOM);
        assertThat(testFournisseur.getAdresse()).isEqualTo(DEFAULT_ADRESSE);
        assertThat(testFournisseur.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testFournisseur.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testFournisseur.getNumeroRegistreCommerce()).isEqualTo(DEFAULT_NUMERO_REGISTRE_COMMERCE);
        assertThat(testFournisseur.getPiecejointe()).isEqualTo(DEFAULT_PIECEJOINTE);
        assertThat(testFournisseur.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testFournisseur.getActivite()).isEqualTo(DEFAULT_ACTIVITE);
        assertThat(testFournisseur.getAdressecomptable()).isEqualTo(DEFAULT_ADRESSECOMPTABLE);
        assertThat(testFournisseur.getAdressedirigeant()).isEqualTo(DEFAULT_ADRESSEDIRIGEANT);
        assertThat(testFournisseur.getAutredenomination()).isEqualTo(DEFAULT_AUTREDENOMINATION);
        assertThat(testFournisseur.getAutreformejuridique()).isEqualTo(DEFAULT_AUTREFORMEJURIDIQUE);
        assertThat(testFournisseur.getBpcomptable()).isEqualTo(DEFAULT_BPCOMPTABLE);
        assertThat(testFournisseur.getBpdeux()).isEqualTo(DEFAULT_BPDEUX);
        assertThat(testFournisseur.getBptrois()).isEqualTo(DEFAULT_BPTROIS);
        assertThat(testFournisseur.getBpun()).isEqualTo(DEFAULT_BPUN);
        assertThat(testFournisseur.getBpsecondaire()).isEqualTo(DEFAULT_BPSECONDAIRE);
        assertThat(testFournisseur.getCentreimpot()).isEqualTo(DEFAULT_CENTREIMPOT);
        assertThat(testFournisseur.getComptable()).isEqualTo(DEFAULT_COMPTABLE);
        assertThat(testFournisseur.getDirigeant()).isEqualTo(DEFAULT_DIRIGEANT);
        assertThat(testFournisseur.getEnseigne()).isEqualTo(DEFAULT_ENSEIGNE);
        assertThat(testFournisseur.getEtssecondaire()).isEqualTo(DEFAULT_ETSSECONDAIRE);
        assertThat(testFournisseur.getInsae()).isEqualTo(DEFAULT_INSAE);
        assertThat(testFournisseur.getFormejuridique()).isEqualTo(DEFAULT_FORMEJURIDIQUE);
        assertThat(testFournisseur.getProprietairesiege()).isEqualTo(DEFAULT_PROPRIETAIRESIEGE);
        assertThat(testFournisseur.getQuartier()).isEqualTo(DEFAULT_QUARTIER);
        assertThat(testFournisseur.getNumeroenregistrement()).isEqualTo(DEFAULT_NUMEROENREGISTREMENT);
        assertThat(testFournisseur.getServiceencharge()).isEqualTo(DEFAULT_SERVICEENCHARGE);
        assertThat(testFournisseur.getSiege()).isEqualTo(DEFAULT_SIEGE);
        assertThat(testFournisseur.getSigle()).isEqualTo(DEFAULT_SIGLE);
        assertThat(testFournisseur.getTelcomptable()).isEqualTo(DEFAULT_TELCOMPTABLE);
        assertThat(testFournisseur.getTeldeux()).isEqualTo(DEFAULT_TELDEUX);
        assertThat(testFournisseur.getTeldirigeant()).isEqualTo(DEFAULT_TELDIRIGEANT);
        assertThat(testFournisseur.getTelsecondaire()).isEqualTo(DEFAULT_TELSECONDAIRE);
        assertThat(testFournisseur.getTeltrois()).isEqualTo(DEFAULT_TELTROIS);
        assertThat(testFournisseur.getTelun()).isEqualTo(DEFAULT_TELUN);
        assertThat(testFournisseur.getVille()).isEqualTo(DEFAULT_VILLE);
        assertThat(testFournisseur.getTypedge()).isEqualTo(DEFAULT_TYPEDGE);
        assertThat(testFournisseur.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testFournisseur.getUtilisateurLogin()).isEqualTo(DEFAULT_UTILISATEUR_LOGIN);
        assertThat(testFournisseur.getFax()).isEqualTo(DEFAULT_FAX);
    }

    @Test
    @Transactional
    public void createFournisseurWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fournisseurRepository.findAll().size();

        // Create the Fournisseur with an existing ID
        fournisseur.setId(1L);
        FournisseurDTO fournisseurDTO = fournisseurMapper.toDto(fournisseur);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFournisseurMockMvc.perform(post("/api/fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fournisseurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Fournisseur in the database
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        assertThat(fournisseurList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFournisseurs() throws Exception {
        // Initialize the database
        fournisseurRepository.saveAndFlush(fournisseur);

        // Get all the fournisseurList
        restFournisseurMockMvc.perform(get("/api/fournisseurs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fournisseur.getId().intValue())))
            .andExpect(jsonPath("$.[*].nom").value(hasItem(DEFAULT_NOM)))
            .andExpect(jsonPath("$.[*].adresse").value(hasItem(DEFAULT_ADRESSE)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE)))
            .andExpect(jsonPath("$.[*].numeroRegistreCommerce").value(hasItem(DEFAULT_NUMERO_REGISTRE_COMMERCE)))
            .andExpect(jsonPath("$.[*].piecejointe").value(hasItem(DEFAULT_PIECEJOINTE)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].activite").value(hasItem(DEFAULT_ACTIVITE)))
            .andExpect(jsonPath("$.[*].adressecomptable").value(hasItem(DEFAULT_ADRESSECOMPTABLE)))
            .andExpect(jsonPath("$.[*].adressedirigeant").value(hasItem(DEFAULT_ADRESSEDIRIGEANT)))
            .andExpect(jsonPath("$.[*].autredenomination").value(hasItem(DEFAULT_AUTREDENOMINATION)))
            .andExpect(jsonPath("$.[*].autreformejuridique").value(hasItem(DEFAULT_AUTREFORMEJURIDIQUE)))
            .andExpect(jsonPath("$.[*].bpcomptable").value(hasItem(DEFAULT_BPCOMPTABLE)))
            .andExpect(jsonPath("$.[*].bpdeux").value(hasItem(DEFAULT_BPDEUX)))
            .andExpect(jsonPath("$.[*].bptrois").value(hasItem(DEFAULT_BPTROIS)))
            .andExpect(jsonPath("$.[*].bpun").value(hasItem(DEFAULT_BPUN)))
            .andExpect(jsonPath("$.[*].bpsecondaire").value(hasItem(DEFAULT_BPSECONDAIRE)))
            .andExpect(jsonPath("$.[*].centreimpot").value(hasItem(DEFAULT_CENTREIMPOT)))
            .andExpect(jsonPath("$.[*].comptable").value(hasItem(DEFAULT_COMPTABLE)))
            .andExpect(jsonPath("$.[*].dirigeant").value(hasItem(DEFAULT_DIRIGEANT)))
            .andExpect(jsonPath("$.[*].enseigne").value(hasItem(DEFAULT_ENSEIGNE)))
            .andExpect(jsonPath("$.[*].etssecondaire").value(hasItem(DEFAULT_ETSSECONDAIRE)))
            .andExpect(jsonPath("$.[*].insae").value(hasItem(DEFAULT_INSAE)))
            .andExpect(jsonPath("$.[*].formejuridique").value(hasItem(DEFAULT_FORMEJURIDIQUE)))
            .andExpect(jsonPath("$.[*].proprietairesiege").value(hasItem(DEFAULT_PROPRIETAIRESIEGE)))
            .andExpect(jsonPath("$.[*].quartier").value(hasItem(DEFAULT_QUARTIER)))
            .andExpect(jsonPath("$.[*].numeroenregistrement").value(hasItem(DEFAULT_NUMEROENREGISTREMENT)))
            .andExpect(jsonPath("$.[*].serviceencharge").value(hasItem(DEFAULT_SERVICEENCHARGE)))
            .andExpect(jsonPath("$.[*].siege").value(hasItem(DEFAULT_SIEGE)))
            .andExpect(jsonPath("$.[*].sigle").value(hasItem(DEFAULT_SIGLE)))
            .andExpect(jsonPath("$.[*].telcomptable").value(hasItem(DEFAULT_TELCOMPTABLE)))
            .andExpect(jsonPath("$.[*].teldeux").value(hasItem(DEFAULT_TELDEUX)))
            .andExpect(jsonPath("$.[*].teldirigeant").value(hasItem(DEFAULT_TELDIRIGEANT)))
            .andExpect(jsonPath("$.[*].telsecondaire").value(hasItem(DEFAULT_TELSECONDAIRE)))
            .andExpect(jsonPath("$.[*].teltrois").value(hasItem(DEFAULT_TELTROIS)))
            .andExpect(jsonPath("$.[*].telun").value(hasItem(DEFAULT_TELUN)))
            .andExpect(jsonPath("$.[*].ville").value(hasItem(DEFAULT_VILLE)))
            .andExpect(jsonPath("$.[*].typedge").value(hasItem(DEFAULT_TYPEDGE)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].utilisateurLogin").value(hasItem(DEFAULT_UTILISATEUR_LOGIN)))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX)));
    }
    
    @Test
    @Transactional
    public void getFournisseur() throws Exception {
        // Initialize the database
        fournisseurRepository.saveAndFlush(fournisseur);

        // Get the fournisseur
        restFournisseurMockMvc.perform(get("/api/fournisseurs/{id}", fournisseur.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fournisseur.getId().intValue()))
            .andExpect(jsonPath("$.nom").value(DEFAULT_NOM))
            .andExpect(jsonPath("$.adresse").value(DEFAULT_ADRESSE))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE))
            .andExpect(jsonPath("$.numeroRegistreCommerce").value(DEFAULT_NUMERO_REGISTRE_COMMERCE))
            .andExpect(jsonPath("$.piecejointe").value(DEFAULT_PIECEJOINTE))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.activite").value(DEFAULT_ACTIVITE))
            .andExpect(jsonPath("$.adressecomptable").value(DEFAULT_ADRESSECOMPTABLE))
            .andExpect(jsonPath("$.adressedirigeant").value(DEFAULT_ADRESSEDIRIGEANT))
            .andExpect(jsonPath("$.autredenomination").value(DEFAULT_AUTREDENOMINATION))
            .andExpect(jsonPath("$.autreformejuridique").value(DEFAULT_AUTREFORMEJURIDIQUE))
            .andExpect(jsonPath("$.bpcomptable").value(DEFAULT_BPCOMPTABLE))
            .andExpect(jsonPath("$.bpdeux").value(DEFAULT_BPDEUX))
            .andExpect(jsonPath("$.bptrois").value(DEFAULT_BPTROIS))
            .andExpect(jsonPath("$.bpun").value(DEFAULT_BPUN))
            .andExpect(jsonPath("$.bpsecondaire").value(DEFAULT_BPSECONDAIRE))
            .andExpect(jsonPath("$.centreimpot").value(DEFAULT_CENTREIMPOT))
            .andExpect(jsonPath("$.comptable").value(DEFAULT_COMPTABLE))
            .andExpect(jsonPath("$.dirigeant").value(DEFAULT_DIRIGEANT))
            .andExpect(jsonPath("$.enseigne").value(DEFAULT_ENSEIGNE))
            .andExpect(jsonPath("$.etssecondaire").value(DEFAULT_ETSSECONDAIRE))
            .andExpect(jsonPath("$.insae").value(DEFAULT_INSAE))
            .andExpect(jsonPath("$.formejuridique").value(DEFAULT_FORMEJURIDIQUE))
            .andExpect(jsonPath("$.proprietairesiege").value(DEFAULT_PROPRIETAIRESIEGE))
            .andExpect(jsonPath("$.quartier").value(DEFAULT_QUARTIER))
            .andExpect(jsonPath("$.numeroenregistrement").value(DEFAULT_NUMEROENREGISTREMENT))
            .andExpect(jsonPath("$.serviceencharge").value(DEFAULT_SERVICEENCHARGE))
            .andExpect(jsonPath("$.siege").value(DEFAULT_SIEGE))
            .andExpect(jsonPath("$.sigle").value(DEFAULT_SIGLE))
            .andExpect(jsonPath("$.telcomptable").value(DEFAULT_TELCOMPTABLE))
            .andExpect(jsonPath("$.teldeux").value(DEFAULT_TELDEUX))
            .andExpect(jsonPath("$.teldirigeant").value(DEFAULT_TELDIRIGEANT))
            .andExpect(jsonPath("$.telsecondaire").value(DEFAULT_TELSECONDAIRE))
            .andExpect(jsonPath("$.teltrois").value(DEFAULT_TELTROIS))
            .andExpect(jsonPath("$.telun").value(DEFAULT_TELUN))
            .andExpect(jsonPath("$.ville").value(DEFAULT_VILLE))
            .andExpect(jsonPath("$.typedge").value(DEFAULT_TYPEDGE))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.utilisateurLogin").value(DEFAULT_UTILISATEUR_LOGIN))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX));
    }
    @Test
    @Transactional
    public void getNonExistingFournisseur() throws Exception {
        // Get the fournisseur
        restFournisseurMockMvc.perform(get("/api/fournisseurs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFournisseur() throws Exception {
        // Initialize the database
        fournisseurRepository.saveAndFlush(fournisseur);

        int databaseSizeBeforeUpdate = fournisseurRepository.findAll().size();

        // Update the fournisseur
        Fournisseur updatedFournisseur = fournisseurRepository.findById(fournisseur.getId()).get();
        // Disconnect from session so that the updates on updatedFournisseur are not directly saved in db
        em.detach(updatedFournisseur);
        updatedFournisseur
            .nom(UPDATED_NOM)
            .adresse(UPDATED_ADRESSE)
            .email(UPDATED_EMAIL)
            .telephone(UPDATED_TELEPHONE)
            .numeroRegistreCommerce(UPDATED_NUMERO_REGISTRE_COMMERCE)
            .piecejointe(UPDATED_PIECEJOINTE)
            .code(UPDATED_CODE)
            .activite(UPDATED_ACTIVITE)
            .adressecomptable(UPDATED_ADRESSECOMPTABLE)
            .adressedirigeant(UPDATED_ADRESSEDIRIGEANT)
            .autredenomination(UPDATED_AUTREDENOMINATION)
            .autreformejuridique(UPDATED_AUTREFORMEJURIDIQUE)
            .bpcomptable(UPDATED_BPCOMPTABLE)
            .bpdeux(UPDATED_BPDEUX)
            .bptrois(UPDATED_BPTROIS)
            .bpun(UPDATED_BPUN)
            .bpsecondaire(UPDATED_BPSECONDAIRE)
            .centreimpot(UPDATED_CENTREIMPOT)
            .comptable(UPDATED_COMPTABLE)
            .dirigeant(UPDATED_DIRIGEANT)
            .enseigne(UPDATED_ENSEIGNE)
            .etssecondaire(UPDATED_ETSSECONDAIRE)
            .insae(UPDATED_INSAE)
            .formejuridique(UPDATED_FORMEJURIDIQUE)
            .proprietairesiege(UPDATED_PROPRIETAIRESIEGE)
            .quartier(UPDATED_QUARTIER)
            .numeroenregistrement(UPDATED_NUMEROENREGISTREMENT)
            .serviceencharge(UPDATED_SERVICEENCHARGE)
            .siege(UPDATED_SIEGE)
            .sigle(UPDATED_SIGLE)
            .telcomptable(UPDATED_TELCOMPTABLE)
            .teldeux(UPDATED_TELDEUX)
            .teldirigeant(UPDATED_TELDIRIGEANT)
            .telsecondaire(UPDATED_TELSECONDAIRE)
            .teltrois(UPDATED_TELTROIS)
            .telun(UPDATED_TELUN)
            .ville(UPDATED_VILLE)
            .typedge(UPDATED_TYPEDGE)
            .type(UPDATED_TYPE)
            .utilisateurLogin(UPDATED_UTILISATEUR_LOGIN)
            .fax(UPDATED_FAX);
        FournisseurDTO fournisseurDTO = fournisseurMapper.toDto(updatedFournisseur);

        restFournisseurMockMvc.perform(put("/api/fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fournisseurDTO)))
            .andExpect(status().isOk());

        // Validate the Fournisseur in the database
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        assertThat(fournisseurList).hasSize(databaseSizeBeforeUpdate);
        Fournisseur testFournisseur = fournisseurList.get(fournisseurList.size() - 1);
        assertThat(testFournisseur.getNom()).isEqualTo(UPDATED_NOM);
        assertThat(testFournisseur.getAdresse()).isEqualTo(UPDATED_ADRESSE);
        assertThat(testFournisseur.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testFournisseur.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testFournisseur.getNumeroRegistreCommerce()).isEqualTo(UPDATED_NUMERO_REGISTRE_COMMERCE);
        assertThat(testFournisseur.getPiecejointe()).isEqualTo(UPDATED_PIECEJOINTE);
        assertThat(testFournisseur.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testFournisseur.getActivite()).isEqualTo(UPDATED_ACTIVITE);
        assertThat(testFournisseur.getAdressecomptable()).isEqualTo(UPDATED_ADRESSECOMPTABLE);
        assertThat(testFournisseur.getAdressedirigeant()).isEqualTo(UPDATED_ADRESSEDIRIGEANT);
        assertThat(testFournisseur.getAutredenomination()).isEqualTo(UPDATED_AUTREDENOMINATION);
        assertThat(testFournisseur.getAutreformejuridique()).isEqualTo(UPDATED_AUTREFORMEJURIDIQUE);
        assertThat(testFournisseur.getBpcomptable()).isEqualTo(UPDATED_BPCOMPTABLE);
        assertThat(testFournisseur.getBpdeux()).isEqualTo(UPDATED_BPDEUX);
        assertThat(testFournisseur.getBptrois()).isEqualTo(UPDATED_BPTROIS);
        assertThat(testFournisseur.getBpun()).isEqualTo(UPDATED_BPUN);
        assertThat(testFournisseur.getBpsecondaire()).isEqualTo(UPDATED_BPSECONDAIRE);
        assertThat(testFournisseur.getCentreimpot()).isEqualTo(UPDATED_CENTREIMPOT);
        assertThat(testFournisseur.getComptable()).isEqualTo(UPDATED_COMPTABLE);
        assertThat(testFournisseur.getDirigeant()).isEqualTo(UPDATED_DIRIGEANT);
        assertThat(testFournisseur.getEnseigne()).isEqualTo(UPDATED_ENSEIGNE);
        assertThat(testFournisseur.getEtssecondaire()).isEqualTo(UPDATED_ETSSECONDAIRE);
        assertThat(testFournisseur.getInsae()).isEqualTo(UPDATED_INSAE);
        assertThat(testFournisseur.getFormejuridique()).isEqualTo(UPDATED_FORMEJURIDIQUE);
        assertThat(testFournisseur.getProprietairesiege()).isEqualTo(UPDATED_PROPRIETAIRESIEGE);
        assertThat(testFournisseur.getQuartier()).isEqualTo(UPDATED_QUARTIER);
        assertThat(testFournisseur.getNumeroenregistrement()).isEqualTo(UPDATED_NUMEROENREGISTREMENT);
        assertThat(testFournisseur.getServiceencharge()).isEqualTo(UPDATED_SERVICEENCHARGE);
        assertThat(testFournisseur.getSiege()).isEqualTo(UPDATED_SIEGE);
        assertThat(testFournisseur.getSigle()).isEqualTo(UPDATED_SIGLE);
        assertThat(testFournisseur.getTelcomptable()).isEqualTo(UPDATED_TELCOMPTABLE);
        assertThat(testFournisseur.getTeldeux()).isEqualTo(UPDATED_TELDEUX);
        assertThat(testFournisseur.getTeldirigeant()).isEqualTo(UPDATED_TELDIRIGEANT);
        assertThat(testFournisseur.getTelsecondaire()).isEqualTo(UPDATED_TELSECONDAIRE);
        assertThat(testFournisseur.getTeltrois()).isEqualTo(UPDATED_TELTROIS);
        assertThat(testFournisseur.getTelun()).isEqualTo(UPDATED_TELUN);
        assertThat(testFournisseur.getVille()).isEqualTo(UPDATED_VILLE);
        assertThat(testFournisseur.getTypedge()).isEqualTo(UPDATED_TYPEDGE);
        assertThat(testFournisseur.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testFournisseur.getUtilisateurLogin()).isEqualTo(UPDATED_UTILISATEUR_LOGIN);
        assertThat(testFournisseur.getFax()).isEqualTo(UPDATED_FAX);
    }

    @Test
    @Transactional
    public void updateNonExistingFournisseur() throws Exception {
        int databaseSizeBeforeUpdate = fournisseurRepository.findAll().size();

        // Create the Fournisseur
        FournisseurDTO fournisseurDTO = fournisseurMapper.toDto(fournisseur);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFournisseurMockMvc.perform(put("/api/fournisseurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fournisseurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Fournisseur in the database
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        assertThat(fournisseurList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFournisseur() throws Exception {
        // Initialize the database
        fournisseurRepository.saveAndFlush(fournisseur);

        int databaseSizeBeforeDelete = fournisseurRepository.findAll().size();

        // Delete the fournisseur
        restFournisseurMockMvc.perform(delete("/api/fournisseurs/{id}", fournisseur.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Fournisseur> fournisseurList = fournisseurRepository.findAll();
        assertThat(fournisseurList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
