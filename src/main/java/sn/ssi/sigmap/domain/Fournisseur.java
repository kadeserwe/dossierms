package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE FOURNISSEUR
 */
@Entity
@Table(name = "fournisseur")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "numero_registre_commerce")
    private Integer numeroRegistreCommerce;

    @Column(name = "piecejointe")
    private String piecejointe;

    @Column(name = "code")
    private String code;

    @Column(name = "activite")
    private String activite;

    @Column(name = "adressecomptable")
    private String adressecomptable;

    @Column(name = "adressedirigeant")
    private String adressedirigeant;

    @Column(name = "autredenomination")
    private String autredenomination;

    @Column(name = "autreformejuridique")
    private String autreformejuridique;

    @Column(name = "bpcomptable")
    private String bpcomptable;

    @Column(name = "bpdeux")
    private String bpdeux;

    @Column(name = "bptrois")
    private String bptrois;

    @Column(name = "bpun")
    private String bpun;

    @Column(name = "bpsecondaire")
    private String bpsecondaire;

    @Column(name = "centreimpot")
    private String centreimpot;

    @Column(name = "comptable")
    private String comptable;

    @Column(name = "dirigeant")
    private String dirigeant;

    @Column(name = "enseigne")
    private String enseigne;

    @Column(name = "etssecondaire")
    private String etssecondaire;

    @Column(name = "insae")
    private String insae;

    @Column(name = "formejuridique")
    private String formejuridique;

    @Column(name = "proprietairesiege")
    private String proprietairesiege;

    @Column(name = "quartier")
    private String quartier;

    @Column(name = "numeroenregistrement")
    private String numeroenregistrement;

    @Column(name = "serviceencharge")
    private String serviceencharge;

    @Column(name = "siege")
    private String siege;

    @Column(name = "sigle")
    private String sigle;

    @Column(name = "telcomptable")
    private String telcomptable;

    @Column(name = "teldeux")
    private String teldeux;

    @Column(name = "teldirigeant")
    private String teldirigeant;

    @Column(name = "telsecondaire")
    private String telsecondaire;

    @Column(name = "teltrois")
    private String teltrois;

    @Column(name = "telun")
    private String telun;

    @Column(name = "ville")
    private String ville;

    @Column(name = "typedge")
    private String typedge;

    @Column(name = "type")
    private String type;

    @Column(name = "utilisateur_login")
    private String utilisateurLogin;

    @Column(name = "fax")
    private String fax;

    @ManyToOne
    @JsonIgnoreProperties(value = "fournisseurs", allowSetters = true)
    private CatFournisseur catFournisseur;

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

    public Fournisseur nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Fournisseur adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public Fournisseur email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public Fournisseur telephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getNumeroRegistreCommerce() {
        return numeroRegistreCommerce;
    }

    public Fournisseur numeroRegistreCommerce(Integer numeroRegistreCommerce) {
        this.numeroRegistreCommerce = numeroRegistreCommerce;
        return this;
    }

    public void setNumeroRegistreCommerce(Integer numeroRegistreCommerce) {
        this.numeroRegistreCommerce = numeroRegistreCommerce;
    }

    public String getPiecejointe() {
        return piecejointe;
    }

    public Fournisseur piecejointe(String piecejointe) {
        this.piecejointe = piecejointe;
        return this;
    }

    public void setPiecejointe(String piecejointe) {
        this.piecejointe = piecejointe;
    }

    public String getCode() {
        return code;
    }

    public Fournisseur code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getActivite() {
        return activite;
    }

    public Fournisseur activite(String activite) {
        this.activite = activite;
        return this;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getAdressecomptable() {
        return adressecomptable;
    }

    public Fournisseur adressecomptable(String adressecomptable) {
        this.adressecomptable = adressecomptable;
        return this;
    }

    public void setAdressecomptable(String adressecomptable) {
        this.adressecomptable = adressecomptable;
    }

    public String getAdressedirigeant() {
        return adressedirigeant;
    }

    public Fournisseur adressedirigeant(String adressedirigeant) {
        this.adressedirigeant = adressedirigeant;
        return this;
    }

    public void setAdressedirigeant(String adressedirigeant) {
        this.adressedirigeant = adressedirigeant;
    }

    public String getAutredenomination() {
        return autredenomination;
    }

    public Fournisseur autredenomination(String autredenomination) {
        this.autredenomination = autredenomination;
        return this;
    }

    public void setAutredenomination(String autredenomination) {
        this.autredenomination = autredenomination;
    }

    public String getAutreformejuridique() {
        return autreformejuridique;
    }

    public Fournisseur autreformejuridique(String autreformejuridique) {
        this.autreformejuridique = autreformejuridique;
        return this;
    }

    public void setAutreformejuridique(String autreformejuridique) {
        this.autreformejuridique = autreformejuridique;
    }

    public String getBpcomptable() {
        return bpcomptable;
    }

    public Fournisseur bpcomptable(String bpcomptable) {
        this.bpcomptable = bpcomptable;
        return this;
    }

    public void setBpcomptable(String bpcomptable) {
        this.bpcomptable = bpcomptable;
    }

    public String getBpdeux() {
        return bpdeux;
    }

    public Fournisseur bpdeux(String bpdeux) {
        this.bpdeux = bpdeux;
        return this;
    }

    public void setBpdeux(String bpdeux) {
        this.bpdeux = bpdeux;
    }

    public String getBptrois() {
        return bptrois;
    }

    public Fournisseur bptrois(String bptrois) {
        this.bptrois = bptrois;
        return this;
    }

    public void setBptrois(String bptrois) {
        this.bptrois = bptrois;
    }

    public String getBpun() {
        return bpun;
    }

    public Fournisseur bpun(String bpun) {
        this.bpun = bpun;
        return this;
    }

    public void setBpun(String bpun) {
        this.bpun = bpun;
    }

    public String getBpsecondaire() {
        return bpsecondaire;
    }

    public Fournisseur bpsecondaire(String bpsecondaire) {
        this.bpsecondaire = bpsecondaire;
        return this;
    }

    public void setBpsecondaire(String bpsecondaire) {
        this.bpsecondaire = bpsecondaire;
    }

    public String getCentreimpot() {
        return centreimpot;
    }

    public Fournisseur centreimpot(String centreimpot) {
        this.centreimpot = centreimpot;
        return this;
    }

    public void setCentreimpot(String centreimpot) {
        this.centreimpot = centreimpot;
    }

    public String getComptable() {
        return comptable;
    }

    public Fournisseur comptable(String comptable) {
        this.comptable = comptable;
        return this;
    }

    public void setComptable(String comptable) {
        this.comptable = comptable;
    }

    public String getDirigeant() {
        return dirigeant;
    }

    public Fournisseur dirigeant(String dirigeant) {
        this.dirigeant = dirigeant;
        return this;
    }

    public void setDirigeant(String dirigeant) {
        this.dirigeant = dirigeant;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public Fournisseur enseigne(String enseigne) {
        this.enseigne = enseigne;
        return this;
    }

    public void setEnseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getEtssecondaire() {
        return etssecondaire;
    }

    public Fournisseur etssecondaire(String etssecondaire) {
        this.etssecondaire = etssecondaire;
        return this;
    }

    public void setEtssecondaire(String etssecondaire) {
        this.etssecondaire = etssecondaire;
    }

    public String getInsae() {
        return insae;
    }

    public Fournisseur insae(String insae) {
        this.insae = insae;
        return this;
    }

    public void setInsae(String insae) {
        this.insae = insae;
    }

    public String getFormejuridique() {
        return formejuridique;
    }

    public Fournisseur formejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
        return this;
    }

    public void setFormejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
    }

    public String getProprietairesiege() {
        return proprietairesiege;
    }

    public Fournisseur proprietairesiege(String proprietairesiege) {
        this.proprietairesiege = proprietairesiege;
        return this;
    }

    public void setProprietairesiege(String proprietairesiege) {
        this.proprietairesiege = proprietairesiege;
    }

    public String getQuartier() {
        return quartier;
    }

    public Fournisseur quartier(String quartier) {
        this.quartier = quartier;
        return this;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getNumeroenregistrement() {
        return numeroenregistrement;
    }

    public Fournisseur numeroenregistrement(String numeroenregistrement) {
        this.numeroenregistrement = numeroenregistrement;
        return this;
    }

    public void setNumeroenregistrement(String numeroenregistrement) {
        this.numeroenregistrement = numeroenregistrement;
    }

    public String getServiceencharge() {
        return serviceencharge;
    }

    public Fournisseur serviceencharge(String serviceencharge) {
        this.serviceencharge = serviceencharge;
        return this;
    }

    public void setServiceencharge(String serviceencharge) {
        this.serviceencharge = serviceencharge;
    }

    public String getSiege() {
        return siege;
    }

    public Fournisseur siege(String siege) {
        this.siege = siege;
        return this;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getSigle() {
        return sigle;
    }

    public Fournisseur sigle(String sigle) {
        this.sigle = sigle;
        return this;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getTelcomptable() {
        return telcomptable;
    }

    public Fournisseur telcomptable(String telcomptable) {
        this.telcomptable = telcomptable;
        return this;
    }

    public void setTelcomptable(String telcomptable) {
        this.telcomptable = telcomptable;
    }

    public String getTeldeux() {
        return teldeux;
    }

    public Fournisseur teldeux(String teldeux) {
        this.teldeux = teldeux;
        return this;
    }

    public void setTeldeux(String teldeux) {
        this.teldeux = teldeux;
    }

    public String getTeldirigeant() {
        return teldirigeant;
    }

    public Fournisseur teldirigeant(String teldirigeant) {
        this.teldirigeant = teldirigeant;
        return this;
    }

    public void setTeldirigeant(String teldirigeant) {
        this.teldirigeant = teldirigeant;
    }

    public String getTelsecondaire() {
        return telsecondaire;
    }

    public Fournisseur telsecondaire(String telsecondaire) {
        this.telsecondaire = telsecondaire;
        return this;
    }

    public void setTelsecondaire(String telsecondaire) {
        this.telsecondaire = telsecondaire;
    }

    public String getTeltrois() {
        return teltrois;
    }

    public Fournisseur teltrois(String teltrois) {
        this.teltrois = teltrois;
        return this;
    }

    public void setTeltrois(String teltrois) {
        this.teltrois = teltrois;
    }

    public String getTelun() {
        return telun;
    }

    public Fournisseur telun(String telun) {
        this.telun = telun;
        return this;
    }

    public void setTelun(String telun) {
        this.telun = telun;
    }

    public String getVille() {
        return ville;
    }

    public Fournisseur ville(String ville) {
        this.ville = ville;
        return this;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTypedge() {
        return typedge;
    }

    public Fournisseur typedge(String typedge) {
        this.typedge = typedge;
        return this;
    }

    public void setTypedge(String typedge) {
        this.typedge = typedge;
    }

    public String getType() {
        return type;
    }

    public Fournisseur type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUtilisateurLogin() {
        return utilisateurLogin;
    }

    public Fournisseur utilisateurLogin(String utilisateurLogin) {
        this.utilisateurLogin = utilisateurLogin;
        return this;
    }

    public void setUtilisateurLogin(String utilisateurLogin) {
        this.utilisateurLogin = utilisateurLogin;
    }

    public String getFax() {
        return fax;
    }

    public Fournisseur fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public CatFournisseur getCatFournisseur() {
        return catFournisseur;
    }

    public Fournisseur catFournisseur(CatFournisseur catFournisseur) {
        this.catFournisseur = catFournisseur;
        return this;
    }

    public void setCatFournisseur(CatFournisseur catFournisseur) {
        this.catFournisseur = catFournisseur;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fournisseur)) {
            return false;
        }
        return id != null && id.equals(((Fournisseur) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fournisseur{" +
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
            "}";
    }
}
