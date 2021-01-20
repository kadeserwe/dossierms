package sn.ssi.sigmap.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.NaturesGarantie} entity.
 */
public class NaturesGarantieDTO implements Serializable {
    
    private Long id;

    private String libelle;

    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaturesGarantieDTO)) {
            return false;
        }

        return id != null && id.equals(((NaturesGarantieDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NaturesGarantieDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
