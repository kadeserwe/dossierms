package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.LotService;
import sn.ssi.sigmap.domain.Lot;
import sn.ssi.sigmap.repository.LotRepository;
import sn.ssi.sigmap.service.dto.LotDTO;
import sn.ssi.sigmap.service.mapper.LotMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Lot}.
 */
@Service
@Transactional
public class LotServiceImpl implements LotService {

    private final Logger log = LoggerFactory.getLogger(LotServiceImpl.class);

    private final LotRepository lotRepository;

    private final LotMapper lotMapper;

    public LotServiceImpl(LotRepository lotRepository, LotMapper lotMapper) {
        this.lotRepository = lotRepository;
        this.lotMapper = lotMapper;
    }

    @Override
    public LotDTO save(LotDTO lotDTO) {
        log.debug("Request to save Lot : {}", lotDTO);
        Lot lot = lotMapper.toEntity(lotDTO);
        lot = lotRepository.save(lot);
        return lotMapper.toDto(lot);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LotDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Lots");
        return lotRepository.findAll(pageable)
            .map(lotMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<LotDTO> findOne(Long id) {
        log.debug("Request to get Lot : {}", id);
        return lotRepository.findById(id)
            .map(lotMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Lot : {}", id);
        lotRepository.deleteById(id);
    }
}
