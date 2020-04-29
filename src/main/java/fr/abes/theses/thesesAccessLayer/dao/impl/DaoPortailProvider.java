package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.portail.*;
import lombok.Getter;

import javax.annotation.Resource;

@Getter
public class DaoPortailProvider {
    @Resource
    private IAnrtCorrespDao anrtCorresp;

    @Resource
    private IComptePortailDao compte;

    @Resource
    private ICourrielDao courriel;

    @Resource
    private IDocumentPortailDao documentPortail;

    @Resource
    private IEtablissementPortailDao etablissement;

    @Resource
    private IMetadataFormatDao metadataFormat;

    @Resource
    private IMetadataMarcDao metadataMarc;

    @Resource
    private IMetadataOaiDcDao metadataOaiDc;

    @Resource
    private IMetadataTefDao metadataTef;

    @Resource
    private IOaiRecordMarcDao oaiRecordMarc;

    @Resource
    private IOaiRecordOaiDcDao oaiRecordOaiDc;

    @Resource
    private IOaiRecordTefDao oaiRecordTef;

    @Resource
    private IOaiSetDao oaiSet;

    @Resource
    private IRecSetMarcDao recSetMarc;

    @Resource
    private IRecSetOaiDcDao recSetOaiDc;

    @Resource
    private IRecSetTefDao recSetTef;

    @Resource
    private IResumptionTokenDao resumptionToken;
}