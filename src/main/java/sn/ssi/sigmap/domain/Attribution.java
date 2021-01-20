package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * TABLE Attribution
 */
@Entity
@Table(name = "attribution")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Attribution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "reference_plande_passation")
    private String referencePlandePassation;

    @Column(name = "reference_avis_general")
    private String referenceAvisGeneral;

    @Column(name = "attributaire_provisoire")
    private String attributaireProvisoire;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "commentaire_definitif")
    private String commentaireDefinitif;

    @Column(name = "nom_fichier_def")
    private String nomFichierDef;

    @Column(name = "attri_type")
    private String attriType;

    @Column(name = "montant_marche", precision = 21, scale = 2)
    private BigDecimal montantMarche;

    @Column(name = "montantdefinitif", precision = 21, scale = 2)
    private BigDecimal montantdefinitif;

    @Column(name = "mois_execution")
    private Integer moisExecution;

    @Column(name = "semaine_execution")
    private Integer semaineExecution;

    @Column(name = "jours_execution")
    private Integer joursExecution;

    @Column(name = "date_publication_provisoire")
    private LocalDate datePublicationProvisoire;

    @Column(name = "date_publication_definitive")
    private LocalDate datePublicationDefinitive;

    @Column(name = "dateattribution")
    private LocalDate dateattribution;

    @ManyToOne
    @JsonIgnoreProperties(value = "attributions", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "attributions", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "attributions", allowSetters = true)
    private Lot lot;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencePlandePassation() {
        return referencePlandePassation;
    }

    public Attribution referencePlandePassation(String referencePlandePassation) {
        this.referencePlandePassation = referencePlandePassation;
        return this;
    }

    public void setReferencePlandePassation(String referencePlandePassation) {
        this.referencePlandePassation = referencePlandePassation;
    }

    public String getReferenceAvisGeneral() {
        return referenceAvisGeneral;
    }

    public Attribution referenceAvisGeneral(String referenceAvisGeneral) {
        this.referenceAvisGeneral = referenceAvisGeneral;
        return this;
    }

    public void setReferenceAvisGeneral(String referenceAvisGeneral) {
        this.referenceAvisGeneral = referenceAvisGeneral;
    }

    public String getAttributaireProvisoire() {
        return attributaireProvisoire;
    }

    public Attribution attributaireProvisoire(String attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
        return this;
    }

    public void setAttributaireProvisoire(String attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Attribution commentaire(String commentaire) {
        this.commentaire = commentaire;
        return this;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCommentaireDefinitif() {
        return commentaireDefinitif;
    }

    public Attribution commentaireDefinitif(String commentaireDefinitif) {
        this.commentaireDefinitif = commentaireDefinitif;
        return this;
    }

    public void setCommentaireDefinitif(String commentaireDefinitif) {
        this.commentaireDefinitif = commentaireDefinitif;
    }

    public String getNomFichierDef() {
        return nomFichierDef;
    }

    public Attribution nomFichierDef(String nomFichierDef) {
        this.nomFichierDef = nomFichierDef;
        return this;
    }

    public void setNomFichierDef(String nomFichierDef) {
        this.nomFichierDef = nomFichierDef;
    }

    public String getAttriType() {
        return attriType;
    }

    public Attribution attriType(String attriType) {
        this.attriType = attriType;
        return this;
    }

    public void setAttriType(String attriType) {
        this.attriType = attriType;
    }

    public BigDecimal getMontantMarche() {
        return montantMarche;
    }

    public Attribution montantMarche(BigDecimal montantMarche) {
        this.montantMarche = montantMarche;
        return this;
    }

    public void setMontantMarche(BigDecimal montantMarche) {
        this.montantMarche = montantMarche;
    }

    public BigDecimal getMontantdefinitif() {
        return montantdefinitif;
    }

    public Attribution montantdefinitif(BigDecimal montantdefinitif) {
        this.montantdefinitif = montantdefinitif;
        return this;
    }

    public void setMontantdefinitif(BigDecimal montantdefinitif) {
        this.montantdefinitif = montantdefinitif;
    }

    public Integer getMoisExecution() {
        return moisExecution;
    }

    public Attribution moisExecution(Integer moisExecution) {
        this.moisExecution = moisExecution;
        return this;
    }

    public void setMoisExecution(Integer moisExecution) {
        this.moisExecution = moisExecution;
    }

    public Integer getSemaineExecution() {
        return semaineExecution;
    }

    public Attribution semaineExecution(Integer semaineExecution) {
        this.semaineExecution = semaineExecution;
        return this;
    }

    public void setSemaineExecution(Integer semaineExecution) {
        this.semaineExecution = semaineExecution;
    }

    public Integer getJoursExecution() {
        return joursExecution;
    }

    public Attribution joursExecution(Integer joursExecution) {
        this.joursExecution = joursExecution;
        return this;
    }

    public void setJoursExecution(Integer joursExecution) {
        this.joursExecution = joursExecution;
    }

    public LocalDate getDatePublicationProvisoire() {
        return datePublicationProvisoire;
    }

    public Attribution datePublicationProvisoire(LocalDate datePublicationProvisoire) {
        this.datePublicationProvisoire = datePublicationProvisoire;
        return this;
    }

    public void setDatePublicationProvisoire(LocalDate datePublicationProvisoire) {
        this.datePublicationProvisoire = datePublicationProvisoire;
    }

    public LocalDate getDatePublicationDefinitive() {
        return datePublicationDefinitive;
    }

    public Attribution datePublicationDefinitive(LocalDate datePublicationDefinitive) {
        this.datePublicationDefinitive = datePublicationDefinitive;
        return this;
    }

    public void setDatePublicationDefinitive(LocalDate datePublicationDefinitive) {
        this.datePublicationDefinitive = datePublicationDefinitive;
    }

    public LocalDate getDateattribution() {
        return dateattribution;
    }

    public Attribution dateattribution(LocalDate dateattribution) {
        this.dateattribution = dateattribution;
        return this;
    }

    public void setDateattribution(LocalDate dateattribution) {
        this.dateattribution = dateattribution;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public Attribution dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public Attribution plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public Lot getLot() {
        return lot;
    }

    public Attribution lot(Lot lot) {
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
        if (!(o instanceof Attribution)) {
            return false;
        }
        return id != null && id.equals(((Attribution) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Attribution{" +
            "id=" + getId() +
            ", referencePlandePassation='" + getReferencePlandePassation() + "'" +
            ", referenceAvisGeneral='" + getReferenceAvisGeneral() + "'" +
            ", attributaireProvisoire='" + getAttributaireProvisoire() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            ", commentaireDefinitif='" + getCommentaireDefinitif() + "'" +
            ", nomFichierDef='" + getNomFichierDef() + "'" +
            ", attriType='" + getAttriType() + "'" +
            ", montantMarche=" + getMontantMarche() +
            ", montantdefinitif=" + getMontantdefinitif() +
            ", moisExecution=" + getMoisExecution() +
            ", semaineExecution=" + getSemaineExecution() +
            ", joursExecution=" + getJoursExecution() +
            ", datePublicationProvisoire='" + getDatePublicationProvisoire() + "'" +
            ", datePublicationDefinitive='" + getDatePublicationDefinitive() + "'" +
            ", dateattribution='" + getDateattribution() + "'" +
            "}";
    }
}
