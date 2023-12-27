package com.example.application.service;

import com.example.application.model.Repas;

import java.util.List;
import java.util.Optional;

public interface RepasService {

    void createRepas(Repas repas);
    Optional<List<Repas>> getAllRepas();
    Repas addRepas(Repas repas);
    Repas updateRepas(Repas repas);
    void deleteRepas(String id);
    
}
