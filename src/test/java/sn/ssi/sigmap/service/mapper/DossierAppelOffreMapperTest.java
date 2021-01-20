package sn.ssi.sigmap.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DossierAppelOffreMapperTest {

    private DossierAppelOffreMapper dossierAppelOffreMapper;

    @BeforeEach
    public void setUp() {
        dossierAppelOffreMapper = new DossierAppelOffreMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(dossierAppelOffreMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(dossierAppelOffreMapper.fromId(null)).isNull();
    }
}
