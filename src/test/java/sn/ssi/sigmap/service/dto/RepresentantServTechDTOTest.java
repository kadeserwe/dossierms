package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class RepresentantServTechDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RepresentantServTechDTO.class);
        RepresentantServTechDTO representantServTechDTO1 = new RepresentantServTechDTO();
        representantServTechDTO1.setId(1L);
        RepresentantServTechDTO representantServTechDTO2 = new RepresentantServTechDTO();
        assertThat(representantServTechDTO1).isNotEqualTo(representantServTechDTO2);
        representantServTechDTO2.setId(representantServTechDTO1.getId());
        assertThat(representantServTechDTO1).isEqualTo(representantServTechDTO2);
        representantServTechDTO2.setId(2L);
        assertThat(representantServTechDTO1).isNotEqualTo(representantServTechDTO2);
        representantServTechDTO1.setId(null);
        assertThat(representantServTechDTO1).isNotEqualTo(representantServTechDTO2);
    }
}
