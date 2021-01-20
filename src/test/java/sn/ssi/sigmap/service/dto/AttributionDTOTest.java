package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class AttributionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AttributionDTO.class);
        AttributionDTO attributionDTO1 = new AttributionDTO();
        attributionDTO1.setId(1L);
        AttributionDTO attributionDTO2 = new AttributionDTO();
        assertThat(attributionDTO1).isNotEqualTo(attributionDTO2);
        attributionDTO2.setId(attributionDTO1.getId());
        assertThat(attributionDTO1).isEqualTo(attributionDTO2);
        attributionDTO2.setId(2L);
        assertThat(attributionDTO1).isNotEqualTo(attributionDTO2);
        attributionDTO1.setId(null);
        assertThat(attributionDTO1).isNotEqualTo(attributionDTO2);
    }
}
