package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PresenceOuvertureMapperTest {

    private PresenceOuvertureMapper presenceOuvertureMapper;

    @BeforeEach
    public void setUp() {
        presenceOuvertureMapper = new PresenceOuvertureMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(presenceOuvertureMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(presenceOuvertureMapper.fromId(null)).isNull();
    }
}
