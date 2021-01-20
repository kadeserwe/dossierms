package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TABLE DossiersEvaluateur
 */
@Entity
@Table(name = "dossiers_evaluateur")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DossiersEvaluateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "commission")
    private String commission;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "fonction")
    private String fonction;

    @Column(name = "date_remise")
    private LocalDate dateRemise;

    @Column(name = "date_limite")
    private LocalDate dateLimite;

    @ManyToOne
    @JsonIgnoreProperties(value = "dossiersEvaluateurs", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommission() {
        return commission;
    }

    public DossiersEvaluateur commission(String commission) {
        this.commission = commission;
        return this;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getNom() {
        return nom;
    }

    public DossiersEvaluateur nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public DossiersEvaluateur prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public DossiersEvaluateur telephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public DossiersEvaluateur email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public DossiersEvaluateur fonction(String fonction) {
        this.fonction = fonction;
        return this;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public LocalDate getDateRemise() {
        return dateRemise;
    }

    public DossiersEvaluateur dateRemise(LocalDate dateRemise) {
        this.dateRemise = dateRemise;
        return this;
    }

    public void setDateRemise(LocalDate dateRemise) {
        this.dateRemise = dateRemise;
    }

    public LocalDate getDateLimite() {
        return dateLimite;
    }

    public DossiersEvaluateur dateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
        return this;
    }

    public void setDateLimite(LocalDate dateLimite) {
        this.dateLimite = dateLimite;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public DossiersEvaluateur dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
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
        if (!(o instanceof DossiersEvaluateur)) {
            return false;
        }
        return id != null && id.equals(((DossiersEvaluateur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersEvaluateur{" +
            "id=" + getId() +
            ", commission='" + getCommission() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", telephone=" + getTelephone() +
            ", email='" + getEmail() + "'" +
            ", fonction='" + getFonction() + "'" +
            ", dateRemise='" + getDateRemise() + "'" +
            ", dateLimite='" + getDateLimite() + "'" +
            "}";
    }
}
