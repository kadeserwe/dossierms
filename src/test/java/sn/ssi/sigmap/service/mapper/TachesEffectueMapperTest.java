package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TachesEffectueMapperTest {

    private TachesEffectueMapper tachesEffectueMapper;

    @BeforeEach
    public void setUp() {
        tachesEffectueMapper = new TachesEffectueMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(tachesEffectueMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(tachesEffectueMapper.fromId(null)).isNull();
    }
}
