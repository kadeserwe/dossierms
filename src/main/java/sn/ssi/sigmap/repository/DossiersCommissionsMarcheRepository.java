package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.DossiersCommissionsMarche;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DossiersCommissionsMarche entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DossiersCommissionsMarcheRepository extends JpaRepository<DossiersCommissionsMarche, Long> {
}
