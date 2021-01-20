package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.RetraitRegistreDAO;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RetraitRegistreDAO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RetraitRegistreDAORepository extends JpaRepository<RetraitRegistreDAO, Long> {
}
