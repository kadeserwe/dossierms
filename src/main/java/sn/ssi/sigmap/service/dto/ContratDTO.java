package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Contrat} entity.
 */
@ApiModel(description = "TABLE CONTRAT")
public class ContratDTO implements Serializable {
    
    private Long id;

    private BigDecimal montant;

    private BigDecimal montantVerse;

    private LocalDate conDateSignature;

    private LocalDate conDateApprobation;

    private LocalDate conDateNotification;

    private LocalDate conDateRecepProvisoire;

    private LocalDate conDateRecepDefinitive;

    private LocalDate conDateOrdreDemarrage;

    private LocalDate condateAttributionProvisoire;

    private LocalDate condateAttributionDefinitive;

    private LocalDate conDatePaiement;

    private LocalDate dateDemandeImmatriculation;

    private LocalDate dateImmatriculation;

    private LocalDate datePub;

    private LocalDate dateDemandePubContrat;

    private LocalDate conDateCreation;

    private LocalDate renouvcontDateDemandeAutorisation;

    private LocalDate renouvcontDateautorisation;

    private LocalDate renouvcontDateDemandeExamenJuridique;

    private LocalDate renouvcontDateExamenJuridique;

    private LocalDate renouvcontDateDemandeApprobation;

    private LocalDate renouvcontDateApprobation;

    private LocalDate renouvcontDateRejet;

    private LocalDate renouvcontDateRetourApprobation;

    private String conCommentSignature;

    private String conRefSignature;

    private String conCommentApprobation;

    private String conRefApprobation;

    private String conCommentNotification;

    private String conRefNotification;

    private String conFichierRecepProvisoire;

    private String conCommentRecepProvisoire;

    private String conFichierRecepDefinitive;

    private String conCommentRecepDefinitive;

    private String conFichierOrdreDemarrage;

    private String conCommentOrdreDemarrage;

    private String conRefAttributionProvisoire;

    private String conCommentaireAttributionProvisoire;

    private String conRefAttributionDefinitive;

    private String conCommentaireAttributionDefinitive;

    private String conStatut;

    private String numMatriculation;

    private String conCommentaireDmdmat;

    private String conCommentaireMatriculation;

    private String concSituation;

    private String nationnalite;

    private String fichierImmatricule;

    private String fichierJustificatif;

    private String commentairePub;

    private String fichierContrat;

    private String conCommentDemandePub;

    private String renouvcontFichierAutorisationPrealable;

    private String renouvcontFichierExamenJuridique;

    private String renouvcontFichierContratSigne;

    private String renouvcontFichierPageGarde;

    private String renouvcontFichierPageSignature;

    private String renouvcontFichierRapportMotivation;

    private String renouvcontFichierProjetContrat;

    private String renouvcontCommentAutorisation;

    private String renouvcontCommentDemandeApprobation;

    private String renouvcontCommentExamenJuridique;

    private Long autoriteId;

    private Long serviceId;

    private Long modePassationId;

    private Long typeMarcheId;

    private Integer immatriculation;

    private Integer delai;

    private Boolean renouvcontImmatStatut;

    private Boolean renouvcontPubStatut;

    private Integer renouvcontAutorisationStatut;

    private Integer renouvcontExamenJuridiqueStatut;

    private Integer renouvcontApprobationStatut;

    private String etatContratdebase;

    private String libelleLot;


    private Long dossierAppelOffreId;

    private Long lotId;

    private Long fournisseurId;

    private Long plisOuvertureId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getMontantVerse() {
        return montantVerse;
    }

