package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DossiersCommissionsMarcheDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link DossiersCommissionsMarche} and its DTO {@link DossiersCommissionsMarcheDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, MembresCommissionsMarcheMapper.class})
public interface DossiersCommissionsMarcheMapper extends EntityMapper<DossiersCommissionsMarcheDTO, DossiersCommissionsMarche> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "membresCommissionsMarche.id", target = "membresCommissionsMarcheId")
    DossiersCommissionsMarcheDTO toDto(DossiersCommissionsMarche dossiersCommissionsMarche);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "membresCommissionsMarcheId", target = "membresCommissionsMarche")
    DossiersCommissionsMarche toEntity(DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO);

    default DossiersCommissionsMarche fromId(Long id) {
        if (id == null) {
            return null;
        }
        DossiersCommissionsMarche dossiersCommissionsMarche = new DossiersCommissionsMarche();
        dossiersCommissionsMarche.setId(id);
        return dossiersCommissionsMarche;
    }
}
