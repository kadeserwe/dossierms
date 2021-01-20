package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.DossierAppelOffreService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.DossierAppelOffreDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.DossierAppelOffre}.
 */
@RestController
@RequestMapping("/api")
public class DossierAppelOffreResource {

    private final Logger log = LoggerFactory.getLogger(DossierAppelOffreResource.class);

    private static final String ENTITY_NAME = "dossiermsDossierAppelOffre";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DossierAppelOffreService dossierAppelOffreService;

    public DossierAppelOffreResource(DossierAppelOffreService dossierAppelOffreService) {
        this.dossierAppelOffreService = dossierAppelOffreService;
    }

    /**
     * {@code POST  /dossier-appel-offres} : Create a new dossierAppelOffre.
     *
     * @param dossierAppelOffreDTO the dossierAppelOffreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dossierAppelOffreDTO, or with status {@code 400 (Bad Request)} if the dossierAppelOffre has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dossier-appel-offres")
    public ResponseEntity<DossierAppelOffreDTO> createDossierAppelOffre(@Valid @RequestBody DossierAppelOffreDTO dossierAppelOffreDTO) throws URISyntaxException {
        log.debug("REST request to save DossierAppelOffre : {}", dossierAppelOffreDTO);
        if (dossierAppelOffreDTO.getId() != null) {
            throw new BadRequestAlertException("A new dossierAppelOffre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DossierAppelOffreDTO result = dossierAppelOffreService.save(dossierAppelOffreDTO);
        return ResponseEntity.created(new URI("/api/dossier-appel-offres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dossier-appel-offres} : Updates an existing dossierAppelOffre.
     *
     * @param dossierAppelOffreDTO the dossierAppelOffreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dossierAppelOffreDTO,
     * or with status {@code 400 (Bad Request)} if the dossierAppelOffreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dossierAppelOffreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dossier-appel-offres")
    public ResponseEntity<DossierAppelOffreDTO> updateDossierAppelOffre(@Valid @RequestBody DossierAppelOffreDTO dossierAppelOffreDTO) throws URISyntaxException {
        log.debug("REST request to update DossierAppelOffre : {}", dossierAppelOffreDTO);
        if (dossierAppelOffreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DossierAppelOffreDTO result = dossierAppelOffreService.save(dossierAppelOffreDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dossierAppelOffreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dossier-appel-offres} : get all the dossierAppelOffres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dossierAppelOffres in body.
     */
    @GetMapping("/dossier-appel-offres")
    public ResponseEntity<List<DossierAppelOffreDTO>> getAllDossierAppelOffres(Pageable pageable) {
        log.debug("REST request to get a page of DossierAppelOffres");
        Page<DossierAppelOffreDTO> page = dossierAppelOffreService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dossier-appel-offres/:id} : get the "id" dossierAppelOffre.
     *
     * @param id the id of the dossierAppelOffreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dossierAppelOffreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dossier-appel-offres/{id}")
    public ResponseEntity<DossierAppelOffreDTO> getDossierAppelOffre(@PathVariable Long id) {
        log.debug("REST request to get DossierAppelOffre : {}", id);
        Optional<DossierAppelOffreDTO> dossierAppelOffreDTO = dossierAppelOffreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dossierAppelOffreDTO);
    }

    /**
     * {@code DELETE  /dossier-appel-offres/:id} : delete the "id" dossierAppelOffre.
     *
     * @param id the id of the dossierAppelOffreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dossier-appel-offres/{id}")
    public ResponseEntity<Void> deleteDossierAppelOffre(@PathVariable Long id) {
        log.debug("REST request to delete DossierAppelOffre : {}", id);
        dossierAppelOffreService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
