package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.DossierAppelOffre} entity.
 */
public class DossierAppelOffreDTO implements Serializable {
    
    private Long id;

    private String dosLieuDepotDossier;

    @NotNull
    private String dosReference;

    private String dosAdresseRetrait;

    private String dosConditionAcquistion;

    private String dosAllotissement;

    private String dosLotDivisible;

    private String dosCommentaireMiseValidation;

    private String dosCommentaireValidation;

    private String dosFichierValidation;

    private String dosCommentairePublicationProvisoire;

    private String dosCommentairesPublicationDefinitive;

    private String dosCommentairePublication;

    private String dosCommentSignature;

    private String dosRefSignature;

    private String dosCommentApprobation;

    private String dosRefApprobation;

    private LocalDate dosDateDebutRetrait;

    private LocalDate dosDateLimiteDepot;

    private LocalDate dosHeurelimitedepot;

    private LocalDate dosDateCreation;

    private LocalDate dosDateRejet;

    private LocalDate dosDatePublicationProvisoire;

    private LocalDate dosDatePublicationDefinitive;

    private LocalDate dosDateDemandePublication;

    private String dosCommentaireDemandePublication;

    private String dosFichierDemandePublication;

    private String dosLieuAcquisitionDAO;

    private Integer telechargerDAO;

    private LocalDate dosDateOuvertueDesplis;

    private LocalDate dosHeureOuvertureDesPlis;

    private LocalDate dosDatePublication;

    private String dosFicchierPublication;

    @NotNull
    private Long autiriteId;

    private BigDecimal dosMontantGarantie;

    private BigDecimal dosMontantDao;

    private BigDecimal dosMontantEstime;

    private String dosIncidents;

    private LocalDate dateRemiseDossierTechnique;

    private LocalDate dateLimiteDossierTechnique;

    private String commentaireDelaiTechnique;

    private LocalDate dosDateMiseValidationAttribution;

    private String dosEtatValidation;

    private String dosBordereau;

    private String dosFichierMiseValidationPrequalif;

    private String dosfichierSignature;

    private LocalDate dosDateSignature;

    private LocalDate dosDateMiseValidationSignature;

    private LocalDate dosDateAttributionDefinitive;

    private LocalDate dosDateDemandeApprobation;

    private String dosCommentDemandeApprobation;

    private String fichierApprobation;

    private LocalDate dosDateNotification;

    private String dosCommentNotification;

    private String dosRefNotification;

    private String dosFichierNotification;

    private String dosCommentaireAttributionDefinitive;


    private Long appelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosLieuDepotDossier() {
        return dosLieuDepotDossier;
    }

    public void setDosLieuDepotDossier(String dosLieuDepotDossier) {
        this.dosLieuDepotDossier = dosLieuDepotDossier;
    }

    public String getDosReference() {
        return dosReference;
    }

    public void setDosReference(String dosReference) {
        this.dosReference = dosReference;
    }

    public String getDosAdresseRetrait() {
        return dosAdresseRetrait;
    }

    public void setDosAdresseRetrait(String dosAdresseRetrait) {
        this.dosAdresseRetrait = dosAdresseRetrait;
    }

    public String getDosConditionAcquistion() {
        return dosConditionAcquistion;
    }

    public void setDosConditionAcquistion(String dosConditionAcquistion) {
        this.dosConditionAcquistion = dosConditionAcquistion;
    }

    public String getDosAllotissement() {
        return dosAllotissement;
    }

    public void setDosAllotissement(String dosAllotissement) {
        this.dosAllotissement = dosAllotissement;
    }

    public String getDosLotDivisible() {
        return dosLotDivisible;
    }

    public void setDosLotDivisible(String dosLotDivisible) {
        this.dosLotDivisible = dosLotDivisible;
    }

    public String getDosCommentaireMiseValidation() {
        return dosCommentaireMiseValidation;
    }

    public void setDosCommentaireMiseValidation(String dosCommentaireMiseValidation) {
        this.dosCommentaireMiseValidation = dosCommentaireMiseValidation;
    }

    public String getDosCommentaireValidation() {
        return dosCommentaireValidation;
    }

    public void setDosCommentaireValidation(String dosCommentaireValidation) {
        this.dosCommentaireValidation = dosCommentaireValidation;
    }

