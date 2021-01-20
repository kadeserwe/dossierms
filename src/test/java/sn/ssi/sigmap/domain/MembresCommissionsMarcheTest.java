package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class MembresCommissionsMarcheTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MembresCommissionsMarche.class);
        MembresCommissionsMarche membresCommissionsMarche1 = new MembresCommissionsMarche();
        membresCommissionsMarche1.setId(1L);
        MembresCommissionsMarche membresCommissionsMarche2 = new MembresCommissionsMarche();
        membresCommissionsMarche2.setId(membresCommissionsMarche1.getId());
        assertThat(membresCommissionsMarche1).isEqualTo(membresCommissionsMarche2);
        membresCommissionsMarche2.setId(2L);
        assertThat(membresCommissionsMarche1).isNotEqualTo(membresCommissionsMarche2);
        membresCommissionsMarche1.setId(null);
        assertThat(membresCommissionsMarche1).isNotEqualTo(membresCommissionsMarche2);
    }
}
