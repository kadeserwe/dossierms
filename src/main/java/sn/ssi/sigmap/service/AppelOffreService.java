package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.AppelOffreDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.AppelOffre}.
 */
public interface AppelOffreService {

    /**
     * Save a appelOffre.
     *
     * @param appelOffreDTO the entity to save.
     * @return the persisted entity.
     */
    AppelOffreDTO save(AppelOffreDTO appelOffreDTO);

    /**
     * Get all the appelOffres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AppelOffreDTO> findAll(Pageable pageable);


    /**
     * Get the "id" appelOffre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AppelOffreDTO> findOne(Long id);

    /**
     * Delete the "id" appelOffre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
