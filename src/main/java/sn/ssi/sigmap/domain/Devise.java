package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TABLE DEVISE
 */
@Entity
@Table(name = "devise")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Devise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "dev_taux_conversion", precision = 21, scale = 2)
    private BigDecimal devTauxConversion;

    @ManyToOne
    @JsonIgnoreProperties(value = "devises", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "devises", allowSetters = true)
    private MonnaieOffre monnaieOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDevTauxConversion() {
        return devTauxConversion;
    }

    public Devise devTauxConversion(BigDecimal devTauxConversion) {
        this.devTauxConversion = devTauxConversion;
        return this;
    }

    public void setDevTauxConversion(BigDecimal devTauxConversion) {
        this.devTauxConversion = devTauxConversion;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public Devise dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public MonnaieOffre getMonnaieOffre() {
        return monnaieOffre;
    }

    public Devise monnaieOffre(MonnaieOffre monnaieOffre) {
        this.monnaieOffre = monnaieOffre;
        return this;
    }

    public void setMonnaieOffre(MonnaieOffre monnaieOffre) {
        this.monnaieOffre = monnaieOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Devise)) {
            return false;
        }
        return id != null && id.equals(((Devise) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Devise{" +
            "id=" + getId() +
            ", devTauxConversion=" + getDevTauxConversion() +
            "}";
    }
}
