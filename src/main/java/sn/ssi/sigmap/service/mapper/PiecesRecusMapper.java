package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PiecesRecusDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PiecesRecus} and its DTO {@link PiecesRecusDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PiecesRecusMapper extends EntityMapper<PiecesRecusDTO, PiecesRecus> {



    default PiecesRecus fromId(Long id) {
        if (id == null) {
            return null;
        }
        PiecesRecus piecesRecus = new PiecesRecus();
        piecesRecus.setId(id);
        return piecesRecus;
    }
}
