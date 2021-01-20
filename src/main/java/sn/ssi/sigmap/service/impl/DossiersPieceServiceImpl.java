package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.DossiersPieceService;
import sn.ssi.sigmap.domain.DossiersPiece;
import sn.ssi.sigmap.repository.DossiersPieceRepository;
import sn.ssi.sigmap.service.dto.DossiersPieceDTO;
import sn.ssi.sigmap.service.mapper.DossiersPieceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link DossiersPiece}.
 */
@Service
@Transactional
public class DossiersPieceServiceImpl implements DossiersPieceService {

    private final Logger log = LoggerFactory.getLogger(DossiersPieceServiceImpl.class);

    private final DossiersPieceRepository dossiersPieceRepository;

    private final DossiersPieceMapper dossiersPieceMapper;

    public DossiersPieceServiceImpl(DossiersPieceRepository dossiersPieceRepository, DossiersPieceMapper dossiersPieceMapper) {
        this.dossiersPieceRepository = dossiersPieceRepository;
        this.dossiersPieceMapper = dossiersPieceMapper;
    }

    @Override
    public DossiersPieceDTO save(DossiersPieceDTO dossiersPieceDTO) {
        log.debug("Request to save DossiersPiece : {}", dossiersPieceDTO);
        DossiersPiece dossiersPiece = dossiersPieceMapper.toEntity(dossiersPieceDTO);
        dossiersPiece = dossiersPieceRepository.save(dossiersPiece);
        return dossiersPieceMapper.toDto(dossiersPiece);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DossiersPieceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all DossiersPieces");
        return dossiersPieceRepository.findAll(pageable)
            .map(dossiersPieceMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<DossiersPieceDTO> findOne(Long id) {
        log.debug("Request to get DossiersPiece : {}", id);
        return dossiersPieceRepository.findById(id)
            .map(dossiersPieceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DossiersPiece : {}", id);
        dossiersPieceRepository.deleteById(id);
    }
}
