package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.AppelOffre} entity.
 */
public class AppelOffreDTO implements Serializable {
    
    private Long id;

    @NotNull
    private LocalDate apoDatecreation;

    private LocalDate apoDateAutorisation;

    private LocalDate apoDateDemandeAutorisation;

    private LocalDate apoDateRejet;

    private LocalDate apoDateMiseAutorisation;

    private LocalDate dateStopProcedure;

    private LocalDate dateAffectationDossier;

    private LocalDate apoDatePVOuverturepli;

    private LocalDate apoDateVersement;

    private LocalDate datePubListeRestreinte;

    private String apoProjet;

    private String apoObjet;

    @NotNull
    private String apoReference;

    private String apoNumeroPretCredit;

    private String apoCommentaireAutorisation;

    private String apoFichierMiseAutorisation;

    private String numeroMarche;

    private String motifStopProcedure;

    private String apoFichierPV;

    private String apoFichierValidation;

    private String apoAutorisationPrealable;

    private String apoFichierAutorisationPrealable;

    private String apoReferenceRequeteAc;

    private String apoRapportSpecial;

    private String apoReferenceCommunication;

    private String apoReleveConseil;

    private String apoFichierRapportSpecial;

    private String apoFichierReleveConseil;

    private String pubListeRestreinte;

    private String fichierListeRestreinte;

    private BigDecimal apoMontantEstime;

    private BigDecimal apoMontantVersement;

    private Integer apoResponsableDCMP;

    private Integer etatSeuil;

    private String apoStatut;

    private String apoValide;

    private Integer apoNbreDAO;

    private Integer apoNbreDC;

    private Integer apoEtatValidation;

    @NotNull
    private Long autiriteId;

    @NotNull
    private Long realisationId;

    private Long modepassationId;

    private Long typemarcheId;

    private Long modeselectionId;


    private Long categorieAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getApoDatecreation() {
        return apoDatecreation;
    }

    public void setApoDatecreation(LocalDate apoDatecreation) {
        this.apoDatecreation = apoDatecreation;
    }

    public LocalDate getApoDateAutorisation() {
        return apoDateAutorisation;
    }

    public void setApoDateAutorisation(LocalDate apoDateAutorisation) {
        this.apoDateAutorisation = apoDateAutorisation;
    }

    public LocalDate getApoDateDemandeAutorisation() {
        return apoDateDemandeAutorisation;
    }

    public void setApoDateDemandeAutorisation(LocalDate apoDateDemandeAutorisation) {
        this.apoDateDemandeAutorisation = apoDateDemandeAutorisation;
    }

    public LocalDate getApoDateRejet() {
        return apoDateRejet;
    }

    public void setApoDateRejet(LocalDate apoDateRejet) {
        this.apoDateRejet = apoDateRejet;
    }

    public LocalDate getApoDateMiseAutorisation() {
        return apoDateMiseAutorisation;
    }

    public void setApoDateMiseAutorisation(LocalDate apoDateMiseAutorisation) {
        this.apoDateMiseAutorisation = apoDateMiseAutorisation;
    }

    public LocalDate getDateStopProcedure() {
        return dateStopProcedure;
    }

    public void setDateStopProcedure(LocalDate dateStopProcedure) {
        this.dateStopProcedure = dateStopProcedure;
    }

    public LocalDate getDateAffectationDossier() {
        return dateAffectationDossier;
    }

    public void setDateAffectationDossier(LocalDate dateAffectationDossier) {
        this.dateAffectationDossier = dateAffectationDossier;
    }

    public LocalDate getApoDatePVOuverturepli() {
        return apoDatePVOuverturepli;
    }

    public void setApoDatePVOuverturepli(LocalDate apoDatePVOuverturepli) {
        this.apoDatePVOuverturepli = apoDatePVOuverturepli;
    }

    public LocalDate getApoDateVersement() {
        return apoDateVersement;
    }

    public void setApoDateVersement(LocalDate apoDateVersement) {
        this.apoDateVersement = apoDateVersement;
    }

    public LocalDate getDatePubListeRestreinte() {
        return datePubListeRestreinte;
    }

    public void setDatePubListeRestreinte(LocalDate datePubListeRestreinte) {
        this.datePubListeRestreinte = datePubListeRestreinte;
    }

    public String getApoProjet() {
        return apoProjet;
    }

    public void setApoProjet(String apoProjet) {
        this.apoProjet = apoProjet;
    }

    public String getApoObjet() {
        return apoObjet;
    }

    public void setApoObjet(String apoObjet) {
        this.apoObjet = apoObjet;
    }

    public String getApoReference() {
        return apoReference;
    }

    public void setApoReference(String apoReference) {
        this.apoReference = apoReference;
    }

    public String getApoNumeroPretCredit() {
        return apoNumeroPretCredit;
    }

    public void setApoNumeroPretCredit(String apoNumeroPretCredit) {
        this.apoNumeroPretCredit = apoNumeroPretCredit;
    }

