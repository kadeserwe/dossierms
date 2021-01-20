package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AvisAttributionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AvisAttributionDTO.class);
        AvisAttributionDTO avisAttributionDTO1 = new AvisAttributionDTO();
        avisAttributionDTO1.setId(1L);
        AvisAttributionDTO avisAttributionDTO2 = new AvisAttributionDTO();
        assertThat(avisAttributionDTO1).isNotEqualTo(avisAttributionDTO2);
        avisAttributionDTO2.setId(avisAttributionDTO1.getId());
        assertThat(avisAttributionDTO1).isEqualTo(avisAttributionDTO2);
        avisAttributionDTO2.setId(2L);
        assertThat(avisAttributionDTO1).isNotEqualTo(avisAttributionDTO2);
        avisAttributionDTO1.setId(null);
        assertThat(avisAttributionDTO1).isNotEqualTo(avisAttributionDTO2);
    }
}