    public String getDosFichierValidation() {
        return dosFichierValidation;
    }

    public void setDosFichierValidation(String dosFichierValidation) {
        this.dosFichierValidation = dosFichierValidation;
    }

    public String getDosCommentairePublicationProvisoire() {
        return dosCommentairePublicationProvisoire;
    }

    public void setDosCommentairePublicationProvisoire(String dosCommentairePublicationProvisoire) {
        this.dosCommentairePublicationProvisoire = dosCommentairePublicationProvisoire;
    }

    public String getDosCommentairesPublicationDefinitive() {
        return dosCommentairesPublicationDefinitive;
    }

    public void setDosCommentairesPublicationDefinitive(String dosCommentairesPublicationDefinitive) {
        this.dosCommentairesPublicationDefinitive = dosCommentairesPublicationDefinitive;
    }

    public String getDosCommentairePublication() {
        return dosCommentairePublication;
    }

    public void setDosCommentairePublication(String dosCommentairePublication) {
        this.dosCommentairePublication = dosCommentairePublication;
    }

    public String getDosCommentSignature() {
        return dosCommentSignature;
    }

    public void setDosCommentSignature(String dosCommentSignature) {
        this.dosCommentSignature = dosCommentSignature;
    }

    public String getDosRefSignature() {
        return dosRefSignature;
    }

    public void setDosRefSignature(String dosRefSignature) {
        this.dosRefSignature = dosRefSignature;
    }

    public String getDosCommentApprobation() {
        return dosCommentApprobation;
    }

    public void setDosCommentApprobation(String dosCommentApprobation) {
        this.dosCommentApprobation = dosCommentApprobation;
    }

    public String getDosRefApprobation() {
        return dosRefApprobation;
    }

    public void setDosRefApprobation(String dosRefApprobation) {
        this.dosRefApprobation = dosRefApprobation;
    }

    public LocalDate getDosDateDebutRetrait() {
        return dosDateDebutRetrait;
    }

    public void setDosDateDebutRetrait(LocalDate dosDateDebutRetrait) {
        this.dosDateDebutRetrait = dosDateDebutRetrait;
    }

    public LocalDate getDosDateLimiteDepot() {
        return dosDateLimiteDepot;
    }

    public void setDosDateLimiteDepot(LocalDate dosDateLimiteDepot) {
        this.dosDateLimiteDepot = dosDateLimiteDepot;
    }

    public LocalDate getDosHeurelimitedepot() {
        return dosHeurelimitedepot;
    }

    public void setDosHeurelimitedepot(LocalDate dosHeurelimitedepot) {
        this.dosHeurelimitedepot = dosHeurelimitedepot;
    }

    public LocalDate getDosDateCreation() {
        return dosDateCreation;
    }

    public void setDosDateCreation(LocalDate dosDateCreation) {
        this.dosDateCreation = dosDateCreation;
    }

    public LocalDate getDosDateRejet() {
        return dosDateRejet;
    }

    public void setDosDateRejet(LocalDate dosDateRejet) {
        this.dosDateRejet = dosDateRejet;
    }

    public LocalDate getDosDatePublicationProvisoire() {
        return dosDatePublicationProvisoire;
    }

    public void setDosDatePublicationProvisoire(LocalDate dosDatePublicationProvisoire) {
        this.dosDatePublicationProvisoire = dosDatePublicationProvisoire;
    }

    public LocalDate getDosDatePublicationDefinitive() {
        return dosDatePublicationDefinitive;
    }

    public void setDosDatePublicationDefinitive(LocalDate dosDatePublicationDefinitive) {
        this.dosDatePublicationDefinitive = dosDatePublicationDefinitive;
    }

    public LocalDate getDosDateDemandePublication() {
        return dosDateDemandePublication;
    }

    public void setDosDateDemandePublication(LocalDate dosDateDemandePublication) {
        this.dosDateDemandePublication = dosDateDemandePublication;
    }

    public String getDosCommentaireDemandePublication() {
        return dosCommentaireDemandePublication;
    }

    public void setDosCommentaireDemandePublication(String dosCommentaireDemandePublication) {
        this.dosCommentaireDemandePublication = dosCommentaireDemandePublication;
    }

