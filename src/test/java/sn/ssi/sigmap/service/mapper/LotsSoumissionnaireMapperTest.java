package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LotsSoumissionnaireMapperTest {

    private LotsSoumissionnaireMapper lotsSoumissionnaireMapper;

    @BeforeEach
    public void setUp() {
        lotsSoumissionnaireMapper = new LotsSoumissionnaireMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(lotsSoumissionnaireMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(lotsSoumissionnaireMapper.fromId(null)).isNull();
    }
}
