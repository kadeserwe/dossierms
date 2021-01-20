package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Fournisseur} entity.
 */
@ApiModel(description = "TABLE FOURNISSEUR")
public class FournisseurDTO implements Serializable {
    
    private Long id;

    private String nom;

    private String adresse;

    private String email;

    private Integer telephone;

    private Integer numeroRegistreCommerce;

    private String piecejointe;

    private String code;

    private String activite;

    private String adressecomptable;

    private String adressedirigeant;

    private String autredenomination;

    private String autreformejuridique;

    private String bpcomptable;

    private String bpdeux;

    private String bptrois;

    private String bpun;

    private String bpsecondaire;

    private String centreimpot;

    private String comptable;

    private String dirigeant;

    private String enseigne;

    private String etssecondaire;

    private String insae;

    private String formejuridique;

    private String proprietairesiege;

    private String quartier;

    private String numeroenregistrement;

    private String serviceencharge;

    private String siege;

    private String sigle;

    private String telcomptable;

    private String teldeux;

    private String teldirigeant;

    private String telsecondaire;

    private String teltrois;

    private String telun;

    private String ville;

    private String typedge;

    private String type;

    private String utilisateurLogin;

    private String fax;


    private Long catFournisseurId;
    
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getNumeroRegistreCommerce() {
        return numeroRegistreCommerce;
    }

    public void setNumeroRegistreCommerce(Integer numeroRegistreCommerce) {
        this.numeroRegistreCommerce = numeroRegistreCommerce;
    }

    public String getPiecejointe() {
        return piecejointe;
    }

