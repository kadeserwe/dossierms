package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Piece;
import sn.ssi.sigmap.repository.PieceRepository;
import sn.ssi.sigmap.service.PieceService;
import sn.ssi.sigmap.service.dto.PieceDTO;
import sn.ssi.sigmap.service.mapper.PieceMapper;

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
 * Integration tests for the {@link PieceResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class PieceResourceIT {

    private static final String DEFAULT_LIBELLE = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_CODEPIECE = "AAAAAAAAAA";
    private static final String UPDATED_CODEPIECE = "BBBBBBBBBB";

    private static final String DEFAULT_LOCALISATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCALISATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_TYPE = 1;
    private static final Integer UPDATED_TYPE = 2;

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    @Autowired
    private PieceRepository pieceRepository;

    @Autowired
    private PieceMapper pieceMapper;

    @Autowired
    private PieceService pieceService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPieceMockMvc;

    private Piece piece;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Piece createEntity(EntityManager em) {
        Piece piece = new Piece()
            .libelle(DEFAULT_LIBELLE)
            .description(DEFAULT_DESCRIPTION)
            .codepiece(DEFAULT_CODEPIECE)
            .localisation(DEFAULT_LOCALISATION)
            .type(DEFAULT_TYPE)
            .autoriteId(DEFAULT_AUTORITE_ID);
        return piece;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Piece createUpdatedEntity(EntityManager em) {
        Piece piece = new Piece()
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION)
            .codepiece(UPDATED_CODEPIECE)
            .localisation(UPDATED_LOCALISATION)
            .type(UPDATED_TYPE)
            .autoriteId(UPDATED_AUTORITE_ID);
        return piece;
    }

    @BeforeEach
    public void initTest() {
        piece = createEntity(em);
    }

    @Test
    @Transactional
    public void createPiece() throws Exception {
        int databaseSizeBeforeCreate = pieceRepository.findAll().size();
        // Create the Piece
        PieceDTO pieceDTO = pieceMapper.toDto(piece);
        restPieceMockMvc.perform(post("/api/pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pieceDTO)))
            .andExpect(status().isCreated());

        // Validate the Piece in the database
        List<Piece> pieceList = pieceRepository.findAll();
        assertThat(pieceList).hasSize(databaseSizeBeforeCreate + 1);
        Piece testPiece = pieceList.get(pieceList.size() - 1);
        assertThat(testPiece.getLibelle()).isEqualTo(DEFAULT_LIBELLE);
        assertThat(testPiece.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testPiece.getCodepiece()).isEqualTo(DEFAULT_CODEPIECE);
        assertThat(testPiece.getLocalisation()).isEqualTo(DEFAULT_LOCALISATION);
        assertThat(testPiece.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testPiece.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void createPieceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = pieceRepository.findAll().size();

        // Create the Piece with an existing ID
        piece.setId(1L);
        PieceDTO pieceDTO = pieceMapper.toDto(piece);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPieceMockMvc.perform(post("/api/pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pieceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Piece in the database
        List<Piece> pieceList = pieceRepository.findAll();
        assertThat(pieceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllPieces() throws Exception {
        // Initialize the database
        pieceRepository.saveAndFlush(piece);

        // Get all the pieceList
        restPieceMockMvc.perform(get("/api/pieces?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(piece.getId().intValue())))
            .andExpect(jsonPath("$.[*].libelle").value(hasItem(DEFAULT_LIBELLE)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].codepiece").value(hasItem(DEFAULT_CODEPIECE)))
            .andExpect(jsonPath("$.[*].localisation").value(hasItem(DEFAULT_LOCALISATION)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getPiece() throws Exception {
        // Initialize the database
        pieceRepository.saveAndFlush(piece);

        // Get the piece
        restPieceMockMvc.perform(get("/api/pieces/{id}", piece.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(piece.getId().intValue()))
            .andExpect(jsonPath("$.libelle").value(DEFAULT_LIBELLE))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.codepiece").value(DEFAULT_CODEPIECE))
            .andExpect(jsonPath("$.localisation").value(DEFAULT_LOCALISATION))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingPiece() throws Exception {
        // Get the piece
        restPieceMockMvc.perform(get("/api/pieces/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePiece() throws Exception {
        // Initialize the database
        pieceRepository.saveAndFlush(piece);

        int databaseSizeBeforeUpdate = pieceRepository.findAll().size();

        // Update the piece
        Piece updatedPiece = pieceRepository.findById(piece.getId()).get();
        // Disconnect from session so that the updates on updatedPiece are not directly saved in db
        em.detach(updatedPiece);
        updatedPiece
            .libelle(UPDATED_LIBELLE)
            .description(UPDATED_DESCRIPTION)
            .codepiece(UPDATED_CODEPIECE)
            .localisation(UPDATED_LOCALISATION)
            .type(UPDATED_TYPE)
            .autoriteId(UPDATED_AUTORITE_ID);
        PieceDTO pieceDTO = pieceMapper.toDto(updatedPiece);

        restPieceMockMvc.perform(put("/api/pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pieceDTO)))
            .andExpect(status().isOk());

        // Validate the Piece in the database
        List<Piece> pieceList = pieceRepository.findAll();
        assertThat(pieceList).hasSize(databaseSizeBeforeUpdate);
        Piece testPiece = pieceList.get(pieceList.size() - 1);
        assertThat(testPiece.getLibelle()).isEqualTo(UPDATED_LIBELLE);
        assertThat(testPiece.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testPiece.getCodepiece()).isEqualTo(UPDATED_CODEPIECE);
        assertThat(testPiece.getLocalisation()).isEqualTo(UPDATED_LOCALISATION);
        assertThat(testPiece.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testPiece.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingPiece() throws Exception {
        int databaseSizeBeforeUpdate = pieceRepository.findAll().size();

        // Create the Piece
        PieceDTO pieceDTO = pieceMapper.toDto(piece);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPieceMockMvc.perform(put("/api/pieces")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(pieceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Piece in the database
        List<Piece> pieceList = pieceRepository.findAll();
        assertThat(pieceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePiece() throws Exception {
        // Initialize the database
        pieceRepository.saveAndFlush(piece);

        int databaseSizeBeforeDelete = pieceRepository.findAll().size();

        // Delete the piece
        restPieceMockMvc.perform(delete("/api/pieces/{id}", piece.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Piece> pieceList = pieceRepository.findAll();
        assertThat(pieceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
