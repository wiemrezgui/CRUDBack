package com.example.application.service;


import com.example.application.model.Repas;
import com.example.application.repository.RepasRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j

public class RepasServiceImpl implements RepasService {

    @Autowired
    private RepasRepository repasRepository;

    @Override
    public void createRepas(Repas repas) {

        this.repasRepository.save(repas);
    }

    @Override
    public Optional<List<Repas>> getAllRepas() {
        List<Repas> repasList = repasRepository.findAll();
        return Optional.ofNullable(repasList);
    }

	@Override
	public Repas addRepas(Repas repas) {
        repas.setId(UUID.randomUUID().toString());
		return repasRepository.save(repas);
	}

	@Override
	public Repas updateRepas(Repas repas) {
		return repasRepository.save(repas);
	}

	@Override
	public void deleteRepas(String id) {
		 repasRepository.deleteById(id);
		
	}
}
