package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CritereTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Critere.class);
        Critere critere1 = new Critere();
        critere1.setId(1L);
        Critere critere2 = new Critere();
        critere2.setId(critere1.getId());
        assertThat(critere1).isEqualTo(critere2);
        critere2.setId(2L);
        assertThat(critere1).isNotEqualTo(critere2);
        critere1.setId(null);
        assertThat(critere1).isNotEqualTo(critere2);
    }
}
