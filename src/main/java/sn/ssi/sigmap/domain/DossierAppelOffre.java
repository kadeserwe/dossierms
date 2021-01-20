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
 * A DossierAppelOffre.
 */
@Entity
@Table(name = "dossier_appel_offre")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DossierAppelOffre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "dos_lieu_depot_dossier")
    private String dosLieuDepotDossier;

    @NotNull
    @Column(name = "dos_reference", nullable = false, unique = true)
    private String dosReference;

    @Column(name = "dos_adresse_retrait")
    private String dosAdresseRetrait;

    @Column(name = "dos_condition_acquistion")
    private String dosConditionAcquistion;

    @Column(name = "dos_allotissement")
    private String dosAllotissement;

    @Column(name = "dos_lot_divisible")
    private String dosLotDivisible;

    @Column(name = "dos_commentaire_mise_validation")
    private String dosCommentaireMiseValidation;

    @Column(name = "dos_commentaire_validation")
    private String dosCommentaireValidation;

    @Column(name = "dos_fichier_validation")
    private String dosFichierValidation;

    @Column(name = "dos_commentaire_publication_provisoire")
    private String dosCommentairePublicationProvisoire;

    @Column(name = "dos_commentaires_publication_definitive")
    private String dosCommentairesPublicationDefinitive;

    @Column(name = "dos_commentaire_publication")
    private String dosCommentairePublication;

    @Column(name = "dos_comment_signature")
    private String dosCommentSignature;

    @Column(name = "dos_ref_signature")
    private String dosRefSignature;

    @Column(name = "dos_comment_approbation")
    private String dosCommentApprobation;

    @Column(name = "dos_ref_approbation")
    private String dosRefApprobation;

    @Column(name = "dos_date_debut_retrait")
    private LocalDate dosDateDebutRetrait;

    @Column(name = "dos_date_limite_depot")
    private LocalDate dosDateLimiteDepot;

    @Column(name = "dos_heurelimitedepot")
    private LocalDate dosHeurelimitedepot;

    @Column(name = "dos_date_creation")
    private LocalDate dosDateCreation;

    @Column(name = "dos_date_rejet")
    private LocalDate dosDateRejet;

    @Column(name = "dos_date_publication_provisoire")
    private LocalDate dosDatePublicationProvisoire;

    @Column(name = "dos_date_publication_definitive")
    private LocalDate dosDatePublicationDefinitive;

    @Column(name = "dos_date_demande_publication")
    private LocalDate dosDateDemandePublication;

    @Column(name = "dos_commentaire_demande_publication")
    private String dosCommentaireDemandePublication;

    @Column(name = "dos_fichier_demande_publication")
    private String dosFichierDemandePublication;

    @Column(name = "dos_lieu_acquisition_dao")
    private String dosLieuAcquisitionDAO;

    @Column(name = "telecharger_dao")
    private Integer telechargerDAO;

    @Column(name = "dos_date_ouvertue_desplis")
    private LocalDate dosDateOuvertueDesplis;

    @Column(name = "dos_heure_ouverture_des_plis")
    private LocalDate dosHeureOuvertureDesPlis;

    @Column(name = "dos_date_publication")
    private LocalDate dosDatePublication;

    @Column(name = "dos_ficchier_publication")
    private String dosFicchierPublication;

    @NotNull
    @Column(name = "autirite_id", nullable = false)
    private Long autiriteId;

    @Column(name = "dos_montant_garantie", precision = 21, scale = 2)
    private BigDecimal dosMontantGarantie;

    @Column(name = "dos_montant_dao", precision = 21, scale = 2)
    private BigDecimal dosMontantDao;

    @Column(name = "dos_montant_estime", precision = 21, scale = 2)
    private BigDecimal dosMontantEstime;

    @Column(name = "dos_incidents")
    private String dosIncidents;

    @Column(name = "date_remise_dossier_technique")
    private LocalDate dateRemiseDossierTechnique;

    @Column(name = "date_limite_dossier_technique")
    private LocalDate dateLimiteDossierTechnique;

    @Column(name = "commentaire_delai_technique")
    private String commentaireDelaiTechnique;

    @Column(name = "dos_date_mise_validation_attribution")
    private LocalDate dosDateMiseValidationAttribution;

    @Column(name = "dos_etat_validation")
    private String dosEtatValidation;

    @Column(name = "dos_bordereau")
    private String dosBordereau;

    @Column(name = "dos_fichier_mise_validation_prequalif")
    private String dosFichierMiseValidationPrequalif;

    @Column(name = "dosfichier_signature")
    private String dosfichierSignature;

    @Column(name = "dos_date_signature")
    private LocalDate dosDateSignature;

    @Column(name = "dos_date_mise_validation_signature")
    private LocalDate dosDateMiseValidationSignature;

    @Column(name = "dos_date_attribution_definitive")
    private LocalDate dosDateAttributionDefinitive;

    @Column(name = "dos_date_demande_approbation")
    private LocalDate dosDateDemandeApprobation;

    @Column(name = "dos_comment_demande_approbation")
    private String dosCommentDemandeApprobation;

    @Column(name = "fichier_approbation")
    private String fichierApprobation;

    @Column(name = "dos_date_notification")
    private LocalDate dosDateNotification;

    @Column(name = "dos_comment_notification")
    private String dosCommentNotification;

    @Column(name = "dos_ref_notification")
    private String dosRefNotification;

    @Column(name = "dos_fichier_notification")
    private String dosFichierNotification;

    @Column(name = "dos_commentaire_attribution_definitive")
    private String dosCommentaireAttributionDefinitive;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossierAppelOffres", allowSetters = true)
    private AppelOffre appelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosLieuDepotDossier() {
        return dosLieuDepotDossier;
    }

    public DossierAppelOffre dosLieuDepotDossier(String dosLieuDepotDossier) {
        this.dosLieuDepotDossier = dosLieuDepotDossier;
        return this;
    }

    public void setDosLieuDepotDossier(String dosLieuDepotDossier) {
        this.dosLieuDepotDossier = dosLieuDepotDossier;
    }

    public String getDosReference() {
        return dosReference;
    }

    public DossierAppelOffre dosReference(String dosReference) {
        this.dosReference = dosReference;
        return this;
    }

    public void setDosReference(String dosReference) {
        this.dosReference = dosReference;
    }

    public String getDosAdresseRetrait() {
        return dosAdresseRetrait;
    }

    public DossierAppelOffre dosAdresseRetrait(String dosAdresseRetrait) {
        this.dosAdresseRetrait = dosAdresseRetrait;
        return this;
    }

    public void setDosAdresseRetrait(String dosAdresseRetrait) {
        this.dosAdresseRetrait = dosAdresseRetrait;
    }

    public String getDosConditionAcquistion() {
        return dosConditionAcquistion;
    }

    public DossierAppelOffre dosConditionAcquistion(String dosConditionAcquistion) {
        this.dosConditionAcquistion = dosConditionAcquistion;
        return this;
    }

    public void setDosConditionAcquistion(String dosConditionAcquistion) {
        this.dosConditionAcquistion = dosConditionAcquistion;
    }

    public String getDosAllotissement() {
        return dosAllotissement;
    }

    public DossierAppelOffre dosAllotissement(String dosAllotissement) {
        this.dosAllotissement = dosAllotissement;
        return this;
    }

    public void setDosAllotissement(String dosAllotissement) {
        this.dosAllotissement = dosAllotissement;
    }

    public String getDosLotDivisible() {
        return dosLotDivisible;
    }

    public DossierAppelOffre dosLotDivisible(String dosLotDivisible) {
        this.dosLotDivisible = dosLotDivisible;
        return this;
    }

    public void setDosLotDivisible(String dosLotDivisible) {
        this.dosLotDivisible = dosLotDivisible;
    }

    public String getDosCommentaireMiseValidation() {
        return dosCommentaireMiseValidation;
    }

    public DossierAppelOffre dosCommentaireMiseValidation(String dosCommentaireMiseValidation) {
        this.dosCommentaireMiseValidation = dosCommentaireMiseValidation;
        return this;
    }

    public void setDosCommentaireMiseValidation(String dosCommentaireMiseValidation) {
        this.dosCommentaireMiseValidation = dosCommentaireMiseValidation;
    }

    public String getDosCommentaireValidation() {
        return dosCommentaireValidation;
    }

    public DossierAppelOffre dosCommentaireValidation(String dosCommentaireValidation) {
        this.dosCommentaireValidation = dosCommentaireValidation;
        return this;
    }

    public void setDosCommentaireValidation(String dosCommentaireValidation) {
        this.dosCommentaireValidation = dosCommentaireValidation;
    }

    public String getDosFichierValidation() {
        return dosFichierValidation;
    }

    public DossierAppelOffre dosFichierValidation(String dosFichierValidation) {
        this.dosFichierValidation = dosFichierValidation;
        return this;
    }

    public void setDosFichierValidation(String dosFichierValidation) {
        this.dosFichierValidation = dosFichierValidation;
    }

    public String getDosCommentairePublicationProvisoire() {
        return dosCommentairePublicationProvisoire;
    }

    public DossierAppelOffre dosCommentairePublicationProvisoire(String dosCommentairePublicationProvisoire) {
        this.dosCommentairePublicationProvisoire = dosCommentairePublicationProvisoire;
        return this;
    }

    public void setDosCommentairePublicationProvisoire(String dosCommentairePublicationProvisoire) {
        this.dosCommentairePublicationProvisoire = dosCommentairePublicationProvisoire;
    }

    public String getDosCommentairesPublicationDefinitive() {
        return dosCommentairesPublicationDefinitive;
    }

    public DossierAppelOffre dosCommentairesPublicationDefinitive(String dosCommentairesPublicationDefinitive) {
        this.dosCommentairesPublicationDefinitive = dosCommentairesPublicationDefinitive;
        return this;
    }

    public void setDosCommentairesPublicationDefinitive(String dosCommentairesPublicationDefinitive) {
        this.dosCommentairesPublicationDefinitive = dosCommentairesPublicationDefinitive;
    }

    public String getDosCommentairePublication() {
        return dosCommentairePublication;
    }

    public DossierAppelOffre dosCommentairePublication(String dosCommentairePublication) {
        this.dosCommentairePublication = dosCommentairePublication;
        return this;
    }

    public void setDosCommentairePublication(String dosCommentairePublication) {
        this.dosCommentairePublication = dosCommentairePublication;
    }

    public String getDosCommentSignature() {
        return dosCommentSignature;
    }

    public DossierAppelOffre dosCommentSignature(String dosCommentSignature) {
        this.dosCommentSignature = dosCommentSignature;
        return this;
    }

    public void setDosCommentSignature(String dosCommentSignature) {
        this.dosCommentSignature = dosCommentSignature;
    }

    public String getDosRefSignature() {
        return dosRefSignature;
    }

    public DossierAppelOffre dosRefSignature(String dosRefSignature) {
        this.dosRefSignature = dosRefSignature;
        return this;
    }

    public void setDosRefSignature(String dosRefSignature) {
        this.dosRefSignature = dosRefSignature;
    }

    public String getDosCommentApprobation() {
        return dosCommentApprobation;
    }

    public DossierAppelOffre dosCommentApprobation(String dosCommentApprobation) {
        this.dosCommentApprobation = dosCommentApprobation;
        return this;
    }

    public void setDosCommentApprobation(String dosCommentApprobation) {
        this.dosCommentApprobation = dosCommentApprobation;
    }

    public String getDosRefApprobation() {
        return dosRefApprobation;
    }

    public DossierAppelOffre dosRefApprobation(String dosRefApprobation) {
        this.dosRefApprobation = dosRefApprobation;
        return this;
    }

    public void setDosRefApprobation(String dosRefApprobation) {
        this.dosRefApprobation = dosRefApprobation;
    }

    public LocalDate getDosDateDebutRetrait() {
        return dosDateDebutRetrait;
    }

    public DossierAppelOffre dosDateDebutRetrait(LocalDate dosDateDebutRetrait) {
        this.dosDateDebutRetrait = dosDateDebutRetrait;
        return this;
    }

    public void setDosDateDebutRetrait(LocalDate dosDateDebutRetrait) {
        this.dosDateDebutRetrait = dosDateDebutRetrait;
    }

    public LocalDate getDosDateLimiteDepot() {
        return dosDateLimiteDepot;
    }

    public DossierAppelOffre dosDateLimiteDepot(LocalDate dosDateLimiteDepot) {
        this.dosDateLimiteDepot = dosDateLimiteDepot;
        return this;
    }

    public void setDosDateLimiteDepot(LocalDate dosDateLimiteDepot) {
        this.dosDateLimiteDepot = dosDateLimiteDepot;
    }

    public LocalDate getDosHeurelimitedepot() {
        return dosHeurelimitedepot;
    }

    public DossierAppelOffre dosHeurelimitedepot(LocalDate dosHeurelimitedepot) {
        this.dosHeurelimitedepot = dosHeurelimitedepot;
        return this;
    }

    public void setDosHeurelimitedepot(LocalDate dosHeurelimitedepot) {
        this.dosHeurelimitedepot = dosHeurelimitedepot;
    }

    public LocalDate getDosDateCreation() {
        return dosDateCreation;
    }

    public DossierAppelOffre dosDateCreation(LocalDate dosDateCreation) {
        this.dosDateCreation = dosDateCreation;
        return this;
    }

    public void setDosDateCreation(LocalDate dosDateCreation) {
        this.dosDateCreation = dosDateCreation;
    }

    public LocalDate getDosDateRejet() {
        return dosDateRejet;
    }

    public DossierAppelOffre dosDateRejet(LocalDate dosDateRejet) {
        this.dosDateRejet = dosDateRejet;
        return this;
    }

    public void setDosDateRejet(LocalDate dosDateRejet) {
        this.dosDateRejet = dosDateRejet;
    }

    public LocalDate getDosDatePublicationProvisoire() {
        return dosDatePublicationProvisoire;
    }

    public DossierAppelOffre dosDatePublicationProvisoire(LocalDate dosDatePublicationProvisoire) {
        this.dosDatePublicationProvisoire = dosDatePublicationProvisoire;
        return this;
    }

    public void setDosDatePublicationProvisoire(LocalDate dosDatePublicationProvisoire) {
        this.dosDatePublicationProvisoire = dosDatePublicationProvisoire;
    }

    public LocalDate getDosDatePublicationDefinitive() {
        return dosDatePublicationDefinitive;
    }

    public DossierAppelOffre dosDatePublicationDefinitive(LocalDate dosDatePublicationDefinitive) {
        this.dosDatePublicationDefinitive = dosDatePublicationDefinitive;
        return this;
    }

    public void setDosDatePublicationDefinitive(LocalDate dosDatePublicationDefinitive) {
        this.dosDatePublicationDefinitive = dosDatePublicationDefinitive;
    }

    public LocalDate getDosDateDemandePublication() {
        return dosDateDemandePublication;
    }

    public DossierAppelOffre dosDateDemandePublication(LocalDate dosDateDemandePublication) {
        this.dosDateDemandePublication = dosDateDemandePublication;
        return this;
    }

    public void setDosDateDemandePublication(LocalDate dosDateDemandePublication) {
        this.dosDateDemandePublication = dosDateDemandePublication;
    }

    public String getDosCommentaireDemandePublication() {
        return dosCommentaireDemandePublication;
    }

    public DossierAppelOffre dosCommentaireDemandePublication(String dosCommentaireDemandePublication) {
        this.dosCommentaireDemandePublication = dosCommentaireDemandePublication;
        return this;
    }

    public void setDosCommentaireDemandePublication(String dosCommentaireDemandePublication) {
        this.dosCommentaireDemandePublication = dosCommentaireDemandePublication;
    }

    public String getDosFichierDemandePublication() {
        return dosFichierDemandePublication;
    }

    public DossierAppelOffre dosFichierDemandePublication(String dosFichierDemandePublication) {
        this.dosFichierDemandePublication = dosFichierDemandePublication;
        return this;
    }

    public void setDosFichierDemandePublication(String dosFichierDemandePublication) {
        this.dosFichierDemandePublication = dosFichierDemandePublication;
    }

    public String getDosLieuAcquisitionDAO() {
        return dosLieuAcquisitionDAO;
    }

    public DossierAppelOffre dosLieuAcquisitionDAO(String dosLieuAcquisitionDAO) {
        this.dosLieuAcquisitionDAO = dosLieuAcquisitionDAO;
        return this;
    }

    public void setDosLieuAcquisitionDAO(String dosLieuAcquisitionDAO) {
        this.dosLieuAcquisitionDAO = dosLieuAcquisitionDAO;
    }

    public Integer getTelechargerDAO() {
        return telechargerDAO;
    }

    public DossierAppelOffre telechargerDAO(Integer telechargerDAO) {
        this.telechargerDAO = telechargerDAO;
        return this;
    }

    public void setTelechargerDAO(Integer telechargerDAO) {
        this.telechargerDAO = telechargerDAO;
    }

    public LocalDate getDosDateOuvertueDesplis() {
        return dosDateOuvertueDesplis;
    }

    public DossierAppelOffre dosDateOuvertueDesplis(LocalDate dosDateOuvertueDesplis) {
        this.dosDateOuvertueDesplis = dosDateOuvertueDesplis;
        return this;
    }

    public void setDosDateOuvertueDesplis(LocalDate dosDateOuvertueDesplis) {
        this.dosDateOuvertueDesplis = dosDateOuvertueDesplis;
    }

    public LocalDate getDosHeureOuvertureDesPlis() {
        return dosHeureOuvertureDesPlis;
    }

    public DossierAppelOffre dosHeureOuvertureDesPlis(LocalDate dosHeureOuvertureDesPlis) {
        this.dosHeureOuvertureDesPlis = dosHeureOuvertureDesPlis;
        return this;
    }

    public void setDosHeureOuvertureDesPlis(LocalDate dosHeureOuvertureDesPlis) {
        this.dosHeureOuvertureDesPlis = dosHeureOuvertureDesPlis;
    }

    public LocalDate getDosDatePublication() {
        return dosDatePublication;
    }

    public DossierAppelOffre dosDatePublication(LocalDate dosDatePublication) {
        this.dosDatePublication = dosDatePublication;
        return this;
    }

    public void setDosDatePublication(LocalDate dosDatePublication) {
        this.dosDatePublication = dosDatePublication;
    }

    public String getDosFicchierPublication() {
        return dosFicchierPublication;
    }

    public DossierAppelOffre dosFicchierPublication(String dosFicchierPublication) {
        this.dosFicchierPublication = dosFicchierPublication;
        return this;
    }

    public void setDosFicchierPublication(String dosFicchierPublication) {
        this.dosFicchierPublication = dosFicchierPublication;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public DossierAppelOffre autiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
        return this;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public BigDecimal getDosMontantGarantie() {
        return dosMontantGarantie;
    }

    public DossierAppelOffre dosMontantGarantie(BigDecimal dosMontantGarantie) {
        this.dosMontantGarantie = dosMontantGarantie;
        return this;
    }

    public void setDosMontantGarantie(BigDecimal dosMontantGarantie) {
        this.dosMontantGarantie = dosMontantGarantie;
    }

    public BigDecimal getDosMontantDao() {
        return dosMontantDao;
    }

    public DossierAppelOffre dosMontantDao(BigDecimal dosMontantDao) {
        this.dosMontantDao = dosMontantDao;
        return this;
    }

    public void setDosMontantDao(BigDecimal dosMontantDao) {
        this.dosMontantDao = dosMontantDao;
    }

    public BigDecimal getDosMontantEstime() {
        return dosMontantEstime;
    }

    public DossierAppelOffre dosMontantEstime(BigDecimal dosMontantEstime) {
        this.dosMontantEstime = dosMontantEstime;
        return this;
    }

    public void setDosMontantEstime(BigDecimal dosMontantEstime) {
        this.dosMontantEstime = dosMontantEstime;
    }

    public String getDosIncidents() {
        return dosIncidents;
    }

    public DossierAppelOffre dosIncidents(String dosIncidents) {
        this.dosIncidents = dosIncidents;
        return this;
    }

    public void setDosIncidents(String dosIncidents) {
        this.dosIncidents = dosIncidents;
    }

    public LocalDate getDateRemiseDossierTechnique() {
        return dateRemiseDossierTechnique;
    }

    public DossierAppelOffre dateRemiseDossierTechnique(LocalDate dateRemiseDossierTechnique) {
        this.dateRemiseDossierTechnique = dateRemiseDossierTechnique;
        return this;
    }

    public void setDateRemiseDossierTechnique(LocalDate dateRemiseDossierTechnique) {
        this.dateRemiseDossierTechnique = dateRemiseDossierTechnique;
    }

    public LocalDate getDateLimiteDossierTechnique() {
        return dateLimiteDossierTechnique;
    }

    public DossierAppelOffre dateLimiteDossierTechnique(LocalDate dateLimiteDossierTechnique) {
        this.dateLimiteDossierTechnique = dateLimiteDossierTechnique;
        return this;
    }

    public void setDateLimiteDossierTechnique(LocalDate dateLimiteDossierTechnique) {
        this.dateLimiteDossierTechnique = dateLimiteDossierTechnique;
    }

    public String getCommentaireDelaiTechnique() {
        return commentaireDelaiTechnique;
    }

    public DossierAppelOffre commentaireDelaiTechnique(String commentaireDelaiTechnique) {
        this.commentaireDelaiTechnique = commentaireDelaiTechnique;
        return this;
    }

    public void setCommentaireDelaiTechnique(String commentaireDelaiTechnique) {
        this.commentaireDelaiTechnique = commentaireDelaiTechnique;
    }

    public LocalDate getDosDateMiseValidationAttribution() {
        return dosDateMiseValidationAttribution;
    }

    public DossierAppelOffre dosDateMiseValidationAttribution(LocalDate dosDateMiseValidationAttribution) {
        this.dosDateMiseValidationAttribution = dosDateMiseValidationAttribution;
        return this;
    }

    public void setDosDateMiseValidationAttribution(LocalDate dosDateMiseValidationAttribution) {
        this.dosDateMiseValidationAttribution = dosDateMiseValidationAttribution;
    }

    public String getDosEtatValidation() {
        return dosEtatValidation;
    }

    public DossierAppelOffre dosEtatValidation(String dosEtatValidation) {
        this.dosEtatValidation = dosEtatValidation;
        return this;
    }

    public void setDosEtatValidation(String dosEtatValidation) {
        this.dosEtatValidation = dosEtatValidation;
    }

    public String getDosBordereau() {
        return dosBordereau;
    }

    public DossierAppelOffre dosBordereau(String dosBordereau) {
        this.dosBordereau = dosBordereau;
        return this;
    }

    public void setDosBordereau(String dosBordereau) {
        this.dosBordereau = dosBordereau;
    }

    public String getDosFichierMiseValidationPrequalif() {
        return dosFichierMiseValidationPrequalif;
    }

    public DossierAppelOffre dosFichierMiseValidationPrequalif(String dosFichierMiseValidationPrequalif) {
        this.dosFichierMiseValidationPrequalif = dosFichierMiseValidationPrequalif;
        return this;
    }

    public void setDosFichierMiseValidationPrequalif(String dosFichierMiseValidationPrequalif) {
        this.dosFichierMiseValidationPrequalif = dosFichierMiseValidationPrequalif;
    }

    public String getDosfichierSignature() {
        return dosfichierSignature;
    }

    public DossierAppelOffre dosfichierSignature(String dosfichierSignature) {
        this.dosfichierSignature = dosfichierSignature;
        return this;
    }

    public void setDosfichierSignature(String dosfichierSignature) {
        this.dosfichierSignature = dosfichierSignature;
    }

    public LocalDate getDosDateSignature() {
        return dosDateSignature;
    }

    public DossierAppelOffre dosDateSignature(LocalDate dosDateSignature) {
        this.dosDateSignature = dosDateSignature;
        return this;
    }

    public void setDosDateSignature(LocalDate dosDateSignature) {
        this.dosDateSignature = dosDateSignature;
    }

    public LocalDate getDosDateMiseValidationSignature() {
        return dosDateMiseValidationSignature;
    }

    public DossierAppelOffre dosDateMiseValidationSignature(LocalDate dosDateMiseValidationSignature) {
        this.dosDateMiseValidationSignature = dosDateMiseValidationSignature;
        return this;
    }

    public void setDosDateMiseValidationSignature(LocalDate dosDateMiseValidationSignature) {
        this.dosDateMiseValidationSignature = dosDateMiseValidationSignature;
    }

    public LocalDate getDosDateAttributionDefinitive() {
        return dosDateAttributionDefinitive;
    }

    public DossierAppelOffre dosDateAttributionDefinitive(LocalDate dosDateAttributionDefinitive) {
        this.dosDateAttributionDefinitive = dosDateAttributionDefinitive;
        return this;
    }

    public void setDosDateAttributionDefinitive(LocalDate dosDateAttributionDefinitive) {
        this.dosDateAttributionDefinitive = dosDateAttributionDefinitive;
    }

    public LocalDate getDosDateDemandeApprobation() {
        return dosDateDemandeApprobation;
    }

    public DossierAppelOffre dosDateDemandeApprobation(LocalDate dosDateDemandeApprobation) {
        this.dosDateDemandeApprobation = dosDateDemandeApprobation;
        return this;
    }

    public void setDosDateDemandeApprobation(LocalDate dosDateDemandeApprobation) {
        this.dosDateDemandeApprobation = dosDateDemandeApprobation;
    }

    public String getDosCommentDemandeApprobation() {
        return dosCommentDemandeApprobation;
    }

    public DossierAppelOffre dosCommentDemandeApprobation(String dosCommentDemandeApprobation) {
        this.dosCommentDemandeApprobation = dosCommentDemandeApprobation;
        return this;
    }

    public void setDosCommentDemandeApprobation(String dosCommentDemandeApprobation) {
        this.dosCommentDemandeApprobation = dosCommentDemandeApprobation;
    }

    public String getFichierApprobation() {
        return fichierApprobation;
    }

    public DossierAppelOffre fichierApprobation(String fichierApprobation) {
        this.fichierApprobation = fichierApprobation;
        return this;
    }

    public void setFichierApprobation(String fichierApprobation) {
        this.fichierApprobation = fichierApprobation;
    }

    public LocalDate getDosDateNotification() {
        return dosDateNotification;
    }

    public DossierAppelOffre dosDateNotification(LocalDate dosDateNotification) {
        this.dosDateNotification = dosDateNotification;
        return this;
    }

    public void setDosDateNotification(LocalDate dosDateNotification) {
        this.dosDateNotification = dosDateNotification;
    }

    public String getDosCommentNotification() {
        return dosCommentNotification;
    }

    public DossierAppelOffre dosCommentNotification(String dosCommentNotification) {
        this.dosCommentNotification = dosCommentNotification;
        return this;
    }

    public void setDosCommentNotification(String dosCommentNotification) {
        this.dosCommentNotification = dosCommentNotification;
    }

    public String getDosRefNotification() {
        return dosRefNotification;
    }

    public DossierAppelOffre dosRefNotification(String dosRefNotification) {
        this.dosRefNotification = dosRefNotification;
        return this;
    }

    public void setDosRefNotification(String dosRefNotification) {
        this.dosRefNotification = dosRefNotification;
    }

    public String getDosFichierNotification() {
        return dosFichierNotification;
    }

    public DossierAppelOffre dosFichierNotification(String dosFichierNotification) {
        this.dosFichierNotification = dosFichierNotification;
        return this;
    }

    public void setDosFichierNotification(String dosFichierNotification) {
        this.dosFichierNotification = dosFichierNotification;
    }

    public String getDosCommentaireAttributionDefinitive() {
        return dosCommentaireAttributionDefinitive;
    }

    public DossierAppelOffre dosCommentaireAttributionDefinitive(String dosCommentaireAttributionDefinitive) {
        this.dosCommentaireAttributionDefinitive = dosCommentaireAttributionDefinitive;
        return this;
    }

    public void setDosCommentaireAttributionDefinitive(String dosCommentaireAttributionDefinitive) {
        this.dosCommentaireAttributionDefinitive = dosCommentaireAttributionDefinitive;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public DossierAppelOffre appelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
        return this;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossierAppelOffre)) {
            return false;
        }
        return id != null && id.equals(((DossierAppelOffre) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossierAppelOffre{" +
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
            "}";
    }
}
