package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class NaturesGarantieDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NaturesGarantieDTO.class);
        NaturesGarantieDTO naturesGarantieDTO1 = new NaturesGarantieDTO();
        naturesGarantieDTO1.setId(1L);
        NaturesGarantieDTO naturesGarantieDTO2 = new NaturesGarantieDTO();
        assertThat(naturesGarantieDTO1).isNotEqualTo(naturesGarantieDTO2);
        naturesGarantieDTO2.setId(naturesGarantieDTO1.getId());
        assertThat(naturesGarantieDTO1).isEqualTo(naturesGarantieDTO2);
        naturesGarantieDTO2.setId(2L);
        assertThat(naturesGarantieDTO1).isNotEqualTo(naturesGarantieDTO2);
        naturesGarantieDTO1.setId(null);
        assertThat(naturesGarantieDTO1).isNotEqualTo(naturesGarantieDTO2);
    }
}
