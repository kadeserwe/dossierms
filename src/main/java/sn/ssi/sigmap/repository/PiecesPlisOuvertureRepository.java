package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.PiecesPlisOuverture;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PiecesPlisOuverture entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PiecesPlisOuvertureRepository extends JpaRepository<PiecesPlisOuverture, Long> {
}
