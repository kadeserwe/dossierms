package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.PlisOuverture} entity.
 */
@ApiModel(description = "TABLE PlisOuverture")
public class PlisOuvertureDTO implements Serializable {
    
    private Long id;

    private String raisonSociale;

    private String adresseMail;

    private String commentaire;

    private String rang;

    private String ninea;

    private String natCode;

    private String monCode;

    private String pvOffreFinanciere;

    private String negociation;

    private BigDecimal montantOffert;

    private BigDecimal scoreFinancier;

    private BigDecimal prixEvalue;

    private BigDecimal scoreTechniquePondere;

    private BigDecimal scoreFinancierPondere;

    private BigDecimal scoreFinal;

    private BigDecimal montantDefinitif;

    private BigDecimal montantTVA;

    private BigDecimal montantDouane;

    private LocalDate dateDepot;

    private LocalDate heuredepot;

    private Integer rabais;

    private Integer scoreTechnique;

    private Integer seuilAtteint;

    private Integer classemenTechnique;

    private Integer classementGeneral;

    private Integer candidatRestreintID;

    private Integer etatPreselection;

    private Integer etatExamenPreliminaire;

    private Integer critereQualification;

    private Integer attributaireProvisoire;

    private Integer offreTechnique;

    private Integer offreFinanciere;

    private Integer lettreSoumission;

    private Integer valide;

    private Integer numero;

    private Integer garantie;

    private Integer pieceRequise;

    private String observationsOffres;

    private String observationsCandidats;

    private String modeReception;

    private String notifie;

    private String signatureOffre;

    private String exhaustivite;

    private String garantieSoumission;

    private String conformite;

    private String critereProvenance;

    private BigDecimal notePreselectionne;

    private Long autoriteId;

    private Long ajustement;


    private Long dossierAppelOffreId;

    private Long retraitRegistreDAOId;

    private Long fournisseurId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getNatCode() {
        return natCode;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public String getMonCode() {
        return monCode;
    }

    public void setMonCode(String monCode) {
        this.monCode = monCode;
    }

    public String getPvOffreFinanciere() {
        return pvOffreFinanciere;
    }

    public void setPvOffreFinanciere(String pvOffreFinanciere) {
        this.pvOffreFinanciere = pvOffreFinanciere;
    }

    public String getNegociation() {
        return negociation;
    }

    public void setNegociation(String negociation) {
        this.negociation = negociation;
    }

    public BigDecimal getMontantOffert() {
        return montantOffert;
    }

    public void setMontantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
    }

    public BigDecimal getScoreFinancier() {
        return scoreFinancier;
    }

    public void setScoreFinancier(BigDecimal scoreFinancier) {
        this.scoreFinancier = scoreFinancier;
    }

    public BigDecimal getPrixEvalue() {
        return prixEvalue;
    }

    public void setPrixEvalue(BigDecimal prixEvalue) {
        this.prixEvalue = prixEvalue;
    }

    public BigDecimal getScoreTechniquePondere() {
        return scoreTechniquePondere;
    }

    public void setScoreTechniquePondere(BigDecimal scoreTechniquePondere) {
        this.scoreTechniquePondere = scoreTechniquePondere;
    }

    public BigDecimal getScoreFinancierPondere() {
        return scoreFinancierPondere;
    }

    public void setScoreFinancierPondere(BigDecimal scoreFinancierPondere) {
        this.scoreFinancierPondere = scoreFinancierPondere;
    }

    public BigDecimal getScoreFinal() {
        return scoreFinal;
    }

    public void setScoreFinal(BigDecimal scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public BigDecimal getMontantDefinitif() {
        return montantDefinitif;
    }

    public void setMontantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
    }

