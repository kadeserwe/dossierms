package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.ObservateursIndependantDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.ObservateursIndependant}.
 */
public interface ObservateursIndependantService {

    /**
     * Save a observateursIndependant.
     *
     * @param observateursIndependantDTO the entity to save.
     * @return the persisted entity.
     */
    ObservateursIndependantDTO save(ObservateursIndependantDTO observateursIndependantDTO);

    /**
     * Get all the observateursIndependants.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ObservateursIndependantDTO> findAll(Pageable pageable);


    /**
     * Get the "id" observateursIndependant.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ObservateursIndependantDTO> findOne(Long id);

    /**
     * Delete the "id" observateursIndependant.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
