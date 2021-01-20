package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PiecesPlisOuvertureDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PiecesPlisOuvertureDTO.class);
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO1 = new PiecesPlisOuvertureDTO();
        piecesPlisOuvertureDTO1.setId(1L);
        PiecesPlisOuvertureDTO piecesPlisOuvertureDTO2 = new PiecesPlisOuvertureDTO();
        assertThat(piecesPlisOuvertureDTO1).isNotEqualTo(piecesPlisOuvertureDTO2);
        piecesPlisOuvertureDTO2.setId(piecesPlisOuvertureDTO1.getId());
        assertThat(piecesPlisOuvertureDTO1).isEqualTo(piecesPlisOuvertureDTO2);
        piecesPlisOuvertureDTO2.setId(2L);
        assertThat(piecesPlisOuvertureDTO1).isNotEqualTo(piecesPlisOuvertureDTO2);
        piecesPlisOuvertureDTO1.setId(null);
        assertThat(piecesPlisOuvertureDTO1).isNotEqualTo(piecesPlisOuvertureDTO2);
    }
}
