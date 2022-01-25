package com.example.guru.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.guru.model.Speciality;
import com.example.guru.services.SpecialityService;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialityService{

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
	
	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}
	
	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
}
