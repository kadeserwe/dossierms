package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AppelOffreTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppelOffre.class);
        AppelOffre appelOffre1 = new AppelOffre();
        appelOffre1.setId(1L);
        AppelOffre appelOffre2 = new AppelOffre();
        appelOffre2.setId(appelOffre1.getId());
        assertThat(appelOffre1).isEqualTo(appelOffre2);
        appelOffre2.setId(2L);
        assertThat(appelOffre1).isNotEqualTo(appelOffre2);
        appelOffre1.setId(null);
        assertThat(appelOffre1).isNotEqualTo(appelOffre2);
    }
}
