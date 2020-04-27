package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.star.ICompteStarDao;
import fr.abes.theses.thesesAccessLayer.dao.step.*;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoStepProvider {
    @Resource
    private ICompteStarDao compteDao;

    @Resource
    private IDocumentStepDao documentStepDao;

    @Resource
    private IEtablissementStepDao etablissementDao;

    @Resource
    private IInitFormationStepDao initFormationDao;

    @Resource
    private IRefHalStepDao refHalDao;

    @Resource
    private IVerrouStepDao verrouDao;
}
