package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.RepresentantServTechService;
import sn.ssi.sigmap.domain.RepresentantServTech;
import sn.ssi.sigmap.repository.RepresentantServTechRepository;
import sn.ssi.sigmap.service.dto.RepresentantServTechDTO;
import sn.ssi.sigmap.service.mapper.RepresentantServTechMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RepresentantServTech}.
 */
@Service
@Transactional
public class RepresentantServTechServiceImpl implements RepresentantServTechService {

    private final Logger log = LoggerFactory.getLogger(RepresentantServTechServiceImpl.class);

    private final RepresentantServTechRepository representantServTechRepository;

    private final RepresentantServTechMapper representantServTechMapper;

    public RepresentantServTechServiceImpl(RepresentantServTechRepository representantServTechRepository, RepresentantServTechMapper representantServTechMapper) {
        this.representantServTechRepository = representantServTechRepository;
        this.representantServTechMapper = representantServTechMapper;
    }

    @Override
    public RepresentantServTechDTO save(RepresentantServTechDTO representantServTechDTO) {
        log.debug("Request to save RepresentantServTech : {}", representantServTechDTO);
        RepresentantServTech representantServTech = representantServTechMapper.toEntity(representantServTechDTO);
        representantServTech = representantServTechRepository.save(representantServTech);
        return representantServTechMapper.toDto(representantServTech);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RepresentantServTechDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RepresentantServTeches");
        return representantServTechRepository.findAll(pageable)
            .map(representantServTechMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<RepresentantServTechDTO> findOne(Long id) {
        log.debug("Request to get RepresentantServTech : {}", id);
        return representantServTechRepository.findById(id)
            .map(representantServTechMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RepresentantServTech : {}", id);
        representantServTechRepository.deleteById(id);
    }
}
