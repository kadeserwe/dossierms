package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.DossiersEvaluateur;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DossiersEvaluateur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DossiersEvaluateurRepository extends JpaRepository<DossiersEvaluateur, Long> {
}
