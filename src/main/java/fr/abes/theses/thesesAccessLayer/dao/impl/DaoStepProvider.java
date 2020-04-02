package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.star.ICompteDao;
import fr.abes.theses.thesesAccessLayer.dao.step.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Getter
public class DaoStepProvider {
    @Resource
    private ICompteDao compteDao;

    @Resource
    private IDocIndexationSolrDao docIndexationSolrDao;

    @Resource
    private IDocumentStepDao documentStepDao;

    @Resource
    private IEtablissementDao etablissementDao;

    @Resource
    private IInitFormationDao initFormationDao;

    @Resource
    private IRefHalDao refHalDao;

    @Resource
    private IVerrouDao verrouDao;
}
