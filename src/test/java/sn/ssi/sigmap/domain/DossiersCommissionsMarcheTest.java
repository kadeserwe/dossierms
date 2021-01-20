package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersCommissionsMarcheTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersCommissionsMarche.class);
        DossiersCommissionsMarche dossiersCommissionsMarche1 = new DossiersCommissionsMarche();
        dossiersCommissionsMarche1.setId(1L);
        DossiersCommissionsMarche dossiersCommissionsMarche2 = new DossiersCommissionsMarche();
        dossiersCommissionsMarche2.setId(dossiersCommissionsMarche1.getId());
        assertThat(dossiersCommissionsMarche1).isEqualTo(dossiersCommissionsMarche2);
        dossiersCommissionsMarche2.setId(2L);
        assertThat(dossiersCommissionsMarche1).isNotEqualTo(dossiersCommissionsMarche2);
        dossiersCommissionsMarche1.setId(null);
        assertThat(dossiersCommissionsMarche1).isNotEqualTo(dossiersCommissionsMarche2);
    }
}
