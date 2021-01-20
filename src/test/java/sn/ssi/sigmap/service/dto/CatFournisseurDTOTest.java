package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CatFournisseurDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CatFournisseurDTO.class);
        CatFournisseurDTO catFournisseurDTO1 = new CatFournisseurDTO();
        catFournisseurDTO1.setId(1L);
        CatFournisseurDTO catFournisseurDTO2 = new CatFournisseurDTO();
        assertThat(catFournisseurDTO1).isNotEqualTo(catFournisseurDTO2);
        catFournisseurDTO2.setId(catFournisseurDTO1.getId());
        assertThat(catFournisseurDTO1).isEqualTo(catFournisseurDTO2);
        catFournisseurDTO2.setId(2L);
        assertThat(catFournisseurDTO1).isNotEqualTo(catFournisseurDTO2);
        catFournisseurDTO1.setId(null);
        assertThat(catFournisseurDTO1).isNotEqualTo(catFournisseurDTO2);
    }
}
