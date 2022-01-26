package com.example.guru.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.Vet;
import com.example.guru.repositories.VetRepository;
import com.example.guru.services.VetService;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

	private final VetRepository vetRepository;

	public VetJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet>vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);		
	}
	
}
