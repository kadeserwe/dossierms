package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A AppelOffre.
 */
@Entity
@Table(name = "appel_offre")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AppelOffre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "apo_datecreation", nullable = false)
    private LocalDate apoDatecreation;

    @Column(name = "apo_date_autorisation")
    private LocalDate apoDateAutorisation;

    @Column(name = "apo_date_demande_autorisation")
    private LocalDate apoDateDemandeAutorisation;

    @Column(name = "apo_date_rejet")
    private LocalDate apoDateRejet;

    @Column(name = "apo_date_mise_autorisation")
    private LocalDate apoDateMiseAutorisation;

    @Column(name = "date_stop_procedure")
    private LocalDate dateStopProcedure;

    @Column(name = "date_affectation_dossier")
    private LocalDate dateAffectationDossier;

    @Column(name = "apo_date_pv_ouverturepli")
    private LocalDate apoDatePVOuverturepli;

    @Column(name = "apo_date_versement")
    private LocalDate apoDateVersement;

    @Column(name = "date_pub_liste_restreinte")
    private LocalDate datePubListeRestreinte;

    @Column(name = "apo_projet")
    private String apoProjet;

    @Column(name = "apo_objet")
    private String apoObjet;

    @NotNull
    @Column(name = "apo_reference", nullable = false, unique = true)
    private String apoReference;

    @Column(name = "apo_numero_pret_credit")
    private String apoNumeroPretCredit;

    @Column(name = "apo_commentaire_autorisation")
    private String apoCommentaireAutorisation;

    @Column(name = "apo_fichier_mise_autorisation")
    private String apoFichierMiseAutorisation;

    @Column(name = "numero_marche")
    private String numeroMarche;

    @Column(name = "motif_stop_procedure")
    private String motifStopProcedure;

    @Column(name = "apo_fichier_pv")
    private String apoFichierPV;

    @Column(name = "apo_fichier_validation")
    private String apoFichierValidation;

    @Column(name = "apo_autorisation_prealable")
    private String apoAutorisationPrealable;

    @Column(name = "apo_fichier_autorisation_prealable")
    private String apoFichierAutorisationPrealable;

    @Column(name = "apo_reference_requete_ac")
    private String apoReferenceRequeteAc;

    @Column(name = "apo_rapport_special")
    private String apoRapportSpecial;

    @Column(name = "apo_reference_communication")
    private String apoReferenceCommunication;

    @Column(name = "apo_releve_conseil")
    private String apoReleveConseil;

    @Column(name = "apo_fichier_rapport_special")
    private String apoFichierRapportSpecial;

    @Column(name = "apo_fichier_releve_conseil")
    private String apoFichierReleveConseil;

    @Column(name = "pub_liste_restreinte")
    private String pubListeRestreinte;

    @Column(name = "fichier_liste_restreinte")
    private String fichierListeRestreinte;

    @Column(name = "apo_montant_estime", precision = 21, scale = 2)
    private BigDecimal apoMontantEstime;

    @Column(name = "apo_montant_versement", precision = 21, scale = 2)
    private BigDecimal apoMontantVersement;

    @Column(name = "apo_responsable_dcmp")
    private Integer apoResponsableDCMP;

    @Column(name = "etat_seuil")
    private Integer etatSeuil;

    @Column(name = "apo_statut")
    private String apoStatut;

    @Column(name = "apo_valide")
    private String apoValide;

    @Column(name = "apo_nbre_dao")
    private Integer apoNbreDAO;

    @Column(name = "apo_nbre_dc")
    private Integer apoNbreDC;

    @Column(name = "apo_etat_validation")
    private Integer apoEtatValidation;

    @NotNull
    @Column(name = "autirite_id", nullable = false)
    private Long autiriteId;

    @NotNull
    @Column(name = "realisation_id", nullable = false)
    private Long realisationId;

    @Column(name = "modepassation_id")
    private Long modepassationId;

    @Column(name = "typemarche_id")
    private Long typemarcheId;

    @Column(name = "modeselection_id")
    private Long modeselectionId;

    @ManyToOne
    @JsonIgnoreProperties(value = "appelOffres", allowSetters = true)
    private CategorieAppelOffre categorieAppelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getApoDatecreation() {
        return apoDatecreation;
    }

    public AppelOffre apoDatecreation(LocalDate apoDatecreation) {
        this.apoDatecreation = apoDatecreation;
        return this;
    }

    public void setApoDatecreation(LocalDate apoDatecreation) {
        this.apoDatecreation = apoDatecreation;
    }

    public LocalDate getApoDateAutorisation() {
        return apoDateAutorisation;
    }

    public AppelOffre apoDateAutorisation(LocalDate apoDateAutorisation) {
        this.apoDateAutorisation = apoDateAutorisation;
        return this;
    }

    public void setApoDateAutorisation(LocalDate apoDateAutorisation) {
        this.apoDateAutorisation = apoDateAutorisation;
    }

    public LocalDate getApoDateDemandeAutorisation() {
        return apoDateDemandeAutorisation;
    }

    public AppelOffre apoDateDemandeAutorisation(LocalDate apoDateDemandeAutorisation) {
        this.apoDateDemandeAutorisation = apoDateDemandeAutorisation;
        return this;
    }

    public void setApoDateDemandeAutorisation(LocalDate apoDateDemandeAutorisation) {
        this.apoDateDemandeAutorisation = apoDateDemandeAutorisation;
    }

    public LocalDate getApoDateRejet() {
        return apoDateRejet;
    }

    public AppelOffre apoDateRejet(LocalDate apoDateRejet) {
        this.apoDateRejet = apoDateRejet;
        return this;
    }

    public void setApoDateRejet(LocalDate apoDateRejet) {
        this.apoDateRejet = apoDateRejet;
    }

    public LocalDate getApoDateMiseAutorisation() {
        return apoDateMiseAutorisation;
    }

    public AppelOffre apoDateMiseAutorisation(LocalDate apoDateMiseAutorisation) {
        this.apoDateMiseAutorisation = apoDateMiseAutorisation;
        return this;
    }

    public void setApoDateMiseAutorisation(LocalDate apoDateMiseAutorisation) {
        this.apoDateMiseAutorisation = apoDateMiseAutorisation;
    }

    public LocalDate getDateStopProcedure() {
        return dateStopProcedure;
    }

    public AppelOffre dateStopProcedure(LocalDate dateStopProcedure) {
        this.dateStopProcedure = dateStopProcedure;
        return this;
    }

    public void setDateStopProcedure(LocalDate dateStopProcedure) {
        this.dateStopProcedure = dateStopProcedure;
    }

    public LocalDate getDateAffectationDossier() {
        return dateAffectationDossier;
    }

    public AppelOffre dateAffectationDossier(LocalDate dateAffectationDossier) {
        this.dateAffectationDossier = dateAffectationDossier;
        return this;
    }

    public void setDateAffectationDossier(LocalDate dateAffectationDossier) {
        this.dateAffectationDossier = dateAffectationDossier;
    }

    public LocalDate getApoDatePVOuverturepli() {
        return apoDatePVOuverturepli;
    }

    public AppelOffre apoDatePVOuverturepli(LocalDate apoDatePVOuverturepli) {
        this.apoDatePVOuverturepli = apoDatePVOuverturepli;
        return this;
    }

    public void setApoDatePVOuverturepli(LocalDate apoDatePVOuverturepli) {
        this.apoDatePVOuverturepli = apoDatePVOuverturepli;
    }

    public LocalDate getApoDateVersement() {
        return apoDateVersement;
    }

    public AppelOffre apoDateVersement(LocalDate apoDateVersement) {
        this.apoDateVersement = apoDateVersement;
        return this;
    }

    public void setApoDateVersement(LocalDate apoDateVersement) {
        this.apoDateVersement = apoDateVersement;
    }

    public LocalDate getDatePubListeRestreinte() {
        return datePubListeRestreinte;
    }

    public AppelOffre datePubListeRestreinte(LocalDate datePubListeRestreinte) {
        this.datePubListeRestreinte = datePubListeRestreinte;
        return this;
    }

    public void setDatePubListeRestreinte(LocalDate datePubListeRestreinte) {
        this.datePubListeRestreinte = datePubListeRestreinte;
    }

    public String getApoProjet() {
        return apoProjet;
    }

    public AppelOffre apoProjet(String apoProjet) {
        this.apoProjet = apoProjet;
        return this;
    }

    public void setApoProjet(String apoProjet) {
        this.apoProjet = apoProjet;
    }

    public String getApoObjet() {
        return apoObjet;
    }

    public AppelOffre apoObjet(String apoObjet) {
        this.apoObjet = apoObjet;
        return this;
    }

    public void setApoObjet(String apoObjet) {
        this.apoObjet = apoObjet;
    }

    public String getApoReference() {
        return apoReference;
    }

    public AppelOffre apoReference(String apoReference) {
        this.apoReference = apoReference;
        return this;
    }

    public void setApoReference(String apoReference) {
        this.apoReference = apoReference;
    }

    public String getApoNumeroPretCredit() {
        return apoNumeroPretCredit;
    }

    public AppelOffre apoNumeroPretCredit(String apoNumeroPretCredit) {
        this.apoNumeroPretCredit = apoNumeroPretCredit;
        return this;
    }

    public void setApoNumeroPretCredit(String apoNumeroPretCredit) {
        this.apoNumeroPretCredit = apoNumeroPretCredit;
    }

    public String getApoCommentaireAutorisation() {
        return apoCommentaireAutorisation;
    }

    public AppelOffre apoCommentaireAutorisation(String apoCommentaireAutorisation) {
        this.apoCommentaireAutorisation = apoCommentaireAutorisation;
        return this;
    }

    public void setApoCommentaireAutorisation(String apoCommentaireAutorisation) {
        this.apoCommentaireAutorisation = apoCommentaireAutorisation;
    }

    public String getApoFichierMiseAutorisation() {
        return apoFichierMiseAutorisation;
    }

    public AppelOffre apoFichierMiseAutorisation(String apoFichierMiseAutorisation) {
        this.apoFichierMiseAutorisation = apoFichierMiseAutorisation;
        return this;
    }

    public void setApoFichierMiseAutorisation(String apoFichierMiseAutorisation) {
        this.apoFichierMiseAutorisation = apoFichierMiseAutorisation;
    }

    public String getNumeroMarche() {
        return numeroMarche;
    }

    public AppelOffre numeroMarche(String numeroMarche) {
        this.numeroMarche = numeroMarche;
        return this;
    }

    public void setNumeroMarche(String numeroMarche) {
        this.numeroMarche = numeroMarche;
    }

    public String getMotifStopProcedure() {
        return motifStopProcedure;
    }

    public AppelOffre motifStopProcedure(String motifStopProcedure) {
        this.motifStopProcedure = motifStopProcedure;
        return this;
    }

    public void setMotifStopProcedure(String motifStopProcedure) {
        this.motifStopProcedure = motifStopProcedure;
    }

    public String getApoFichierPV() {
        return apoFichierPV;
    }

    public AppelOffre apoFichierPV(String apoFichierPV) {
        this.apoFichierPV = apoFichierPV;
        return this;
    }

    public void setApoFichierPV(String apoFichierPV) {
        this.apoFichierPV = apoFichierPV;
    }

    public String getApoFichierValidation() {
        return apoFichierValidation;
    }

    public AppelOffre apoFichierValidation(String apoFichierValidation) {
        this.apoFichierValidation = apoFichierValidation;
        return this;
    }

    public void setApoFichierValidation(String apoFichierValidation) {
        this.apoFichierValidation = apoFichierValidation;
    }

    public String getApoAutorisationPrealable() {
        return apoAutorisationPrealable;
    }

    public AppelOffre apoAutorisationPrealable(String apoAutorisationPrealable) {
        this.apoAutorisationPrealable = apoAutorisationPrealable;
        return this;
    }

    public void setApoAutorisationPrealable(String apoAutorisationPrealable) {
        this.apoAutorisationPrealable = apoAutorisationPrealable;
    }

    public String getApoFichierAutorisationPrealable() {
        return apoFichierAutorisationPrealable;
    }

    public AppelOffre apoFichierAutorisationPrealable(String apoFichierAutorisationPrealable) {
        this.apoFichierAutorisationPrealable = apoFichierAutorisationPrealable;
        return this;
    }

    public void setApoFichierAutorisationPrealable(String apoFichierAutorisationPrealable) {
        this.apoFichierAutorisationPrealable = apoFichierAutorisationPrealable;
    }

    public String getApoReferenceRequeteAc() {
        return apoReferenceRequeteAc;
    }

    public AppelOffre apoReferenceRequeteAc(String apoReferenceRequeteAc) {
        this.apoReferenceRequeteAc = apoReferenceRequeteAc;
        return this;
    }

    public void setApoReferenceRequeteAc(String apoReferenceRequeteAc) {
        this.apoReferenceRequeteAc = apoReferenceRequeteAc;
    }

    public String getApoRapportSpecial() {
        return apoRapportSpecial;
    }

    public AppelOffre apoRapportSpecial(String apoRapportSpecial) {
        this.apoRapportSpecial = apoRapportSpecial;
        return this;
    }

    public void setApoRapportSpecial(String apoRapportSpecial) {
        this.apoRapportSpecial = apoRapportSpecial;
    }

    public String getApoReferenceCommunication() {
        return apoReferenceCommunication;
    }

    public AppelOffre apoReferenceCommunication(String apoReferenceCommunication) {
        this.apoReferenceCommunication = apoReferenceCommunication;
        return this;
    }

    public void setApoReferenceCommunication(String apoReferenceCommunication) {
        this.apoReferenceCommunication = apoReferenceCommunication;
    }

    public String getApoReleveConseil() {
        return apoReleveConseil;
    }

    public AppelOffre apoReleveConseil(String apoReleveConseil) {
        this.apoReleveConseil = apoReleveConseil;
        return this;
    }

    public void setApoReleveConseil(String apoReleveConseil) {
        this.apoReleveConseil = apoReleveConseil;
    }

    public String getApoFichierRapportSpecial() {
        return apoFichierRapportSpecial;
    }

    public AppelOffre apoFichierRapportSpecial(String apoFichierRapportSpecial) {
        this.apoFichierRapportSpecial = apoFichierRapportSpecial;
        return this;
    }

    public void setApoFichierRapportSpecial(String apoFichierRapportSpecial) {
        this.apoFichierRapportSpecial = apoFichierRapportSpecial;
    }

    public String getApoFichierReleveConseil() {
        return apoFichierReleveConseil;
    }

    public AppelOffre apoFichierReleveConseil(String apoFichierReleveConseil) {
        this.apoFichierReleveConseil = apoFichierReleveConseil;
        return this;
    }

    public void setApoFichierReleveConseil(String apoFichierReleveConseil) {
        this.apoFichierReleveConseil = apoFichierReleveConseil;
    }

    public String getPubListeRestreinte() {
        return pubListeRestreinte;
    }

    public AppelOffre pubListeRestreinte(String pubListeRestreinte) {
        this.pubListeRestreinte = pubListeRestreinte;
        return this;
    }

    public void setPubListeRestreinte(String pubListeRestreinte) {
        this.pubListeRestreinte = pubListeRestreinte;
    }

    public String getFichierListeRestreinte() {
        return fichierListeRestreinte;
    }

    public AppelOffre fichierListeRestreinte(String fichierListeRestreinte) {
        this.fichierListeRestreinte = fichierListeRestreinte;
        return this;
    }

    public void setFichierListeRestreinte(String fichierListeRestreinte) {
        this.fichierListeRestreinte = fichierListeRestreinte;
    }

    public BigDecimal getApoMontantEstime() {
        return apoMontantEstime;
    }

    public AppelOffre apoMontantEstime(BigDecimal apoMontantEstime) {
        this.apoMontantEstime = apoMontantEstime;
        return this;
    }

    public void setApoMontantEstime(BigDecimal apoMontantEstime) {
        this.apoMontantEstime = apoMontantEstime;
    }

    public BigDecimal getApoMontantVersement() {
        return apoMontantVersement;
    }

    public AppelOffre apoMontantVersement(BigDecimal apoMontantVersement) {
        this.apoMontantVersement = apoMontantVersement;
        return this;
    }

    public void setApoMontantVersement(BigDecimal apoMontantVersement) {
        this.apoMontantVersement = apoMontantVersement;
    }

    public Integer getApoResponsableDCMP() {
        return apoResponsableDCMP;
    }

    public AppelOffre apoResponsableDCMP(Integer apoResponsableDCMP) {
        this.apoResponsableDCMP = apoResponsableDCMP;
        return this;
    }

    public void setApoResponsableDCMP(Integer apoResponsableDCMP) {
        this.apoResponsableDCMP = apoResponsableDCMP;
    }

    public Integer getEtatSeuil() {
        return etatSeuil;
    }

    public AppelOffre etatSeuil(Integer etatSeuil) {
        this.etatSeuil = etatSeuil;
        return this;
    }

    public void setEtatSeuil(Integer etatSeuil) {
        this.etatSeuil = etatSeuil;
    }

    public String getApoStatut() {
        return apoStatut;
    }

    public AppelOffre apoStatut(String apoStatut) {
        this.apoStatut = apoStatut;
        return this;
    }

    public void setApoStatut(String apoStatut) {
        this.apoStatut = apoStatut;
    }

    public String getApoValide() {
        return apoValide;
    }

    public AppelOffre apoValide(String apoValide) {
        this.apoValide = apoValide;
        return this;
    }

    public void setApoValide(String apoValide) {
        this.apoValide = apoValide;
    }

    public Integer getApoNbreDAO() {
        return apoNbreDAO;
    }

    public AppelOffre apoNbreDAO(Integer apoNbreDAO) {
        this.apoNbreDAO = apoNbreDAO;
        return this;
    }

    public void setApoNbreDAO(Integer apoNbreDAO) {
        this.apoNbreDAO = apoNbreDAO;
    }

    public Integer getApoNbreDC() {
        return apoNbreDC;
    }

    public AppelOffre apoNbreDC(Integer apoNbreDC) {
        this.apoNbreDC = apoNbreDC;
        return this;
    }

    public void setApoNbreDC(Integer apoNbreDC) {
        this.apoNbreDC = apoNbreDC;
    }

    public Integer getApoEtatValidation() {
        return apoEtatValidation;
    }

    public AppelOffre apoEtatValidation(Integer apoEtatValidation) {
        this.apoEtatValidation = apoEtatValidation;
        return this;
    }

    public void setApoEtatValidation(Integer apoEtatValidation) {
        this.apoEtatValidation = apoEtatValidation;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public AppelOffre autiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
        return this;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public Long getRealisationId() {
        return realisationId;
    }

    public AppelOffre realisationId(Long realisationId) {
        this.realisationId = realisationId;
        return this;
    }

    public void setRealisationId(Long realisationId) {
        this.realisationId = realisationId;
    }

    public Long getModepassationId() {
        return modepassationId;
    }

    public AppelOffre modepassationId(Long modepassationId) {
        this.modepassationId = modepassationId;
        return this;
    }

    public void setModepassationId(Long modepassationId) {
        this.modepassationId = modepassationId;
    }

    public Long getTypemarcheId() {
        return typemarcheId;
    }

    public AppelOffre typemarcheId(Long typemarcheId) {
        this.typemarcheId = typemarcheId;
        return this;
    }

    public void setTypemarcheId(Long typemarcheId) {
        this.typemarcheId = typemarcheId;
    }

    public Long getModeselectionId() {
        return modeselectionId;
    }

    public AppelOffre modeselectionId(Long modeselectionId) {
        this.modeselectionId = modeselectionId;
        return this;
    }

    public void setModeselectionId(Long modeselectionId) {
        this.modeselectionId = modeselectionId;
    }

    public CategorieAppelOffre getCategorieAppelOffre() {
        return categorieAppelOffre;
    }

    public AppelOffre categorieAppelOffre(CategorieAppelOffre categorieAppelOffre) {
        this.categorieAppelOffre = categorieAppelOffre;
        return this;
    }

    public void setCategorieAppelOffre(CategorieAppelOffre categorieAppelOffre) {
        this.categorieAppelOffre = categorieAppelOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppelOffre)) {
            return false;
        }
        return id != null && id.equals(((AppelOffre) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppelOffre{" +
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
            "}";
    }
}
