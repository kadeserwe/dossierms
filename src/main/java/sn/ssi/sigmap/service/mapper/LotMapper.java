package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.LotDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Lot} and its DTO {@link LotDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface LotMapper extends EntityMapper<LotDTO, Lot> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    LotDTO toDto(Lot lot);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    Lot toEntity(LotDTO lotDTO);

    default Lot fromId(Long id) {
        if (id == null) {
            return null;
        }
        Lot lot = new Lot();
        lot.setId(id);
        return lot;
    }
}
