package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.GarantiesDossierDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.GarantiesDossier}.
 */
public interface GarantiesDossierService {

    /**
     * Save a garantiesDossier.
     *
     * @param garantiesDossierDTO the entity to save.
     * @return the persisted entity.
     */
    GarantiesDossierDTO save(GarantiesDossierDTO garantiesDossierDTO);

    /**
     * Get all the garantiesDossiers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GarantiesDossierDTO> findAll(Pageable pageable);


    /**
     * Get the "id" garantiesDossier.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GarantiesDossierDTO> findOne(Long id);

    /**
     * Delete the "id" garantiesDossier.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
