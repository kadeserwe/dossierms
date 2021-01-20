package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.GarantiesSoumissionnaireService;
import sn.ssi.sigmap.domain.GarantiesSoumissionnaire;
import sn.ssi.sigmap.repository.GarantiesSoumissionnaireRepository;
import sn.ssi.sigmap.service.dto.GarantiesSoumissionnaireDTO;
import sn.ssi.sigmap.service.mapper.GarantiesSoumissionnaireMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GarantiesSoumissionnaire}.
 */
@Service
@Transactional
public class GarantiesSoumissionnaireServiceImpl implements GarantiesSoumissionnaireService {

    private final Logger log = LoggerFactory.getLogger(GarantiesSoumissionnaireServiceImpl.class);

    private final GarantiesSoumissionnaireRepository garantiesSoumissionnaireRepository;

    private final GarantiesSoumissionnaireMapper garantiesSoumissionnaireMapper;

    public GarantiesSoumissionnaireServiceImpl(GarantiesSoumissionnaireRepository garantiesSoumissionnaireRepository, GarantiesSoumissionnaireMapper garantiesSoumissionnaireMapper) {
        this.garantiesSoumissionnaireRepository = garantiesSoumissionnaireRepository;
        this.garantiesSoumissionnaireMapper = garantiesSoumissionnaireMapper;
    }

    @Override
    public GarantiesSoumissionnaireDTO save(GarantiesSoumissionnaireDTO garantiesSoumissionnaireDTO) {
        log.debug("Request to save GarantiesSoumissionnaire : {}", garantiesSoumissionnaireDTO);
        GarantiesSoumissionnaire garantiesSoumissionnaire = garantiesSoumissionnaireMapper.toEntity(garantiesSoumissionnaireDTO);
        garantiesSoumissionnaire = garantiesSoumissionnaireRepository.save(garantiesSoumissionnaire);
        return garantiesSoumissionnaireMapper.toDto(garantiesSoumissionnaire);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GarantiesSoumissionnaireDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GarantiesSoumissionnaires");
        return garantiesSoumissionnaireRepository.findAll(pageable)
            .map(garantiesSoumissionnaireMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<GarantiesSoumissionnaireDTO> findOne(Long id) {
        log.debug("Request to get GarantiesSoumissionnaire : {}", id);
        return garantiesSoumissionnaireRepository.findById(id)
            .map(garantiesSoumissionnaireMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete GarantiesSoumissionnaire : {}", id);
        garantiesSoumissionnaireRepository.deleteById(id);
    }
}
