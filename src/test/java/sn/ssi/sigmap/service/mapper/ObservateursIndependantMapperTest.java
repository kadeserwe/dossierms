package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ObservateursIndependantMapperTest {

    private ObservateursIndependantMapper observateursIndependantMapper;

    @BeforeEach
    public void setUp() {
        observateursIndependantMapper = new ObservateursIndependantMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(observateursIndependantMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(observateursIndependantMapper.fromId(null)).isNull();
    }
}
