package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.NaturePrixService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.NaturePrixDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.NaturePrix}.
 */
@RestController
@RequestMapping("/api")
public class NaturePrixResource {

    private final Logger log = LoggerFactory.getLogger(NaturePrixResource.class);

    private static final String ENTITY_NAME = "dossiermsNaturePrix";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NaturePrixService naturePrixService;

    public NaturePrixResource(NaturePrixService naturePrixService) {
        this.naturePrixService = naturePrixService;
    }

    /**
     * {@code POST  /nature-prixes} : Create a new naturePrix.
     *
     * @param naturePrixDTO the naturePrixDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new naturePrixDTO, or with status {@code 400 (Bad Request)} if the naturePrix has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/nature-prixes")
    public ResponseEntity<NaturePrixDTO> createNaturePrix(@RequestBody NaturePrixDTO naturePrixDTO) throws URISyntaxException {
        log.debug("REST request to save NaturePrix : {}", naturePrixDTO);
        if (naturePrixDTO.getId() != null) {
            throw new BadRequestAlertException("A new naturePrix cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NaturePrixDTO result = naturePrixService.save(naturePrixDTO);
        return ResponseEntity.created(new URI("/api/nature-prixes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /nature-prixes} : Updates an existing naturePrix.
     *
     * @param naturePrixDTO the naturePrixDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated naturePrixDTO,
     * or with status {@code 400 (Bad Request)} if the naturePrixDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the naturePrixDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/nature-prixes")
    public ResponseEntity<NaturePrixDTO> updateNaturePrix(@RequestBody NaturePrixDTO naturePrixDTO) throws URISyntaxException {
        log.debug("REST request to update NaturePrix : {}", naturePrixDTO);
        if (naturePrixDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NaturePrixDTO result = naturePrixService.save(naturePrixDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, naturePrixDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /nature-prixes} : get all the naturePrixes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of naturePrixes in body.
     */
    @GetMapping("/nature-prixes")
    public ResponseEntity<List<NaturePrixDTO>> getAllNaturePrixes(Pageable pageable) {
        log.debug("REST request to get a page of NaturePrixes");
        Page<NaturePrixDTO> page = naturePrixService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /nature-prixes/:id} : get the "id" naturePrix.
     *
     * @param id the id of the naturePrixDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the naturePrixDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/nature-prixes/{id}")
    public ResponseEntity<NaturePrixDTO> getNaturePrix(@PathVariable Long id) {
        log.debug("REST request to get NaturePrix : {}", id);
        Optional<NaturePrixDTO> naturePrixDTO = naturePrixService.findOne(id);
        return ResponseUtil.wrapOrNotFound(naturePrixDTO);
    }

    /**
     * {@code DELETE  /nature-prixes/:id} : delete the "id" naturePrix.
     *
     * @param id the id of the naturePrixDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/nature-prixes/{id}")
    public ResponseEntity<Void> deleteNaturePrix(@PathVariable Long id) {
        log.debug("REST request to delete NaturePrix : {}", id);
        naturePrixService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
