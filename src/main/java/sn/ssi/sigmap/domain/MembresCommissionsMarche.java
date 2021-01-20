package sn.ssi.sigmap.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TABLE MembresCommissionsMarche
 */
@Entity
@Table(name = "membres_commissions_marche")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MembresCommissionsMarche implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "fonction")
    private String fonction;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "gestion")
    private String gestion;

    @Column(name = "statut")
    private String statut;

    @Column(name = "type_membre")
    private String typeMembre;

    @Column(name = "arrete")
    private String arrete;

    @Column(name = "fichier_arrete")
    private String fichierArrete;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_content_type")
    private String photoContentType;

    @Column(name = "type")
    private String type;

    @Column(name = "origine")
    private String origine;

    @Column(name = "etape_pi")
    private Integer etapePI;

    @Column(name = "flag_president")
    private Integer flagPresident;

    @Column(name = "actif")
    private Integer actif;

    @Column(name = "position")
    private Integer position;

    @Column(name = "reconduit")
    private Integer reconduit;

    @Column(name = "autorite_id")
    private Long autoriteId;

    @Column(name = "membre")
    private Long membre;

    @Column(name = "date_arrete")
    private LocalDate dateArrete;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public MembresCommissionsMarche nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public MembresCommissionsMarche prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public MembresCommissionsMarche fonction(String fonction) {
        this.fonction = fonction;
        return this;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTelephone() {
        return telephone;
    }

    public MembresCommissionsMarche telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public MembresCommissionsMarche email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGestion() {
        return gestion;
    }

    public MembresCommissionsMarche gestion(String gestion) {
        this.gestion = gestion;
        return this;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getStatut() {
        return statut;
    }

    public MembresCommissionsMarche statut(String statut) {
        this.statut = statut;
        return this;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTypeMembre() {
        return typeMembre;
    }

    public MembresCommissionsMarche typeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
        return this;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

    public String getArrete() {
        return arrete;
    }

    public MembresCommissionsMarche arrete(String arrete) {
        this.arrete = arrete;
        return this;
    }

    public void setArrete(String arrete) {
        this.arrete = arrete;
    }

    public String getFichierArrete() {
        return fichierArrete;
    }

    public MembresCommissionsMarche fichierArrete(String fichierArrete) {
        this.fichierArrete = fichierArrete;
        return this;
    }

    public void setFichierArrete(String fichierArrete) {
        this.fichierArrete = fichierArrete;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public MembresCommissionsMarche photo(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public MembresCommissionsMarche photoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
        return this;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getType() {
        return type;
    }

    public MembresCommissionsMarche type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigine() {
        return origine;
    }

    public MembresCommissionsMarche origine(String origine) {
        this.origine = origine;
        return this;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public Integer getEtapePI() {
        return etapePI;
    }

    public MembresCommissionsMarche etapePI(Integer etapePI) {
        this.etapePI = etapePI;
        return this;
    }

    public void setEtapePI(Integer etapePI) {
        this.etapePI = etapePI;
    }

    public Integer getFlagPresident() {
        return flagPresident;
    }

    public MembresCommissionsMarche flagPresident(Integer flagPresident) {
        this.flagPresident = flagPresident;
        return this;
    }

    public void setFlagPresident(Integer flagPresident) {
        this.flagPresident = flagPresident;
    }

    public Integer getActif() {
        return actif;
    }

    public MembresCommissionsMarche actif(Integer actif) {
        this.actif = actif;
        return this;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public Integer getPosition() {
        return position;
    }

    public MembresCommissionsMarche position(Integer position) {
        this.position = position;
        return this;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getReconduit() {
        return reconduit;
    }

    public MembresCommissionsMarche reconduit(Integer reconduit) {
        this.reconduit = reconduit;
        return this;
    }

    public void setReconduit(Integer reconduit) {
        this.reconduit = reconduit;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public MembresCommissionsMarche autoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
        return this;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getMembre() {
        return membre;
    }

    public MembresCommissionsMarche membre(Long membre) {
        this.membre = membre;
        return this;
    }

    public void setMembre(Long membre) {
        this.membre = membre;
    }

    public LocalDate getDateArrete() {
        return dateArrete;
    }

    public MembresCommissionsMarche dateArrete(LocalDate dateArrete) {
        this.dateArrete = dateArrete;
        return this;
    }

    public void setDateArrete(LocalDate dateArrete) {
        this.dateArrete = dateArrete;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MembresCommissionsMarche)) {
            return false;
        }
        return id != null && id.equals(((MembresCommissionsMarche) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MembresCommissionsMarche{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", fonction='" + getFonction() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", email='" + getEmail() + "'" +
            ", gestion='" + getGestion() + "'" +
            ", statut='" + getStatut() + "'" +
            ", typeMembre='" + getTypeMembre() + "'" +
            ", arrete='" + getArrete() + "'" +
            ", fichierArrete='" + getFichierArrete() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", photoContentType='" + getPhotoContentType() + "'" +
            ", type='" + getType() + "'" +
            ", origine='" + getOrigine() + "'" +
            ", etapePI=" + getEtapePI() +
            ", flagPresident=" + getFlagPresident() +
            ", actif=" + getActif() +
            ", position=" + getPosition() +
            ", reconduit=" + getReconduit() +
            ", autoriteId=" + getAutoriteId() +
            ", membre=" + getMembre() +
            ", dateArrete='" + getDateArrete() + "'" +
            "}";
    }
}
