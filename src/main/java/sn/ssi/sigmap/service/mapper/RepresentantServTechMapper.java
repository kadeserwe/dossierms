package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.RepresentantServTechDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RepresentantServTech} and its DTO {@link RepresentantServTechDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface RepresentantServTechMapper extends EntityMapper<RepresentantServTechDTO, RepresentantServTech> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    RepresentantServTechDTO toDto(RepresentantServTech representantServTech);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    RepresentantServTech toEntity(RepresentantServTechDTO representantServTechDTO);

    default RepresentantServTech fromId(Long id) {
        if (id == null) {
            return null;
        }
        RepresentantServTech representantServTech = new RepresentantServTech();
        representantServTech.setId(id);
        return representantServTech;
    }
}
