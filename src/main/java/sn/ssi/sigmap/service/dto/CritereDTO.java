package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Critere} entity.
 */
@ApiModel(description = "TABLE Critere")
public class CritereDTO implements Serializable {
    
    private Long id;

    private String libelle;

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
        if (!(o instanceof CritereDTO)) {
            return false;
        }

        return id != null && id.equals(((CritereDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CritereDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", autoriteId=" + getAutoriteId() +
            "}";
    }
}
