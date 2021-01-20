package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * TABLE PlisOuverture
 */
@Entity
@Table(name = "plis_ouverture")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PlisOuverture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "adresse_mail")
    private String adresseMail;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "rang")
    private String rang;

    @Column(name = "ninea")
    private String ninea;

    @Column(name = "nat_code")
    private String natCode;

    @Column(name = "mon_code")
    private String monCode;

    @Column(name = "pv_offre_financiere")
    private String pvOffreFinanciere;

    @Column(name = "negociation")
    private String negociation;

    @Column(name = "montant_offert", precision = 21, scale = 2)
    private BigDecimal montantOffert;

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

    @Column(name = "montant_definitif", precision = 21, scale = 2)
    private BigDecimal montantDefinitif;

    @Column(name = "montant_tva", precision = 21, scale = 2)
    private BigDecimal montantTVA;

    @Column(name = "montant_douane", precision = 21, scale = 2)
    private BigDecimal montantDouane;

    @Column(name = "date_depot")
    private LocalDate dateDepot;

    @Column(name = "heuredepot")
    private LocalDate heuredepot;

    @Column(name = "rabais")
    private Integer rabais;

    @Column(name = "score_technique")
    private Integer scoreTechnique;

    @Column(name = "seuil_atteint")
    private Integer seuilAtteint;

    @Column(name = "classemen_technique")
    private Integer classemenTechnique;

    @Column(name = "classement_general")
    private Integer classementGeneral;

    @Column(name = "candidat_restreint_id")
    private Integer candidatRestreintID;

    @Column(name = "etat_preselection")
    private Integer etatPreselection;

    @Column(name = "etat_examen_preliminaire")
    private Integer etatExamenPreliminaire;

    @Column(name = "critere_qualification")
    private Integer critereQualification;

    @Column(name = "attributaire_provisoire")
    private Integer attributaireProvisoire;

    @Column(name = "offre_technique")
    private Integer offreTechnique;

    @Column(name = "offre_financiere")
    private Integer offreFinanciere;

    @Column(name = "lettre_soumission")
    private Integer lettreSoumission;

    @Column(name = "valide")
    private Integer valide;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "garantie")
    private Integer garantie;

    @Column(name = "piece_requise")
    private Integer pieceRequise;

    @Column(name = "observations_offres")
    private String observationsOffres;

    @Column(name = "observations_candidats")
    private String observationsCandidats;

    @Column(name = "mode_reception")
    private String modeReception;

    @Column(name = "notifie")
    private String notifie;

    @Column(name = "signature_offre")
    private String signatureOffre;

    @Column(name = "exhaustivite")
    private String exhaustivite;

    @Column(name = "garantie_soumission")
    private String garantieSoumission;

    @Column(name = "conformite")
    private String conformite;

    @Column(name = "critere_provenance")
    private String critereProvenance;

    @Column(name = "note_preselectionne", precision = 21, scale = 2)
    private BigDecimal notePreselectionne;

    @Column(name = "autorite_id")
    private Long autoriteId;

    @Column(name = "ajustement")
    private Long ajustement;

    @ManyToOne
    @JsonIgnoreProperties(value = "plisOuvertures", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "plisOuvertures", allowSetters = true)
    private RetraitRegistreDAO retraitRegistreDAO;

    @ManyToOne
    @JsonIgnoreProperties(value = "plisOuvertures", allowSetters = true)
    private Fournisseur fournisseur;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public PlisOuverture raisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
        return this;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public PlisOuverture adresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
        return this;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public PlisOuverture commentaire(String commentaire) {
        this.commentaire = commentaire;
        return this;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getRang() {
        return rang;
    }

    public PlisOuverture rang(String rang) {
        this.rang = rang;
        return this;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getNinea() {
        return ninea;
    }

    public PlisOuverture ninea(String ninea) {
        this.ninea = ninea;
        return this;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getNatCode() {
        return natCode;
    }

    public PlisOuverture natCode(String natCode) {
        this.natCode = natCode;
        return this;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public String getMonCode() {
        return monCode;
    }

    public PlisOuverture monCode(String monCode) {
        this.monCode = monCode;
        return this;
    }

    public void setMonCode(String monCode) {
        this.monCode = monCode;
    }

    public String getPvOffreFinanciere() {
        return pvOffreFinanciere;
    }

    public PlisOuverture pvOffreFinanciere(String pvOffreFinanciere) {
        this.pvOffreFinanciere = pvOffreFinanciere;
        return this;
    }

    public void setPvOffreFinanciere(String pvOffreFinanciere) {
        this.pvOffreFinanciere = pvOffreFinanciere;
    }

    public String getNegociation() {
        return negociation;
    }

    public PlisOuverture negociation(String negociation) {
        this.negociation = negociation;
        return this;
    }

    public void setNegociation(String negociation) {
        this.negociation = negociation;
    }

    public BigDecimal getMontantOffert() {
        return montantOffert;
    }

    public PlisOuverture montantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
        return this;
    }

    public void setMontantOffert(BigDecimal montantOffert) {
        this.montantOffert = montantOffert;
    }

    public BigDecimal getScoreFinancier() {
        return scoreFinancier;
    }

    public PlisOuverture scoreFinancier(BigDecimal scoreFinancier) {
        this.scoreFinancier = scoreFinancier;
        return this;
    }

    public void setScoreFinancier(BigDecimal scoreFinancier) {
        this.scoreFinancier = scoreFinancier;
    }

    public BigDecimal getPrixEvalue() {
        return prixEvalue;
    }

    public PlisOuverture prixEvalue(BigDecimal prixEvalue) {
        this.prixEvalue = prixEvalue;
        return this;
    }

    public void setPrixEvalue(BigDecimal prixEvalue) {
        this.prixEvalue = prixEvalue;
    }

    public BigDecimal getScoreTechniquePondere() {
        return scoreTechniquePondere;
    }

    public PlisOuverture scoreTechniquePondere(BigDecimal scoreTechniquePondere) {
        this.scoreTechniquePondere = scoreTechniquePondere;
        return this;
    }

    public void setScoreTechniquePondere(BigDecimal scoreTechniquePondere) {
        this.scoreTechniquePondere = scoreTechniquePondere;
    }

    public BigDecimal getScoreFinancierPondere() {
        return scoreFinancierPondere;
    }

    public PlisOuverture scoreFinancierPondere(BigDecimal scoreFinancierPondere) {
        this.scoreFinancierPondere = scoreFinancierPondere;
        return this;
    }

    public void setScoreFinancierPondere(BigDecimal scoreFinancierPondere) {
        this.scoreFinancierPondere = scoreFinancierPondere;
    }

    public BigDecimal getScoreFinal() {
        return scoreFinal;
    }

    public PlisOuverture scoreFinal(BigDecimal scoreFinal) {
        this.scoreFinal = scoreFinal;
        return this;
    }

    public void setScoreFinal(BigDecimal scoreFinal) {
        this.scoreFinal = scoreFinal;
    }

    public BigDecimal getMontantDefinitif() {
        return montantDefinitif;
    }

    public PlisOuverture montantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
        return this;
    }

    public void setMontantDefinitif(BigDecimal montantDefinitif) {
        this.montantDefinitif = montantDefinitif;
    }

    public BigDecimal getMontantTVA() {
        return montantTVA;
    }

    public PlisOuverture montantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
        return this;
    }

    public void setMontantTVA(BigDecimal montantTVA) {
        this.montantTVA = montantTVA;
    }

    public BigDecimal getMontantDouane() {
        return montantDouane;
    }

    public PlisOuverture montantDouane(BigDecimal montantDouane) {
        this.montantDouane = montantDouane;
        return this;
    }

    public void setMontantDouane(BigDecimal montantDouane) {
        this.montantDouane = montantDouane;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public PlisOuverture dateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
        return this;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public LocalDate getHeuredepot() {
        return heuredepot;
    }

    public PlisOuverture heuredepot(LocalDate heuredepot) {
        this.heuredepot = heuredepot;
        return this;
    }

    public void setHeuredepot(LocalDate heuredepot) {
        this.heuredepot = heuredepot;
    }

    public Integer getRabais() {
        return rabais;
    }

    public PlisOuverture rabais(Integer rabais) {
        this.rabais = rabais;
        return this;
    }

    public void setRabais(Integer rabais) {
        this.rabais = rabais;
    }

    public Integer getScoreTechnique() {
        return scoreTechnique;
    }

    public PlisOuverture scoreTechnique(Integer scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
        return this;
    }

    public void setScoreTechnique(Integer scoreTechnique) {
        this.scoreTechnique = scoreTechnique;
    }

    public Integer getSeuilAtteint() {
        return seuilAtteint;
    }

    public PlisOuverture seuilAtteint(Integer seuilAtteint) {
        this.seuilAtteint = seuilAtteint;
        return this;
    }

    public void setSeuilAtteint(Integer seuilAtteint) {
        this.seuilAtteint = seuilAtteint;
    }

    public Integer getClassemenTechnique() {
        return classemenTechnique;
    }

    public PlisOuverture classemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
        return this;
    }

    public void setClassemenTechnique(Integer classemenTechnique) {
        this.classemenTechnique = classemenTechnique;
    }

    public Integer getClassementGeneral() {
        return classementGeneral;
    }

    public PlisOuverture classementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
        return this;
    }

    public void setClassementGeneral(Integer classementGeneral) {
        this.classementGeneral = classementGeneral;
    }

    public Integer getCandidatRestreintID() {
        return candidatRestreintID;
    }

    public PlisOuverture candidatRestreintID(Integer candidatRestreintID) {
        this.candidatRestreintID = candidatRestreintID;
        return this;
    }

    public void setCandidatRestreintID(Integer candidatRestreintID) {
        this.candidatRestreintID = candidatRestreintID;
    }

    public Integer getEtatPreselection() {
        return etatPreselection;
    }

    public PlisOuverture etatPreselection(Integer etatPreselection) {
        this.etatPreselection = etatPreselection;
        return this;
    }

    public void setEtatPreselection(Integer etatPreselection) {
        this.etatPreselection = etatPreselection;
    }

    public Integer getEtatExamenPreliminaire() {
        return etatExamenPreliminaire;
    }

    public PlisOuverture etatExamenPreliminaire(Integer etatExamenPreliminaire) {
        this.etatExamenPreliminaire = etatExamenPreliminaire;
        return this;
    }

    public void setEtatExamenPreliminaire(Integer etatExamenPreliminaire) {
        this.etatExamenPreliminaire = etatExamenPreliminaire;
    }

    public Integer getCritereQualification() {
        return critereQualification;
    }

    public PlisOuverture critereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
        return this;
    }

    public void setCritereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
    }

    public Integer getAttributaireProvisoire() {
        return attributaireProvisoire;
    }

    public PlisOuverture attributaireProvisoire(Integer attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
        return this;
    }

    public void setAttributaireProvisoire(Integer attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
    }

    public Integer getOffreTechnique() {
        return offreTechnique;
    }

    public PlisOuverture offreTechnique(Integer offreTechnique) {
        this.offreTechnique = offreTechnique;
        return this;
    }

    public void setOffreTechnique(Integer offreTechnique) {
        this.offreTechnique = offreTechnique;
    }

    public Integer getOffreFinanciere() {
        return offreFinanciere;
    }

    public PlisOuverture offreFinanciere(Integer offreFinanciere) {
        this.offreFinanciere = offreFinanciere;
        return this;
    }

    public void setOffreFinanciere(Integer offreFinanciere) {
        this.offreFinanciere = offreFinanciere;
    }

    public Integer getLettreSoumission() {
        return lettreSoumission;
    }

    public PlisOuverture lettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
        return this;
    }

    public void setLettreSoumission(Integer lettreSoumission) {
        this.lettreSoumission = lettreSoumission;
    }

    public Integer getValide() {
        return valide;
    }

    public PlisOuverture valide(Integer valide) {
        this.valide = valide;
        return this;
    }

    public void setValide(Integer valide) {
        this.valide = valide;
    }

    public Integer getNumero() {
        return numero;
    }

    public PlisOuverture numero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getGarantie() {
        return garantie;
    }

    public PlisOuverture garantie(Integer garantie) {
        this.garantie = garantie;
        return this;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    public Integer getPieceRequise() {
        return pieceRequise;
    }

    public PlisOuverture pieceRequise(Integer pieceRequise) {
        this.pieceRequise = pieceRequise;
        return this;
    }

    public void setPieceRequise(Integer pieceRequise) {
        this.pieceRequise = pieceRequise;
    }

    public String getObservationsOffres() {
        return observationsOffres;
    }

    public PlisOuverture observationsOffres(String observationsOffres) {
        this.observationsOffres = observationsOffres;
        return this;
    }

    public void setObservationsOffres(String observationsOffres) {
        this.observationsOffres = observationsOffres;
    }

    public String getObservationsCandidats() {
        return observationsCandidats;
    }

    public PlisOuverture observationsCandidats(String observationsCandidats) {
        this.observationsCandidats = observationsCandidats;
        return this;
    }

    public void setObservationsCandidats(String observationsCandidats) {
        this.observationsCandidats = observationsCandidats;
    }

    public String getModeReception() {
        return modeReception;
    }

    public PlisOuverture modeReception(String modeReception) {
        this.modeReception = modeReception;
        return this;
    }

    public void setModeReception(String modeReception) {
        this.modeReception = modeReception;
    }

    public String getNotifie() {
        return notifie;
    }

    public PlisOuverture notifie(String notifie) {
        this.notifie = notifie;
        return this;
    }

    public void setNotifie(String notifie) {
        this.notifie = notifie;
    }

    public String getSignatureOffre() {
        return signatureOffre;
    }

    public PlisOuverture signatureOffre(String signatureOffre) {
        this.signatureOffre = signatureOffre;
        return this;
    }

    public void setSignatureOffre(String signatureOffre) {
        this.signatureOffre = signatureOffre;
    }

    public String getExhaustivite() {
        return exhaustivite;
    }

    public PlisOuverture exhaustivite(String exhaustivite) {
        this.exhaustivite = exhaustivite;
        return this;
    }

    public void setExhaustivite(String exhaustivite) {
        this.exhaustivite = exhaustivite;
    }

    public String getGarantieSoumission() {
        return garantieSoumission;
    }

    public PlisOuverture garantieSoumission(String garantieSoumission) {
        this.garantieSoumission = garantieSoumission;
        return this;
    }

    public void setGarantieSoumission(String garantieSoumission) {
        this.garantieSoumission = garantieSoumission;
    }

    public String getConformite() {
        return conformite;
    }

    public PlisOuverture conformite(String conformite) {
        this.conformite = conformite;
        return this;
    }

    public void setConformite(String conformite) {
        this.conformite = conformite;
    }

    public String getCritereProvenance() {
        return critereProvenance;
    }

    public PlisOuverture critereProvenance(String critereProvenance) {
        this.critereProvenance = critereProvenance;
        return this;
    }

    public void setCritereProvenance(String critereProvenance) {
        this.critereProvenance = critereProvenance;
    }

    public BigDecimal getNotePreselectionne() {
        return notePreselectionne;
    }

    public PlisOuverture notePreselectionne(BigDecimal notePreselectionne) {
        this.notePreselectionne = notePreselectionne;
        return this;
    }

    public void setNotePreselectionne(BigDecimal notePreselectionne) {
        this.notePreselectionne = notePreselectionne;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public PlisOuverture autoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
        return this;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getAjustement() {
        return ajustement;
    }

    public PlisOuverture ajustement(Long ajustement) {
        this.ajustement = ajustement;
        return this;
    }

    public void setAjustement(Long ajustement) {
        this.ajustement = ajustement;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public PlisOuverture dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public RetraitRegistreDAO getRetraitRegistreDAO() {
        return retraitRegistreDAO;
    }

    public PlisOuverture retraitRegistreDAO(RetraitRegistreDAO retraitRegistreDAO) {
        this.retraitRegistreDAO = retraitRegistreDAO;
        return this;
    }

    public void setRetraitRegistreDAO(RetraitRegistreDAO retraitRegistreDAO) {
        this.retraitRegistreDAO = retraitRegistreDAO;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public PlisOuverture fournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        return this;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlisOuverture)) {
            return false;
        }
        return id != null && id.equals(((PlisOuverture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PlisOuverture{" +
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
            "}";
    }
}
