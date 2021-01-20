package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.CatFournisseur;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CatFournisseur entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CatFournisseurRepository extends JpaRepository<CatFournisseur, Long> {
}
