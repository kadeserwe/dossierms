package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PlisOuvertureTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlisOuverture.class);
        PlisOuverture plisOuverture1 = new PlisOuverture();
        plisOuverture1.setId(1L);
        PlisOuverture plisOuverture2 = new PlisOuverture();
        plisOuverture2.setId(plisOuverture1.getId());
        assertThat(plisOuverture1).isEqualTo(plisOuverture2);
        plisOuverture2.setId(2L);
        assertThat(plisOuverture1).isNotEqualTo(plisOuverture2);
        plisOuverture1.setId(null);
        assertThat(plisOuverture1).isNotEqualTo(plisOuverture2);
    }
}
