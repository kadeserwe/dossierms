package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Dossierscommissionsmarche
 */
@Entity
@Table(name = "dossiers_commissions_marche")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DossiersCommissionsMarche implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "flag_presence_evaluation")
    private Integer flagPresenceEvaluation;

    @Column(name = "etape_pi")
    private Integer etapePI;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersCommissionsMarches", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersCommissionsMarches", allowSetters = true)
    private MembresCommissionsMarche membresCommissionsMarche;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFlagPresenceEvaluation() {
        return flagPresenceEvaluation;
    }

    public DossiersCommissionsMarche flagPresenceEvaluation(Integer flagPresenceEvaluation) {
        this.flagPresenceEvaluation = flagPresenceEvaluation;
        return this;
    }

    public void setFlagPresenceEvaluation(Integer flagPresenceEvaluation) {
        this.flagPresenceEvaluation = flagPresenceEvaluation;
    }

    public Integer getEtapePI() {
        return etapePI;
    }

    public DossiersCommissionsMarche etapePI(Integer etapePI) {
        this.etapePI = etapePI;
        return this;
    }

    public void setEtapePI(Integer etapePI) {
        this.etapePI = etapePI;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public DossiersCommissionsMarche dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public MembresCommissionsMarche getMembresCommissionsMarche() {
        return membresCommissionsMarche;
    }

    public DossiersCommissionsMarche membresCommissionsMarche(MembresCommissionsMarche membresCommissionsMarche) {
        this.membresCommissionsMarche = membresCommissionsMarche;
        return this;
    }

    public void setMembresCommissionsMarche(MembresCommissionsMarche membresCommissionsMarche) {
        this.membresCommissionsMarche = membresCommissionsMarche;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DossiersCommissionsMarche)) {
            return false;
        }
        return id != null && id.equals(((DossiersCommissionsMarche) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersCommissionsMarche{" +
            "id=" + getId() +
            ", flagPresenceEvaluation=" + getFlagPresenceEvaluation() +
            ", etapePI=" + getEtapePI() +
            "}";
    }
}
