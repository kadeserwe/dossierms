package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.DossiersSouscritereService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.DossiersSouscritereDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.DossiersSouscritere}.
 */
@RestController
@RequestMapping("/api")
public class DossiersSouscritereResource {

    private final Logger log = LoggerFactory.getLogger(DossiersSouscritereResource.class);

    private static final String ENTITY_NAME = "dossiermsDossiersSouscritere";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DossiersSouscritereService dossiersSouscritereService;

    public DossiersSouscritereResource(DossiersSouscritereService dossiersSouscritereService) {
        this.dossiersSouscritereService = dossiersSouscritereService;
    }

    /**
     * {@code POST  /dossiers-souscriteres} : Create a new dossiersSouscritere.
     *
     * @param dossiersSouscritereDTO the dossiersSouscritereDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dossiersSouscritereDTO, or with status {@code 400 (Bad Request)} if the dossiersSouscritere has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dossiers-souscriteres")
    public ResponseEntity<DossiersSouscritereDTO> createDossiersSouscritere(@RequestBody DossiersSouscritereDTO dossiersSouscritereDTO) throws URISyntaxException {
        log.debug("REST request to save DossiersSouscritere : {}", dossiersSouscritereDTO);
        if (dossiersSouscritereDTO.getId() != null) {
            throw new BadRequestAlertException("A new dossiersSouscritere cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DossiersSouscritereDTO result = dossiersSouscritereService.save(dossiersSouscritereDTO);
        return ResponseEntity.created(new URI("/api/dossiers-souscriteres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dossiers-souscriteres} : Updates an existing dossiersSouscritere.
     *
     * @param dossiersSouscritereDTO the dossiersSouscritereDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dossiersSouscritereDTO,
     * or with status {@code 400 (Bad Request)} if the dossiersSouscritereDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dossiersSouscritereDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dossiers-souscriteres")
    public ResponseEntity<DossiersSouscritereDTO> updateDossiersSouscritere(@RequestBody DossiersSouscritereDTO dossiersSouscritereDTO) throws URISyntaxException {
        log.debug("REST request to update DossiersSouscritere : {}", dossiersSouscritereDTO);
        if (dossiersSouscritereDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DossiersSouscritereDTO result = dossiersSouscritereService.save(dossiersSouscritereDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dossiersSouscritereDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dossiers-souscriteres} : get all the dossiersSouscriteres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dossiersSouscriteres in body.
     */
    @GetMapping("/dossiers-souscriteres")
    public ResponseEntity<List<DossiersSouscritereDTO>> getAllDossiersSouscriteres(Pageable pageable) {
        log.debug("REST request to get a page of DossiersSouscriteres");
        Page<DossiersSouscritereDTO> page = dossiersSouscritereService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dossiers-souscriteres/:id} : get the "id" dossiersSouscritere.
     *
     * @param id the id of the dossiersSouscritereDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dossiersSouscritereDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dossiers-souscriteres/{id}")
    public ResponseEntity<DossiersSouscritereDTO> getDossiersSouscritere(@PathVariable Long id) {
        log.debug("REST request to get DossiersSouscritere : {}", id);
        Optional<DossiersSouscritereDTO> dossiersSouscritereDTO = dossiersSouscritereService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dossiersSouscritereDTO);
    }

    /**
     * {@code DELETE  /dossiers-souscriteres/:id} : delete the "id" dossiersSouscritere.
     *
     * @param id the id of the dossiersSouscritereDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dossiers-souscriteres/{id}")
    public ResponseEntity<Void> deleteDossiersSouscritere(@PathVariable Long id) {
        log.debug("REST request to delete DossiersSouscritere : {}", id);
        dossiersSouscritereService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
