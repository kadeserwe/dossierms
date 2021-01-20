package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DossierAppelOffreDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.DossierAppelOffre}.
 */
public interface DossierAppelOffreService {

    /**
     * Save a dossierAppelOffre.
     *
     * @param dossierAppelOffreDTO the entity to save.
     * @return the persisted entity.
     */
    DossierAppelOffreDTO save(DossierAppelOffreDTO dossierAppelOffreDTO);

    /**
     * Get all the dossierAppelOffres.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DossierAppelOffreDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dossierAppelOffre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DossierAppelOffreDTO> findOne(Long id);

    /**
     * Delete the "id" dossierAppelOffre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
