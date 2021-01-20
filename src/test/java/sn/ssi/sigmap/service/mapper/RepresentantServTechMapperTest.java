package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RepresentantServTechMapperTest {

    private RepresentantServTechMapper representantServTechMapper;

    @BeforeEach
    public void setUp() {
        representantServTechMapper = new RepresentantServTechMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(representantServTechMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(representantServTechMapper.fromId(null)).isNull();
    }
}
