package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Devise} entity.
 */
@ApiModel(description = "TABLE DEVISE")
public class DeviseDTO implements Serializable {
    
    private Long id;

    private BigDecimal devTauxConversion;


    private Long dossierAppelOffreId;

    private Long monnaieOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDevTauxConversion() {
        return devTauxConversion;
    }

    public void setDevTauxConversion(BigDecimal devTauxConversion) {
        this.devTauxConversion = devTauxConversion;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getMonnaieOffreId() {
        return monnaieOffreId;
    }

    public void setMonnaieOffreId(Long monnaieOffreId) {
        this.monnaieOffreId = monnaieOffreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeviseDTO)) {
            return false;
        }

        return id != null && id.equals(((DeviseDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DeviseDTO{" +
            "id=" + getId() +
            ", devTauxConversion=" + getDevTauxConversion() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", monnaieOffreId=" + getMonnaieOffreId() +
            "}";
    }
}
