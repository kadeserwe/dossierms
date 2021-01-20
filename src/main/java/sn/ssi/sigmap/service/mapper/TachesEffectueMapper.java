package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.TachesEffectueDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link TachesEffectue} and its DTO {@link TachesEffectueDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface TachesEffectueMapper extends EntityMapper<TachesEffectueDTO, TachesEffectue> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    TachesEffectueDTO toDto(TachesEffectue tachesEffectue);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    TachesEffectue toEntity(TachesEffectueDTO tachesEffectueDTO);

    default TachesEffectue fromId(Long id) {
        if (id == null) {
            return null;
        }
        TachesEffectue tachesEffectue = new TachesEffectue();
        tachesEffectue.setId(id);
        return tachesEffectue;
    }
}
