package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.MonnaieOffreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MonnaieOffre} and its DTO {@link MonnaieOffreDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MonnaieOffreMapper extends EntityMapper<MonnaieOffreDTO, MonnaieOffre> {



    default MonnaieOffre fromId(Long id) {
        if (id == null) {
            return null;
        }
        MonnaieOffre monnaieOffre = new MonnaieOffre();
        monnaieOffre.setId(id);
        return monnaieOffre;
    }
}
