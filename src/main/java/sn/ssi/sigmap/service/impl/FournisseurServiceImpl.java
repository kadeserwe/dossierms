package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.FournisseurService;
import sn.ssi.sigmap.domain.Fournisseur;
import sn.ssi.sigmap.repository.FournisseurRepository;
import sn.ssi.sigmap.service.dto.FournisseurDTO;
import sn.ssi.sigmap.service.mapper.FournisseurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Fournisseur}.
 */
@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    private final Logger log = LoggerFactory.getLogger(FournisseurServiceImpl.class);

    private final FournisseurRepository fournisseurRepository;

    private final FournisseurMapper fournisseurMapper;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, FournisseurMapper fournisseurMapper) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurMapper = fournisseurMapper;
    }

    @Override
    public FournisseurDTO save(FournisseurDTO fournisseurDTO) {
        log.debug("Request to save Fournisseur : {}", fournisseurDTO);
        Fournisseur fournisseur = fournisseurMapper.toEntity(fournisseurDTO);
        fournisseur = fournisseurRepository.save(fournisseur);
        return fournisseurMapper.toDto(fournisseur);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FournisseurDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Fournisseurs");
        return fournisseurRepository.findAll(pageable)
            .map(fournisseurMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<FournisseurDTO> findOne(Long id) {
        log.debug("Request to get Fournisseur : {}", id);
        return fournisseurRepository.findById(id)
            .map(fournisseurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Fournisseur : {}", id);
        fournisseurRepository.deleteById(id);
    }
}
