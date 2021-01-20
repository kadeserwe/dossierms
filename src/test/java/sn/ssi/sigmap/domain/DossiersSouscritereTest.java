package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersSouscritereTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersSouscritere.class);
        DossiersSouscritere dossiersSouscritere1 = new DossiersSouscritere();
        dossiersSouscritere1.setId(1L);
        DossiersSouscritere dossiersSouscritere2 = new DossiersSouscritere();
        dossiersSouscritere2.setId(dossiersSouscritere1.getId());
        assertThat(dossiersSouscritere1).isEqualTo(dossiersSouscritere2);
        dossiersSouscritere2.setId(2L);
        assertThat(dossiersSouscritere1).isNotEqualTo(dossiersSouscritere2);
        dossiersSouscritere1.setId(null);
        assertThat(dossiersSouscritere1).isNotEqualTo(dossiersSouscritere2);
    }
}
