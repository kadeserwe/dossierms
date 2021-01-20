package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DossiersSouscritereDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DossiersSouscritere} and its DTO {@link DossiersSouscritereDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, LotMapper.class, CritereMapper.class})
public interface DossiersSouscritereMapper extends EntityMapper<DossiersSouscritereDTO, DossiersSouscritere> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "lot.id", target = "lotId")
    @Mapping(source = "critere.id", target = "critereId")
    DossiersSouscritereDTO toDto(DossiersSouscritere dossiersSouscritere);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "lotId", target = "lot")
    @Mapping(source = "critereId", target = "critere")
    DossiersSouscritere toEntity(DossiersSouscritereDTO dossiersSouscritereDTO);

    default DossiersSouscritere fromId(Long id) {
        if (id == null) {
            return null;
        }
        DossiersSouscritere dossiersSouscritere = new DossiersSouscritere();
        dossiersSouscritere.setId(id);
        return dossiersSouscritere;
    }
}
