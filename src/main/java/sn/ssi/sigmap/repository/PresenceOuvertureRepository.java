package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.PresenceOuverture;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PresenceOuverture entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PresenceOuvertureRepository extends JpaRepository<PresenceOuverture, Long> {
}
