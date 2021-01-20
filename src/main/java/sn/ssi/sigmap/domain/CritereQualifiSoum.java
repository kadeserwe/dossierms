package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE CriteresQualificationsSoumissionnaire
 */
@Entity
@Table(name = "critere_qualifi_soum")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CritereQualifiSoum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "conforme")
    private Integer conforme;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "libelle_lot")
    private String libelleLot;

    @ManyToOne
    @JsonIgnoreProperties(value = "critereQualifiSoums", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "critereQualifiSoums", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "critereQualifiSoums", allowSetters = true)
    private Lot lot;

    @ManyToOne
    @JsonIgnoreProperties(value = "critereQualifiSoums", allowSetters = true)
    private DossiersSouscritere dossiersSosuscritere;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConforme() {
        return conforme;
    }

    public CritereQualifiSoum conforme(Integer conforme) {
        this.conforme = conforme;
        return this;
    }

    public void setConforme(Integer conforme) {
        this.conforme = conforme;
    }

    public String getLibelle() {
        return libelle;
    }

    public CritereQualifiSoum libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleLot() {
        return libelleLot;
    }

    public CritereQualifiSoum libelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
        return this;
    }

    public void setLibelleLot(String libelleLot) {
        this.libelleLot = libelleLot;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public CritereQualifiSoum dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public CritereQualifiSoum plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public Lot getLot() {
        return lot;
    }

    public CritereQualifiSoum lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public DossiersSouscritere getDossiersSosuscritere() {
        return dossiersSosuscritere;
    }

    public CritereQualifiSoum dossiersSosuscritere(DossiersSouscritere dossiersSouscritere) {
        this.dossiersSosuscritere = dossiersSouscritere;
        return this;
    }

    public void setDossiersSosuscritere(DossiersSouscritere dossiersSouscritere) {
        this.dossiersSosuscritere = dossiersSouscritere;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CritereQualifiSoum)) {
            return false;
        }
        return id != null && id.equals(((CritereQualifiSoum) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CritereQualifiSoum{" +
            "id=" + getId() +
            ", conforme=" + getConforme() +
            ", libelle='" + getLibelle() + "'" +
            ", libelleLot='" + getLibelleLot() + "'" +
            "}";
    }
}
