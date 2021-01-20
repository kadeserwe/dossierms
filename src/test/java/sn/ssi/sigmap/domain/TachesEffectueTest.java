package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class TachesEffectueTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TachesEffectue.class);
        TachesEffectue tachesEffectue1 = new TachesEffectue();
        tachesEffectue1.setId(1L);
        TachesEffectue tachesEffectue2 = new TachesEffectue();
        tachesEffectue2.setId(tachesEffectue1.getId());
        assertThat(tachesEffectue1).isEqualTo(tachesEffectue2);
        tachesEffectue2.setId(2L);
        assertThat(tachesEffectue1).isNotEqualTo(tachesEffectue2);
        tachesEffectue1.setId(null);
        assertThat(tachesEffectue1).isNotEqualTo(tachesEffectue2);
    }
}
