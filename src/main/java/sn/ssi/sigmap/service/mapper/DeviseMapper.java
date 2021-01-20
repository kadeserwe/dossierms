package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DeviseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Devise} and its DTO {@link DeviseDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, MonnaieOffreMapper.class})
public interface DeviseMapper extends EntityMapper<DeviseDTO, Devise> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "monnaieOffre.id", target = "monnaieOffreId")
    DeviseDTO toDto(Devise devise);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "monnaieOffreId", target = "monnaieOffre")
    Devise toEntity(DeviseDTO deviseDTO);

    default Devise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Devise devise = new Devise();
        devise.setId(id);
        return devise;
    }
}
