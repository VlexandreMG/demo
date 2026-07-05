package com.sig.demo.controller;

import com.sig.demo.model.Parc;
import com.sig.demo.repository.ParcRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parcs")
@CrossOrigin("*") // Crucial pour le front-end !
public class ParcController {

    private final ParcRepository parcRepository;

    public ParcController(ParcRepository parcRepository) {
        this.parcRepository = parcRepository;
    }

    @GetMapping
    public List<Parc> getAllParcs() {
        return parcRepository.findAll();
    }
}
