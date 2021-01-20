package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.LotsSoumissionnaireDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.LotsSoumissionnaire}.
 */
public interface LotsSoumissionnaireService {

    /**
     * Save a lotsSoumissionnaire.
     *
     * @param lotsSoumissionnaireDTO the entity to save.
     * @return the persisted entity.
     */
    LotsSoumissionnaireDTO save(LotsSoumissionnaireDTO lotsSoumissionnaireDTO);

    /**
     * Get all the lotsSoumissionnaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LotsSoumissionnaireDTO> findAll(Pageable pageable);


    /**
     * Get the "id" lotsSoumissionnaire.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LotsSoumissionnaireDTO> findOne(Long id);

    /**
     * Delete the "id" lotsSoumissionnaire.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
