package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.LotsSoumissionnaire} entity.
 */
@ApiModel(description = "TABLE LotsSoumissionnaire")
public class LotsSoumissionnaireDTO implements Serializable {
    
    private Long id;

    private String raisonsociale;

    private String numero;

    private String email;

    private String commentaire;

    private String lotsoumis;

    private String lotrecu;

    private String libelle;

    private String elimine;

    private BigDecimal montantOffert;

    private BigDecimal montantDefinitif;

    private BigDecimal montantGarantie;

    private BigDecimal montantTVA;

    private BigDecimal montantDouane;

    private BigDecimal montantTTC;

    private Integer rabais;

    private Integer rang;

    private BigDecimal scoreTechnique;

    private BigDecimal scoreFinancier;

    private BigDecimal prixEvalue;

    private BigDecimal scoreTechniquePondere;

    private BigDecimal scoreFinancierPondere;

    private BigDecimal scoreFinal;

    private LocalDate dateDepot;

    private Integer classementGeneral;

    private Integer classemenTechnique;

    private Integer etatPreselection;

    private Integer etatExamenPreliminaire;

    private Integer critereQualification;

    private Integer attributaireProvisoire;

    private Integer plilValide;

    private Integer lettreSoumission;

    private Integer offreTechnique;

    private Integer offreFinanciere;

    private Integer plinumero;


    private Long dossierAppelOffreId;

    private Long lotId;

    private Long plisOuvertureId;

    private Long monnaieOffreId;

    private Long naturePrixId;

    private Long paysId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getLotsoumis() {
        return lotsoumis;
    }

    public void setLotsoumis(String lotsoumis) {
        this.lotsoumis = lotsoumis;
    }

    public String getLotrecu() {
        return lotrecu;
    }

    public void setLotrecu(String lotrecu) {
        this.lotrecu = lotrecu;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getElimine() {
        return elimine;
    }

    public void setElimine(String elimine) {
        this.elimine = elimine;
    }

    public BigDecimal getMontantOffert() {
        return montantOffert;
    }

    public void setMontantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
    }

    public BigDecimal getMontantDefinitif() {
        return montantDefinitif;
    }

    public void setMontantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
    }

    public BigDecimal getMontantGarantie() {
        return montantGarantie;
    }

    public void setMontantGarantie(BigDecimal montantGarantie) {
        this.montantGarantie = montantGarantie;
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

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Integer getRabais() {
        return rabais;
    }

    public void setRabais(Integer rabais) {
        this.rabais = rabais;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public BigDecimal getScoreTechnique() {
        return scoreTechnique;
    }

    public void setScoreTechnique(BigDecimal scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
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

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Integer getClassementGeneral() {
        return classementGeneral;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }

    public Integer getClassemenTechnique() {
        return classemenTechnique;
    }

    public void setClassemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
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

    public Integer getPlilValide() {
        return plilValide;
    }

    public void setPlilValide(Integer plilValide) {
        this.plilValide = plilValide;
    }

    public Integer getLettreSoumission() {
        return lettreSoumission;
    }

    public void setLettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
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

    public Integer getPlinumero() {
        return plinumero;
    }

    public void setPlinumero(Integer plinumero) {
        this.plinumero = plinumero;
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

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    public Long getMonnaieOffreId() {
        return monnaieOffreId;
    }

    public void setMonnaieOffreId(Long monnaieOffreId) {
        this.monnaieOffreId = monnaieOffreId;
    }

    public Long getNaturePrixId() {
        return naturePrixId;
    }

    public void setNaturePrixId(Long naturePrixId) {
        this.naturePrixId = naturePrixId;
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
        if (!(o instanceof LotsSoumissionnaireDTO)) {
            return false;
        }

        return id != null && id.equals(((LotsSoumissionnaireDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LotsSoumissionnaireDTO{" +
            "id=" + getId() +
            ", raisonsociale='" + getRaisonsociale() + "'" +
            ", numero='" + getNumero() + "'" +
            ", email='" + getEmail() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            ", lotsoumis='" + getLotsoumis() + "'" +
            ", lotrecu='" + getLotrecu() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", elimine='" + getElimine() + "'" +
            ", montantOffert=" + getMontantOffert() +
            ", montantDefinitif=" + getMontantDefinitif() +
            ", montantGarantie=" + getMontantGarantie() +
            ", montantTVA=" + getMontantTVA() +
            ", montantDouane=" + getMontantDouane() +
            ", montantTTC=" + getMontantTTC() +
            ", rabais=" + getRabais() +
            ", rang=" + getRang() +
            ", scoreTechnique=" + getScoreTechnique() +
            ", scoreFinancier=" + getScoreFinancier() +
            ", prixEvalue=" + getPrixEvalue() +
            ", scoreTechniquePondere=" + getScoreTechniquePondere() +
            ", scoreFinancierPondere=" + getScoreFinancierPondere() +
            ", scoreFinal=" + getScoreFinal() +
            ", dateDepot='" + getDateDepot() + "'" +
            ", classementGeneral=" + getClassementGeneral() +
            ", classemenTechnique=" + getClassemenTechnique() +
            ", etatPreselection=" + getEtatPreselection() +
            ", etatExamenPreliminaire=" + getEtatExamenPreliminaire() +
            ", critereQualification=" + getCritereQualification() +
            ", attributaireProvisoire=" + getAttributaireProvisoire() +
            ", plilValide=" + getPlilValide() +
            ", lettreSoumission=" + getLettreSoumission() +
            ", offreTechnique=" + getOffreTechnique() +
            ", offreFinanciere=" + getOffreFinanciere() +
            ", plinumero=" + getPlinumero() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", lotId=" + getLotId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", monnaieOffreId=" + getMonnaieOffreId() +
            ", naturePrixId=" + getNaturePrixId() +
            ", paysId=" + getPaysId() +
            "}";
    }
}
