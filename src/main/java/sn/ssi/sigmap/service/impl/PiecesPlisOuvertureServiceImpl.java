package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.PiecesPlisOuvertureService;
import sn.ssi.sigmap.domain.PiecesPlisOuverture;
import sn.ssi.sigmap.repository.PiecesPlisOuvertureRepository;
import sn.ssi.sigmap.service.dto.PiecesPlisOuvertureDTO;
import sn.ssi.sigmap.service.mapper.PiecesPlisOuvertureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PiecesPlisOuverture}.
 */
@Service
@Transactional
public class PiecesPlisOuvertureServiceImpl implements PiecesPlisOuvertureService {

    private final Logger log = LoggerFactory.getLogger(PiecesPlisOuvertureServiceImpl.class);

    private final PiecesPlisOuvertureRepository piecesPlisOuvertureRepository;

    private final PiecesPlisOuvertureMapper piecesPlisOuvertureMapper;

    public PiecesPlisOuvertureServiceImpl(PiecesPlisOuvertureRepository piecesPlisOuvertureRepository, PiecesPlisOuvertureMapper piecesPlisOuvertureMapper) {
        this.piecesPlisOuvertureRepository = piecesPlisOuvertureRepository;
        this.piecesPlisOuvertureMapper = piecesPlisOuvertureMapper;
    }

    @Override
    public PiecesPlisOuvertureDTO save(PiecesPlisOuvertureDTO piecesPlisOuvertureDTO) {
        log.debug("Request to save PiecesPlisOuverture : {}", piecesPlisOuvertureDTO);
        PiecesPlisOuverture piecesPlisOuverture = piecesPlisOuvertureMapper.toEntity(piecesPlisOuvertureDTO);
        piecesPlisOuverture = piecesPlisOuvertureRepository.save(piecesPlisOuverture);
        return piecesPlisOuvertureMapper.toDto(piecesPlisOuverture);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PiecesPlisOuvertureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PiecesPlisOuvertures");
        return piecesPlisOuvertureRepository.findAll(pageable)
            .map(piecesPlisOuvertureMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PiecesPlisOuvertureDTO> findOne(Long id) {
        log.debug("Request to get PiecesPlisOuverture : {}", id);
        return piecesPlisOuvertureRepository.findById(id)
            .map(piecesPlisOuvertureMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PiecesPlisOuverture : {}", id);
        piecesPlisOuvertureRepository.deleteById(id);
    }
}
