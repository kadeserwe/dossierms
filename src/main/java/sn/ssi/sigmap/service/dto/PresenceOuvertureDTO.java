package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.PresenceOuverture} entity.
 */
@ApiModel(description = "TABLE Presenceouverture")
public class PresenceOuvertureDTO implements Serializable {
    
    private Long id;

    private String supplementaire;

    private String email;

    private String telephone;

    private String nomRepresentant;

    private String prenomRepresentant;

    private String nomStructure;

    private String qualite;

    private Integer etapePI;


    private Long dossierAppelOffreId;

    private Long appelOffreId;

    private Long plisOuvertureId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplementaire() {
        return supplementaire;
    }

    public void setSupplementaire(String supplementaire) {
        this.supplementaire = supplementaire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNomRepresentant() {
        return nomRepresentant;
    }

    public void setNomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
    }

    public String getPrenomRepresentant() {
        return prenomRepresentant;
    }

    public void setPrenomRepresentant(String prenomRepresentant) {
        this.prenomRepresentant = prenomRepresentant;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
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

    public Long getAppelOffreId() {
        return appelOffreId;
    }

    public void setAppelOffreId(Long appelOffreId) {
        this.appelOffreId = appelOffreId;
    }

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PresenceOuvertureDTO)) {
            return false;
        }

        return id != null && id.equals(((PresenceOuvertureDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PresenceOuvertureDTO{" +
            "id=" + getId() +
            ", supplementaire='" + getSupplementaire() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", nomRepresentant='" + getNomRepresentant() + "'" +
            ", prenomRepresentant='" + getPrenomRepresentant() + "'" +
            ", nomStructure='" + getNomStructure() + "'" +
            ", qualite='" + getQualite() + "'" +
            ", etapePI=" + getEtapePI() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", appelOffreId=" + getAppelOffreId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            "}";
    }
}
