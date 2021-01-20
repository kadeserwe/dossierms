package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Lot} entity.
 */
@ApiModel(description = "TABLE LOT")
public class LotDTO implements Serializable {
    
    private Long id;

    private String libelle;

    private String numero;

    private String commentaire;

    private BigDecimal montant;

    private BigDecimal montantdao;


    private Long dossierAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getMontantdao() {
        return montantdao;
    }

    public void setMontantdao(BigDecimal montantdao) {
        this.montantdao = montantdao;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LotDTO)) {
            return false;
        }

        return id != null && id.equals(((LotDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LotDTO{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            ", numero='" + getNumero() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            ", montant=" + getMontant() +
            ", montantdao=" + getMontantdao() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            "}";
    }
}
