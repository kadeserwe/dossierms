package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.AppelOffreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppelOffre} and its DTO {@link AppelOffreDTO}.
 */
@Mapper(componentModel = "spring", uses = {CategorieAppelOffreMapper.class})
public interface AppelOffreMapper extends EntityMapper<AppelOffreDTO, AppelOffre> {

    @Mapping(source = "categorieAppelOffre.id", target = "categorieAppelOffreId")
    AppelOffreDTO toDto(AppelOffre appelOffre);

    @Mapping(source = "categorieAppelOffreId", target = "categorieAppelOffre")
    AppelOffre toEntity(AppelOffreDTO appelOffreDTO);

    default AppelOffre fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppelOffre appelOffre = new AppelOffre();
        appelOffre.setId(id);
        return appelOffre;
    }
}
