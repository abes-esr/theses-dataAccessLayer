package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.portail.*;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoPortailProvider {
    @Resource
    private IAnrtCorrespDao anrtCorrespDao;

    @Resource
    private IComptePortailDao compteDao;

    @Resource
    private ICourrielDao courrielDao;

    @Resource
    private IDocumentPortailDao documentPortailDao;

    @Resource
    private IEtablissementDao etablissementDao;

    @Resource
    private ILogImportSudocErrorDao logImportSudocErrorDao;

    @Resource
    private ILogImportSudocStepDao logImportSudocStepDao;

    @Resource
    private IMetadataFormatDao metadataFormatDao;

    @Resource
    private IMetadataMarcDao metadataMarcDao;

    @Resource
    private IMetadataOaiDcDao metadataOaiDcDao;

    @Resource
    private IMetadataTefDao metadataTefDao;

    @Resource
    private IOaiRecordMarcDao oaiRecordMarcDao;

    @Resource
    private IOaiRecordOaiDcDao oaiRecordOaiDcDao;

    @Resource
    private IOaiRecordTefDao oaiRecordTefDao;

    @Resource
    private IOaiSetDao oaiSetDao;

    @Resource
    private IRecSetIdDao recSetIdDao;

    @Resource
    private IRecSetMarcDao recSetMarcDao;

    @Resource
    private IRecSetOaiDcDao recSetOaiDcDao;

    @Resource
    private IRecSetTefDao recSetTefDao;

    @Resource
    private IResumptionTokenDao resumptionTokenDao;
}
