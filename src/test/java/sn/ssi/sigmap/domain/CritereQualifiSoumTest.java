package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CritereQualifiSoumTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CritereQualifiSoum.class);
        CritereQualifiSoum critereQualifiSoum1 = new CritereQualifiSoum();
        critereQualifiSoum1.setId(1L);
        CritereQualifiSoum critereQualifiSoum2 = new CritereQualifiSoum();
        critereQualifiSoum2.setId(critereQualifiSoum1.getId());
        assertThat(critereQualifiSoum1).isEqualTo(critereQualifiSoum2);
        critereQualifiSoum2.setId(2L);
        assertThat(critereQualifiSoum1).isNotEqualTo(critereQualifiSoum2);
        critereQualifiSoum1.setId(null);
        assertThat(critereQualifiSoum1).isNotEqualTo(critereQualifiSoum2);
    }
}
