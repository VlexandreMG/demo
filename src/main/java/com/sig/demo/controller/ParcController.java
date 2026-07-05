package com.sig.demo.controller;

import com.sig.demo.repository.ParcRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parcs")
@CrossOrigin("*")
public class ParcController {

    private final ParcRepository parcRepository;

    public ParcController(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    // 1. Récupérer TOUS les parcs (On remet l'endpoint de l'étape 2 qui avait disparu)
    @GetMapping
    public List<Map<String, Object>> getAllParcs() {
        return parcRepository.findAll().stream().map(parc -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", parc.getId());
            map.put("nom", parc.getNom());
            map.put("lng", parc.getGeom() != null ? parc.getGeom().getX() : null);
            map.put("lat", parc.getGeom() != null ? parc.getGeom().getY() : null);
            return map;
        }).collect(Collectors.toList());
    }

    // 2. Recherche de proximité (La route devient bien /api/parcs/proximite)
    @GetMapping("/proximite")
    public List<Map<String, Object>> getParcsProches(
            @RequestParam("lng") double lng,
            @RequestParam("lat") double lat,
            @RequestParam("rayonKm") double rayonKm) {
        
        double distanceInMeters = rayonKm * 1000;
        
        return parcRepository.findParcsProches(lng, lat, distanceInMeters).stream().map(parc -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", parc.getId());
            map.put("nom", parc.getNom());
            map.put("lng", parc.getGeom() != null ? parc.getGeom().getX() : null);
            map.put("lat", parc.getGeom() != null ? parc.getGeom().getY() : null);
            return map;
        }).collect(Collectors.toList());
    }
}