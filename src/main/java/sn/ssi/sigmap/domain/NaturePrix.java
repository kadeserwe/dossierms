package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Natureprix
 */
@Entity
@Table(name = "nature_prix")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NaturePrix implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nat_code")
    private String natCode;

    @Column(name = "nat_libelle")
    private String natLibelle;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNatCode() {
        return natCode;
    }

    public NaturePrix natCode(String natCode) {
        this.natCode = natCode;
        return this;
    }

    public void setNatCode(String natCode) {
        this.natCode = natCode;
    }

    public String getNatLibelle() {
        return natLibelle;
    }

    public NaturePrix natLibelle(String natLibelle) {
        this.natLibelle = natLibelle;
        return this;
    }

    public void setNatLibelle(String natLibelle) {
        this.natLibelle = natLibelle;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NaturePrix)) {
            return false;
        }
        return id != null && id.equals(((NaturePrix) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "NaturePrix{" +
            "id=" + getId() +
            ", natCode='" + getNatCode() + "'" +
            ", natLibelle='" + getNatLibelle() + "'" +
            "}";
    }
}
