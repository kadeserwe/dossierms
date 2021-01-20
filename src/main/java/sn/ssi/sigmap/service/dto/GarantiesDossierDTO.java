package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.GarantiesDossier} entity.
 */
@ApiModel(description = "TABLE GARANTIE")
public class GarantiesDossierDTO implements Serializable {
    
    private Long id;

    private BigDecimal pourcentage;

    private BigDecimal montant;

    private Long autiriteId;


    private Long dossierAppelOffreId;

    private Long lotId;

    private Long piecesRecusId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
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

    public Long getPiecesRecusId() {
        return piecesRecusId;
    }

    public void setPiecesRecusId(Long piecesRecusId) {
        this.piecesRecusId = piecesRecusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GarantiesDossierDTO)) {
            return false;
        }

        return id != null && id.equals(((GarantiesDossierDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GarantiesDossierDTO{" +
            "id=" + getId() +
            ", pourcentage=" + getPourcentage() +
            ", montant=" + getMontant() +
            ", autiriteId=" + getAutiriteId() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", lotId=" + getLotId() +
            ", piecesRecusId=" + getPiecesRecusId() +
            "}";
    }
}
