package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TABLE GARANTIE
 */
@Entity
@Table(name = "garanties_dossier")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GarantiesDossier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "pourcentage", precision = 21, scale = 2)
    private BigDecimal pourcentage;

    @Column(name = "montant", precision = 21, scale = 2)
    private BigDecimal montant;

    @Column(name = "autirite_id")
    private Long autiriteId;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesDossiers", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesDossiers", allowSetters = true)
    private Lot lot;

    @ManyToOne
    @JsonIgnoreProperties(value = "garantiesDossiers", allowSetters = true)
    private PiecesRecus piecesRecus;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPourcentage() {
        return pourcentage;
    }

    public GarantiesDossier pourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
        return this;
    }

    public void setPourcentage(BigDecimal pourcentage) {
        this.pourcentage = pourcentage;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public GarantiesDossier montant(BigDecimal montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public GarantiesDossier autiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
        return this;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public GarantiesDossier dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Lot getLot() {
        return lot;
    }

    public GarantiesDossier lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public PiecesRecus getPiecesRecus() {
        return piecesRecus;
    }

    public GarantiesDossier piecesRecus(PiecesRecus piecesRecus) {
        this.piecesRecus = piecesRecus;
        return this;
    }

    public void setPiecesRecus(PiecesRecus piecesRecus) {
        this.piecesRecus = piecesRecus;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GarantiesDossier)) {
            return false;
        }
        return id != null && id.equals(((GarantiesDossier) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GarantiesDossier{" +
            "id=" + getId() +
            ", pourcentage=" + getPourcentage() +
            ", montant=" + getMontant() +
            ", autiriteId=" + getAutiriteId() +
            "}";
    }
}
