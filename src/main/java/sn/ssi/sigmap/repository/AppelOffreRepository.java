package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.AppelOffre;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppelOffre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppelOffreRepository extends JpaRepository<AppelOffre, Long> {
}
