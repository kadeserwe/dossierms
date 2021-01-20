package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.MonnaieOffreDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.MonnaieOffre}.
 */
public interface MonnaieOffreService {

    /**
     * Save a monnaieOffre.
     *
     * @param monnaieOffreDTO the entity to save.
     * @return the persisted entity.
     */
    MonnaieOffreDTO save(MonnaieOffreDTO monnaieOffreDTO);

    /**
     * Get all the monnaieOffres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MonnaieOffreDTO> findAll(Pageable pageable);


    /**
     * Get the "id" monnaieOffre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MonnaieOffreDTO> findOne(Long id);

    /**
     * Delete the "id" monnaieOffre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
