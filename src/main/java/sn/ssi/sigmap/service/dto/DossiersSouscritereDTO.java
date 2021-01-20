package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.DossiersSouscritere} entity.
 */
@ApiModel(description = "TABLE CriteresQualificationsSoumissionnaire")
public class DossiersSouscritereDTO implements Serializable {
    
    private Long id;

    private BigDecimal note;


    private Long dossierAppelOffreId;

    private Long lotId;

    private Long critereId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getCritereId() {
        return critereId;
    }

    public void setCritereId(Long critereId) {
        this.critereId = critereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossiersSouscritereDTO)) {
            return false;
        }

        return id != null && id.equals(((DossiersSouscritereDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersSouscritereDTO{" +
            "id=" + getId() +
            ", note=" + getNote() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", lotId=" + getLotId() +
            ", critereId=" + getCritereId() +
            "}";
    }
}
