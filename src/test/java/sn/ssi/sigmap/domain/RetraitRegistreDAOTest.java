package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class RetraitRegistreDAOTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RetraitRegistreDAO.class);
        RetraitRegistreDAO retraitRegistreDAO1 = new RetraitRegistreDAO();
        retraitRegistreDAO1.setId(1L);
        RetraitRegistreDAO retraitRegistreDAO2 = new RetraitRegistreDAO();
        retraitRegistreDAO2.setId(retraitRegistreDAO1.getId());
        assertThat(retraitRegistreDAO1).isEqualTo(retraitRegistreDAO2);
        retraitRegistreDAO2.setId(2L);
        assertThat(retraitRegistreDAO1).isNotEqualTo(retraitRegistreDAO2);
        retraitRegistreDAO1.setId(null);
        assertThat(retraitRegistreDAO1).isNotEqualTo(retraitRegistreDAO2);
    }
}
