package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ObservateursIndependantTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ObservateursIndependant.class);
        ObservateursIndependant observateursIndependant1 = new ObservateursIndependant();
        observateursIndependant1.setId(1L);
        ObservateursIndependant observateursIndependant2 = new ObservateursIndependant();
        observateursIndependant2.setId(observateursIndependant1.getId());
        assertThat(observateursIndependant1).isEqualTo(observateursIndependant2);
        observateursIndependant2.setId(2L);
        assertThat(observateursIndependant1).isNotEqualTo(observateursIndependant2);
        observateursIndependant1.setId(null);
        assertThat(observateursIndependant1).isNotEqualTo(observateursIndependant2);
    }
}
