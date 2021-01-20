package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ObservateursIndependantDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ObservateursIndependantDTO.class);
        ObservateursIndependantDTO observateursIndependantDTO1 = new ObservateursIndependantDTO();
        observateursIndependantDTO1.setId(1L);
        ObservateursIndependantDTO observateursIndependantDTO2 = new ObservateursIndependantDTO();
        assertThat(observateursIndependantDTO1).isNotEqualTo(observateursIndependantDTO2);
        observateursIndependantDTO2.setId(observateursIndependantDTO1.getId());
        assertThat(observateursIndependantDTO1).isEqualTo(observateursIndependantDTO2);
        observateursIndependantDTO2.setId(2L);
        assertThat(observateursIndependantDTO1).isNotEqualTo(observateursIndependantDTO2);
        observateursIndependantDTO1.setId(null);
        assertThat(observateursIndependantDTO1).isNotEqualTo(observateursIndependantDTO2);
    }
}
