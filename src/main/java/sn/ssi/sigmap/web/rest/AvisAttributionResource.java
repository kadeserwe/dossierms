package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.AvisAttributionService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.AvisAttributionDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.AvisAttribution}.
 */
@RestController
@RequestMapping("/api")
public class AvisAttributionResource {

    private final Logger log = LoggerFactory.getLogger(AvisAttributionResource.class);

    private static final String ENTITY_NAME = "dossiermsAvisAttribution";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AvisAttributionService avisAttributionService;

    public AvisAttributionResource(AvisAttributionService avisAttributionService) {
        this.avisAttributionService = avisAttributionService;
    }

    /**
     * {@code POST  /avis-attributions} : Create a new avisAttribution.
     *
     * @param avisAttributionDTO the avisAttributionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new avisAttributionDTO, or with status {@code 400 (Bad Request)} if the avisAttribution has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/avis-attributions")
    public ResponseEntity<AvisAttributionDTO> createAvisAttribution(@RequestBody AvisAttributionDTO avisAttributionDTO) throws URISyntaxException {
        log.debug("REST request to save AvisAttribution : {}", avisAttributionDTO);
        if (avisAttributionDTO.getId() != null) {
            throw new BadRequestAlertException("A new avisAttribution cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AvisAttributionDTO result = avisAttributionService.save(avisAttributionDTO);
        return ResponseEntity.created(new URI("/api/avis-attributions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /avis-attributions} : Updates an existing avisAttribution.
     *
     * @param avisAttributionDTO the avisAttributionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated avisAttributionDTO,
     * or with status {@code 400 (Bad Request)} if the avisAttributionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the avisAttributionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/avis-attributions")
    public ResponseEntity<AvisAttributionDTO> updateAvisAttribution(@RequestBody AvisAttributionDTO avisAttributionDTO) throws URISyntaxException {
        log.debug("REST request to update AvisAttribution : {}", avisAttributionDTO);
        if (avisAttributionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AvisAttributionDTO result = avisAttributionService.save(avisAttributionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, avisAttributionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /avis-attributions} : get all the avisAttributions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of avisAttributions in body.
     */
    @GetMapping("/avis-attributions")
    public ResponseEntity<List<AvisAttributionDTO>> getAllAvisAttributions(Pageable pageable) {
        log.debug("REST request to get a page of AvisAttributions");
        Page<AvisAttributionDTO> page = avisAttributionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /avis-attributions/:id} : get the "id" avisAttribution.
     *
     * @param id the id of the avisAttributionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the avisAttributionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/avis-attributions/{id}")
    public ResponseEntity<AvisAttributionDTO> getAvisAttribution(@PathVariable Long id) {
        log.debug("REST request to get AvisAttribution : {}", id);
        Optional<AvisAttributionDTO> avisAttributionDTO = avisAttributionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(avisAttributionDTO);
    }

    /**
     * {@code DELETE  /avis-attributions/:id} : delete the "id" avisAttribution.
     *
     * @param id the id of the avisAttributionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/avis-attributions/{id}")
    public ResponseEntity<Void> deleteAvisAttribution(@PathVariable Long id) {
        log.debug("REST request to delete AvisAttribution : {}", id);
        avisAttributionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
