package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.LotsSoumissionnaireDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link LotsSoumissionnaire} and its DTO {@link LotsSoumissionnaireDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, LotMapper.class, PlisOuvertureMapper.class, MonnaieOffreMapper.class, NaturePrixMapper.class, PaysMapper.class})
public interface LotsSoumissionnaireMapper extends EntityMapper<LotsSoumissionnaireDTO, LotsSoumissionnaire> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "lot.id", target = "lotId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "monnaieOffre.id", target = "monnaieOffreId")
    @Mapping(source = "naturePrix.id", target = "naturePrixId")
    @Mapping(source = "pays.id", target = "paysId")
    LotsSoumissionnaireDTO toDto(LotsSoumissionnaire lotsSoumissionnaire);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "lotId", target = "lot")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "monnaieOffreId", target = "monnaieOffre")
    @Mapping(source = "naturePrixId", target = "naturePrix")
    @Mapping(source = "paysId", target = "pays")
    LotsSoumissionnaire toEntity(LotsSoumissionnaireDTO lotsSoumissionnaireDTO);

    default LotsSoumissionnaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        LotsSoumissionnaire lotsSoumissionnaire = new LotsSoumissionnaire();
        lotsSoumissionnaire.setId(id);
        return lotsSoumissionnaire;
    }
}
