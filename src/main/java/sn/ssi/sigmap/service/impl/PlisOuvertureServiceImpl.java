package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.PlisOuvertureService;
import sn.ssi.sigmap.domain.PlisOuverture;
import sn.ssi.sigmap.repository.PlisOuvertureRepository;
import sn.ssi.sigmap.service.dto.PlisOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PlisOuvertureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PlisOuverture}.
 */
@Service
@Transactional
public class PlisOuvertureServiceImpl implements PlisOuvertureService {

    private final Logger log = LoggerFactory.getLogger(PlisOuvertureServiceImpl.class);

    private final PlisOuvertureRepository plisOuvertureRepository;

    private final PlisOuvertureMapper plisOuvertureMapper;

    public PlisOuvertureServiceImpl(PlisOuvertureRepository plisOuvertureRepository, PlisOuvertureMapper plisOuvertureMapper) {
        this.plisOuvertureRepository = plisOuvertureRepository;
        this.plisOuvertureMapper = plisOuvertureMapper;
    }

    @Override
    public PlisOuvertureDTO save(PlisOuvertureDTO plisOuvertureDTO) {
        log.debug("Request to save PlisOuverture : {}", plisOuvertureDTO);
        PlisOuverture plisOuverture = plisOuvertureMapper.toEntity(plisOuvertureDTO);
        plisOuverture = plisOuvertureRepository.save(plisOuverture);
        return plisOuvertureMapper.toDto(plisOuverture);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PlisOuvertureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PlisOuvertures");
        return plisOuvertureRepository.findAll(pageable)
            .map(plisOuvertureMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PlisOuvertureDTO> findOne(Long id) {
        log.debug("Request to get PlisOuverture : {}", id);
        return plisOuvertureRepository.findById(id)
            .map(plisOuvertureMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PlisOuverture : {}", id);
        plisOuvertureRepository.deleteById(id);
    }
}
