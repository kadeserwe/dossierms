package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Piecesplisouverture
 */
@Entity
@Table(name = "pieces_plis_ouverture")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PiecesPlisOuverture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "etat")
    private String etat;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "etat_conforme")
    private String etatConforme;

    @ManyToOne
    @JsonIgnoreProperties(value = "piecesPlisOuvertures", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "piecesPlisOuvertures", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "piecesPlisOuvertures", allowSetters = true)
    private Piece piece;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public PiecesPlisOuverture etat(String etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public PiecesPlisOuverture libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEtatConforme() {
        return etatConforme;
    }

    public PiecesPlisOuverture etatConforme(String etatConforme) {
        this.etatConforme = etatConforme;
        return this;
    }

    public void setEtatConforme(String etatConforme) {
        this.etatConforme = etatConforme;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public PiecesPlisOuverture dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public PiecesPlisOuverture plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public Piece getPiece() {
        return piece;
    }

    public PiecesPlisOuverture piece(Piece piece) {
        this.piece = piece;
        return this;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PiecesPlisOuverture)) {
            return false;
        }
        return id != null && id.equals(((PiecesPlisOuverture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PiecesPlisOuverture{" +
            "id=" + getId() +
            ", etat='" + getEtat() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", etatConforme='" + getEtatConforme() + "'" +
            "}";
    }
}
