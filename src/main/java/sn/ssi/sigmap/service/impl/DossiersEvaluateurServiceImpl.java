package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DossiersEvaluateurService;
import sn.ssi.sigmap.domain.DossiersEvaluateur;
import sn.ssi.sigmap.repository.DossiersEvaluateurRepository;
import sn.ssi.sigmap.service.dto.DossiersEvaluateurDTO;
import sn.ssi.sigmap.service.mapper.DossiersEvaluateurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DossiersEvaluateur}.
 */
@Service
@Transactional
public class DossiersEvaluateurServiceImpl implements DossiersEvaluateurService {

    private final Logger log = LoggerFactory.getLogger(DossiersEvaluateurServiceImpl.class);

    private final DossiersEvaluateurRepository dossiersEvaluateurRepository;

    private final DossiersEvaluateurMapper dossiersEvaluateurMapper;

    public DossiersEvaluateurServiceImpl(DossiersEvaluateurRepository dossiersEvaluateurRepository, DossiersEvaluateurMapper dossiersEvaluateurMapper) {
        this.dossiersEvaluateurRepository = dossiersEvaluateurRepository;
        this.dossiersEvaluateurMapper = dossiersEvaluateurMapper;
    }

    @Override
    public DossiersEvaluateurDTO save(DossiersEvaluateurDTO dossiersEvaluateurDTO) {
        log.debug("Request to save DossiersEvaluateur : {}", dossiersEvaluateurDTO);
        DossiersEvaluateur dossiersEvaluateur = dossiersEvaluateurMapper.toEntity(dossiersEvaluateurDTO);
        dossiersEvaluateur = dossiersEvaluateurRepository.save(dossiersEvaluateur);
        return dossiersEvaluateurMapper.toDto(dossiersEvaluateur);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DossiersEvaluateurDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DossiersEvaluateurs");
        return dossiersEvaluateurRepository.findAll(pageable)
            .map(dossiersEvaluateurMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DossiersEvaluateurDTO> findOne(Long id) {
        log.debug("Request to get DossiersEvaluateur : {}", id);
        return dossiersEvaluateurRepository.findById(id)
            .map(dossiersEvaluateurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DossiersEvaluateur : {}", id);
        dossiersEvaluateurRepository.deleteById(id);
    }
}
