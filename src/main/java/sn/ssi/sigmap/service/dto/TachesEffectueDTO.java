package sn.ssi.sigmap.service.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

/**
 * A DTO for the {@link sn.ssi.sigmap.domain.TachesEffectue} entity.
 */
@ApiModel(description = "TABLE APPEL D'OFFRE")
public class TachesEffectueDTO implements Serializable {
    
    private Long id;

    private Integer allotissement;

    private Integer garantie;

    private Integer pieceAdministrative;

    private Integer critereQualification;

    private Integer devise;

    private Integer financement;

    private Integer registreRetrait;

    private Integer registreDepot;

    private Integer lotsSoumis;

    private Integer commissionsPassation;

    private Integer representantsSoumis;

    private Integer servicesTechniques;

    private Integer observateurs;

    private Integer garantieSoum;

    private Integer piecesSoumis;

    private Integer lectureOffre;

    private Integer commissionTecnique;

    private Integer document;

    private Integer examenGarantie;

    private Integer examenExhaustivite;

    private Integer examenSignatureOffre;

    private Integer examenConformite;

    private Integer verificationCritere;

    private Integer attributionProvisoire;

    private Integer termeReference;

    private Integer depotCandidature;

    private Integer preselection;

    private Integer notification;

    private Integer commissionsPassationPI;

    private Integer representantsSoumisPI;

    private Integer notesTechnique;

    private Integer offresFinanciere;

    private Integer prixEvalue;

    private Integer registreDepotPI;

    private Integer critereProvenance;

    private Integer procesVerbale;


    private Long dossierAppelOffreId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAllotissement() {
        return allotissement;
    }

    public void setAllotissement(Integer allotissement) {
        this.allotissement = allotissement;
    }

    public Integer getGarantie() {
        return garantie;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    public Integer getPieceAdministrative() {
        return pieceAdministrative;
    }

    public void setPieceAdministrative(Integer pieceAdministrative) {
        this.pieceAdministrative = pieceAdministrative;
    }

    public Integer getCritereQualification() {
        return critereQualification;
    }

    public void setCritereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
    }

    public Integer getDevise() {
        return devise;
    }

    public void setDevise(Integer devise) {
        this.devise = devise;
    }

    public Integer getFinancement() {
        return financement;
    }

    public void setFinancement(Integer financement) {
        this.financement = financement;
    }

    public Integer getRegistreRetrait() {
        return registreRetrait;
    }

    public void setRegistreRetrait(Integer registreRetrait) {
        this.registreRetrait = registreRetrait;
    }

    public Integer getRegistreDepot() {
        return registreDepot;
    }

    public void setRegistreDepot(Integer registreDepot) {
        this.registreDepot = registreDepot;
    }

    public Integer getLotsSoumis() {
        return lotsSoumis;
    }

    public void setLotsSoumis(Integer lotsSoumis) {
        this.lotsSoumis = lotsSoumis;
    }

    public Integer getCommissionsPassation() {
        return commissionsPassation;
    }

    public void setCommissionsPassation(Integer commissionsPassation) {
        this.commissionsPassation = commissionsPassation;
    }

    public Integer getRepresentantsSoumis() {
        return representantsSoumis;
    }

    public void setRepresentantsSoumis(Integer representantsSoumis) {
        this.representantsSoumis = representantsSoumis;
    }

    public Integer getServicesTechniques() {
        return servicesTechniques;
    }

    public void setServicesTechniques(Integer servicesTechniques) {
        this.servicesTechniques = servicesTechniques;
    }

    public Integer getObservateurs() {
        return observateurs;
    }

    public void setObservateurs(Integer observateurs) {
        this.observateurs = observateurs;
    }

    public Integer getGarantieSoum() {
        return garantieSoum;
    }

    public void setGarantieSoum(Integer garantieSoum) {
        this.garantieSoum = garantieSoum;
    }

    public Integer getPiecesSoumis() {
        return piecesSoumis;
    }

    public void setPiecesSoumis(Integer piecesSoumis) {
        this.piecesSoumis = piecesSoumis;
    }

    public Integer getLectureOffre() {
        return lectureOffre;
    }

    public void setLectureOffre(Integer lectureOffre) {
        this.lectureOffre = lectureOffre;
    }

    public Integer getCommissionTecnique() {
        return commissionTecnique;
    }

