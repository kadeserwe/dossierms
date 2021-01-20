package sn.ssi.sigmap.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Document} entity.
 */
public class DocumentDTO implements Serializable {
    
    private Long id;

    private String typeDocument;

    private String textPVOuverture;

    private String nomFichier;

    private String libelle;

    private String reference;

    private String objet;

    private String origine;

    private String lieuAcquisitionDAO;

    private String fichierDemandePublication;

    private String fichierDC;

    private String fichierAR;

    private LocalDate date;

    private LocalDate heure;

    private LocalDate dateDemandePublication;

    private LocalDate dateLimiteDepot;

    private LocalDate heureLimiteDepot;

    private LocalDate dateOuvertueDesplis;

    private LocalDate heureOuvertureDesPlis;

    @NotNull
    private Long autoriteId;


    private Long dossierAppelOffreId;

    private Long appelOffreId;

    private Long plisOuvertureId;

    private Long lotId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getTextPVOuverture() {
        return textPVOuverture;
    }

    public void setTextPVOuverture(String textPVOuverture) {
        this.textPVOuverture = textPVOuverture;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getLieuAcquisitionDAO() {
        return lieuAcquisitionDAO;
    }

    public void setLieuAcquisitionDAO(String lieuAcquisitionDAO) {
        this.lieuAcquisitionDAO = lieuAcquisitionDAO;
    }

    public String getFichierDemandePublication() {
        return fichierDemandePublication;
    }

    public void setFichierDemandePublication(String fichierDemandePublication) {
        this.fichierDemandePublication = fichierDemandePublication;
    }

    public String getFichierDC() {
        return fichierDC;
    }

    public void setFichierDC(String fichierDC) {
        this.fichierDC = fichierDC;
    }

    public String getFichierAR() {
        return fichierAR;
    }

    public void setFichierAR(String fichierAR) {
        this.fichierAR = fichierAR;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getHeure() {
        return heure;
    }

    public void setHeure(LocalDate heure) {
        this.heure = heure;
    }

    public LocalDate getDateDemandePublication() {
        return dateDemandePublication;
    }

    public void setDateDemandePublication(LocalDate dateDemandePublication) {
        this.dateDemandePublication = dateDemandePublication;
    }

    public LocalDate getDateLimiteDepot() {
        return dateLimiteDepot;
    }

    public void setDateLimiteDepot(LocalDate dateLimiteDepot) {
        this.dateLimiteDepot = dateLimiteDepot;
    }

    public LocalDate getHeureLimiteDepot() {
        return heureLimiteDepot;
    }

    public void setHeureLimiteDepot(LocalDate heureLimiteDepot) {
        this.heureLimiteDepot = heureLimiteDepot;
    }

    public LocalDate getDateOuvertueDesplis() {
        return dateOuvertueDesplis;
    }

    public void setDateOuvertueDesplis(LocalDate dateOuvertueDesplis) {
        this.dateOuvertueDesplis = dateOuvertueDesplis;
    }

    public LocalDate getHeureOuvertureDesPlis() {
        return heureOuvertureDesPlis;
    }

    public void setHeureOuvertureDesPlis(LocalDate heureOuvertureDesPlis) {
        this.heureOuvertureDesPlis = heureOuvertureDesPlis;
    }

    public Long getAutoriteId() {
        return autoriteId;
    }

    public void setAutoriteId(Long autoriteId) {
        this.autoriteId = autoriteId;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getAppelOffreId() {
        return appelOffreId;
    }

    public void setAppelOffreId(Long appelOffreId) {
        this.appelOffreId = appelOffreId;
    }

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DocumentDTO)) {
            return false;
        }

        return id != null && id.equals(((DocumentDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DocumentDTO{" +
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
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", appelOffreId=" + getAppelOffreId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", lotId=" + getLotId() +
            "}";
    }
}
