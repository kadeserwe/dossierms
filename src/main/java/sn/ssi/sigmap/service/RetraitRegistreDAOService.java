package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.RetraitRegistreDAODTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.RetraitRegistreDAO}.
 */
public interface RetraitRegistreDAOService {

    /**
     * Save a retraitRegistreDAO.
     *
     * @param retraitRegistreDAODTO the entity to save.
     * @return the persisted entity.
     */
    RetraitRegistreDAODTO save(RetraitRegistreDAODTO retraitRegistreDAODTO);

    /**
     * Get all the retraitRegistreDAOS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<RetraitRegistreDAODTO> findAll(Pageable pageable);


    /**
     * Get the "id" retraitRegistreDAO.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<RetraitRegistreDAODTO> findOne(Long id);

    /**
     * Delete the "id" retraitRegistreDAO.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
