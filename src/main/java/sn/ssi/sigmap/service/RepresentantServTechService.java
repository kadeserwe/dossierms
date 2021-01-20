package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.RepresentantServTechDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.RepresentantServTech}.
 */
public interface RepresentantServTechService {

    /**
     * Save a representantServTech.
     *
     * @param representantServTechDTO the entity to save.
     * @return the persisted entity.
     */
    RepresentantServTechDTO save(RepresentantServTechDTO representantServTechDTO);

    /**
     * Get all the representantServTeches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RepresentantServTechDTO> findAll(Pageable pageable);


    /**
     * Get the "id" representantServTech.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RepresentantServTechDTO> findOne(Long id);

    /**
     * Delete the "id" representantServTech.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
