package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PieceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Piece} and its DTO {@link PieceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PieceMapper extends EntityMapper<PieceDTO, Piece> {



    default Piece fromId(Long id) {
        if (id == null) {
            return null;
        }
        Piece piece = new Piece();
        piece.setId(id);
        return piece;
    }
}
