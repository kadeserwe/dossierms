package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.Attribution;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Attribution entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AttributionRepository extends JpaRepository<Attribution, Long> {
}
