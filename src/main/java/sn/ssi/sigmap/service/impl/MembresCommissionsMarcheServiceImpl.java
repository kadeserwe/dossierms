package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.MembresCommissionsMarcheService;
import sn.ssi.sigmap.domain.MembresCommissionsMarche;
import sn.ssi.sigmap.repository.MembresCommissionsMarcheRepository;
import sn.ssi.sigmap.service.dto.MembresCommissionsMarcheDTO;
import sn.ssi.sigmap.service.mapper.MembresCommissionsMarcheMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MembresCommissionsMarche}.
 */
@Service
@Transactional
public class MembresCommissionsMarcheServiceImpl implements MembresCommissionsMarcheService {

    private final Logger log = LoggerFactory.getLogger(MembresCommissionsMarcheServiceImpl.class);

    private final MembresCommissionsMarcheRepository membresCommissionsMarcheRepository;

    private final MembresCommissionsMarcheMapper membresCommissionsMarcheMapper;

    public MembresCommissionsMarcheServiceImpl(MembresCommissionsMarcheRepository membresCommissionsMarcheRepository, MembresCommissionsMarcheMapper membresCommissionsMarcheMapper) {
        this.membresCommissionsMarcheRepository = membresCommissionsMarcheRepository;
        this.membresCommissionsMarcheMapper = membresCommissionsMarcheMapper;
    }

    @Override
    public MembresCommissionsMarcheDTO save(MembresCommissionsMarcheDTO membresCommissionsMarcheDTO) {
        log.debug("Request to save MembresCommissionsMarche : {}", membresCommissionsMarcheDTO);
        MembresCommissionsMarche membresCommissionsMarche = membresCommissionsMarcheMapper.toEntity(membresCommissionsMarcheDTO);
        membresCommissionsMarche = membresCommissionsMarcheRepository.save(membresCommissionsMarche);
        return membresCommissionsMarcheMapper.toDto(membresCommissionsMarche);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MembresCommissionsMarcheDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MembresCommissionsMarches");
        return membresCommissionsMarcheRepository.findAll(pageable)
            .map(membresCommissionsMarcheMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<MembresCommissionsMarcheDTO> findOne(Long id) {
        log.debug("Request to get MembresCommissionsMarche : {}", id);
        return membresCommissionsMarcheRepository.findById(id)
            .map(membresCommissionsMarcheMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete MembresCommissionsMarche : {}", id);
        membresCommissionsMarcheRepository.deleteById(id);
    }
}
