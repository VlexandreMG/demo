package com.sig.demo.controller;

import com.sig.demo.model.Parc;
import com.sig.demo.repository.ParcRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/parcs")
@CrossOrigin("*")
public class ParcController {

    private final ParcRepository parcRepository;

    public ParcController(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    @GetMapping
    public List<Map<String, Object>> getAllParcs() {
        return parcRepository.findAll().stream().map(parc -> {
            Map<String, Object> map = new java.util.HashMap<>();
            map.put("id", parc.getId());
            map.put("nom", parc.getNom());
            map.put("lng", parc.getGeom() != null ? parc.getGeom().getX() : null);
            map.put("lat", parc.getGeom() != null ? parc.getGeom().getY() : null);
            return map;
        }).collect(Collectors.toList());
    }
}