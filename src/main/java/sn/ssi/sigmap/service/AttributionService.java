package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.AttributionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.Attribution}.
 */
public interface AttributionService {

    /**
     * Save a attribution.
     *
     * @param attributionDTO the entity to save.
     * @return the persisted entity.
     */
    AttributionDTO save(AttributionDTO attributionDTO);

    /**
     * Get all the attributions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AttributionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" attribution.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AttributionDTO> findOne(Long id);

    /**
     * Delete the "id" attribution.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
