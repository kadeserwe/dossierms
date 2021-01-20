package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CatFournisseurMapperTest {

    private CatFournisseurMapper catFournisseurMapper;

    @BeforeEach
    public void setUp() {
        catFournisseurMapper = new CatFournisseurMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(catFournisseurMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(catFournisseurMapper.fromId(null)).isNull();
    }
}
