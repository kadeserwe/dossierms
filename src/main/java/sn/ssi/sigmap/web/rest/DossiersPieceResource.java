package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.DossiersPieceService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.DossiersPieceDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.ssi.sigmap.domain.DossiersPiece}.
 */
@RestController
@RequestMapping("/api")
public class DossiersPieceResource {

    private final Logger log = LoggerFactory.getLogger(DossiersPieceResource.class);

    private static final String ENTITY_NAME = "dossiermsDossiersPiece";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DossiersPieceService dossiersPieceService;

    public DossiersPieceResource(DossiersPieceService dossiersPieceService) {
        this.dossiersPieceService = dossiersPieceService;
    }

    /**
     * {@code POST  /dossiers-pieces} : Create a new dossiersPiece.
     *
     * @param dossiersPieceDTO the dossiersPieceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dossiersPieceDTO, or with status {@code 400 (Bad Request)} if the dossiersPiece has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dossiers-pieces")
    public ResponseEntity<DossiersPieceDTO> createDossiersPiece(@RequestBody DossiersPieceDTO dossiersPieceDTO) throws URISyntaxException {
        log.debug("REST request to save DossiersPiece : {}", dossiersPieceDTO);
        if (dossiersPieceDTO.getId() != null) {
            throw new BadRequestAlertException("A new dossiersPiece cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DossiersPieceDTO result = dossiersPieceService.save(dossiersPieceDTO);
        return ResponseEntity.created(new URI("/api/dossiers-pieces/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dossiers-pieces} : Updates an existing dossiersPiece.
     *
     * @param dossiersPieceDTO the dossiersPieceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dossiersPieceDTO,
     * or with status {@code 400 (Bad Request)} if the dossiersPieceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dossiersPieceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dossiers-pieces")
    public ResponseEntity<DossiersPieceDTO> updateDossiersPiece(@RequestBody DossiersPieceDTO dossiersPieceDTO) throws URISyntaxException {
        log.debug("REST request to update DossiersPiece : {}", dossiersPieceDTO);
        if (dossiersPieceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DossiersPieceDTO result = dossiersPieceService.save(dossiersPieceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dossiersPieceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dossiers-pieces} : get all the dossiersPieces.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dossiersPieces in body.
     */
    @GetMapping("/dossiers-pieces")
    public ResponseEntity<List<DossiersPieceDTO>> getAllDossiersPieces(Pageable pageable) {
        log.debug("REST request to get a page of DossiersPieces");
        Page<DossiersPieceDTO> page = dossiersPieceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dossiers-pieces/:id} : get the "id" dossiersPiece.
     *
     * @param id the id of the dossiersPieceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dossiersPieceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dossiers-pieces/{id}")
    public ResponseEntity<DossiersPieceDTO> getDossiersPiece(@PathVariable Long id) {
        log.debug("REST request to get DossiersPiece : {}", id);
        Optional<DossiersPieceDTO> dossiersPieceDTO = dossiersPieceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dossiersPieceDTO);
    }

    /**
     * {@code DELETE  /dossiers-pieces/:id} : delete the "id" dossiersPiece.
     *
     * @param id the id of the dossiersPieceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dossiers-pieces/{id}")
    public ResponseEntity<Void> deleteDossiersPiece(@PathVariable Long id) {
        log.debug("REST request to delete DossiersPiece : {}", id);
        dossiersPieceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
