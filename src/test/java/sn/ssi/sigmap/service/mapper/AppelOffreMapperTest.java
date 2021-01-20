package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppelOffreMapperTest {

    private AppelOffreMapper appelOffreMapper;

    @BeforeEach
    public void setUp() {
        appelOffreMapper = new AppelOffreMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appelOffreMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appelOffreMapper.fromId(null)).isNull();
    }
}
