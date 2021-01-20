package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.CritereQualifiSoumService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.CritereQualifiSoumDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.CritereQualifiSoum}.
 */
@RestController
@RequestMapping("/api")
public class CritereQualifiSoumResource {

    private final Logger log = LoggerFactory.getLogger(CritereQualifiSoumResource.class);

    private static final String ENTITY_NAME = "dossiermsCritereQualifiSoum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CritereQualifiSoumService critereQualifiSoumService;

    public CritereQualifiSoumResource(CritereQualifiSoumService critereQualifiSoumService) {
        this.critereQualifiSoumService = critereQualifiSoumService;
    }

    /**
     * {@code POST  /critere-qualifi-soums} : Create a new critereQualifiSoum.
     *
     * @param critereQualifiSoumDTO the critereQualifiSoumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new critereQualifiSoumDTO, or with status {@code 400 (Bad Request)} if the critereQualifiSoum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/critere-qualifi-soums")
    public ResponseEntity<CritereQualifiSoumDTO> createCritereQualifiSoum(@RequestBody CritereQualifiSoumDTO critereQualifiSoumDTO) throws URISyntaxException {
        log.debug("REST request to save CritereQualifiSoum : {}", critereQualifiSoumDTO);
        if (critereQualifiSoumDTO.getId() != null) {
            throw new BadRequestAlertException("A new critereQualifiSoum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CritereQualifiSoumDTO result = critereQualifiSoumService.save(critereQualifiSoumDTO);
        return ResponseEntity.created(new URI("/api/critere-qualifi-soums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /critere-qualifi-soums} : Updates an existing critereQualifiSoum.
     *
     * @param critereQualifiSoumDTO the critereQualifiSoumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated critereQualifiSoumDTO,
     * or with status {@code 400 (Bad Request)} if the critereQualifiSoumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the critereQualifiSoumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/critere-qualifi-soums")
    public ResponseEntity<CritereQualifiSoumDTO> updateCritereQualifiSoum(@RequestBody CritereQualifiSoumDTO critereQualifiSoumDTO) throws URISyntaxException {
        log.debug("REST request to update CritereQualifiSoum : {}", critereQualifiSoumDTO);
        if (critereQualifiSoumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CritereQualifiSoumDTO result = critereQualifiSoumService.save(critereQualifiSoumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, critereQualifiSoumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /critere-qualifi-soums} : get all the critereQualifiSoums.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of critereQualifiSoums in body.
     */
    @GetMapping("/critere-qualifi-soums")
    public ResponseEntity<List<CritereQualifiSoumDTO>> getAllCritereQualifiSoums(Pageable pageable) {
        log.debug("REST request to get a page of CritereQualifiSoums");
        Page<CritereQualifiSoumDTO> page = critereQualifiSoumService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /critere-qualifi-soums/:id} : get the "id" critereQualifiSoum.
     *
     * @param id the id of the critereQualifiSoumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the critereQualifiSoumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/critere-qualifi-soums/{id}")
    public ResponseEntity<CritereQualifiSoumDTO> getCritereQualifiSoum(@PathVariable Long id) {
        log.debug("REST request to get CritereQualifiSoum : {}", id);
        Optional<CritereQualifiSoumDTO> critereQualifiSoumDTO = critereQualifiSoumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(critereQualifiSoumDTO);
    }

    /**
     * {@code DELETE  /critere-qualifi-soums/:id} : delete the "id" critereQualifiSoum.
     *
     * @param id the id of the critereQualifiSoumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/critere-qualifi-soums/{id}")
    public ResponseEntity<Void> deleteCritereQualifiSoum(@PathVariable Long id) {
        log.debug("REST request to delete CritereQualifiSoum : {}", id);
        critereQualifiSoumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
