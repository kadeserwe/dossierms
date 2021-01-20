package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.PiecesRecusService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.PiecesRecusDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.PiecesRecus}.
 */
@RestController
@RequestMapping("/api")
public class PiecesRecusResource {

    private final Logger log = LoggerFactory.getLogger(PiecesRecusResource.class);

    private static final String ENTITY_NAME = "dossiermsPiecesRecus";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PiecesRecusService piecesRecusService;

    public PiecesRecusResource(PiecesRecusService piecesRecusService) {
        this.piecesRecusService = piecesRecusService;
    }

    /**
     * {@code POST  /pieces-recuses} : Create a new piecesRecus.
     *
     * @param piecesRecusDTO the piecesRecusDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new piecesRecusDTO, or with status {@code 400 (Bad Request)} if the piecesRecus has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pieces-recuses")
    public ResponseEntity<PiecesRecusDTO> createPiecesRecus(@RequestBody PiecesRecusDTO piecesRecusDTO) throws URISyntaxException {
        log.debug("REST request to save PiecesRecus : {}", piecesRecusDTO);
        if (piecesRecusDTO.getId() != null) {
            throw new BadRequestAlertException("A new piecesRecus cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PiecesRecusDTO result = piecesRecusService.save(piecesRecusDTO);
        return ResponseEntity.created(new URI("/api/pieces-recuses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /pieces-recuses} : Updates an existing piecesRecus.
     *
     * @param piecesRecusDTO the piecesRecusDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated piecesRecusDTO,
     * or with status {@code 400 (Bad Request)} if the piecesRecusDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the piecesRecusDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pieces-recuses")
    public ResponseEntity<PiecesRecusDTO> updatePiecesRecus(@RequestBody PiecesRecusDTO piecesRecusDTO) throws URISyntaxException {
        log.debug("REST request to update PiecesRecus : {}", piecesRecusDTO);
        if (piecesRecusDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PiecesRecusDTO result = piecesRecusService.save(piecesRecusDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, piecesRecusDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pieces-recuses} : get all the piecesRecuses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of piecesRecuses in body.
     */
    @GetMapping("/pieces-recuses")
    public ResponseEntity<List<PiecesRecusDTO>> getAllPiecesRecuses(Pageable pageable) {
        log.debug("REST request to get a page of PiecesRecuses");
        Page<PiecesRecusDTO> page = piecesRecusService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /pieces-recuses/:id} : get the "id" piecesRecus.
     *
     * @param id the id of the piecesRecusDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the piecesRecusDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pieces-recuses/{id}")
    public ResponseEntity<PiecesRecusDTO> getPiecesRecus(@PathVariable Long id) {
        log.debug("REST request to get PiecesRecus : {}", id);
        Optional<PiecesRecusDTO> piecesRecusDTO = piecesRecusService.findOne(id);
        return ResponseUtil.wrapOrNotFound(piecesRecusDTO);
    }

    /**
     * {@code DELETE  /pieces-recuses/:id} : delete the "id" piecesRecus.
     *
     * @param id the id of the piecesRecusDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pieces-recuses/{id}")
    public ResponseEntity<Void> deletePiecesRecus(@PathVariable Long id) {
        log.debug("REST request to delete PiecesRecus : {}", id);
        piecesRecusService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
