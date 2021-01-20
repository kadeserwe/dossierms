package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class HistoriqueAppelOffresACDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(HistoriqueAppelOffresACDTO.class);
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO1 = new HistoriqueAppelOffresACDTO();
        historiqueAppelOffresACDTO1.setId(1L);
        HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO2 = new HistoriqueAppelOffresACDTO();
        assertThat(historiqueAppelOffresACDTO1).isNotEqualTo(historiqueAppelOffresACDTO2);
        historiqueAppelOffresACDTO2.setId(historiqueAppelOffresACDTO1.getId());
        assertThat(historiqueAppelOffresACDTO1).isEqualTo(historiqueAppelOffresACDTO2);
        historiqueAppelOffresACDTO2.setId(2L);
        assertThat(historiqueAppelOffresACDTO1).isNotEqualTo(historiqueAppelOffresACDTO2);
        historiqueAppelOffresACDTO1.setId(null);
        assertThat(historiqueAppelOffresACDTO1).isNotEqualTo(historiqueAppelOffresACDTO2);
    }
}
