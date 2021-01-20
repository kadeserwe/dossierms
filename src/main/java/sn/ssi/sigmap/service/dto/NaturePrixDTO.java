package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.NaturePrix} entity.
 */
@ApiModel(description = "TABLE Natureprix")
public class NaturePrixDTO implements Serializable {
    
    private Long id;

    private String natCode;

    private String natLibelle;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatCode() {
        return natCode;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public String getNatLibelle() {
        return natLibelle;
    }

    public void setNatLibelle(String natLibelle) {
        this.natLibelle = natLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaturePrixDTO)) {
            return false;
        }

        return id != null && id.equals(((NaturePrixDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NaturePrixDTO{" +
            "id=" + getId() +
            ", natCode='" + getNatCode() + "'" +
            ", natLibelle='" + getNatLibelle() + "'" +
            "}";
    }
}
