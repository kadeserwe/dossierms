package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Piece} entity.
 */
@ApiModel(description = "TABLE PIECE")
public class PieceDTO implements Serializable {
    
    private Long id;

    private String libelle;

    private String description;

    private String codepiece;

    private String localisation;

    private Integer type;

    private Long autoriteId;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodepiece() {
        return codepiece;
    }

    public void setCodepiece(String codepiece) {
        this.codepiece = codepiece;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PieceDTO)) {
            return false;
        }

        return id != null && id.equals(((PieceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PieceDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            ", codepiece='" + getCodepiece() + "'" +
            ", localisation='" + getLocalisation() + "'" +
            ", type=" + getType() +
            ", autoriteId=" + getAutoriteId() +
            "}";
    }
}
