package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Monnaieoffre
 */
@Entity
@Table(name = "monnaie_offre")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MonnaieOffre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "mon_code")
    private String monCode;

    @Column(name = "mon_libelle")
    private String monLibelle;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonCode() {
        return monCode;
    }

    public MonnaieOffre monCode(String monCode) {
        this.monCode = monCode;
        return this;
    }

    public void setMonCode(String monCode) {
        this.monCode = monCode;
    }

    public String getMonLibelle() {
        return monLibelle;
    }

    public MonnaieOffre monLibelle(String monLibelle) {
        this.monLibelle = monLibelle;
        return this;
    }

    public void setMonLibelle(String monLibelle) {
        this.monLibelle = monLibelle;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MonnaieOffre)) {
            return false;
        }
        return id != null && id.equals(((MonnaieOffre) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MonnaieOffre{" +
            "id=" + getId() +
            ", monCode='" + getMonCode() + "'" +
            ", monLibelle='" + getMonLibelle() + "'" +
            "}";
    }
}
