package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.DossiersPiece;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DossiersPiece entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DossiersPieceRepository extends JpaRepository<DossiersPiece, Long> {
}
