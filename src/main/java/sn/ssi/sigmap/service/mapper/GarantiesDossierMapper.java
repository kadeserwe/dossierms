package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.GarantiesDossierDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GarantiesDossier} and its DTO {@link GarantiesDossierDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, LotMapper.class, PiecesRecusMapper.class})
public interface GarantiesDossierMapper extends EntityMapper<GarantiesDossierDTO, GarantiesDossier> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "lot.id", target = "lotId")
    @Mapping(source = "piecesRecus.id", target = "piecesRecusId")
    GarantiesDossierDTO toDto(GarantiesDossier garantiesDossier);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "lotId", target = "lot")
    @Mapping(source = "piecesRecusId", target = "piecesRecus")
    GarantiesDossier toEntity(GarantiesDossierDTO garantiesDossierDTO);

    default GarantiesDossier fromId(Long id) {
        if (id == null) {
            return null;
        }
        GarantiesDossier garantiesDossier = new GarantiesDossier();
        garantiesDossier.setId(id);
        return garantiesDossier;
    }
}
