package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * TABLE RetraitRegistreDAO
 */
@Entity
@Table(name = "retrait_registre_dao")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RetraitRegistreDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nom_soumissionnaire")
    private String nomSoumissionnaire;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "mode_paiement")
    private String modePaiement;

    @Column(name = "ninea")
    private String ninea;

    @Column(name = "montant_verse", precision = 21, scale = 2)
    private BigDecimal montantVerse;

    @Column(name = "date_retrait")
    private LocalDate dateRetrait;

    @ManyToOne
    @JsonIgnoreProperties(value = "retraitRegistreDAOS", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "retraitRegistreDAOS", allowSetters = true)
    private Fournisseur fournisseur;

    @ManyToOne
    @JsonIgnoreProperties(value = "retraitRegistreDAOS", allowSetters = true)
    private Pays pays;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSoumissionnaire() {
        return nomSoumissionnaire;
    }

    public RetraitRegistreDAO nomSoumissionnaire(String nomSoumissionnaire) {
        this.nomSoumissionnaire = nomSoumissionnaire;
        return this;
    }

    public void setNomSoumissionnaire(String nomSoumissionnaire) {
        this.nomSoumissionnaire = nomSoumissionnaire;
    }

    public String getTelephone() {
        return telephone;
    }

    public RetraitRegistreDAO telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public RetraitRegistreDAO email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public RetraitRegistreDAO modePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
        return this;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public String getNinea() {
        return ninea;
    }

    public RetraitRegistreDAO ninea(String ninea) {
        this.ninea = ninea;
        return this;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public BigDecimal getMontantVerse() {
        return montantVerse;
    }

    public RetraitRegistreDAO montantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
        return this;
    }

    public void setMontantVerse(BigDecimal montantVerse) {
        this.montantVerse = montantVerse;
    }

    public LocalDate getDateRetrait() {
        return dateRetrait;
    }

    public RetraitRegistreDAO dateRetrait(LocalDate dateRetrait) {
        this.dateRetrait = dateRetrait;
        return this;
    }

    public void setDateRetrait(LocalDate dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public RetraitRegistreDAO dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public RetraitRegistreDAO fournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        return this;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Pays getPays() {
        return pays;
    }

    public RetraitRegistreDAO pays(Pays pays) {
        this.pays = pays;
        return this;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RetraitRegistreDAO)) {
            return false;
        }
        return id != null && id.equals(((RetraitRegistreDAO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RetraitRegistreDAO{" +
            "id=" + getId() +
            ", nomSoumissionnaire='" + getNomSoumissionnaire() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", email='" + getEmail() + "'" +
            ", modePaiement='" + getModePaiement() + "'" +
            ", ninea='" + getNinea() + "'" +
            ", montantVerse=" + getMontantVerse() +
            ", dateRetrait='" + getDateRetrait() + "'" +
            "}";
    }
}
