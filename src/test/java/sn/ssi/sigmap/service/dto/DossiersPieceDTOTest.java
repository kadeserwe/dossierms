package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class DossiersPieceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DossiersPieceDTO.class);
        DossiersPieceDTO dossiersPieceDTO1 = new DossiersPieceDTO();
        dossiersPieceDTO1.setId(1L);
        DossiersPieceDTO dossiersPieceDTO2 = new DossiersPieceDTO();
        assertThat(dossiersPieceDTO1).isNotEqualTo(dossiersPieceDTO2);
        dossiersPieceDTO2.setId(dossiersPieceDTO1.getId());
        assertThat(dossiersPieceDTO1).isEqualTo(dossiersPieceDTO2);
        dossiersPieceDTO2.setId(2L);
        assertThat(dossiersPieceDTO1).isNotEqualTo(dossiersPieceDTO2);
        dossiersPieceDTO1.setId(null);
        assertThat(dossiersPieceDTO1).isNotEqualTo(dossiersPieceDTO2);
    }
}
