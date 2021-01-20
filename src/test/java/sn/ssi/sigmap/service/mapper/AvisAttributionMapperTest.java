package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AvisAttributionMapperTest {

    private AvisAttributionMapper avisAttributionMapper;

    @BeforeEach
    public void setUp() {
        avisAttributionMapper = new AvisAttributionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(avisAttributionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(avisAttributionMapper.fromId(null)).isNull();
    }
}
