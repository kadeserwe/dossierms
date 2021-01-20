package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.GarantiesDossier;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GarantiesDossier entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GarantiesDossierRepository extends JpaRepository<GarantiesDossier, Long> {
}
