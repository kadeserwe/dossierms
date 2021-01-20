package sn.ssi.sigmap.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.ssi.sigmap.web.rest.TestUtil;

public class TachesEffectueDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TachesEffectueDTO.class);
        TachesEffectueDTO tachesEffectueDTO1 = new TachesEffectueDTO();
        tachesEffectueDTO1.setId(1L);
        TachesEffectueDTO tachesEffectueDTO2 = new TachesEffectueDTO();
        assertThat(tachesEffectueDTO1).isNotEqualTo(tachesEffectueDTO2);
        tachesEffectueDTO2.setId(tachesEffectueDTO1.getId());
        assertThat(tachesEffectueDTO1).isEqualTo(tachesEffectueDTO2);
        tachesEffectueDTO2.setId(2L);
        assertThat(tachesEffectueDTO1).isNotEqualTo(tachesEffectueDTO2);
        tachesEffectueDTO1.setId(null);
        assertThat(tachesEffectueDTO1).isNotEqualTo(tachesEffectueDTO2);
    }
}
