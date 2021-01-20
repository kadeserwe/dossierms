package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class GarantiesDossierDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(GarantiesDossierDTO.class);
        GarantiesDossierDTO garantiesDossierDTO1 = new GarantiesDossierDTO();
        garantiesDossierDTO1.setId(1L);
        GarantiesDossierDTO garantiesDossierDTO2 = new GarantiesDossierDTO();
        assertThat(garantiesDossierDTO1).isNotEqualTo(garantiesDossierDTO2);
        garantiesDossierDTO2.setId(garantiesDossierDTO1.getId());
        assertThat(garantiesDossierDTO1).isEqualTo(garantiesDossierDTO2);
        garantiesDossierDTO2.setId(2L);
        assertThat(garantiesDossierDTO1).isNotEqualTo(garantiesDossierDTO2);
        garantiesDossierDTO1.setId(null);
        assertThat(garantiesDossierDTO1).isNotEqualTo(garantiesDossierDTO2);
    }
}
