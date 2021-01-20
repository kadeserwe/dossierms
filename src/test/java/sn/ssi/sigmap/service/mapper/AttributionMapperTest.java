package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AttributionMapperTest {

    private AttributionMapper attributionMapper;

    @BeforeEach
    public void setUp() {
        attributionMapper = new AttributionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(attributionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(attributionMapper.fromId(null)).isNull();
    }
}
