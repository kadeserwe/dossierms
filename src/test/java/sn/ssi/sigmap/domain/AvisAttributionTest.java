package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AvisAttributionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AvisAttribution.class);
        AvisAttribution avisAttribution1 = new AvisAttribution();
        avisAttribution1.setId(1L);
        AvisAttribution avisAttribution2 = new AvisAttribution();
        avisAttribution2.setId(avisAttribution1.getId());
        assertThat(avisAttribution1).isEqualTo(avisAttribution2);
        avisAttribution2.setId(2L);
        assertThat(avisAttribution1).isNotEqualTo(avisAttribution2);
        avisAttribution1.setId(null);
        assertThat(avisAttribution1).isNotEqualTo(avisAttribution2);
    }
}
