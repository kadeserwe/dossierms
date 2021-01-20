package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class RetraitRegistreDAODTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RetraitRegistreDAODTO.class);
        RetraitRegistreDAODTO retraitRegistreDAODTO1 = new RetraitRegistreDAODTO();
        retraitRegistreDAODTO1.setId(1L);
        RetraitRegistreDAODTO retraitRegistreDAODTO2 = new RetraitRegistreDAODTO();
        assertThat(retraitRegistreDAODTO1).isNotEqualTo(retraitRegistreDAODTO2);
        retraitRegistreDAODTO2.setId(retraitRegistreDAODTO1.getId());
        assertThat(retraitRegistreDAODTO1).isEqualTo(retraitRegistreDAODTO2);
        retraitRegistreDAODTO2.setId(2L);
        assertThat(retraitRegistreDAODTO1).isNotEqualTo(retraitRegistreDAODTO2);
        retraitRegistreDAODTO1.setId(null);
        assertThat(retraitRegistreDAODTO1).isNotEqualTo(retraitRegistreDAODTO2);
    }
}
