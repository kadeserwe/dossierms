package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class GarantiesSoumissionnaireDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(GarantiesSoumissionnaireDTO.class);
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO1 = new GarantiesSoumissionnaireDTO();
        garantiesSoumissionnaireDTO1.setId(1L);
        GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO2 = new GarantiesSoumissionnaireDTO();
        assertThat(garantiesSoumissionnaireDTO1).isNotEqualTo(garantiesSoumissionnaireDTO2);
        garantiesSoumissionnaireDTO2.setId(garantiesSoumissionnaireDTO1.getId());
        assertThat(garantiesSoumissionnaireDTO1).isEqualTo(garantiesSoumissionnaireDTO2);
        garantiesSoumissionnaireDTO2.setId(2L);
        assertThat(garantiesSoumissionnaireDTO1).isNotEqualTo(garantiesSoumissionnaireDTO2);
        garantiesSoumissionnaireDTO1.setId(null);
        assertThat(garantiesSoumissionnaireDTO1).isNotEqualTo(garantiesSoumissionnaireDTO2);
    }
}