    public void setMontantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
    }

    public LocalDate getConDateSignature() {
        return conDateSignature;
    }

    public void setConDateSignature(LocalDate conDateSignature) {
        this.conDateSignature = conDateSignature;
    }

    public LocalDate getConDateApprobation() {
        return conDateApprobation;
    }

    public void setConDateApprobation(LocalDate conDateApprobation) {
        this.conDateApprobation = conDateApprobation;
    }

    public LocalDate getConDateNotification() {
        return conDateNotification;
    }

    public void setConDateNotification(LocalDate conDateNotification) {
        this.conDateNotification = conDateNotification;
    }

    public LocalDate getConDateRecepProvisoire() {
        return conDateRecepProvisoire;
    }

    public void setConDateRecepProvisoire(LocalDate conDateRecepProvisoire) {
        this.conDateRecepProvisoire = conDateRecepProvisoire;
    }

    public LocalDate getConDateRecepDefinitive() {
        return conDateRecepDefinitive;
    }

    public void setConDateRecepDefinitive(LocalDate conDateRecepDefinitive) {
        this.conDateRecepDefinitive = conDateRecepDefinitive;
    }

    public LocalDate getConDateOrdreDemarrage() {
        return conDateOrdreDemarrage;
    }

    public void setConDateOrdreDemarrage(LocalDate conDateOrdreDemarrage) {
        this.conDateOrdreDemarrage = conDateOrdreDemarrage;
    }

    public LocalDate getCondateAttributionProvisoire() {
        return condateAttributionProvisoire;
    }

    public void setCondateAttributionProvisoire(LocalDate condateAttributionProvisoire) {
        this.condateAttributionProvisoire = condateAttributionProvisoire;
    }

    public LocalDate getCondateAttributionDefinitive() {
        return condateAttributionDefinitive;
    }

    public void setCondateAttributionDefinitive(LocalDate condateAttributionDefinitive) {
        this.condateAttributionDefinitive = condateAttributionDefinitive;
    }

    public LocalDate getConDatePaiement() {
        return conDatePaiement;
    }

    public void setConDatePaiement(LocalDate conDatePaiement) {
        this.conDatePaiement = conDatePaiement;
    }

    public LocalDate getDateDemandeImmatriculation() {
        return dateDemandeImmatriculation;
    }

    public void setDateDemandeImmatriculation(LocalDate dateDemandeImmatriculation) {
        this.dateDemandeImmatriculation = dateDemandeImmatriculation;
    }

    public LocalDate getDateImmatriculation() {
        return dateImmatriculation;
    }

    public void setDateImmatriculation(LocalDate dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
    }

    public LocalDate getDatePub() {
        return datePub;
    }

    public void setDatePub(LocalDate datePub) {
        this.datePub = datePub;
    }

    public LocalDate getDateDemandePubContrat() {
        return dateDemandePubContrat;
    }

    public void setDateDemandePubContrat(LocalDate dateDemandePubContrat) {
        this.dateDemandePubContrat = dateDemandePubContrat;
    }

    public LocalDate getConDateCreation() {
        return conDateCreation;
    }

    public void setConDateCreation(LocalDate conDateCreation) {
        this.conDateCreation = conDateCreation;
    }

    public LocalDate getRenouvcontDateDemandeAutorisation() {
        return renouvcontDateDemandeAutorisation;
    }

    public void setRenouvcontDateDemandeAutorisation(LocalDate renouvcontDateDemandeAutorisation) {
        this.renouvcontDateDemandeAutorisation = renouvcontDateDemandeAutorisation;
    }

    public LocalDate getRenouvcontDateautorisation() {
        return renouvcontDateautorisation;
    }

    public void setRenouvcontDateautorisation(LocalDate renouvcontDateautorisation) {
        this.renouvcontDateautorisation = renouvcontDateautorisation;
    }

    public LocalDate getRenouvcontDateDemandeExamenJuridique() {
        return renouvcontDateDemandeExamenJuridique;
    }

    public void setRenouvcontDateDemandeExamenJuridique(LocalDate renouvcontDateDemandeExamenJuridique) {
        this.renouvcontDateDemandeExamenJuridique = renouvcontDateDemandeExamenJuridique;
    }

    public LocalDate getRenouvcontDateExamenJuridique() {
        return renouvcontDateExamenJuridique;
    }

    public void setRenouvcontDateExamenJuridique(LocalDate renouvcontDateExamenJuridique) {
        this.renouvcontDateExamenJuridique = renouvcontDateExamenJuridique;
    }

    public LocalDate getRenouvcontDateDemandeApprobation() {
        return renouvcontDateDemandeApprobation;
    }

    public void setRenouvcontDateDemandeApprobation(LocalDate renouvcontDateDemandeApprobation) {
        this.renouvcontDateDemandeApprobation = renouvcontDateDemandeApprobation;
    }

    public LocalDate getRenouvcontDateApprobation() {
        return renouvcontDateApprobation;
    }

    public void setRenouvcontDateApprobation(LocalDate renouvcontDateApprobation) {
        this.renouvcontDateApprobation = renouvcontDateApprobation;
    }

    public LocalDate getRenouvcontDateRejet() {
        return renouvcontDateRejet;
    }

    public void setRenouvcontDateRejet(LocalDate renouvcontDateRejet) {
        this.renouvcontDateRejet = renouvcontDateRejet;
    }

    public LocalDate getRenouvcontDateRetourApprobation() {
        return renouvcontDateRetourApprobation;
    }

    public void setRenouvcontDateRetourApprobation(LocalDate renouvcontDateRetourApprobation) {
        this.renouvcontDateRetourApprobation = renouvcontDateRetourApprobation;
    }

    public String getConCommentSignature() {
        return conCommentSignature;
    }

    public void setConCommentSignature(String conCommentSignature) {
        this.conCommentSignature = conCommentSignature;
    }

    public String getConRefSignature() {
        return conRefSignature;
    }

    public void setConRefSignature(String conRefSignature) {
        this.conRefSignature = conRefSignature;
    }

    public String getConCommentApprobation() {
        return conCommentApprobation;
    }

    public void setConCommentApprobation(String conCommentApprobation) {
        this.conCommentApprobation = conCommentApprobation;
    }

    public String getConRefApprobation() {
        return conRefApprobation;
    }

    public void setConRefApprobation(String conRefApprobation) {
        this.conRefApprobation = conRefApprobation;
    }

    public String getConCommentNotification() {
        return conCommentNotification;
    }

    public void setConCommentNotification(String conCommentNotification) {
        this.conCommentNotification = conCommentNotification;
    }

    public String getConRefNotification() {
        return conRefNotification;
    }

    public void setConRefNotification(String conRefNotification) {
        this.conRefNotification = conRefNotification;
    }

    public String getConFichierRecepProvisoire() {
        return conFichierRecepProvisoire;
    }

    public void setConFichierRecepProvisoire(String conFichierRecepProvisoire) {
        this.conFichierRecepProvisoire = conFichierRecepProvisoire;
    }

    public String getConCommentRecepProvisoire() {
        return conCommentRecepProvisoire;
    }

    public void setConCommentRecepProvisoire(String conCommentRecepProvisoire) {
        this.conCommentRecepProvisoire = conCommentRecepProvisoire;
    }

    public String getConFichierRecepDefinitive() {
        return conFichierRecepDefinitive;
    }

    public void setConFichierRecepDefinitive(String conFichierRecepDefinitive) {
        this.conFichierRecepDefinitive = conFichierRecepDefinitive;
    }

    public String getConCommentRecepDefinitive() {
        return conCommentRecepDefinitive;
    }

    public void setConCommentRecepDefinitive(String conCommentRecepDefinitive) {
        this.conCommentRecepDefinitive = conCommentRecepDefinitive;
    }

    public String getConFichierOrdreDemarrage() {
        return conFichierOrdreDemarrage;
    }

    public void setConFichierOrdreDemarrage(String conFichierOrdreDemarrage) {
        this.conFichierOrdreDemarrage = conFichierOrdreDemarrage;
    }

    public String getConCommentOrdreDemarrage() {
        return conCommentOrdreDemarrage;
    }

    public void setConCommentOrdreDemarrage(String conCommentOrdreDemarrage) {
        this.conCommentOrdreDemarrage = conCommentOrdreDemarrage;
    }

    public String getConRefAttributionProvisoire() {
        return conRefAttributionProvisoire;
    }

    public void setConRefAttributionProvisoire(String conRefAttributionProvisoire) {
        this.conRefAttributionProvisoire = conRefAttributionProvisoire;
    }

    public String getConCommentaireAttributionProvisoire() {
        return conCommentaireAttributionProvisoire;
    }

    public void setConCommentaireAttributionProvisoire(String conCommentaireAttributionProvisoire) {
        this.conCommentaireAttributionProvisoire = conCommentaireAttributionProvisoire;
    }

    public String getConRefAttributionDefinitive() {
        return conRefAttributionDefinitive;
    }

    public void setConRefAttributionDefinitive(String conRefAttributionDefinitive) {
        this.conRefAttributionDefinitive = conRefAttributionDefinitive;
    }

    public String getConCommentaireAttributionDefinitive() {
        return conCommentaireAttributionDefinitive;
    }

    public void setConCommentaireAttributionDefinitive(String conCommentaireAttributionDefinitive) {
        this.conCommentaireAttributionDefinitive = conCommentaireAttributionDefinitive;
    }

    public String getConStatut() {
        return conStatut;
    }

    public void setConStatut(String conStatut) {
        this.conStatut = conStatut;
    }

    public String getNumMatriculation() {
        return numMatriculation;
    }

    public void setNumMatriculation(String numMatriculation) {
        this.numMatriculation = numMatriculation;
    }

    public String getConCommentaireDmdmat() {
        return conCommentaireDmdmat;
    }

    public void setConCommentaireDmdmat(String conCommentaireDmdmat) {
        this.conCommentaireDmdmat = conCommentaireDmdmat;
    }

    public String getConCommentaireMatriculation() {
        return conCommentaireMatriculation;
    }

    public void setConCommentaireMatriculation(String conCommentaireMatriculation) {
        this.conCommentaireMatriculation = conCommentaireMatriculation;
    }

    public String getConcSituation() {
        return concSituation;
    }

    public void setConcSituation(String concSituation) {
        this.concSituation = concSituation;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getFichierImmatricule() {
        return fichierImmatricule;
    }

    public void setFichierImmatricule(String fichierImmatricule) {
        this.fichierImmatricule = fichierImmatricule;
    }

    public String getFichierJustificatif() {
        return fichierJustificatif;
    }

    public void setFichierJustificatif(String fichierJustificatif) {
        this.fichierJustificatif = fichierJustificatif;
    }

    public String getCommentairePub() {
        return commentairePub;
    }

    public void setCommentairePub(String commentairePub) {
        this.commentairePub = commentairePub;
    }

    public String getFichierContrat() {
        return fichierContrat;
    }

    public void setFichierContrat(String fichierContrat) {
        this.fichierContrat = fichierContrat;
    }

    public String getConCommentDemandePub() {
        return conCommentDemandePub;
    }

    public void setConCommentDemandePub(String conCommentDemandePub) {
        this.conCommentDemandePub = conCommentDemandePub;
    }

    public String getRenouvcontFichierAutorisationPrealable() {
        return renouvcontFichierAutorisationPrealable;
    }

    public void setRenouvcontFichierAutorisationPrealable(String renouvcontFichierAutorisationPrealable) {
        this.renouvcontFichierAutorisationPrealable = renouvcontFichierAutorisationPrealable;
    }

    public String getRenouvcontFichierExamenJuridique() {
        return renouvcontFichierExamenJuridique;
    }

    public void setRenouvcontFichierExamenJuridique(String renouvcontFichierExamenJuridique) {
        this.renouvcontFichierExamenJuridique = renouvcontFichierExamenJuridique;
    }

    public String getRenouvcontFichierContratSigne() {
        return renouvcontFichierContratSigne;
    }

    public void setRenouvcontFichierContratSigne(String renouvcontFichierContratSigne) {
        this.renouvcontFichierContratSigne = renouvcontFichierContratSigne;
    }

    public String getRenouvcontFichierPageGarde() {
        return renouvcontFichierPageGarde;
    }

    public void setRenouvcontFichierPageGarde(String renouvcontFichierPageGarde) {
        this.renouvcontFichierPageGarde = renouvcontFichierPageGarde;
    }

    public String getRenouvcontFichierPageSignature() {
        return renouvcontFichierPageSignature;
    }

    public void setRenouvcontFichierPageSignature(String renouvcontFichierPageSignature) {
        this.renouvcontFichierPageSignature = renouvcontFichierPageSignature;
    }

    public String getRenouvcontFichierRapportMotivation() {
        return renouvcontFichierRapportMotivation;
    }

    public void setRenouvcontFichierRapportMotivation(String renouvcontFichierRapportMotivation) {
        this.renouvcontFichierRapportMotivation = renouvcontFichierRapportMotivation;
    }

    public String getRenouvcontFichierProjetContrat() {
        return renouvcontFichierProjetContrat;
    }

    public void setRenouvcontFichierProjetContrat(String renouvcontFichierProjetContrat) {
        this.renouvcontFichierProjetContrat = renouvcontFichierProjetContrat;
    }

    public String getRenouvcontCommentAutorisation() {
        return renouvcontCommentAutorisation;
    }

    public void setRenouvcontCommentAutorisation(String renouvcontCommentAutorisation) {
        this.renouvcontCommentAutorisation = renouvcontCommentAutorisation;
    }

    public String getRenouvcontCommentDemandeApprobation() {
        return renouvcontCommentDemandeApprobation;
    }

    public void setRenouvcontCommentDemandeApprobation(String renouvcontCommentDemandeApprobation) {
        this.renouvcontCommentDemandeApprobation = renouvcontCommentDemandeApprobation;
    }

    public String getRenouvcontCommentExamenJuridique() {
        return renouvcontCommentExamenJuridique;
    }

    public void setRenouvcontCommentExamenJuridique(String renouvcontCommentExamenJuridique) {
        this.renouvcontCommentExamenJuridique = renouvcontCommentExamenJuridique;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getModePassationId() {
        return modePassationId;
    }

    public void setModePassationId(Long modePassationId) {
        this.modePassationId = modePassationId;
    }

    public Long getTypeMarcheId() {
        return typeMarcheId;
    }

    public void setTypeMarcheId(Long typeMarcheId) {
        this.typeMarcheId = typeMarcheId;
    }

    public Integer getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(Integer immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Boolean isRenouvcontImmatStatut() {
        return renouvcontImmatStatut;
    }

    public void setRenouvcontImmatStatut(Boolean renouvcontImmatStatut) {
        this.renouvcontImmatStatut = renouvcontImmatStatut;
    }

    public Boolean isRenouvcontPubStatut() {
        return renouvcontPubStatut;
    }

    public void setRenouvcontPubStatut(Boolean renouvcontPubStatut) {
        this.renouvcontPubStatut = renouvcontPubStatut;
    }

    public Integer getRenouvcontAutorisationStatut() {
        return renouvcontAutorisationStatut;
    }

    public void setRenouvcontAutorisationStatut(Integer renouvcontAutorisationStatut) {
        this.renouvcontAutorisationStatut = renouvcontAutorisationStatut;
    }

    public Integer getRenouvcontExamenJuridiqueStatut() {
        return renouvcontExamenJuridiqueStatut;
    }

    public void setRenouvcontExamenJuridiqueStatut(Integer renouvcontExamenJuridiqueStatut) {
        this.renouvcontExamenJuridiqueStatut = renouvcontExamenJuridiqueStatut;
    }

    public Integer getRenouvcontApprobationStatut() {
        return renouvcontApprobationStatut;
    }

    public void setRenouvcontApprobationStatut(Integer renouvcontApprobationStatut) {
        this.renouvcontApprobationStatut = renouvcontApprobationStatut;
    }

    public String getEtatContratdebase() {
        return etatContratdebase;
    }

    public void setEtatContratdebase(String etatContratdebase) {
        this.etatContratdebase = etatContratdebase;
    }

    public String getLibelleLot() {
        return libelleLot;
    }

    public void setLibelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
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
        if (!(o instanceof ContratDTO)) {
            return false;
        }

        return id != null && id.equals(((ContratDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ContratDTO{" +
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
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", lotId=" + getLotId() +
            ", fournisseurId=" + getFournisseurId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            "}";
    }
}
