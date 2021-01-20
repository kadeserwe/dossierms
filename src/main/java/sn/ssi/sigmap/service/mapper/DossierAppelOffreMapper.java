package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DossierAppelOffreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DossierAppelOffre} and its DTO {@link DossierAppelOffreDTO}.
 */
@Mapper(componentModel = "spring", uses = {AppelOffreMapper.class})
public interface DossierAppelOffreMapper extends EntityMapper<DossierAppelOffreDTO, DossierAppelOffre> {

    @Mapping(source = "appelOffre.id", target = "appelOffreId")
    DossierAppelOffreDTO toDto(DossierAppelOffre dossierAppelOffre);

    @Mapping(source = "appelOffreId", target = "appelOffre")
    DossierAppelOffre toEntity(DossierAppelOffreDTO dossierAppelOffreDTO);

    default DossierAppelOffre fromId(Long id) {
        if (id == null) {
            return null;
        }
        DossierAppelOffre dossierAppelOffre = new DossierAppelOffre();
        dossierAppelOffre.setId(id);
        return dossierAppelOffre;
    }
}
