package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class GarantiesSoumissionnaireTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GarantiesSoumissionnaire.class);
        GarantiesSoumissionnaire garantiesSoumissionnaire1 = new GarantiesSoumissionnaire();
        garantiesSoumissionnaire1.setId(1L);
        GarantiesSoumissionnaire garantiesSoumissionnaire2 = new GarantiesSoumissionnaire();
        garantiesSoumissionnaire2.setId(garantiesSoumissionnaire1.getId());
        assertThat(garantiesSoumissionnaire1).isEqualTo(garantiesSoumissionnaire2);
        garantiesSoumissionnaire2.setId(2L);
        assertThat(garantiesSoumissionnaire1).isNotEqualTo(garantiesSoumissionnaire2);
        garantiesSoumissionnaire1.setId(null);
        assertThat(garantiesSoumissionnaire1).isNotEqualTo(garantiesSoumissionnaire2);
    }
}
