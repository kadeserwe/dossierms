package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Document.
 */
@Entity
@Table(name = "document")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "type_document")
    private String typeDocument;

    @Column(name = "text_pv_ouverture")
    private String textPVOuverture;

    @Column(name = "nom_fichier")
    private String nomFichier;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "reference")
    private String reference;

    @Column(name = "objet")
    private String objet;

    @Column(name = "origine")
    private String origine;

    @Column(name = "lieu_acquisition_dao")
    private String lieuAcquisitionDAO;

    @Column(name = "fichier_demande_publication")
    private String fichierDemandePublication;

    @Column(name = "fichier_dc")
    private String fichierDC;

    @Column(name = "fichier_ar")
    private String fichierAR;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "heure")
    private LocalDate heure;

    @Column(name = "date_demande_publication")
    private LocalDate dateDemandePublication;

    @Column(name = "date_limite_depot")
    private LocalDate dateLimiteDepot;

    @Column(name = "heure_limite_depot")
    private LocalDate heureLimiteDepot;

    @Column(name = "date_ouvertue_desplis")
    private LocalDate dateOuvertueDesplis;

    @Column(name = "heure_ouverture_des_plis")
    private LocalDate heureOuvertureDesPlis;

    @NotNull
    @Column(name = "autorite_id", nullable = false)
    private Long autoriteId;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private AppelOffre appelOffre;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private PlisOuverture plisOuverture;

    @ManyToOne
    @JsonIgnoreProperties(value = "documents", allowSetters = true)
    private Lot lot;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public Document typeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
        return this;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTextPVOuverture() {
        return textPVOuverture;
    }

    public Document textPVOuverture(String textPVOuverture) {
        this.textPVOuverture = textPVOuverture;
        return this;
    }

    public void setTextPVOuverture(String textPVOuverture) {
        this.textPVOuverture = textPVOuverture;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public Document nomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        return this;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getLibelle() {
        return libelle;
    }

    public Document libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public Document reference(String reference) {
        this.reference = reference;
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjet() {
        return objet;
    }

    public Document objet(String objet) {
        this.objet = objet;
        return this;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getOrigine() {
        return origine;
    }

    public Document origine(String origine) {
        this.origine = origine;
        return this;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getLieuAcquisitionDAO() {
        return lieuAcquisitionDAO;
    }

    public Document lieuAcquisitionDAO(String lieuAcquisitionDAO) {
        this.lieuAcquisitionDAO = lieuAcquisitionDAO;
        return this;
    }

    public void setLieuAcquisitionDAO(String lieuAcquisitionDAO) {
        this.lieuAcquisitionDAO = lieuAcquisitionDAO;
    }

    public String getFichierDemandePublication() {
        return fichierDemandePublication;
    }

    public Document fichierDemandePublication(String fichierDemandePublication) {
        this.fichierDemandePublication = fichierDemandePublication;
        return this;
    }

    public void setFichierDemandePublication(String fichierDemandePublication) {
        this.fichierDemandePublication = fichierDemandePublication;
    }

    public String getFichierDC() {
        return fichierDC;
    }

    public Document fichierDC(String fichierDC) {
        this.fichierDC = fichierDC;
        return this;
    }

    public void setFichierDC(String fichierDC) {
        this.fichierDC = fichierDC;
    }

    public String getFichierAR() {
        return fichierAR;
    }

    public Document fichierAR(String fichierAR) {
        this.fichierAR = fichierAR;
        return this;
    }

    public void setFichierAR(String fichierAR) {
        this.fichierAR = fichierAR;
    }

    public LocalDate getDate() {
        return date;
    }

    public Document date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getHeure() {
        return heure;
    }

    public Document heure(LocalDate heure) {
        this.heure = heure;
        return this;
    }

    public void setHeure(LocalDate heure) {
        this.heure = heure;
    }

    public LocalDate getDateDemandePublication() {
        return dateDemandePublication;
    }

    public Document dateDemandePublication(LocalDate dateDemandePublication) {
        this.dateDemandePublication = dateDemandePublication;
        return this;
    }

    public void setDateDemandePublication(LocalDate dateDemandePublication) {
        this.dateDemandePublication = dateDemandePublication;
    }

    public LocalDate getDateLimiteDepot() {
        return dateLimiteDepot;
    }

    public Document dateLimiteDepot(LocalDate dateLimiteDepot) {
        this.dateLimiteDepot = dateLimiteDepot;
        return this;
    }

    public void setDateLimiteDepot(LocalDate dateLimiteDepot) {
        this.dateLimiteDepot = dateLimiteDepot;
    }

    public LocalDate getHeureLimiteDepot() {
        return heureLimiteDepot;
    }

    public Document heureLimiteDepot(LocalDate heureLimiteDepot) {
        this.heureLimiteDepot = heureLimiteDepot;
        return this;
    }

    public void setHeureLimiteDepot(LocalDate heureLimiteDepot) {
        this.heureLimiteDepot = heureLimiteDepot;
    }

    public LocalDate getDateOuvertueDesplis() {
        return dateOuvertueDesplis;
    }

    public Document dateOuvertueDesplis(LocalDate dateOuvertueDesplis) {
        this.dateOuvertueDesplis = dateOuvertueDesplis;
        return this;
    }

    public void setDateOuvertueDesplis(LocalDate dateOuvertueDesplis) {
        this.dateOuvertueDesplis = dateOuvertueDesplis;
    }

    public LocalDate getHeureOuvertureDesPlis() {
        return heureOuvertureDesPlis;
    }

    public Document heureOuvertureDesPlis(LocalDate heureOuvertureDesPlis) {
        this.heureOuvertureDesPlis = heureOuvertureDesPlis;
        return this;
    }

    public void setHeureOuvertureDesPlis(LocalDate heureOuvertureDesPlis) {
        this.heureOuvertureDesPlis = heureOuvertureDesPlis;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public Document autoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
        return this;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public Document dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }

    public AppelOffre getAppelOffre() {
        return appelOffre;
    }

    public Document appelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
        return this;
    }

    public void setAppelOffre(AppelOffre appelOffre) {
        this.appelOffre = appelOffre;
    }

    public PlisOuverture getPlisOuverture() {
        return plisOuverture;
    }

    public Document plisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
        return this;
    }

    public void setPlisOuverture(PlisOuverture plisOuverture) {
        this.plisOuverture = plisOuverture;
    }

    public Lot getLot() {
        return lot;
    }

    public Document lot(Lot lot) {
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
        if (!(o instanceof Document)) {
            return false;
        }
        return id != null && id.equals(((Document) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Document{" +
            "id=" + getId() +
            ", typeDocument='" + getTypeDocument() + "'" +
            ", textPVOuverture='" + getTextPVOuverture() + "'" +
            ", nomFichier='" + getNomFichier() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", reference='" + getReference() + "'" +
            ", objet='" + getObjet() + "'" +
            ", origine='" + getOrigine() + "'" +
            ", lieuAcquisitionDAO='" + getLieuAcquisitionDAO() + "'" +
            ", fichierDemandePublication='" + getFichierDemandePublication() + "'" +
            ", fichierDC='" + getFichierDC() + "'" +
            ", fichierAR='" + getFichierAR() + "'" +
            ", date='" + getDate() + "'" +
            ", heure='" + getHeure() + "'" +
            ", dateDemandePublication='" + getDateDemandePublication() + "'" +
            ", dateLimiteDepot='" + getDateLimiteDepot() + "'" +
            ", heureLimiteDepot='" + getHeureLimiteDepot() + "'" +
            ", dateOuvertueDesplis='" + getDateOuvertueDesplis() + "'" +
            ", heureOuvertureDesPlis='" + getHeureOuvertureDesPlis() + "'" +
            ", autoriteId=" + getAutoriteId() +
            "}";
    }
}
