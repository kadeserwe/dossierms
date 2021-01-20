package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DossierAppelOffreService;
import sn.ssi.sigmap.domain.DossierAppelOffre;
import sn.ssi.sigmap.repository.DossierAppelOffreRepository;
import sn.ssi.sigmap.service.dto.DossierAppelOffreDTO;
import sn.ssi.sigmap.service.mapper.DossierAppelOffreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DossierAppelOffre}.
 */
@Service
@Transactional
public class DossierAppelOffreServiceImpl implements DossierAppelOffreService {

    private final Logger log = LoggerFactory.getLogger(DossierAppelOffreServiceImpl.class);

    private final DossierAppelOffreRepository dossierAppelOffreRepository;

    private final DossierAppelOffreMapper dossierAppelOffreMapper;

    public DossierAppelOffreServiceImpl(DossierAppelOffreRepository dossierAppelOffreRepository, DossierAppelOffreMapper dossierAppelOffreMapper) {
        this.dossierAppelOffreRepository = dossierAppelOffreRepository;
        this.dossierAppelOffreMapper = dossierAppelOffreMapper;
    }

    @Override
    public DossierAppelOffreDTO save(DossierAppelOffreDTO dossierAppelOffreDTO) {
        log.debug("Request to save DossierAppelOffre : {}", dossierAppelOffreDTO);
        DossierAppelOffre dossierAppelOffre = dossierAppelOffreMapper.toEntity(dossierAppelOffreDTO);
        dossierAppelOffre = dossierAppelOffreRepository.save(dossierAppelOffre);
        return dossierAppelOffreMapper.toDto(dossierAppelOffre);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DossierAppelOffreDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DossierAppelOffres");
        return dossierAppelOffreRepository.findAll(pageable)
            .map(dossierAppelOffreMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DossierAppelOffreDTO> findOne(Long id) {
        log.debug("Request to get DossierAppelOffre : {}", id);
        return dossierAppelOffreRepository.findById(id)
            .map(dossierAppelOffreMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DossierAppelOffre : {}", id);
        dossierAppelOffreRepository.deleteById(id);
    }
}
