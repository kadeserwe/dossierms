package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.NaturePrixService;
import sn.ssi.sigmap.domain.NaturePrix;
import sn.ssi.sigmap.repository.NaturePrixRepository;
import sn.ssi.sigmap.service.dto.NaturePrixDTO;
import sn.ssi.sigmap.service.mapper.NaturePrixMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link NaturePrix}.
 */
@Service
@Transactional
public class NaturePrixServiceImpl implements NaturePrixService {

    private final Logger log = LoggerFactory.getLogger(NaturePrixServiceImpl.class);

    private final NaturePrixRepository naturePrixRepository;

    private final NaturePrixMapper naturePrixMapper;

    public NaturePrixServiceImpl(NaturePrixRepository naturePrixRepository, NaturePrixMapper naturePrixMapper) {
        this.naturePrixRepository = naturePrixRepository;
        this.naturePrixMapper = naturePrixMapper;
    }

    @Override
    public NaturePrixDTO save(NaturePrixDTO naturePrixDTO) {
        log.debug("Request to save NaturePrix : {}", naturePrixDTO);
        NaturePrix naturePrix = naturePrixMapper.toEntity(naturePrixDTO);
        naturePrix = naturePrixRepository.save(naturePrix);
        return naturePrixMapper.toDto(naturePrix);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NaturePrixDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NaturePrixes");
        return naturePrixRepository.findAll(pageable)
            .map(naturePrixMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<NaturePrixDTO> findOne(Long id) {
        log.debug("Request to get NaturePrix : {}", id);
        return naturePrixRepository.findById(id)
            .map(naturePrixMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete NaturePrix : {}", id);
        naturePrixRepository.deleteById(id);
    }
}
