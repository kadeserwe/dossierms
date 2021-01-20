package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.CatFournisseurService;
import sn.ssi.sigmap.domain.CatFournisseur;
import sn.ssi.sigmap.repository.CatFournisseurRepository;
import sn.ssi.sigmap.service.dto.CatFournisseurDTO;
import sn.ssi.sigmap.service.mapper.CatFournisseurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CatFournisseur}.
 */
@Service
@Transactional
public class CatFournisseurServiceImpl implements CatFournisseurService {

    private final Logger log = LoggerFactory.getLogger(CatFournisseurServiceImpl.class);

    private final CatFournisseurRepository catFournisseurRepository;

    private final CatFournisseurMapper catFournisseurMapper;

    public CatFournisseurServiceImpl(CatFournisseurRepository catFournisseurRepository, CatFournisseurMapper catFournisseurMapper) {
        this.catFournisseurRepository = catFournisseurRepository;
        this.catFournisseurMapper = catFournisseurMapper;
    }

    @Override
    public CatFournisseurDTO save(CatFournisseurDTO catFournisseurDTO) {
        log.debug("Request to save CatFournisseur : {}", catFournisseurDTO);
        CatFournisseur catFournisseur = catFournisseurMapper.toEntity(catFournisseurDTO);
        catFournisseur = catFournisseurRepository.save(catFournisseur);
        return catFournisseurMapper.toDto(catFournisseur);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CatFournisseurDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CatFournisseurs");
        return catFournisseurRepository.findAll(pageable)
            .map(catFournisseurMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CatFournisseurDTO> findOne(Long id) {
        log.debug("Request to get CatFournisseur : {}", id);
        return catFournisseurRepository.findById(id)
            .map(catFournisseurMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CatFournisseur : {}", id);
        catFournisseurRepository.deleteById(id);
    }
}
