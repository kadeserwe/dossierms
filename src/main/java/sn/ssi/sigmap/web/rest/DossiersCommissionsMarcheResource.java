package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.DossiersCommissionsMarcheService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.DossiersCommissionsMarcheDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.DossiersCommissionsMarche}.
 */
@RestController
@RequestMapping("/api")
public class DossiersCommissionsMarcheResource {

    private final Logger log = LoggerFactory.getLogger(DossiersCommissionsMarcheResource.class);

    private static final String ENTITY_NAME = "dossiermsDossiersCommissionsMarche";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DossiersCommissionsMarcheService dossiersCommissionsMarcheService;

    public DossiersCommissionsMarcheResource(DossiersCommissionsMarcheService dossiersCommissionsMarcheService) {
        this.dossiersCommissionsMarcheService = dossiersCommissionsMarcheService;
    }

    /**
     * {@code POST  /dossiers-commissions-marches} : Create a new dossiersCommissionsMarche.
     *
     * @param dossiersCommissionsMarcheDTO the dossiersCommissionsMarcheDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dossiersCommissionsMarcheDTO, or with status {@code 400 (Bad Request)} if the dossiersCommissionsMarche has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dossiers-commissions-marches")
    public ResponseEntity<DossiersCommissionsMarcheDTO> createDossiersCommissionsMarche(@RequestBody DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO) throws URISyntaxException {
        log.debug("REST request to save DossiersCommissionsMarche : {}", dossiersCommissionsMarcheDTO);
        if (dossiersCommissionsMarcheDTO.getId() != null) {
            throw new BadRequestAlertException("A new dossiersCommissionsMarche cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DossiersCommissionsMarcheDTO result = dossiersCommissionsMarcheService.save(dossiersCommissionsMarcheDTO);
        return ResponseEntity.created(new URI("/api/dossiers-commissions-marches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dossiers-commissions-marches} : Updates an existing dossiersCommissionsMarche.
     *
     * @param dossiersCommissionsMarcheDTO the dossiersCommissionsMarcheDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dossiersCommissionsMarcheDTO,
     * or with status {@code 400 (Bad Request)} if the dossiersCommissionsMarcheDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dossiersCommissionsMarcheDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dossiers-commissions-marches")
    public ResponseEntity<DossiersCommissionsMarcheDTO> updateDossiersCommissionsMarche(@RequestBody DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO) throws URISyntaxException {
        log.debug("REST request to update DossiersCommissionsMarche : {}", dossiersCommissionsMarcheDTO);
        if (dossiersCommissionsMarcheDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DossiersCommissionsMarcheDTO result = dossiersCommissionsMarcheService.save(dossiersCommissionsMarcheDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, dossiersCommissionsMarcheDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dossiers-commissions-marches} : get all the dossiersCommissionsMarches.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dossiersCommissionsMarches in body.
     */
    @GetMapping("/dossiers-commissions-marches")
    public ResponseEntity<List<DossiersCommissionsMarcheDTO>> getAllDossiersCommissionsMarches(Pageable pageable) {
        log.debug("REST request to get a page of DossiersCommissionsMarches");
        Page<DossiersCommissionsMarcheDTO> page = dossiersCommissionsMarcheService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dossiers-commissions-marches/:id} : get the "id" dossiersCommissionsMarche.
     *
     * @param id the id of the dossiersCommissionsMarcheDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dossiersCommissionsMarcheDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dossiers-commissions-marches/{id}")
    public ResponseEntity<DossiersCommissionsMarcheDTO> getDossiersCommissionsMarche(@PathVariable Long id) {
        log.debug("REST request to get DossiersCommissionsMarche : {}", id);
        Optional<DossiersCommissionsMarcheDTO> dossiersCommissionsMarcheDTO = dossiersCommissionsMarcheService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dossiersCommissionsMarcheDTO);
    }

    /**
     * {@code DELETE  /dossiers-commissions-marches/:id} : delete the "id" dossiersCommissionsMarche.
     *
     * @param id the id of the dossiersCommissionsMarcheDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dossiers-commissions-marches/{id}")
    public ResponseEntity<Void> deleteDossiersCommissionsMarche(@PathVariable Long id) {
        log.debug("REST request to delete DossiersCommissionsMarche : {}", id);
        dossiersCommissionsMarcheService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
