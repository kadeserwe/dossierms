package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.CritereDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Critere} and its DTO {@link CritereDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CritereMapper extends EntityMapper<CritereDTO, Critere> {



    default Critere fromId(Long id) {
        if (id == null) {
            return null;
        }
        Critere critere = new Critere();
        critere.setId(id);
        return critere;
    }
}
