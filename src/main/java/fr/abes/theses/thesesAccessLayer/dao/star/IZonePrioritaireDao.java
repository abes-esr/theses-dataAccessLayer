package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.ZonePrioritaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IZonePrioritaireDao extends JpaRepository<ZonePrioritaire, Integer> {
    @Query("select z from ZonePrioritaire z where z.labelZone = :labelZone")
    ZonePrioritaire findZoneByLabel(@Param("labelZone") String labelZone);
}
