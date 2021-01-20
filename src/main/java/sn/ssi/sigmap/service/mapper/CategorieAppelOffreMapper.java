package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.CategorieAppelOffreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CategorieAppelOffre} and its DTO {@link CategorieAppelOffreDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategorieAppelOffreMapper extends EntityMapper<CategorieAppelOffreDTO, CategorieAppelOffre> {



    default CategorieAppelOffre fromId(Long id) {
        if (id == null) {
            return null;
        }
        CategorieAppelOffre categorieAppelOffre = new CategorieAppelOffre();
        categorieAppelOffre.setId(id);
        return categorieAppelOffre;
    }
}
