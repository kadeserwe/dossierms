package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.CategorieAppelOffreDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.CategorieAppelOffre}.
 */
public interface CategorieAppelOffreService {

    /**
     * Save a categorieAppelOffre.
     *
     * @param categorieAppelOffreDTO the entity to save.
     * @return the persisted entity.
     */
    CategorieAppelOffreDTO save(CategorieAppelOffreDTO categorieAppelOffreDTO);

    /**
     * Get all the categorieAppelOffres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CategorieAppelOffreDTO> findAll(Pageable pageable);


    /**
     * Get the "id" categorieAppelOffre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategorieAppelOffreDTO> findOne(Long id);

    /**
     * Delete the "id" categorieAppelOffre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
