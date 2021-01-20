package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.CatFournisseurDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.CatFournisseur}.
 */
public interface CatFournisseurService {

    /**
     * Save a catFournisseur.
     *
     * @param catFournisseurDTO the entity to save.
     * @return the persisted entity.
     */
    CatFournisseurDTO save(CatFournisseurDTO catFournisseurDTO);

    /**
     * Get all the catFournisseurs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CatFournisseurDTO> findAll(Pageable pageable);


    /**
     * Get the "id" catFournisseur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CatFournisseurDTO> findOne(Long id);

    /**
     * Delete the "id" catFournisseur.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
