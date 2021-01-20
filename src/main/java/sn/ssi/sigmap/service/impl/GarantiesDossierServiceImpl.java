package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.GarantiesDossierService;
import sn.ssi.sigmap.domain.GarantiesDossier;
import sn.ssi.sigmap.repository.GarantiesDossierRepository;
import sn.ssi.sigmap.service.dto.GarantiesDossierDTO;
import sn.ssi.sigmap.service.mapper.GarantiesDossierMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GarantiesDossier}.
 */
@Service
@Transactional
public class GarantiesDossierServiceImpl implements GarantiesDossierService {

    private final Logger log = LoggerFactory.getLogger(GarantiesDossierServiceImpl.class);

    private final GarantiesDossierRepository garantiesDossierRepository;

    private final GarantiesDossierMapper garantiesDossierMapper;

    public GarantiesDossierServiceImpl(GarantiesDossierRepository garantiesDossierRepository, GarantiesDossierMapper garantiesDossierMapper) {
        this.garantiesDossierRepository = garantiesDossierRepository;
        this.garantiesDossierMapper = garantiesDossierMapper;
    }

    @Override
    public GarantiesDossierDTO save(GarantiesDossierDTO garantiesDossierDTO) {
        log.debug("Request to save GarantiesDossier : {}", garantiesDossierDTO);
        GarantiesDossier garantiesDossier = garantiesDossierMapper.toEntity(garantiesDossierDTO);
        garantiesDossier = garantiesDossierRepository.save(garantiesDossier);
        return garantiesDossierMapper.toDto(garantiesDossier);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GarantiesDossierDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GarantiesDossiers");
        return garantiesDossierRepository.findAll(pageable)
            .map(garantiesDossierMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<GarantiesDossierDTO> findOne(Long id) {
        log.debug("Request to get GarantiesDossier : {}", id);
        return garantiesDossierRepository.findById(id)
            .map(garantiesDossierMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete GarantiesDossier : {}", id);
        garantiesDossierRepository.deleteById(id);
    }
}
