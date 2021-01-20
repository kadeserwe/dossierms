package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.NaturePrix;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the NaturePrix entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NaturePrixRepository extends JpaRepository<NaturePrix, Long> {
}
