package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.RepresentantServTech;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RepresentantServTech entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RepresentantServTechRepository extends JpaRepository<RepresentantServTech, Long> {
}
