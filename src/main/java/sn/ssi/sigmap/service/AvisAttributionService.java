package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.AvisAttributionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.AvisAttribution}.
 */
public interface AvisAttributionService {

    /**
     * Save a avisAttribution.
     *
     * @param avisAttributionDTO the entity to save.
     * @return the persisted entity.
     */
    AvisAttributionDTO save(AvisAttributionDTO avisAttributionDTO);

    /**
     * Get all the avisAttributions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AvisAttributionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" avisAttribution.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AvisAttributionDTO> findOne(Long id);

    /**
     * Delete the "id" avisAttribution.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
