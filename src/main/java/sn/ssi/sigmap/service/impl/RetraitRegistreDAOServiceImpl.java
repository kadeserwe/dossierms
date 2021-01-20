package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.RetraitRegistreDAOService;
import sn.ssi.sigmap.domain.RetraitRegistreDAO;
import sn.ssi.sigmap.repository.RetraitRegistreDAORepository;
import sn.ssi.sigmap.service.dto.RetraitRegistreDAODTO;
import sn.ssi.sigmap.service.mapper.RetraitRegistreDAOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link RetraitRegistreDAO}.
 */
@Service
@Transactional
public class RetraitRegistreDAOServiceImpl implements RetraitRegistreDAOService {

    private final Logger log = LoggerFactory.getLogger(RetraitRegistreDAOServiceImpl.class);

    private final RetraitRegistreDAORepository retraitRegistreDAORepository;

    private final RetraitRegistreDAOMapper retraitRegistreDAOMapper;

    public RetraitRegistreDAOServiceImpl(RetraitRegistreDAORepository retraitRegistreDAORepository, RetraitRegistreDAOMapper retraitRegistreDAOMapper) {
        this.retraitRegistreDAORepository = retraitRegistreDAORepository;
        this.retraitRegistreDAOMapper = retraitRegistreDAOMapper;
    }

    @Override
    public RetraitRegistreDAODTO save(RetraitRegistreDAODTO retraitRegistreDAODTO) {
        log.debug("Request to save RetraitRegistreDAO : {}", retraitRegistreDAODTO);
        RetraitRegistreDAO retraitRegistreDAO = retraitRegistreDAOMapper.toEntity(retraitRegistreDAODTO);
        retraitRegistreDAO = retraitRegistreDAORepository.save(retraitRegistreDAO);
        return retraitRegistreDAOMapper.toDto(retraitRegistreDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RetraitRegistreDAODTO> findAll(Pageable pageable) {
        log.debug("Request to get all RetraitRegistreDAOS");
        return retraitRegistreDAORepository.findAll(pageable)
            .map(retraitRegistreDAOMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<RetraitRegistreDAODTO> findOne(Long id) {
        log.debug("Request to get RetraitRegistreDAO : {}", id);
        return retraitRegistreDAORepository.findById(id)
            .map(retraitRegistreDAOMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RetraitRegistreDAO : {}", id);
        retraitRegistreDAORepository.deleteById(id);
    }
}
