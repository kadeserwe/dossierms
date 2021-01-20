package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class ContratDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ContratDTO.class);
        ContratDTO contratDTO1 = new ContratDTO();
        contratDTO1.setId(1L);
        ContratDTO contratDTO2 = new ContratDTO();
        assertThat(contratDTO1).isNotEqualTo(contratDTO2);
        contratDTO2.setId(contratDTO1.getId());
        assertThat(contratDTO1).isEqualTo(contratDTO2);
        contratDTO2.setId(2L);
        assertThat(contratDTO1).isNotEqualTo(contratDTO2);
        contratDTO1.setId(null);
        assertThat(contratDTO1).isNotEqualTo(contratDTO2);
    }
}
