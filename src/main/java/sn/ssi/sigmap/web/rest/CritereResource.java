package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.CritereService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.CritereDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.Critere}.
 */
@RestController
@RequestMapping("/api")
public class CritereResource {

    private final Logger log = LoggerFactory.getLogger(CritereResource.class);

    private static final String ENTITY_NAME = "dossiermsCritere";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CritereService critereService;

    public CritereResource(CritereService critereService) {
        this.critereService = critereService;
    }

    /**
     * {@code POST  /criteres} : Create a new critere.
     *
     * @param critereDTO the critereDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new critereDTO, or with status {@code 400 (Bad Request)} if the critere has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/criteres")
    public ResponseEntity<CritereDTO> createCritere(@RequestBody CritereDTO critereDTO) throws URISyntaxException {
        log.debug("REST request to save Critere : {}", critereDTO);
        if (critereDTO.getId() != null) {
            throw new BadRequestAlertException("A new critere cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CritereDTO result = critereService.save(critereDTO);
        return ResponseEntity.created(new URI("/api/criteres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /criteres} : Updates an existing critere.
     *
     * @param critereDTO the critereDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated critereDTO,
     * or with status {@code 400 (Bad Request)} if the critereDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the critereDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/criteres")
    public ResponseEntity<CritereDTO> updateCritere(@RequestBody CritereDTO critereDTO) throws URISyntaxException {
        log.debug("REST request to update Critere : {}", critereDTO);
        if (critereDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CritereDTO result = critereService.save(critereDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, critereDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /criteres} : get all the criteres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of criteres in body.
     */
    @GetMapping("/criteres")
    public ResponseEntity<List<CritereDTO>> getAllCriteres(Pageable pageable) {
        log.debug("REST request to get a page of Criteres");
        Page<CritereDTO> page = critereService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /criteres/:id} : get the "id" critere.
     *
     * @param id the id of the critereDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the critereDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/criteres/{id}")
    public ResponseEntity<CritereDTO> getCritere(@PathVariable Long id) {
        log.debug("REST request to get Critere : {}", id);
        Optional<CritereDTO> critereDTO = critereService.findOne(id);
        return ResponseUtil.wrapOrNotFound(critereDTO);
    }

    /**
     * {@code DELETE  /criteres/:id} : delete the "id" critere.
     *
     * @param id the id of the critereDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/criteres/{id}")
    public ResponseEntity<Void> deleteCritere(@PathVariable Long id) {
        log.debug("REST request to delete Critere : {}", id);
        critereService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
