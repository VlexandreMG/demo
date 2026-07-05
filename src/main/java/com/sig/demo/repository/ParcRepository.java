package com.sig.demo.repository;

import com.sig.demo.model.Parc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParcRepository extends JpaRepository<Parc, Long> {
    // Le CRUD classique est hérité automatiquement ici

    // La fameuse fonction manquante avec la requête spatiale PostGIS !
    @Query(value = "SELECT * FROM parcs WHERE ST_DWithin(geom::geography, ST_MakePoint(:lng, :lat)::geography, :distanceInMeters)", nativeQuery = true)
    List<Parc> findParcsProches(
        @Param("lng") double lng, 
        @Param("lat") double lat, 
        @Param("distanceInMeters") double distanceInMeters
    );
}
