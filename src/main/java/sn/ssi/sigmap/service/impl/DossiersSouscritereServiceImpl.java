package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DossiersSouscritereService;
import sn.ssi.sigmap.domain.DossiersSouscritere;
import sn.ssi.sigmap.repository.DossiersSouscritereRepository;
import sn.ssi.sigmap.service.dto.DossiersSouscritereDTO;
import sn.ssi.sigmap.service.mapper.DossiersSouscritereMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DossiersSouscritere}.
 */
@Service
@Transactional
public class DossiersSouscritereServiceImpl implements DossiersSouscritereService {

    private final Logger log = LoggerFactory.getLogger(DossiersSouscritereServiceImpl.class);

    private final DossiersSouscritereRepository dossiersSouscritereRepository;

    private final DossiersSouscritereMapper dossiersSouscritereMapper;

    public DossiersSouscritereServiceImpl(DossiersSouscritereRepository dossiersSouscritereRepository, DossiersSouscritereMapper dossiersSouscritereMapper) {
        this.dossiersSouscritereRepository = dossiersSouscritereRepository;
        this.dossiersSouscritereMapper = dossiersSouscritereMapper;
    }

    @Override
    public DossiersSouscritereDTO save(DossiersSouscritereDTO dossiersSouscritereDTO) {
        log.debug("Request to save DossiersSouscritere : {}", dossiersSouscritereDTO);
        DossiersSouscritere dossiersSouscritere = dossiersSouscritereMapper.toEntity(dossiersSouscritereDTO);
        dossiersSouscritere = dossiersSouscritereRepository.save(dossiersSouscritere);
        return dossiersSouscritereMapper.toDto(dossiersSouscritere);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DossiersSouscritereDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DossiersSouscriteres");
        return dossiersSouscritereRepository.findAll(pageable)
            .map(dossiersSouscritereMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DossiersSouscritereDTO> findOne(Long id) {
        log.debug("Request to get DossiersSouscritere : {}", id);
        return dossiersSouscritereRepository.findById(id)
            .map(dossiersSouscritereMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DossiersSouscritere : {}", id);
        dossiersSouscritereRepository.deleteById(id);
    }
}
