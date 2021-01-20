package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PresenceOuvertureDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PresenceOuvertureDTO.class);
        PresenceOuvertureDTO presenceOuvertureDTO1 = new PresenceOuvertureDTO();
        presenceOuvertureDTO1.setId(1L);
        PresenceOuvertureDTO presenceOuvertureDTO2 = new PresenceOuvertureDTO();
        assertThat(presenceOuvertureDTO1).isNotEqualTo(presenceOuvertureDTO2);
        presenceOuvertureDTO2.setId(presenceOuvertureDTO1.getId());
        assertThat(presenceOuvertureDTO1).isEqualTo(presenceOuvertureDTO2);
        presenceOuvertureDTO2.setId(2L);
        assertThat(presenceOuvertureDTO1).isNotEqualTo(presenceOuvertureDTO2);
        presenceOuvertureDTO1.setId(null);
        assertThat(presenceOuvertureDTO1).isNotEqualTo(presenceOuvertureDTO2);
    }
}
