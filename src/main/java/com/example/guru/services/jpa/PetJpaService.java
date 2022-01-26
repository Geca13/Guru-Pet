package com.example.guru.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.Pet;
import com.example.guru.repositories.PetRepository;
import com.example.guru.services.PetService;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {
	
	private final PetRepository petRepository;

	public PetJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);		
	}
	

}
