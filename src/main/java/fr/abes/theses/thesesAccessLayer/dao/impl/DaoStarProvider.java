package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.star.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Getter
public class DaoStarProvider {
    @Resource
    private ICommentairesDao commentaires;

    @Resource
    private ICompteStarDao compte;

    @Resource
    private IDocumentStarDao document;

    @Resource
    private  IDomaineHalDao domaineHal;

    @Resource
    private IInitFormationStarDao initFormation;

    @Resource
    private ILdapUserDao ldapUser;

    @Resource
    private INoticeBiblioDao noticeBiblio;

    @Resource
    private IRefHalStarDao refHal;

    @Resource
    private ISimEtablissementDao simEtablissement;

    @Resource
    private ISimRestiersDao simRestiers;

    @Resource
    private ISimThesesDao simTheses;

    @Resource
    private IVerrouStarDao verrou;

    @Resource
    private IZonePrioritaireDao zonePrioritaire;
}
