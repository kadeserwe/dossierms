package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class LotsSoumissionnaireTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(LotsSoumissionnaire.class);
        LotsSoumissionnaire lotsSoumissionnaire1 = new LotsSoumissionnaire();
        lotsSoumissionnaire1.setId(1L);
        LotsSoumissionnaire lotsSoumissionnaire2 = new LotsSoumissionnaire();
        lotsSoumissionnaire2.setId(lotsSoumissionnaire1.getId());
        assertThat(lotsSoumissionnaire1).isEqualTo(lotsSoumissionnaire2);
        lotsSoumissionnaire2.setId(2L);
        assertThat(lotsSoumissionnaire1).isNotEqualTo(lotsSoumissionnaire2);
        lotsSoumissionnaire1.setId(null);
        assertThat(lotsSoumissionnaire1).isNotEqualTo(lotsSoumissionnaire2);
    }
}
