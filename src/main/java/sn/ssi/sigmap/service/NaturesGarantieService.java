package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.NaturesGarantieDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.NaturesGarantie}.
 */
public interface NaturesGarantieService {

    /**
     * Save a naturesGarantie.
     *
     * @param naturesGarantieDTO the entity to save.
     * @return the persisted entity.
     */
    NaturesGarantieDTO save(NaturesGarantieDTO naturesGarantieDTO);

    /**
     * Get all the naturesGaranties.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NaturesGarantieDTO> findAll(Pageable pageable);


    /**
     * Get the "id" naturesGarantie.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NaturesGarantieDTO> findOne(Long id);

    /**
     * Delete the "id" naturesGarantie.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
