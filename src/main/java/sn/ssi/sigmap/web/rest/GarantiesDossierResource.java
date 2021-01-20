package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.GarantiesDossierService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.GarantiesDossierDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.GarantiesDossier}.
 */
@RestController
@RequestMapping("/api")
public class GarantiesDossierResource {

    private final Logger log = LoggerFactory.getLogger(GarantiesDossierResource.class);

    private static final String ENTITY_NAME = "dossiermsGarantiesDossier";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GarantiesDossierService garantiesDossierService;

    public GarantiesDossierResource(GarantiesDossierService garantiesDossierService) {
        this.garantiesDossierService = garantiesDossierService;
    }

    /**
     * {@code POST  /garanties-dossiers} : Create a new garantiesDossier.
     *
     * @param garantiesDossierDTO the garantiesDossierDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new garantiesDossierDTO, or with status {@code 400 (Bad Request)} if the garantiesDossier has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/garanties-dossiers")
    public ResponseEntity<GarantiesDossierDTO> createGarantiesDossier(@RequestBody GarantiesDossierDTO garantiesDossierDTO) throws URISyntaxException {
        log.debug("REST request to save GarantiesDossier : {}", garantiesDossierDTO);
        if (garantiesDossierDTO.getId() != null) {
            throw new BadRequestAlertException("A new garantiesDossier cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GarantiesDossierDTO result = garantiesDossierService.save(garantiesDossierDTO);
        return ResponseEntity.created(new URI("/api/garanties-dossiers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /garanties-dossiers} : Updates an existing garantiesDossier.
     *
     * @param garantiesDossierDTO the garantiesDossierDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated garantiesDossierDTO,
     * or with status {@code 400 (Bad Request)} if the garantiesDossierDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the garantiesDossierDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/garanties-dossiers")
    public ResponseEntity<GarantiesDossierDTO> updateGarantiesDossier(@RequestBody GarantiesDossierDTO garantiesDossierDTO) throws URISyntaxException {
        log.debug("REST request to update GarantiesDossier : {}", garantiesDossierDTO);
        if (garantiesDossierDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GarantiesDossierDTO result = garantiesDossierService.save(garantiesDossierDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, garantiesDossierDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /garanties-dossiers} : get all the garantiesDossiers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of garantiesDossiers in body.
     */
    @GetMapping("/garanties-dossiers")
    public ResponseEntity<List<GarantiesDossierDTO>> getAllGarantiesDossiers(Pageable pageable) {
        log.debug("REST request to get a page of GarantiesDossiers");
        Page<GarantiesDossierDTO> page = garantiesDossierService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /garanties-dossiers/:id} : get the "id" garantiesDossier.
     *
     * @param id the id of the garantiesDossierDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the garantiesDossierDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/garanties-dossiers/{id}")
    public ResponseEntity<GarantiesDossierDTO> getGarantiesDossier(@PathVariable Long id) {
        log.debug("REST request to get GarantiesDossier : {}", id);
        Optional<GarantiesDossierDTO> garantiesDossierDTO = garantiesDossierService.findOne(id);
        return ResponseUtil.wrapOrNotFound(garantiesDossierDTO);
    }

    /**
     * {@code DELETE  /garanties-dossiers/:id} : delete the "id" garantiesDossier.
     *
     * @param id the id of the garantiesDossierDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/garanties-dossiers/{id}")
    public ResponseEntity<Void> deleteGarantiesDossier(@PathVariable Long id) {
        log.debug("REST request to delete GarantiesDossier : {}", id);
        garantiesDossierService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
