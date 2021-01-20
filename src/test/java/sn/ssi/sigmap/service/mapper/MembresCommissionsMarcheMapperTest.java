package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MembresCommissionsMarcheMapperTest {

    private MembresCommissionsMarcheMapper membresCommissionsMarcheMapper;

    @BeforeEach
    public void setUp() {
        membresCommissionsMarcheMapper = new MembresCommissionsMarcheMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(membresCommissionsMarcheMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(membresCommissionsMarcheMapper.fromId(null)).isNull();
    }
}
