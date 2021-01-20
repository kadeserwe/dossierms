package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.PiecesPlisOuvertureDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.PiecesPlisOuverture}.
 */
public interface PiecesPlisOuvertureService {

    /**
     * Save a piecesPlisOuverture.
     *
     * @param piecesPlisOuvertureDTO the entity to save.
     * @return the persisted entity.
     */
    PiecesPlisOuvertureDTO save(PiecesPlisOuvertureDTO piecesPlisOuvertureDTO);

    /**
     * Get all the piecesPlisOuvertures.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PiecesPlisOuvertureDTO> findAll(Pageable pageable);


    /**
     * Get the "id" piecesPlisOuverture.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PiecesPlisOuvertureDTO> findOne(Long id);

    /**
     * Delete the "id" piecesPlisOuverture.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
