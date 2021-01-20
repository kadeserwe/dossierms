package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.AvisAttribution} entity.
 */
@ApiModel(description = "TABLE AvisAttribution")
public class AvisAttributionDTO implements Serializable {
    
    private Long id;

    private String attriObjet;

    private String attriType;

    private String attritexte;

    private String attriRef;

    private String attrifichier;

    private String attriRaisonsocial;

    private LocalDate attriDate;

    private LocalDate attridatepublication;

    private Integer attriPub;

    private Long autiriteId;


    private Long dossierAppelOffreId;

    private Long lotId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttriObjet() {
        return attriObjet;
    }

    public void setAttriObjet(String attriObjet) {
        this.attriObjet = attriObjet;
    }

    public String getAttriType() {
        return attriType;
    }

    public void setAttriType(String attriType) {
        this.attriType = attriType;
    }

    public String getAttritexte() {
        return attritexte;
    }

    public void setAttritexte(String attritexte) {
        this.attritexte = attritexte;
    }

    public String getAttriRef() {
        return attriRef;
    }

    public void setAttriRef(String attriRef) {
        this.attriRef = attriRef;
    }

    public String getAttrifichier() {
        return attrifichier;
    }

    public void setAttrifichier(String attrifichier) {
        this.attrifichier = attrifichier;
    }

    public String getAttriRaisonsocial() {
        return attriRaisonsocial;
    }

    public void setAttriRaisonsocial(String attriRaisonsocial) {
        this.attriRaisonsocial = attriRaisonsocial;
    }

    public LocalDate getAttriDate() {
        return attriDate;
    }

    public void setAttriDate(LocalDate attriDate) {
        this.attriDate = attriDate;
    }

    public LocalDate getAttridatepublication() {
        return attridatepublication;
    }

    public void setAttridatepublication(LocalDate attridatepublication) {
        this.attridatepublication = attridatepublication;
    }

    public Integer getAttriPub() {
        return attriPub;
    }

    public void setAttriPub(Integer attriPub) {
        this.attriPub = attriPub;
    }

    public Long getAutiriteId() {
        return autiriteId;
    }

    public void setAutiriteId(Long autiriteId) {
        this.autiriteId = autiriteId;
    }

    public Long getDossierAppelOffreId() {
        return dossierAppelOffreId;
    }

    public void setDossierAppelOffreId(Long dossierAppelOffreId) {
        this.dossierAppelOffreId = dossierAppelOffreId;
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
        if (!(o instanceof AvisAttributionDTO)) {
            return false;
        }

        return id != null && id.equals(((AvisAttributionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AvisAttributionDTO{" +
            "id=" + getId() +
            ", attriObjet='" + getAttriObjet() + "'" +
            ", attriType='" + getAttriType() + "'" +
            ", attritexte='" + getAttritexte() + "'" +
            ", attriRef='" + getAttriRef() + "'" +
            ", attrifichier='" + getAttrifichier() + "'" +
            ", attriRaisonsocial='" + getAttriRaisonsocial() + "'" +
            ", attriDate='" + getAttriDate() + "'" +
            ", attridatepublication='" + getAttridatepublication() + "'" +
            ", attriPub=" + getAttriPub() +
            ", autiriteId=" + getAutiriteId() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", lotId=" + getLotId() +
            "}";
    }
}
