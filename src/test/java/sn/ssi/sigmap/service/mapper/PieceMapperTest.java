package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PieceMapperTest {

    private PieceMapper pieceMapper;

    @BeforeEach
    public void setUp() {
        pieceMapper = new PieceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(pieceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(pieceMapper.fromId(null)).isNull();
    }
}
