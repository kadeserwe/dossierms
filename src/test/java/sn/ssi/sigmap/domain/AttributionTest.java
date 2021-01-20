package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AttributionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Attribution.class);
        Attribution attribution1 = new Attribution();
        attribution1.setId(1L);
        Attribution attribution2 = new Attribution();
        attribution2.setId(attribution1.getId());
        assertThat(attribution1).isEqualTo(attribution2);
        attribution2.setId(2L);
        assertThat(attribution1).isNotEqualTo(attribution2);
        attribution1.setId(null);
        assertThat(attribution1).isNotEqualTo(attribution2);
    }
}
