package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.HistoriqueAppelOffresACService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.HistoriqueAppelOffresACDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.HistoriqueAppelOffresAC}.
 */
@RestController
@RequestMapping("/api")
public class HistoriqueAppelOffresACResource {

    private final Logger log = LoggerFactory.getLogger(HistoriqueAppelOffresACResource.class);

    private static final String ENTITY_NAME = "dossiermsHistoriqueAppelOffresAc";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HistoriqueAppelOffresACService historiqueAppelOffresACService;

    public HistoriqueAppelOffresACResource(HistoriqueAppelOffresACService historiqueAppelOffresACService) {
        this.historiqueAppelOffresACService = historiqueAppelOffresACService;
    }

    /**
     * {@code POST  /historique-appel-offres-acs} : Create a new historiqueAppelOffresAC.
     *
     * @param historiqueAppelOffresACDTO the historiqueAppelOffresACDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new historiqueAppelOffresACDTO, or with status {@code 400 (Bad Request)} if the historiqueAppelOffresAC has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/historique-appel-offres-acs")
    public ResponseEntity<HistoriqueAppelOffresACDTO> createHistoriqueAppelOffresAC(@RequestBody HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO) throws URISyntaxException {
        log.debug("REST request to save HistoriqueAppelOffresAC : {}", historiqueAppelOffresACDTO);
        if (historiqueAppelOffresACDTO.getId() != null) {
            throw new BadRequestAlertException("A new historiqueAppelOffresAC cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HistoriqueAppelOffresACDTO result = historiqueAppelOffresACService.save(historiqueAppelOffresACDTO);
        return ResponseEntity.created(new URI("/api/historique-appel-offres-acs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /historique-appel-offres-acs} : Updates an existing historiqueAppelOffresAC.
     *
     * @param historiqueAppelOffresACDTO the historiqueAppelOffresACDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated historiqueAppelOffresACDTO,
     * or with status {@code 400 (Bad Request)} if the historiqueAppelOffresACDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the historiqueAppelOffresACDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/historique-appel-offres-acs")
    public ResponseEntity<HistoriqueAppelOffresACDTO> updateHistoriqueAppelOffresAC(@RequestBody HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO) throws URISyntaxException {
        log.debug("REST request to update HistoriqueAppelOffresAC : {}", historiqueAppelOffresACDTO);
        if (historiqueAppelOffresACDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HistoriqueAppelOffresACDTO result = historiqueAppelOffresACService.save(historiqueAppelOffresACDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, historiqueAppelOffresACDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /historique-appel-offres-acs} : get all the historiqueAppelOffresACS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of historiqueAppelOffresACS in body.
     */
    @GetMapping("/historique-appel-offres-acs")
    public ResponseEntity<List<HistoriqueAppelOffresACDTO>> getAllHistoriqueAppelOffresACS(Pageable pageable) {
        log.debug("REST request to get a page of HistoriqueAppelOffresACS");
        Page<HistoriqueAppelOffresACDTO> page = historiqueAppelOffresACService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /historique-appel-offres-acs/:id} : get the "id" historiqueAppelOffresAC.
     *
     * @param id the id of the historiqueAppelOffresACDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the historiqueAppelOffresACDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/historique-appel-offres-acs/{id}")
    public ResponseEntity<HistoriqueAppelOffresACDTO> getHistoriqueAppelOffresAC(@PathVariable Long id) {
        log.debug("REST request to get HistoriqueAppelOffresAC : {}", id);
        Optional<HistoriqueAppelOffresACDTO> historiqueAppelOffresACDTO = historiqueAppelOffresACService.findOne(id);
        return ResponseUtil.wrapOrNotFound(historiqueAppelOffresACDTO);
    }

    /**
     * {@code DELETE  /historique-appel-offres-acs/:id} : delete the "id" historiqueAppelOffresAC.
     *
     * @param id the id of the historiqueAppelOffresACDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/historique-appel-offres-acs/{id}")
    public ResponseEntity<Void> deleteHistoriqueAppelOffresAC(@PathVariable Long id) {
        log.debug("REST request to delete HistoriqueAppelOffresAC : {}", id);
        historiqueAppelOffresACService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
