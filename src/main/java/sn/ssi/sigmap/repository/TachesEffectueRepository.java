package sn.ssi.sigmap.repository;

import sn.ssi.sigmap.domain.TachesEffectue;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the TachesEffectue entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TachesEffectueRepository extends JpaRepository<TachesEffectue, Long> {
}