    public String getApoCommentaireAutorisation() {
        return apoCommentaireAutorisation;
    }

    public void setApoCommentaireAutorisation(String apoCommentaireAutorisation) {
        this.apoCommentaireAutorisation = apoCommentaireAutorisation;
    }

    public String getApoFichierMiseAutorisation() {
        return apoFichierMiseAutorisation;
    }

    public void setApoFichierMiseAutorisation(String apoFichierMiseAutorisation) {
        this.apoFichierMiseAutorisation = apoFichierMiseAutorisation;
    }

    public String getNumeroMarche() {
        return numeroMarche;
    }

    public void setNumeroMarche(String numeroMarche) {
        this.numeroMarche = numeroMarche;
    }

    public String getMotifStopProcedure() {
        return motifStopProcedure;
    }

    public void setMotifStopProcedure(String motifStopProcedure) {
        this.motifStopProcedure = motifStopProcedure;
    }

    public String getApoFichierPV() {
        return apoFichierPV;
    }

    public void setApoFichierPV(String apoFichierPV) {
        this.apoFichierPV = apoFichierPV;
    }

    public String getApoFichierValidation() {
        return apoFichierValidation;
    }

    public void setApoFichierValidation(String apoFichierValidation) {
        this.apoFichierValidation = apoFichierValidation;
    }

    public String getApoAutorisationPrealable() {
        return apoAutorisationPrealable;
    }

    public void setApoAutorisationPrealable(String apoAutorisationPrealable) {
        this.apoAutorisationPrealable = apoAutorisationPrealable;
    }

    public String getApoFichierAutorisationPrealable() {
        return apoFichierAutorisationPrealable;
    }

    public void setApoFichierAutorisationPrealable(String apoFichierAutorisationPrealable) {
        this.apoFichierAutorisationPrealable = apoFichierAutorisationPrealable;
    }

    public String getApoReferenceRequeteAc() {
        return apoReferenceRequeteAc;
    }

    public void setApoReferenceRequeteAc(String apoReferenceRequeteAc) {
        this.apoReferenceRequeteAc = apoReferenceRequeteAc;
    }

    public String getApoRapportSpecial() {
        return apoRapportSpecial;
    }

    public void setApoRapportSpecial(String apoRapportSpecial) {
        this.apoRapportSpecial = apoRapportSpecial;
    }

    public String getApoReferenceCommunication() {
        return apoReferenceCommunication;
    }

    public void setApoReferenceCommunication(String apoReferenceCommunication) {
        this.apoReferenceCommunication = apoReferenceCommunication;
    }

    public String getApoReleveConseil() {
        return apoReleveConseil;
    }

    public void setApoReleveConseil(String apoReleveConseil) {
        this.apoReleveConseil = apoReleveConseil;
    }

    public String getApoFichierRapportSpecial() {
        return apoFichierRapportSpecial;
    }

    public void setApoFichierRapportSpecial(String apoFichierRapportSpecial) {
        this.apoFichierRapportSpecial = apoFichierRapportSpecial;
    }

    public String getApoFichierReleveConseil() {
        return apoFichierReleveConseil;
    }

    public void setApoFichierReleveConseil(String apoFichierReleveConseil) {
        this.apoFichierReleveConseil = apoFichierReleveConseil;
    }

    public String getPubListeRestreinte() {
        return pubListeRestreinte;
    }

    public void setPubListeRestreinte(String pubListeRestreinte) {
        this.pubListeRestreinte = pubListeRestreinte;
    }

    public String getFichierListeRestreinte() {
        return fichierListeRestreinte;
    }

    public void setFichierListeRestreinte(String fichierListeRestreinte) {
        this.fichierListeRestreinte = fichierListeRestreinte;
    }

    public BigDecimal getApoMontantEstime() {
        return apoMontantEstime;
    }

    public void setApoMontantEstime(BigDecimal apoMontantEstime) {
        this.apoMontantEstime = apoMontantEstime;
    }

    public BigDecimal getApoMontantVersement() {
        return apoMontantVersement;
    }

    public void setApoMontantVersement(BigDecimal apoMontantVersement) {
        this.apoMontantVersement = apoMontantVersement;
    }

    public Integer getApoResponsableDCMP() {
        return apoResponsableDCMP;
    }

    public void setApoResponsableDCMP(Integer apoResponsableDCMP) {
        this.apoResponsableDCMP = apoResponsableDCMP;
    }

    public Integer getEtatSeuil() {
        return etatSeuil;
    }

    public void setEtatSeuil(Integer etatSeuil) {
        this.etatSeuil = etatSeuil;
    }

    public String getApoStatut() {
        return apoStatut;
    }

    public void setApoStatut(String apoStatut) {
        this.apoStatut = apoStatut;
    }

    public String getApoValide() {
        return apoValide;
    }

    public void setApoValide(String apoValide) {
        this.apoValide = apoValide;
    }

    public Integer getApoNbreDAO() {
        return apoNbreDAO;
    }

