package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.AvisAttributionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AvisAttribution} and its DTO {@link AvisAttributionDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, LotMapper.class})
public interface AvisAttributionMapper extends EntityMapper<AvisAttributionDTO, AvisAttribution> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "lot.id", target = "lotId")
    AvisAttributionDTO toDto(AvisAttribution avisAttribution);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "lotId", target = "lot")
    AvisAttribution toEntity(AvisAttributionDTO avisAttributionDTO);

    default AvisAttribution fromId(Long id) {
        if (id == null) {
            return null;
        }
        AvisAttribution avisAttribution = new AvisAttribution();
        avisAttribution.setId(id);
        return avisAttribution;
    }
}
