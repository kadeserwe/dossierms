package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PlisOuvertureDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlisOuvertureDTO.class);
        PlisOuvertureDTO plisOuvertureDTO1 = new PlisOuvertureDTO();
        plisOuvertureDTO1.setId(1L);
        PlisOuvertureDTO plisOuvertureDTO2 = new PlisOuvertureDTO();
        assertThat(plisOuvertureDTO1).isNotEqualTo(plisOuvertureDTO2);
        plisOuvertureDTO2.setId(plisOuvertureDTO1.getId());
        assertThat(plisOuvertureDTO1).isEqualTo(plisOuvertureDTO2);
        plisOuvertureDTO2.setId(2L);
        assertThat(plisOuvertureDTO1).isNotEqualTo(plisOuvertureDTO2);
        plisOuvertureDTO1.setId(null);
        assertThat(plisOuvertureDTO1).isNotEqualTo(plisOuvertureDTO2);
    }
}
