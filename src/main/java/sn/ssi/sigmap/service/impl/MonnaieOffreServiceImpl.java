package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.MonnaieOffreService;
import sn.ssi.sigmap.domain.MonnaieOffre;
import sn.ssi.sigmap.repository.MonnaieOffreRepository;
import sn.ssi.sigmap.service.dto.MonnaieOffreDTO;
import sn.ssi.sigmap.service.mapper.MonnaieOffreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MonnaieOffre}.
 */
@Service
@Transactional
public class MonnaieOffreServiceImpl implements MonnaieOffreService {

    private final Logger log = LoggerFactory.getLogger(MonnaieOffreServiceImpl.class);

    private final MonnaieOffreRepository monnaieOffreRepository;

    private final MonnaieOffreMapper monnaieOffreMapper;

    public MonnaieOffreServiceImpl(MonnaieOffreRepository monnaieOffreRepository, MonnaieOffreMapper monnaieOffreMapper) {
        this.monnaieOffreRepository = monnaieOffreRepository;
        this.monnaieOffreMapper = monnaieOffreMapper;
    }

    @Override
    public MonnaieOffreDTO save(MonnaieOffreDTO monnaieOffreDTO) {
        log.debug("Request to save MonnaieOffre : {}", monnaieOffreDTO);
        MonnaieOffre monnaieOffre = monnaieOffreMapper.toEntity(monnaieOffreDTO);
        monnaieOffre = monnaieOffreRepository.save(monnaieOffre);
        return monnaieOffreMapper.toDto(monnaieOffre);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MonnaieOffreDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MonnaieOffres");
        return monnaieOffreRepository.findAll(pageable)
            .map(monnaieOffreMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<MonnaieOffreDTO> findOne(Long id) {
        log.debug("Request to get MonnaieOffre : {}", id);
        return monnaieOffreRepository.findById(id)
            .map(monnaieOffreMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete MonnaieOffre : {}", id);
        monnaieOffreRepository.deleteById(id);
    }
}
