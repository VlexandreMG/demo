package com.sig.demo.repository;

import com.sig.demo.model.Parc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcRepository extends JpaRepository<Parc, Long> {
    // Le CRUD classique est hérité automatiquement ici
}
