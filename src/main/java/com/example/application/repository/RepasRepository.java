package com.example.application.repository;

import com.example.application.model.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RepasRepository  extends JpaRepository<Repas,String> {
}
