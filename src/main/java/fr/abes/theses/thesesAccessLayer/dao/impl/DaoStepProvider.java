package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.star.ICompteStarDao;
import fr.abes.theses.thesesAccessLayer.dao.step.*;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoStepProvider {
    @Resource
    private ICompteStarDao compte;

    @Resource
    private IDocumentStepDao document;

    @Resource
    private IEtablissementStepDao etablissement;

    @Resource
    private IInitFormationStepDao initFormation;

    @Resource
    private IRefHalStepDao refHal;

    @Resource
    private IVerrouStepDao verrou;
}
