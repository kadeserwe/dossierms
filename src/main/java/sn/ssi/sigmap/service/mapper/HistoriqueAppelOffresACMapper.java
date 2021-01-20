package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.HistoriqueAppelOffresACDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link HistoriqueAppelOffresAC} and its DTO {@link HistoriqueAppelOffresACDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface HistoriqueAppelOffresACMapper extends EntityMapper<HistoriqueAppelOffresACDTO, HistoriqueAppelOffresAC> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    HistoriqueAppelOffresACDTO toDto(HistoriqueAppelOffresAC historiqueAppelOffresAC);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    HistoriqueAppelOffresAC toEntity(HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO);

    default HistoriqueAppelOffresAC fromId(Long id) {
        if (id == null) {
            return null;
        }
        HistoriqueAppelOffresAC historiqueAppelOffresAC = new HistoriqueAppelOffresAC();
        historiqueAppelOffresAC.setId(id);
        return historiqueAppelOffresAC;
    }
}
