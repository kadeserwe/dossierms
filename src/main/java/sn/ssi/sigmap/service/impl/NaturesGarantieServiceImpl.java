package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.NaturesGarantieService;
import sn.ssi.sigmap.domain.NaturesGarantie;
import sn.ssi.sigmap.repository.NaturesGarantieRepository;
import sn.ssi.sigmap.service.dto.NaturesGarantieDTO;
import sn.ssi.sigmap.service.mapper.NaturesGarantieMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link NaturesGarantie}.
 */
@Service
@Transactional
public class NaturesGarantieServiceImpl implements NaturesGarantieService {

    private final Logger log = LoggerFactory.getLogger(NaturesGarantieServiceImpl.class);

    private final NaturesGarantieRepository naturesGarantieRepository;

    private final NaturesGarantieMapper naturesGarantieMapper;

    public NaturesGarantieServiceImpl(NaturesGarantieRepository naturesGarantieRepository, NaturesGarantieMapper naturesGarantieMapper) {
        this.naturesGarantieRepository = naturesGarantieRepository;
        this.naturesGarantieMapper = naturesGarantieMapper;
    }

    @Override
    public NaturesGarantieDTO save(NaturesGarantieDTO naturesGarantieDTO) {
        log.debug("Request to save NaturesGarantie : {}", naturesGarantieDTO);
        NaturesGarantie naturesGarantie = naturesGarantieMapper.toEntity(naturesGarantieDTO);
        naturesGarantie = naturesGarantieRepository.save(naturesGarantie);
        return naturesGarantieMapper.toDto(naturesGarantie);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NaturesGarantieDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NaturesGaranties");
        return naturesGarantieRepository.findAll(pageable)
            .map(naturesGarantieMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<NaturesGarantieDTO> findOne(Long id) {
        log.debug("Request to get NaturesGarantie : {}", id);
        return naturesGarantieRepository.findById(id)
            .map(naturesGarantieMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete NaturesGarantie : {}", id);
        naturesGarantieRepository.deleteById(id);
    }
}
