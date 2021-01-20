package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TABLE GarantiesSoumissionnaire
 */
@Entity
@Table(name = "garanties_soumissionnaire")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GarantiesSoumissionnaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "fournie")
    private String fournie;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "observations")
    private String observations;

    @Column(name = "libellelot")
    private String libellelot;

    @Column(name = "montant", precision = 21, scale = 2)
    private BigDecimal montant;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesSoumissionnaires", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesSoumissionnaires", allowSetters = true)
    private GarantiesDossier garantiesDossier;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesSoumissionnaires", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesSoumissionnaires", allowSetters = true)
    private NaturesGarantie naturesGarantie;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFournie() {
        return fournie;
    }

    public GarantiesSoumissionnaire fournie(String fournie) {
        this.fournie = fournie;
        return this;
    }

    public void setFournie(String fournie) {
        this.fournie = fournie;
    }

    public String getLibelle() {
        return libelle;
    }

    public GarantiesSoumissionnaire libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getObservations() {
        return observations;
    }

    public GarantiesSoumissionnaire observations(String observations) {
        this.observations = observations;
        return this;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getLibellelot() {
        return libellelot;
    }

    public GarantiesSoumissionnaire libellelot(String libellelot) {
        this.libellelot = libellelot;
        return this;
    }

    public void setLibellelot(String libellelot) {
        this.libellelot = libellelot;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public GarantiesSoumissionnaire montant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public GarantiesSoumissionnaire dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public GarantiesDossier getGarantiesDossier() {
        return garantiesDossier;
    }

    public GarantiesSoumissionnaire garantiesDossier(GarantiesDossier garantiesDossier) {
        this.garantiesDossier = garantiesDossier;
        return this;
    }

    public void setGarantiesDossier(GarantiesDossier garantiesDossier) {
        this.garantiesDossier = garantiesDossier;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public GarantiesSoumissionnaire plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public NaturesGarantie getNaturesGarantie() {
        return naturesGarantie;
    }

    public GarantiesSoumissionnaire naturesGarantie(NaturesGarantie naturesGarantie) {
        this.naturesGarantie = naturesGarantie;
        return this;
    }

    public void setNaturesGarantie(NaturesGarantie naturesGarantie) {
        this.naturesGarantie = naturesGarantie;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GarantiesSoumissionnaire)) {
            return false;
        }
        return id != null && id.equals(((GarantiesSoumissionnaire) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GarantiesSoumissionnaire{" +
            "id=" + getId() +
            ", fournie='" + getFournie() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", observations='" + getObservations() + "'" +
            ", libellelot='" + getLibellelot() + "'" +
            ", montant=" + getMontant() +
            "}";
    }
}
