package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.PiecesRecus} entity.
 */
@ApiModel(description = "TABLE PIECERECUS")
public class PiecesRecusDTO implements Serializable {
    
    private Long id;

    private String libelle;

    private String description;

    private Integer garantie;

    
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

    public Integer getGarantie() {
        return garantie;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PiecesRecusDTO)) {
            return false;
        }

        return id != null && id.equals(((PiecesRecusDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PiecesRecusDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            ", garantie=" + getGarantie() +
            "}";
    }
}
