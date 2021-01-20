package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.PresenceOuvertureService;
import sn.ssi.sigmap.domain.PresenceOuverture;
import sn.ssi.sigmap.repository.PresenceOuvertureRepository;
import sn.ssi.sigmap.service.dto.PresenceOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PresenceOuvertureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PresenceOuverture}.
 */
@Service
@Transactional
public class PresenceOuvertureServiceImpl implements PresenceOuvertureService {

    private final Logger log = LoggerFactory.getLogger(PresenceOuvertureServiceImpl.class);

    private final PresenceOuvertureRepository presenceOuvertureRepository;

    private final PresenceOuvertureMapper presenceOuvertureMapper;

    public PresenceOuvertureServiceImpl(PresenceOuvertureRepository presenceOuvertureRepository, PresenceOuvertureMapper presenceOuvertureMapper) {
        this.presenceOuvertureRepository = presenceOuvertureRepository;
        this.presenceOuvertureMapper = presenceOuvertureMapper;
    }

    @Override
    public PresenceOuvertureDTO save(PresenceOuvertureDTO presenceOuvertureDTO) {
        log.debug("Request to save PresenceOuverture : {}", presenceOuvertureDTO);
        PresenceOuverture presenceOuverture = presenceOuvertureMapper.toEntity(presenceOuvertureDTO);
        presenceOuverture = presenceOuvertureRepository.save(presenceOuverture);
        return presenceOuvertureMapper.toDto(presenceOuverture);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PresenceOuvertureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PresenceOuvertures");
        return presenceOuvertureRepository.findAll(pageable)
            .map(presenceOuvertureMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PresenceOuvertureDTO> findOne(Long id) {
        log.debug("Request to get PresenceOuverture : {}", id);
        return presenceOuvertureRepository.findById(id)
            .map(presenceOuvertureMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PresenceOuverture : {}", id);
        presenceOuvertureRepository.deleteById(id);
    }
}
