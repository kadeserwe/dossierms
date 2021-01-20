package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.RetraitRegistreDAO} entity.
 */
@ApiModel(description = "TABLE RetraitRegistreDAO")
public class RetraitRegistreDAODTO implements Serializable {
    
    private Long id;

    private String nomSoumissionnaire;

    private String telephone;

    private String email;

    private String modePaiement;

    private String ninea;

    private BigDecimal montantVerse;

    private LocalDate dateRetrait;


    private Long dossierAppelOffreId;

    private Long fournisseurId;

    private Long paysId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSoumissionnaire() {
        return nomSoumissionnaire;
    }

    public void setNomSoumissionnaire(String nomSoumissionnaire) {
        this.nomSoumissionnaire = nomSoumissionnaire;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public BigDecimal getMontantVerse() {
        return montantVerse;
    }

    public void setMontantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
    }

    public LocalDate getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(LocalDate dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Long getPaysId() {
        return paysId;
    }

    public void setPaysId(Long paysId) {
        this.paysId = paysId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RetraitRegistreDAODTO)) {
            return false;
        }

        return id != null && id.equals(((RetraitRegistreDAODTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RetraitRegistreDAODTO{" +
            "id=" + getId() +
            ", nomSoumissionnaire='" + getNomSoumissionnaire() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", email='" + getEmail() + "'" +
            ", modePaiement='" + getModePaiement() + "'" +
            ", ninea='" + getNinea() + "'" +
            ", montantVerse=" + getMontantVerse() +
            ", dateRetrait='" + getDateRetrait() + "'" +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", fournisseurId=" + getFournisseurId() +
            ", paysId=" + getPaysId() +
            "}";
    }
}
