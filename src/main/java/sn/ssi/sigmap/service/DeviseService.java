package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DeviseDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.Devise}.
 */
public interface DeviseService {

    /**
     * Save a devise.
     *
     * @param deviseDTO the entity to save.
     * @return the persisted entity.
     */
    DeviseDTO save(DeviseDTO deviseDTO);

    /**
     * Get all the devises.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DeviseDTO> findAll(Pageable pageable);


    /**
     * Get the "id" devise.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DeviseDTO> findOne(Long id);

    /**
     * Delete the "id" devise.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
