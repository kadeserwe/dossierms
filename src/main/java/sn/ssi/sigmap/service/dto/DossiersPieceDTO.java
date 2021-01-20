package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.DossiersPiece} entity.
 */
@ApiModel(description = "TABLE Dossierspiece")
public class DossiersPieceDTO implements Serializable {
    
    private Long id;


    private Long dossierAppelOffreId;

    private Long pieceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
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
        if (!(o instanceof DossiersPieceDTO)) {
            return false;
        }

        return id != null && id.equals(((DossiersPieceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DossiersPieceDTO{" +
            "id=" + getId() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", pieceId=" + getPieceId() +
            "}";
    }
}
