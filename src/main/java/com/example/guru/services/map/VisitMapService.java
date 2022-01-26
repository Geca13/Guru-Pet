package com.example.guru.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.guru.model.Visit;
import com.example.guru.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}
	
	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public Visit save(Visit object) {
		if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null) {
			throw new RuntimeException("Invalid visit");
		}
		return super.save(object);
	}
}
