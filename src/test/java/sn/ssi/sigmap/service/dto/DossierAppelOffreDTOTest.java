package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossierAppelOffreDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossierAppelOffreDTO.class);
        DossierAppelOffreDTO dossierAppelOffreDTO1 = new DossierAppelOffreDTO();
        dossierAppelOffreDTO1.setId(1L);
        DossierAppelOffreDTO dossierAppelOffreDTO2 = new DossierAppelOffreDTO();
        assertThat(dossierAppelOffreDTO1).isNotEqualTo(dossierAppelOffreDTO2);
        dossierAppelOffreDTO2.setId(dossierAppelOffreDTO1.getId());
        assertThat(dossierAppelOffreDTO1).isEqualTo(dossierAppelOffreDTO2);
        dossierAppelOffreDTO2.setId(2L);
        assertThat(dossierAppelOffreDTO1).isNotEqualTo(dossierAppelOffreDTO2);
        dossierAppelOffreDTO1.setId(null);
        assertThat(dossierAppelOffreDTO1).isNotEqualTo(dossierAppelOffreDTO2);
    }
}
