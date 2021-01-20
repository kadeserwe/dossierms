package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.PresenceOuvertureDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.PresenceOuverture}.
 */
public interface PresenceOuvertureService {

    /**
     * Save a presenceOuverture.
     *
     * @param presenceOuvertureDTO the entity to save.
     * @return the persisted entity.
     */
    PresenceOuvertureDTO save(PresenceOuvertureDTO presenceOuvertureDTO);

    /**
     * Get all the presenceOuvertures.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PresenceOuvertureDTO> findAll(Pageable pageable);


    /**
     * Get the "id" presenceOuverture.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PresenceOuvertureDTO> findOne(Long id);

    /**
     * Delete the "id" presenceOuverture.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
