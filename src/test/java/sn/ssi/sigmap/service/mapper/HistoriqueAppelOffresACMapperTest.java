package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HistoriqueAppelOffresACMapperTest {

    private HistoriqueAppelOffresACMapper historiqueAppelOffresACMapper;

    @BeforeEach
    public void setUp() {
        historiqueAppelOffresACMapper = new HistoriqueAppelOffresACMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(historiqueAppelOffresACMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(historiqueAppelOffresACMapper.fromId(null)).isNull();
    }
}
