package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.PlisOuvertureService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.PlisOuvertureDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.PlisOuverture}.
 */
@RestController
@RequestMapping("/api")
public class PlisOuvertureResource {

    private final Logger log = LoggerFactory.getLogger(PlisOuvertureResource.class);

    private static final String ENTITY_NAME = "dossiermsPlisOuverture";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PlisOuvertureService plisOuvertureService;

    public PlisOuvertureResource(PlisOuvertureService plisOuvertureService) {
        this.plisOuvertureService = plisOuvertureService;
    }

    /**
     * {@code POST  /plis-ouvertures} : Create a new plisOuverture.
     *
     * @param plisOuvertureDTO the plisOuvertureDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new plisOuvertureDTO, or with status {@code 400 (Bad Request)} if the plisOuverture has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/plis-ouvertures")
    public ResponseEntity<PlisOuvertureDTO> createPlisOuverture(@RequestBody PlisOuvertureDTO plisOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to save PlisOuverture : {}", plisOuvertureDTO);
        if (plisOuvertureDTO.getId() != null) {
            throw new BadRequestAlertException("A new plisOuverture cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PlisOuvertureDTO result = plisOuvertureService.save(plisOuvertureDTO);
        return ResponseEntity.created(new URI("/api/plis-ouvertures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /plis-ouvertures} : Updates an existing plisOuverture.
     *
     * @param plisOuvertureDTO the plisOuvertureDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated plisOuvertureDTO,
     * or with status {@code 400 (Bad Request)} if the plisOuvertureDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the plisOuvertureDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/plis-ouvertures")
    public ResponseEntity<PlisOuvertureDTO> updatePlisOuverture(@RequestBody PlisOuvertureDTO plisOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to update PlisOuverture : {}", plisOuvertureDTO);
        if (plisOuvertureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PlisOuvertureDTO result = plisOuvertureService.save(plisOuvertureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, plisOuvertureDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /plis-ouvertures} : get all the plisOuvertures.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of plisOuvertures in body.
     */
    @GetMapping("/plis-ouvertures")
    public ResponseEntity<List<PlisOuvertureDTO>> getAllPlisOuvertures(Pageable pageable) {
        log.debug("REST request to get a page of PlisOuvertures");
        Page<PlisOuvertureDTO> page = plisOuvertureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /plis-ouvertures/:id} : get the "id" plisOuverture.
     *
     * @param id the id of the plisOuvertureDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the plisOuvertureDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/plis-ouvertures/{id}")
    public ResponseEntity<PlisOuvertureDTO> getPlisOuverture(@PathVariable Long id) {
        log.debug("REST request to get PlisOuverture : {}", id);
        Optional<PlisOuvertureDTO> plisOuvertureDTO = plisOuvertureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(plisOuvertureDTO);
    }

    /**
     * {@code DELETE  /plis-ouvertures/:id} : delete the "id" plisOuverture.
     *
     * @param id the id of the plisOuvertureDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/plis-ouvertures/{id}")
    public ResponseEntity<Void> deletePlisOuverture(@PathVariable Long id) {
        log.debug("REST request to delete PlisOuverture : {}", id);
        plisOuvertureService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
