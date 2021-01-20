package sn.ssi.sigmap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * TABLE APPEL D'OFFRE
 */
@Entity
@Table(name = "taches_effectue")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TachesEffectue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "allotissement")
    private Integer allotissement;

    @Column(name = "garantie")
    private Integer garantie;

    @Column(name = "piece_administrative")
    private Integer pieceAdministrative;

    @Column(name = "critere_qualification")
    private Integer critereQualification;

    @Column(name = "devise")
    private Integer devise;

    @Column(name = "financement")
    private Integer financement;

    @Column(name = "registre_retrait")
    private Integer registreRetrait;

    @Column(name = "registre_depot")
    private Integer registreDepot;

    @Column(name = "lots_soumis")
    private Integer lotsSoumis;

    @Column(name = "commissions_passation")
    private Integer commissionsPassation;

    @Column(name = "representants_soumis")
    private Integer representantsSoumis;

    @Column(name = "services_techniques")
    private Integer servicesTechniques;

    @Column(name = "observateurs")
    private Integer observateurs;

    @Column(name = "garantie_soum")
    private Integer garantieSoum;

    @Column(name = "pieces_soumis")
    private Integer piecesSoumis;

    @Column(name = "lecture_offre")
    private Integer lectureOffre;

    @Column(name = "commission_tecnique")
    private Integer commissionTecnique;

    @Column(name = "document")
    private Integer document;

    @Column(name = "examen_garantie")
    private Integer examenGarantie;

    @Column(name = "examen_exhaustivite")
    private Integer examenExhaustivite;

    @Column(name = "examen_signature_offre")
    private Integer examenSignatureOffre;

    @Column(name = "examen_conformite")
    private Integer examenConformite;

    @Column(name = "verification_critere")
    private Integer verificationCritere;

    @Column(name = "attribution_provisoire")
    private Integer attributionProvisoire;

    @Column(name = "terme_reference")
    private Integer termeReference;

    @Column(name = "depot_candidature")
    private Integer depotCandidature;

    @Column(name = "preselection")
    private Integer preselection;

    @Column(name = "notification")
    private Integer notification;

    @Column(name = "commissions_passation_pi")
    private Integer commissionsPassationPI;

    @Column(name = "representants_soumis_pi")
    private Integer representantsSoumisPI;

    @Column(name = "notes_technique")
    private Integer notesTechnique;

    @Column(name = "offres_financiere")
    private Integer offresFinanciere;

    @Column(name = "prix_evalue")
    private Integer prixEvalue;

    @Column(name = "registre_depot_pi")
    private Integer registreDepotPI;

    @Column(name = "critere_provenance")
    private Integer critereProvenance;

    @Column(name = "proces_verbale")
    private Integer procesVerbale;

    @ManyToOne
    @JsonIgnoreProperties(value = "tachesEffectues", allowSetters = true)
    private DossierAppelOffre dossierAppelOffre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAllotissement() {
        return allotissement;
    }

    public TachesEffectue allotissement(Integer allotissement) {
        this.allotissement = allotissement;
        return this;
    }

    public void setAllotissement(Integer allotissement) {
        this.allotissement = allotissement;
    }

    public Integer getGarantie() {
        return garantie;
    }

    public TachesEffectue garantie(Integer garantie) {
        this.garantie = garantie;
        return this;
    }

    public void setGarantie(Integer garantie) {
        this.garantie = garantie;
    }

    public Integer getPieceAdministrative() {
        return pieceAdministrative;
    }

    public TachesEffectue pieceAdministrative(Integer pieceAdministrative) {
        this.pieceAdministrative = pieceAdministrative;
        return this;
    }

    public void setPieceAdministrative(Integer pieceAdministrative) {
        this.pieceAdministrative = pieceAdministrative;
    }

    public Integer getCritereQualification() {
        return critereQualification;
    }

    public TachesEffectue critereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
        return this;
    }

    public void setCritereQualification(Integer critereQualification) {
        this.critereQualification = critereQualification;
    }

    public Integer getDevise() {
        return devise;
    }

    public TachesEffectue devise(Integer devise) {
        this.devise = devise;
        return this;
    }

    public void setDevise(Integer devise) {
        this.devise = devise;
    }

    public Integer getFinancement() {
        return financement;
    }

    public TachesEffectue financement(Integer financement) {
        this.financement = financement;
        return this;
    }

    public void setFinancement(Integer financement) {
        this.financement = financement;
    }

    public Integer getRegistreRetrait() {
        return registreRetrait;
    }

    public TachesEffectue registreRetrait(Integer registreRetrait) {
        this.registreRetrait = registreRetrait;
        return this;
    }

    public void setRegistreRetrait(Integer registreRetrait) {
        this.registreRetrait = registreRetrait;
    }

    public Integer getRegistreDepot() {
        return registreDepot;
    }

    public TachesEffectue registreDepot(Integer registreDepot) {
        this.registreDepot = registreDepot;
        return this;
    }

    public void setRegistreDepot(Integer registreDepot) {
        this.registreDepot = registreDepot;
    }

    public Integer getLotsSoumis() {
        return lotsSoumis;
    }

    public TachesEffectue lotsSoumis(Integer lotsSoumis) {
        this.lotsSoumis = lotsSoumis;
        return this;
    }

    public void setLotsSoumis(Integer lotsSoumis) {
        this.lotsSoumis = lotsSoumis;
    }

    public Integer getCommissionsPassation() {
        return commissionsPassation;
    }

    public TachesEffectue commissionsPassation(Integer commissionsPassation) {
        this.commissionsPassation = commissionsPassation;
        return this;
    }

    public void setCommissionsPassation(Integer commissionsPassation) {
        this.commissionsPassation = commissionsPassation;
    }

    public Integer getRepresentantsSoumis() {
        return representantsSoumis;
    }

    public TachesEffectue representantsSoumis(Integer representantsSoumis) {
        this.representantsSoumis = representantsSoumis;
        return this;
    }

    public void setRepresentantsSoumis(Integer representantsSoumis) {
        this.representantsSoumis = representantsSoumis;
    }

    public Integer getServicesTechniques() {
        return servicesTechniques;
    }

    public TachesEffectue servicesTechniques(Integer servicesTechniques) {
        this.servicesTechniques = servicesTechniques;
        return this;
    }

    public void setServicesTechniques(Integer servicesTechniques) {
        this.servicesTechniques = servicesTechniques;
    }

    public Integer getObservateurs() {
        return observateurs;
    }

    public TachesEffectue observateurs(Integer observateurs) {
        this.observateurs = observateurs;
        return this;
    }

    public void setObservateurs(Integer observateurs) {
        this.observateurs = observateurs;
    }

    public Integer getGarantieSoum() {
        return garantieSoum;
    }

    public TachesEffectue garantieSoum(Integer garantieSoum) {
        this.garantieSoum = garantieSoum;
        return this;
    }

    public void setGarantieSoum(Integer garantieSoum) {
        this.garantieSoum = garantieSoum;
    }

    public Integer getPiecesSoumis() {
        return piecesSoumis;
    }

    public TachesEffectue piecesSoumis(Integer piecesSoumis) {
        this.piecesSoumis = piecesSoumis;
        return this;
    }

    public void setPiecesSoumis(Integer piecesSoumis) {
        this.piecesSoumis = piecesSoumis;
    }

    public Integer getLectureOffre() {
        return lectureOffre;
    }

    public TachesEffectue lectureOffre(Integer lectureOffre) {
        this.lectureOffre = lectureOffre;
        return this;
    }

    public void setLectureOffre(Integer lectureOffre) {
        this.lectureOffre = lectureOffre;
    }

    public Integer getCommissionTecnique() {
        return commissionTecnique;
    }

    public TachesEffectue commissionTecnique(Integer commissionTecnique) {
        this.commissionTecnique = commissionTecnique;
        return this;
    }

    public void setCommissionTecnique(Integer commissionTecnique) {
        this.commissionTecnique = commissionTecnique;
    }

    public Integer getDocument() {
        return document;
    }

    public TachesEffectue document(Integer document) {
        this.document = document;
        return this;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getExamenGarantie() {
        return examenGarantie;
    }

    public TachesEffectue examenGarantie(Integer examenGarantie) {
        this.examenGarantie = examenGarantie;
        return this;
    }

    public void setExamenGarantie(Integer examenGarantie) {
        this.examenGarantie = examenGarantie;
    }

    public Integer getExamenExhaustivite() {
        return examenExhaustivite;
    }

    public TachesEffectue examenExhaustivite(Integer examenExhaustivite) {
        this.examenExhaustivite = examenExhaustivite;
        return this;
    }

    public void setExamenExhaustivite(Integer examenExhaustivite) {
        this.examenExhaustivite = examenExhaustivite;
    }

    public Integer getExamenSignatureOffre() {
        return examenSignatureOffre;
    }

    public TachesEffectue examenSignatureOffre(Integer examenSignatureOffre) {
        this.examenSignatureOffre = examenSignatureOffre;
        return this;
    }

    public void setExamenSignatureOffre(Integer examenSignatureOffre) {
        this.examenSignatureOffre = examenSignatureOffre;
    }

    public Integer getExamenConformite() {
        return examenConformite;
    }

    public TachesEffectue examenConformite(Integer examenConformite) {
        this.examenConformite = examenConformite;
        return this;
    }

    public void setExamenConformite(Integer examenConformite) {
        this.examenConformite = examenConformite;
    }

    public Integer getVerificationCritere() {
        return verificationCritere;
    }

    public TachesEffectue verificationCritere(Integer verificationCritere) {
        this.verificationCritere = verificationCritere;
        return this;
    }

    public void setVerificationCritere(Integer verificationCritere) {
        this.verificationCritere = verificationCritere;
    }

    public Integer getAttributionProvisoire() {
        return attributionProvisoire;
    }

    public TachesEffectue attributionProvisoire(Integer attributionProvisoire) {
        this.attributionProvisoire = attributionProvisoire;
        return this;
    }

    public void setAttributionProvisoire(Integer attributionProvisoire) {
        this.attributionProvisoire = attributionProvisoire;
    }

    public Integer getTermeReference() {
        return termeReference;
    }

    public TachesEffectue termeReference(Integer termeReference) {
        this.termeReference = termeReference;
        return this;
    }

    public void setTermeReference(Integer termeReference) {
        this.termeReference = termeReference;
    }

    public Integer getDepotCandidature() {
        return depotCandidature;
    }

    public TachesEffectue depotCandidature(Integer depotCandidature) {
        this.depotCandidature = depotCandidature;
        return this;
    }

    public void setDepotCandidature(Integer depotCandidature) {
        this.depotCandidature = depotCandidature;
    }

    public Integer getPreselection() {
        return preselection;
    }

    public TachesEffectue preselection(Integer preselection) {
        this.preselection = preselection;
        return this;
    }

    public void setPreselection(Integer preselection) {
        this.preselection = preselection;
    }

    public Integer getNotification() {
        return notification;
    }

    public TachesEffectue notification(Integer notification) {
        this.notification = notification;
        return this;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    public Integer getCommissionsPassationPI() {
        return commissionsPassationPI;
    }

    public TachesEffectue commissionsPassationPI(Integer commissionsPassationPI) {
        this.commissionsPassationPI = commissionsPassationPI;
        return this;
    }

    public void setCommissionsPassationPI(Integer commissionsPassationPI) {
        this.commissionsPassationPI = commissionsPassationPI;
    }

    public Integer getRepresentantsSoumisPI() {
        return representantsSoumisPI;
    }

    public TachesEffectue representantsSoumisPI(Integer representantsSoumisPI) {
        this.representantsSoumisPI = representantsSoumisPI;
        return this;
    }

    public void setRepresentantsSoumisPI(Integer representantsSoumisPI) {
        this.representantsSoumisPI = representantsSoumisPI;
    }

    public Integer getNotesTechnique() {
        return notesTechnique;
    }

    public TachesEffectue notesTechnique(Integer notesTechnique) {
        this.notesTechnique = notesTechnique;
        return this;
    }

    public void setNotesTechnique(Integer notesTechnique) {
        this.notesTechnique = notesTechnique;
    }

    public Integer getOffresFinanciere() {
        return offresFinanciere;
    }

    public TachesEffectue offresFinanciere(Integer offresFinanciere) {
        this.offresFinanciere = offresFinanciere;
        return this;
    }

    public void setOffresFinanciere(Integer offresFinanciere) {
        this.offresFinanciere = offresFinanciere;
    }

    public Integer getPrixEvalue() {
        return prixEvalue;
    }

    public TachesEffectue prixEvalue(Integer prixEvalue) {
        this.prixEvalue = prixEvalue;
        return this;
    }

    public void setPrixEvalue(Integer prixEvalue) {
        this.prixEvalue = prixEvalue;
    }

    public Integer getRegistreDepotPI() {
        return registreDepotPI;
    }

    public TachesEffectue registreDepotPI(Integer registreDepotPI) {
        this.registreDepotPI = registreDepotPI;
        return this;
    }

    public void setRegistreDepotPI(Integer registreDepotPI) {
        this.registreDepotPI = registreDepotPI;
    }

    public Integer getCritereProvenance() {
        return critereProvenance;
    }

    public TachesEffectue critereProvenance(Integer critereProvenance) {
        this.critereProvenance = critereProvenance;
        return this;
    }

    public void setCritereProvenance(Integer critereProvenance) {
        this.critereProvenance = critereProvenance;
    }

    public Integer getProcesVerbale() {
        return procesVerbale;
    }

    public TachesEffectue procesVerbale(Integer procesVerbale) {
        this.procesVerbale = procesVerbale;
        return this;
    }

    public void setProcesVerbale(Integer procesVerbale) {
        this.procesVerbale = procesVerbale;
    }

    public DossierAppelOffre getDossierAppelOffre() {
        return dossierAppelOffre;
    }

    public TachesEffectue dossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
        return this;
    }

    public void setDossierAppelOffre(DossierAppelOffre dossierAppelOffre) {
        this.dossierAppelOffre = dossierAppelOffre;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TachesEffectue)) {
            return false;
        }
        return id != null && id.equals(((TachesEffectue) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TachesEffectue{" +
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
            "}";
    }
}
