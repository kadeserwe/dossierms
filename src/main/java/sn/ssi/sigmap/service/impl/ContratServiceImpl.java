package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.ContratService;
import sn.ssi.sigmap.domain.Contrat;
import sn.ssi.sigmap.repository.ContratRepository;
import sn.ssi.sigmap.service.dto.ContratDTO;
import sn.ssi.sigmap.service.mapper.ContratMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Contrat}.
 */
@Service
@Transactional
public class ContratServiceImpl implements ContratService {

    private final Logger log = LoggerFactory.getLogger(ContratServiceImpl.class);

    private final ContratRepository contratRepository;

    private final ContratMapper contratMapper;

    public ContratServiceImpl(ContratRepository contratRepository, ContratMapper contratMapper) {
        this.contratRepository = contratRepository;
        this.contratMapper = contratMapper;
    }

    @Override
    public ContratDTO save(ContratDTO contratDTO) {
        log.debug("Request to save Contrat : {}", contratDTO);
        Contrat contrat = contratMapper.toEntity(contratDTO);
        contrat = contratRepository.save(contrat);
        return contratMapper.toDto(contrat);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ContratDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Contrats");
        return contratRepository.findAll(pageable)
            .map(contratMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ContratDTO> findOne(Long id) {
        log.debug("Request to get Contrat : {}", id);
        return contratRepository.findById(id)
            .map(contratMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Contrat : {}", id);
        contratRepository.deleteById(id);
    }
}
