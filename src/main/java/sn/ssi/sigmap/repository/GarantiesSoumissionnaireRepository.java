package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.GarantiesSoumissionnaire;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GarantiesSoumissionnaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GarantiesSoumissionnaireRepository extends JpaRepository<GarantiesSoumissionnaire, Long> {
}
