package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.DossiersEvaluateurService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.DossiersEvaluateurDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.DossiersEvaluateur}.
 */
@RestController
@RequestMapping("/api")
public class DossiersEvaluateurResource {

    private final Logger log = LoggerFactory.getLogger(DossiersEvaluateurResource.class);

    private static final String ENTITY_NAME = "dossiermsDossiersEvaluateur";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DossiersEvaluateurService dossiersEvaluateurService;

    public DossiersEvaluateurResource(DossiersEvaluateurService dossiersEvaluateurService) {
        this.dossiersEvaluateurService = dossiersEvaluateurService;
    }

    /**
     * {@code POST  /dossiers-evaluateurs} : Create a new dossiersEvaluateur.
     *
     * @param dossiersEvaluateurDTO the dossiersEvaluateurDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dossiersEvaluateurDTO, or with status {@code 400 (Bad Request)} if the dossiersEvaluateur has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dossiers-evaluateurs")
    public ResponseEntity<DossiersEvaluateurDTO> createDossiersEvaluateur(@RequestBody DossiersEvaluateurDTO dossiersEvaluateurDTO) throws URISyntaxException {
        log.debug("REST request to save DossiersEvaluateur : {}", dossiersEvaluateurDTO);
        if (dossiersEvaluateurDTO.getId() != null) {
            throw new BadRequestAlertException("A new dossiersEvaluateur cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DossiersEvaluateurDTO result = dossiersEvaluateurService.save(dossiersEvaluateurDTO);
        return ResponseEntity.created(new URI("/api/dossiers-evaluateurs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dossiers-evaluateurs} : Updates an existing dossiersEvaluateur.
     *
     * @param dossiersEvaluateurDTO the dossiersEvaluateurDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dossiersEvaluateurDTO,
     * or with status {@code 400 (Bad Request)} if the dossiersEvaluateurDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dossiersEvaluateurDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dossiers-evaluateurs")
    public ResponseEntity<DossiersEvaluateurDTO> updateDossiersEvaluateur(@RequestBody DossiersEvaluateurDTO dossiersEvaluateurDTO) throws URISyntaxException {
        log.debug("REST request to update DossiersEvaluateur : {}", dossiersEvaluateurDTO);
        if (dossiersEvaluateurDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DossiersEvaluateurDTO result = dossiersEvaluateurService.save(dossiersEvaluateurDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dossiersEvaluateurDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dossiers-evaluateurs} : get all the dossiersEvaluateurs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dossiersEvaluateurs in body.
     */
    @GetMapping("/dossiers-evaluateurs")
    public ResponseEntity<List<DossiersEvaluateurDTO>> getAllDossiersEvaluateurs(Pageable pageable) {
        log.debug("REST request to get a page of DossiersEvaluateurs");
        Page<DossiersEvaluateurDTO> page = dossiersEvaluateurService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dossiers-evaluateurs/:id} : get the "id" dossiersEvaluateur.
     *
     * @param id the id of the dossiersEvaluateurDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dossiersEvaluateurDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dossiers-evaluateurs/{id}")
    public ResponseEntity<DossiersEvaluateurDTO> getDossiersEvaluateur(@PathVariable Long id) {
        log.debug("REST request to get DossiersEvaluateur : {}", id);
        Optional<DossiersEvaluateurDTO> dossiersEvaluateurDTO = dossiersEvaluateurService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dossiersEvaluateurDTO);
    }

    /**
     * {@code DELETE  /dossiers-evaluateurs/:id} : delete the "id" dossiersEvaluateur.
     *
     * @param id the id of the dossiersEvaluateurDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dossiers-evaluateurs/{id}")
    public ResponseEntity<Void> deleteDossiersEvaluateur(@PathVariable Long id) {
        log.debug("REST request to delete DossiersEvaluateur : {}", id);
        dossiersEvaluateurService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