    public void setPiecejointe(String piecejointe) {
        this.piecejointe = piecejointe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getAdressecomptable() {
        return adressecomptable;
    }

    public void setAdressecomptable(String adressecomptable) {
        this.adressecomptable = adressecomptable;
    }

    public String getAdressedirigeant() {
        return adressedirigeant;
    }

    public void setAdressedirigeant(String adressedirigeant) {
        this.adressedirigeant = adressedirigeant;
    }

    public String getAutredenomination() {
        return autredenomination;
    }

    public void setAutredenomination(String autredenomination) {
        this.autredenomination = autredenomination;
    }

    public String getAutreformejuridique() {
        return autreformejuridique;
    }

    public void setAutreformejuridique(String autreformejuridique) {
        this.autreformejuridique = autreformejuridique;
    }

    public String getBpcomptable() {
        return bpcomptable;
    }

    public void setBpcomptable(String bpcomptable) {
        this.bpcomptable = bpcomptable;
    }

    public String getBpdeux() {
        return bpdeux;
    }

    public void setBpdeux(String bpdeux) {
        this.bpdeux = bpdeux;
    }

    public String getBptrois() {
        return bptrois;
    }

    public void setBptrois(String bptrois) {
        this.bptrois = bptrois;
    }

    public String getBpun() {
        return bpun;
    }

    public void setBpun(String bpun) {
        this.bpun = bpun;
    }

    public String getBpsecondaire() {
        return bpsecondaire;
    }

    public void setBpsecondaire(String bpsecondaire) {
        this.bpsecondaire = bpsecondaire;
    }

    public String getCentreimpot() {
        return centreimpot;
    }

    public void setCentreimpot(String centreimpot) {
        this.centreimpot = centreimpot;
    }

    public String getComptable() {
        return comptable;
    }

    public void setComptable(String comptable) {
        this.comptable = comptable;
    }

    public String getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(String dirigeant) {
        this.dirigeant = dirigeant;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getEtssecondaire() {
        return etssecondaire;
    }

    public void setEtssecondaire(String etssecondaire) {
        this.etssecondaire = etssecondaire;
    }

    public String getInsae() {
        return insae;
    }

    public void setInsae(String insae) {
        this.insae = insae;
    }

    public String getFormejuridique() {
        return formejuridique;
    }

    public void setFormejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
    }

    public String getProprietairesiege() {
        return proprietairesiege;
    }

    public void setProprietairesiege(String proprietairesiege) {
        this.proprietairesiege = proprietairesiege;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getNumeroenregistrement() {
        return numeroenregistrement;
    }

    public void setNumeroenregistrement(String numeroenregistrement) {
        this.numeroenregistrement = numeroenregistrement;
    }

    public String getServiceencharge() {
        return serviceencharge;
    }

    public void setServiceencharge(String serviceencharge) {
        this.serviceencharge = serviceencharge;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getTelcomptable() {
        return telcomptable;
    }

    public void setTelcomptable(String telcomptable) {
        this.telcomptable = telcomptable;
    }

    public String getTeldeux() {
        return teldeux;
    }

    public void setTeldeux(String teldeux) {
        this.teldeux = teldeux;
    }

    public String getTeldirigeant() {
        return teldirigeant;
    }

    public void setTeldirigeant(String teldirigeant) {
        this.teldirigeant = teldirigeant;
    }

    public String getTelsecondaire() {
        return telsecondaire;
    }

    public void setTelsecondaire(String telsecondaire) {
        this.telsecondaire = telsecondaire;
    }

    public String getTeltrois() {
        return teltrois;
    }

    public void setTeltrois(String teltrois) {
        this.teltrois = teltrois;
    }

    public String getTelun() {
        return telun;
    }

    public void setTelun(String telun) {
        this.telun = telun;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTypedge() {
        return typedge;
    }

    public void setTypedge(String typedge) {
        this.typedge = typedge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUtilisateurLogin() {
        return utilisateurLogin;
    }

    public void setUtilisateurLogin(String utilisateurLogin) {
        this.utilisateurLogin = utilisateurLogin;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getCatFournisseurId() {
        return catFournisseurId;
    }

    public void setCatFournisseurId(Long catFournisseurId) {
        this.catFournisseurId = catFournisseurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FournisseurDTO)) {
            return false;
        }

        return id != null && id.equals(((FournisseurDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FournisseurDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephone=" + getTelephone() +
            ", numeroRegistreCommerce=" + getNumeroRegistreCommerce() +
            ", piecejointe='" + getPiecejointe() + "'" +
            ", code='" + getCode() + "'" +
            ", activite='" + getActivite() + "'" +
            ", adressecomptable='" + getAdressecomptable() + "'" +
            ", adressedirigeant='" + getAdressedirigeant() + "'" +
            ", autredenomination='" + getAutredenomination() + "'" +
            ", autreformejuridique='" + getAutreformejuridique() + "'" +
            ", bpcomptable='" + getBpcomptable() + "'" +
            ", bpdeux='" + getBpdeux() + "'" +
            ", bptrois='" + getBptrois() + "'" +
            ", bpun='" + getBpun() + "'" +
            ", bpsecondaire='" + getBpsecondaire() + "'" +
            ", centreimpot='" + getCentreimpot() + "'" +
            ", comptable='" + getComptable() + "'" +
            ", dirigeant='" + getDirigeant() + "'" +
            ", enseigne='" + getEnseigne() + "'" +
            ", etssecondaire='" + getEtssecondaire() + "'" +
            ", insae='" + getInsae() + "'" +
            ", formejuridique='" + getFormejuridique() + "'" +
            ", proprietairesiege='" + getProprietairesiege() + "'" +
            ", quartier='" + getQuartier() + "'" +
            ", numeroenregistrement='" + getNumeroenregistrement() + "'" +
            ", serviceencharge='" + getServiceencharge() + "'" +
            ", siege='" + getSiege() + "'" +
            ", sigle='" + getSigle() + "'" +
            ", telcomptable='" + getTelcomptable() + "'" +
            ", teldeux='" + getTeldeux() + "'" +
            ", teldirigeant='" + getTeldirigeant() + "'" +
            ", telsecondaire='" + getTelsecondaire() + "'" +
            ", teltrois='" + getTeltrois() + "'" +
            ", telun='" + getTelun() + "'" +
            ", ville='" + getVille() + "'" +
            ", typedge='" + getTypedge() + "'" +
            ", type='" + getType() + "'" +
            ", utilisateurLogin='" + getUtilisateurLogin() + "'" +
            ", fax='" + getFax() + "'" +
            ", catFournisseurId=" + getCatFournisseurId() +
            "}";
    }
}
