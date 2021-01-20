package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DossiersEvaluateurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DossiersEvaluateur} and its DTO {@link DossiersEvaluateurDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class})
public interface DossiersEvaluateurMapper extends EntityMapper<DossiersEvaluateurDTO, DossiersEvaluateur> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    DossiersEvaluateurDTO toDto(DossiersEvaluateur dossiersEvaluateur);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    DossiersEvaluateur toEntity(DossiersEvaluateurDTO dossiersEvaluateurDTO);

    default DossiersEvaluateur fromId(Long id) {
        if (id == null) {
            return null;
        }
        DossiersEvaluateur dossiersEvaluateur = new DossiersEvaluateur();
        dossiersEvaluateur.setId(id);
        return dossiersEvaluateur;
    }
}
