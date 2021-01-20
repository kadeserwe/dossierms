package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PiecesRecusTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PiecesRecus.class);
        PiecesRecus piecesRecus1 = new PiecesRecus();
        piecesRecus1.setId(1L);
        PiecesRecus piecesRecus2 = new PiecesRecus();
        piecesRecus2.setId(piecesRecus1.getId());
        assertThat(piecesRecus1).isEqualTo(piecesRecus2);
        piecesRecus2.setId(2L);
        assertThat(piecesRecus1).isNotEqualTo(piecesRecus2);
        piecesRecus1.setId(null);
        assertThat(piecesRecus1).isNotEqualTo(piecesRecus2);
    }
}
