package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.AppelOffreService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.AppelOffreDTO;

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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.ssi.sigmap.domain.AppelOffre}.
 */
@RestController
@RequestMapping("/api")
public class AppelOffreResource {

    private final Logger log = LoggerFactory.getLogger(AppelOffreResource.class);

    private static final String ENTITY_NAME = "dossiermsAppelOffre";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppelOffreService appelOffreService;

    public AppelOffreResource(AppelOffreService appelOffreService) {
        this.appelOffreService = appelOffreService;
    }

    /**
     * {@code POST  /appel-offres} : Create a new appelOffre.
     *
     * @param appelOffreDTO the appelOffreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appelOffreDTO, or with status {@code 400 (Bad Request)} if the appelOffre has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/appel-offres")
    public ResponseEntity<AppelOffreDTO> createAppelOffre(@Valid @RequestBody AppelOffreDTO appelOffreDTO) throws URISyntaxException {
        log.debug("REST request to save AppelOffre : {}", appelOffreDTO);
        if (appelOffreDTO.getId() != null) {
            throw new BadRequestAlertException("A new appelOffre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppelOffreDTO result = appelOffreService.save(appelOffreDTO);
        return ResponseEntity.created(new URI("/api/appel-offres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /appel-offres} : Updates an existing appelOffre.
     *
     * @param appelOffreDTO the appelOffreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appelOffreDTO,
     * or with status {@code 400 (Bad Request)} if the appelOffreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appelOffreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/appel-offres")
    public ResponseEntity<AppelOffreDTO> updateAppelOffre(@Valid @RequestBody AppelOffreDTO appelOffreDTO) throws URISyntaxException {
        log.debug("REST request to update AppelOffre : {}", appelOffreDTO);
        if (appelOffreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppelOffreDTO result = appelOffreService.save(appelOffreDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appelOffreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /appel-offres} : get all the appelOffres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appelOffres in body.
     */
    @GetMapping("/appel-offres")
    public ResponseEntity<List<AppelOffreDTO>> getAllAppelOffres(Pageable pageable) {
        log.debug("REST request to get a page of AppelOffres");
        Page<AppelOffreDTO> page = appelOffreService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /appel-offres/:id} : get the "id" appelOffre.
     *
     * @param id the id of the appelOffreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appelOffreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/appel-offres/{id}")
    public ResponseEntity<AppelOffreDTO> getAppelOffre(@PathVariable Long id) {
        log.debug("REST request to get AppelOffre : {}", id);
        Optional<AppelOffreDTO> appelOffreDTO = appelOffreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appelOffreDTO);
    }

    /**
     * {@code DELETE  /appel-offres/:id} : delete the "id" appelOffre.
     *
     * @param id the id of the appelOffreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/appel-offres/{id}")
    public ResponseEntity<Void> deleteAppelOffre(@PathVariable Long id) {
        log.debug("REST request to delete AppelOffre : {}", id);
        appelOffreService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
