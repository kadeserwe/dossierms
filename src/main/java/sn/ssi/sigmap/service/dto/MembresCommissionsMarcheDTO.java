package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.MembresCommissionsMarche} entity.
 */
@ApiModel(description = "TABLE MembresCommissionsMarche")
public class MembresCommissionsMarcheDTO implements Serializable {
    
    private Long id;

    private String nom;

    private String prenom;

    private String fonction;

    private String telephone;

    private String email;

    private String gestion;

    private String statut;

    private String typeMembre;

    private String arrete;

    private String fichierArrete;

    @Lob
    private byte[] photo;

    private String photoContentType;
    private String type;

    private String origine;

    private Integer etapePI;

    private Integer flagPresident;

    private Integer actif;

    private Integer position;

    private Integer reconduit;

    private Long autoriteId;

    private Long membre;

    private LocalDate dateArrete;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

    public String getArrete() {
        return arrete;
    }

    public void setArrete(String arrete) {
        this.arrete = arrete;
    }

    public String getFichierArrete() {
        return fichierArrete;
    }

    public void setFichierArrete(String fichierArrete) {
        this.fichierArrete = fichierArrete;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public Integer getEtapePI() {
        return etapePI;
    }

    public void setEtapePI(Integer etapePI) {
        this.etapePI = etapePI;
    }

    public Integer getFlagPresident() {
        return flagPresident;
    }

    public void setFlagPresident(Integer flagPresident) {
        this.flagPresident = flagPresident;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getReconduit() {
        return reconduit;
    }

    public void setReconduit(Integer reconduit) {
        this.reconduit = reconduit;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getMembre() {
        return membre;
    }

    public void setMembre(Long membre) {
        this.membre = membre;
    }

    public LocalDate getDateArrete() {
        return dateArrete;
    }

    public void setDateArrete(LocalDate dateArrete) {
        this.dateArrete = dateArrete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MembresCommissionsMarcheDTO)) {
            return false;
        }

        return id != null && id.equals(((MembresCommissionsMarcheDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MembresCommissionsMarcheDTO{" +
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
