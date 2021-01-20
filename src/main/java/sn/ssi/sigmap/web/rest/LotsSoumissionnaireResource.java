package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.service.LotsSoumissionnaireService;
import sn.ssi.sigmap.web.rest.errors.BadRequestAlertException;
import sn.ssi.sigmap.service.dto.LotsSoumissionnaireDTO;

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
 * REST controller for managing {@link sn.ssi.sigmap.domain.LotsSoumissionnaire}.
 */
@RestController
@RequestMapping("/api")
public class LotsSoumissionnaireResource {

    private final Logger log = LoggerFactory.getLogger(LotsSoumissionnaireResource.class);

    private static final String ENTITY_NAME = "dossiermsLotsSoumissionnaire";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LotsSoumissionnaireService lotsSoumissionnaireService;

    public LotsSoumissionnaireResource(LotsSoumissionnaireService lotsSoumissionnaireService) {
        this.lotsSoumissionnaireService = lotsSoumissionnaireService;
    }

    /**
     * {@code POST  /lots-soumissionnaires} : Create a new lotsSoumissionnaire.
     *
     * @param lotsSoumissionnaireDTO the lotsSoumissionnaireDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new lotsSoumissionnaireDTO, or with status {@code 400 (Bad Request)} if the lotsSoumissionnaire has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/lots-soumissionnaires")
    public ResponseEntity<LotsSoumissionnaireDTO> createLotsSoumissionnaire(@RequestBody LotsSoumissionnaireDTO lotsSoumissionnaireDTO) throws URISyntaxException {
        log.debug("REST request to save LotsSoumissionnaire : {}", lotsSoumissionnaireDTO);
        if (lotsSoumissionnaireDTO.getId() != null) {
            throw new BadRequestAlertException("A new lotsSoumissionnaire cannot already have an ID", ENTITY_NAME, "idexists");
        }
        LotsSoumissionnaireDTO result = lotsSoumissionnaireService.save(lotsSoumissionnaireDTO);
        return ResponseEntity.created(new URI("/api/lots-soumissionnaires/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /lots-soumissionnaires} : Updates an existing lotsSoumissionnaire.
     *
     * @param lotsSoumissionnaireDTO the lotsSoumissionnaireDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated lotsSoumissionnaireDTO,
     * or with status {@code 400 (Bad Request)} if the lotsSoumissionnaireDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the lotsSoumissionnaireDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/lots-soumissionnaires")
    public ResponseEntity<LotsSoumissionnaireDTO> updateLotsSoumissionnaire(@RequestBody LotsSoumissionnaireDTO lotsSoumissionnaireDTO) throws URISyntaxException {
        log.debug("REST request to update LotsSoumissionnaire : {}", lotsSoumissionnaireDTO);
        if (lotsSoumissionnaireDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        LotsSoumissionnaireDTO result = lotsSoumissionnaireService.save(lotsSoumissionnaireDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, lotsSoumissionnaireDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /lots-soumissionnaires} : get all the lotsSoumissionnaires.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of lotsSoumissionnaires in body.
     */
    @GetMapping("/lots-soumissionnaires")
    public ResponseEntity<List<LotsSoumissionnaireDTO>> getAllLotsSoumissionnaires(Pageable pageable) {
        log.debug("REST request to get a page of LotsSoumissionnaires");
        Page<LotsSoumissionnaireDTO> page = lotsSoumissionnaireService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /lots-soumissionnaires/:id} : get the "id" lotsSoumissionnaire.
     *
     * @param id the id of the lotsSoumissionnaireDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the lotsSoumissionnaireDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/lots-soumissionnaires/{id}")
    public ResponseEntity<LotsSoumissionnaireDTO> getLotsSoumissionnaire(@PathVariable Long id) {
        log.debug("REST request to get LotsSoumissionnaire : {}", id);
        Optional<LotsSoumissionnaireDTO> lotsSoumissionnaireDTO = lotsSoumissionnaireService.findOne(id);
        return ResponseUtil.wrapOrNotFound(lotsSoumissionnaireDTO);
    }

    /**
     * {@code DELETE  /lots-soumissionnaires/:id} : delete the "id" lotsSoumissionnaire.
     *
     * @param id the id of the lotsSoumissionnaireDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/lots-soumissionnaires/{id}")
    public ResponseEntity<Void> deleteLotsSoumissionnaire(@PathVariable Long id) {
        log.debug("REST request to delete LotsSoumissionnaire : {}", id);
        lotsSoumissionnaireService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
