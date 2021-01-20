package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.DossiersCommissionsMarcheDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.DossiersCommissionsMarche}.
 */
public interface DossiersCommissionsMarcheService {

    /**
     * Save a dossiersCommissionsMarche.
     *
     * @param dossiersCommissionsMarcheDTO the entity to save.
     * @return the persisted entity.
     */
    DossiersCommissionsMarcheDTO save(DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO);

    /**
     * Get all the dossiersCommissionsMarches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<DossiersCommissionsMarcheDTO> findAll(Pageable pageable);


    /**
     * Get the "id" dossiersCommissionsMarche.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DossiersCommissionsMarcheDTO> findOne(Long id);

    /**
     * Delete the "id" dossiersCommissionsMarche.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
