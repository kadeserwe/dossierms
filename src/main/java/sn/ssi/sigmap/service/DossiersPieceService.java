package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DossiersPieceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.DossiersPiece}.
 */
public interface DossiersPieceService {

    /**
     * Save a dossiersPiece.
     *
     * @param dossiersPieceDTO the entity to save.
     * @return the persisted entity.
     */
    DossiersPieceDTO save(DossiersPieceDTO dossiersPieceDTO);

    /**
     * Get all the dossiersPieces.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DossiersPieceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dossiersPiece.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DossiersPieceDTO> findOne(Long id);

    /**
     * Delete the "id" dossiersPiece.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
