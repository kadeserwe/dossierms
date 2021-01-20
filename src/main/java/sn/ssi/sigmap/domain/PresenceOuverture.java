package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE Presenceouverture
 */
@Entity
@Table(name = "presence_ouverture")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PresenceOuverture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "supplementaire")
    private String supplementaire;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "nom_representant")
    private String nomRepresentant;

    @Column(name = "prenom_representant")
    private String prenomRepresentant;

    @Column(name = "nom_structure")
    private String nomStructure;

    @Column(name = "qualite")
    private String qualite;

    @Column(name = "etape_pi")
    private Integer etapePI;

    @ManyToOne
    @JsonIgnoreProperties(value = "presenceOuvertures", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "presenceOuvertures", allowSetters = true)
    private AppelOffre appelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "presenceOuvertures", allowSetters = true)
    private PlisOuverture plisOuverture;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplementaire() {
        return supplementaire;
    }

    public PresenceOuverture supplementaire(String supplementaire) {
        this.supplementaire = supplementaire;
        return this;
    }

    public void setSupplementaire(String supplementaire) {
        this.supplementaire = supplementaire;
    }

    public String getEmail() {
        return email;
    }

    public PresenceOuverture email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public PresenceOuverture telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNomRepresentant() {
        return nomRepresentant;
    }

    public PresenceOuverture nomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
        return this;
    }

    public void setNomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
    }

    public String getPrenomRepresentant() {
        return prenomRepresentant;
    }

    public PresenceOuverture prenomRepresentant(String prenomRepresentant) {
        this.prenomRepresentant = prenomRepresentant;
        return this;
    }

    public void setPrenomRepresentant(String prenomRepresentant) {
        this.prenomRepresentant = prenomRepresentant;
    }

    public String getNomStructure() {
        return nomStructure;
    }

    public PresenceOuverture nomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
        return this;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getQualite() {
        return qualite;
    }

    public PresenceOuverture qualite(String qualite) {
        this.qualite = qualite;
        return this;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public Integer getEtapePI() {
        return etapePI;
    }

    public PresenceOuverture etapePI(Integer etapePI) {
        this.etapePI = etapePI;
        return this;
    }

    public void setEtapePI(Integer etapePI) {
        this.etapePI = etapePI;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public PresenceOuverture dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public PresenceOuverture appelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
        return this;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public PresenceOuverture plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PresenceOuverture)) {
            return false;
        }
        return id != null && id.equals(((PresenceOuverture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PresenceOuverture{" +
            "id=" + getId() +
            ", supplementaire='" + getSupplementaire() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", nomRepresentant='" + getNomRepresentant() + "'" +
            ", prenomRepresentant='" + getPrenomRepresentant() + "'" +
            ", nomStructure='" + getNomStructure() + "'" +
            ", qualite='" + getQualite() + "'" +
            ", etapePI=" + getEtapePI() +
            "}";
    }
}
