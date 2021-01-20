package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.GarantiesSoumissionnaireService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.GarantiesSoumissionnaireDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.GarantiesSoumissionnaire}.
 */
@RestController
@RequestMapping("/api")
public class GarantiesSoumissionnaireResource {

    private final Logger log = LoggerFactory.getLogger(GarantiesSoumissionnaireResource.class);

    private static final String ENTITY_NAME = "dossiermsGarantiesSoumissionnaire";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GarantiesSoumissionnaireService garantiesSoumissionnaireService;

    public GarantiesSoumissionnaireResource(GarantiesSoumissionnaireService garantiesSoumissionnaireService) {
        this.garantiesSoumissionnaireService = garantiesSoumissionnaireService;
    }

    /**
     * {@code POST  /garanties-soumissionnaires} : Create a new garantiesSoumissionnaire.
     *
     * @param garantiesSoumissionnaireDTO the garantiesSoumissionnaireDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new garantiesSoumissionnaireDTO, or with status {@code 400 (Bad Request)} if the garantiesSoumissionnaire has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/garanties-soumissionnaires")
    public ResponseEntity<GarantiesSoumissionnaireDTO> createGarantiesSoumissionnaire(@RequestBody GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO) throws URISyntaxException {
        log.debug("REST request to save GarantiesSoumissionnaire : {}", garantiesSoumissionnaireDTO);
        if (garantiesSoumissionnaireDTO.getId() != null) {
            throw new BadRequestAlertException("A new garantiesSoumissionnaire cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GarantiesSoumissionnaireDTO result = garantiesSoumissionnaireService.save(garantiesSoumissionnaireDTO);
        return ResponseEntity.created(new URI("/api/garanties-soumissionnaires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /garanties-soumissionnaires} : Updates an existing garantiesSoumissionnaire.
     *
     * @param garantiesSoumissionnaireDTO the garantiesSoumissionnaireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated garantiesSoumissionnaireDTO,
     * or with status {@code 400 (Bad Request)} if the garantiesSoumissionnaireDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the garantiesSoumissionnaireDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/garanties-soumissionnaires")
    public ResponseEntity<GarantiesSoumissionnaireDTO> updateGarantiesSoumissionnaire(@RequestBody GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO) throws URISyntaxException {
        log.debug("REST request to update GarantiesSoumissionnaire : {}", garantiesSoumissionnaireDTO);
        if (garantiesSoumissionnaireDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GarantiesSoumissionnaireDTO result = garantiesSoumissionnaireService.save(garantiesSoumissionnaireDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, garantiesSoumissionnaireDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /garanties-soumissionnaires} : get all the garantiesSoumissionnaires.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of garantiesSoumissionnaires in body.
     */
    @GetMapping("/garanties-soumissionnaires")
    public ResponseEntity<List<GarantiesSoumissionnaireDTO>> getAllGarantiesSoumissionnaires(Pageable pageable) {
        log.debug("REST request to get a page of GarantiesSoumissionnaires");
        Page<GarantiesSoumissionnaireDTO> page = garantiesSoumissionnaireService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /garanties-soumissionnaires/:id} : get the "id" garantiesSoumissionnaire.
     *
     * @param id the id of the garantiesSoumissionnaireDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the garantiesSoumissionnaireDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/garanties-soumissionnaires/{id}")
    public ResponseEntity<GarantiesSoumissionnaireDTO> getGarantiesSoumissionnaire(@PathVariable Long id) {
        log.debug("REST request to get GarantiesSoumissionnaire : {}", id);
        Optional<GarantiesSoumissionnaireDTO> garantiesSoumissionnaireDTO = garantiesSoumissionnaireService.findOne(id);
        return ResponseUtil.wrapOrNotFound(garantiesSoumissionnaireDTO);
    }

    /**
     * {@code DELETE  /garanties-soumissionnaires/:id} : delete the "id" garantiesSoumissionnaire.
     *
     * @param id the id of the garantiesSoumissionnaireDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/garanties-soumissionnaires/{id}")
    public ResponseEntity<Void> deleteGarantiesSoumissionnaire(@PathVariable Long id) {
        log.debug("REST request to delete GarantiesSoumissionnaire : {}", id);
        garantiesSoumissionnaireService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
