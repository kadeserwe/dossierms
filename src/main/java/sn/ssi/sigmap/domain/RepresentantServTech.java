package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TABLE RepresentantsServicesTechnique
 */
@Entity
@Table(name = "representant_serv_tech")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RepresentantServTech implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "representant")
    private String representant;

    @Column(name = "qualite")
    private String qualite;

    @Column(name = "presence")
    private String presence;

    @Column(name = "date_convocation")
    private LocalDate dateConvocation;

    @Column(name = "etape")
    private Integer etape;

    @ManyToOne
    @JsonIgnoreProperties(value = "representantServTeches", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepresentant() {
        return representant;
    }

    public RepresentantServTech representant(String representant) {
        this.representant = representant;
        return this;
    }

    public void setRepresentant(String representant) {
        this.representant = representant;
    }

    public String getQualite() {
        return qualite;
    }

    public RepresentantServTech qualite(String qualite) {
        this.qualite = qualite;
        return this;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getPresence() {
        return presence;
    }

    public RepresentantServTech presence(String presence) {
        this.presence = presence;
        return this;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public LocalDate getDateConvocation() {
        return dateConvocation;
    }

    public RepresentantServTech dateConvocation(LocalDate dateConvocation) {
        this.dateConvocation = dateConvocation;
        return this;
    }

    public void setDateConvocation(LocalDate dateConvocation) {
        this.dateConvocation = dateConvocation;
    }

    public Integer getEtape() {
        return etape;
    }

    public RepresentantServTech etape(Integer etape) {
        this.etape = etape;
        return this;
    }

    public void setEtape(Integer etape) {
        this.etape = etape;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public RepresentantServTech dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RepresentantServTech)) {
            return false;
        }
        return id != null && id.equals(((RepresentantServTech) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RepresentantServTech{" +
            "id=" + getId() +
            ", representant='" + getRepresentant() + "'" +
            ", qualite='" + getQualite() + "'" +
            ", presence='" + getPresence() + "'" +
            ", dateConvocation='" + getDateConvocation() + "'" +
            ", etape=" + getEtape() +
            "}";
    }
}
