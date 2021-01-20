package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.GarantiesSoumissionnaireDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GarantiesSoumissionnaire} and its DTO {@link GarantiesSoumissionnaireDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, GarantiesDossierMapper.class, PlisOuvertureMapper.class, NaturesGarantieMapper.class})
public interface GarantiesSoumissionnaireMapper extends EntityMapper<GarantiesSoumissionnaireDTO, GarantiesSoumissionnaire> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "garantiesDossier.id", target = "garantiesDossierId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "naturesGarantie.id", target = "naturesGarantieId")
    GarantiesSoumissionnaireDTO toDto(GarantiesSoumissionnaire garantiesSoumissionnaire);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "garantiesDossierId", target = "garantiesDossier")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "naturesGarantieId", target = "naturesGarantie")
    GarantiesSoumissionnaire toEntity(GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO);

    default GarantiesSoumissionnaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        GarantiesSoumissionnaire garantiesSoumissionnaire = new GarantiesSoumissionnaire();
        garantiesSoumissionnaire.setId(id);
        return garantiesSoumissionnaire;
    }
}
