package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.RepresentantServTechService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.RepresentantServTechDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.RepresentantServTech}.
 */
@RestController
@RequestMapping("/api")
public class RepresentantServTechResource {

    private final Logger log = LoggerFactory.getLogger(RepresentantServTechResource.class);

    private static final String ENTITY_NAME = "dossiermsRepresentantServTech";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RepresentantServTechService representantServTechService;

    public RepresentantServTechResource(RepresentantServTechService representantServTechService) {
        this.representantServTechService = representantServTechService;
    }

    /**
     * {@code POST  /representant-serv-teches} : Create a new representantServTech.
     *
     * @param representantServTechDTO the representantServTechDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new representantServTechDTO, or with status {@code 400 (Bad Request)} if the representantServTech has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/representant-serv-teches")
    public ResponseEntity<RepresentantServTechDTO> createRepresentantServTech(@RequestBody RepresentantServTechDTO representantServTechDTO) throws URISyntaxException {
        log.debug("REST request to save RepresentantServTech : {}", representantServTechDTO);
        if (representantServTechDTO.getId() != null) {
            throw new BadRequestAlertException("A new representantServTech cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RepresentantServTechDTO result = representantServTechService.save(representantServTechDTO);
        return ResponseEntity.created(new URI("/api/representant-serv-teches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /representant-serv-teches} : Updates an existing representantServTech.
     *
     * @param representantServTechDTO the representantServTechDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated representantServTechDTO,
     * or with status {@code 400 (Bad Request)} if the representantServTechDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the representantServTechDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/representant-serv-teches")
    public ResponseEntity<RepresentantServTechDTO> updateRepresentantServTech(@RequestBody RepresentantServTechDTO representantServTechDTO) throws URISyntaxException {
        log.debug("REST request to update RepresentantServTech : {}", representantServTechDTO);
        if (representantServTechDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RepresentantServTechDTO result = representantServTechService.save(representantServTechDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, representantServTechDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /representant-serv-teches} : get all the representantServTeches.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of representantServTeches in body.
     */
    @GetMapping("/representant-serv-teches")
    public ResponseEntity<List<RepresentantServTechDTO>> getAllRepresentantServTeches(Pageable pageable) {
        log.debug("REST request to get a page of RepresentantServTeches");
        Page<RepresentantServTechDTO> page = representantServTechService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /representant-serv-teches/:id} : get the "id" representantServTech.
     *
     * @param id the id of the representantServTechDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the representantServTechDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/representant-serv-teches/{id}")
    public ResponseEntity<RepresentantServTechDTO> getRepresentantServTech(@PathVariable Long id) {
        log.debug("REST request to get RepresentantServTech : {}", id);
        Optional<RepresentantServTechDTO> representantServTechDTO = representantServTechService.findOne(id);
        return ResponseUtil.wrapOrNotFound(representantServTechDTO);
    }

    /**
     * {@code DELETE  /representant-serv-teches/:id} : delete the "id" representantServTech.
     *
     * @param id the id of the representantServTechDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/representant-serv-teches/{id}")
    public ResponseEntity<Void> deleteRepresentantServTech(@PathVariable Long id) {
        log.debug("REST request to delete RepresentantServTech : {}", id);
        representantServTechService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
