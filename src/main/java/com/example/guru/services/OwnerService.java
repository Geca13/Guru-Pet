package com.example.guru.services;

import java.util.Set;

import com.example.guru.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	

}
