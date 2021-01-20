package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * TABLE LotsSoumissionnaire
 */
@Entity
@Table(name = "lots_soumissionnaire")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LotsSoumissionnaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "raisonsociale")
    private String raisonsociale;

    @Column(name = "numero")
    private String numero;

    @Column(name = "email")
    private String email;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "lotsoumis")
    private String lotsoumis;

    @Column(name = "lotrecu")
    private String lotrecu;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "elimine")
    private String elimine;

    @Column(name = "montant_offert", precision = 21, scale = 2)
    private BigDecimal montantOffert;

    @Column(name = "montant_definitif", precision = 21, scale = 2)
    private BigDecimal montantDefinitif;

    @Column(name = "montant_garantie", precision = 21, scale = 2)
    private BigDecimal montantGarantie;

    @Column(name = "montant_tva", precision = 21, scale = 2)
    private BigDecimal montantTVA;

    @Column(name = "montant_douane", precision = 21, scale = 2)
    private BigDecimal montantDouane;

    @Column(name = "montant_ttc", precision = 21, scale = 2)
    private BigDecimal montantTTC;

    @Column(name = "rabais")
    private Integer rabais;

    @Column(name = "rang")
    private Integer rang;

    @Column(name = "score_technique", precision = 21, scale = 2)
    private BigDecimal scoreTechnique;

    @Column(name = "score_financier", precision = 21, scale = 2)
    private BigDecimal scoreFinancier;

    @Column(name = "prix_evalue", precision = 21, scale = 2)
    private BigDecimal prixEvalue;

    @Column(name = "score_technique_pondere", precision = 21, scale = 2)
    private BigDecimal scoreTechniquePondere;

    @Column(name = "score_financier_pondere", precision = 21, scale = 2)
    private BigDecimal scoreFinancierPondere;

    @Column(name = "score_final", precision = 21, scale = 2)
    private BigDecimal scoreFinal;

    @Column(name = "date_depot")
    private LocalDate dateDepot;

    @Column(name = "classement_general")
    private Integer classementGeneral;

    @Column(name = "classemen_technique")
    private Integer classemenTechnique;

    @Column(name = "etat_preselection")
    private Integer etatPreselection;

    @Column(name = "etat_examen_preliminaire")
    private Integer etatExamenPreliminaire;

    @Column(name = "critere_qualification")
    private Integer critereQualification;

    @Column(name = "attributaire_provisoire")
    private Integer attributaireProvisoire;

    @Column(name = "plil_valide")
    private Integer plilValide;

    @Column(name = "lettre_soumission")
    private Integer lettreSoumission;

    @Column(name = "offre_technique")
    private Integer offreTechnique;

    @Column(name = "offre_financiere")
    private Integer offreFinanciere;

    @Column(name = "plinumero")
    private Integer plinumero;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private Lot lot;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private MonnaieOffre monnaieOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private NaturePrix naturePrix;

    @ManyToOne
    @JsonIgnoreProperties(value = "lotsSoumissionnaires", allowSetters = true)
    private Pays pays;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonsociale() {
        return raisonsociale;
    }

    public LotsSoumissionnaire raisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
        return this;
    }

    public void setRaisonsociale(String raisonsociale) {
        this.raisonsociale = raisonsociale;
    }

    public String getNumero() {
        return numero;
    }

    public LotsSoumissionnaire numero(String numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public LotsSoumissionnaire email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public LotsSoumissionnaire commentaire(String commentaire) {
        this.commentaire = commentaire;
        return this;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getLotsoumis() {
        return lotsoumis;
    }

    public LotsSoumissionnaire lotsoumis(String lotsoumis) {
        this.lotsoumis = lotsoumis;
        return this;
    }

    public void setLotsoumis(String lotsoumis) {
        this.lotsoumis = lotsoumis;
    }

    public String getLotrecu() {
        return lotrecu;
    }

    public LotsSoumissionnaire lotrecu(String lotrecu) {
        this.lotrecu = lotrecu;
        return this;
    }

    public void setLotrecu(String lotrecu) {
        this.lotrecu = lotrecu;
    }

    public String getLibelle() {
        return libelle;
    }

    public LotsSoumissionnaire libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getElimine() {
        return elimine;
    }

    public LotsSoumissionnaire elimine(String elimine) {
        this.elimine = elimine;
        return this;
    }

    public void setElimine(String elimine) {
        this.elimine = elimine;
    }

    public BigDecimal getMontantOffert() {
        return montantOffert;
    }

    public LotsSoumissionnaire montantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
        return this;
    }

    public void setMontantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
    }

    public BigDecimal getMontantDefinitif() {
        return montantDefinitif;
    }

    public LotsSoumissionnaire montantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
        return this;
    }

    public void setMontantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
    }

    public BigDecimal getMontantGarantie() {
        return montantGarantie;
    }

    public LotsSoumissionnaire montantGarantie(BigDecimal montantGarantie) {
        this.montantGarantie = montantGarantie;
        return this;
    }

    public void setMontantGarantie(BigDecimal montantGarantie) {
        this.montantGarantie = montantGarantie;
    }

    public BigDecimal getMontantTVA() {
        return montantTVA;
    }

    public LotsSoumissionnaire montantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
        return this;
    }

    public void setMontantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
    }

    public BigDecimal getMontantDouane() {
        return montantDouane;
    }

    public LotsSoumissionnaire montantDouane(BigDecimal montantDouane) {
        this.montantDouane = montantDouane;
        return this;
    }

    public void setMontantDouane(BigDecimal montantDouane) {
        this.montantDouane = montantDouane;
    }

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public LotsSoumissionnaire montantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
        return this;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Integer getRabais() {
        return rabais;
    }

    public LotsSoumissionnaire rabais(Integer rabais) {
        this.rabais = rabais;
        return this;
    }

    public void setRabais(Integer rabais) {
        this.rabais = rabais;
    }

    public Integer getRang() {
        return rang;
    }

    public LotsSoumissionnaire rang(Integer rang) {
        this.rang = rang;
        return this;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public BigDecimal getScoreTechnique() {
        return scoreTechnique;
    }

    public LotsSoumissionnaire scoreTechnique(BigDecimal scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
        return this;
    }

    public void setScoreTechnique(BigDecimal scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
    }

    public BigDecimal getScoreFinancier() {
        return scoreFinancier;
    }

    public LotsSoumissionnaire scoreFinancier(BigDecimal scoreFinancier) {
        this.scoreFinancier = scoreFinancier;
        return this;
    }

    public void setScoreFinancier(BigDecimal scoreFinancier) {
        this.scoreFinancier = scoreFinancier;
    }

    public BigDecimal getPrixEvalue() {
        return prixEvalue;
    }

    public LotsSoumissionnaire prixEvalue(BigDecimal prixEvalue) {
        this.prixEvalue = prixEvalue;
        return this;
    }

    public void setPrixEvalue(BigDecimal prixEvalue) {
        this.prixEvalue = prixEvalue;
    }

    public BigDecimal getScoreTechniquePondere() {
        return scoreTechniquePondere;
    }

    public LotsSoumissionnaire scoreTechniquePondere(BigDecimal scoreTechniquePondere) {
        this.scoreTechniquePondere = scoreTechniquePondere;
        return this;
    }

    public void setScoreTechniquePondere(BigDecimal scoreTechniquePondere) {
        this.scoreTechniquePondere = scoreTechniquePondere;
    }

    public BigDecimal getScoreFinancierPondere() {
        return scoreFinancierPondere;
    }

    public LotsSoumissionnaire scoreFinancierPondere(BigDecimal scoreFinancierPondere) {
        this.scoreFinancierPondere = scoreFinancierPondere;
        return this;
    }

    public void setScoreFinancierPondere(BigDecimal scoreFinancierPondere) {
        this.scoreFinancierPondere = scoreFinancierPondere;
    }

    public BigDecimal getScoreFinal() {
        return scoreFinal;
    }

    public LotsSoumissionnaire scoreFinal(BigDecimal scoreFinal) {
        this.scoreFinal = scoreFinal;
        return this;
    }

    public void setScoreFinal(BigDecimal scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public LotsSoumissionnaire dateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
        return this;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Integer getClassementGeneral() {
        return classementGeneral;
    }

    public LotsSoumissionnaire classementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
        return this;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }

    public Integer getClassemenTechnique() {
        return classemenTechnique;
    }

    public LotsSoumissionnaire classemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
        return this;
    }

    public void setClassemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
    }

    public Integer getEtatPreselection() {
        return etatPreselection;
    }

    public LotsSoumissionnaire etatPreselection(Integer etatPreselection) {
        this.etatPreselection = etatPreselection;
        return this;
    }

    public void setEtatPreselection(Integer etatPreselection) {
        this.etatPreselection = etatPreselection;
    }

    public Integer getEtatExamenPreliminaire() {
        return etatExamenPreliminaire;
    }

    public LotsSoumissionnaire etatExamenPreliminaire(Integer etatExamenPreliminaire) {
        this.etatExamenPreliminaire = etatExamenPreliminaire;
        return this;
    }

    public void setEtatExamenPreliminaire(Integer etatExamenPreliminaire) {
        this.etatExamenPreliminaire = etatExamenPreliminaire;
    }

    public Integer getCritereQualification() {
        return critereQualification;
    }

    public LotsSoumissionnaire critereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
        return this;
    }

    public void setCritereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
    }

    public Integer getAttributaireProvisoire() {
        return attributaireProvisoire;
    }

    public LotsSoumissionnaire attributaireProvisoire(Integer attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
        return this;
    }

    public void setAttributaireProvisoire(Integer attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
    }

    public Integer getPlilValide() {
        return plilValide;
    }

    public LotsSoumissionnaire plilValide(Integer plilValide) {
        this.plilValide = plilValide;
        return this;
    }

    public void setPlilValide(Integer plilValide) {
        this.plilValide = plilValide;
    }

    public Integer getLettreSoumission() {
        return lettreSoumission;
    }

    public LotsSoumissionnaire lettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
        return this;
    }

    public void setLettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
    }

    public Integer getOffreTechnique() {
        return offreTechnique;
    }

    public LotsSoumissionnaire offreTechnique(Integer offreTechnique) {
        this.offreTechnique = offreTechnique;
        return this;
    }

    public void setOffreTechnique(Integer offreTechnique) {
        this.offreTechnique = offreTechnique;
    }

    public Integer getOffreFinanciere() {
        return offreFinanciere;
    }

    public LotsSoumissionnaire offreFinanciere(Integer offreFinanciere) {
        this.offreFinanciere = offreFinanciere;
        return this;
    }

    public void setOffreFinanciere(Integer offreFinanciere) {
        this.offreFinanciere = offreFinanciere;
    }

    public Integer getPlinumero() {
        return plinumero;
    }

    public LotsSoumissionnaire plinumero(Integer plinumero) {
        this.plinumero = plinumero;
        return this;
    }

    public void setPlinumero(Integer plinumero) {
        this.plinumero = plinumero;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public LotsSoumissionnaire dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Lot getLot() {
        return lot;
    }

    public LotsSoumissionnaire lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public LotsSoumissionnaire plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public MonnaieOffre getMonnaieOffre() {
        return monnaieOffre;
    }

    public LotsSoumissionnaire monnaieOffre(MonnaieOffre monnaieOffre) {
        this.monnaieOffre = monnaieOffre;
        return this;
    }

    public void setMonnaieOffre(MonnaieOffre monnaieOffre) {
        this.monnaieOffre = monnaieOffre;
    }

    public NaturePrix getNaturePrix() {
        return naturePrix;
    }

    public LotsSoumissionnaire naturePrix(NaturePrix naturePrix) {
        this.naturePrix = naturePrix;
        return this;
    }

    public void setNaturePrix(NaturePrix naturePrix) {
        this.naturePrix = naturePrix;
    }

    public Pays getPays() {
        return pays;
    }

    public LotsSoumissionnaire pays(Pays pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LotsSoumissionnaire)) {
            return false;
        }
        return id != null && id.equals(((LotsSoumissionnaire) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LotsSoumissionnaire{" +
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
            "}";
    }
}
