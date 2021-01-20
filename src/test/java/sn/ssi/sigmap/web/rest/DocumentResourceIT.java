package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Document;
import sn.ssi.sigmap.repository.DocumentRepository;
import sn.ssi.sigmap.service.DocumentService;
import sn.ssi.sigmap.service.dto.DocumentDTO;
import sn.ssi.sigmap.service.mapper.DocumentMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link DocumentResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class DocumentResourceIT {

    private static final String DEFAULT_TYPE_DOCUMENT = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_DOCUMENT = "BBBBBBBBBB";

    private static final String DEFAULT_TEXT_PV_OUVERTURE = "AAAAAAAAAA";
    private static final String UPDATED_TEXT_PV_OUVERTURE = "BBBBBBBBBB";

    private static final String DEFAULT_NOM_FICHIER = "AAAAAAAAAA";
    private static final String UPDATED_NOM_FICHIER = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_OBJET = "AAAAAAAAAA";
    private static final String UPDATED_OBJET = "BBBBBBBBBB";

    private static final String DEFAULT_ORIGINE = "AAAAAAAAAA";
    private static final String UPDATED_ORIGINE = "BBBBBBBBBB";

    private static final String DEFAULT_LIEU_ACQUISITION_DAO = "AAAAAAAAAA";
    private static final String UPDATED_LIEU_ACQUISITION_DAO = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_DEMANDE_PUBLICATION = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_DEMANDE_PUBLICATION = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_DC = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_DC = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_AR = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_AR = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEURE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_DEMANDE_PUBLICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEMANDE_PUBLICATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_LIMITE_DEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_LIMITE_DEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEURE_LIMITE_DEPOT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEURE_LIMITE_DEPOT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_OUVERTUE_DESPLIS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_OUVERTUE_DESPLIS = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_HEURE_OUVERTURE_DES_PLIS = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_HEURE_OUVERTURE_DES_PLIS = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDocumentMockMvc;

    private Document document;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Document createEntity(EntityManager em) {
        Document document = new Document()
            .typeDocument(DEFAULT_TYPE_DOCUMENT)
            .textPVOuverture(DEFAULT_TEXT_PV_OUVERTURE)
            .nomFichier(DEFAULT_NOM_FICHIER)
            .libelle(DEFAULT_LIBELLE)
            .reference(DEFAULT_REFERENCE)
            .objet(DEFAULT_OBJET)
            .origine(DEFAULT_ORIGINE)
            .lieuAcquisitionDAO(DEFAULT_LIEU_ACQUISITION_DAO)
            .fichierDemandePublication(DEFAULT_FICHIER_DEMANDE_PUBLICATION)
            .fichierDC(DEFAULT_FICHIER_DC)
            .fichierAR(DEFAULT_FICHIER_AR)
            .date(DEFAULT_DATE)
            .heure(DEFAULT_HEURE)
            .dateDemandePublication(DEFAULT_DATE_DEMANDE_PUBLICATION)
            .dateLimiteDepot(DEFAULT_DATE_LIMITE_DEPOT)
            .heureLimiteDepot(DEFAULT_HEURE_LIMITE_DEPOT)
            .dateOuvertueDesplis(DEFAULT_DATE_OUVERTUE_DESPLIS)
            .heureOuvertureDesPlis(DEFAULT_HEURE_OUVERTURE_DES_PLIS)
            .autoriteId(DEFAULT_AUTORITE_ID);
        return document;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Document createUpdatedEntity(EntityManager em) {
        Document document = new Document()
            .typeDocument(UPDATED_TYPE_DOCUMENT)
            .textPVOuverture(UPDATED_TEXT_PV_OUVERTURE)
            .nomFichier(UPDATED_NOM_FICHIER)
            .libelle(UPDATED_LIBELLE)
            .reference(UPDATED_REFERENCE)
            .objet(UPDATED_OBJET)
            .origine(UPDATED_ORIGINE)
            .lieuAcquisitionDAO(UPDATED_LIEU_ACQUISITION_DAO)
            .fichierDemandePublication(UPDATED_FICHIER_DEMANDE_PUBLICATION)
            .fichierDC(UPDATED_FICHIER_DC)
            .fichierAR(UPDATED_FICHIER_AR)
            .date(UPDATED_DATE)
            .heure(UPDATED_HEURE)
            .dateDemandePublication(UPDATED_DATE_DEMANDE_PUBLICATION)
            .dateLimiteDepot(UPDATED_DATE_LIMITE_DEPOT)
            .heureLimiteDepot(UPDATED_HEURE_LIMITE_DEPOT)
            .dateOuvertueDesplis(UPDATED_DATE_OUVERTUE_DESPLIS)
            .heureOuvertureDesPlis(UPDATED_HEURE_OUVERTURE_DES_PLIS)
            .autoriteId(UPDATED_AUTORITE_ID);
        return document;
    }

    @BeforeEach
    public void initTest() {
        document = createEntity(em);
    }

    @Test
    @Transactional
    public void createDocument() throws Exception {
        int databaseSizeBeforeCreate = documentRepository.findAll().size();
        // Create the Document
        DocumentDTO documentDTO = documentMapper.toDto(document);
        restDocumentMockMvc.perform(post("/api/documents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(documentDTO)))
            .andExpect(status().isCreated());

        // Validate the Document in the database
        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeCreate + 1);
        Document testDocument = documentList.get(documentList.size() - 1);
        assertThat(testDocument.getTypeDocument()).isEqualTo(DEFAULT_TYPE_DOCUMENT);
        assertThat(testDocument.getTextPVOuverture()).isEqualTo(DEFAULT_TEXT_PV_OUVERTURE);
        assertThat(testDocument.getNomFichier()).isEqualTo(DEFAULT_NOM_FICHIER);
        assertThat(testDocument.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testDocument.getReference()).isEqualTo(DEFAULT_REFERENCE);
        assertThat(testDocument.getObjet()).isEqualTo(DEFAULT_OBJET);
        assertThat(testDocument.getOrigine()).isEqualTo(DEFAULT_ORIGINE);
        assertThat(testDocument.getLieuAcquisitionDAO()).isEqualTo(DEFAULT_LIEU_ACQUISITION_DAO);
        assertThat(testDocument.getFichierDemandePublication()).isEqualTo(DEFAULT_FICHIER_DEMANDE_PUBLICATION);
        assertThat(testDocument.getFichierDC()).isEqualTo(DEFAULT_FICHIER_DC);
        assertThat(testDocument.getFichierAR()).isEqualTo(DEFAULT_FICHIER_AR);
        assertThat(testDocument.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testDocument.getHeure()).isEqualTo(DEFAULT_HEURE);
        assertThat(testDocument.getDateDemandePublication()).isEqualTo(DEFAULT_DATE_DEMANDE_PUBLICATION);
        assertThat(testDocument.getDateLimiteDepot()).isEqualTo(DEFAULT_DATE_LIMITE_DEPOT);
        assertThat(testDocument.getHeureLimiteDepot()).isEqualTo(DEFAULT_HEURE_LIMITE_DEPOT);
        assertThat(testDocument.getDateOuvertueDesplis()).isEqualTo(DEFAULT_DATE_OUVERTUE_DESPLIS);
        assertThat(testDocument.getHeureOuvertureDesPlis()).isEqualTo(DEFAULT_HEURE_OUVERTURE_DES_PLIS);
        assertThat(testDocument.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void createDocumentWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = documentRepository.findAll().size();

        // Create the Document with an existing ID
        document.setId(1L);
        DocumentDTO documentDTO = documentMapper.toDto(document);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDocumentMockMvc.perform(post("/api/documents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(documentDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Document in the database
        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkAutoriteIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = documentRepository.findAll().size();
        // set the field null
        document.setAutoriteId(null);

        // Create the Document, which fails.
        DocumentDTO documentDTO = documentMapper.toDto(document);


        restDocumentMockMvc.perform(post("/api/documents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(documentDTO)))
            .andExpect(status().isBadRequest());

        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDocuments() throws Exception {
        // Initialize the database
        documentRepository.saveAndFlush(document);

        // Get all the documentList
        restDocumentMockMvc.perform(get("/api/documents?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(document.getId().intValue())))
            .andExpect(jsonPath("$.[*].typeDocument").value(hasItem(DEFAULT_TYPE_DOCUMENT)))
            .andExpect(jsonPath("$.[*].textPVOuverture").value(hasItem(DEFAULT_TEXT_PV_OUVERTURE)))
            .andExpect(jsonPath("$.[*].nomFichier").value(hasItem(DEFAULT_NOM_FICHIER)))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].reference").value(hasItem(DEFAULT_REFERENCE)))
            .andExpect(jsonPath("$.[*].objet").value(hasItem(DEFAULT_OBJET)))
            .andExpect(jsonPath("$.[*].origine").value(hasItem(DEFAULT_ORIGINE)))
            .andExpect(jsonPath("$.[*].lieuAcquisitionDAO").value(hasItem(DEFAULT_LIEU_ACQUISITION_DAO)))
            .andExpect(jsonPath("$.[*].fichierDemandePublication").value(hasItem(DEFAULT_FICHIER_DEMANDE_PUBLICATION)))
            .andExpect(jsonPath("$.[*].fichierDC").value(hasItem(DEFAULT_FICHIER_DC)))
            .andExpect(jsonPath("$.[*].fichierAR").value(hasItem(DEFAULT_FICHIER_AR)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].heure").value(hasItem(DEFAULT_HEURE.toString())))
            .andExpect(jsonPath("$.[*].dateDemandePublication").value(hasItem(DEFAULT_DATE_DEMANDE_PUBLICATION.toString())))
            .andExpect(jsonPath("$.[*].dateLimiteDepot").value(hasItem(DEFAULT_DATE_LIMITE_DEPOT.toString())))
            .andExpect(jsonPath("$.[*].heureLimiteDepot").value(hasItem(DEFAULT_HEURE_LIMITE_DEPOT.toString())))
            .andExpect(jsonPath("$.[*].dateOuvertueDesplis").value(hasItem(DEFAULT_DATE_OUVERTUE_DESPLIS.toString())))
            .andExpect(jsonPath("$.[*].heureOuvertureDesPlis").value(hasItem(DEFAULT_HEURE_OUVERTURE_DES_PLIS.toString())))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getDocument() throws Exception {
        // Initialize the database
        documentRepository.saveAndFlush(document);

        // Get the document
        restDocumentMockMvc.perform(get("/api/documents/{id}", document.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(document.getId().intValue()))
            .andExpect(jsonPath("$.typeDocument").value(DEFAULT_TYPE_DOCUMENT))
            .andExpect(jsonPath("$.textPVOuverture").value(DEFAULT_TEXT_PV_OUVERTURE))
            .andExpect(jsonPath("$.nomFichier").value(DEFAULT_NOM_FICHIER))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.reference").value(DEFAULT_REFERENCE))
            .andExpect(jsonPath("$.objet").value(DEFAULT_OBJET))
            .andExpect(jsonPath("$.origine").value(DEFAULT_ORIGINE))
            .andExpect(jsonPath("$.lieuAcquisitionDAO").value(DEFAULT_LIEU_ACQUISITION_DAO))
            .andExpect(jsonPath("$.fichierDemandePublication").value(DEFAULT_FICHIER_DEMANDE_PUBLICATION))
            .andExpect(jsonPath("$.fichierDC").value(DEFAULT_FICHIER_DC))
            .andExpect(jsonPath("$.fichierAR").value(DEFAULT_FICHIER_AR))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.heure").value(DEFAULT_HEURE.toString()))
            .andExpect(jsonPath("$.dateDemandePublication").value(DEFAULT_DATE_DEMANDE_PUBLICATION.toString()))
            .andExpect(jsonPath("$.dateLimiteDepot").value(DEFAULT_DATE_LIMITE_DEPOT.toString()))
            .andExpect(jsonPath("$.heureLimiteDepot").value(DEFAULT_HEURE_LIMITE_DEPOT.toString()))
            .andExpect(jsonPath("$.dateOuvertueDesplis").value(DEFAULT_DATE_OUVERTUE_DESPLIS.toString()))
            .andExpect(jsonPath("$.heureOuvertureDesPlis").value(DEFAULT_HEURE_OUVERTURE_DES_PLIS.toString()))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingDocument() throws Exception {
        // Get the document
        restDocumentMockMvc.perform(get("/api/documents/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDocument() throws Exception {
        // Initialize the database
        documentRepository.saveAndFlush(document);

        int databaseSizeBeforeUpdate = documentRepository.findAll().size();

        // Update the document
        Document updatedDocument = documentRepository.findById(document.getId()).get();
        // Disconnect from session so that the updates on updatedDocument are not directly saved in db
        em.detach(updatedDocument);
        updatedDocument
            .typeDocument(UPDATED_TYPE_DOCUMENT)
            .textPVOuverture(UPDATED_TEXT_PV_OUVERTURE)
            .nomFichier(UPDATED_NOM_FICHIER)
            .libelle(UPDATED_LIBELLE)
            .reference(UPDATED_REFERENCE)
            .objet(UPDATED_OBJET)
            .origine(UPDATED_ORIGINE)
            .lieuAcquisitionDAO(UPDATED_LIEU_ACQUISITION_DAO)
            .fichierDemandePublication(UPDATED_FICHIER_DEMANDE_PUBLICATION)
            .fichierDC(UPDATED_FICHIER_DC)
            .fichierAR(UPDATED_FICHIER_AR)
            .date(UPDATED_DATE)
            .heure(UPDATED_HEURE)
            .dateDemandePublication(UPDATED_DATE_DEMANDE_PUBLICATION)
            .dateLimiteDepot(UPDATED_DATE_LIMITE_DEPOT)
            .heureLimiteDepot(UPDATED_HEURE_LIMITE_DEPOT)
            .dateOuvertueDesplis(UPDATED_DATE_OUVERTUE_DESPLIS)
            .heureOuvertureDesPlis(UPDATED_HEURE_OUVERTURE_DES_PLIS)
            .autoriteId(UPDATED_AUTORITE_ID);
        DocumentDTO documentDTO = documentMapper.toDto(updatedDocument);

        restDocumentMockMvc.perform(put("/api/documents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(documentDTO)))
            .andExpect(status().isOk());

        // Validate the Document in the database
        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeUpdate);
        Document testDocument = documentList.get(documentList.size() - 1);
        assertThat(testDocument.getTypeDocument()).isEqualTo(UPDATED_TYPE_DOCUMENT);
        assertThat(testDocument.getTextPVOuverture()).isEqualTo(UPDATED_TEXT_PV_OUVERTURE);
        assertThat(testDocument.getNomFichier()).isEqualTo(UPDATED_NOM_FICHIER);
        assertThat(testDocument.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testDocument.getReference()).isEqualTo(UPDATED_REFERENCE);
        assertThat(testDocument.getObjet()).isEqualTo(UPDATED_OBJET);
        assertThat(testDocument.getOrigine()).isEqualTo(UPDATED_ORIGINE);
        assertThat(testDocument.getLieuAcquisitionDAO()).isEqualTo(UPDATED_LIEU_ACQUISITION_DAO);
        assertThat(testDocument.getFichierDemandePublication()).isEqualTo(UPDATED_FICHIER_DEMANDE_PUBLICATION);
        assertThat(testDocument.getFichierDC()).isEqualTo(UPDATED_FICHIER_DC);
        assertThat(testDocument.getFichierAR()).isEqualTo(UPDATED_FICHIER_AR);
        assertThat(testDocument.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testDocument.getHeure()).isEqualTo(UPDATED_HEURE);
        assertThat(testDocument.getDateDemandePublication()).isEqualTo(UPDATED_DATE_DEMANDE_PUBLICATION);
        assertThat(testDocument.getDateLimiteDepot()).isEqualTo(UPDATED_DATE_LIMITE_DEPOT);
        assertThat(testDocument.getHeureLimiteDepot()).isEqualTo(UPDATED_HEURE_LIMITE_DEPOT);
        assertThat(testDocument.getDateOuvertueDesplis()).isEqualTo(UPDATED_DATE_OUVERTUE_DESPLIS);
        assertThat(testDocument.getHeureOuvertureDesPlis()).isEqualTo(UPDATED_HEURE_OUVERTURE_DES_PLIS);
        assertThat(testDocument.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingDocument() throws Exception {
        int databaseSizeBeforeUpdate = documentRepository.findAll().size();

        // Create the Document
        DocumentDTO documentDTO = documentMapper.toDto(document);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDocumentMockMvc.perform(put("/api/documents")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(documentDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Document in the database
        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDocument() throws Exception {
        // Initialize the database
        documentRepository.saveAndFlush(document);

        int databaseSizeBeforeDelete = documentRepository.findAll().size();

        // Delete the document
        restDocumentMockMvc.perform(delete("/api/documents/{id}", document.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Document> documentList = documentRepository.findAll();
        assertThat(documentList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
