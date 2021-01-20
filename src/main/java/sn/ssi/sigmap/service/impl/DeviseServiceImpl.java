package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DeviseService;
import sn.ssi.sigmap.domain.Devise;
import sn.ssi.sigmap.repository.DeviseRepository;
import sn.ssi.sigmap.service.dto.DeviseDTO;
import sn.ssi.sigmap.service.mapper.DeviseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Devise}.
 */
@Service
@Transactional
public class DeviseServiceImpl implements DeviseService {

    private final Logger log = LoggerFactory.getLogger(DeviseServiceImpl.class);

    private final DeviseRepository deviseRepository;

    private final DeviseMapper deviseMapper;

    public DeviseServiceImpl(DeviseRepository deviseRepository, DeviseMapper deviseMapper) {
        this.deviseRepository = deviseRepository;
        this.deviseMapper = deviseMapper;
    }

    @Override
    public DeviseDTO save(DeviseDTO deviseDTO) {
        log.debug("Request to save Devise : {}", deviseDTO);
        Devise devise = deviseMapper.toEntity(deviseDTO);
        devise = deviseRepository.save(devise);
        return deviseMapper.toDto(devise);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DeviseDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Devises");
        return deviseRepository.findAll(pageable)
            .map(deviseMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DeviseDTO> findOne(Long id) {
        log.debug("Request to get Devise : {}", id);
        return deviseRepository.findById(id)
            .map(deviseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Devise : {}", id);
        deviseRepository.deleteById(id);
    }
}
