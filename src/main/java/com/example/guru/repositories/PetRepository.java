package com.example.guru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.guru.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
