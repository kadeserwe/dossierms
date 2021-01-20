package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.MonnaieOffreService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.MonnaieOffreDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.MonnaieOffre}.
 */
@RestController
@RequestMapping("/api")
public class MonnaieOffreResource {

    private final Logger log = LoggerFactory.getLogger(MonnaieOffreResource.class);

    private static final String ENTITY_NAME = "dossiermsMonnaieOffre";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonnaieOffreService monnaieOffreService;

    public MonnaieOffreResource(MonnaieOffreService monnaieOffreService) {
        this.monnaieOffreService = monnaieOffreService;
    }

    /**
     * {@code POST  /monnaie-offres} : Create a new monnaieOffre.
     *
     * @param monnaieOffreDTO the monnaieOffreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monnaieOffreDTO, or with status {@code 400 (Bad Request)} if the monnaieOffre has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monnaie-offres")
    public ResponseEntity<MonnaieOffreDTO> createMonnaieOffre(@RequestBody MonnaieOffreDTO monnaieOffreDTO) throws URISyntaxException {
        log.debug("REST request to save MonnaieOffre : {}", monnaieOffreDTO);
        if (monnaieOffreDTO.getId() != null) {
            throw new BadRequestAlertException("A new monnaieOffre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonnaieOffreDTO result = monnaieOffreService.save(monnaieOffreDTO);
        return ResponseEntity.created(new URI("/api/monnaie-offres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monnaie-offres} : Updates an existing monnaieOffre.
     *
     * @param monnaieOffreDTO the monnaieOffreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monnaieOffreDTO,
     * or with status {@code 400 (Bad Request)} if the monnaieOffreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monnaieOffreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monnaie-offres")
    public ResponseEntity<MonnaieOffreDTO> updateMonnaieOffre(@RequestBody MonnaieOffreDTO monnaieOffreDTO) throws URISyntaxException {
        log.debug("REST request to update MonnaieOffre : {}", monnaieOffreDTO);
        if (monnaieOffreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonnaieOffreDTO result = monnaieOffreService.save(monnaieOffreDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, monnaieOffreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monnaie-offres} : get all the monnaieOffres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monnaieOffres in body.
     */
    @GetMapping("/monnaie-offres")
    public ResponseEntity<List<MonnaieOffreDTO>> getAllMonnaieOffres(Pageable pageable) {
        log.debug("REST request to get a page of MonnaieOffres");
        Page<MonnaieOffreDTO> page = monnaieOffreService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monnaie-offres/:id} : get the "id" monnaieOffre.
     *
     * @param id the id of the monnaieOffreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monnaieOffreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monnaie-offres/{id}")
    public ResponseEntity<MonnaieOffreDTO> getMonnaieOffre(@PathVariable Long id) {
        log.debug("REST request to get MonnaieOffre : {}", id);
        Optional<MonnaieOffreDTO> monnaieOffreDTO = monnaieOffreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monnaieOffreDTO);
    }

    /**
     * {@code DELETE  /monnaie-offres/:id} : delete the "id" monnaieOffre.
     *
     * @param id the id of the monnaieOffreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monnaie-offres/{id}")
    public ResponseEntity<Void> deleteMonnaieOffre(@PathVariable Long id) {
        log.debug("REST request to delete MonnaieOffre : {}", id);
        monnaieOffreService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
