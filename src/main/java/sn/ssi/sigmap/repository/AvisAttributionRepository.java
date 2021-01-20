package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.AvisAttribution;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AvisAttribution entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AvisAttributionRepository extends JpaRepository<AvisAttribution, Long> {
}
