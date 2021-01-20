package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.PiecesRecus;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the PiecesRecus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PiecesRecusRepository extends JpaRepository<PiecesRecus, Long> {
}
