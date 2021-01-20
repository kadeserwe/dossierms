package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.AvisAttributionService;
import sn.ssi.sigmap.domain.AvisAttribution;
import sn.ssi.sigmap.repository.AvisAttributionRepository;
import sn.ssi.sigmap.service.dto.AvisAttributionDTO;
import sn.ssi.sigmap.service.mapper.AvisAttributionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AvisAttribution}.
 */
@Service
@Transactional
public class AvisAttributionServiceImpl implements AvisAttributionService {

    private final Logger log = LoggerFactory.getLogger(AvisAttributionServiceImpl.class);

    private final AvisAttributionRepository avisAttributionRepository;

    private final AvisAttributionMapper avisAttributionMapper;

    public AvisAttributionServiceImpl(AvisAttributionRepository avisAttributionRepository, AvisAttributionMapper avisAttributionMapper) {
        this.avisAttributionRepository = avisAttributionRepository;
        this.avisAttributionMapper = avisAttributionMapper;
    }

    @Override
    public AvisAttributionDTO save(AvisAttributionDTO avisAttributionDTO) {
        log.debug("Request to save AvisAttribution : {}", avisAttributionDTO);
        AvisAttribution avisAttribution = avisAttributionMapper.toEntity(avisAttributionDTO);
        avisAttribution = avisAttributionRepository.save(avisAttribution);
        return avisAttributionMapper.toDto(avisAttribution);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AvisAttributionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AvisAttributions");
        return avisAttributionRepository.findAll(pageable)
            .map(avisAttributionMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<AvisAttributionDTO> findOne(Long id) {
        log.debug("Request to get AvisAttribution : {}", id);
        return avisAttributionRepository.findById(id)
            .map(avisAttributionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AvisAttribution : {}", id);
        avisAttributionRepository.deleteById(id);
    }
}
