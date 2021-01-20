package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersCommissionsMarcheDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersCommissionsMarcheDTO.class);
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO1 = new DossiersCommissionsMarcheDTO();
        dossiersCommissionsMarcheDTO1.setId(1L);
        DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO2 = new DossiersCommissionsMarcheDTO();
        assertThat(dossiersCommissionsMarcheDTO1).isNotEqualTo(dossiersCommissionsMarcheDTO2);
        dossiersCommissionsMarcheDTO2.setId(dossiersCommissionsMarcheDTO1.getId());
        assertThat(dossiersCommissionsMarcheDTO1).isEqualTo(dossiersCommissionsMarcheDTO2);
        dossiersCommissionsMarcheDTO2.setId(2L);
        assertThat(dossiersCommissionsMarcheDTO1).isNotEqualTo(dossiersCommissionsMarcheDTO2);
        dossiersCommissionsMarcheDTO1.setId(null);
        assertThat(dossiersCommissionsMarcheDTO1).isNotEqualTo(dossiersCommissionsMarcheDTO2);
    }
}
