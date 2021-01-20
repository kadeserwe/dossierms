package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.PresenceOuvertureService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.PresenceOuvertureDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.PresenceOuverture}.
 */
@RestController
@RequestMapping("/api")
public class PresenceOuvertureResource {

    private final Logger log = LoggerFactory.getLogger(PresenceOuvertureResource.class);

    private static final String ENTITY_NAME = "dossiermsPresenceOuverture";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PresenceOuvertureService presenceOuvertureService;

    public PresenceOuvertureResource(PresenceOuvertureService presenceOuvertureService) {
        this.presenceOuvertureService = presenceOuvertureService;
    }

    /**
     * {@code POST  /presence-ouvertures} : Create a new presenceOuverture.
     *
     * @param presenceOuvertureDTO the presenceOuvertureDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new presenceOuvertureDTO, or with status {@code 400 (Bad Request)} if the presenceOuverture has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/presence-ouvertures")
    public ResponseEntity<PresenceOuvertureDTO> createPresenceOuverture(@RequestBody PresenceOuvertureDTO presenceOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to save PresenceOuverture : {}", presenceOuvertureDTO);
        if (presenceOuvertureDTO.getId() != null) {
            throw new BadRequestAlertException("A new presenceOuverture cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PresenceOuvertureDTO result = presenceOuvertureService.save(presenceOuvertureDTO);
        return ResponseEntity.created(new URI("/api/presence-ouvertures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /presence-ouvertures} : Updates an existing presenceOuverture.
     *
     * @param presenceOuvertureDTO the presenceOuvertureDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated presenceOuvertureDTO,
     * or with status {@code 400 (Bad Request)} if the presenceOuvertureDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the presenceOuvertureDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/presence-ouvertures")
    public ResponseEntity<PresenceOuvertureDTO> updatePresenceOuverture(@RequestBody PresenceOuvertureDTO presenceOuvertureDTO) throws URISyntaxException {
        log.debug("REST request to update PresenceOuverture : {}", presenceOuvertureDTO);
        if (presenceOuvertureDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PresenceOuvertureDTO result = presenceOuvertureService.save(presenceOuvertureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, presenceOuvertureDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /presence-ouvertures} : get all the presenceOuvertures.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of presenceOuvertures in body.
     */
    @GetMapping("/presence-ouvertures")
    public ResponseEntity<List<PresenceOuvertureDTO>> getAllPresenceOuvertures(Pageable pageable) {
        log.debug("REST request to get a page of PresenceOuvertures");
        Page<PresenceOuvertureDTO> page = presenceOuvertureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /presence-ouvertures/:id} : get the "id" presenceOuverture.
     *
     * @param id the id of the presenceOuvertureDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the presenceOuvertureDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/presence-ouvertures/{id}")
    public ResponseEntity<PresenceOuvertureDTO> getPresenceOuverture(@PathVariable Long id) {
        log.debug("REST request to get PresenceOuverture : {}", id);
        Optional<PresenceOuvertureDTO> presenceOuvertureDTO = presenceOuvertureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(presenceOuvertureDTO);
    }

    /**
     * {@code DELETE  /presence-ouvertures/:id} : delete the "id" presenceOuverture.
     *
     * @param id the id of the presenceOuvertureDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/presence-ouvertures/{id}")
    public ResponseEntity<Void> deletePresenceOuverture(@PathVariable Long id) {
        log.debug("REST request to delete PresenceOuverture : {}", id);
        presenceOuvertureService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
