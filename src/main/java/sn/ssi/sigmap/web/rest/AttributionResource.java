package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.AttributionService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.AttributionDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.Attribution}.
 */
@RestController
@RequestMapping("/api")
public class AttributionResource {

    private final Logger log = LoggerFactory.getLogger(AttributionResource.class);

    private static final String ENTITY_NAME = "dossiermsAttribution";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AttributionService attributionService;

    public AttributionResource(AttributionService attributionService) {
        this.attributionService = attributionService;
    }

    /**
     * {@code POST  /attributions} : Create a new attribution.
     *
     * @param attributionDTO the attributionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new attributionDTO, or with status {@code 400 (Bad Request)} if the attribution has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/attributions")
    public ResponseEntity<AttributionDTO> createAttribution(@RequestBody AttributionDTO attributionDTO) throws URISyntaxException {
        log.debug("REST request to save Attribution : {}", attributionDTO);
        if (attributionDTO.getId() != null) {
            throw new BadRequestAlertException("A new attribution cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AttributionDTO result = attributionService.save(attributionDTO);
        return ResponseEntity.created(new URI("/api/attributions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /attributions} : Updates an existing attribution.
     *
     * @param attributionDTO the attributionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated attributionDTO,
     * or with status {@code 400 (Bad Request)} if the attributionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the attributionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/attributions")
    public ResponseEntity<AttributionDTO> updateAttribution(@RequestBody AttributionDTO attributionDTO) throws URISyntaxException {
        log.debug("REST request to update Attribution : {}", attributionDTO);
        if (attributionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AttributionDTO result = attributionService.save(attributionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, attributionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /attributions} : get all the attributions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of attributions in body.
     */
    @GetMapping("/attributions")
    public ResponseEntity<List<AttributionDTO>> getAllAttributions(Pageable pageable) {
        log.debug("REST request to get a page of Attributions");
        Page<AttributionDTO> page = attributionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /attributions/:id} : get the "id" attribution.
     *
     * @param id the id of the attributionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the attributionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/attributions/{id}")
    public ResponseEntity<AttributionDTO> getAttribution(@PathVariable Long id) {
        log.debug("REST request to get Attribution : {}", id);
        Optional<AttributionDTO> attributionDTO = attributionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(attributionDTO);
    }

    /**
     * {@code DELETE  /attributions/:id} : delete the "id" attribution.
     *
     * @param id the id of the attributionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/attributions/{id}")
    public ResponseEntity<Void> deleteAttribution(@PathVariable Long id) {
        log.debug("REST request to delete Attribution : {}", id);
        attributionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
