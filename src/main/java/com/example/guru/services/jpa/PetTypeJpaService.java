package com.example.guru.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.PetType;
import com.example.guru.repositories.PetTypeRepository;
import com.example.guru.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeJpaService implements PetTypeService {
	
	private final PetTypeRepository ptRepository;

	public PetTypeJpaService(PetTypeRepository ptRepository) {
		super();
		this.ptRepository = ptRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> types = new HashSet<>();
		ptRepository.findAll().forEach(types::add);
		return types;
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return ptRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return ptRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		ptRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		ptRepository.deleteById(id);
		
	}
	
	

}
