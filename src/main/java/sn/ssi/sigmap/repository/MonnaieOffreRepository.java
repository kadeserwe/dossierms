package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.MonnaieOffre;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MonnaieOffre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MonnaieOffreRepository extends JpaRepository<MonnaieOffre, Long> {
}
