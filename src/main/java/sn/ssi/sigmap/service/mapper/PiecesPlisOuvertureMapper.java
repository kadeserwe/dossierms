package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PiecesPlisOuvertureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PiecesPlisOuverture} and its DTO {@link PiecesPlisOuvertureDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, PlisOuvertureMapper.class, PieceMapper.class})
public interface PiecesPlisOuvertureMapper extends EntityMapper<PiecesPlisOuvertureDTO, PiecesPlisOuverture> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "piece.id", target = "pieceId")
    PiecesPlisOuvertureDTO toDto(PiecesPlisOuverture piecesPlisOuverture);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "pieceId", target = "piece")
    PiecesPlisOuverture toEntity(PiecesPlisOuvertureDTO piecesPlisOuvertureDTO);

    default PiecesPlisOuverture fromId(Long id) {
        if (id == null) {
            return null;
        }
        PiecesPlisOuverture piecesPlisOuverture = new PiecesPlisOuverture();
        piecesPlisOuverture.setId(id);
        return piecesPlisOuverture;
    }
}
