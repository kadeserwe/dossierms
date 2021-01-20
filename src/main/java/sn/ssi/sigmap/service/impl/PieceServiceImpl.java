package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.PieceService;
import sn.ssi.sigmap.domain.Piece;
import sn.ssi.sigmap.repository.PieceRepository;
import sn.ssi.sigmap.service.dto.PieceDTO;
import sn.ssi.sigmap.service.mapper.PieceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Piece}.
 */
@Service
@Transactional
public class PieceServiceImpl implements PieceService {

    private final Logger log = LoggerFactory.getLogger(PieceServiceImpl.class);

    private final PieceRepository pieceRepository;

    private final PieceMapper pieceMapper;

    public PieceServiceImpl(PieceRepository pieceRepository, PieceMapper pieceMapper) {
        this.pieceRepository = pieceRepository;
        this.pieceMapper = pieceMapper;
    }

    @Override
    public PieceDTO save(PieceDTO pieceDTO) {
        log.debug("Request to save Piece : {}", pieceDTO);
        Piece piece = pieceMapper.toEntity(pieceDTO);
        piece = pieceRepository.save(piece);
        return pieceMapper.toDto(piece);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PieceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Pieces");
        return pieceRepository.findAll(pageable)
            .map(pieceMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PieceDTO> findOne(Long id) {
        log.debug("Request to get Piece : {}", id);
        return pieceRepository.findById(id)
            .map(pieceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Piece : {}", id);
        pieceRepository.deleteById(id);
    }
}
