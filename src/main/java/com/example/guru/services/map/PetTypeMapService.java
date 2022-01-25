package com.example.guru.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.guru.model.PetType;
import com.example.guru.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

 @Override
 public void delete(PetType object) {
	// TODO Auto-generated method stub
	super.delete(object);
}
 
 @Override
public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}
 
 @Override
 public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
 
 @Override
 public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
 
 @Override
 public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
}
