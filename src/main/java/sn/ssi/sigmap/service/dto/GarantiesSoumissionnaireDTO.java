package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.GarantiesSoumissionnaire} entity.
 */
@ApiModel(description = "TABLE GarantiesSoumissionnaire")
public class GarantiesSoumissionnaireDTO implements Serializable {
    
    private Long id;

    private String fournie;

    private String libelle;

    private String observations;

    private String libellelot;

    private BigDecimal montant;


    private Long dossierAppelOffreId;

    private Long garantiesDossierId;

    private Long plisOuvertureId;

    private Long naturesGarantieId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFournie() {
        return fournie;
    }

    public void setFournie(String fournie) {
        this.fournie = fournie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getLibellelot() {
        return libellelot;
    }

    public void setLibellelot(String libellelot) {
        this.libellelot = libellelot;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getGarantiesDossierId() {
        return garantiesDossierId;
    }

    public void setGarantiesDossierId(Long garantiesDossierId) {
        this.garantiesDossierId = garantiesDossierId;
    }

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    public Long getNaturesGarantieId() {
        return naturesGarantieId;
    }

    public void setNaturesGarantieId(Long naturesGarantieId) {
        this.naturesGarantieId = naturesGarantieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GarantiesSoumissionnaireDTO)) {
            return false;
        }

        return id != null && id.equals(((GarantiesSoumissionnaireDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GarantiesSoumissionnaireDTO{" +
            "id=" + getId() +
            ", fournie='" + getFournie() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", observations='" + getObservations() + "'" +
            ", libellelot='" + getLibellelot() + "'" +
            ", montant=" + getMontant() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", garantiesDossierId=" + getGarantiesDossierId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", naturesGarantieId=" + getNaturesGarantieId() +
            "}";
    }
}
