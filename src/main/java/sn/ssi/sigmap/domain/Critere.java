package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Critere
 */
@Entity
@Table(name = "critere")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Critere implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "autorite_id")
    private Long autoriteId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public Critere libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public Critere autoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
        return this;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Critere)) {
            return false;
        }
        return id != null && id.equals(((Critere) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Critere{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", autoriteId=" + getAutoriteId() +
            "}";
    }
}