    public String getDosFichierDemandePublication() {
        return dosFichierDemandePublication;
    }

    public void setDosFichierDemandePublication(String dosFichierDemandePublication) {
        this.dosFichierDemandePublication = dosFichierDemandePublication;
    }

    public String getDosLieuAcquisitionDAO() {
        return dosLieuAcquisitionDAO;
    }

    public void setDosLieuAcquisitionDAO(String dosLieuAcquisitionDAO) {
        this.dosLieuAcquisitionDAO = dosLieuAcquisitionDAO;
    }

    public Integer getTelechargerDAO() {
        return telechargerDAO;
    }

    public void setTelechargerDAO(Integer telechargerDAO) {
        this.telechargerDAO = telechargerDAO;
    }

    public LocalDate getDosDateOuvertueDesplis() {
        return dosDateOuvertueDesplis;
    }

    public void setDosDateOuvertueDesplis(LocalDate dosDateOuvertueDesplis) {
        this.dosDateOuvertueDesplis = dosDateOuvertueDesplis;
    }

    public LocalDate getDosHeureOuvertureDesPlis() {
        return dosHeureOuvertureDesPlis;
    }

    public void setDosHeureOuvertureDesPlis(LocalDate dosHeureOuvertureDesPlis) {
        this.dosHeureOuvertureDesPlis = dosHeureOuvertureDesPlis;
    }

    public LocalDate getDosDatePublication() {
        return dosDatePublication;
    }

    public void setDosDatePublication(LocalDate dosDatePublication) {
        this.dosDatePublication = dosDatePublication;
    }

    public String getDosFicchierPublication() {
        return dosFicchierPublication;
    }

