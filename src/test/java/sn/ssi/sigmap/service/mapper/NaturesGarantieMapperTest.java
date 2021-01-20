package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NaturesGarantieMapperTest {

    private NaturesGarantieMapper naturesGarantieMapper;

    @BeforeEach
    public void setUp() {
        naturesGarantieMapper = new NaturesGarantieMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(naturesGarantieMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(naturesGarantieMapper.fromId(null)).isNull();
    }
}
