package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersPieceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersPiece.class);
        DossiersPiece dossiersPiece1 = new DossiersPiece();
        dossiersPiece1.setId(1L);
        DossiersPiece dossiersPiece2 = new DossiersPiece();
        dossiersPiece2.setId(dossiersPiece1.getId());
        assertThat(dossiersPiece1).isEqualTo(dossiersPiece2);
        dossiersPiece2.setId(2L);
        assertThat(dossiersPiece1).isNotEqualTo(dossiersPiece2);
        dossiersPiece1.setId(null);
        assertThat(dossiersPiece1).isNotEqualTo(dossiersPiece2);
    }
}
