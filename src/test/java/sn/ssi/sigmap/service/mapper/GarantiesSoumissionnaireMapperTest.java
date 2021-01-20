package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GarantiesSoumissionnaireMapperTest {

    private GarantiesSoumissionnaireMapper garantiesSoumissionnaireMapper;

    @BeforeEach
    public void setUp() {
        garantiesSoumissionnaireMapper = new GarantiesSoumissionnaireMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(garantiesSoumissionnaireMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(garantiesSoumissionnaireMapper.fromId(null)).isNull();
    }
}
