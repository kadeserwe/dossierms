package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.CritereDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.Critere}.
 */
public interface CritereService {

    /**
     * Save a critere.
     *
     * @param critereDTO the entity to save.
     * @return the persisted entity.
     */
    CritereDTO save(CritereDTO critereDTO);

    /**
     * Get all the criteres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CritereDTO> findAll(Pageable pageable);


    /**
     * Get the "id" critere.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CritereDTO> findOne(Long id);

    /**
     * Delete the "id" critere.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
