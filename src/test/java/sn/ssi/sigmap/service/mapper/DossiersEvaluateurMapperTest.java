package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DossiersEvaluateurMapperTest {

    private DossiersEvaluateurMapper dossiersEvaluateurMapper;

    @BeforeEach
    public void setUp() {
        dossiersEvaluateurMapper = new DossiersEvaluateurMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dossiersEvaluateurMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dossiersEvaluateurMapper.fromId(null)).isNull();
    }
}
