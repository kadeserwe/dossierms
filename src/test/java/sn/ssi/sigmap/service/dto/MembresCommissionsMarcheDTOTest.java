package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class MembresCommissionsMarcheDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MembresCommissionsMarcheDTO.class);
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO1 = new MembresCommissionsMarcheDTO();
        membresCommissionsMarcheDTO1.setId(1L);
        MembresCommissionsMarcheDTO membresCommissionsMarcheDTO2 = new MembresCommissionsMarcheDTO();
        assertThat(membresCommissionsMarcheDTO1).isNotEqualTo(membresCommissionsMarcheDTO2);
        membresCommissionsMarcheDTO2.setId(membresCommissionsMarcheDTO1.getId());
        assertThat(membresCommissionsMarcheDTO1).isEqualTo(membresCommissionsMarcheDTO2);
        membresCommissionsMarcheDTO2.setId(2L);
        assertThat(membresCommissionsMarcheDTO1).isNotEqualTo(membresCommissionsMarcheDTO2);
        membresCommissionsMarcheDTO1.setId(null);
        assertThat(membresCommissionsMarcheDTO1).isNotEqualTo(membresCommissionsMarcheDTO2);
    }
}