    public void setCommissionTecnique(Integer commissionTecnique) {
        this.commissionTecnique = commissionTecnique;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getExamenGarantie() {
        return examenGarantie;
    }

    public void setExamenGarantie(Integer examenGarantie) {
        this.examenGarantie = examenGarantie;
    }

    public Integer getExamenExhaustivite() {
        return examenExhaustivite;
    }

    public void setExamenExhaustivite(Integer examenExhaustivite) {
        this.examenExhaustivite = examenExhaustivite;
    }

    public Integer getExamenSignatureOffre() {
        return examenSignatureOffre;
    }

    public void setExamenSignatureOffre(Integer examenSignatureOffre) {
        this.examenSignatureOffre = examenSignatureOffre;
    }

    public Integer getExamenConformite() {
        return examenConformite;
    }

    public void setExamenConformite(Integer examenConformite) {
        this.examenConformite = examenConformite;
    }

    public Integer getVerificationCritere() {
        return verificationCritere;
    }

    public void setVerificationCritere(Integer verificationCritere) {
        this.verificationCritere = verificationCritere;
    }

    public Integer getAttributionProvisoire() {
        return attributionProvisoire;
    }

    public void setAttributionProvisoire(Integer attributionProvisoire) {
        this.attributionProvisoire = attributionProvisoire;
    }

    public Integer getTermeReference() {
        return termeReference;
    }

    public void setTermeReference(Integer termeReference) {
        this.termeReference = termeReference;
    }

    public Integer getDepotCandidature() {
        return depotCandidature;
    }

    public void setDepotCandidature(Integer depotCandidature) {
        this.depotCandidature = depotCandidature;
    }

    public Integer getPreselection() {
        return preselection;
    }

    public void setPreselection(Integer preselection) {
        this.preselection = preselection;
    }

    public Integer getNotification() {
        return notification;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    public Integer getCommissionsPassationPI() {
        return commissionsPassationPI;
    }

    public void setCommissionsPassationPI(Integer commissionsPassationPI) {
        this.commissionsPassationPI = commissionsPassationPI;
    }

    public Integer getRepresentantsSoumisPI() {
        return representantsSoumisPI;
    }

    public void setRepresentantsSoumisPI(Integer representantsSoumisPI) {
        this.representantsSoumisPI = representantsSoumisPI;
    }

    public Integer getNotesTechnique() {
        return notesTechnique;
    }

    public void setNotesTechnique(Integer notesTechnique) {
        this.notesTechnique = notesTechnique;
    }

    public Integer getOffresFinanciere() {
        return offresFinanciere;
    }

    public void setOffresFinanciere(Integer offresFinanciere) {
        this.offresFinanciere = offresFinanciere;
    }

    public Integer getPrixEvalue() {
        return prixEvalue;
    }

    public void setPrixEvalue(Integer prixEvalue) {
        this.prixEvalue = prixEvalue;
    }

    public Integer getRegistreDepotPI() {
        return registreDepotPI;
    }

    public void setRegistreDepotPI(Integer registreDepotPI) {
        this.registreDepotPI = registreDepotPI;
    }

    public Integer getCritereProvenance() {
        return critereProvenance;
    }

    public void setCritereProvenance(Integer critereProvenance) {
        this.critereProvenance = critereProvenance;
    }

    public Integer getProcesVerbale() {
        return procesVerbale;
    }

    public void setProcesVerbale(Integer procesVerbale) {
        this.procesVerbale = procesVerbale;
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
        if (!(o instanceof TachesEffectueDTO)) {
            return false;
        }

        return id != null && id.equals(((TachesEffectueDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TachesEffectueDTO{" +
            "id=" + getId() +
            ", allotissement=" + getAllotissement() +
            ", garantie=" + getGarantie() +
            ", pieceAdministrative=" + getPieceAdministrative() +
            ", critereQualification=" + getCritereQualification() +
            ", devise=" + getDevise() +
            ", financement=" + getFinancement() +
            ", registreRetrait=" + getRegistreRetrait() +
            ", registreDepot=" + getRegistreDepot() +
            ", lotsSoumis=" + getLotsSoumis() +
            ", commissionsPassation=" + getCommissionsPassation() +
            ", representantsSoumis=" + getRepresentantsSoumis() +
            ", servicesTechniques=" + getServicesTechniques() +
            ", observateurs=" + getObservateurs() +
            ", garantieSoum=" + getGarantieSoum() +
            ", piecesSoumis=" + getPiecesSoumis() +
            ", lectureOffre=" + getLectureOffre() +
            ", commissionTecnique=" + getCommissionTecnique() +
            ", document=" + getDocument() +
            ", examenGarantie=" + getExamenGarantie() +
            ", examenExhaustivite=" + getExamenExhaustivite() +
            ", examenSignatureOffre=" + getExamenSignatureOffre() +
            ", examenConformite=" + getExamenConformite() +
            ", verificationCritere=" + getVerificationCritere() +
            ", attributionProvisoire=" + getAttributionProvisoire() +
            ", termeReference=" + getTermeReference() +
            ", depotCandidature=" + getDepotCandidature() +
            ", preselection=" + getPreselection() +
            ", notification=" + getNotification() +
            ", commissionsPassationPI=" + getCommissionsPassationPI() +
            ", representantsSoumisPI=" + getRepresentantsSoumisPI() +
            ", notesTechnique=" + getNotesTechnique() +
            ", offresFinanciere=" + getOffresFinanciere() +
            ", prixEvalue=" + getPrixEvalue() +
            ", registreDepotPI=" + getRegistreDepotPI() +
            ", critereProvenance=" + getCritereProvenance() +
            ", procesVerbale=" + getProcesVerbale() +
            ", dossierAppelOffreId=" + getDossierAppelOffreId() +
            "}";
    }
}
