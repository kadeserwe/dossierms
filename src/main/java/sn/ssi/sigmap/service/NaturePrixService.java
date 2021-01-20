package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.NaturePrixDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.NaturePrix}.
 */
public interface NaturePrixService {

    /**
     * Save a naturePrix.
     *
     * @param naturePrixDTO the entity to save.
     * @return the persisted entity.
     */
    NaturePrixDTO save(NaturePrixDTO naturePrixDTO);

    /**
     * Get all the naturePrixes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NaturePrixDTO> findAll(Pageable pageable);


    /**
     * Get the "id" naturePrix.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NaturePrixDTO> findOne(Long id);

    /**
     * Delete the "id" naturePrix.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
