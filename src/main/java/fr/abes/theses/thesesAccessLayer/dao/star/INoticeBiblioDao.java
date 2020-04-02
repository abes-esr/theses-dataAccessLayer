package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INoticeBiblioDao extends JpaRepository<NoticeBiblio, Integer> {

    @Query("select nb from NoticeBiblio nb where nb.done = 0 and nb.idJob = :idJob order by nb.codeEtab")
    List<NoticeBiblio> getNoticesNonTraiteByJobId(@Param("idJob") Integer idJob);

    @Query("select distinct nb.codeEtab from NoticeBiblio nb where nb.done = 0 and nb.idJob = :idJob")
    List<String> getCodeEtabNonTraiteByJobId(@Param("idJob") Integer idJob);
}
