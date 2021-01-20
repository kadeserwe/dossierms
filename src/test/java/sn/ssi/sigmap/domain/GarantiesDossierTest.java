package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class GarantiesDossierTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GarantiesDossier.class);
        GarantiesDossier garantiesDossier1 = new GarantiesDossier();
        garantiesDossier1.setId(1L);
        GarantiesDossier garantiesDossier2 = new GarantiesDossier();
        garantiesDossier2.setId(garantiesDossier1.getId());
        assertThat(garantiesDossier1).isEqualTo(garantiesDossier2);
        garantiesDossier2.setId(2L);
        assertThat(garantiesDossier1).isNotEqualTo(garantiesDossier2);
        garantiesDossier1.setId(null);
        assertThat(garantiesDossier1).isNotEqualTo(garantiesDossier2);
    }
}
