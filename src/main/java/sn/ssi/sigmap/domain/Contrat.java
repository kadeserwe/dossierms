package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * TABLE CONTRAT
 */
@Entity
@Table(name = "contrat")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "montant", precision = 21, scale = 2)
    private BigDecimal montant;

    @Column(name = "montant_verse", precision = 21, scale = 2)
    private BigDecimal montantVerse;

    @Column(name = "con_date_signature")
    private LocalDate conDateSignature;

    @Column(name = "con_date_approbation")
    private LocalDate conDateApprobation;

    @Column(name = "con_date_notification")
    private LocalDate conDateNotification;

    @Column(name = "con_date_recep_provisoire")
    private LocalDate conDateRecepProvisoire;

    @Column(name = "con_date_recep_definitive")
    private LocalDate conDateRecepDefinitive;

    @Column(name = "con_date_ordre_demarrage")
    private LocalDate conDateOrdreDemarrage;

    @Column(name = "condate_attribution_provisoire")
    private LocalDate condateAttributionProvisoire;

    @Column(name = "condate_attribution_definitive")
    private LocalDate condateAttributionDefinitive;

    @Column(name = "con_date_paiement")
    private LocalDate conDatePaiement;

    @Column(name = "date_demande_immatriculation")
    private LocalDate dateDemandeImmatriculation;

    @Column(name = "date_immatriculation")
    private LocalDate dateImmatriculation;

    @Column(name = "date_pub")
    private LocalDate datePub;

    @Column(name = "date_demande_pub_contrat")
    private LocalDate dateDemandePubContrat;

    @Column(name = "con_date_creation")
    private LocalDate conDateCreation;

    @Column(name = "renouvcont_date_demande_autorisation")
    private LocalDate renouvcontDateDemandeAutorisation;

    @Column(name = "renouvcont_dateautorisation")
    private LocalDate renouvcontDateautorisation;

    @Column(name = "renouvcont_date_demande_examen_juridique")
    private LocalDate renouvcontDateDemandeExamenJuridique;

    @Column(name = "renouvcont_date_examen_juridique")
    private LocalDate renouvcontDateExamenJuridique;

    @Column(name = "renouvcont_date_demande_approbation")
    private LocalDate renouvcontDateDemandeApprobation;

    @Column(name = "renouvcont_date_approbation")
    private LocalDate renouvcontDateApprobation;

    @Column(name = "renouvcont_date_rejet")
    private LocalDate renouvcontDateRejet;

    @Column(name = "renouvcont_date_retour_approbation")
    private LocalDate renouvcontDateRetourApprobation;

    @Column(name = "con_comment_signature")
    private String conCommentSignature;

    @Column(name = "con_ref_signature")
    private String conRefSignature;

    @Column(name = "con_comment_approbation")
    private String conCommentApprobation;

    @Column(name = "con_ref_approbation")
    private String conRefApprobation;

    @Column(name = "con_comment_notification")
    private String conCommentNotification;

    @Column(name = "con_ref_notification")
    private String conRefNotification;

    @Column(name = "con_fichier_recep_provisoire")
    private String conFichierRecepProvisoire;

    @Column(name = "con_comment_recep_provisoire")
    private String conCommentRecepProvisoire;

    @Column(name = "con_fichier_recep_definitive")
    private String conFichierRecepDefinitive;

    @Column(name = "con_comment_recep_definitive")
    private String conCommentRecepDefinitive;

    @Column(name = "con_fichier_ordre_demarrage")
    private String conFichierOrdreDemarrage;

    @Column(name = "con_comment_ordre_demarrage")
    private String conCommentOrdreDemarrage;

    @Column(name = "con_ref_attribution_provisoire")
    private String conRefAttributionProvisoire;

    @Column(name = "con_commentaire_attribution_provisoire")
    private String conCommentaireAttributionProvisoire;

    @Column(name = "con_ref_attribution_definitive")
    private String conRefAttributionDefinitive;

    @Column(name = "con_commentaire_attribution_definitive")
    private String conCommentaireAttributionDefinitive;

    @Column(name = "con_statut")
    private String conStatut;

    @Column(name = "num_matriculation")
    private String numMatriculation;

    @Column(name = "con_commentaire_dmdmat")
    private String conCommentaireDmdmat;

    @Column(name = "con_commentaire_matriculation")
    private String conCommentaireMatriculation;

    @Column(name = "conc_situation")
    private String concSituation;

    @Column(name = "nationnalite")
    private String nationnalite;

    @Column(name = "fichier_immatricule")
    private String fichierImmatricule;

    @Column(name = "fichier_justificatif")
    private String fichierJustificatif;

    @Column(name = "commentaire_pub")
    private String commentairePub;

    @Column(name = "fichier_contrat")
    private String fichierContrat;

    @Column(name = "con_comment_demande_pub")
    private String conCommentDemandePub;

    @Column(name = "renouvcont_fichier_autorisation_prealable")
    private String renouvcontFichierAutorisationPrealable;

    @Column(name = "renouvcont_fichier_examen_juridique")
    private String renouvcontFichierExamenJuridique;

    @Column(name = "renouvcont_fichier_contrat_signe")
    private String renouvcontFichierContratSigne;

    @Column(name = "renouvcont_fichier_page_garde")
    private String renouvcontFichierPageGarde;

    @Column(name = "renouvcont_fichier_page_signature")
    private String renouvcontFichierPageSignature;

    @Column(name = "renouvcont_fichier_rapport_motivation")
    private String renouvcontFichierRapportMotivation;

    @Column(name = "renouvcont_fichier_projet_contrat")
    private String renouvcontFichierProjetContrat;

    @Column(name = "renouvcont_comment_autorisation")
    private String renouvcontCommentAutorisation;

    @Column(name = "renouvcont_comment_demande_approbation")
    private String renouvcontCommentDemandeApprobation;

    @Column(name = "renouvcont_comment_examen_juridique")
    private String renouvcontCommentExamenJuridique;

    @Column(name = "autorite_id")
    private Long autoriteId;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "mode_passation_id")
    private Long modePassationId;

    @Column(name = "type_marche_id")
    private Long typeMarcheId;

    @Column(name = "immatriculation")
    private Integer immatriculation;

    @Column(name = "delai")
    private Integer delai;

    @Column(name = "renouvcont_immat_statut")
    private Boolean renouvcontImmatStatut;

    @Column(name = "renouvcont_pub_statut")
    private Boolean renouvcontPubStatut;

    @Column(name = "renouvcont_autorisation_statut")
    private Integer renouvcontAutorisationStatut;

    @Column(name = "renouvcont_examen_juridique_statut")
    private Integer renouvcontExamenJuridiqueStatut;

    @Column(name = "renouvcont_approbation_statut")
    private Integer renouvcontApprobationStatut;

    @Column(name = "etat_contratdebase")
    private String etatContratdebase;

    @Column(name = "libelle_lot")
    private String libelleLot;

    @ManyToOne
    @JsonIgnoreProperties(value = "contrats", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "contrats", allowSetters = true)
    private Lot lot;

    @ManyToOne
    @JsonIgnoreProperties(value = "contrats", allowSetters = true)
    private Fournisseur fournisseur;

    @ManyToOne
    @JsonIgnoreProperties(value = "contrats", allowSetters = true)
    private PlisOuverture plisOuverture;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public Contrat montant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getMontantVerse() {
        return montantVerse;
    }

    public Contrat montantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
        return this;
    }

    public void setMontantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
    }

    public LocalDate getConDateSignature() {
        return conDateSignature;
    }

    public Contrat conDateSignature(LocalDate conDateSignature) {
        this.conDateSignature = conDateSignature;
        return this;
    }

    public void setConDateSignature(LocalDate conDateSignature) {
        this.conDateSignature = conDateSignature;
    }

    public LocalDate getConDateApprobation() {
        return conDateApprobation;
    }

    public Contrat conDateApprobation(LocalDate conDateApprobation) {
        this.conDateApprobation = conDateApprobation;
        return this;
    }

    public void setConDateApprobation(LocalDate conDateApprobation) {
        this.conDateApprobation = conDateApprobation;
    }

    public LocalDate getConDateNotification() {
        return conDateNotification;
    }

    public Contrat conDateNotification(LocalDate conDateNotification) {
        this.conDateNotification = conDateNotification;
        return this;
    }

    public void setConDateNotification(LocalDate conDateNotification) {
        this.conDateNotification = conDateNotification;
    }

    public LocalDate getConDateRecepProvisoire() {
        return conDateRecepProvisoire;
    }

    public Contrat conDateRecepProvisoire(LocalDate conDateRecepProvisoire) {
        this.conDateRecepProvisoire = conDateRecepProvisoire;
        return this;
    }

    public void setConDateRecepProvisoire(LocalDate conDateRecepProvisoire) {
        this.conDateRecepProvisoire = conDateRecepProvisoire;
    }

    public LocalDate getConDateRecepDefinitive() {
        return conDateRecepDefinitive;
    }

    public Contrat conDateRecepDefinitive(LocalDate conDateRecepDefinitive) {
        this.conDateRecepDefinitive = conDateRecepDefinitive;
        return this;
    }

    public void setConDateRecepDefinitive(LocalDate conDateRecepDefinitive) {
        this.conDateRecepDefinitive = conDateRecepDefinitive;
    }

    public LocalDate getConDateOrdreDemarrage() {
        return conDateOrdreDemarrage;
    }

    public Contrat conDateOrdreDemarrage(LocalDate conDateOrdreDemarrage) {
        this.conDateOrdreDemarrage = conDateOrdreDemarrage;
        return this;
    }

    public void setConDateOrdreDemarrage(LocalDate conDateOrdreDemarrage) {
        this.conDateOrdreDemarrage = conDateOrdreDemarrage;
    }

    public LocalDate getCondateAttributionProvisoire() {
        return condateAttributionProvisoire;
    }

    public Contrat condateAttributionProvisoire(LocalDate condateAttributionProvisoire) {
        this.condateAttributionProvisoire = condateAttributionProvisoire;
        return this;
    }

    public void setCondateAttributionProvisoire(LocalDate condateAttributionProvisoire) {
        this.condateAttributionProvisoire = condateAttributionProvisoire;
    }

    public LocalDate getCondateAttributionDefinitive() {
        return condateAttributionDefinitive;
    }

    public Contrat condateAttributionDefinitive(LocalDate condateAttributionDefinitive) {
        this.condateAttributionDefinitive = condateAttributionDefinitive;
        return this;
    }

    public void setCondateAttributionDefinitive(LocalDate condateAttributionDefinitive) {
        this.condateAttributionDefinitive = condateAttributionDefinitive;
    }

    public LocalDate getConDatePaiement() {
        return conDatePaiement;
    }

    public Contrat conDatePaiement(LocalDate conDatePaiement) {
        this.conDatePaiement = conDatePaiement;
        return this;
    }

    public void setConDatePaiement(LocalDate conDatePaiement) {
        this.conDatePaiement = conDatePaiement;
    }

    public LocalDate getDateDemandeImmatriculation() {
        return dateDemandeImmatriculation;
    }

    public Contrat dateDemandeImmatriculation(LocalDate dateDemandeImmatriculation) {
        this.dateDemandeImmatriculation = dateDemandeImmatriculation;
        return this;
    }

    public void setDateDemandeImmatriculation(LocalDate dateDemandeImmatriculation) {
        this.dateDemandeImmatriculation = dateDemandeImmatriculation;
    }

    public LocalDate getDateImmatriculation() {
        return dateImmatriculation;
    }

    public Contrat dateImmatriculation(LocalDate dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
        return this;
    }

    public void setDateImmatriculation(LocalDate dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
    }

    public LocalDate getDatePub() {
        return datePub;
    }

    public Contrat datePub(LocalDate datePub) {
        this.datePub = datePub;
        return this;
    }

    public void setDatePub(LocalDate datePub) {
        this.datePub = datePub;
    }

    public LocalDate getDateDemandePubContrat() {
        return dateDemandePubContrat;
    }

    public Contrat dateDemandePubContrat(LocalDate dateDemandePubContrat) {
        this.dateDemandePubContrat = dateDemandePubContrat;
        return this;
    }

    public void setDateDemandePubContrat(LocalDate dateDemandePubContrat) {
        this.dateDemandePubContrat = dateDemandePubContrat;
    }

    public LocalDate getConDateCreation() {
        return conDateCreation;
    }

    public Contrat conDateCreation(LocalDate conDateCreation) {
        this.conDateCreation = conDateCreation;
        return this;
    }

    public void setConDateCreation(LocalDate conDateCreation) {
        this.conDateCreation = conDateCreation;
    }

    public LocalDate getRenouvcontDateDemandeAutorisation() {
        return renouvcontDateDemandeAutorisation;
    }

    public Contrat renouvcontDateDemandeAutorisation(LocalDate renouvcontDateDemandeAutorisation) {
        this.renouvcontDateDemandeAutorisation = renouvcontDateDemandeAutorisation;
        return this;
    }

    public void setRenouvcontDateDemandeAutorisation(LocalDate renouvcontDateDemandeAutorisation) {
        this.renouvcontDateDemandeAutorisation = renouvcontDateDemandeAutorisation;
    }

    public LocalDate getRenouvcontDateautorisation() {
        return renouvcontDateautorisation;
    }

    public Contrat renouvcontDateautorisation(LocalDate renouvcontDateautorisation) {
        this.renouvcontDateautorisation = renouvcontDateautorisation;
        return this;
    }

    public void setRenouvcontDateautorisation(LocalDate renouvcontDateautorisation) {
        this.renouvcontDateautorisation = renouvcontDateautorisation;
    }

    public LocalDate getRenouvcontDateDemandeExamenJuridique() {
        return renouvcontDateDemandeExamenJuridique;
    }

    public Contrat renouvcontDateDemandeExamenJuridique(LocalDate renouvcontDateDemandeExamenJuridique) {
        this.renouvcontDateDemandeExamenJuridique = renouvcontDateDemandeExamenJuridique;
        return this;
    }

    public void setRenouvcontDateDemandeExamenJuridique(LocalDate renouvcontDateDemandeExamenJuridique) {
        this.renouvcontDateDemandeExamenJuridique = renouvcontDateDemandeExamenJuridique;
    }

    public LocalDate getRenouvcontDateExamenJuridique() {
        return renouvcontDateExamenJuridique;
    }

    public Contrat renouvcontDateExamenJuridique(LocalDate renouvcontDateExamenJuridique) {
        this.renouvcontDateExamenJuridique = renouvcontDateExamenJuridique;
        return this;
    }

    public void setRenouvcontDateExamenJuridique(LocalDate renouvcontDateExamenJuridique) {
        this.renouvcontDateExamenJuridique = renouvcontDateExamenJuridique;
    }

    public LocalDate getRenouvcontDateDemandeApprobation() {
        return renouvcontDateDemandeApprobation;
    }

    public Contrat renouvcontDateDemandeApprobation(LocalDate renouvcontDateDemandeApprobation) {
        this.renouvcontDateDemandeApprobation = renouvcontDateDemandeApprobation;
        return this;
    }

    public void setRenouvcontDateDemandeApprobation(LocalDate renouvcontDateDemandeApprobation) {
        this.renouvcontDateDemandeApprobation = renouvcontDateDemandeApprobation;
    }

    public LocalDate getRenouvcontDateApprobation() {
        return renouvcontDateApprobation;
    }

    public Contrat renouvcontDateApprobation(LocalDate renouvcontDateApprobation) {
        this.renouvcontDateApprobation = renouvcontDateApprobation;
        return this;
    }

    public void setRenouvcontDateApprobation(LocalDate renouvcontDateApprobation) {
        this.renouvcontDateApprobation = renouvcontDateApprobation;
    }

    public LocalDate getRenouvcontDateRejet() {
        return renouvcontDateRejet;
    }

    public Contrat renouvcontDateRejet(LocalDate renouvcontDateRejet) {
        this.renouvcontDateRejet = renouvcontDateRejet;
        return this;
    }

    public void setRenouvcontDateRejet(LocalDate renouvcontDateRejet) {
        this.renouvcontDateRejet = renouvcontDateRejet;
    }

    public LocalDate getRenouvcontDateRetourApprobation() {
        return renouvcontDateRetourApprobation;
    }

    public Contrat renouvcontDateRetourApprobation(LocalDate renouvcontDateRetourApprobation) {
        this.renouvcontDateRetourApprobation = renouvcontDateRetourApprobation;
        return this;
    }

    public void setRenouvcontDateRetourApprobation(LocalDate renouvcontDateRetourApprobation) {
        this.renouvcontDateRetourApprobation = renouvcontDateRetourApprobation;
    }

    public String getConCommentSignature() {
        return conCommentSignature;
    }

    public Contrat conCommentSignature(String conCommentSignature) {
        this.conCommentSignature = conCommentSignature;
        return this;
    }

    public void setConCommentSignature(String conCommentSignature) {
        this.conCommentSignature = conCommentSignature;
    }

    public String getConRefSignature() {
        return conRefSignature;
    }

    public Contrat conRefSignature(String conRefSignature) {
        this.conRefSignature = conRefSignature;
        return this;
    }

    public void setConRefSignature(String conRefSignature) {
        this.conRefSignature = conRefSignature;
    }

    public String getConCommentApprobation() {
        return conCommentApprobation;
    }

    public Contrat conCommentApprobation(String conCommentApprobation) {
        this.conCommentApprobation = conCommentApprobation;
        return this;
    }

    public void setConCommentApprobation(String conCommentApprobation) {
        this.conCommentApprobation = conCommentApprobation;
    }

    public String getConRefApprobation() {
        return conRefApprobation;
    }

    public Contrat conRefApprobation(String conRefApprobation) {
        this.conRefApprobation = conRefApprobation;
        return this;
    }

    public void setConRefApprobation(String conRefApprobation) {
        this.conRefApprobation = conRefApprobation;
    }

    public String getConCommentNotification() {
        return conCommentNotification;
    }

    public Contrat conCommentNotification(String conCommentNotification) {
        this.conCommentNotification = conCommentNotification;
        return this;
    }

    public void setConCommentNotification(String conCommentNotification) {
        this.conCommentNotification = conCommentNotification;
    }

    public String getConRefNotification() {
        return conRefNotification;
    }

    public Contrat conRefNotification(String conRefNotification) {
        this.conRefNotification = conRefNotification;
        return this;
    }

    public void setConRefNotification(String conRefNotification) {
        this.conRefNotification = conRefNotification;
    }

    public String getConFichierRecepProvisoire() {
        return conFichierRecepProvisoire;
    }

    public Contrat conFichierRecepProvisoire(String conFichierRecepProvisoire) {
        this.conFichierRecepProvisoire = conFichierRecepProvisoire;
        return this;
    }

    public void setConFichierRecepProvisoire(String conFichierRecepProvisoire) {
        this.conFichierRecepProvisoire = conFichierRecepProvisoire;
    }

    public String getConCommentRecepProvisoire() {
        return conCommentRecepProvisoire;
    }

    public Contrat conCommentRecepProvisoire(String conCommentRecepProvisoire) {
        this.conCommentRecepProvisoire = conCommentRecepProvisoire;
        return this;
    }

    public void setConCommentRecepProvisoire(String conCommentRecepProvisoire) {
        this.conCommentRecepProvisoire = conCommentRecepProvisoire;
    }

    public String getConFichierRecepDefinitive() {
        return conFichierRecepDefinitive;
    }

    public Contrat conFichierRecepDefinitive(String conFichierRecepDefinitive) {
        this.conFichierRecepDefinitive = conFichierRecepDefinitive;
        return this;
    }

    public void setConFichierRecepDefinitive(String conFichierRecepDefinitive) {
        this.conFichierRecepDefinitive = conFichierRecepDefinitive;
    }

    public String getConCommentRecepDefinitive() {
        return conCommentRecepDefinitive;
    }

    public Contrat conCommentRecepDefinitive(String conCommentRecepDefinitive) {
        this.conCommentRecepDefinitive = conCommentRecepDefinitive;
        return this;
    }

    public void setConCommentRecepDefinitive(String conCommentRecepDefinitive) {
        this.conCommentRecepDefinitive = conCommentRecepDefinitive;
    }

    public String getConFichierOrdreDemarrage() {
        return conFichierOrdreDemarrage;
    }

    public Contrat conFichierOrdreDemarrage(String conFichierOrdreDemarrage) {
        this.conFichierOrdreDemarrage = conFichierOrdreDemarrage;
        return this;
    }

    public void setConFichierOrdreDemarrage(String conFichierOrdreDemarrage) {
        this.conFichierOrdreDemarrage = conFichierOrdreDemarrage;
    }

    public String getConCommentOrdreDemarrage() {
        return conCommentOrdreDemarrage;
    }

    public Contrat conCommentOrdreDemarrage(String conCommentOrdreDemarrage) {
        this.conCommentOrdreDemarrage = conCommentOrdreDemarrage;
        return this;
    }

    public void setConCommentOrdreDemarrage(String conCommentOrdreDemarrage) {
        this.conCommentOrdreDemarrage = conCommentOrdreDemarrage;
    }

    public String getConRefAttributionProvisoire() {
        return conRefAttributionProvisoire;
    }

    public Contrat conRefAttributionProvisoire(String conRefAttributionProvisoire) {
        this.conRefAttributionProvisoire = conRefAttributionProvisoire;
        return this;
    }

    public void setConRefAttributionProvisoire(String conRefAttributionProvisoire) {
        this.conRefAttributionProvisoire = conRefAttributionProvisoire;
    }

    public String getConCommentaireAttributionProvisoire() {
        return conCommentaireAttributionProvisoire;
    }

    public Contrat conCommentaireAttributionProvisoire(String conCommentaireAttributionProvisoire) {
        this.conCommentaireAttributionProvisoire = conCommentaireAttributionProvisoire;
        return this;
    }

    public void setConCommentaireAttributionProvisoire(String conCommentaireAttributionProvisoire) {
        this.conCommentaireAttributionProvisoire = conCommentaireAttributionProvisoire;
    }

    public String getConRefAttributionDefinitive() {
        return conRefAttributionDefinitive;
    }

    public Contrat conRefAttributionDefinitive(String conRefAttributionDefinitive) {
        this.conRefAttributionDefinitive = conRefAttributionDefinitive;
        return this;
    }

    public void setConRefAttributionDefinitive(String conRefAttributionDefinitive) {
        this.conRefAttributionDefinitive = conRefAttributionDefinitive;
    }

    public String getConCommentaireAttributionDefinitive() {
        return conCommentaireAttributionDefinitive;
    }

    public Contrat conCommentaireAttributionDefinitive(String conCommentaireAttributionDefinitive) {
        this.conCommentaireAttributionDefinitive = conCommentaireAttributionDefinitive;
        return this;
    }

    public void setConCommentaireAttributionDefinitive(String conCommentaireAttributionDefinitive) {
        this.conCommentaireAttributionDefinitive = conCommentaireAttributionDefinitive;
    }

    public String getConStatut() {
        return conStatut;
    }

    public Contrat conStatut(String conStatut) {
        this.conStatut = conStatut;
        return this;
    }

    public void setConStatut(String conStatut) {
        this.conStatut = conStatut;
    }

    public String getNumMatriculation() {
        return numMatriculation;
    }

    public Contrat numMatriculation(String numMatriculation) {
        this.numMatriculation = numMatriculation;
        return this;
    }

    public void setNumMatriculation(String numMatriculation) {
        this.numMatriculation = numMatriculation;
    }

    public String getConCommentaireDmdmat() {
        return conCommentaireDmdmat;
    }

    public Contrat conCommentaireDmdmat(String conCommentaireDmdmat) {
        this.conCommentaireDmdmat = conCommentaireDmdmat;
        return this;
    }

    public void setConCommentaireDmdmat(String conCommentaireDmdmat) {
        this.conCommentaireDmdmat = conCommentaireDmdmat;
    }

    public String getConCommentaireMatriculation() {
        return conCommentaireMatriculation;
    }

    public Contrat conCommentaireMatriculation(String conCommentaireMatriculation) {
        this.conCommentaireMatriculation = conCommentaireMatriculation;
        return this;
    }

    public void setConCommentaireMatriculation(String conCommentaireMatriculation) {
        this.conCommentaireMatriculation = conCommentaireMatriculation;
    }

    public String getConcSituation() {
        return concSituation;
    }

    public Contrat concSituation(String concSituation) {
        this.concSituation = concSituation;
        return this;
    }

    public void setConcSituation(String concSituation) {
        this.concSituation = concSituation;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public Contrat nationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
        return this;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getFichierImmatricule() {
        return fichierImmatricule;
    }

    public Contrat fichierImmatricule(String fichierImmatricule) {
        this.fichierImmatricule = fichierImmatricule;
        return this;
    }

    public void setFichierImmatricule(String fichierImmatricule) {
        this.fichierImmatricule = fichierImmatricule;
    }

    public String getFichierJustificatif() {
        return fichierJustificatif;
    }

    public Contrat fichierJustificatif(String fichierJustificatif) {
        this.fichierJustificatif = fichierJustificatif;
        return this;
    }

    public void setFichierJustificatif(String fichierJustificatif) {
        this.fichierJustificatif = fichierJustificatif;
    }

    public String getCommentairePub() {
        return commentairePub;
    }

    public Contrat commentairePub(String commentairePub) {
        this.commentairePub = commentairePub;
        return this;
    }

    public void setCommentairePub(String commentairePub) {
        this.commentairePub = commentairePub;
    }

    public String getFichierContrat() {
        return fichierContrat;
    }

    public Contrat fichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
        return this;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    public String getConCommentDemandePub() {
        return conCommentDemandePub;
    }

    public Contrat conCommentDemandePub(String conCommentDemandePub) {
        this.conCommentDemandePub = conCommentDemandePub;
        return this;
    }

    public void setConCommentDemandePub(String conCommentDemandePub) {
        this.conCommentDemandePub = conCommentDemandePub;
    }

    public String getRenouvcontFichierAutorisationPrealable() {
        return renouvcontFichierAutorisationPrealable;
    }

    public Contrat renouvcontFichierAutorisationPrealable(String renouvcontFichierAutorisationPrealable) {
        this.renouvcontFichierAutorisationPrealable = renouvcontFichierAutorisationPrealable;
        return this;
    }

    public void setRenouvcontFichierAutorisationPrealable(String renouvcontFichierAutorisationPrealable) {
        this.renouvcontFichierAutorisationPrealable = renouvcontFichierAutorisationPrealable;
    }

    public String getRenouvcontFichierExamenJuridique() {
        return renouvcontFichierExamenJuridique;
    }

    public Contrat renouvcontFichierExamenJuridique(String renouvcontFichierExamenJuridique) {
        this.renouvcontFichierExamenJuridique = renouvcontFichierExamenJuridique;
        return this;
    }

    public void setRenouvcontFichierExamenJuridique(String renouvcontFichierExamenJuridique) {
        this.renouvcontFichierExamenJuridique = renouvcontFichierExamenJuridique;
    }

    public String getRenouvcontFichierContratSigne() {
        return renouvcontFichierContratSigne;
    }

    public Contrat renouvcontFichierContratSigne(String renouvcontFichierContratSigne) {
        this.renouvcontFichierContratSigne = renouvcontFichierContratSigne;
        return this;
    }

    public void setRenouvcontFichierContratSigne(String renouvcontFichierContratSigne) {
        this.renouvcontFichierContratSigne = renouvcontFichierContratSigne;
    }

    public String getRenouvcontFichierPageGarde() {
        return renouvcontFichierPageGarde;
    }

    public Contrat renouvcontFichierPageGarde(String renouvcontFichierPageGarde) {
        this.renouvcontFichierPageGarde = renouvcontFichierPageGarde;
        return this;
    }

    public void setRenouvcontFichierPageGarde(String renouvcontFichierPageGarde) {
        this.renouvcontFichierPageGarde = renouvcontFichierPageGarde;
    }

    public String getRenouvcontFichierPageSignature() {
        return renouvcontFichierPageSignature;
    }

    public Contrat renouvcontFichierPageSignature(String renouvcontFichierPageSignature) {
        this.renouvcontFichierPageSignature = renouvcontFichierPageSignature;
        return this;
    }

    public void setRenouvcontFichierPageSignature(String renouvcontFichierPageSignature) {
        this.renouvcontFichierPageSignature = renouvcontFichierPageSignature;
    }

    public String getRenouvcontFichierRapportMotivation() {
        return renouvcontFichierRapportMotivation;
    }

    public Contrat renouvcontFichierRapportMotivation(String renouvcontFichierRapportMotivation) {
        this.renouvcontFichierRapportMotivation = renouvcontFichierRapportMotivation;
        return this;
    }

    public void setRenouvcontFichierRapportMotivation(String renouvcontFichierRapportMotivation) {
        this.renouvcontFichierRapportMotivation = renouvcontFichierRapportMotivation;
    }

    public String getRenouvcontFichierProjetContrat() {
        return renouvcontFichierProjetContrat;
    }

    public Contrat renouvcontFichierProjetContrat(String renouvcontFichierProjetContrat) {
        this.renouvcontFichierProjetContrat = renouvcontFichierProjetContrat;
        return this;
    }

    public void setRenouvcontFichierProjetContrat(String renouvcontFichierProjetContrat) {
        this.renouvcontFichierProjetContrat = renouvcontFichierProjetContrat;
    }

    public String getRenouvcontCommentAutorisation() {
        return renouvcontCommentAutorisation;
    }

    public Contrat renouvcontCommentAutorisation(String renouvcontCommentAutorisation) {
        this.renouvcontCommentAutorisation = renouvcontCommentAutorisation;
        return this;
    }

    public void setRenouvcontCommentAutorisation(String renouvcontCommentAutorisation) {
        this.renouvcontCommentAutorisation = renouvcontCommentAutorisation;
    }

    public String getRenouvcontCommentDemandeApprobation() {
        return renouvcontCommentDemandeApprobation;
    }

    public Contrat renouvcontCommentDemandeApprobation(String renouvcontCommentDemandeApprobation) {
        this.renouvcontCommentDemandeApprobation = renouvcontCommentDemandeApprobation;
        return this;
    }

    public void setRenouvcontCommentDemandeApprobation(String renouvcontCommentDemandeApprobation) {
        this.renouvcontCommentDemandeApprobation = renouvcontCommentDemandeApprobation;
    }

    public String getRenouvcontCommentExamenJuridique() {
        return renouvcontCommentExamenJuridique;
    }

    public Contrat renouvcontCommentExamenJuridique(String renouvcontCommentExamenJuridique) {
        this.renouvcontCommentExamenJuridique = renouvcontCommentExamenJuridique;
        return this;
    }

    public void setRenouvcontCommentExamenJuridique(String renouvcontCommentExamenJuridique) {
        this.renouvcontCommentExamenJuridique = renouvcontCommentExamenJuridique;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public Contrat autoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
        return this;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public Contrat serviceId(Long serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getModePassationId() {
        return modePassationId;
    }

    public Contrat modePassationId(Long modePassationId) {
        this.modePassationId = modePassationId;
        return this;
    }

    public void setModePassationId(Long modePassationId) {
        this.modePassationId = modePassationId;
    }

    public Long getTypeMarcheId() {
        return typeMarcheId;
    }

    public Contrat typeMarcheId(Long typeMarcheId) {
        this.typeMarcheId = typeMarcheId;
        return this;
    }

    public void setTypeMarcheId(Long typeMarcheId) {
        this.typeMarcheId = typeMarcheId;
    }

    public Integer getImmatriculation() {
        return immatriculation;
    }

    public Contrat immatriculation(Integer immatriculation) {
        this.immatriculation = immatriculation;
        return this;
    }

    public void setImmatriculation(Integer immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Integer getDelai() {
        return delai;
    }

    public Contrat delai(Integer delai) {
        this.delai = delai;
        return this;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Boolean isRenouvcontImmatStatut() {
        return renouvcontImmatStatut;
    }

    public Contrat renouvcontImmatStatut(Boolean renouvcontImmatStatut) {
        this.renouvcontImmatStatut = renouvcontImmatStatut;
        return this;
    }

    public void setRenouvcontImmatStatut(Boolean renouvcontImmatStatut) {
        this.renouvcontImmatStatut = renouvcontImmatStatut;
    }

    public Boolean isRenouvcontPubStatut() {
        return renouvcontPubStatut;
    }

    public Contrat renouvcontPubStatut(Boolean renouvcontPubStatut) {
        this.renouvcontPubStatut = renouvcontPubStatut;
        return this;
    }

    public void setRenouvcontPubStatut(Boolean renouvcontPubStatut) {
        this.renouvcontPubStatut = renouvcontPubStatut;
    }

    public Integer getRenouvcontAutorisationStatut() {
        return renouvcontAutorisationStatut;
    }

    public Contrat renouvcontAutorisationStatut(Integer renouvcontAutorisationStatut) {
        this.renouvcontAutorisationStatut = renouvcontAutorisationStatut;
        return this;
    }

    public void setRenouvcontAutorisationStatut(Integer renouvcontAutorisationStatut) {
        this.renouvcontAutorisationStatut = renouvcontAutorisationStatut;
    }

    public Integer getRenouvcontExamenJuridiqueStatut() {
        return renouvcontExamenJuridiqueStatut;
    }

    public Contrat renouvcontExamenJuridiqueStatut(Integer renouvcontExamenJuridiqueStatut) {
        this.renouvcontExamenJuridiqueStatut = renouvcontExamenJuridiqueStatut;
        return this;
    }

    public void setRenouvcontExamenJuridiqueStatut(Integer renouvcontExamenJuridiqueStatut) {
        this.renouvcontExamenJuridiqueStatut = renouvcontExamenJuridiqueStatut;
    }

    public Integer getRenouvcontApprobationStatut() {
        return renouvcontApprobationStatut;
    }

    public Contrat renouvcontApprobationStatut(Integer renouvcontApprobationStatut) {
        this.renouvcontApprobationStatut = renouvcontApprobationStatut;
        return this;
    }

    public void setRenouvcontApprobationStatut(Integer renouvcontApprobationStatut) {
        this.renouvcontApprobationStatut = renouvcontApprobationStatut;
    }

    public String getEtatContratdebase() {
        return etatContratdebase;
    }

    public Contrat etatContratdebase(String etatContratdebase) {
        this.etatContratdebase = etatContratdebase;
        return this;
    }

    public void setEtatContratdebase(String etatContratdebase) {
        this.etatContratdebase = etatContratdebase;
    }

    public String getLibelleLot() {
        return libelleLot;
    }

    public Contrat libelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
        return this;
    }

    public void setLibelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public Contrat dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Lot getLot() {
        return lot;
    }

    public Contrat lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public Contrat fournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        return this;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public Contrat plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contrat)) {
            return false;
        }
        return id != null && id.equals(((Contrat) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Contrat{" +
            "id=" + getId() +
            ", montant=" + getMontant() +
            ", montantVerse=" + getMontantVerse() +
            ", conDateSignature='" + getConDateSignature() + "'" +
            ", conDateApprobation='" + getConDateApprobation() + "'" +
            ", conDateNotification='" + getConDateNotification() + "'" +
            ", conDateRecepProvisoire='" + getConDateRecepProvisoire() + "'" +
            ", conDateRecepDefinitive='" + getConDateRecepDefinitive() + "'" +
            ", conDateOrdreDemarrage='" + getConDateOrdreDemarrage() + "'" +
            ", condateAttributionProvisoire='" + getCondateAttributionProvisoire() + "'" +
            ", condateAttributionDefinitive='" + getCondateAttributionDefinitive() + "'" +
            ", conDatePaiement='" + getConDatePaiement() + "'" +
            ", dateDemandeImmatriculation='" + getDateDemandeImmatriculation() + "'" +
            ", dateImmatriculation='" + getDateImmatriculation() + "'" +
            ", datePub='" + getDatePub() + "'" +
            ", dateDemandePubContrat='" + getDateDemandePubContrat() + "'" +
            ", conDateCreation='" + getConDateCreation() + "'" +
            ", renouvcontDateDemandeAutorisation='" + getRenouvcontDateDemandeAutorisation() + "'" +
            ", renouvcontDateautorisation='" + getRenouvcontDateautorisation() + "'" +
            ", renouvcontDateDemandeExamenJuridique='" + getRenouvcontDateDemandeExamenJuridique() + "'" +
            ", renouvcontDateExamenJuridique='" + getRenouvcontDateExamenJuridique() + "'" +
            ", renouvcontDateDemandeApprobation='" + getRenouvcontDateDemandeApprobation() + "'" +
            ", renouvcontDateApprobation='" + getRenouvcontDateApprobation() + "'" +
            ", renouvcontDateRejet='" + getRenouvcontDateRejet() + "'" +
            ", renouvcontDateRetourApprobation='" + getRenouvcontDateRetourApprobation() + "'" +
            ", conCommentSignature='" + getConCommentSignature() + "'" +
            ", conRefSignature='" + getConRefSignature() + "'" +
            ", conCommentApprobation='" + getConCommentApprobation() + "'" +
            ", conRefApprobation='" + getConRefApprobation() + "'" +
            ", conCommentNotification='" + getConCommentNotification() + "'" +
            ", conRefNotification='" + getConRefNotification() + "'" +
            ", conFichierRecepProvisoire='" + getConFichierRecepProvisoire() + "'" +
            ", conCommentRecepProvisoire='" + getConCommentRecepProvisoire() + "'" +
            ", conFichierRecepDefinitive='" + getConFichierRecepDefinitive() + "'" +
            ", conCommentRecepDefinitive='" + getConCommentRecepDefinitive() + "'" +
            ", conFichierOrdreDemarrage='" + getConFichierOrdreDemarrage() + "'" +
            ", conCommentOrdreDemarrage='" + getConCommentOrdreDemarrage() + "'" +
            ", conRefAttributionProvisoire='" + getConRefAttributionProvisoire() + "'" +
            ", conCommentaireAttributionProvisoire='" + getConCommentaireAttributionProvisoire() + "'" +
            ", conRefAttributionDefinitive='" + getConRefAttributionDefinitive() + "'" +
            ", conCommentaireAttributionDefinitive='" + getConCommentaireAttributionDefinitive() + "'" +
            ", conStatut='" + getConStatut() + "'" +
            ", numMatriculation='" + getNumMatriculation() + "'" +
            ", conCommentaireDmdmat='" + getConCommentaireDmdmat() + "'" +
            ", conCommentaireMatriculation='" + getConCommentaireMatriculation() + "'" +
            ", concSituation='" + getConcSituation() + "'" +
            ", nationnalite='" + getNationnalite() + "'" +
            ", fichierImmatricule='" + getFichierImmatricule() + "'" +
            ", fichierJustificatif='" + getFichierJustificatif() + "'" +
            ", commentairePub='" + getCommentairePub() + "'" +
            ", fichierContrat='" + getFichierContrat() + "'" +
            ", conCommentDemandePub='" + getConCommentDemandePub() + "'" +
            ", renouvcontFichierAutorisationPrealable='" + getRenouvcontFichierAutorisationPrealable() + "'" +
            ", renouvcontFichierExamenJuridique='" + getRenouvcontFichierExamenJuridique() + "'" +
            ", renouvcontFichierContratSigne='" + getRenouvcontFichierContratSigne() + "'" +
            ", renouvcontFichierPageGarde='" + getRenouvcontFichierPageGarde() + "'" +
            ", renouvcontFichierPageSignature='" + getRenouvcontFichierPageSignature() + "'" +
            ", renouvcontFichierRapportMotivation='" + getRenouvcontFichierRapportMotivation() + "'" +
            ", renouvcontFichierProjetContrat='" + getRenouvcontFichierProjetContrat() + "'" +
            ", renouvcontCommentAutorisation='" + getRenouvcontCommentAutorisation() + "'" +
            ", renouvcontCommentDemandeApprobation='" + getRenouvcontCommentDemandeApprobation() + "'" +
            ", renouvcontCommentExamenJuridique='" + getRenouvcontCommentExamenJuridique() + "'" +
            ", autoriteId=" + getAutoriteId() +
            ", serviceId=" + getServiceId() +
            ", modePassationId=" + getModePassationId() +
            ", typeMarcheId=" + getTypeMarcheId() +
            ", immatriculation=" + getImmatriculation() +
            ", delai=" + getDelai() +
            ", renouvcontImmatStatut='" + isRenouvcontImmatStatut() + "'" +
            ", renouvcontPubStatut='" + isRenouvcontPubStatut() + "'" +
            ", renouvcontAutorisationStatut=" + getRenouvcontAutorisationStatut() +
            ", renouvcontExamenJuridiqueStatut=" + getRenouvcontExamenJuridiqueStatut() +
            ", renouvcontApprobationStatut=" + getRenouvcontApprobationStatut() +
            ", etatContratdebase='" + getEtatContratdebase() + "'" +
            ", libelleLot='" + getLibelleLot() + "'" +
            "}";
    }
}
