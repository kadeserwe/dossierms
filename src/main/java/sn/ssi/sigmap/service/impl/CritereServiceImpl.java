package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.CritereService;
import sn.ssi.sigmap.domain.Critere;
import sn.ssi.sigmap.repository.CritereRepository;
import sn.ssi.sigmap.service.dto.CritereDTO;
import sn.ssi.sigmap.service.mapper.CritereMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Critere}.
 */
@Service
@Transactional
public class CritereServiceImpl implements CritereService {

    private final Logger log = LoggerFactory.getLogger(CritereServiceImpl.class);

    private final CritereRepository critereRepository;

    private final CritereMapper critereMapper;

    public CritereServiceImpl(CritereRepository critereRepository, CritereMapper critereMapper) {
        this.critereRepository = critereRepository;
        this.critereMapper = critereMapper;
    }

    @Override
    public CritereDTO save(CritereDTO critereDTO) {
        log.debug("Request to save Critere : {}", critereDTO);
        Critere critere = critereMapper.toEntity(critereDTO);
        critere = critereRepository.save(critere);
        return critereMapper.toDto(critere);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CritereDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Criteres");
        return critereRepository.findAll(pageable)
            .map(critereMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CritereDTO> findOne(Long id) {
        log.debug("Request to get Critere : {}", id);
        return critereRepository.findById(id)
            .map(critereMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Critere : {}", id);
        critereRepository.deleteById(id);
    }
}
