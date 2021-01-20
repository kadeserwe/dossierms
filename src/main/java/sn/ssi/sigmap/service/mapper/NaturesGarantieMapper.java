package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.NaturesGarantieDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NaturesGarantie} and its DTO {@link NaturesGarantieDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NaturesGarantieMapper extends EntityMapper<NaturesGarantieDTO, NaturesGarantie> {



    default NaturesGarantie fromId(Long id) {
        if (id == null) {
            return null;
        }
        NaturesGarantie naturesGarantie = new NaturesGarantie();
        naturesGarantie.setId(id);
        return naturesGarantie;
    }
}
