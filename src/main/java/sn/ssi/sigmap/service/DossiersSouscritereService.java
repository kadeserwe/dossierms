package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DossiersSouscritereDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.DossiersSouscritere}.
 */
public interface DossiersSouscritereService {

    /**
     * Save a dossiersSouscritere.
     *
     * @param dossiersSouscritereDTO the entity to save.
     * @return the persisted entity.
     */
    DossiersSouscritereDTO save(DossiersSouscritereDTO dossiersSouscritereDTO);

    /**
     * Get all the dossiersSouscriteres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DossiersSouscritereDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dossiersSouscritere.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DossiersSouscritereDTO> findOne(Long id);

    /**
     * Delete the "id" dossiersSouscritere.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
