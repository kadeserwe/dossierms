package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PieceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PieceDTO.class);
        PieceDTO pieceDTO1 = new PieceDTO();
        pieceDTO1.setId(1L);
        PieceDTO pieceDTO2 = new PieceDTO();
        assertThat(pieceDTO1).isNotEqualTo(pieceDTO2);
        pieceDTO2.setId(pieceDTO1.getId());
        assertThat(pieceDTO1).isEqualTo(pieceDTO2);
        pieceDTO2.setId(2L);
        assertThat(pieceDTO1).isNotEqualTo(pieceDTO2);
        pieceDTO1.setId(null);
        assertThat(pieceDTO1).isNotEqualTo(pieceDTO2);
    }
}
