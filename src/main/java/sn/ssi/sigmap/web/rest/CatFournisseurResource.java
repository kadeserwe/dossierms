package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.CatFournisseurService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.CatFournisseurDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.CatFournisseur}.
 */
@RestController
@RequestMapping("/api")
public class CatFournisseurResource {

    private final Logger log = LoggerFactory.getLogger(CatFournisseurResource.class);

    private static final String ENTITY_NAME = "dossiermsCatFournisseur";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CatFournisseurService catFournisseurService;

    public CatFournisseurResource(CatFournisseurService catFournisseurService) {
        this.catFournisseurService = catFournisseurService;
    }

    /**
     * {@code POST  /cat-fournisseurs} : Create a new catFournisseur.
     *
     * @param catFournisseurDTO the catFournisseurDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new catFournisseurDTO, or with status {@code 400 (Bad Request)} if the catFournisseur has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cat-fournisseurs")
    public ResponseEntity<CatFournisseurDTO> createCatFournisseur(@RequestBody CatFournisseurDTO catFournisseurDTO) throws URISyntaxException {
        log.debug("REST request to save CatFournisseur : {}", catFournisseurDTO);
        if (catFournisseurDTO.getId() != null) {
            throw new BadRequestAlertException("A new catFournisseur cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CatFournisseurDTO result = catFournisseurService.save(catFournisseurDTO);
        return ResponseEntity.created(new URI("/api/cat-fournisseurs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cat-fournisseurs} : Updates an existing catFournisseur.
     *
     * @param catFournisseurDTO the catFournisseurDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated catFournisseurDTO,
     * or with status {@code 400 (Bad Request)} if the catFournisseurDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the catFournisseurDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cat-fournisseurs")
    public ResponseEntity<CatFournisseurDTO> updateCatFournisseur(@RequestBody CatFournisseurDTO catFournisseurDTO) throws URISyntaxException {
        log.debug("REST request to update CatFournisseur : {}", catFournisseurDTO);
        if (catFournisseurDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CatFournisseurDTO result = catFournisseurService.save(catFournisseurDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, catFournisseurDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cat-fournisseurs} : get all the catFournisseurs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of catFournisseurs in body.
     */
    @GetMapping("/cat-fournisseurs")
    public ResponseEntity<List<CatFournisseurDTO>> getAllCatFournisseurs(Pageable pageable) {
        log.debug("REST request to get a page of CatFournisseurs");
        Page<CatFournisseurDTO> page = catFournisseurService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cat-fournisseurs/:id} : get the "id" catFournisseur.
     *
     * @param id the id of the catFournisseurDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the catFournisseurDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cat-fournisseurs/{id}")
    public ResponseEntity<CatFournisseurDTO> getCatFournisseur(@PathVariable Long id) {
        log.debug("REST request to get CatFournisseur : {}", id);
        Optional<CatFournisseurDTO> catFournisseurDTO = catFournisseurService.findOne(id);
        return ResponseUtil.wrapOrNotFound(catFournisseurDTO);
    }

    /**
     * {@code DELETE  /cat-fournisseurs/:id} : delete the "id" catFournisseur.
     *
     * @param id the id of the catFournisseurDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cat-fournisseurs/{id}")
    public ResponseEntity<Void> deleteCatFournisseur(@PathVariable Long id) {
        log.debug("REST request to delete CatFournisseur : {}", id);
        catFournisseurService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
