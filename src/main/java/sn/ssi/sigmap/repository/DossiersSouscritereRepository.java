package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.DossiersSouscritere;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DossiersSouscritere entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DossiersSouscritereRepository extends JpaRepository<DossiersSouscritere, Long> {
}
