package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.LotsSoumissionnaireService;
import sn.ssi.sigmap.domain.LotsSoumissionnaire;
import sn.ssi.sigmap.repository.LotsSoumissionnaireRepository;
import sn.ssi.sigmap.service.dto.LotsSoumissionnaireDTO;
import sn.ssi.sigmap.service.mapper.LotsSoumissionnaireMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link LotsSoumissionnaire}.
 */
@Service
@Transactional
public class LotsSoumissionnaireServiceImpl implements LotsSoumissionnaireService {

    private final Logger log = LoggerFactory.getLogger(LotsSoumissionnaireServiceImpl.class);

    private final LotsSoumissionnaireRepository lotsSoumissionnaireRepository;

    private final LotsSoumissionnaireMapper lotsSoumissionnaireMapper;

    public LotsSoumissionnaireServiceImpl(LotsSoumissionnaireRepository lotsSoumissionnaireRepository, LotsSoumissionnaireMapper lotsSoumissionnaireMapper) {
        this.lotsSoumissionnaireRepository = lotsSoumissionnaireRepository;
        this.lotsSoumissionnaireMapper = lotsSoumissionnaireMapper;
    }

    @Override
    public LotsSoumissionnaireDTO save(LotsSoumissionnaireDTO lotsSoumissionnaireDTO) {
        log.debug("Request to save LotsSoumissionnaire : {}", lotsSoumissionnaireDTO);
        LotsSoumissionnaire lotsSoumissionnaire = lotsSoumissionnaireMapper.toEntity(lotsSoumissionnaireDTO);
        lotsSoumissionnaire = lotsSoumissionnaireRepository.save(lotsSoumissionnaire);
        return lotsSoumissionnaireMapper.toDto(lotsSoumissionnaire);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LotsSoumissionnaireDTO> findAll(Pageable pageable) {
        log.debug("Request to get all LotsSoumissionnaires");
        return lotsSoumissionnaireRepository.findAll(pageable)
            .map(lotsSoumissionnaireMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<LotsSoumissionnaireDTO> findOne(Long id) {
        log.debug("Request to get LotsSoumissionnaire : {}", id);
        return lotsSoumissionnaireRepository.findById(id)
            .map(lotsSoumissionnaireMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete LotsSoumissionnaire : {}", id);
        lotsSoumissionnaireRepository.deleteById(id);
    }
}
