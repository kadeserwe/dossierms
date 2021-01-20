package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DossiersEvaluateurDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.DossiersEvaluateur}.
 */
public interface DossiersEvaluateurService {

    /**
     * Save a dossiersEvaluateur.
     *
     * @param dossiersEvaluateurDTO the entity to save.
     * @return the persisted entity.
     */
    DossiersEvaluateurDTO save(DossiersEvaluateurDTO dossiersEvaluateurDTO);

    /**
     * Get all the dossiersEvaluateurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DossiersEvaluateurDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dossiersEvaluateur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DossiersEvaluateurDTO> findOne(Long id);

    /**
     * Delete the "id" dossiersEvaluateur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
