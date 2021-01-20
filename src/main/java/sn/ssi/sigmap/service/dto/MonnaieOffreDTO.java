package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.MonnaieOffre} entity.
 */
@ApiModel(description = "TABLE Monnaieoffre")
public class MonnaieOffreDTO implements Serializable {
    
    private Long id;

    private String monCode;

    private String monLibelle;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonCode() {
        return monCode;
    }

    public void setMonCode(String monCode) {
        this.monCode = monCode;
    }

    public String getMonLibelle() {
        return monLibelle;
    }

    public void setMonLibelle(String monLibelle) {
        this.monLibelle = monLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonnaieOffreDTO)) {
            return false;
        }

        return id != null && id.equals(((MonnaieOffreDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonnaieOffreDTO{" +
            "id=" + getId() +
            ", monCode='" + getMonCode() + "'" +
            ", monLibelle='" + getMonLibelle() + "'" +
            "}";
    }
}
