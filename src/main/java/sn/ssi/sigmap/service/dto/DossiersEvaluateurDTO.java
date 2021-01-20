package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.DossiersEvaluateur} entity.
 */
@ApiModel(description = "TABLE DossiersEvaluateur")
public class DossiersEvaluateurDTO implements Serializable {
    
    private Long id;

    private String commission;

    private String nom;

    private String prenom;

    private Integer telephone;

    private String email;

    private String fonction;

    private LocalDate dateRemise;

    private LocalDate dateLimite;


    private Long dossierAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public LocalDate getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(LocalDate dateRemise) {
        this.dateRemise = dateRemise;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
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
        if (!(o instanceof DossiersEvaluateurDTO)) {
            return false;
        }

        return id != null && id.equals(((DossiersEvaluateurDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersEvaluateurDTO{" +
            "id=" + getId() +
            ", commission='" + getCommission() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", telephone=" + getTelephone() +
            ", email='" + getEmail() + "'" +
            ", fonction='" + getFonction() + "'" +
            ", dateRemise='" + getDateRemise() + "'" +
            ", dateLimite='" + getDateLimite() + "'" +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            "}";
    }
}
