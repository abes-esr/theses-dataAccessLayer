package fr.abes.theses.thesesAccessLayer.dao.impl;

import fr.abes.theses.thesesAccessLayer.dao.star.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Getter
public class DaoStarProvider {
    @Resource
    private ICommentairesDao commentairesDao;

    @Resource
    private ICompteDao compteDao;

    @Resource
    private IDocumentDao documentDao;

    @Resource
    private  IDomaineHalDao domaineHalDao;

    @Resource
    private IInitFormationDao initFormationDao;

    @Resource
    private ILdapUserDao ldapUserDao;

    @Resource
    private INoticeBiblioDao noticeBiblioDao;

    @Resource
    private IRefHalDao refHalDao;

    @Resource
    private ISimEtablissementDao simEtablissementDao;

    @Resource
    private ISimRestiersDao simRestiersDao;

    @Resource
    private ISimThesesDao simThesesDao;

    @Resource
    private IVerrouDao verrouDao;

    @Resource
    private IZonePrioritaireDao zonePrioritaireDao;
}
