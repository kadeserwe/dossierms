package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.DossiersCommissionsMarche} entity.
 */
@ApiModel(description = "TABLE Dossierscommissionsmarche")
public class DossiersCommissionsMarcheDTO implements Serializable {
    
    private Long id;

    private Integer flagPresenceEvaluation;

    private Integer etapePI;


    private Long dossierAppelOffreId;

    private Long membresCommissionsMarcheId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlagPresenceEvaluation() {
        return flagPresenceEvaluation;
    }

    public void setFlagPresenceEvaluation(Integer flagPresenceEvaluation) {
        this.flagPresenceEvaluation = flagPresenceEvaluation;
    }

    public Integer getEtapePI() {
        return etapePI;
    }

    public void setEtapePI(Integer etapePI) {
        this.etapePI = etapePI;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getMembresCommissionsMarcheId() {
        return membresCommissionsMarcheId;
    }

    public void setMembresCommissionsMarcheId(Long membresCommissionsMarcheId) {
        this.membresCommissionsMarcheId = membresCommissionsMarcheId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossiersCommissionsMarcheDTO)) {
            return false;
        }

        return id != null && id.equals(((DossiersCommissionsMarcheDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersCommissionsMarcheDTO{" +
            "id=" + getId() +
            ", flagPresenceEvaluation=" + getFlagPresenceEvaluation() +
            ", etapePI=" + getEtapePI() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", membresCommissionsMarcheId=" + getMembresCommissionsMarcheId() +
            "}";
    }
}