    public void setApoNbreDAO(Integer apoNbreDAO) {
        this.apoNbreDAO = apoNbreDAO;
    }

    public Integer getApoNbreDC() {
        return apoNbreDC;
    }

    public void setApoNbreDC(Integer apoNbreDC) {
        this.apoNbreDC = apoNbreDC;
    }

    public Integer getApoEtatValidation() {
        return apoEtatValidation;
    }

    public void setApoEtatValidation(Integer apoEtatValidation) {
        this.apoEtatValidation = apoEtatValidation;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public Long getRealisationId() {
        return realisationId;
    }

    public void setRealisationId(Long realisationId) {
        this.realisationId = realisationId;
    }

    public Long getModepassationId() {
        return modepassationId;
    }

    public void setModepassationId(Long modepassationId) {
        this.modepassationId = modepassationId;
    }

    public Long getTypemarcheId() {
        return typemarcheId;
    }

    public void setTypemarcheId(Long typemarcheId) {
        this.typemarcheId = typemarcheId;
    }

    public Long getModeselectionId() {
        return modeselectionId;
    }

    public void setModeselectionId(Long modeselectionId) {
        this.modeselectionId = modeselectionId;
    }

    public Long getCategorieAppelOffreId() {
        return categorieAppelOffreId;
    }

    public void setCategorieAppelOffreId(Long categorieAppelOffreId) {
        this.categorieAppelOffreId = categorieAppelOffreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppelOffreDTO)) {
            return false;
        }

        return id != null && id.equals(((AppelOffreDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppelOffreDTO{" +
            "id=" + getId() +
            ", apoDatecreation='" + getApoDatecreation() + "'" +
            ", apoDateAutorisation='" + getApoDateAutorisation() + "'" +
            ", apoDateDemandeAutorisation='" + getApoDateDemandeAutorisation() + "'" +
            ", apoDateRejet='" + getApoDateRejet() + "'" +
            ", apoDateMiseAutorisation='" + getApoDateMiseAutorisation() + "'" +
            ", dateStopProcedure='" + getDateStopProcedure() + "'" +
            ", dateAffectationDossier='" + getDateAffectationDossier() + "'" +
            ", apoDatePVOuverturepli='" + getApoDatePVOuverturepli() + "'" +
            ", apoDateVersement='" + getApoDateVersement() + "'" +
            ", datePubListeRestreinte='" + getDatePubListeRestreinte() + "'" +
            ", apoProjet='" + getApoProjet() + "'" +
            ", apoObjet='" + getApoObjet() + "'" +
            ", apoReference='" + getApoReference() + "'" +
            ", apoNumeroPretCredit='" + getApoNumeroPretCredit() + "'" +
            ", apoCommentaireAutorisation='" + getApoCommentaireAutorisation() + "'" +
            ", apoFichierMiseAutorisation='" + getApoFichierMiseAutorisation() + "'" +
            ", numeroMarche='" + getNumeroMarche() + "'" +
            ", motifStopProcedure='" + getMotifStopProcedure() + "'" +
            ", apoFichierPV='" + getApoFichierPV() + "'" +
            ", apoFichierValidation='" + getApoFichierValidation() + "'" +
            ", apoAutorisationPrealable='" + getApoAutorisationPrealable() + "'" +
            ", apoFichierAutorisationPrealable='" + getApoFichierAutorisationPrealable() + "'" +
            ", apoReferenceRequeteAc='" + getApoReferenceRequeteAc() + "'" +
            ", apoRapportSpecial='" + getApoRapportSpecial() + "'" +
            ", apoReferenceCommunication='" + getApoReferenceCommunication() + "'" +
            ", apoReleveConseil='" + getApoReleveConseil() + "'" +
            ", apoFichierRapportSpecial='" + getApoFichierRapportSpecial() + "'" +
            ", apoFichierReleveConseil='" + getApoFichierReleveConseil() + "'" +
            ", pubListeRestreinte='" + getPubListeRestreinte() + "'" +
            ", fichierListeRestreinte='" + getFichierListeRestreinte() + "'" +
            ", apoMontantEstime=" + getApoMontantEstime() +
            ", apoMontantVersement=" + getApoMontantVersement() +
            ", apoResponsableDCMP=" + getApoResponsableDCMP() +
            ", etatSeuil=" + getEtatSeuil() +
            ", apoStatut='" + getApoStatut() + "'" +
            ", apoValide='" + getApoValide() + "'" +
            ", apoNbreDAO=" + getApoNbreDAO() +
            ", apoNbreDC=" + getApoNbreDC() +
            ", apoEtatValidation=" + getApoEtatValidation() +
            ", autiriteId=" + getAutiriteId() +
            ", realisationId=" + getRealisationId() +
            ", modepassationId=" + getModepassationId() +
            ", typemarcheId=" + getTypemarcheId() +
            ", modeselectionId=" + getModeselectionId() +
            ", categorieAppelOffreId=" + getCategorieAppelOffreId() +
            "}";
    }
}
