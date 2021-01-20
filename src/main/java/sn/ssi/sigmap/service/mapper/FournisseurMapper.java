package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.FournisseurDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Fournisseur} and its DTO {@link FournisseurDTO}.
 */
@Mapper(componentModel = "spring", uses = {CatFournisseurMapper.class})
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {

    @Mapping(source = "catFournisseur.id", target = "catFournisseurId")
    FournisseurDTO toDto(Fournisseur fournisseur);

    @Mapping(source = "catFournisseurId", target = "catFournisseur")
    Fournisseur toEntity(FournisseurDTO fournisseurDTO);

    default Fournisseur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(id);
        return fournisseur;
    }
}
