package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TABLE HistoriqueappeloffresAC
 */
@Entity
@Table(name = "historique_appel_offres_ac")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HistoriqueAppelOffresAC implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "histoac_validation")
    private String histoacValidation;

    @Column(name = "histoac_commentaire")
    private String histoacCommentaire;

    @Column(name = "histoac_fichiervalidation")
    private String histoacFichiervalidation;

    @Column(name = "histoac_borderau")
    private String histoacBorderau;

    @Column(name = "histo_validation")
    private String histoValidation;

    @Column(name = "histo_commentaire")
    private String histoCommentaire;

    @Column(name = "histo_fichiervalidation")
    private String histoFichiervalidation;

    @Column(name = "dao_fichier")
    private String daoFichier;

    @Column(name = "origine")
    private String origine;

    @Column(name = "histoac_datevalidation")
    private LocalDate histoacDatevalidation;

    @Column(name = "histoac_datecreationdossier")
    private LocalDate histoacDatecreationdossier;

    @Column(name = "histo_datevalidation")
    private LocalDate histoDatevalidation;

    @Column(name = "histoac_attribution")
    private Integer histoacAttribution;

    @Column(name = "histoac_ac")
    private Integer histoacAc;

    @Column(name = "validerpar_nom")
    private String validerparNom;

    @Column(name = "validerpar_prenom")
    private String validerparPrenom;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "autirite_id")
    private Long autiriteId;

    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueAppelOffresACS", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistoacValidation() {
        return histoacValidation;
    }

    public HistoriqueAppelOffresAC histoacValidation(String histoacValidation) {
        this.histoacValidation = histoacValidation;
        return this;
    }

    public void setHistoacValidation(String histoacValidation) {
        this.histoacValidation = histoacValidation;
    }

    public String getHistoacCommentaire() {
        return histoacCommentaire;
    }

    public HistoriqueAppelOffresAC histoacCommentaire(String histoacCommentaire) {
        this.histoacCommentaire = histoacCommentaire;
        return this;
    }

    public void setHistoacCommentaire(String histoacCommentaire) {
        this.histoacCommentaire = histoacCommentaire;
    }

    public String getHistoacFichiervalidation() {
        return histoacFichiervalidation;
    }

    public HistoriqueAppelOffresAC histoacFichiervalidation(String histoacFichiervalidation) {
        this.histoacFichiervalidation = histoacFichiervalidation;
        return this;
    }

    public void setHistoacFichiervalidation(String histoacFichiervalidation) {
        this.histoacFichiervalidation = histoacFichiervalidation;
    }

    public String getHistoacBorderau() {
        return histoacBorderau;
    }

    public HistoriqueAppelOffresAC histoacBorderau(String histoacBorderau) {
        this.histoacBorderau = histoacBorderau;
        return this;
    }

    public void setHistoacBorderau(String histoacBorderau) {
        this.histoacBorderau = histoacBorderau;
    }

    public String getHistoValidation() {
        return histoValidation;
    }

    public HistoriqueAppelOffresAC histoValidation(String histoValidation) {
        this.histoValidation = histoValidation;
        return this;
    }

    public void setHistoValidation(String histoValidation) {
        this.histoValidation = histoValidation;
    }

    public String getHistoCommentaire() {
        return histoCommentaire;
    }

    public HistoriqueAppelOffresAC histoCommentaire(String histoCommentaire) {
        this.histoCommentaire = histoCommentaire;
        return this;
    }

    public void setHistoCommentaire(String histoCommentaire) {
        this.histoCommentaire = histoCommentaire;
    }

    public String getHistoFichiervalidation() {
        return histoFichiervalidation;
    }

    public HistoriqueAppelOffresAC histoFichiervalidation(String histoFichiervalidation) {
        this.histoFichiervalidation = histoFichiervalidation;
        return this;
    }

    public void setHistoFichiervalidation(String histoFichiervalidation) {
        this.histoFichiervalidation = histoFichiervalidation;
    }

    public String getDaoFichier() {
        return daoFichier;
    }

    public HistoriqueAppelOffresAC daoFichier(String daoFichier) {
        this.daoFichier = daoFichier;
        return this;
    }

    public void setDaoFichier(String daoFichier) {
        this.daoFichier = daoFichier;
    }

    public String getOrigine() {
        return origine;
    }

    public HistoriqueAppelOffresAC origine(String origine) {
        this.origine = origine;
        return this;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public LocalDate getHistoacDatevalidation() {
        return histoacDatevalidation;
    }

    public HistoriqueAppelOffresAC histoacDatevalidation(LocalDate histoacDatevalidation) {
        this.histoacDatevalidation = histoacDatevalidation;
        return this;
    }

    public void setHistoacDatevalidation(LocalDate histoacDatevalidation) {
        this.histoacDatevalidation = histoacDatevalidation;
    }

    public LocalDate getHistoacDatecreationdossier() {
        return histoacDatecreationdossier;
    }

    public HistoriqueAppelOffresAC histoacDatecreationdossier(LocalDate histoacDatecreationdossier) {
        this.histoacDatecreationdossier = histoacDatecreationdossier;
        return this;
    }

    public void setHistoacDatecreationdossier(LocalDate histoacDatecreationdossier) {
        this.histoacDatecreationdossier = histoacDatecreationdossier;
    }

    public LocalDate getHistoDatevalidation() {
        return histoDatevalidation;
    }

    public HistoriqueAppelOffresAC histoDatevalidation(LocalDate histoDatevalidation) {
        this.histoDatevalidation = histoDatevalidation;
        return this;
    }

    public void setHistoDatevalidation(LocalDate histoDatevalidation) {
        this.histoDatevalidation = histoDatevalidation;
    }

    public Integer getHistoacAttribution() {
        return histoacAttribution;
    }

    public HistoriqueAppelOffresAC histoacAttribution(Integer histoacAttribution) {
        this.histoacAttribution = histoacAttribution;
        return this;
    }

    public void setHistoacAttribution(Integer histoacAttribution) {
        this.histoacAttribution = histoacAttribution;
    }

    public Integer getHistoacAc() {
        return histoacAc;
    }

    public HistoriqueAppelOffresAC histoacAc(Integer histoacAc) {
        this.histoacAc = histoacAc;
        return this;
    }

    public void setHistoacAc(Integer histoacAc) {
        this.histoacAc = histoacAc;
    }

    public String getValiderparNom() {
        return validerparNom;
    }

    public HistoriqueAppelOffresAC validerparNom(String validerparNom) {
        this.validerparNom = validerparNom;
        return this;
    }

    public void setValiderparNom(String validerparNom) {
        this.validerparNom = validerparNom;
    }

    public String getValiderparPrenom() {
        return validerparPrenom;
    }

    public HistoriqueAppelOffresAC validerparPrenom(String validerparPrenom) {
        this.validerparPrenom = validerparPrenom;
        return this;
    }

    public void setValiderparPrenom(String validerparPrenom) {
        this.validerparPrenom = validerparPrenom;
    }

    public Long getUserId() {
        return userId;
    }

    public HistoriqueAppelOffresAC userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public HistoriqueAppelOffresAC autiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
        return this;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public HistoriqueAppelOffresAC dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueAppelOffresAC)) {
            return false;
        }
        return id != null && id.equals(((HistoriqueAppelOffresAC) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueAppelOffresAC{" +
            "id=" + getId() +
            ", histoacValidation='" + getHistoacValidation() + "'" +
            ", histoacCommentaire='" + getHistoacCommentaire() + "'" +
            ", histoacFichiervalidation='" + getHistoacFichiervalidation() + "'" +
            ", histoacBorderau='" + getHistoacBorderau() + "'" +
            ", histoValidation='" + getHistoValidation() + "'" +
            ", histoCommentaire='" + getHistoCommentaire() + "'" +
            ", histoFichiervalidation='" + getHistoFichiervalidation() + "'" +
            ", daoFichier='" + getDaoFichier() + "'" +
            ", origine='" + getOrigine() + "'" +
            ", histoacDatevalidation='" + getHistoacDatevalidation() + "'" +
            ", histoacDatecreationdossier='" + getHistoacDatecreationdossier() + "'" +
            ", histoDatevalidation='" + getHistoDatevalidation() + "'" +
            ", histoacAttribution=" + getHistoacAttribution() +
            ", histoacAc=" + getHistoacAc() +
            ", validerparNom='" + getValiderparNom() + "'" +
            ", validerparPrenom='" + getValiderparPrenom() + "'" +
            ", userId=" + getUserId() +
            ", autiriteId=" + getAutiriteId() +
            "}";
    }
}
