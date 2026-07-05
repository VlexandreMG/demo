package com.sig.demo.model;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "parcs")
public class Parc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Point geom; // Type spatial JTS

    // Getters et Setters obligatoires pour le sprint
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Point getGeom() { return geom; }
    public void setGeom(Point geom) { this.geom = geom; }
}
