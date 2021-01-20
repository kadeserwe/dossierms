package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TABLE CriteresQualificationsSoumissionnaire
 */
@Entity
@Table(name = "dossiers_souscritere")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DossiersSouscritere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "note", precision = 21, scale = 2)
    private BigDecimal note;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersSouscriteres", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersSouscriteres", allowSetters = true)
    private Lot lot;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersSouscriteres", allowSetters = true)
    private Critere critere;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNote() {
        return note;
    }

    public DossiersSouscritere note(BigDecimal note) {
        this.note = note;
        return this;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public DossiersSouscritere dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Lot getLot() {
        return lot;
    }

    public DossiersSouscritere lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Critere getCritere() {
        return critere;
    }

    public DossiersSouscritere critere(Critere critere) {
        this.critere = critere;
        return this;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossiersSouscritere)) {
            return false;
        }
        return id != null && id.equals(((DossiersSouscritere) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersSouscritere{" +
            "id=" + getId() +
            ", note=" + getNote() +
            "}";
    }
}
