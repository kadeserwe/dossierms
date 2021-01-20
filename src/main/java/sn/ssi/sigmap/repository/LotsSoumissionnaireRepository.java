package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.LotsSoumissionnaire;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the LotsSoumissionnaire entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LotsSoumissionnaireRepository extends JpaRepository<LotsSoumissionnaire, Long> {
}