    public void setDosFicchierPublication(String dosFicchierPublication) {
        this.dosFicchierPublication = dosFicchierPublication;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public BigDecimal getDosMontantGarantie() {
        return dosMontantGarantie;
    }

    public void setDosMontantGarantie(BigDecimal dosMontantGarantie) {
        this.dosMontantGarantie = dosMontantGarantie;
    }

    public BigDecimal getDosMontantDao() {
        return dosMontantDao;
    }

    public void setDosMontantDao(BigDecimal dosMontantDao) {
        this.dosMontantDao = dosMontantDao;
    }

    public BigDecimal getDosMontantEstime() {
        return dosMontantEstime;
    }

    public void setDosMontantEstime(BigDecimal dosMontantEstime) {
        this.dosMontantEstime = dosMontantEstime;
    }

    public String getDosIncidents() {
        return dosIncidents;
    }

    public void setDosIncidents(String dosIncidents) {
        this.dosIncidents = dosIncidents;
    }

    public LocalDate getDateRemiseDossierTechnique() {
        return dateRemiseDossierTechnique;
    }

    public void setDateRemiseDossierTechnique(LocalDate dateRemiseDossierTechnique) {
        this.dateRemiseDossierTechnique = dateRemiseDossierTechnique;
    }

    public LocalDate getDateLimiteDossierTechnique() {
        return dateLimiteDossierTechnique;
    }

    public void setDateLimiteDossierTechnique(LocalDate dateLimiteDossierTechnique) {
        this.dateLimiteDossierTechnique = dateLimiteDossierTechnique;
    }

    public String getCommentaireDelaiTechnique() {
        return commentaireDelaiTechnique;
    }

    public void setCommentaireDelaiTechnique(String commentaireDelaiTechnique) {
        this.commentaireDelaiTechnique = commentaireDelaiTechnique;
    }

    public LocalDate getDosDateMiseValidationAttribution() {
        return dosDateMiseValidationAttribution;
    }

    public void setDosDateMiseValidationAttribution(LocalDate dosDateMiseValidationAttribution) {
        this.dosDateMiseValidationAttribution = dosDateMiseValidationAttribution;
    }

    public String getDosEtatValidation() {
        return dosEtatValidation;
    }

    public void setDosEtatValidation(String dosEtatValidation) {
        this.dosEtatValidation = dosEtatValidation;
    }

    public String getDosBordereau() {
        return dosBordereau;
    }

    public void setDosBordereau(String dosBordereau) {
        this.dosBordereau = dosBordereau;
    }

    public String getDosFichierMiseValidationPrequalif() {
        return dosFichierMiseValidationPrequalif;
    }

    public void setDosFichierMiseValidationPrequalif(String dosFichierMiseValidationPrequalif) {
        this.dosFichierMiseValidationPrequalif = dosFichierMiseValidationPrequalif;
    }

    public String getDosfichierSignature() {
        return dosfichierSignature;
    }

    public void setDosfichierSignature(String dosfichierSignature) {
        this.dosfichierSignature = dosfichierSignature;
    }

    public LocalDate getDosDateSignature() {
        return dosDateSignature;
    }

    public void setDosDateSignature(LocalDate dosDateSignature) {
        this.dosDateSignature = dosDateSignature;
    }

    public LocalDate getDosDateMiseValidationSignature() {
        return dosDateMiseValidationSignature;
    }

    public void setDosDateMiseValidationSignature(LocalDate dosDateMiseValidationSignature) {
        this.dosDateMiseValidationSignature = dosDateMiseValidationSignature;
    }

    public LocalDate getDosDateAttributionDefinitive() {
        return dosDateAttributionDefinitive;
    }

    public void setDosDateAttributionDefinitive(LocalDate dosDateAttributionDefinitive) {
        this.dosDateAttributionDefinitive = dosDateAttributionDefinitive;
    }

    public LocalDate getDosDateDemandeApprobation() {
        return dosDateDemandeApprobation;
    }

    public void setDosDateDemandeApprobation(LocalDate dosDateDemandeApprobation) {
        this.dosDateDemandeApprobation = dosDateDemandeApprobation;
    }

    public String getDosCommentDemandeApprobation() {
        return dosCommentDemandeApprobation;
    }

    public void setDosCommentDemandeApprobation(String dosCommentDemandeApprobation) {
        this.dosCommentDemandeApprobation = dosCommentDemandeApprobation;
    }

    public String getFichierApprobation() {
        return fichierApprobation;
    }

    public void setFichierApprobation(String fichierApprobation) {
        this.fichierApprobation = fichierApprobation;
    }

    public LocalDate getDosDateNotification() {
        return dosDateNotification;
    }

    public void setDosDateNotification(LocalDate dosDateNotification) {
        this.dosDateNotification = dosDateNotification;
    }

    public String getDosCommentNotification() {
        return dosCommentNotification;
    }

    public void setDosCommentNotification(String dosCommentNotification) {
        this.dosCommentNotification = dosCommentNotification;
    }

    public String getDosRefNotification() {
        return dosRefNotification;
    }

    public void setDosRefNotification(String dosRefNotification) {
        this.dosRefNotification = dosRefNotification;
    }

    public String getDosFichierNotification() {
        return dosFichierNotification;
    }

    public void setDosFichierNotification(String dosFichierNotification) {
        this.dosFichierNotification = dosFichierNotification;
    }

    public String getDosCommentaireAttributionDefinitive() {
        return dosCommentaireAttributionDefinitive;
    }

    public void setDosCommentaireAttributionDefinitive(String dosCommentaireAttributionDefinitive) {
        this.dosCommentaireAttributionDefinitive = dosCommentaireAttributionDefinitive;
    }

    public Long getAppelOffreId() {
        return appelOffreId;
    }

    public void setAppelOffreId(Long appelOffreId) {
        this.appelOffreId = appelOffreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossierAppelOffreDTO)) {
            return false;
        }

