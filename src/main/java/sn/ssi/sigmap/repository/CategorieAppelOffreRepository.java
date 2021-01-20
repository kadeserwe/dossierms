package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.CategorieAppelOffre;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CategorieAppelOffre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategorieAppelOffreRepository extends JpaRepository<CategorieAppelOffre, Long> {
}
