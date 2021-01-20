package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.GarantiesSoumissionnaireDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.GarantiesSoumissionnaire}.
 */
public interface GarantiesSoumissionnaireService {

    /**
     * Save a garantiesSoumissionnaire.
     *
     * @param garantiesSoumissionnaireDTO the entity to save.
     * @return the persisted entity.
     */
    GarantiesSoumissionnaireDTO save(GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO);

    /**
     * Get all the garantiesSoumissionnaires.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GarantiesSoumissionnaireDTO> findAll(Pageable pageable);


    /**
     * Get the "id" garantiesSoumissionnaire.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GarantiesSoumissionnaireDTO> findOne(Long id);

    /**
     * Delete the "id" garantiesSoumissionnaire.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
