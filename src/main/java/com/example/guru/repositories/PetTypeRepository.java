package com.example.guru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.guru.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType , Long> {

}
