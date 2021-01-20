package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.DossierAppelOffre;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DossierAppelOffre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DossierAppelOffreRepository extends JpaRepository<DossierAppelOffre, Long> {
}
