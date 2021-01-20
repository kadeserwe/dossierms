package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TABLE AvisAttribution
 */
@Entity
@Table(name = "avis_attribution")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AvisAttribution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "attri_objet")
    private String attriObjet;

    @Column(name = "attri_type")
    private String attriType;

    @Column(name = "attritexte")
    private String attritexte;

    @Column(name = "attri_ref")
    private String attriRef;

    @Column(name = "attrifichier")
    private String attrifichier;

    @Column(name = "attri_raisonsocial")
    private String attriRaisonsocial;

    @Column(name = "attri_date")
    private LocalDate attriDate;

    @Column(name = "attridatepublication")
    private LocalDate attridatepublication;

    @Column(name = "attri_pub")
    private Integer attriPub;

    @Column(name = "autirite_id")
    private Long autiriteId;

    @ManyToOne
    @JsonIgnoreProperties(value = "avisAttributions", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "avisAttributions", allowSetters = true)
    private Lot lot;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttriObjet() {
        return attriObjet;
    }

    public AvisAttribution attriObjet(String attriObjet) {
        this.attriObjet = attriObjet;
        return this;
    }

    public void setAttriObjet(String attriObjet) {
        this.attriObjet = attriObjet;
    }

    public String getAttriType() {
        return attriType;
    }

    public AvisAttribution attriType(String attriType) {
        this.attriType = attriType;
        return this;
    }

    public void setAttriType(String attriType) {
        this.attriType = attriType;
    }

    public String getAttritexte() {
        return attritexte;
    }

    public AvisAttribution attritexte(String attritexte) {
        this.attritexte = attritexte;
        return this;
    }

    public void setAttritexte(String attritexte) {
        this.attritexte = attritexte;
    }

    public String getAttriRef() {
        return attriRef;
    }

    public AvisAttribution attriRef(String attriRef) {
        this.attriRef = attriRef;
        return this;
    }

    public void setAttriRef(String attriRef) {
        this.attriRef = attriRef;
    }

    public String getAttrifichier() {
        return attrifichier;
    }

    public AvisAttribution attrifichier(String attrifichier) {
        this.attrifichier = attrifichier;
        return this;
    }

    public void setAttrifichier(String attrifichier) {
        this.attrifichier = attrifichier;
    }

    public String getAttriRaisonsocial() {
        return attriRaisonsocial;
    }

    public AvisAttribution attriRaisonsocial(String attriRaisonsocial) {
        this.attriRaisonsocial = attriRaisonsocial;
        return this;
    }

    public void setAttriRaisonsocial(String attriRaisonsocial) {
        this.attriRaisonsocial = attriRaisonsocial;
    }

    public LocalDate getAttriDate() {
        return attriDate;
    }

    public AvisAttribution attriDate(LocalDate attriDate) {
        this.attriDate = attriDate;
        return this;
    }

    public void setAttriDate(LocalDate attriDate) {
        this.attriDate = attriDate;
    }

    public LocalDate getAttridatepublication() {
        return attridatepublication;
    }

    public AvisAttribution attridatepublication(LocalDate attridatepublication) {
        this.attridatepublication = attridatepublication;
        return this;
    }

    public void setAttridatepublication(LocalDate attridatepublication) {
        this.attridatepublication = attridatepublication;
    }

    public Integer getAttriPub() {
        return attriPub;
    }

    public AvisAttribution attriPub(Integer attriPub) {
        this.attriPub = attriPub;
        return this;
    }

    public void setAttriPub(Integer attriPub) {
        this.attriPub = attriPub;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public AvisAttribution autiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
        return this;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public AvisAttribution dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Lot getLot() {
        return lot;
    }

    public AvisAttribution lot(Lot lot) {
        this.lot = lot;
        return this;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvisAttribution)) {
            return false;
        }
        return id != null && id.equals(((AvisAttribution) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AvisAttribution{" +
            "id=" + getId() +
            ", attriObjet='" + getAttriObjet() + "'" +
            ", attriType='" + getAttriType() + "'" +
            ", attritexte='" + getAttritexte() + "'" +
            ", attriRef='" + getAttriRef() + "'" +
            ", attrifichier='" + getAttrifichier() + "'" +
            ", attriRaisonsocial='" + getAttriRaisonsocial() + "'" +
            ", attriDate='" + getAttriDate() + "'" +
            ", attridatepublication='" + getAttridatepublication() + "'" +
            ", attriPub=" + getAttriPub() +
            ", autiriteId=" + getAutiriteId() +
            "}";
    }
}
