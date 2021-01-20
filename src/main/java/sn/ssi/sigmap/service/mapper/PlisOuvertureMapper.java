package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.PlisOuvertureDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PlisOuverture} and its DTO {@link PlisOuvertureDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, RetraitRegistreDAOMapper.class, FournisseurMapper.class})
public interface PlisOuvertureMapper extends EntityMapper<PlisOuvertureDTO, PlisOuverture> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "retraitRegistreDAO.id", target = "retraitRegistreDAOId")
    @Mapping(source = "fournisseur.id", target = "fournisseurId")
    PlisOuvertureDTO toDto(PlisOuverture plisOuverture);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "retraitRegistreDAOId", target = "retraitRegistreDAO")
    @Mapping(source = "fournisseurId", target = "fournisseur")
    PlisOuverture toEntity(PlisOuvertureDTO plisOuvertureDTO);

    default PlisOuverture fromId(Long id) {
        if (id == null) {
            return null;
        }
        PlisOuverture plisOuverture = new PlisOuverture();
        plisOuverture.setId(id);
        return plisOuverture;
    }
}
