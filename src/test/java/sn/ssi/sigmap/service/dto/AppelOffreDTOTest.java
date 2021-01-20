package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AppelOffreDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppelOffreDTO.class);
        AppelOffreDTO appelOffreDTO1 = new AppelOffreDTO();
        appelOffreDTO1.setId(1L);
        AppelOffreDTO appelOffreDTO2 = new AppelOffreDTO();
        assertThat(appelOffreDTO1).isNotEqualTo(appelOffreDTO2);
        appelOffreDTO2.setId(appelOffreDTO1.getId());
        assertThat(appelOffreDTO1).isEqualTo(appelOffreDTO2);
        appelOffreDTO2.setId(2L);
        assertThat(appelOffreDTO1).isNotEqualTo(appelOffreDTO2);
        appelOffreDTO1.setId(null);
        assertThat(appelOffreDTO1).isNotEqualTo(appelOffreDTO2);
    }
}
