# theses-dataaccesslayer
Data access layer to the theses databases.

Explications sur les problèmes liés à l'insertion et la mise à jour en base des champs XMLTYPE

2 solutions expliquées ici : https://mosisa.wordpress.com/2008/07/14/hibernate-with-oracle-xmltype/
et ici : https://stackoverflow.com/questions/3064330/how-to-map-xmltype-with-jpa-hibernate

Solution 1 : Mise en place d'un type spécifique sous forme d'une classe HibernateXMLType (dans package fr.abes.theses.thesesAccessLayer.model.types). 
Il faut pour cela, que le dialect hibernate utilisé déclare le type XML type : voir classe fr.abes.theses.thesesAccessLayer.configuration.OracleXmlDialect
Cette classe peut hériter des classes Oracle12cDialect ou Oracle10gDialect. L'utilisation de l'une ou l'autre n'a pas changé le déroulement des TU.
L'entité testée qui implémente cette solution est dans : fr.abes.theses.thesesAccessLayer.model.entities.star.EtablissementStar
Y est déclaré une définition du type pour effectuer le mapping entre Document xml java et envoie d'un xmltype à Oracle : @TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
La colonne est ensuite déclarée en tant que org.jdom2.Document et annotée avec le type personnalisé : @Type(type = "HibernateXMLType")

Le test unitaire correspondant est dans fr.abes.theses.thesesAccessLayer.dao.star.IEtablissementStarDaoTest

L'erreur retournée est la suivante : org.springframework.orm.jpa.JpaSystemException: Could not set field value + valeur xml dans le fichier de test. Problème de reflection.

Piste pour trouver une solution : utiliser une autre librairie que org.jdom2.Document. J'ai fait des tests, mais ça n'a pas non plus fonctionné. Le tuto utilise une autre librairie : org.w3c.dom.Document

Solution 2 : Utilisation d'un columnTransformer pour lancer les opérations de lecture / écriture sur le champ xmltype : 
On doit aussi utiliser le dialect hibernate fr.abes.theses.thesesAccessLayer.configuration.OracleXmlDialect mais sans obligation de redéclarer le xmltype. Par contre, la méthode useInputStreamToInsertBlob doit être présente.
L'entité testée est fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar 
La colonne doc est déclarée en String cette fois (au lieu de Document) et annotée avec : 
@ColumnTransformer(read = "NVL2(DOC, (DOC).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
@Lob
@Lob permet d'indiquer à hibernate que la String java doit être transformée en clob oracle
le transformer permet d'indiquer à hibernate quoi faire au moment de l'insertion. Au niveau du read, il indique via nvl2 quoi faire en cas de valeur nulle du champ xml, si pas null on envoie la valeur du champ en clob, sinon, on met null dans le champ (ça peut sembler inutile mais il semblerait que ce soit indispensable).
Au niveau write, il appelle la fonction oracle NULLSAFE_XMLTYPE qui a été déclarée dans la BDD et qui utilise la méthode XMLTYPE d'oracle pour effectuer la transfo du champ clob passé en paramètre.

Le TU se situe dans   fr.abes.theses.thesesAccessLayer.dao.star.IDocumentStarDaoTest. L'erreur est remontée par oracle lors de l'exécution de la fonction XMLTYPE : 
Caused by: java.sql.SQLException: ORA-31011: Echec d'analyse XML
ORA-19213: une erreur s'est produite lors du traitement XML aux lignes  1
LPX-00210: '<' attendu plutôt que '['
ORA-06512: à "SYS.XMLTYPE", ligne 272
ORA-06512: à ligne 1
ORA-06512: à "STAR.NULLSAFE_XMLTYPE", ligne 5

Pour pouvoir tester les programmes, il est nécessaire de rajouter les fichiers application.properties, au moins dans le répertoire resources de test avec les informations d'accès  à la base de données de DEV pour pouvoir exécuter les TU.
