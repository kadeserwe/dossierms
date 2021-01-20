package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CategorieAppelOffreMapperTest {

    private CategorieAppelOffreMapper categorieAppelOffreMapper;

    @BeforeEach
    public void setUp() {
        categorieAppelOffreMapper = new CategorieAppelOffreMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(categorieAppelOffreMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(categorieAppelOffreMapper.fromId(null)).isNull();
    }
}
