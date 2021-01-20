package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersSouscritereDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersSouscritereDTO.class);
        DossiersSouscritereDTO dossiersSouscritereDTO1 = new DossiersSouscritereDTO();
        dossiersSouscritereDTO1.setId(1L);
        DossiersSouscritereDTO dossiersSouscritereDTO2 = new DossiersSouscritereDTO();
        assertThat(dossiersSouscritereDTO1).isNotEqualTo(dossiersSouscritereDTO2);
        dossiersSouscritereDTO2.setId(dossiersSouscritereDTO1.getId());
        assertThat(dossiersSouscritereDTO1).isEqualTo(dossiersSouscritereDTO2);
        dossiersSouscritereDTO2.setId(2L);
        assertThat(dossiersSouscritereDTO1).isNotEqualTo(dossiersSouscritereDTO2);
        dossiersSouscritereDTO1.setId(null);
        assertThat(dossiersSouscritereDTO1).isNotEqualTo(dossiersSouscritereDTO2);
    }
}
