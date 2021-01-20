package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.Attribution} entity.
 */
@ApiModel(description = "TABLE Attribution")
public class AttributionDTO implements Serializable {
    
    private Long id;

    private String referencePlandePassation;

    private String referenceAvisGeneral;

    private String attributaireProvisoire;

    private String commentaire;

    private String commentaireDefinitif;

    private String nomFichierDef;

    private String attriType;

    private BigDecimal montantMarche;

    private BigDecimal montantdefinitif;

    private Integer moisExecution;

    private Integer semaineExecution;

    private Integer joursExecution;

    private LocalDate datePublicationProvisoire;

    private LocalDate datePublicationDefinitive;

    private LocalDate dateattribution;


    private Long dossierAppelOffreId;

    private Long plisOuvertureId;

    private Long lotId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferencePlandePassation() {
        return referencePlandePassation;
    }

    public void setReferencePlandePassation(String referencePlandePassation) {
        this.referencePlandePassation = referencePlandePassation;
    }

    public String getReferenceAvisGeneral() {
        return referenceAvisGeneral;
    }

    public void setReferenceAvisGeneral(String referenceAvisGeneral) {
        this.referenceAvisGeneral = referenceAvisGeneral;
    }

    public String getAttributaireProvisoire() {
        return attributaireProvisoire;
    }

    public void setAttributaireProvisoire(String attributaireProvisoire) {
        this.attributaireProvisoire = attributaireProvisoire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCommentaireDefinitif() {
        return commentaireDefinitif;
    }

    public void setCommentaireDefinitif(String commentaireDefinitif) {
        this.commentaireDefinitif = commentaireDefinitif;
    }

    public String getNomFichierDef() {
        return nomFichierDef;
    }

    public void setNomFichierDef(String nomFichierDef) {
        this.nomFichierDef = nomFichierDef;
    }

    public String getAttriType() {
        return attriType;
    }

    public void setAttriType(String attriType) {
        this.attriType = attriType;
    }

    public BigDecimal getMontantMarche() {
        return montantMarche;
    }

    public void setMontantMarche(BigDecimal montantMarche) {
        this.montantMarche = montantMarche;
    }

    public BigDecimal getMontantdefinitif() {
        return montantdefinitif;
    }

    public void setMontantdefinitif(BigDecimal montantdefinitif) {
        this.montantdefinitif = montantdefinitif;
    }

    public Integer getMoisExecution() {
        return moisExecution;
    }

    public void setMoisExecution(Integer moisExecution) {
        this.moisExecution = moisExecution;
    }

    public Integer getSemaineExecution() {
        return semaineExecution;
    }

    public void setSemaineExecution(Integer semaineExecution) {
        this.semaineExecution = semaineExecution;
    }

    public Integer getJoursExecution() {
        return joursExecution;
    }

    public void setJoursExecution(Integer joursExecution) {
        this.joursExecution = joursExecution;
    }

    public LocalDate getDatePublicationProvisoire() {
        return datePublicationProvisoire;
    }

    public void setDatePublicationProvisoire(LocalDate datePublicationProvisoire) {
        this.datePublicationProvisoire = datePublicationProvisoire;
    }

    public LocalDate getDatePublicationDefinitive() {
        return datePublicationDefinitive;
    }

    public void setDatePublicationDefinitive(LocalDate datePublicationDefinitive) {
        this.datePublicationDefinitive = datePublicationDefinitive;
    }

    public LocalDate getDateattribution() {
        return dateattribution;
    }

    public void setDateattribution(LocalDate dateattribution) {
        this.dateattribution = dateattribution;
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
        if (!(o instanceof AttributionDTO)) {
            return false;
        }

        return id != null && id.equals(((AttributionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AttributionDTO{" +
            "id=" + getId() +
            ", referencePlandePassation='" + getReferencePlandePassation() + "'" +
            ", referenceAvisGeneral='" + getReferenceAvisGeneral() + "'" +
            ", attributaireProvisoire='" + getAttributaireProvisoire() + "'" +
            ", commentaire='" + getCommentaire() + "'" +
            ", commentaireDefinitif='" + getCommentaireDefinitif() + "'" +
            ", nomFichierDef='" + getNomFichierDef() + "'" +
            ", attriType='" + getAttriType() + "'" +
            ", montantMarche=" + getMontantMarche() +
            ", montantdefinitif=" + getMontantdefinitif() +
            ", moisExecution=" + getMoisExecution() +
            ", semaineExecution=" + getSemaineExecution() +
            ", joursExecution=" + getJoursExecution() +
            ", datePublicationProvisoire='" + getDatePublicationProvisoire() + "'" +
            ", datePublicationDefinitive='" + getDatePublicationDefinitive() + "'" +
            ", dateattribution='" + getDateattribution() + "'" +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            ", plisOuvertureId=" + getPlisOuvertureId() +
            ", lotId=" + getLotId() +
            "}";
    }
}
