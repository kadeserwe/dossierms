package sn.ssi.sigmap.service.impl;

import sn.ssi.sigmap.service.CategorieAppelOffreService;
import sn.ssi.sigmap.domain.CategorieAppelOffre;
import sn.ssi.sigmap.repository.CategorieAppelOffreRepository;
import sn.ssi.sigmap.service.dto.CategorieAppelOffreDTO;
import sn.ssi.sigmap.service.mapper.CategorieAppelOffreMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CategorieAppelOffre}.
 */
@Service
@Transactional
public class CategorieAppelOffreServiceImpl implements CategorieAppelOffreService {

    private final Logger log = LoggerFactory.getLogger(CategorieAppelOffreServiceImpl.class);

    private final CategorieAppelOffreRepository categorieAppelOffreRepository;

    private final CategorieAppelOffreMapper categorieAppelOffreMapper;

    public CategorieAppelOffreServiceImpl(CategorieAppelOffreRepository categorieAppelOffreRepository, CategorieAppelOffreMapper categorieAppelOffreMapper) {
        this.categorieAppelOffreRepository = categorieAppelOffreRepository;
        this.categorieAppelOffreMapper = categorieAppelOffreMapper;
    }

    @Override
    public CategorieAppelOffreDTO save(CategorieAppelOffreDTO categorieAppelOffreDTO) {
        log.debug("Request to save CategorieAppelOffre : {}", categorieAppelOffreDTO);
        CategorieAppelOffre categorieAppelOffre = categorieAppelOffreMapper.toEntity(categorieAppelOffreDTO);
        categorieAppelOffre = categorieAppelOffreRepository.save(categorieAppelOffre);
        return categorieAppelOffreMapper.toDto(categorieAppelOffre);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CategorieAppelOffreDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CategorieAppelOffres");
        return categorieAppelOffreRepository.findAll(pageable)
            .map(categorieAppelOffreMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CategorieAppelOffreDTO> findOne(Long id) {
        log.debug("Request to get CategorieAppelOffre : {}", id);
        return categorieAppelOffreRepository.findById(id)
            .map(categorieAppelOffreMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CategorieAppelOffre : {}", id);
        categorieAppelOffreRepository.deleteById(id);
    }
}
