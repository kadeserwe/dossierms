package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.CritereQualifiSoumDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.CritereQualifiSoum}.
 */
public interface CritereQualifiSoumService {

    /**
     * Save a critereQualifiSoum.
     *
     * @param critereQualifiSoumDTO the entity to save.
     * @return the persisted entity.
     */
    CritereQualifiSoumDTO save(CritereQualifiSoumDTO critereQualifiSoumDTO);

    /**
     * Get all the critereQualifiSoums.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CritereQualifiSoumDTO> findAll(Pageable pageable);


    /**
     * Get the "id" critereQualifiSoum.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CritereQualifiSoumDTO> findOne(Long id);

    /**
     * Delete the "id" critereQualifiSoum.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
