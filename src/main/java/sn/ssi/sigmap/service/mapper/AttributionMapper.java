package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.AttributionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Attribution} and its DTO {@link AttributionDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, PlisOuvertureMapper.class, LotMapper.class})
public interface AttributionMapper extends EntityMapper<AttributionDTO, Attribution> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "lot.id", target = "lotId")
    AttributionDTO toDto(Attribution attribution);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "lotId", target = "lot")
    Attribution toEntity(AttributionDTO attributionDTO);

    default Attribution fromId(Long id) {
        if (id == null) {
            return null;
        }
        Attribution attribution = new Attribution();
        attribution.setId(id);
        return attribution;
    }
}
