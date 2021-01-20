package sn.ssi.sigmap.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class CatFournisseurTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CatFournisseur.class);
        CatFournisseur catFournisseur1 = new CatFournisseur();
        catFournisseur1.setId(1L);
        CatFournisseur catFournisseur2 = new CatFournisseur();
        catFournisseur2.setId(catFournisseur1.getId());
        assertThat(catFournisseur1).isEqualTo(catFournisseur2);
        catFournisseur2.setId(2L);
        assertThat(catFournisseur1).isNotEqualTo(catFournisseur2);
        catFournisseur1.setId(null);
        assertThat(catFournisseur1).isNotEqualTo(catFournisseur2);
    }
}
