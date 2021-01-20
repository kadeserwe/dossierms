package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.PiecesRecusDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.PiecesRecus}.
 */
public interface PiecesRecusService {

    /**
     * Save a piecesRecus.
     *
     * @param piecesRecusDTO the entity to save.
     * @return the persisted entity.
     */
    PiecesRecusDTO save(PiecesRecusDTO piecesRecusDTO);

    /**
     * Get all the piecesRecuses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PiecesRecusDTO> findAll(Pageable pageable);


    /**
     * Get the "id" piecesRecus.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PiecesRecusDTO> findOne(Long id);

    /**
     * Delete the "id" piecesRecus.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
