package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DossiersSouscritereMapperTest {

    private DossiersSouscritereMapper dossiersSouscritereMapper;

    @BeforeEach
    public void setUp() {
        dossiersSouscritereMapper = new DossiersSouscritereMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dossiersSouscritereMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dossiersSouscritereMapper.fromId(null)).isNull();
    }
}
