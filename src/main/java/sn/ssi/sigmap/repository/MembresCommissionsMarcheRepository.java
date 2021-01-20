package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.MembresCommissionsMarche;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MembresCommissionsMarche entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MembresCommissionsMarcheRepository extends JpaRepository<MembresCommissionsMarche, Long> {
}
