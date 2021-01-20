package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class HistoriqueAppelOffresACTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(HistoriqueAppelOffresAC.class);
        HistoriqueAppelOffresAC historiqueAppelOffresAC1 = new HistoriqueAppelOffresAC();
        historiqueAppelOffresAC1.setId(1L);
        HistoriqueAppelOffresAC historiqueAppelOffresAC2 = new HistoriqueAppelOffresAC();
        historiqueAppelOffresAC2.setId(historiqueAppelOffresAC1.getId());
        assertThat(historiqueAppelOffresAC1).isEqualTo(historiqueAppelOffresAC2);
        historiqueAppelOffresAC2.setId(2L);
        assertThat(historiqueAppelOffresAC1).isNotEqualTo(historiqueAppelOffresAC2);
        historiqueAppelOffresAC1.setId(null);
        assertThat(historiqueAppelOffresAC1).isNotEqualTo(historiqueAppelOffresAC2);
    }
}
