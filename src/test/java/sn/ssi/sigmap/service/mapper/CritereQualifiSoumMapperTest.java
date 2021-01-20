package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CritereQualifiSoumMapperTest {

    private CritereQualifiSoumMapper critereQualifiSoumMapper;

    @BeforeEach
    public void setUp() {
        critereQualifiSoumMapper = new CritereQualifiSoumMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(critereQualifiSoumMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(critereQualifiSoumMapper.fromId(null)).isNull();
    }
}
