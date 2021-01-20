package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.ObservateursIndependantDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ObservateursIndependant} and its DTO {@link ObservateursIndependantDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface ObservateursIndependantMapper extends EntityMapper<ObservateursIndependantDTO, ObservateursIndependant> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    ObservateursIndependantDTO toDto(ObservateursIndependant observateursIndependant);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    ObservateursIndependant toEntity(ObservateursIndependantDTO observateursIndependantDTO);

    default ObservateursIndependant fromId(Long id) {
        if (id == null) {
            return null;
        }
        ObservateursIndependant observateursIndependant = new ObservateursIndependant();
        observateursIndependant.setId(id);
        return observateursIndependant;
    }
}
