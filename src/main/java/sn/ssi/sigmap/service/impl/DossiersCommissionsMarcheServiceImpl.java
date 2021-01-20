package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DossiersCommissionsMarcheService;
import sn.ssi.sigmap.domain.DossiersCommissionsMarche;
import sn.ssi.sigmap.repository.DossiersCommissionsMarcheRepository;
import sn.ssi.sigmap.service.dto.DossiersCommissionsMarcheDTO;
import sn.ssi.sigmap.service.mapper.DossiersCommissionsMarcheMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DossiersCommissionsMarche}.
 */
@Service
@Transactional
public class DossiersCommissionsMarcheServiceImpl implements DossiersCommissionsMarcheService {

    private final Logger log = LoggerFactory.getLogger(DossiersCommissionsMarcheServiceImpl.class);

    private final DossiersCommissionsMarcheRepository dossiersCommissionsMarcheRepository;

    private final DossiersCommissionsMarcheMapper dossiersCommissionsMarcheMapper;

    public DossiersCommissionsMarcheServiceImpl(DossiersCommissionsMarcheRepository dossiersCommissionsMarcheRepository, DossiersCommissionsMarcheMapper dossiersCommissionsMarcheMapper) {
        this.dossiersCommissionsMarcheRepository = dossiersCommissionsMarcheRepository;
        this.dossiersCommissionsMarcheMapper = dossiersCommissionsMarcheMapper;
    }

    @Override
    public DossiersCommissionsMarcheDTO save(DossiersCommissionsMarcheDTO dossiersCommissionsMarcheDTO) {
        log.debug("Request to save DossiersCommissionsMarche : {}", dossiersCommissionsMarcheDTO);
        DossiersCommissionsMarche dossiersCommissionsMarche = dossiersCommissionsMarcheMapper.toEntity(dossiersCommissionsMarcheDTO);
        dossiersCommissionsMarche = dossiersCommissionsMarcheRepository.save(dossiersCommissionsMarche);
        return dossiersCommissionsMarcheMapper.toDto(dossiersCommissionsMarche);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DossiersCommissionsMarcheDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DossiersCommissionsMarches");
        return dossiersCommissionsMarcheRepository.findAll(pageable)
            .map(dossiersCommissionsMarcheMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DossiersCommissionsMarcheDTO> findOne(Long id) {
        log.debug("Request to get DossiersCommissionsMarche : {}", id);
        return dossiersCommissionsMarcheRepository.findById(id)
            .map(dossiersCommissionsMarcheMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DossiersCommissionsMarche : {}", id);
        dossiersCommissionsMarcheRepository.deleteById(id);
    }
}
