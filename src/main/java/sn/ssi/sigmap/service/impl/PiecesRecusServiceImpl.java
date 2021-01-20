package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.PiecesRecusService;
import sn.ssi.sigmap.domain.PiecesRecus;
import sn.ssi.sigmap.repository.PiecesRecusRepository;
import sn.ssi.sigmap.service.dto.PiecesRecusDTO;
import sn.ssi.sigmap.service.mapper.PiecesRecusMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PiecesRecus}.
 */
@Service
@Transactional
public class PiecesRecusServiceImpl implements PiecesRecusService {

    private final Logger log = LoggerFactory.getLogger(PiecesRecusServiceImpl.class);

    private final PiecesRecusRepository piecesRecusRepository;

    private final PiecesRecusMapper piecesRecusMapper;

    public PiecesRecusServiceImpl(PiecesRecusRepository piecesRecusRepository, PiecesRecusMapper piecesRecusMapper) {
        this.piecesRecusRepository = piecesRecusRepository;
        this.piecesRecusMapper = piecesRecusMapper;
    }

    @Override
    public PiecesRecusDTO save(PiecesRecusDTO piecesRecusDTO) {
        log.debug("Request to save PiecesRecus : {}", piecesRecusDTO);
        PiecesRecus piecesRecus = piecesRecusMapper.toEntity(piecesRecusDTO);
        piecesRecus = piecesRecusRepository.save(piecesRecus);
        return piecesRecusMapper.toDto(piecesRecus);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PiecesRecusDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PiecesRecuses");
        return piecesRecusRepository.findAll(pageable)
            .map(piecesRecusMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PiecesRecusDTO> findOne(Long id) {
        log.debug("Request to get PiecesRecus : {}", id);
        return piecesRecusRepository.findById(id)
            .map(piecesRecusMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PiecesRecus : {}", id);
        piecesRecusRepository.deleteById(id);
    }
}
