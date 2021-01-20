package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.HistoriqueAppelOffresAC;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the HistoriqueAppelOffresAC entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HistoriqueAppelOffresACRepository extends JpaRepository<HistoriqueAppelOffresAC, Long> {
}
