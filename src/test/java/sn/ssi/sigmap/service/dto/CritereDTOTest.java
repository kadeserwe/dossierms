package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CritereDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CritereDTO.class);
        CritereDTO critereDTO1 = new CritereDTO();
        critereDTO1.setId(1L);
        CritereDTO critereDTO2 = new CritereDTO();
        assertThat(critereDTO1).isNotEqualTo(critereDTO2);
        critereDTO2.setId(critereDTO1.getId());
        assertThat(critereDTO1).isEqualTo(critereDTO2);
        critereDTO2.setId(2L);
        assertThat(critereDTO1).isNotEqualTo(critereDTO2);
        critereDTO1.setId(null);
        assertThat(critereDTO1).isNotEqualTo(critereDTO2);
    }
}
