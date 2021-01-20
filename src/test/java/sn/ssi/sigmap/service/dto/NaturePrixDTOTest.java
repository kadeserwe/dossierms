package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class NaturePrixDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NaturePrixDTO.class);
        NaturePrixDTO naturePrixDTO1 = new NaturePrixDTO();
        naturePrixDTO1.setId(1L);
        NaturePrixDTO naturePrixDTO2 = new NaturePrixDTO();
        assertThat(naturePrixDTO1).isNotEqualTo(naturePrixDTO2);
        naturePrixDTO2.setId(naturePrixDTO1.getId());
        assertThat(naturePrixDTO1).isEqualTo(naturePrixDTO2);
        naturePrixDTO2.setId(2L);
        assertThat(naturePrixDTO1).isNotEqualTo(naturePrixDTO2);
        naturePrixDTO1.setId(null);
        assertThat(naturePrixDTO1).isNotEqualTo(naturePrixDTO2);
    }
}
