package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.CritereQualifiSoum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CritereQualifiSoum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CritereQualifiSoumRepository extends JpaRepository<CritereQualifiSoum, Long> {
}
