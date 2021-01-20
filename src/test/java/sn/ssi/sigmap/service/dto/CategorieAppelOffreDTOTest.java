package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CategorieAppelOffreDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CategorieAppelOffreDTO.class);
        CategorieAppelOffreDTO categorieAppelOffreDTO1 = new CategorieAppelOffreDTO();
        categorieAppelOffreDTO1.setId(1L);
        CategorieAppelOffreDTO categorieAppelOffreDTO2 = new CategorieAppelOffreDTO();
        assertThat(categorieAppelOffreDTO1).isNotEqualTo(categorieAppelOffreDTO2);
        categorieAppelOffreDTO2.setId(categorieAppelOffreDTO1.getId());
        assertThat(categorieAppelOffreDTO1).isEqualTo(categorieAppelOffreDTO2);
        categorieAppelOffreDTO2.setId(2L);
        assertThat(categorieAppelOffreDTO1).isNotEqualTo(categorieAppelOffreDTO2);
        categorieAppelOffreDTO1.setId(null);
        assertThat(categorieAppelOffreDTO1).isNotEqualTo(categorieAppelOffreDTO2);
    }
}
