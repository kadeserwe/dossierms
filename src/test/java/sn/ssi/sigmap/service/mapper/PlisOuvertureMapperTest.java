package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlisOuvertureMapperTest {

    private PlisOuvertureMapper plisOuvertureMapper;

    @BeforeEach
    public void setUp() {
        plisOuvertureMapper = new PlisOuvertureMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(plisOuvertureMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(plisOuvertureMapper.fromId(null)).isNull();
    }
}
