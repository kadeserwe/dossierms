package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.ObservateursIndependantService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.ObservateursIndependantDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.ObservateursIndependant}.
 */
@RestController
@RequestMapping("/api")
public class ObservateursIndependantResource {

    private final Logger log = LoggerFactory.getLogger(ObservateursIndependantResource.class);

    private static final String ENTITY_NAME = "dossiermsObservateursIndependant";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ObservateursIndependantService observateursIndependantService;

    public ObservateursIndependantResource(ObservateursIndependantService observateursIndependantService) {
        this.observateursIndependantService = observateursIndependantService;
    }

    /**
     * {@code POST  /observateurs-independants} : Create a new observateursIndependant.
     *
     * @param observateursIndependantDTO the observateursIndependantDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new observateursIndependantDTO, or with status {@code 400 (Bad Request)} if the observateursIndependant has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/observateurs-independants")
    public ResponseEntity<ObservateursIndependantDTO> createObservateursIndependant(@RequestBody ObservateursIndependantDTO observateursIndependantDTO) throws URISyntaxException {
        log.debug("REST request to save ObservateursIndependant : {}", observateursIndependantDTO);
        if (observateursIndependantDTO.getId() != null) {
            throw new BadRequestAlertException("A new observateursIndependant cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ObservateursIndependantDTO result = observateursIndependantService.save(observateursIndependantDTO);
        return ResponseEntity.created(new URI("/api/observateurs-independants/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /observateurs-independants} : Updates an existing observateursIndependant.
     *
     * @param observateursIndependantDTO the observateursIndependantDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated observateursIndependantDTO,
     * or with status {@code 400 (Bad Request)} if the observateursIndependantDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the observateursIndependantDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/observateurs-independants")
    public ResponseEntity<ObservateursIndependantDTO> updateObservateursIndependant(@RequestBody ObservateursIndependantDTO observateursIndependantDTO) throws URISyntaxException {
        log.debug("REST request to update ObservateursIndependant : {}", observateursIndependantDTO);
        if (observateursIndependantDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ObservateursIndependantDTO result = observateursIndependantService.save(observateursIndependantDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, observateursIndependantDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /observateurs-independants} : get all the observateursIndependants.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of observateursIndependants in body.
     */
    @GetMapping("/observateurs-independants")
    public ResponseEntity<List<ObservateursIndependantDTO>> getAllObservateursIndependants(Pageable pageable) {
        log.debug("REST request to get a page of ObservateursIndependants");
        Page<ObservateursIndependantDTO> page = observateursIndependantService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /observateurs-independants/:id} : get the "id" observateursIndependant.
     *
     * @param id the id of the observateursIndependantDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the observateursIndependantDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/observateurs-independants/{id}")
    public ResponseEntity<ObservateursIndependantDTO> getObservateursIndependant(@PathVariable Long id) {
        log.debug("REST request to get ObservateursIndependant : {}", id);
        Optional<ObservateursIndependantDTO> observateursIndependantDTO = observateursIndependantService.findOne(id);
        return ResponseUtil.wrapOrNotFound(observateursIndependantDTO);
    }

    /**
     * {@code DELETE  /observateurs-independants/:id} : delete the "id" observateursIndependant.
     *
     * @param id the id of the observateursIndependantDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/observateurs-independants/{id}")
    public ResponseEntity<Void> deleteObservateursIndependant(@PathVariable Long id) {
        log.debug("REST request to delete ObservateursIndependant : {}", id);
        observateursIndependantService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
