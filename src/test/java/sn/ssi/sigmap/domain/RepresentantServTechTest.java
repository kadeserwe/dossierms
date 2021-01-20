package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class RepresentantServTechTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RepresentantServTech.class);
        RepresentantServTech representantServTech1 = new RepresentantServTech();
        representantServTech1.setId(1L);
        RepresentantServTech representantServTech2 = new RepresentantServTech();
        representantServTech2.setId(representantServTech1.getId());
        assertThat(representantServTech1).isEqualTo(representantServTech2);
        representantServTech2.setId(2L);
        assertThat(representantServTech1).isNotEqualTo(representantServTech2);
        representantServTech1.setId(null);
        assertThat(representantServTech1).isNotEqualTo(representantServTech2);
    }
}
