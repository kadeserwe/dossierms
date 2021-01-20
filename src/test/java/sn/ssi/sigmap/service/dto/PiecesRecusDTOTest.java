package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PiecesRecusDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PiecesRecusDTO.class);
        PiecesRecusDTO piecesRecusDTO1 = new PiecesRecusDTO();
        piecesRecusDTO1.setId(1L);
        PiecesRecusDTO piecesRecusDTO2 = new PiecesRecusDTO();
        assertThat(piecesRecusDTO1).isNotEqualTo(piecesRecusDTO2);
        piecesRecusDTO2.setId(piecesRecusDTO1.getId());
        assertThat(piecesRecusDTO1).isEqualTo(piecesRecusDTO2);
        piecesRecusDTO2.setId(2L);
        assertThat(piecesRecusDTO1).isNotEqualTo(piecesRecusDTO2);
        piecesRecusDTO1.setId(null);
        assertThat(piecesRecusDTO1).isNotEqualTo(piecesRecusDTO2);
    }
}
