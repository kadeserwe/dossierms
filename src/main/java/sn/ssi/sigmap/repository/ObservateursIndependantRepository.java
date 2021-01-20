package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.ObservateursIndependant;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ObservateursIndependant entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ObservateursIndependantRepository extends JpaRepository<ObservateursIndependant, Long> {
}
