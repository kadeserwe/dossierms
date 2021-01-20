package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CategorieAppelOffreTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CategorieAppelOffre.class);
        CategorieAppelOffre categorieAppelOffre1 = new CategorieAppelOffre();
        categorieAppelOffre1.setId(1L);
        CategorieAppelOffre categorieAppelOffre2 = new CategorieAppelOffre();
        categorieAppelOffre2.setId(categorieAppelOffre1.getId());
        assertThat(categorieAppelOffre1).isEqualTo(categorieAppelOffre2);
        categorieAppelOffre2.setId(2L);
        assertThat(categorieAppelOffre1).isNotEqualTo(categorieAppelOffre2);
        categorieAppelOffre1.setId(null);
        assertThat(categorieAppelOffre1).isNotEqualTo(categorieAppelOffre2);
    }
}
