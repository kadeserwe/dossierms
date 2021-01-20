package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PresenceOuvertureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PresenceOuverture} and its DTO {@link PresenceOuvertureDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, AppelOffreMapper.class, PlisOuvertureMapper.class})
public interface PresenceOuvertureMapper extends EntityMapper<PresenceOuvertureDTO, PresenceOuverture> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "appelOffre.id", target = "appelOffreId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    PresenceOuvertureDTO toDto(PresenceOuverture presenceOuverture);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "appelOffreId", target = "appelOffre")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    PresenceOuverture toEntity(PresenceOuvertureDTO presenceOuvertureDTO);

    default PresenceOuverture fromId(Long id) {
        if (id == null) {
            return null;
        }
        PresenceOuverture presenceOuverture = new PresenceOuverture();
        presenceOuverture.setId(id);
        return presenceOuverture;
    }
}
