package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RetraitRegistreDAOMapperTest {

    private RetraitRegistreDAOMapper retraitRegistreDAOMapper;

    @BeforeEach
    public void setUp() {
        retraitRegistreDAOMapper = new RetraitRegistreDAOMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(retraitRegistreDAOMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(retraitRegistreDAOMapper.fromId(null)).isNull();
    }
}
