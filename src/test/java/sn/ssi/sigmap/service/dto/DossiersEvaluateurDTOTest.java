package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersEvaluateurDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersEvaluateurDTO.class);
        DossiersEvaluateurDTO dossiersEvaluateurDTO1 = new DossiersEvaluateurDTO();
        dossiersEvaluateurDTO1.setId(1L);
        DossiersEvaluateurDTO dossiersEvaluateurDTO2 = new DossiersEvaluateurDTO();
        assertThat(dossiersEvaluateurDTO1).isNotEqualTo(dossiersEvaluateurDTO2);
        dossiersEvaluateurDTO2.setId(dossiersEvaluateurDTO1.getId());
        assertThat(dossiersEvaluateurDTO1).isEqualTo(dossiersEvaluateurDTO2);
        dossiersEvaluateurDTO2.setId(2L);
        assertThat(dossiersEvaluateurDTO1).isNotEqualTo(dossiersEvaluateurDTO2);
        dossiersEvaluateurDTO1.setId(null);
        assertThat(dossiersEvaluateurDTO1).isNotEqualTo(dossiersEvaluateurDTO2);
    }
}
