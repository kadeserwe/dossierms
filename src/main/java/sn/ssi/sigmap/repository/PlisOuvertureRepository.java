package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.PlisOuverture;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PlisOuverture entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlisOuvertureRepository extends JpaRepository<PlisOuverture, Long> {
}
