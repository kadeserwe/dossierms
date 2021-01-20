package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersEvaluateurTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersEvaluateur.class);
        DossiersEvaluateur dossiersEvaluateur1 = new DossiersEvaluateur();
        dossiersEvaluateur1.setId(1L);
        DossiersEvaluateur dossiersEvaluateur2 = new DossiersEvaluateur();
        dossiersEvaluateur2.setId(dossiersEvaluateur1.getId());
        assertThat(dossiersEvaluateur1).isEqualTo(dossiersEvaluateur2);
        dossiersEvaluateur2.setId(2L);
        assertThat(dossiersEvaluateur1).isNotEqualTo(dossiersEvaluateur2);
        dossiersEvaluateur1.setId(null);
        assertThat(dossiersEvaluateur1).isNotEqualTo(dossiersEvaluateur2);
    }
}
