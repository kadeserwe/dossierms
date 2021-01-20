package sn.ssi.sigmap.web.rest;

import sn.ssi.sigmap.DossiermsApp;
import sn.ssi.sigmap.domain.Contrat;
import sn.ssi.sigmap.repository.ContratRepository;
import sn.ssi.sigmap.service.ContratService;
import sn.ssi.sigmap.service.dto.ContratDTO;
import sn.ssi.sigmap.service.mapper.ContratMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ContratResource} REST controller.
 */
@SpringBootTest(classes = DossiermsApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class ContratResourceIT {

    private static final BigDecimal DEFAULT_MONTANT = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MONTANT_VERSE = new BigDecimal(1);
    private static final BigDecimal UPDATED_MONTANT_VERSE = new BigDecimal(2);

    private static final LocalDate DEFAULT_CON_DATE_SIGNATURE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_SIGNATURE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_APPROBATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_APPROBATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_NOTIFICATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_NOTIFICATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_RECEP_PROVISOIRE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_RECEP_PROVISOIRE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_RECEP_DEFINITIVE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_RECEP_DEFINITIVE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_ORDRE_DEMARRAGE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_ORDRE_DEMARRAGE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CONDATE_ATTRIBUTION_PROVISOIRE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CONDATE_ATTRIBUTION_PROVISOIRE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CONDATE_ATTRIBUTION_DEFINITIVE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CONDATE_ATTRIBUTION_DEFINITIVE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_PAIEMENT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_PAIEMENT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_DEMANDE_IMMATRICULATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEMANDE_IMMATRICULATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_IMMATRICULATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_IMMATRICULATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_PUB = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_PUB = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATE_DEMANDE_PUB_CONTRAT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_DEMANDE_PUB_CONTRAT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_CON_DATE_CREATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CON_DATE_CREATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_DEMANDE_AUTORISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_DEMANDE_AUTORISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATEAUTORISATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATEAUTORISATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_EXAMEN_JURIDIQUE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_EXAMEN_JURIDIQUE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_DEMANDE_APPROBATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_DEMANDE_APPROBATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_APPROBATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_APPROBATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_REJET = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_REJET = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_RENOUVCONT_DATE_RETOUR_APPROBATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RENOUVCONT_DATE_RETOUR_APPROBATION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_CON_COMMENT_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_SIGNATURE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_REF_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_CON_REF_SIGNATURE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_APPROBATION = "BBBBBBBBBB";

    private static final String DEFAULT_CON_REF_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_CON_REF_APPROBATION = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_NOTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_NOTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_CON_REF_NOTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_CON_REF_NOTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_CON_FICHIER_RECEP_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CON_FICHIER_RECEP_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_RECEP_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_RECEP_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_FICHIER_RECEP_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_CON_FICHIER_RECEP_DEFINITIVE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_RECEP_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_RECEP_DEFINITIVE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_FICHIER_ORDRE_DEMARRAGE = "AAAAAAAAAA";
    private static final String UPDATED_CON_FICHIER_ORDRE_DEMARRAGE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_ORDRE_DEMARRAGE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_ORDRE_DEMARRAGE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_REF_ATTRIBUTION_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CON_REF_ATTRIBUTION_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_REF_ATTRIBUTION_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_CON_REF_ATTRIBUTION_DEFINITIVE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE = "BBBBBBBBBB";

    private static final String DEFAULT_CON_STATUT = "AAAAAAAAAA";
    private static final String UPDATED_CON_STATUT = "BBBBBBBBBB";

    private static final String DEFAULT_NUM_MATRICULATION = "AAAAAAAAAA";
    private static final String UPDATED_NUM_MATRICULATION = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENTAIRE_DMDMAT = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENTAIRE_DMDMAT = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENTAIRE_MATRICULATION = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENTAIRE_MATRICULATION = "BBBBBBBBBB";

    private static final String DEFAULT_CONC_SITUATION = "AAAAAAAAAA";
    private static final String UPDATED_CONC_SITUATION = "BBBBBBBBBB";

    private static final String DEFAULT_NATIONNALITE = "AAAAAAAAAA";
    private static final String UPDATED_NATIONNALITE = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_IMMATRICULE = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_IMMATRICULE = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_JUSTIFICATIF = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_JUSTIFICATIF = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENTAIRE_PUB = "AAAAAAAAAA";
    private static final String UPDATED_COMMENTAIRE_PUB = "BBBBBBBBBB";

    private static final String DEFAULT_FICHIER_CONTRAT = "AAAAAAAAAA";
    private static final String UPDATED_FICHIER_CONTRAT = "BBBBBBBBBB";

    private static final String DEFAULT_CON_COMMENT_DEMANDE_PUB = "AAAAAAAAAA";
    private static final String UPDATED_CON_COMMENT_DEMANDE_PUB = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_CONTRAT_SIGNE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_CONTRAT_SIGNE = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_PAGE_GARDE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_PAGE_GARDE = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_PAGE_SIGNATURE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_PAGE_SIGNATURE = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_FICHIER_PROJET_CONTRAT = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_FICHIER_PROJET_CONTRAT = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_COMMENT_AUTORISATION = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_COMMENT_AUTORISATION = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_COMMENT_DEMANDE_APPROBATION = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_COMMENT_DEMANDE_APPROBATION = "BBBBBBBBBB";

    private static final String DEFAULT_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE = "AAAAAAAAAA";
    private static final String UPDATED_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE = "BBBBBBBBBB";

    private static final Long DEFAULT_AUTORITE_ID = 1L;
    private static final Long UPDATED_AUTORITE_ID = 2L;

    private static final Long DEFAULT_SERVICE_ID = 1L;
    private static final Long UPDATED_SERVICE_ID = 2L;

    private static final Long DEFAULT_MODE_PASSATION_ID = 1L;
    private static final Long UPDATED_MODE_PASSATION_ID = 2L;

    private static final Long DEFAULT_TYPE_MARCHE_ID = 1L;
    private static final Long UPDATED_TYPE_MARCHE_ID = 2L;

    private static final Integer DEFAULT_IMMATRICULATION = 1;
    private static final Integer UPDATED_IMMATRICULATION = 2;

    private static final Integer DEFAULT_DELAI = 1;
    private static final Integer UPDATED_DELAI = 2;

    private static final Boolean DEFAULT_RENOUVCONT_IMMAT_STATUT = false;
    private static final Boolean UPDATED_RENOUVCONT_IMMAT_STATUT = true;

    private static final Boolean DEFAULT_RENOUVCONT_PUB_STATUT = false;
    private static final Boolean UPDATED_RENOUVCONT_PUB_STATUT = true;

    private static final Integer DEFAULT_RENOUVCONT_AUTORISATION_STATUT = 1;
    private static final Integer UPDATED_RENOUVCONT_AUTORISATION_STATUT = 2;

    private static final Integer DEFAULT_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT = 1;
    private static final Integer UPDATED_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT = 2;

    private static final Integer DEFAULT_RENOUVCONT_APPROBATION_STATUT = 1;
    private static final Integer UPDATED_RENOUVCONT_APPROBATION_STATUT = 2;

    private static final String DEFAULT_ETAT_CONTRATDEBASE = "AAAAAAAAAA";
    private static final String UPDATED_ETAT_CONTRATDEBASE = "BBBBBBBBBB";

    private static final String DEFAULT_LIBELLE_LOT = "AAAAAAAAAA";
    private static final String UPDATED_LIBELLE_LOT = "BBBBBBBBBB";

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private ContratMapper contratMapper;

    @Autowired
    private ContratService contratService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restContratMockMvc;

    private Contrat contrat;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Contrat createEntity(EntityManager em) {
        Contrat contrat = new Contrat()
            .montant(DEFAULT_MONTANT)
            .montantVerse(DEFAULT_MONTANT_VERSE)
            .conDateSignature(DEFAULT_CON_DATE_SIGNATURE)
            .conDateApprobation(DEFAULT_CON_DATE_APPROBATION)
            .conDateNotification(DEFAULT_CON_DATE_NOTIFICATION)
            .conDateRecepProvisoire(DEFAULT_CON_DATE_RECEP_PROVISOIRE)
            .conDateRecepDefinitive(DEFAULT_CON_DATE_RECEP_DEFINITIVE)
            .conDateOrdreDemarrage(DEFAULT_CON_DATE_ORDRE_DEMARRAGE)
            .condateAttributionProvisoire(DEFAULT_CONDATE_ATTRIBUTION_PROVISOIRE)
            .condateAttributionDefinitive(DEFAULT_CONDATE_ATTRIBUTION_DEFINITIVE)
            .conDatePaiement(DEFAULT_CON_DATE_PAIEMENT)
            .dateDemandeImmatriculation(DEFAULT_DATE_DEMANDE_IMMATRICULATION)
            .dateImmatriculation(DEFAULT_DATE_IMMATRICULATION)
            .datePub(DEFAULT_DATE_PUB)
            .dateDemandePubContrat(DEFAULT_DATE_DEMANDE_PUB_CONTRAT)
            .conDateCreation(DEFAULT_CON_DATE_CREATION)
            .renouvcontDateDemandeAutorisation(DEFAULT_RENOUVCONT_DATE_DEMANDE_AUTORISATION)
            .renouvcontDateautorisation(DEFAULT_RENOUVCONT_DATEAUTORISATION)
            .renouvcontDateDemandeExamenJuridique(DEFAULT_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE)
            .renouvcontDateExamenJuridique(DEFAULT_RENOUVCONT_DATE_EXAMEN_JURIDIQUE)
            .renouvcontDateDemandeApprobation(DEFAULT_RENOUVCONT_DATE_DEMANDE_APPROBATION)
            .renouvcontDateApprobation(DEFAULT_RENOUVCONT_DATE_APPROBATION)
            .renouvcontDateRejet(DEFAULT_RENOUVCONT_DATE_REJET)
            .renouvcontDateRetourApprobation(DEFAULT_RENOUVCONT_DATE_RETOUR_APPROBATION)
            .conCommentSignature(DEFAULT_CON_COMMENT_SIGNATURE)
            .conRefSignature(DEFAULT_CON_REF_SIGNATURE)
            .conCommentApprobation(DEFAULT_CON_COMMENT_APPROBATION)
            .conRefApprobation(DEFAULT_CON_REF_APPROBATION)
            .conCommentNotification(DEFAULT_CON_COMMENT_NOTIFICATION)
            .conRefNotification(DEFAULT_CON_REF_NOTIFICATION)
            .conFichierRecepProvisoire(DEFAULT_CON_FICHIER_RECEP_PROVISOIRE)
            .conCommentRecepProvisoire(DEFAULT_CON_COMMENT_RECEP_PROVISOIRE)
            .conFichierRecepDefinitive(DEFAULT_CON_FICHIER_RECEP_DEFINITIVE)
            .conCommentRecepDefinitive(DEFAULT_CON_COMMENT_RECEP_DEFINITIVE)
            .conFichierOrdreDemarrage(DEFAULT_CON_FICHIER_ORDRE_DEMARRAGE)
            .conCommentOrdreDemarrage(DEFAULT_CON_COMMENT_ORDRE_DEMARRAGE)
            .conRefAttributionProvisoire(DEFAULT_CON_REF_ATTRIBUTION_PROVISOIRE)
            .conCommentaireAttributionProvisoire(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE)
            .conRefAttributionDefinitive(DEFAULT_CON_REF_ATTRIBUTION_DEFINITIVE)
            .conCommentaireAttributionDefinitive(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE)
            .conStatut(DEFAULT_CON_STATUT)
            .numMatriculation(DEFAULT_NUM_MATRICULATION)
            .conCommentaireDmdmat(DEFAULT_CON_COMMENTAIRE_DMDMAT)
            .conCommentaireMatriculation(DEFAULT_CON_COMMENTAIRE_MATRICULATION)
            .concSituation(DEFAULT_CONC_SITUATION)
            .nationnalite(DEFAULT_NATIONNALITE)
            .fichierImmatricule(DEFAULT_FICHIER_IMMATRICULE)
            .fichierJustificatif(DEFAULT_FICHIER_JUSTIFICATIF)
            .commentairePub(DEFAULT_COMMENTAIRE_PUB)
            .fichierContrat(DEFAULT_FICHIER_CONTRAT)
            .conCommentDemandePub(DEFAULT_CON_COMMENT_DEMANDE_PUB)
            .renouvcontFichierAutorisationPrealable(DEFAULT_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE)
            .renouvcontFichierExamenJuridique(DEFAULT_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE)
            .renouvcontFichierContratSigne(DEFAULT_RENOUVCONT_FICHIER_CONTRAT_SIGNE)
            .renouvcontFichierPageGarde(DEFAULT_RENOUVCONT_FICHIER_PAGE_GARDE)
            .renouvcontFichierPageSignature(DEFAULT_RENOUVCONT_FICHIER_PAGE_SIGNATURE)
            .renouvcontFichierRapportMotivation(DEFAULT_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION)
            .renouvcontFichierProjetContrat(DEFAULT_RENOUVCONT_FICHIER_PROJET_CONTRAT)
            .renouvcontCommentAutorisation(DEFAULT_RENOUVCONT_COMMENT_AUTORISATION)
            .renouvcontCommentDemandeApprobation(DEFAULT_RENOUVCONT_COMMENT_DEMANDE_APPROBATION)
            .renouvcontCommentExamenJuridique(DEFAULT_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE)
            .autoriteId(DEFAULT_AUTORITE_ID)
            .serviceId(DEFAULT_SERVICE_ID)
            .modePassationId(DEFAULT_MODE_PASSATION_ID)
            .typeMarcheId(DEFAULT_TYPE_MARCHE_ID)
            .immatriculation(DEFAULT_IMMATRICULATION)
            .delai(DEFAULT_DELAI)
            .renouvcontImmatStatut(DEFAULT_RENOUVCONT_IMMAT_STATUT)
            .renouvcontPubStatut(DEFAULT_RENOUVCONT_PUB_STATUT)
            .renouvcontAutorisationStatut(DEFAULT_RENOUVCONT_AUTORISATION_STATUT)
            .renouvcontExamenJuridiqueStatut(DEFAULT_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT)
            .renouvcontApprobationStatut(DEFAULT_RENOUVCONT_APPROBATION_STATUT)
            .etatContratdebase(DEFAULT_ETAT_CONTRATDEBASE)
            .libelleLot(DEFAULT_LIBELLE_LOT);
        return contrat;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Contrat createUpdatedEntity(EntityManager em) {
        Contrat contrat = new Contrat()
            .montant(UPDATED_MONTANT)
            .montantVerse(UPDATED_MONTANT_VERSE)
            .conDateSignature(UPDATED_CON_DATE_SIGNATURE)
            .conDateApprobation(UPDATED_CON_DATE_APPROBATION)
            .conDateNotification(UPDATED_CON_DATE_NOTIFICATION)
            .conDateRecepProvisoire(UPDATED_CON_DATE_RECEP_PROVISOIRE)
            .conDateRecepDefinitive(UPDATED_CON_DATE_RECEP_DEFINITIVE)
            .conDateOrdreDemarrage(UPDATED_CON_DATE_ORDRE_DEMARRAGE)
            .condateAttributionProvisoire(UPDATED_CONDATE_ATTRIBUTION_PROVISOIRE)
            .condateAttributionDefinitive(UPDATED_CONDATE_ATTRIBUTION_DEFINITIVE)
            .conDatePaiement(UPDATED_CON_DATE_PAIEMENT)
            .dateDemandeImmatriculation(UPDATED_DATE_DEMANDE_IMMATRICULATION)
            .dateImmatriculation(UPDATED_DATE_IMMATRICULATION)
            .datePub(UPDATED_DATE_PUB)
            .dateDemandePubContrat(UPDATED_DATE_DEMANDE_PUB_CONTRAT)
            .conDateCreation(UPDATED_CON_DATE_CREATION)
            .renouvcontDateDemandeAutorisation(UPDATED_RENOUVCONT_DATE_DEMANDE_AUTORISATION)
            .renouvcontDateautorisation(UPDATED_RENOUVCONT_DATEAUTORISATION)
            .renouvcontDateDemandeExamenJuridique(UPDATED_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE)
            .renouvcontDateExamenJuridique(UPDATED_RENOUVCONT_DATE_EXAMEN_JURIDIQUE)
            .renouvcontDateDemandeApprobation(UPDATED_RENOUVCONT_DATE_DEMANDE_APPROBATION)
            .renouvcontDateApprobation(UPDATED_RENOUVCONT_DATE_APPROBATION)
            .renouvcontDateRejet(UPDATED_RENOUVCONT_DATE_REJET)
            .renouvcontDateRetourApprobation(UPDATED_RENOUVCONT_DATE_RETOUR_APPROBATION)
            .conCommentSignature(UPDATED_CON_COMMENT_SIGNATURE)
            .conRefSignature(UPDATED_CON_REF_SIGNATURE)
            .conCommentApprobation(UPDATED_CON_COMMENT_APPROBATION)
            .conRefApprobation(UPDATED_CON_REF_APPROBATION)
            .conCommentNotification(UPDATED_CON_COMMENT_NOTIFICATION)
            .conRefNotification(UPDATED_CON_REF_NOTIFICATION)
            .conFichierRecepProvisoire(UPDATED_CON_FICHIER_RECEP_PROVISOIRE)
            .conCommentRecepProvisoire(UPDATED_CON_COMMENT_RECEP_PROVISOIRE)
            .conFichierRecepDefinitive(UPDATED_CON_FICHIER_RECEP_DEFINITIVE)
            .conCommentRecepDefinitive(UPDATED_CON_COMMENT_RECEP_DEFINITIVE)
            .conFichierOrdreDemarrage(UPDATED_CON_FICHIER_ORDRE_DEMARRAGE)
            .conCommentOrdreDemarrage(UPDATED_CON_COMMENT_ORDRE_DEMARRAGE)
            .conRefAttributionProvisoire(UPDATED_CON_REF_ATTRIBUTION_PROVISOIRE)
            .conCommentaireAttributionProvisoire(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE)
            .conRefAttributionDefinitive(UPDATED_CON_REF_ATTRIBUTION_DEFINITIVE)
            .conCommentaireAttributionDefinitive(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE)
            .conStatut(UPDATED_CON_STATUT)
            .numMatriculation(UPDATED_NUM_MATRICULATION)
            .conCommentaireDmdmat(UPDATED_CON_COMMENTAIRE_DMDMAT)
            .conCommentaireMatriculation(UPDATED_CON_COMMENTAIRE_MATRICULATION)
            .concSituation(UPDATED_CONC_SITUATION)
            .nationnalite(UPDATED_NATIONNALITE)
            .fichierImmatricule(UPDATED_FICHIER_IMMATRICULE)
            .fichierJustificatif(UPDATED_FICHIER_JUSTIFICATIF)
            .commentairePub(UPDATED_COMMENTAIRE_PUB)
            .fichierContrat(UPDATED_FICHIER_CONTRAT)
            .conCommentDemandePub(UPDATED_CON_COMMENT_DEMANDE_PUB)
            .renouvcontFichierAutorisationPrealable(UPDATED_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE)
            .renouvcontFichierExamenJuridique(UPDATED_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE)
            .renouvcontFichierContratSigne(UPDATED_RENOUVCONT_FICHIER_CONTRAT_SIGNE)
            .renouvcontFichierPageGarde(UPDATED_RENOUVCONT_FICHIER_PAGE_GARDE)
            .renouvcontFichierPageSignature(UPDATED_RENOUVCONT_FICHIER_PAGE_SIGNATURE)
            .renouvcontFichierRapportMotivation(UPDATED_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION)
            .renouvcontFichierProjetContrat(UPDATED_RENOUVCONT_FICHIER_PROJET_CONTRAT)
            .renouvcontCommentAutorisation(UPDATED_RENOUVCONT_COMMENT_AUTORISATION)
            .renouvcontCommentDemandeApprobation(UPDATED_RENOUVCONT_COMMENT_DEMANDE_APPROBATION)
            .renouvcontCommentExamenJuridique(UPDATED_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE)
            .autoriteId(UPDATED_AUTORITE_ID)
            .serviceId(UPDATED_SERVICE_ID)
            .modePassationId(UPDATED_MODE_PASSATION_ID)
            .typeMarcheId(UPDATED_TYPE_MARCHE_ID)
            .immatriculation(UPDATED_IMMATRICULATION)
            .delai(UPDATED_DELAI)
            .renouvcontImmatStatut(UPDATED_RENOUVCONT_IMMAT_STATUT)
            .renouvcontPubStatut(UPDATED_RENOUVCONT_PUB_STATUT)
            .renouvcontAutorisationStatut(UPDATED_RENOUVCONT_AUTORISATION_STATUT)
            .renouvcontExamenJuridiqueStatut(UPDATED_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT)
            .renouvcontApprobationStatut(UPDATED_RENOUVCONT_APPROBATION_STATUT)
            .etatContratdebase(UPDATED_ETAT_CONTRATDEBASE)
            .libelleLot(UPDATED_LIBELLE_LOT);
        return contrat;
    }

    @BeforeEach
    public void initTest() {
        contrat = createEntity(em);
    }

    @Test
    @Transactional
    public void createContrat() throws Exception {
        int databaseSizeBeforeCreate = contratRepository.findAll().size();
        // Create the Contrat
        ContratDTO contratDTO = contratMapper.toDto(contrat);
        restContratMockMvc.perform(post("/api/contrats")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(contratDTO)))
            .andExpect(status().isCreated());

        // Validate the Contrat in the database
        List<Contrat> contratList = contratRepository.findAll();
        assertThat(contratList).hasSize(databaseSizeBeforeCreate + 1);
        Contrat testContrat = contratList.get(contratList.size() - 1);
        assertThat(testContrat.getMontant()).isEqualTo(DEFAULT_MONTANT);
        assertThat(testContrat.getMontantVerse()).isEqualTo(DEFAULT_MONTANT_VERSE);
        assertThat(testContrat.getConDateSignature()).isEqualTo(DEFAULT_CON_DATE_SIGNATURE);
        assertThat(testContrat.getConDateApprobation()).isEqualTo(DEFAULT_CON_DATE_APPROBATION);
        assertThat(testContrat.getConDateNotification()).isEqualTo(DEFAULT_CON_DATE_NOTIFICATION);
        assertThat(testContrat.getConDateRecepProvisoire()).isEqualTo(DEFAULT_CON_DATE_RECEP_PROVISOIRE);
        assertThat(testContrat.getConDateRecepDefinitive()).isEqualTo(DEFAULT_CON_DATE_RECEP_DEFINITIVE);
        assertThat(testContrat.getConDateOrdreDemarrage()).isEqualTo(DEFAULT_CON_DATE_ORDRE_DEMARRAGE);
        assertThat(testContrat.getCondateAttributionProvisoire()).isEqualTo(DEFAULT_CONDATE_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getCondateAttributionDefinitive()).isEqualTo(DEFAULT_CONDATE_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConDatePaiement()).isEqualTo(DEFAULT_CON_DATE_PAIEMENT);
        assertThat(testContrat.getDateDemandeImmatriculation()).isEqualTo(DEFAULT_DATE_DEMANDE_IMMATRICULATION);
        assertThat(testContrat.getDateImmatriculation()).isEqualTo(DEFAULT_DATE_IMMATRICULATION);
        assertThat(testContrat.getDatePub()).isEqualTo(DEFAULT_DATE_PUB);
        assertThat(testContrat.getDateDemandePubContrat()).isEqualTo(DEFAULT_DATE_DEMANDE_PUB_CONTRAT);
        assertThat(testContrat.getConDateCreation()).isEqualTo(DEFAULT_CON_DATE_CREATION);
        assertThat(testContrat.getRenouvcontDateDemandeAutorisation()).isEqualTo(DEFAULT_RENOUVCONT_DATE_DEMANDE_AUTORISATION);
        assertThat(testContrat.getRenouvcontDateautorisation()).isEqualTo(DEFAULT_RENOUVCONT_DATEAUTORISATION);
        assertThat(testContrat.getRenouvcontDateDemandeExamenJuridique()).isEqualTo(DEFAULT_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontDateExamenJuridique()).isEqualTo(DEFAULT_RENOUVCONT_DATE_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontDateDemandeApprobation()).isEqualTo(DEFAULT_RENOUVCONT_DATE_DEMANDE_APPROBATION);
        assertThat(testContrat.getRenouvcontDateApprobation()).isEqualTo(DEFAULT_RENOUVCONT_DATE_APPROBATION);
        assertThat(testContrat.getRenouvcontDateRejet()).isEqualTo(DEFAULT_RENOUVCONT_DATE_REJET);
        assertThat(testContrat.getRenouvcontDateRetourApprobation()).isEqualTo(DEFAULT_RENOUVCONT_DATE_RETOUR_APPROBATION);
        assertThat(testContrat.getConCommentSignature()).isEqualTo(DEFAULT_CON_COMMENT_SIGNATURE);
        assertThat(testContrat.getConRefSignature()).isEqualTo(DEFAULT_CON_REF_SIGNATURE);
        assertThat(testContrat.getConCommentApprobation()).isEqualTo(DEFAULT_CON_COMMENT_APPROBATION);
        assertThat(testContrat.getConRefApprobation()).isEqualTo(DEFAULT_CON_REF_APPROBATION);
        assertThat(testContrat.getConCommentNotification()).isEqualTo(DEFAULT_CON_COMMENT_NOTIFICATION);
        assertThat(testContrat.getConRefNotification()).isEqualTo(DEFAULT_CON_REF_NOTIFICATION);
        assertThat(testContrat.getConFichierRecepProvisoire()).isEqualTo(DEFAULT_CON_FICHIER_RECEP_PROVISOIRE);
        assertThat(testContrat.getConCommentRecepProvisoire()).isEqualTo(DEFAULT_CON_COMMENT_RECEP_PROVISOIRE);
        assertThat(testContrat.getConFichierRecepDefinitive()).isEqualTo(DEFAULT_CON_FICHIER_RECEP_DEFINITIVE);
        assertThat(testContrat.getConCommentRecepDefinitive()).isEqualTo(DEFAULT_CON_COMMENT_RECEP_DEFINITIVE);
        assertThat(testContrat.getConFichierOrdreDemarrage()).isEqualTo(DEFAULT_CON_FICHIER_ORDRE_DEMARRAGE);
        assertThat(testContrat.getConCommentOrdreDemarrage()).isEqualTo(DEFAULT_CON_COMMENT_ORDRE_DEMARRAGE);
        assertThat(testContrat.getConRefAttributionProvisoire()).isEqualTo(DEFAULT_CON_REF_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getConCommentaireAttributionProvisoire()).isEqualTo(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getConRefAttributionDefinitive()).isEqualTo(DEFAULT_CON_REF_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConCommentaireAttributionDefinitive()).isEqualTo(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConStatut()).isEqualTo(DEFAULT_CON_STATUT);
        assertThat(testContrat.getNumMatriculation()).isEqualTo(DEFAULT_NUM_MATRICULATION);
        assertThat(testContrat.getConCommentaireDmdmat()).isEqualTo(DEFAULT_CON_COMMENTAIRE_DMDMAT);
        assertThat(testContrat.getConCommentaireMatriculation()).isEqualTo(DEFAULT_CON_COMMENTAIRE_MATRICULATION);
        assertThat(testContrat.getConcSituation()).isEqualTo(DEFAULT_CONC_SITUATION);
        assertThat(testContrat.getNationnalite()).isEqualTo(DEFAULT_NATIONNALITE);
        assertThat(testContrat.getFichierImmatricule()).isEqualTo(DEFAULT_FICHIER_IMMATRICULE);
        assertThat(testContrat.getFichierJustificatif()).isEqualTo(DEFAULT_FICHIER_JUSTIFICATIF);
        assertThat(testContrat.getCommentairePub()).isEqualTo(DEFAULT_COMMENTAIRE_PUB);
        assertThat(testContrat.getFichierContrat()).isEqualTo(DEFAULT_FICHIER_CONTRAT);
        assertThat(testContrat.getConCommentDemandePub()).isEqualTo(DEFAULT_CON_COMMENT_DEMANDE_PUB);
        assertThat(testContrat.getRenouvcontFichierAutorisationPrealable()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE);
        assertThat(testContrat.getRenouvcontFichierExamenJuridique()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontFichierContratSigne()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_CONTRAT_SIGNE);
        assertThat(testContrat.getRenouvcontFichierPageGarde()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_PAGE_GARDE);
        assertThat(testContrat.getRenouvcontFichierPageSignature()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_PAGE_SIGNATURE);
        assertThat(testContrat.getRenouvcontFichierRapportMotivation()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION);
        assertThat(testContrat.getRenouvcontFichierProjetContrat()).isEqualTo(DEFAULT_RENOUVCONT_FICHIER_PROJET_CONTRAT);
        assertThat(testContrat.getRenouvcontCommentAutorisation()).isEqualTo(DEFAULT_RENOUVCONT_COMMENT_AUTORISATION);
        assertThat(testContrat.getRenouvcontCommentDemandeApprobation()).isEqualTo(DEFAULT_RENOUVCONT_COMMENT_DEMANDE_APPROBATION);
        assertThat(testContrat.getRenouvcontCommentExamenJuridique()).isEqualTo(DEFAULT_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getAutoriteId()).isEqualTo(DEFAULT_AUTORITE_ID);
        assertThat(testContrat.getServiceId()).isEqualTo(DEFAULT_SERVICE_ID);
        assertThat(testContrat.getModePassationId()).isEqualTo(DEFAULT_MODE_PASSATION_ID);
        assertThat(testContrat.getTypeMarcheId()).isEqualTo(DEFAULT_TYPE_MARCHE_ID);
        assertThat(testContrat.getImmatriculation()).isEqualTo(DEFAULT_IMMATRICULATION);
        assertThat(testContrat.getDelai()).isEqualTo(DEFAULT_DELAI);
        assertThat(testContrat.isRenouvcontImmatStatut()).isEqualTo(DEFAULT_RENOUVCONT_IMMAT_STATUT);
        assertThat(testContrat.isRenouvcontPubStatut()).isEqualTo(DEFAULT_RENOUVCONT_PUB_STATUT);
        assertThat(testContrat.getRenouvcontAutorisationStatut()).isEqualTo(DEFAULT_RENOUVCONT_AUTORISATION_STATUT);
        assertThat(testContrat.getRenouvcontExamenJuridiqueStatut()).isEqualTo(DEFAULT_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT);
        assertThat(testContrat.getRenouvcontApprobationStatut()).isEqualTo(DEFAULT_RENOUVCONT_APPROBATION_STATUT);
        assertThat(testContrat.getEtatContratdebase()).isEqualTo(DEFAULT_ETAT_CONTRATDEBASE);
        assertThat(testContrat.getLibelleLot()).isEqualTo(DEFAULT_LIBELLE_LOT);
    }

    @Test
    @Transactional
    public void createContratWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = contratRepository.findAll().size();

        // Create the Contrat with an existing ID
        contrat.setId(1L);
        ContratDTO contratDTO = contratMapper.toDto(contrat);

        // An entity with an existing ID cannot be created, so this API call must fail
        restContratMockMvc.perform(post("/api/contrats")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(contratDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Contrat in the database
        List<Contrat> contratList = contratRepository.findAll();
        assertThat(contratList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllContrats() throws Exception {
        // Initialize the database
        contratRepository.saveAndFlush(contrat);

        // Get all the contratList
        restContratMockMvc.perform(get("/api/contrats?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(contrat.getId().intValue())))
            .andExpect(jsonPath("$.[*].montant").value(hasItem(DEFAULT_MONTANT.intValue())))
            .andExpect(jsonPath("$.[*].montantVerse").value(hasItem(DEFAULT_MONTANT_VERSE.intValue())))
            .andExpect(jsonPath("$.[*].conDateSignature").value(hasItem(DEFAULT_CON_DATE_SIGNATURE.toString())))
            .andExpect(jsonPath("$.[*].conDateApprobation").value(hasItem(DEFAULT_CON_DATE_APPROBATION.toString())))
            .andExpect(jsonPath("$.[*].conDateNotification").value(hasItem(DEFAULT_CON_DATE_NOTIFICATION.toString())))
            .andExpect(jsonPath("$.[*].conDateRecepProvisoire").value(hasItem(DEFAULT_CON_DATE_RECEP_PROVISOIRE.toString())))
            .andExpect(jsonPath("$.[*].conDateRecepDefinitive").value(hasItem(DEFAULT_CON_DATE_RECEP_DEFINITIVE.toString())))
            .andExpect(jsonPath("$.[*].conDateOrdreDemarrage").value(hasItem(DEFAULT_CON_DATE_ORDRE_DEMARRAGE.toString())))
            .andExpect(jsonPath("$.[*].condateAttributionProvisoire").value(hasItem(DEFAULT_CONDATE_ATTRIBUTION_PROVISOIRE.toString())))
            .andExpect(jsonPath("$.[*].condateAttributionDefinitive").value(hasItem(DEFAULT_CONDATE_ATTRIBUTION_DEFINITIVE.toString())))
            .andExpect(jsonPath("$.[*].conDatePaiement").value(hasItem(DEFAULT_CON_DATE_PAIEMENT.toString())))
            .andExpect(jsonPath("$.[*].dateDemandeImmatriculation").value(hasItem(DEFAULT_DATE_DEMANDE_IMMATRICULATION.toString())))
            .andExpect(jsonPath("$.[*].dateImmatriculation").value(hasItem(DEFAULT_DATE_IMMATRICULATION.toString())))
            .andExpect(jsonPath("$.[*].datePub").value(hasItem(DEFAULT_DATE_PUB.toString())))
            .andExpect(jsonPath("$.[*].dateDemandePubContrat").value(hasItem(DEFAULT_DATE_DEMANDE_PUB_CONTRAT.toString())))
            .andExpect(jsonPath("$.[*].conDateCreation").value(hasItem(DEFAULT_CON_DATE_CREATION.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateDemandeAutorisation").value(hasItem(DEFAULT_RENOUVCONT_DATE_DEMANDE_AUTORISATION.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateautorisation").value(hasItem(DEFAULT_RENOUVCONT_DATEAUTORISATION.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateDemandeExamenJuridique").value(hasItem(DEFAULT_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateExamenJuridique").value(hasItem(DEFAULT_RENOUVCONT_DATE_EXAMEN_JURIDIQUE.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateDemandeApprobation").value(hasItem(DEFAULT_RENOUVCONT_DATE_DEMANDE_APPROBATION.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateApprobation").value(hasItem(DEFAULT_RENOUVCONT_DATE_APPROBATION.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateRejet").value(hasItem(DEFAULT_RENOUVCONT_DATE_REJET.toString())))
            .andExpect(jsonPath("$.[*].renouvcontDateRetourApprobation").value(hasItem(DEFAULT_RENOUVCONT_DATE_RETOUR_APPROBATION.toString())))
            .andExpect(jsonPath("$.[*].conCommentSignature").value(hasItem(DEFAULT_CON_COMMENT_SIGNATURE)))
            .andExpect(jsonPath("$.[*].conRefSignature").value(hasItem(DEFAULT_CON_REF_SIGNATURE)))
            .andExpect(jsonPath("$.[*].conCommentApprobation").value(hasItem(DEFAULT_CON_COMMENT_APPROBATION)))
            .andExpect(jsonPath("$.[*].conRefApprobation").value(hasItem(DEFAULT_CON_REF_APPROBATION)))
            .andExpect(jsonPath("$.[*].conCommentNotification").value(hasItem(DEFAULT_CON_COMMENT_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].conRefNotification").value(hasItem(DEFAULT_CON_REF_NOTIFICATION)))
            .andExpect(jsonPath("$.[*].conFichierRecepProvisoire").value(hasItem(DEFAULT_CON_FICHIER_RECEP_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].conCommentRecepProvisoire").value(hasItem(DEFAULT_CON_COMMENT_RECEP_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].conFichierRecepDefinitive").value(hasItem(DEFAULT_CON_FICHIER_RECEP_DEFINITIVE)))
            .andExpect(jsonPath("$.[*].conCommentRecepDefinitive").value(hasItem(DEFAULT_CON_COMMENT_RECEP_DEFINITIVE)))
            .andExpect(jsonPath("$.[*].conFichierOrdreDemarrage").value(hasItem(DEFAULT_CON_FICHIER_ORDRE_DEMARRAGE)))
            .andExpect(jsonPath("$.[*].conCommentOrdreDemarrage").value(hasItem(DEFAULT_CON_COMMENT_ORDRE_DEMARRAGE)))
            .andExpect(jsonPath("$.[*].conRefAttributionProvisoire").value(hasItem(DEFAULT_CON_REF_ATTRIBUTION_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].conCommentaireAttributionProvisoire").value(hasItem(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE)))
            .andExpect(jsonPath("$.[*].conRefAttributionDefinitive").value(hasItem(DEFAULT_CON_REF_ATTRIBUTION_DEFINITIVE)))
            .andExpect(jsonPath("$.[*].conCommentaireAttributionDefinitive").value(hasItem(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE)))
            .andExpect(jsonPath("$.[*].conStatut").value(hasItem(DEFAULT_CON_STATUT)))
            .andExpect(jsonPath("$.[*].numMatriculation").value(hasItem(DEFAULT_NUM_MATRICULATION)))
            .andExpect(jsonPath("$.[*].conCommentaireDmdmat").value(hasItem(DEFAULT_CON_COMMENTAIRE_DMDMAT)))
            .andExpect(jsonPath("$.[*].conCommentaireMatriculation").value(hasItem(DEFAULT_CON_COMMENTAIRE_MATRICULATION)))
            .andExpect(jsonPath("$.[*].concSituation").value(hasItem(DEFAULT_CONC_SITUATION)))
            .andExpect(jsonPath("$.[*].nationnalite").value(hasItem(DEFAULT_NATIONNALITE)))
            .andExpect(jsonPath("$.[*].fichierImmatricule").value(hasItem(DEFAULT_FICHIER_IMMATRICULE)))
            .andExpect(jsonPath("$.[*].fichierJustificatif").value(hasItem(DEFAULT_FICHIER_JUSTIFICATIF)))
            .andExpect(jsonPath("$.[*].commentairePub").value(hasItem(DEFAULT_COMMENTAIRE_PUB)))
            .andExpect(jsonPath("$.[*].fichierContrat").value(hasItem(DEFAULT_FICHIER_CONTRAT)))
            .andExpect(jsonPath("$.[*].conCommentDemandePub").value(hasItem(DEFAULT_CON_COMMENT_DEMANDE_PUB)))
            .andExpect(jsonPath("$.[*].renouvcontFichierAutorisationPrealable").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE)))
            .andExpect(jsonPath("$.[*].renouvcontFichierExamenJuridique").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE)))
            .andExpect(jsonPath("$.[*].renouvcontFichierContratSigne").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_CONTRAT_SIGNE)))
            .andExpect(jsonPath("$.[*].renouvcontFichierPageGarde").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_PAGE_GARDE)))
            .andExpect(jsonPath("$.[*].renouvcontFichierPageSignature").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_PAGE_SIGNATURE)))
            .andExpect(jsonPath("$.[*].renouvcontFichierRapportMotivation").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION)))
            .andExpect(jsonPath("$.[*].renouvcontFichierProjetContrat").value(hasItem(DEFAULT_RENOUVCONT_FICHIER_PROJET_CONTRAT)))
            .andExpect(jsonPath("$.[*].renouvcontCommentAutorisation").value(hasItem(DEFAULT_RENOUVCONT_COMMENT_AUTORISATION)))
            .andExpect(jsonPath("$.[*].renouvcontCommentDemandeApprobation").value(hasItem(DEFAULT_RENOUVCONT_COMMENT_DEMANDE_APPROBATION)))
            .andExpect(jsonPath("$.[*].renouvcontCommentExamenJuridique").value(hasItem(DEFAULT_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE)))
            .andExpect(jsonPath("$.[*].autoriteId").value(hasItem(DEFAULT_AUTORITE_ID.intValue())))
            .andExpect(jsonPath("$.[*].serviceId").value(hasItem(DEFAULT_SERVICE_ID.intValue())))
            .andExpect(jsonPath("$.[*].modePassationId").value(hasItem(DEFAULT_MODE_PASSATION_ID.intValue())))
            .andExpect(jsonPath("$.[*].typeMarcheId").value(hasItem(DEFAULT_TYPE_MARCHE_ID.intValue())))
            .andExpect(jsonPath("$.[*].immatriculation").value(hasItem(DEFAULT_IMMATRICULATION)))
            .andExpect(jsonPath("$.[*].delai").value(hasItem(DEFAULT_DELAI)))
            .andExpect(jsonPath("$.[*].renouvcontImmatStatut").value(hasItem(DEFAULT_RENOUVCONT_IMMAT_STATUT.booleanValue())))
            .andExpect(jsonPath("$.[*].renouvcontPubStatut").value(hasItem(DEFAULT_RENOUVCONT_PUB_STATUT.booleanValue())))
            .andExpect(jsonPath("$.[*].renouvcontAutorisationStatut").value(hasItem(DEFAULT_RENOUVCONT_AUTORISATION_STATUT)))
            .andExpect(jsonPath("$.[*].renouvcontExamenJuridiqueStatut").value(hasItem(DEFAULT_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT)))
            .andExpect(jsonPath("$.[*].renouvcontApprobationStatut").value(hasItem(DEFAULT_RENOUVCONT_APPROBATION_STATUT)))
            .andExpect(jsonPath("$.[*].etatContratdebase").value(hasItem(DEFAULT_ETAT_CONTRATDEBASE)))
            .andExpect(jsonPath("$.[*].libelleLot").value(hasItem(DEFAULT_LIBELLE_LOT)));
    }
    
    @Test
    @Transactional
    public void getContrat() throws Exception {
        // Initialize the database
        contratRepository.saveAndFlush(contrat);

        // Get the contrat
        restContratMockMvc.perform(get("/api/contrats/{id}", contrat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(contrat.getId().intValue()))
            .andExpect(jsonPath("$.montant").value(DEFAULT_MONTANT.intValue()))
            .andExpect(jsonPath("$.montantVerse").value(DEFAULT_MONTANT_VERSE.intValue()))
            .andExpect(jsonPath("$.conDateSignature").value(DEFAULT_CON_DATE_SIGNATURE.toString()))
            .andExpect(jsonPath("$.conDateApprobation").value(DEFAULT_CON_DATE_APPROBATION.toString()))
            .andExpect(jsonPath("$.conDateNotification").value(DEFAULT_CON_DATE_NOTIFICATION.toString()))
            .andExpect(jsonPath("$.conDateRecepProvisoire").value(DEFAULT_CON_DATE_RECEP_PROVISOIRE.toString()))
            .andExpect(jsonPath("$.conDateRecepDefinitive").value(DEFAULT_CON_DATE_RECEP_DEFINITIVE.toString()))
            .andExpect(jsonPath("$.conDateOrdreDemarrage").value(DEFAULT_CON_DATE_ORDRE_DEMARRAGE.toString()))
            .andExpect(jsonPath("$.condateAttributionProvisoire").value(DEFAULT_CONDATE_ATTRIBUTION_PROVISOIRE.toString()))
            .andExpect(jsonPath("$.condateAttributionDefinitive").value(DEFAULT_CONDATE_ATTRIBUTION_DEFINITIVE.toString()))
            .andExpect(jsonPath("$.conDatePaiement").value(DEFAULT_CON_DATE_PAIEMENT.toString()))
            .andExpect(jsonPath("$.dateDemandeImmatriculation").value(DEFAULT_DATE_DEMANDE_IMMATRICULATION.toString()))
            .andExpect(jsonPath("$.dateImmatriculation").value(DEFAULT_DATE_IMMATRICULATION.toString()))
            .andExpect(jsonPath("$.datePub").value(DEFAULT_DATE_PUB.toString()))
            .andExpect(jsonPath("$.dateDemandePubContrat").value(DEFAULT_DATE_DEMANDE_PUB_CONTRAT.toString()))
            .andExpect(jsonPath("$.conDateCreation").value(DEFAULT_CON_DATE_CREATION.toString()))
            .andExpect(jsonPath("$.renouvcontDateDemandeAutorisation").value(DEFAULT_RENOUVCONT_DATE_DEMANDE_AUTORISATION.toString()))
            .andExpect(jsonPath("$.renouvcontDateautorisation").value(DEFAULT_RENOUVCONT_DATEAUTORISATION.toString()))
            .andExpect(jsonPath("$.renouvcontDateDemandeExamenJuridique").value(DEFAULT_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE.toString()))
            .andExpect(jsonPath("$.renouvcontDateExamenJuridique").value(DEFAULT_RENOUVCONT_DATE_EXAMEN_JURIDIQUE.toString()))
            .andExpect(jsonPath("$.renouvcontDateDemandeApprobation").value(DEFAULT_RENOUVCONT_DATE_DEMANDE_APPROBATION.toString()))
            .andExpect(jsonPath("$.renouvcontDateApprobation").value(DEFAULT_RENOUVCONT_DATE_APPROBATION.toString()))
            .andExpect(jsonPath("$.renouvcontDateRejet").value(DEFAULT_RENOUVCONT_DATE_REJET.toString()))
            .andExpect(jsonPath("$.renouvcontDateRetourApprobation").value(DEFAULT_RENOUVCONT_DATE_RETOUR_APPROBATION.toString()))
            .andExpect(jsonPath("$.conCommentSignature").value(DEFAULT_CON_COMMENT_SIGNATURE))
            .andExpect(jsonPath("$.conRefSignature").value(DEFAULT_CON_REF_SIGNATURE))
            .andExpect(jsonPath("$.conCommentApprobation").value(DEFAULT_CON_COMMENT_APPROBATION))
            .andExpect(jsonPath("$.conRefApprobation").value(DEFAULT_CON_REF_APPROBATION))
            .andExpect(jsonPath("$.conCommentNotification").value(DEFAULT_CON_COMMENT_NOTIFICATION))
            .andExpect(jsonPath("$.conRefNotification").value(DEFAULT_CON_REF_NOTIFICATION))
            .andExpect(jsonPath("$.conFichierRecepProvisoire").value(DEFAULT_CON_FICHIER_RECEP_PROVISOIRE))
            .andExpect(jsonPath("$.conCommentRecepProvisoire").value(DEFAULT_CON_COMMENT_RECEP_PROVISOIRE))
            .andExpect(jsonPath("$.conFichierRecepDefinitive").value(DEFAULT_CON_FICHIER_RECEP_DEFINITIVE))
            .andExpect(jsonPath("$.conCommentRecepDefinitive").value(DEFAULT_CON_COMMENT_RECEP_DEFINITIVE))
            .andExpect(jsonPath("$.conFichierOrdreDemarrage").value(DEFAULT_CON_FICHIER_ORDRE_DEMARRAGE))
            .andExpect(jsonPath("$.conCommentOrdreDemarrage").value(DEFAULT_CON_COMMENT_ORDRE_DEMARRAGE))
            .andExpect(jsonPath("$.conRefAttributionProvisoire").value(DEFAULT_CON_REF_ATTRIBUTION_PROVISOIRE))
            .andExpect(jsonPath("$.conCommentaireAttributionProvisoire").value(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE))
            .andExpect(jsonPath("$.conRefAttributionDefinitive").value(DEFAULT_CON_REF_ATTRIBUTION_DEFINITIVE))
            .andExpect(jsonPath("$.conCommentaireAttributionDefinitive").value(DEFAULT_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE))
            .andExpect(jsonPath("$.conStatut").value(DEFAULT_CON_STATUT))
            .andExpect(jsonPath("$.numMatriculation").value(DEFAULT_NUM_MATRICULATION))
            .andExpect(jsonPath("$.conCommentaireDmdmat").value(DEFAULT_CON_COMMENTAIRE_DMDMAT))
            .andExpect(jsonPath("$.conCommentaireMatriculation").value(DEFAULT_CON_COMMENTAIRE_MATRICULATION))
            .andExpect(jsonPath("$.concSituation").value(DEFAULT_CONC_SITUATION))
            .andExpect(jsonPath("$.nationnalite").value(DEFAULT_NATIONNALITE))
            .andExpect(jsonPath("$.fichierImmatricule").value(DEFAULT_FICHIER_IMMATRICULE))
            .andExpect(jsonPath("$.fichierJustificatif").value(DEFAULT_FICHIER_JUSTIFICATIF))
            .andExpect(jsonPath("$.commentairePub").value(DEFAULT_COMMENTAIRE_PUB))
            .andExpect(jsonPath("$.fichierContrat").value(DEFAULT_FICHIER_CONTRAT))
            .andExpect(jsonPath("$.conCommentDemandePub").value(DEFAULT_CON_COMMENT_DEMANDE_PUB))
            .andExpect(jsonPath("$.renouvcontFichierAutorisationPrealable").value(DEFAULT_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE))
            .andExpect(jsonPath("$.renouvcontFichierExamenJuridique").value(DEFAULT_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE))
            .andExpect(jsonPath("$.renouvcontFichierContratSigne").value(DEFAULT_RENOUVCONT_FICHIER_CONTRAT_SIGNE))
            .andExpect(jsonPath("$.renouvcontFichierPageGarde").value(DEFAULT_RENOUVCONT_FICHIER_PAGE_GARDE))
            .andExpect(jsonPath("$.renouvcontFichierPageSignature").value(DEFAULT_RENOUVCONT_FICHIER_PAGE_SIGNATURE))
            .andExpect(jsonPath("$.renouvcontFichierRapportMotivation").value(DEFAULT_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION))
            .andExpect(jsonPath("$.renouvcontFichierProjetContrat").value(DEFAULT_RENOUVCONT_FICHIER_PROJET_CONTRAT))
            .andExpect(jsonPath("$.renouvcontCommentAutorisation").value(DEFAULT_RENOUVCONT_COMMENT_AUTORISATION))
            .andExpect(jsonPath("$.renouvcontCommentDemandeApprobation").value(DEFAULT_RENOUVCONT_COMMENT_DEMANDE_APPROBATION))
            .andExpect(jsonPath("$.renouvcontCommentExamenJuridique").value(DEFAULT_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE))
            .andExpect(jsonPath("$.autoriteId").value(DEFAULT_AUTORITE_ID.intValue()))
            .andExpect(jsonPath("$.serviceId").value(DEFAULT_SERVICE_ID.intValue()))
            .andExpect(jsonPath("$.modePassationId").value(DEFAULT_MODE_PASSATION_ID.intValue()))
            .andExpect(jsonPath("$.typeMarcheId").value(DEFAULT_TYPE_MARCHE_ID.intValue()))
            .andExpect(jsonPath("$.immatriculation").value(DEFAULT_IMMATRICULATION))
            .andExpect(jsonPath("$.delai").value(DEFAULT_DELAI))
            .andExpect(jsonPath("$.renouvcontImmatStatut").value(DEFAULT_RENOUVCONT_IMMAT_STATUT.booleanValue()))
            .andExpect(jsonPath("$.renouvcontPubStatut").value(DEFAULT_RENOUVCONT_PUB_STATUT.booleanValue()))
            .andExpect(jsonPath("$.renouvcontAutorisationStatut").value(DEFAULT_RENOUVCONT_AUTORISATION_STATUT))
            .andExpect(jsonPath("$.renouvcontExamenJuridiqueStatut").value(DEFAULT_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT))
            .andExpect(jsonPath("$.renouvcontApprobationStatut").value(DEFAULT_RENOUVCONT_APPROBATION_STATUT))
            .andExpect(jsonPath("$.etatContratdebase").value(DEFAULT_ETAT_CONTRATDEBASE))
            .andExpect(jsonPath("$.libelleLot").value(DEFAULT_LIBELLE_LOT));
    }
    @Test
    @Transactional
    public void getNonExistingContrat() throws Exception {
        // Get the contrat
        restContratMockMvc.perform(get("/api/contrats/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateContrat() throws Exception {
        // Initialize the database
        contratRepository.saveAndFlush(contrat);

        int databaseSizeBeforeUpdate = contratRepository.findAll().size();

        // Update the contrat
        Contrat updatedContrat = contratRepository.findById(contrat.getId()).get();
        // Disconnect from session so that the updates on updatedContrat are not directly saved in db
        em.detach(updatedContrat);
        updatedContrat
            .montant(UPDATED_MONTANT)
            .montantVerse(UPDATED_MONTANT_VERSE)
            .conDateSignature(UPDATED_CON_DATE_SIGNATURE)
            .conDateApprobation(UPDATED_CON_DATE_APPROBATION)
            .conDateNotification(UPDATED_CON_DATE_NOTIFICATION)
            .conDateRecepProvisoire(UPDATED_CON_DATE_RECEP_PROVISOIRE)
            .conDateRecepDefinitive(UPDATED_CON_DATE_RECEP_DEFINITIVE)
            .conDateOrdreDemarrage(UPDATED_CON_DATE_ORDRE_DEMARRAGE)
            .condateAttributionProvisoire(UPDATED_CONDATE_ATTRIBUTION_PROVISOIRE)
            .condateAttributionDefinitive(UPDATED_CONDATE_ATTRIBUTION_DEFINITIVE)
            .conDatePaiement(UPDATED_CON_DATE_PAIEMENT)
            .dateDemandeImmatriculation(UPDATED_DATE_DEMANDE_IMMATRICULATION)
            .dateImmatriculation(UPDATED_DATE_IMMATRICULATION)
            .datePub(UPDATED_DATE_PUB)
            .dateDemandePubContrat(UPDATED_DATE_DEMANDE_PUB_CONTRAT)
            .conDateCreation(UPDATED_CON_DATE_CREATION)
            .renouvcontDateDemandeAutorisation(UPDATED_RENOUVCONT_DATE_DEMANDE_AUTORISATION)
            .renouvcontDateautorisation(UPDATED_RENOUVCONT_DATEAUTORISATION)
            .renouvcontDateDemandeExamenJuridique(UPDATED_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE)
            .renouvcontDateExamenJuridique(UPDATED_RENOUVCONT_DATE_EXAMEN_JURIDIQUE)
            .renouvcontDateDemandeApprobation(UPDATED_RENOUVCONT_DATE_DEMANDE_APPROBATION)
            .renouvcontDateApprobation(UPDATED_RENOUVCONT_DATE_APPROBATION)
            .renouvcontDateRejet(UPDATED_RENOUVCONT_DATE_REJET)
            .renouvcontDateRetourApprobation(UPDATED_RENOUVCONT_DATE_RETOUR_APPROBATION)
            .conCommentSignature(UPDATED_CON_COMMENT_SIGNATURE)
            .conRefSignature(UPDATED_CON_REF_SIGNATURE)
            .conCommentApprobation(UPDATED_CON_COMMENT_APPROBATION)
            .conRefApprobation(UPDATED_CON_REF_APPROBATION)
            .conCommentNotification(UPDATED_CON_COMMENT_NOTIFICATION)
            .conRefNotification(UPDATED_CON_REF_NOTIFICATION)
            .conFichierRecepProvisoire(UPDATED_CON_FICHIER_RECEP_PROVISOIRE)
            .conCommentRecepProvisoire(UPDATED_CON_COMMENT_RECEP_PROVISOIRE)
            .conFichierRecepDefinitive(UPDATED_CON_FICHIER_RECEP_DEFINITIVE)
            .conCommentRecepDefinitive(UPDATED_CON_COMMENT_RECEP_DEFINITIVE)
            .conFichierOrdreDemarrage(UPDATED_CON_FICHIER_ORDRE_DEMARRAGE)
            .conCommentOrdreDemarrage(UPDATED_CON_COMMENT_ORDRE_DEMARRAGE)
            .conRefAttributionProvisoire(UPDATED_CON_REF_ATTRIBUTION_PROVISOIRE)
            .conCommentaireAttributionProvisoire(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE)
            .conRefAttributionDefinitive(UPDATED_CON_REF_ATTRIBUTION_DEFINITIVE)
            .conCommentaireAttributionDefinitive(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE)
            .conStatut(UPDATED_CON_STATUT)
            .numMatriculation(UPDATED_NUM_MATRICULATION)
            .conCommentaireDmdmat(UPDATED_CON_COMMENTAIRE_DMDMAT)
            .conCommentaireMatriculation(UPDATED_CON_COMMENTAIRE_MATRICULATION)
            .concSituation(UPDATED_CONC_SITUATION)
            .nationnalite(UPDATED_NATIONNALITE)
            .fichierImmatricule(UPDATED_FICHIER_IMMATRICULE)
            .fichierJustificatif(UPDATED_FICHIER_JUSTIFICATIF)
            .commentairePub(UPDATED_COMMENTAIRE_PUB)
            .fichierContrat(UPDATED_FICHIER_CONTRAT)
            .conCommentDemandePub(UPDATED_CON_COMMENT_DEMANDE_PUB)
            .renouvcontFichierAutorisationPrealable(UPDATED_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE)
            .renouvcontFichierExamenJuridique(UPDATED_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE)
            .renouvcontFichierContratSigne(UPDATED_RENOUVCONT_FICHIER_CONTRAT_SIGNE)
            .renouvcontFichierPageGarde(UPDATED_RENOUVCONT_FICHIER_PAGE_GARDE)
            .renouvcontFichierPageSignature(UPDATED_RENOUVCONT_FICHIER_PAGE_SIGNATURE)
            .renouvcontFichierRapportMotivation(UPDATED_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION)
            .renouvcontFichierProjetContrat(UPDATED_RENOUVCONT_FICHIER_PROJET_CONTRAT)
            .renouvcontCommentAutorisation(UPDATED_RENOUVCONT_COMMENT_AUTORISATION)
            .renouvcontCommentDemandeApprobation(UPDATED_RENOUVCONT_COMMENT_DEMANDE_APPROBATION)
            .renouvcontCommentExamenJuridique(UPDATED_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE)
            .autoriteId(UPDATED_AUTORITE_ID)
            .serviceId(UPDATED_SERVICE_ID)
            .modePassationId(UPDATED_MODE_PASSATION_ID)
            .typeMarcheId(UPDATED_TYPE_MARCHE_ID)
            .immatriculation(UPDATED_IMMATRICULATION)
            .delai(UPDATED_DELAI)
            .renouvcontImmatStatut(UPDATED_RENOUVCONT_IMMAT_STATUT)
            .renouvcontPubStatut(UPDATED_RENOUVCONT_PUB_STATUT)
            .renouvcontAutorisationStatut(UPDATED_RENOUVCONT_AUTORISATION_STATUT)
            .renouvcontExamenJuridiqueStatut(UPDATED_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT)
            .renouvcontApprobationStatut(UPDATED_RENOUVCONT_APPROBATION_STATUT)
            .etatContratdebase(UPDATED_ETAT_CONTRATDEBASE)
            .libelleLot(UPDATED_LIBELLE_LOT);
        ContratDTO contratDTO = contratMapper.toDto(updatedContrat);

        restContratMockMvc.perform(put("/api/contrats")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(contratDTO)))
            .andExpect(status().isOk());

        // Validate the Contrat in the database
        List<Contrat> contratList = contratRepository.findAll();
        assertThat(contratList).hasSize(databaseSizeBeforeUpdate);
        Contrat testContrat = contratList.get(contratList.size() - 1);
        assertThat(testContrat.getMontant()).isEqualTo(UPDATED_MONTANT);
        assertThat(testContrat.getMontantVerse()).isEqualTo(UPDATED_MONTANT_VERSE);
        assertThat(testContrat.getConDateSignature()).isEqualTo(UPDATED_CON_DATE_SIGNATURE);
        assertThat(testContrat.getConDateApprobation()).isEqualTo(UPDATED_CON_DATE_APPROBATION);
        assertThat(testContrat.getConDateNotification()).isEqualTo(UPDATED_CON_DATE_NOTIFICATION);
        assertThat(testContrat.getConDateRecepProvisoire()).isEqualTo(UPDATED_CON_DATE_RECEP_PROVISOIRE);
        assertThat(testContrat.getConDateRecepDefinitive()).isEqualTo(UPDATED_CON_DATE_RECEP_DEFINITIVE);
        assertThat(testContrat.getConDateOrdreDemarrage()).isEqualTo(UPDATED_CON_DATE_ORDRE_DEMARRAGE);
        assertThat(testContrat.getCondateAttributionProvisoire()).isEqualTo(UPDATED_CONDATE_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getCondateAttributionDefinitive()).isEqualTo(UPDATED_CONDATE_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConDatePaiement()).isEqualTo(UPDATED_CON_DATE_PAIEMENT);
        assertThat(testContrat.getDateDemandeImmatriculation()).isEqualTo(UPDATED_DATE_DEMANDE_IMMATRICULATION);
        assertThat(testContrat.getDateImmatriculation()).isEqualTo(UPDATED_DATE_IMMATRICULATION);
        assertThat(testContrat.getDatePub()).isEqualTo(UPDATED_DATE_PUB);
        assertThat(testContrat.getDateDemandePubContrat()).isEqualTo(UPDATED_DATE_DEMANDE_PUB_CONTRAT);
        assertThat(testContrat.getConDateCreation()).isEqualTo(UPDATED_CON_DATE_CREATION);
        assertThat(testContrat.getRenouvcontDateDemandeAutorisation()).isEqualTo(UPDATED_RENOUVCONT_DATE_DEMANDE_AUTORISATION);
        assertThat(testContrat.getRenouvcontDateautorisation()).isEqualTo(UPDATED_RENOUVCONT_DATEAUTORISATION);
        assertThat(testContrat.getRenouvcontDateDemandeExamenJuridique()).isEqualTo(UPDATED_RENOUVCONT_DATE_DEMANDE_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontDateExamenJuridique()).isEqualTo(UPDATED_RENOUVCONT_DATE_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontDateDemandeApprobation()).isEqualTo(UPDATED_RENOUVCONT_DATE_DEMANDE_APPROBATION);
        assertThat(testContrat.getRenouvcontDateApprobation()).isEqualTo(UPDATED_RENOUVCONT_DATE_APPROBATION);
        assertThat(testContrat.getRenouvcontDateRejet()).isEqualTo(UPDATED_RENOUVCONT_DATE_REJET);
        assertThat(testContrat.getRenouvcontDateRetourApprobation()).isEqualTo(UPDATED_RENOUVCONT_DATE_RETOUR_APPROBATION);
        assertThat(testContrat.getConCommentSignature()).isEqualTo(UPDATED_CON_COMMENT_SIGNATURE);
        assertThat(testContrat.getConRefSignature()).isEqualTo(UPDATED_CON_REF_SIGNATURE);
        assertThat(testContrat.getConCommentApprobation()).isEqualTo(UPDATED_CON_COMMENT_APPROBATION);
        assertThat(testContrat.getConRefApprobation()).isEqualTo(UPDATED_CON_REF_APPROBATION);
        assertThat(testContrat.getConCommentNotification()).isEqualTo(UPDATED_CON_COMMENT_NOTIFICATION);
        assertThat(testContrat.getConRefNotification()).isEqualTo(UPDATED_CON_REF_NOTIFICATION);
        assertThat(testContrat.getConFichierRecepProvisoire()).isEqualTo(UPDATED_CON_FICHIER_RECEP_PROVISOIRE);
        assertThat(testContrat.getConCommentRecepProvisoire()).isEqualTo(UPDATED_CON_COMMENT_RECEP_PROVISOIRE);
        assertThat(testContrat.getConFichierRecepDefinitive()).isEqualTo(UPDATED_CON_FICHIER_RECEP_DEFINITIVE);
        assertThat(testContrat.getConCommentRecepDefinitive()).isEqualTo(UPDATED_CON_COMMENT_RECEP_DEFINITIVE);
        assertThat(testContrat.getConFichierOrdreDemarrage()).isEqualTo(UPDATED_CON_FICHIER_ORDRE_DEMARRAGE);
        assertThat(testContrat.getConCommentOrdreDemarrage()).isEqualTo(UPDATED_CON_COMMENT_ORDRE_DEMARRAGE);
        assertThat(testContrat.getConRefAttributionProvisoire()).isEqualTo(UPDATED_CON_REF_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getConCommentaireAttributionProvisoire()).isEqualTo(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_PROVISOIRE);
        assertThat(testContrat.getConRefAttributionDefinitive()).isEqualTo(UPDATED_CON_REF_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConCommentaireAttributionDefinitive()).isEqualTo(UPDATED_CON_COMMENTAIRE_ATTRIBUTION_DEFINITIVE);
        assertThat(testContrat.getConStatut()).isEqualTo(UPDATED_CON_STATUT);
        assertThat(testContrat.getNumMatriculation()).isEqualTo(UPDATED_NUM_MATRICULATION);
        assertThat(testContrat.getConCommentaireDmdmat()).isEqualTo(UPDATED_CON_COMMENTAIRE_DMDMAT);
        assertThat(testContrat.getConCommentaireMatriculation()).isEqualTo(UPDATED_CON_COMMENTAIRE_MATRICULATION);
        assertThat(testContrat.getConcSituation()).isEqualTo(UPDATED_CONC_SITUATION);
        assertThat(testContrat.getNationnalite()).isEqualTo(UPDATED_NATIONNALITE);
        assertThat(testContrat.getFichierImmatricule()).isEqualTo(UPDATED_FICHIER_IMMATRICULE);
        assertThat(testContrat.getFichierJustificatif()).isEqualTo(UPDATED_FICHIER_JUSTIFICATIF);
        assertThat(testContrat.getCommentairePub()).isEqualTo(UPDATED_COMMENTAIRE_PUB);
        assertThat(testContrat.getFichierContrat()).isEqualTo(UPDATED_FICHIER_CONTRAT);
        assertThat(testContrat.getConCommentDemandePub()).isEqualTo(UPDATED_CON_COMMENT_DEMANDE_PUB);
        assertThat(testContrat.getRenouvcontFichierAutorisationPrealable()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_AUTORISATION_PREALABLE);
        assertThat(testContrat.getRenouvcontFichierExamenJuridique()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getRenouvcontFichierContratSigne()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_CONTRAT_SIGNE);
        assertThat(testContrat.getRenouvcontFichierPageGarde()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_PAGE_GARDE);
        assertThat(testContrat.getRenouvcontFichierPageSignature()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_PAGE_SIGNATURE);
        assertThat(testContrat.getRenouvcontFichierRapportMotivation()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_RAPPORT_MOTIVATION);
        assertThat(testContrat.getRenouvcontFichierProjetContrat()).isEqualTo(UPDATED_RENOUVCONT_FICHIER_PROJET_CONTRAT);
        assertThat(testContrat.getRenouvcontCommentAutorisation()).isEqualTo(UPDATED_RENOUVCONT_COMMENT_AUTORISATION);
        assertThat(testContrat.getRenouvcontCommentDemandeApprobation()).isEqualTo(UPDATED_RENOUVCONT_COMMENT_DEMANDE_APPROBATION);
        assertThat(testContrat.getRenouvcontCommentExamenJuridique()).isEqualTo(UPDATED_RENOUVCONT_COMMENT_EXAMEN_JURIDIQUE);
        assertThat(testContrat.getAutoriteId()).isEqualTo(UPDATED_AUTORITE_ID);
        assertThat(testContrat.getServiceId()).isEqualTo(UPDATED_SERVICE_ID);
        assertThat(testContrat.getModePassationId()).isEqualTo(UPDATED_MODE_PASSATION_ID);
        assertThat(testContrat.getTypeMarcheId()).isEqualTo(UPDATED_TYPE_MARCHE_ID);
        assertThat(testContrat.getImmatriculation()).isEqualTo(UPDATED_IMMATRICULATION);
        assertThat(testContrat.getDelai()).isEqualTo(UPDATED_DELAI);
        assertThat(testContrat.isRenouvcontImmatStatut()).isEqualTo(UPDATED_RENOUVCONT_IMMAT_STATUT);
        assertThat(testContrat.isRenouvcontPubStatut()).isEqualTo(UPDATED_RENOUVCONT_PUB_STATUT);
        assertThat(testContrat.getRenouvcontAutorisationStatut()).isEqualTo(UPDATED_RENOUVCONT_AUTORISATION_STATUT);
        assertThat(testContrat.getRenouvcontExamenJuridiqueStatut()).isEqualTo(UPDATED_RENOUVCONT_EXAMEN_JURIDIQUE_STATUT);
        assertThat(testContrat.getRenouvcontApprobationStatut()).isEqualTo(UPDATED_RENOUVCONT_APPROBATION_STATUT);
        assertThat(testContrat.getEtatContratdebase()).isEqualTo(UPDATED_ETAT_CONTRATDEBASE);
        assertThat(testContrat.getLibelleLot()).isEqualTo(UPDATED_LIBELLE_LOT);
    }

    @Test
    @Transactional
    public void updateNonExistingContrat() throws Exception {
        int databaseSizeBeforeUpdate = contratRepository.findAll().size();

        // Create the Contrat
        ContratDTO contratDTO = contratMapper.toDto(contrat);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restContratMockMvc.perform(put("/api/contrats")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(contratDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Contrat in the database
        List<Contrat> contratList = contratRepository.findAll();
        assertThat(contratList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteContrat() throws Exception {
        // Initialize the database
        contratRepository.saveAndFlush(contrat);

        int databaseSizeBeforeDelete = contratRepository.findAll().size();

        // Delete the contrat
        restContratMockMvc.perform(delete("/api/contrats/{id}", contrat.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Contrat> contratList = contratRepository.findAll();
        assertThat(contratList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
