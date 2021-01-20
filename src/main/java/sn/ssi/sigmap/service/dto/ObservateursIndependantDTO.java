package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.ObservateursIndependant} entity.
 */
@ApiModel(description = "TABLE ObservateursIndependant")
public class ObservateursIndependantDTO implements Serializable {
    
    private Long id;

    private String representant;

    private String qualite;

    private String presence;

    private LocalDate dateConvocation;

    private Integer etape;


    private Long dossierAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepresentant() {
        return representant;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public LocalDate getDateConvocation() {
        return dateConvocation;
    }

    public void setDateConvocation(LocalDate dateConvocation) {
        this.dateConvocation = dateConvocation;
    }

    public Integer getEtape() {
        return etape;
    }

    public void setEtape(Integer etape) {
        this.etape = etape;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ObservateursIndependantDTO)) {
            return false;
        }

        return id != null && id.equals(((ObservateursIndependantDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ObservateursIndependantDTO{" +
            "id=" + getId() +
            ", representant='" + getRepresentant() + "'" +
            ", qualite='" + getQualite() + "'" +
            ", presence='" + getPresence() + "'" +
            ", dateConvocation='" + getDateConvocation() + "'" +
            ", etape=" + getEtape() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            "}";
    }
}
