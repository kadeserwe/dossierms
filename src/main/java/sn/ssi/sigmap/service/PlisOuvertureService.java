package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.PlisOuvertureDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.PlisOuverture}.
 */
public interface PlisOuvertureService {

    /**
     * Save a plisOuverture.
     *
     * @param plisOuvertureDTO the entity to save.
     * @return the persisted entity.
     */
    PlisOuvertureDTO save(PlisOuvertureDTO plisOuvertureDTO);

    /**
     * Get all the plisOuvertures.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PlisOuvertureDTO> findAll(Pageable pageable);


    /**
     * Get the "id" plisOuverture.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PlisOuvertureDTO> findOne(Long id);

    /**
     * Delete the "id" plisOuverture.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
