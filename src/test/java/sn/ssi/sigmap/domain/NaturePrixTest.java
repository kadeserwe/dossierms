package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class NaturePrixTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NaturePrix.class);
        NaturePrix naturePrix1 = new NaturePrix();
        naturePrix1.setId(1L);
        NaturePrix naturePrix2 = new NaturePrix();
        naturePrix2.setId(naturePrix1.getId());
        assertThat(naturePrix1).isEqualTo(naturePrix2);
        naturePrix2.setId(2L);
        assertThat(naturePrix1).isNotEqualTo(naturePrix2);
        naturePrix1.setId(null);
        assertThat(naturePrix1).isNotEqualTo(naturePrix2);
    }
}
