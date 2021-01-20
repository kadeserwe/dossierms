package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.PiecesPlisOuverture} entity.
 */
@ApiModel(description = "TABLE Piecesplisouverture")
public class PiecesPlisOuvertureDTO implements Serializable {
    
    private Long id;

    private String etat;

    private String libelle;

    private String etatConforme;


    private Long dossierAppelOffreId;

    private Long plisOuvertureId;

    private Long pieceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEtatConforme() {
        return etatConforme;
    }

    public void setEtatConforme(String etatConforme) {
        this.etatConforme = etatConforme;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    public Long getPlisOuvertureId() {
        return plisOuvertureId;
    }

    public void setPlisOuvertureId(Long plisOuvertureId) {
        this.plisOuvertureId = plisOuvertureId;
    }

    public Long getPieceId() {
        return pieceId;
    }

    public void setPieceId(Long pieceId) {
        this.pieceId = pieceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PiecesPlisOuvertureDTO)) {
            return false;
        }

        return id != null && id.equals(((PiecesPlisOuvertureDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PiecesPlisOuvertureDTO{" +
            "id=" + getId() +
            ", etat='" + getEtat() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", etatConforme='" + getEtatConforme() + "'" +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", pieceId=" + getPieceId() +
            "}";
    }
}
