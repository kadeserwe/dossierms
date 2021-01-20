package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.CritereQualifiSoumService;
import sn.ssi.sigmap.domain.CritereQualifiSoum;
import sn.ssi.sigmap.repository.CritereQualifiSoumRepository;
import sn.ssi.sigmap.service.dto.CritereQualifiSoumDTO;
import sn.ssi.sigmap.service.mapper.CritereQualifiSoumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CritereQualifiSoum}.
 */
@Service
@Transactional
public class CritereQualifiSoumServiceImpl implements CritereQualifiSoumService {

    private final Logger log = LoggerFactory.getLogger(CritereQualifiSoumServiceImpl.class);

    private final CritereQualifiSoumRepository critereQualifiSoumRepository;

    private final CritereQualifiSoumMapper critereQualifiSoumMapper;

    public CritereQualifiSoumServiceImpl(CritereQualifiSoumRepository critereQualifiSoumRepository, CritereQualifiSoumMapper critereQualifiSoumMapper) {
        this.critereQualifiSoumRepository = critereQualifiSoumRepository;
        this.critereQualifiSoumMapper = critereQualifiSoumMapper;
    }

    @Override
    public CritereQualifiSoumDTO save(CritereQualifiSoumDTO critereQualifiSoumDTO) {
        log.debug("Request to save CritereQualifiSoum : {}", critereQualifiSoumDTO);
        CritereQualifiSoum critereQualifiSoum = critereQualifiSoumMapper.toEntity(critereQualifiSoumDTO);
        critereQualifiSoum = critereQualifiSoumRepository.save(critereQualifiSoum);
        return critereQualifiSoumMapper.toDto(critereQualifiSoum);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CritereQualifiSoumDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CritereQualifiSoums");
        return critereQualifiSoumRepository.findAll(pageable)
            .map(critereQualifiSoumMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CritereQualifiSoumDTO> findOne(Long id) {
        log.debug("Request to get CritereQualifiSoum : {}", id);
        return critereQualifiSoumRepository.findById(id)
            .map(critereQualifiSoumMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CritereQualifiSoum : {}", id);
        critereQualifiSoumRepository.deleteById(id);
    }
}
