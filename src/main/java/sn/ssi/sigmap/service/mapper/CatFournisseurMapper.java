package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.CatFournisseurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CatFournisseur} and its DTO {@link CatFournisseurDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CatFournisseurMapper extends EntityMapper<CatFournisseurDTO, CatFournisseur> {



    default CatFournisseur fromId(Long id) {
        if (id == null) {
            return null;
        }
        CatFournisseur catFournisseur = new CatFournisseur();
        catFournisseur.setId(id);
        return catFournisseur;
    }
}
