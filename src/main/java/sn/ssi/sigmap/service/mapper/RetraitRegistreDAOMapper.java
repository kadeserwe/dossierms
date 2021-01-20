package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.RetraitRegistreDAODTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RetraitRegistreDAO} and its DTO {@link RetraitRegistreDAODTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, FournisseurMapper.class, PaysMapper.class})
public interface RetraitRegistreDAOMapper extends EntityMapper<RetraitRegistreDAODTO, RetraitRegistreDAO> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "fournisseur.id", target = "fournisseurId")
    @Mapping(source = "pays.id", target = "paysId")
    RetraitRegistreDAODTO toDto(RetraitRegistreDAO retraitRegistreDAO);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "fournisseurId", target = "fournisseur")
    @Mapping(source = "paysId", target = "pays")
    RetraitRegistreDAO toEntity(RetraitRegistreDAODTO retraitRegistreDAODTO);

    default RetraitRegistreDAO fromId(Long id) {
        if (id == null) {
            return null;
        }
        RetraitRegistreDAO retraitRegistreDAO = new RetraitRegistreDAO();
        retraitRegistreDAO.setId(id);
        return retraitRegistreDAO;
    }
}
