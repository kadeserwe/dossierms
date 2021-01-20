package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CritereMapperTest {

    private CritereMapper critereMapper;

    @BeforeEach
    public void setUp() {
        critereMapper = new CritereMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(critereMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(critereMapper.fromId(null)).isNull();
    }
}
