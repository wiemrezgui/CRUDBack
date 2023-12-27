package com.example.application.controller;

import com.example.application.model.Repas;
import com.example.application.service.RepasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RepasController {

    private final RepasService repasService;

    @Autowired
    public RepasController(RepasService repasService) {
        this.repasService = repasService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Repas>> getAll() {
        Optional<List<Repas>> repasListOptional = repasService.getAllRepas();
        if (repasListOptional.isPresent()) {
            List<Repas> repasList = repasListOptional.get();
            return new ResponseEntity<>(repasList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Repas> addRepas(@RequestBody Repas repas){
        Repas createdRepas = repasService.addRepas(repas);
        return new ResponseEntity<>(createdRepas, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Repas> updateRepas(@RequestBody Repas repas){
    	Repas updatedRepas = repasService.updateRepas(repas);
        return new ResponseEntity<>(updatedRepas, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRepas(@PathVariable("id") String id) {
    	repasService.deleteRepas(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}