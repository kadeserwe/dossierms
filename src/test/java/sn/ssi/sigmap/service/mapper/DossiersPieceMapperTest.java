package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DossiersPieceMapperTest {

    private DossiersPieceMapper dossiersPieceMapper;

    @BeforeEach
    public void setUp() {
        dossiersPieceMapper = new DossiersPieceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dossiersPieceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dossiersPieceMapper.fromId(null)).isNull();
    }
}
