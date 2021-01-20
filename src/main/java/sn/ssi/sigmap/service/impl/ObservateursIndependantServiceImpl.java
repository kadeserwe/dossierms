package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.ObservateursIndependantService;
import sn.ssi.sigmap.domain.ObservateursIndependant;
import sn.ssi.sigmap.repository.ObservateursIndependantRepository;
import sn.ssi.sigmap.service.dto.ObservateursIndependantDTO;
import sn.ssi.sigmap.service.mapper.ObservateursIndependantMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ObservateursIndependant}.
 */
@Service
@Transactional
public class ObservateursIndependantServiceImpl implements ObservateursIndependantService {

    private final Logger log = LoggerFactory.getLogger(ObservateursIndependantServiceImpl.class);

    private final ObservateursIndependantRepository observateursIndependantRepository;

    private final ObservateursIndependantMapper observateursIndependantMapper;

    public ObservateursIndependantServiceImpl(ObservateursIndependantRepository observateursIndependantRepository, ObservateursIndependantMapper observateursIndependantMapper) {
        this.observateursIndependantRepository = observateursIndependantRepository;
        this.observateursIndependantMapper = observateursIndependantMapper;
    }

    @Override
    public ObservateursIndependantDTO save(ObservateursIndependantDTO observateursIndependantDTO) {
        log.debug("Request to save ObservateursIndependant : {}", observateursIndependantDTO);
        ObservateursIndependant observateursIndependant = observateursIndependantMapper.toEntity(observateursIndependantDTO);
        observateursIndependant = observateursIndependantRepository.save(observateursIndependant);
        return observateursIndependantMapper.toDto(observateursIndependant);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ObservateursIndependantDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ObservateursIndependants");
        return observateursIndependantRepository.findAll(pageable)
            .map(observateursIndependantMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ObservateursIndependantDTO> findOne(Long id) {
        log.debug("Request to get ObservateursIndependant : {}", id);
        return observateursIndependantRepository.findById(id)
            .map(observateursIndependantMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ObservateursIndependant : {}", id);
        observateursIndependantRepository.deleteById(id);
    }
}