        return id != null && id.equals(((DossierAppelOffreDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossierAppelOffreDTO{" +
            "id=" + getId() +
            ", dosLieuDepotDossier='" + getDosLieuDepotDossier() + "'" +
            ", dosReference='" + getDosReference() + "'" +
            ", dosAdresseRetrait='" + getDosAdresseRetrait() + "'" +
            ", dosConditionAcquistion='" + getDosConditionAcquistion() + "'" +
            ", dosAllotissement='" + getDosAllotissement() + "'" +
            ", dosLotDivisible='" + getDosLotDivisible() + "'" +
            ", dosCommentaireMiseValidation='" + getDosCommentaireMiseValidation() + "'" +
            ", dosCommentaireValidation='" + getDosCommentaireValidation() + "'" +
            ", dosFichierValidation='" + getDosFichierValidation() + "'" +
            ", dosCommentairePublicationProvisoire='" + getDosCommentairePublicationProvisoire() + "'" +
            ", dosCommentairesPublicationDefinitive='" + getDosCommentairesPublicationDefinitive() + "'" +
            ", dosCommentairePublication='" + getDosCommentairePublication() + "'" +
            ", dosCommentSignature='" + getDosCommentSignature() + "'" +
            ", dosRefSignature='" + getDosRefSignature() + "'" +
            ", dosCommentApprobation='" + getDosCommentApprobation() + "'" +
            ", dosRefApprobation='" + getDosRefApprobation() + "'" +
            ", dosDateDebutRetrait='" + getDosDateDebutRetrait() + "'" +
            ", dosDateLimiteDepot='" + getDosDateLimiteDepot() + "'" +
            ", dosHeurelimitedepot='" + getDosHeurelimitedepot() + "'" +
            ", dosDateCreation='" + getDosDateCreation() + "'" +
            ", dosDateRejet='" + getDosDateRejet() + "'" +
            ", dosDatePublicationProvisoire='" + getDosDatePublicationProvisoire() + "'" +
            ", dosDatePublicationDefinitive='" + getDosDatePublicationDefinitive() + "'" +
            ", dosDateDemandePublication='" + getDosDateDemandePublication() + "'" +
            ", dosCommentaireDemandePublication='" + getDosCommentaireDemandePublication() + "'" +
            ", dosFichierDemandePublication='" + getDosFichierDemandePublication() + "'" +
            ", dosLieuAcquisitionDAO='" + getDosLieuAcquisitionDAO() + "'" +
            ", telechargerDAO=" + getTelechargerDAO() +
            ", dosDateOuvertueDesplis='" + getDosDateOuvertueDesplis() + "'" +
            ", dosHeureOuvertureDesPlis='" + getDosHeureOuvertureDesPlis() + "'" +
            ", dosDatePublication='" + getDosDatePublication() + "'" +
            ", dosFicchierPublication='" + getDosFicchierPublication() + "'" +
            ", autiriteId=" + getAutiriteId() +
            ", dosMontantGarantie=" + getDosMontantGarantie() +
            ", dosMontantDao=" + getDosMontantDao() +
            ", dosMontantEstime=" + getDosMontantEstime() +
            ", dosIncidents='" + getDosIncidents() + "'" +
            ", dateRemiseDossierTechnique='" + getDateRemiseDossierTechnique() + "'" +
            ", dateLimiteDossierTechnique='" + getDateLimiteDossierTechnique() + "'" +
            ", commentaireDelaiTechnique='" + getCommentaireDelaiTechnique() + "'" +
            ", dosDateMiseValidationAttribution='" + getDosDateMiseValidationAttribution() + "'" +
            ", dosEtatValidation='" + getDosEtatValidation() + "'" +
            ", dosBordereau='" + getDosBordereau() + "'" +
            ", dosFichierMiseValidationPrequalif='" + getDosFichierMiseValidationPrequalif() + "'" +
            ", dosfichierSignature='" + getDosfichierSignature() + "'" +
            ", dosDateSignature='" + getDosDateSignature() + "'" +
            ", dosDateMiseValidationSignature='" + getDosDateMiseValidationSignature() + "'" +
            ", dosDateAttributionDefinitive='" + getDosDateAttributionDefinitive() + "'" +
            ", dosDateDemandeApprobation='" + getDosDateDemandeApprobation() + "'" +
            ", dosCommentDemandeApprobation='" + getDosCommentDemandeApprobation() + "'" +
            ", fichierApprobation='" + getFichierApprobation() + "'" +
            ", dosDateNotification='" + getDosDateNotification() + "'" +
            ", dosCommentNotification='" + getDosCommentNotification() + "'" +
            ", dosRefNotification='" + getDosRefNotification() + "'" +
            ", dosFichierNotification='" + getDosFichierNotification() + "'" +
            ", dosCommentaireAttributionDefinitive='" + getDosCommentaireAttributionDefinitive() + "'" +
            ", appelOffreId=" + getAppelOffreId() +
            "}";
    }
}
