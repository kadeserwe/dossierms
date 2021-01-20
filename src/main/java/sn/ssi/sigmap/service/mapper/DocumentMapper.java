package sn.ssi.sigmap.service.mapper;


import sn.ssi.sigmap.domain.*;
import sn.ssi.sigmap.service.dto.DocumentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Document} and its DTO {@link DocumentDTO}.
 */
@Mapper(componentModel = "spring", uses = {DossierAppelOffreMapper.class, AppelOffreMapper.class, PlisOuvertureMapper.class, LotMapper.class})
public interface DocumentMapper extends EntityMapper<DocumentDTO, Document> {

    @Mapping(source = "dossierAppelOffre.id", target = "dossierAppelOffreId")
    @Mapping(source = "appelOffre.id", target = "appelOffreId")
    @Mapping(source = "plisOuverture.id", target = "plisOuvertureId")
    @Mapping(source = "lot.id", target = "lotId")
    DocumentDTO toDto(Document document);

    @Mapping(source = "dossierAppelOffreId", target = "dossierAppelOffre")
    @Mapping(source = "appelOffreId", target = "appelOffre")
    @Mapping(source = "plisOuvertureId", target = "plisOuverture")
    @Mapping(source = "lotId", target = "lot")
    Document toEntity(DocumentDTO documentDTO);

    default Document fromId(Long id) {
        if (id == null) {
            return null;
        }
        Document document = new Document();
        document.setId(id);
        return document;
    }
}
