package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.TachesEffectueService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.TachesEffectueDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.TachesEffectue}.
 */
@RestController
@RequestMapping("/api")
public class TachesEffectueResource {

    private final Logger log = LoggerFactory.getLogger(TachesEffectueResource.class);

    private static final String ENTITY_NAME = "dossiermsTachesEffectue";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TachesEffectueService tachesEffectueService;

    public TachesEffectueResource(TachesEffectueService tachesEffectueService) {
        this.tachesEffectueService = tachesEffectueService;
    }

    /**
     * {@code POST  /taches-effectues} : Create a new tachesEffectue.
     *
     * @param tachesEffectueDTO the tachesEffectueDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tachesEffectueDTO, or with status {@code 400 (Bad Request)} if the tachesEffectue has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/taches-effectues")
    public ResponseEntity<TachesEffectueDTO> createTachesEffectue(@RequestBody TachesEffectueDTO tachesEffectueDTO) throws URISyntaxException {
        log.debug("REST request to save TachesEffectue : {}", tachesEffectueDTO);
        if (tachesEffectueDTO.getId() != null) {
            throw new BadRequestAlertException("A new tachesEffectue cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TachesEffectueDTO result = tachesEffectueService.save(tachesEffectueDTO);
        return ResponseEntity.created(new URI("/api/taches-effectues/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /taches-effectues} : Updates an existing tachesEffectue.
     *
     * @param tachesEffectueDTO the tachesEffectueDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tachesEffectueDTO,
     * or with status {@code 400 (Bad Request)} if the tachesEffectueDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tachesEffectueDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/taches-effectues")
    public ResponseEntity<TachesEffectueDTO> updateTachesEffectue(@RequestBody TachesEffectueDTO tachesEffectueDTO) throws URISyntaxException {
        log.debug("REST request to update TachesEffectue : {}", tachesEffectueDTO);
        if (tachesEffectueDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TachesEffectueDTO result = tachesEffectueService.save(tachesEffectueDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, tachesEffectueDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /taches-effectues} : get all the tachesEffectues.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tachesEffectues in body.
     */
    @GetMapping("/taches-effectues")
    public ResponseEntity<List<TachesEffectueDTO>> getAllTachesEffectues(Pageable pageable) {
        log.debug("REST request to get a page of TachesEffectues");
        Page<TachesEffectueDTO> page = tachesEffectueService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /taches-effectues/:id} : get the "id" tachesEffectue.
     *
     * @param id the id of the tachesEffectueDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tachesEffectueDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/taches-effectues/{id}")
    public ResponseEntity<TachesEffectueDTO> getTachesEffectue(@PathVariable Long id) {
        log.debug("REST request to get TachesEffectue : {}", id);
        Optional<TachesEffectueDTO> tachesEffectueDTO = tachesEffectueService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tachesEffectueDTO);
    }

    /**
     * {@code DELETE  /taches-effectues/:id} : delete the "id" tachesEffectue.
     *
     * @param id the id of the tachesEffectueDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/taches-effectues/{id}")
    public ResponseEntity<Void> deleteTachesEffectue(@PathVariable Long id) {
        log.debug("REST request to delete TachesEffectue : {}", id);
        tachesEffectueService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
