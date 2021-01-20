package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PiecesPlisOuvertureMapperTest {

    private PiecesPlisOuvertureMapper piecesPlisOuvertureMapper;

    @BeforeEach
    public void setUp() {
        piecesPlisOuvertureMapper = new PiecesPlisOuvertureMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(piecesPlisOuvertureMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(piecesPlisOuvertureMapper.fromId(null)).isNull();
    }
}
