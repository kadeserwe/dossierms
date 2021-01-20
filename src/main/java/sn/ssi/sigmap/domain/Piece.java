package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE PIECE
 */
@Entity
@Table(name = "piece")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Piece implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "codepiece")
    private String codepiece;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "type")
    private Integer type;

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

    public Piece libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public Piece description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodepiece() {
        return codepiece;
    }

    public Piece codepiece(String codepiece) {
        this.codepiece = codepiece;
        return this;
    }

    public void setCodepiece(String codepiece) {
        this.codepiece = codepiece;
    }

    public String getLocalisation() {
        return localisation;
    }

    public Piece localisation(String localisation) {
        this.localisation = localisation;
        return this;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getType() {
        return type;
    }

    public Piece type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public Piece autoriteId(Long autoriteId) {
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
        if (!(o instanceof Piece)) {
            return false;
        }
        return id != null && id.equals(((Piece) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Piece{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", description='" + getDescription() + "'" +
            ", codepiece='" + getCodepiece() + "'" +
            ", localisation='" + getLocalisation() + "'" +
            ", type=" + getType() +
            ", autoriteId=" + getAutoriteId() +
            "}";
    }
}
