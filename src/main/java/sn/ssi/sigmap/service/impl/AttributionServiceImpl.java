package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.AttributionService;
import sn.ssi.sigmap.domain.Attribution;
import sn.ssi.sigmap.repository.AttributionRepository;
import sn.ssi.sigmap.service.dto.AttributionDTO;
import sn.ssi.sigmap.service.mapper.AttributionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Attribution}.
 */
@Service
@Transactional
public class AttributionServiceImpl implements AttributionService {

    private final Logger log = LoggerFactory.getLogger(AttributionServiceImpl.class);

    private final AttributionRepository attributionRepository;

    private final AttributionMapper attributionMapper;

    public AttributionServiceImpl(AttributionRepository attributionRepository, AttributionMapper attributionMapper) {
        this.attributionRepository = attributionRepository;
        this.attributionMapper = attributionMapper;
    }

    @Override
    public AttributionDTO save(AttributionDTO attributionDTO) {
        log.debug("Request to save Attribution : {}", attributionDTO);
        Attribution attribution = attributionMapper.toEntity(attributionDTO);
        attribution = attributionRepository.save(attribution);
        return attributionMapper.toDto(attribution);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AttributionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Attributions");
        return attributionRepository.findAll(pageable)
            .map(attributionMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<AttributionDTO> findOne(Long id) {
        log.debug("Request to get Attribution : {}", id);
        return attributionRepository.findById(id)
            .map(attributionMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Attribution : {}", id);
        attributionRepository.deleteById(id);
    }
}
