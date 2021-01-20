package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.CategorieAppelOffreService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.CategorieAppelOffreDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.CategorieAppelOffre}.
 */
@RestController
@RequestMapping("/api")
public class CategorieAppelOffreResource {

    private final Logger log = LoggerFactory.getLogger(CategorieAppelOffreResource.class);

    private static final String ENTITY_NAME = "dossiermsCategorieAppelOffre";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CategorieAppelOffreService categorieAppelOffreService;

    public CategorieAppelOffreResource(CategorieAppelOffreService categorieAppelOffreService) {
        this.categorieAppelOffreService = categorieAppelOffreService;
    }

    /**
     * {@code POST  /categorie-appel-offres} : Create a new categorieAppelOffre.
     *
     * @param categorieAppelOffreDTO the categorieAppelOffreDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new categorieAppelOffreDTO, or with status {@code 400 (Bad Request)} if the categorieAppelOffre has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/categorie-appel-offres")
    public ResponseEntity<CategorieAppelOffreDTO> createCategorieAppelOffre(@RequestBody CategorieAppelOffreDTO categorieAppelOffreDTO) throws URISyntaxException {
        log.debug("REST request to save CategorieAppelOffre : {}", categorieAppelOffreDTO);
        if (categorieAppelOffreDTO.getId() != null) {
            throw new BadRequestAlertException("A new categorieAppelOffre cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CategorieAppelOffreDTO result = categorieAppelOffreService.save(categorieAppelOffreDTO);
        return ResponseEntity.created(new URI("/api/categorie-appel-offres/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /categorie-appel-offres} : Updates an existing categorieAppelOffre.
     *
     * @param categorieAppelOffreDTO the categorieAppelOffreDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated categorieAppelOffreDTO,
     * or with status {@code 400 (Bad Request)} if the categorieAppelOffreDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the categorieAppelOffreDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/categorie-appel-offres")
    public ResponseEntity<CategorieAppelOffreDTO> updateCategorieAppelOffre(@RequestBody CategorieAppelOffreDTO categorieAppelOffreDTO) throws URISyntaxException {
        log.debug("REST request to update CategorieAppelOffre : {}", categorieAppelOffreDTO);
        if (categorieAppelOffreDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CategorieAppelOffreDTO result = categorieAppelOffreService.save(categorieAppelOffreDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, categorieAppelOffreDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /categorie-appel-offres} : get all the categorieAppelOffres.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of categorieAppelOffres in body.
     */
    @GetMapping("/categorie-appel-offres")
    public ResponseEntity<List<CategorieAppelOffreDTO>> getAllCategorieAppelOffres(Pageable pageable) {
        log.debug("REST request to get a page of CategorieAppelOffres");
        Page<CategorieAppelOffreDTO> page = categorieAppelOffreService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /categorie-appel-offres/:id} : get the "id" categorieAppelOffre.
     *
     * @param id the id of the categorieAppelOffreDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the categorieAppelOffreDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/categorie-appel-offres/{id}")
    public ResponseEntity<CategorieAppelOffreDTO> getCategorieAppelOffre(@PathVariable Long id) {
        log.debug("REST request to get CategorieAppelOffre : {}", id);
        Optional<CategorieAppelOffreDTO> categorieAppelOffreDTO = categorieAppelOffreService.findOne(id);
        return ResponseUtil.wrapOrNotFound(categorieAppelOffreDTO);
    }

    /**
     * {@code DELETE  /categorie-appel-offres/:id} : delete the "id" categorieAppelOffre.
     *
     * @param id the id of the categorieAppelOffreDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/categorie-appel-offres/{id}")
    public ResponseEntity<Void> deleteCategorieAppelOffre(@PathVariable Long id) {
        log.debug("REST request to delete CategorieAppelOffre : {}", id);
        categorieAppelOffreService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
