package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.NaturePrixDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link NaturePrix} and its DTO {@link NaturePrixDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NaturePrixMapper extends EntityMapper<NaturePrixDTO, NaturePrix> {



    default NaturePrix fromId(Long id) {
        if (id == null) {
            return null;
        }
        NaturePrix naturePrix = new NaturePrix();
        naturePrix.setId(id);
        return naturePrix;
    }
}
