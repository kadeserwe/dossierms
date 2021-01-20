package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.HistoriqueAppelOffresAC} entity.
 */
@ApiModel(description = "TABLE HistoriqueappeloffresAC")
public class HistoriqueAppelOffresACDTO implements Serializable {
    
    private Long id;

    private String histoacValidation;

    private String histoacCommentaire;

    private String histoacFichiervalidation;

    private String histoacBorderau;

    private String histoValidation;

    private String histoCommentaire;

    private String histoFichiervalidation;

    private String daoFichier;

    private String origine;

    private LocalDate histoacDatevalidation;

    private LocalDate histoacDatecreationdossier;

    private LocalDate histoDatevalidation;

    private Integer histoacAttribution;

    private Integer histoacAc;

    private String validerparNom;

    private String validerparPrenom;

    private Long userId;

    private Long autiriteId;


    private Long dossierAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoacValidation() {
        return histoacValidation;
    }

    public void setHistoacValidation(String histoacValidation) {
        this.histoacValidation = histoacValidation;
    }

    public String getHistoacCommentaire() {
        return histoacCommentaire;
    }

    public void setHistoacCommentaire(String histoacCommentaire) {
        this.histoacCommentaire = histoacCommentaire;
    }

    public String getHistoacFichiervalidation() {
        return histoacFichiervalidation;
    }

    public void setHistoacFichiervalidation(String histoacFichiervalidation) {
        this.histoacFichiervalidation = histoacFichiervalidation;
    }

    public String getHistoacBorderau() {
        return histoacBorderau;
    }

    public void setHistoacBorderau(String histoacBorderau) {
        this.histoacBorderau = histoacBorderau;
    }

    public String getHistoValidation() {
        return histoValidation;
    }

    public void setHistoValidation(String histoValidation) {
        this.histoValidation = histoValidation;
    }

    public String getHistoCommentaire() {
        return histoCommentaire;
    }

    public void setHistoCommentaire(String histoCommentaire) {
        this.histoCommentaire = histoCommentaire;
    }

    public String getHistoFichiervalidation() {
        return histoFichiervalidation;
    }

    public void setHistoFichiervalidation(String histoFichiervalidation) {
        this.histoFichiervalidation = histoFichiervalidation;
    }

    public String getDaoFichier() {
        return daoFichier;
    }

    public void setDaoFichier(String daoFichier) {
        this.daoFichier = daoFichier;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public LocalDate getHistoacDatevalidation() {
        return histoacDatevalidation;
    }

    public void setHistoacDatevalidation(LocalDate histoacDatevalidation) {
        this.histoacDatevalidation = histoacDatevalidation;
    }

    public LocalDate getHistoacDatecreationdossier() {
        return histoacDatecreationdossier;
    }

    public void setHistoacDatecreationdossier(LocalDate histoacDatecreationdossier) {
        this.histoacDatecreationdossier = histoacDatecreationdossier;
    }

    public LocalDate getHistoDatevalidation() {
        return histoDatevalidation;
    }

    public void setHistoDatevalidation(LocalDate histoDatevalidation) {
        this.histoDatevalidation = histoDatevalidation;
    }

    public Integer getHistoacAttribution() {
        return histoacAttribution;
    }

    public void setHistoacAttribution(Integer histoacAttribution) {
        this.histoacAttribution = histoacAttribution;
    }

    public Integer getHistoacAc() {
        return histoacAc;
    }

    public void setHistoacAc(Integer histoacAc) {
        this.histoacAc = histoacAc;
    }

    public String getValiderparNom() {
        return validerparNom;
    }

    public void setValiderparNom(String validerparNom) {
        this.validerparNom = validerparNom;
    }

    public String getValiderparPrenom() {
        return validerparPrenom;
    }

    public void setValiderparPrenom(String validerparPrenom) {
        this.validerparPrenom = validerparPrenom;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueAppelOffresACDTO)) {
            return false;
        }

        return id != null && id.equals(((HistoriqueAppelOffresACDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueAppelOffresACDTO{" +
            "id=" + getId() +
            ", histoacValidation='" + getHistoacValidation() + "'" +
            ", histoacCommentaire='" + getHistoacCommentaire() + "'" +
            ", histoacFichiervalidation='" + getHistoacFichiervalidation() + "'" +
            ", histoacBorderau='" + getHistoacBorderau() + "'" +
            ", histoValidation='" + getHistoValidation() + "'" +
            ", histoCommentaire='" + getHistoCommentaire() + "'" +
            ", histoFichiervalidation='" + getHistoFichiervalidation() + "'" +
            ", daoFichier='" + getDaoFichier() + "'" +
            ", origine='" + getOrigine() + "'" +
            ", histoacDatevalidation='" + getHistoacDatevalidation() + "'" +
            ", histoacDatecreationdossier='" + getHistoacDatecreationdossier() + "'" +
            ", histoDatevalidation='" + getHistoDatevalidation() + "'" +
            ", histoacAttribution=" + getHistoacAttribution() +
            ", histoacAc=" + getHistoacAc() +
            ", validerparNom='" + getValiderparNom() + "'" +
            ", validerparPrenom='" + getValiderparPrenom() + "'" +
            ", userId=" + getUserId() +
            ", autiriteId=" + getAutiriteId() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            "}";
    }
}
