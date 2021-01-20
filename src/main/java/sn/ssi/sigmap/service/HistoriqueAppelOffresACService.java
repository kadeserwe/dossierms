package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.HistoriqueAppelOffresACDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.HistoriqueAppelOffresAC}.
 */
public interface HistoriqueAppelOffresACService {

    /**
     * Save a historiqueAppelOffresAC.
     *
     * @param historiqueAppelOffresACDTO the entity to save.
     * @return the persisted entity.
     */
    HistoriqueAppelOffresACDTO save(HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO);

    /**
     * Get all the historiqueAppelOffresACS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<HistoriqueAppelOffresACDTO> findAll(Pageable pageable);


    /**
     * Get the "id" historiqueAppelOffresAC.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<HistoriqueAppelOffresACDTO> findOne(Long id);

    /**
     * Delete the "id" historiqueAppelOffresAC.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
