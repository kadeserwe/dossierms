package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DossiersCommissionsMarcheMapperTest {

    private DossiersCommissionsMarcheMapper dossiersCommissionsMarcheMapper;

    @BeforeEach
    public void setUp() {
        dossiersCommissionsMarcheMapper = new DossiersCommissionsMarcheMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dossiersCommissionsMarcheMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dossiersCommissionsMarcheMapper.fromId(null)).isNull();
    }
}
