package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PiecesRecusMapperTest {

    private PiecesRecusMapper piecesRecusMapper;

    @BeforeEach
    public void setUp() {
        piecesRecusMapper = new PiecesRecusMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(piecesRecusMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(piecesRecusMapper.fromId(null)).isNull();
    }
}
