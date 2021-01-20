package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.RetraitRegistreDAOService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.RetraitRegistreDAODTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.RetraitRegistreDAO}.
 */
@RestController
@RequestMapping("/api")
public class RetraitRegistreDAOResource {

    private final Logger log = LoggerFactory.getLogger(RetraitRegistreDAOResource.class);

    private static final String ENTITY_NAME = "dossiermsRetraitRegistreDao";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RetraitRegistreDAOService retraitRegistreDAOService;

    public RetraitRegistreDAOResource(RetraitRegistreDAOService retraitRegistreDAOService) {
        this.retraitRegistreDAOService = retraitRegistreDAOService;
    }

    /**
     * {@code POST  /retrait-registre-daos} : Create a new retraitRegistreDAO.
     *
     * @param retraitRegistreDAODTO the retraitRegistreDAODTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new retraitRegistreDAODTO, or with status {@code 400 (Bad Request)} if the retraitRegistreDAO has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/retrait-registre-daos")
    public ResponseEntity<RetraitRegistreDAODTO> createRetraitRegistreDAO(@RequestBody RetraitRegistreDAODTO retraitRegistreDAODTO) throws URISyntaxException {
        log.debug("REST request to save RetraitRegistreDAO : {}", retraitRegistreDAODTO);
        if (retraitRegistreDAODTO.getId() != null) {
            throw new BadRequestAlertException("A new retraitRegistreDAO cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RetraitRegistreDAODTO result = retraitRegistreDAOService.save(retraitRegistreDAODTO);
        return ResponseEntity.created(new URI("/api/retrait-registre-daos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /retrait-registre-daos} : Updates an existing retraitRegistreDAO.
     *
     * @param retraitRegistreDAODTO the retraitRegistreDAODTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated retraitRegistreDAODTO,
     * or with status {@code 400 (Bad Request)} if the retraitRegistreDAODTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the retraitRegistreDAODTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/retrait-registre-daos")
    public ResponseEntity<RetraitRegistreDAODTO> updateRetraitRegistreDAO(@RequestBody RetraitRegistreDAODTO retraitRegistreDAODTO) throws URISyntaxException {
        log.debug("REST request to update RetraitRegistreDAO : {}", retraitRegistreDAODTO);
        if (retraitRegistreDAODTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RetraitRegistreDAODTO result = retraitRegistreDAOService.save(retraitRegistreDAODTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, retraitRegistreDAODTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /retrait-registre-daos} : get all the retraitRegistreDAOS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of retraitRegistreDAOS in body.
     */
    @GetMapping("/retrait-registre-daos")
    public ResponseEntity<List<RetraitRegistreDAODTO>> getAllRetraitRegistreDAOS(Pageable pageable) {
        log.debug("REST request to get a page of RetraitRegistreDAOS");
        Page<RetraitRegistreDAODTO> page = retraitRegistreDAOService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /retrait-registre-daos/:id} : get the "id" retraitRegistreDAO.
     *
     * @param id the id of the retraitRegistreDAODTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the retraitRegistreDAODTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/retrait-registre-daos/{id}")
    public ResponseEntity<RetraitRegistreDAODTO> getRetraitRegistreDAO(@PathVariable Long id) {
        log.debug("REST request to get RetraitRegistreDAO : {}", id);
        Optional<RetraitRegistreDAODTO> retraitRegistreDAODTO = retraitRegistreDAOService.findOne(id);
        return ResponseUtil.wrapOrNotFound(retraitRegistreDAODTO);
    }

    /**
     * {@code DELETE  /retrait-registre-daos/:id} : delete the "id" retraitRegistreDAO.
     *
     * @param id the id of the retraitRegistreDAODTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/retrait-registre-daos/{id}")
    public ResponseEntity<Void> deleteRetraitRegistreDAO(@PathVariable Long id) {
        log.debug("REST request to delete RetraitRegistreDAO : {}", id);
        retraitRegistreDAOService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
