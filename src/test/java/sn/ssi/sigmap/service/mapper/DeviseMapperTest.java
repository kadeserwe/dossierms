package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DeviseMapperTest {

    private DeviseMapper deviseMapper;

    @BeforeEach
    public void setUp() {
        deviseMapper = new DeviseMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(deviseMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(deviseMapper.fromId(null)).isNull();
    }
}
