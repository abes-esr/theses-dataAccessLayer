package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INoticeBiblioDao extends JpaRepository<NoticeBiblio, Integer> {
    @Query("select nb from NoticeBiblio nb where nb.done = 0 and nb.idJob = :idJob order by nb.codeEtab")
    List<NoticeBiblio> getNoticesNonTraiteByJobId(@Param("idJob") Integer idJob);

    @Query("select nb from NoticeBiblio nb where nb.idJob = :idJob")
    List<NoticeBiblio> getAllNoticesByJobId(@Param("idJob") Integer idJob);
}
