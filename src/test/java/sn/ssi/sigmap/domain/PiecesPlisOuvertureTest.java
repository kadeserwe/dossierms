package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class PiecesPlisOuvertureTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PiecesPlisOuverture.class);
        PiecesPlisOuverture piecesPlisOuverture1 = new PiecesPlisOuverture();
        piecesPlisOuverture1.setId(1L);
        PiecesPlisOuverture piecesPlisOuverture2 = new PiecesPlisOuverture();
        piecesPlisOuverture2.setId(piecesPlisOuverture1.getId());
        assertThat(piecesPlisOuverture1).isEqualTo(piecesPlisOuverture2);
        piecesPlisOuverture2.setId(2L);
        assertThat(piecesPlisOuverture1).isNotEqualTo(piecesPlisOuverture2);
        piecesPlisOuverture1.setId(null);
        assertThat(piecesPlisOuverture1).isNotEqualTo(piecesPlisOuverture2);
    }
}
