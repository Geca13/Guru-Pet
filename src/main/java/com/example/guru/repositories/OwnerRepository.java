package com.example.guru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.guru.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

}
