package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.MembresCommissionsMarcheDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MembresCommissionsMarche} and its DTO {@link MembresCommissionsMarcheDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MembresCommissionsMarcheMapper extends EntityMapper<MembresCommissionsMarcheDTO, MembresCommissionsMarche> {



    default MembresCommissionsMarche fromId(Long id) {
        if (id == null) {
            return null;
        }
        MembresCommissionsMarche membresCommissionsMarche = new MembresCommissionsMarche();
        membresCommissionsMarche.setId(id);
        return membresCommissionsMarche;
    }
}
