package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class MonnaieOffreDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MonnaieOffreDTO.class);
        MonnaieOffreDTO monnaieOffreDTO1 = new MonnaieOffreDTO();
        monnaieOffreDTO1.setId(1L);
        MonnaieOffreDTO monnaieOffreDTO2 = new MonnaieOffreDTO();
        assertThat(monnaieOffreDTO1).isNotEqualTo(monnaieOffreDTO2);
        monnaieOffreDTO2.setId(monnaieOffreDTO1.getId());
        assertThat(monnaieOffreDTO1).isEqualTo(monnaieOffreDTO2);
        monnaieOffreDTO2.setId(2L);
        assertThat(monnaieOffreDTO1).isNotEqualTo(monnaieOffreDTO2);
        monnaieOffreDTO1.setId(null);
        assertThat(monnaieOffreDTO1).isNotEqualTo(monnaieOffreDTO2);
    }
}
