package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DossiersPieceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DossiersPiece} and its DTO {@link DossiersPieceDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, PieceMapper.class})
public interface DossiersPieceMapper extends EntityMapper<DossiersPieceDTO, DossiersPiece> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "piece.id", target = "pieceId")
    DossiersPieceDTO toDto(DossiersPiece dossiersPiece);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "pieceId", target = "piece")
    DossiersPiece toEntity(DossiersPieceDTO dossiersPieceDTO);

    default DossiersPiece fromId(Long id) {
        if (id == null) {
            return null;
        }
        DossiersPiece dossiersPiece = new DossiersPiece();
        dossiersPiece.setId(id);
        return dossiersPiece;
    }
}
