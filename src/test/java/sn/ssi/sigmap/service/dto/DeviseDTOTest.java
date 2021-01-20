package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DeviseDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DeviseDTO.class);
        DeviseDTO deviseDTO1 = new DeviseDTO();
        deviseDTO1.setId(1L);
        DeviseDTO deviseDTO2 = new DeviseDTO();
        assertThat(deviseDTO1).isNotEqualTo(deviseDTO2);
        deviseDTO2.setId(deviseDTO1.getId());
        assertThat(deviseDTO1).isEqualTo(deviseDTO2);
        deviseDTO2.setId(2L);
        assertThat(deviseDTO1).isNotEqualTo(deviseDTO2);
        deviseDTO1.setId(null);
        assertThat(deviseDTO1).isNotEqualTo(deviseDTO2);
    }
}
