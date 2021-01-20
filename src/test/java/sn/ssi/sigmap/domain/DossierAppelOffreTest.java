package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossierAppelOffreTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossierAppelOffre.class);
        DossierAppelOffre dossierAppelOffre1 = new DossierAppelOffre();
        dossierAppelOffre1.setId(1L);
        DossierAppelOffre dossierAppelOffre2 = new DossierAppelOffre();
        dossierAppelOffre2.setId(dossierAppelOffre1.getId());
        assertThat(dossierAppelOffre1).isEqualTo(dossierAppelOffre2);
        dossierAppelOffre2.setId(2L);
        assertThat(dossierAppelOffre1).isNotEqualTo(dossierAppelOffre2);
        dossierAppelOffre1.setId(null);
        assertThat(dossierAppelOffre1).isNotEqualTo(dossierAppelOffre2);
    }
}
