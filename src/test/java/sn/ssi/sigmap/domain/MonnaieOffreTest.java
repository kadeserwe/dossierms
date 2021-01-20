package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class MonnaieOffreTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MonnaieOffre.class);
        MonnaieOffre monnaieOffre1 = new MonnaieOffre();
        monnaieOffre1.setId(1L);
        MonnaieOffre monnaieOffre2 = new MonnaieOffre();
        monnaieOffre2.setId(monnaieOffre1.getId());
        assertThat(monnaieOffre1).isEqualTo(monnaieOffre2);
        monnaieOffre2.setId(2L);
        assertThat(monnaieOffre1).isNotEqualTo(monnaieOffre2);
        monnaieOffre1.setId(null);
        assertThat(monnaieOffre1).isNotEqualTo(monnaieOffre2);
    }
}
