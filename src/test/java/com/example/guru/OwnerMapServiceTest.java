package com.example.guru;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.guru.model.Owner;
import com.example.guru.services.map.OwnerServiceMap;
import com.example.guru.services.map.PetServiceMap;
import com.example.guru.services.map.PetTypeMapService;

public class OwnerMapServiceTest {
	
	OwnerServiceMap ownerServiceMap;
	
	final Long id = 1L;
	final String lastName = "Geca";
	
	@BeforeEach
	void setUp() {
		ownerServiceMap= new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(id).lastName(lastName).build());
	}
	
	@Test
	void findAll() {
	Set<Owner> owners =	ownerServiceMap.findAll();
	assertEquals(1, owners.size());
		
	}
	

	@Test
	void findById() {
		
		Owner owner = ownerServiceMap.findById(id);
		assertEquals(1, owner.getId());
	}

	@Test
	void save() {
		Owner owner2 = Owner.builder().id(2L).build();
		Owner saved = ownerServiceMap.save(owner2);
		assertEquals(2, saved.getId());
	}
	
	@Test
	void findByLastName() {
		Owner owner = ownerServiceMap.findByLastName(lastName);
		assertNotNull(owner);
	}
	@Test
	void findByLastNameNotFound() {
		Owner owner = ownerServiceMap.findByLastName("notexisting");
		assertNull(owner);
	}
	
	@Test
	void saveNoId() {
		Owner saved = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(saved);
		assertNotNull(saved.getId());
	}

	@Test
	void delete() {
		Owner owner = ownerServiceMap.findById(id);
		ownerServiceMap.delete(owner);
		assertEquals(0, ownerServiceMap.findAll().size());
	}
	

	@Test
	void deleteById() {
		ownerServiceMap.deleteById(id);
		assertEquals(0, ownerServiceMap.findAll().size());
	}
	
	


}
