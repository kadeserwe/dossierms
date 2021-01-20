package sn.ssi.sigmap.service;

import sn.ssi.sigmap.service.dto.MembresCommissionsMarcheDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link sn.ssi.sigmap.domain.MembresCommissionsMarche}.
 */
public interface MembresCommissionsMarcheService {

    /**
     * Save a membresCommissionsMarche.
     *
     * @param membresCommissionsMarcheDTO the entity to save.
     * @return the persisted entity.
     */
    MembresCommissionsMarcheDTO save(MembresCommissionsMarcheDTO membresCommissionsMarcheDTO);

    /**
     * Get all the membresCommissionsMarches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MembresCommissionsMarcheDTO> findAll(Pageable pageable);


    /**
     * Get the "id" membresCommissionsMarche.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MembresCommissionsMarcheDTO> findOne(Long id);

    /**
     * Delete the "id" membresCommissionsMarche.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
