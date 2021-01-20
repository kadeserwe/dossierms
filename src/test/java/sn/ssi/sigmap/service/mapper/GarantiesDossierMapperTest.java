package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GarantiesDossierMapperTest {

    private GarantiesDossierMapper garantiesDossierMapper;

    @BeforeEach
    public void setUp() {
        garantiesDossierMapper = new GarantiesDossierMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(garantiesDossierMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(garantiesDossierMapper.fromId(null)).isNull();
    }
}
