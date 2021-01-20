package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.HistoriqueAppelOffresACService;
import sn.ssi.sigmap.domain.HistoriqueAppelOffresAC;
import sn.ssi.sigmap.repository.HistoriqueAppelOffresACRepository;
import sn.ssi.sigmap.service.dto.HistoriqueAppelOffresACDTO;
import sn.ssi.sigmap.service.mapper.HistoriqueAppelOffresACMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link HistoriqueAppelOffresAC}.
 */
@Service
@Transactional
public class HistoriqueAppelOffresACServiceImpl implements HistoriqueAppelOffresACService {

    private final Logger log = LoggerFactory.getLogger(HistoriqueAppelOffresACServiceImpl.class);

    private final HistoriqueAppelOffresACRepository historiqueAppelOffresACRepository;

    private final HistoriqueAppelOffresACMapper historiqueAppelOffresACMapper;

    public HistoriqueAppelOffresACServiceImpl(HistoriqueAppelOffresACRepository historiqueAppelOffresACRepository, HistoriqueAppelOffresACMapper historiqueAppelOffresACMapper) {
        this.historiqueAppelOffresACRepository = historiqueAppelOffresACRepository;
        this.historiqueAppelOffresACMapper = historiqueAppelOffresACMapper;
    }

    @Override
    public HistoriqueAppelOffresACDTO save(HistoriqueAppelOffresACDTO historiqueAppelOffresACDTO) {
        log.debug("Request to save HistoriqueAppelOffresAC : {}", historiqueAppelOffresACDTO);
        HistoriqueAppelOffresAC historiqueAppelOffresAC = historiqueAppelOffresACMapper.toEntity(historiqueAppelOffresACDTO);
        historiqueAppelOffresAC = historiqueAppelOffresACRepository.save(historiqueAppelOffresAC);
        return historiqueAppelOffresACMapper.toDto(historiqueAppelOffresAC);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<HistoriqueAppelOffresACDTO> findAll(Pageable pageable) {
        log.debug("Request to get all HistoriqueAppelOffresACS");
        return historiqueAppelOffresACRepository.findAll(pageable)
            .map(historiqueAppelOffresACMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<HistoriqueAppelOffresACDTO> findOne(Long id) {
        log.debug("Request to get HistoriqueAppelOffresAC : {}", id);
        return historiqueAppelOffresACRepository.findById(id)
            .map(historiqueAppelOffresACMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete HistoriqueAppelOffresAC : {}", id);
        historiqueAppelOffresACRepository.deleteById(id);
    }
}
