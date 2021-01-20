package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.TachesEffectueService;
import sn.ssi.sigmap.domain.TachesEffectue;
import sn.ssi.sigmap.repository.TachesEffectueRepository;
import sn.ssi.sigmap.service.dto.TachesEffectueDTO;
import sn.ssi.sigmap.service.mapper.TachesEffectueMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link TachesEffectue}.
 */
@Service
@Transactional
public class TachesEffectueServiceImpl implements TachesEffectueService {

    private final Logger log = LoggerFactory.getLogger(TachesEffectueServiceImpl.class);

    private final TachesEffectueRepository tachesEffectueRepository;

    private final TachesEffectueMapper tachesEffectueMapper;

    public TachesEffectueServiceImpl(TachesEffectueRepository tachesEffectueRepository, TachesEffectueMapper tachesEffectueMapper) {
        this.tachesEffectueRepository = tachesEffectueRepository;
        this.tachesEffectueMapper = tachesEffectueMapper;
    }

    @Override
    public TachesEffectueDTO save(TachesEffectueDTO tachesEffectueDTO) {
        log.debug("Request to save TachesEffectue : {}", tachesEffectueDTO);
        TachesEffectue tachesEffectue = tachesEffectueMapper.toEntity(tachesEffectueDTO);
        tachesEffectue = tachesEffectueRepository.save(tachesEffectue);
        return tachesEffectueMapper.toDto(tachesEffectue);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TachesEffectueDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TachesEffectues");
        return tachesEffectueRepository.findAll(pageable)
            .map(tachesEffectueMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<TachesEffectueDTO> findOne(Long id) {
        log.debug("Request to get TachesEffectue : {}", id);
        return tachesEffectueRepository.findById(id)
            .map(tachesEffectueMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TachesEffectue : {}", id);
        tachesEffectueRepository.deleteById(id);
    }
}
