package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.ContratDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Contrat} and its DTO {@link ContratDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, LotMapper.class, FournisseurMapper.class, PlisOuvertureMapper.class})
public interface ContratMapper extends EntityMapper<ContratDTO, Contrat> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "lot.id", target = "lotId")
    @Mapping(source = "fournisseur.id", target = "fournisseurId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    ContratDTO toDto(Contrat contrat);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "lotId", target = "lot")
    @Mapping(source = "fournisseurId", target = "fournisseur")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    Contrat toEntity(ContratDTO contratDTO);

    default Contrat fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contrat contrat = new Contrat();
        contrat.setId(id);
        return contrat;
    }
}
