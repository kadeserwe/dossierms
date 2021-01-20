package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.TachesEffectueDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.TachesEffectue}.
 */
public interface TachesEffectueService {

    /**
     * Save a tachesEffectue.
     *
     * @param tachesEffectueDTO the entity to save.
     * @return the persisted entity.
     */
    TachesEffectueDTO save(TachesEffectueDTO tachesEffectueDTO);

    /**
     * Get all the tachesEffectues.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TachesEffectueDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tachesEffectue.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TachesEffectueDTO> findOne(Long id);

    /**
     * Delete the "id" tachesEffectue.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
