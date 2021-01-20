package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PresenceOuvertureTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PresenceOuverture.class);
        PresenceOuverture presenceOuverture1 = new PresenceOuverture();
        presenceOuverture1.setId(1L);
        PresenceOuverture presenceOuverture2 = new PresenceOuverture();
        presenceOuverture2.setId(presenceOuverture1.getId());
        assertThat(presenceOuverture1).isEqualTo(presenceOuverture2);
        presenceOuverture2.setId(2L);
        assertThat(presenceOuverture1).isNotEqualTo(presenceOuverture2);
        presenceOuverture1.setId(null);
        assertThat(presenceOuverture1).isNotEqualTo(presenceOuverture2);
    }
}
