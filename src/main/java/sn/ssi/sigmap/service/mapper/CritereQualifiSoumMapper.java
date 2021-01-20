package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.CritereQualifiSoumDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CritereQualifiSoum} and its DTO {@link CritereQualifiSoumDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, PlisOuvertureMapper.class, LotMapper.class, DossiersSouscritereMapper.class})
public interface CritereQualifiSoumMapper extends EntityMapper<CritereQualifiSoumDTO, CritereQualifiSoum> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "lot.id", target = "lotId")
    @Mapping(source = "dossiersSosuscritere.id", target = "dossiersSosuscritereId")
    CritereQualifiSoumDTO toDto(CritereQualifiSoum critereQualifiSoum);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "lotId", target = "lot")
    @Mapping(source = "dossiersSosuscritereId", target = "dossiersSosuscritere")
    CritereQualifiSoum toEntity(CritereQualifiSoumDTO critereQualifiSoumDTO);

    default CritereQualifiSoum fromId(Long id) {
        if (id == null) {
            return null;
        }
        CritereQualifiSoum critereQualifiSoum = new CritereQualifiSoum();
        critereQualifiSoum.setId(id);
        return critereQualifiSoum;
    }
}
