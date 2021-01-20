package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CritereQualifiSoumDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CritereQualifiSoumDTO.class);
        CritereQualifiSoumDTO critereQualifiSoumDTO1 = new CritereQualifiSoumDTO();
        critereQualifiSoumDTO1.setId(1L);
        CritereQualifiSoumDTO critereQualifiSoumDTO2 = new CritereQualifiSoumDTO();
        assertThat(critereQualifiSoumDTO1).isNotEqualTo(critereQualifiSoumDTO2);
        critereQualifiSoumDTO2.setId(critereQualifiSoumDTO1.getId());
        assertThat(critereQualifiSoumDTO1).isEqualTo(critereQualifiSoumDTO2);
        critereQualifiSoumDTO2.setId(2L);
        assertThat(critereQualifiSoumDTO1).isNotEqualTo(critereQualifiSoumDTO2);
        critereQualifiSoumDTO1.setId(null);
        assertThat(critereQualifiSoumDTO1).isNotEqualTo(critereQualifiSoumDTO2);
    }
}
