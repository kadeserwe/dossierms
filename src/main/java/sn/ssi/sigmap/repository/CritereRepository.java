package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.Critere;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Critere entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CritereRepository extends JpaRepository<Critere, Long> {
}