    public BigDecimal getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
    }

    public BigDecimal getMontantDouane() {
        return montantDouane;
    }

    public void setMontantDouane(BigDecimal montantDouane) {
        this.montantDouane = montantDouane;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public LocalDate getHeuredepot() {
        return heuredepot;
    }

    public void setHeuredepot(LocalDate heuredepot) {
        this.heuredepot = heuredepot;
    }

    public Integer getRabais() {
        return rabais;
    }

    public void setRabais(Integer rabais) {
        this.rabais = rabais;
    }

    public Integer getScoreTechnique() {
        return scoreTechnique;
    }

    public void setScoreTechnique(Integer scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
    }

    public Integer getSeuilAtteint() {
        return seuilAtteint;
    }

    public void setSeuilAtteint(Integer seuilAtteint) {
        this.seuilAtteint = seuilAtteint;
    }

    public Integer getClassemenTechnique() {
        return classemenTechnique;
    }

    public void setClassemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
    }

    public Integer getClassementGeneral() {
        return classementGeneral;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }

    public Integer getCandidatRestreintID() {
        return candidatRestreintID;
    }

    public void setCandidatRestreintID(Integer candidatRestreintID) {
        this.candidatRestreintID = candidatRestreintID;
    }

    public Integer getEtatPreselection() {
        return etatPreselection;
    }

    public void setEtatPreselection(Integer etatPreselection) {
        this.etatPreselection = etatPreselection;
    }

    public Integer getEtatExamenPreliminaire() {
        return etatExamenPreliminaire;
    }

    public void setEtatExamenPreliminaire(Integer etatExamenPreliminaire) {
        this.etatExamenPreliminaire = etatExamenPreliminaire;
    }

    public Integer getCritereQualification() {
        return critereQualification;
    }

    public void setCritereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
    }

    public Integer getAttributaireProvisoire() {
        return attributaireProvisoire;
    }

    public void setAttributaireProvisoire(Integer attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
    }

    public Integer getOffreTechnique() {
        return offreTechnique;
    }

    public void setOffreTechnique(Integer offreTechnique) {
        this.offreTechnique = offreTechnique;
    }

    public Integer getOffreFinanciere() {
        return offreFinanciere;
    }

    public void setOffreFinanciere(Integer offreFinanciere) {
        this.offreFinanciere = offreFinanciere;
    }

    public Integer getLettreSoumission() {
        return lettreSoumission;
    }

    public void setLettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
    }

    public Integer getValide() {
        return valide;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getGarantie() {
        return garantie;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    public Integer getPieceRequise() {
        return pieceRequise;
    }

    public void setPieceRequise(Integer pieceRequise) {
        this.pieceRequise = pieceRequise;
    }

    public String getObservationsOffres() {
        return observationsOffres;
    }

    public void setObservationsOffres(String observationsOffres) {
        this.observationsOffres = observationsOffres;
    }

    public String getObservationsCandidats() {
        return observationsCandidats;
    }

    public void setObservationsCandidats(String observationsCandidats) {
        this.observationsCandidats = observationsCandidats;
    }

    public String getModeReception() {
        return modeReception;
    }

    public void setModeReception(String modeReception) {
        this.modeReception = modeReception;
    }

    public String getNotifie() {
        return notifie;
    }

    public void setNotifie(String notifie) {
        this.notifie = notifie;
    }

    public String getSignatureOffre() {
        return signatureOffre;
    }

    public void setSignatureOffre(String signatureOffre) {
        this.signatureOffre = signatureOffre;
    }

    public String getExhaustivite() {
        return exhaustivite;
    }

    public void setExhaustivite(String exhaustivite) {
        this.exhaustivite = exhaustivite;
    }

    public String getGarantieSoumission() {
        return garantieSoumission;
    }

    public void setGarantieSoumission(String garantieSoumission) {
        this.garantieSoumission = garantieSoumission;
    }

    public String getConformite() {
        return conformite;
    }

    public void setConformite(String conformite) {
        this.conformite = conformite;
    }

    public String getCritereProvenance() {
        return critereProvenance;
    }

    public void setCritereProvenance(String critereProvenance) {
        this.critereProvenance = critereProvenance;
    }

    public BigDecimal getNotePreselectionne() {
        return notePreselectionne;
    }

    public void setNotePreselectionne(BigDecimal notePreselectionne) {
        this.notePreselectionne = notePreselectionne;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getAjustement() {
        return ajustement;
    }

    public void setAjustement(Long ajustement) {
        this.ajustement = ajustement;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getRetraitRegistreDAOId() {
        return retraitRegistreDAOId;
    }

    public void setRetraitRegistreDAOId(Long retraitRegistreDAOId) {
        this.retraitRegistreDAOId = retraitRegistreDAOId;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlisOuvertureDTO)) {
            return false;
        }

        return id != null && id.equals(((PlisOuvertureDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PlisOuvertureDTO{" +
            "id=" + getId() +
            ", raisonSociale='" + getRaisonSociale() + "'" +
            ", adresseMail='" + getAdresseMail() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            ", rang='" + getRang() + "'" +
            ", ninea='" + getNinea() + "'" +
            ", natCode='" + getNatCode() + "'" +
            ", monCode='" + getMonCode() + "'" +
            ", pvOffreFinanciere='" + getPvOffreFinanciere() + "'" +
            ", negociation='" + getNegociation() + "'" +
            ", montantOffert=" + getMontantOffert() +
            ", scoreFinancier=" + getScoreFinancier() +
            ", prixEvalue=" + getPrixEvalue() +
            ", scoreTechniquePondere=" + getScoreTechniquePondere() +
            ", scoreFinancierPondere=" + getScoreFinancierPondere() +
            ", scoreFinal=" + getScoreFinal() +
            ", montantDefinitif=" + getMontantDefinitif() +
            ", montantTVA=" + getMontantTVA() +
            ", montantDouane=" + getMontantDouane() +
            ", dateDepot='" + getDateDepot() + "'" +
            ", heuredepot='" + getHeuredepot() + "'" +
            ", rabais=" + getRabais() +
            ", scoreTechnique=" + getScoreTechnique() +
            ", seuilAtteint=" + getSeuilAtteint() +
            ", classemenTechnique=" + getClassemenTechnique() +
            ", classementGeneral=" + getClassementGeneral() +
            ", candidatRestreintID=" + getCandidatRestreintID() +
            ", etatPreselection=" + getEtatPreselection() +
            ", etatExamenPreliminaire=" + getEtatExamenPreliminaire() +
            ", critereQualification=" + getCritereQualification() +
            ", attributaireProvisoire=" + getAttributaireProvisoire() +
            ", offreTechnique=" + getOffreTechnique() +
            ", offreFinanciere=" + getOffreFinanciere() +
            ", lettreSoumission=" + getLettreSoumission() +
            ", valide=" + getValide() +
            ", numero=" + getNumero() +
            ", garantie=" + getGarantie() +
            ", pieceRequise=" + getPieceRequise() +
            ", observationsOffres='" + getObservationsOffres() + "'" +
            ", observationsCandidats='" + getObservationsCandidats() + "'" +
            ", modeReception='" + getModeReception() + "'" +
            ", notifie='" + getNotifie() + "'" +
            ", signatureOffre='" + getSignatureOffre() + "'" +
            ", exhaustivite='" + getExhaustivite() + "'" +
            ", garantieSoumission='" + getGarantieSoumission() + "'" +
            ", conformite='" + getConformite() + "'" +
            ", critereProvenance='" + getCritereProvenance() + "'" +
            ", notePreselectionne=" + getNotePreselectionne() +
            ", autoriteId=" + getAutoriteId() +
            ", ajustement=" + getAjustement() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", retraitRegistreDAOId=" + getRetraitRegistreDAOId() +
            ", fournisseurId=" + getFournisseurId() +
            "}";
    }
}
