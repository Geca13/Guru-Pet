package com.example.guru.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.Speciality;
import com.example.guru.repositories.SpecialityRepository;
import com.example.guru.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService {
	
	private final SpecialityRepository specialityRepository;

	public SpecialityJpaService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);		
	}
	

}
