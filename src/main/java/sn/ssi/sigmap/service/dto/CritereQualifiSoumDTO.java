package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.CritereQualifiSoum} entity.
 */
@ApiModel(description = "TABLE CriteresQualificationsSoumissionnaire")
public class CritereQualifiSoumDTO implements Serializable {
    
    private Long id;

    private Integer conforme;

    private String libelle;

    private String libelleLot;


    private Long dossierAppelOffreId;

    private Long plisOuvertureId;

    private Long lotId;

    private Long dossiersSosuscritereId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConforme() {
        return conforme;
    }

    public void setConforme(Integer conforme) {
        this.conforme = conforme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleLot() {
        return libelleLot;
    }

    public void setLibelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getDossiersSosuscritereId() {
        return dossiersSosuscritereId;
    }

    public void setDossiersSosuscritereId(Long dossiersSouscritereId) {
        this.dossiersSosuscritereId = dossiersSouscritereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CritereQualifiSoumDTO)) {
            return false;
        }

        return id != null && id.equals(((CritereQualifiSoumDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CritereQualifiSoumDTO{" +
            "id=" + getId() +
            ", conforme=" + getConforme() +
            ", libelle='" + getLibelle() + "'" +
            ", libelleLot='" + getLibelleLot() + "'" +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", lotId=" + getLotId() +
            ", dossiersSosuscritereId=" + getDossiersSosuscritereId() +
            "}";
    }
}
