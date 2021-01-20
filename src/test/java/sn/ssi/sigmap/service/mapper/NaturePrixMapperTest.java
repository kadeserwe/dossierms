package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NaturePrixMapperTest {

    private NaturePrixMapper naturePrixMapper;

    @BeforeEach
    public void setUp() {
        naturePrixMapper = new NaturePrixMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(naturePrixMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(naturePrixMapper.fromId(null)).isNull();
    }
}
