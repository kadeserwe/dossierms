package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.PiecesPlisOuvertureService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.PiecesPlisOuvertureDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.PiecesPlisOuverture}.
 */
@RestController
@RequestMapping("/api")
public class PiecesPlisOuvertureResource {

    private final Logger log = LoggerFactory.getLogger(PiecesPlisOuvertureResource.class);

    private static final String ENTITY_NAME = "dossiermsPiecesPlisOuverture";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PiecesPlisOuvertureService piecesPlisOuvertureService;

    public PiecesPlisOuvertureResource(PiecesPlisOuvertureService piecesPlisOuvertureService) {
        this.piecesPlisOuvertureService = piecesPlisOuvertureService;
    }

    /**
     * {@code POST  /pieces-plis-ouvertures} : Create a new piecesPlisOuverture.
     *
     * @param piecesPlisOuvertureDTO the piecesPlisOuvertureDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new piecesPlisOuvertureDTO, or with status {@code 400 (Bad Request)} if the piecesPlisOuverture has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pieces-plis-ouvertures")
    public ResponseEntity<PiecesPlisOuvertureDTO> createPiecesPlisOuverture(@RequestBody PiecesPlisOuvertureDTO piecesPlisOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to save PiecesPlisOuverture : {}", piecesPlisOuvertureDTO);
        if (piecesPlisOuvertureDTO.getId() != null) {
            throw new BadRequestAlertException("A new piecesPlisOuverture cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PiecesPlisOuvertureDTO result = piecesPlisOuvertureService.save(piecesPlisOuvertureDTO);
        return ResponseEntity.created(new URI("/api/pieces-plis-ouvertures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pieces-plis-ouvertures} : Updates an existing piecesPlisOuverture.
     *
     * @param piecesPlisOuvertureDTO the piecesPlisOuvertureDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated piecesPlisOuvertureDTO,
     * or with status {@code 400 (Bad Request)} if the piecesPlisOuvertureDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the piecesPlisOuvertureDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pieces-plis-ouvertures")
    public ResponseEntity<PiecesPlisOuvertureDTO> updatePiecesPlisOuverture(@RequestBody PiecesPlisOuvertureDTO piecesPlisOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to update PiecesPlisOuverture : {}", piecesPlisOuvertureDTO);
        if (piecesPlisOuvertureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PiecesPlisOuvertureDTO result = piecesPlisOuvertureService.save(piecesPlisOuvertureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, piecesPlisOuvertureDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pieces-plis-ouvertures} : get all the piecesPlisOuvertures.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of piecesPlisOuvertures in body.
     */
    @GetMapping("/pieces-plis-ouvertures")
    public ResponseEntity<List<PiecesPlisOuvertureDTO>> getAllPiecesPlisOuvertures(Pageable pageable) {
        log.debug("REST request to get a page of PiecesPlisOuvertures");
        Page<PiecesPlisOuvertureDTO> page = piecesPlisOuvertureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pieces-plis-ouvertures/:id} : get the "id" piecesPlisOuverture.
     *
     * @param id the id of the piecesPlisOuvertureDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the piecesPlisOuvertureDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pieces-plis-ouvertures/{id}")
    public ResponseEntity<PiecesPlisOuvertureDTO> getPiecesPlisOuverture(@PathVariable Long id) {
        log.debug("REST request to get PiecesPlisOuverture : {}", id);
        Optional<PiecesPlisOuvertureDTO> piecesPlisOuvertureDTO = piecesPlisOuvertureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(piecesPlisOuvertureDTO);
    }

    /**
     * {@code DELETE  /pieces-plis-ouvertures/:id} : delete the "id" piecesPlisOuverture.
     *
     * @param id the id of the piecesPlisOuvertureDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pieces-plis-ouvertures/{id}")
    public ResponseEntity<Void> deletePiecesPlisOuverture(@PathVariable Long id) {
        log.debug("REST request to delete PiecesPlisOuverture : {}", id);
        piecesPlisOuvertureService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
