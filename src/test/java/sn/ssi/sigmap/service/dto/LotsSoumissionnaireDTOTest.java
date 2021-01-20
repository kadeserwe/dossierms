package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class LotsSoumissionnaireDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(LotsSoumissionnaireDTO.class);
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO1 = new LotsSoumissionnaireDTO();
        lotsSoumissionnaireDTO1.setId(1L);
        LotsSoumissionnaireDTO lotsSoumissionnaireDTO2 = new LotsSoumissionnaireDTO();
        assertThat(lotsSoumissionnaireDTO1).isNotEqualTo(lotsSoumissionnaireDTO2);
        lotsSoumissionnaireDTO2.setId(lotsSoumissionnaireDTO1.getId());
        assertThat(lotsSoumissionnaireDTO1).isEqualTo(lotsSoumissionnaireDTO2);
        lotsSoumissionnaireDTO2.setId(2L);
        assertThat(lotsSoumissionnaireDTO1).isNotEqualTo(lotsSoumissionnaireDTO2);
        lotsSoumissionnaireDTO1.setId(null);
        assertThat(lotsSoumissionnaireDTO1).isNotEqualTo(lotsSoumissionnaireDTO2);
    }
}
