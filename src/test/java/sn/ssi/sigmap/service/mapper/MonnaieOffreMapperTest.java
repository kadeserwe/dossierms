package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MonnaieOffreMapperTest {

    private MonnaieOffreMapper monnaieOffreMapper;

    @BeforeEach
    public void setUp() {
        monnaieOffreMapper = new MonnaieOffreMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(monnaieOffreMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(monnaieOffreMapper.fromId(null)).isNull();
    }
}
