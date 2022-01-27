package com.example.guru;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.junit.jupiter.MockitoExtension;

import com.example.guru.model.Owner;
import com.example.guru.repositories.OwnerRepository;
import com.example.guru.repositories.PetRepository;
import com.example.guru.repositories.PetTypeRepository;
import com.example.guru.services.jpa.OwnerJpaService;

@ExtendWith(MockitoExtension.class)
public class OwnerJpaServiceTest {
	
	private static final String LAST_NAME = "Geca";

	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerJpaService service;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp() {
		
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
		
	}
	
	@Test
	void findByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		Owner owner = service.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME, owner.getLastName());
	}
	
	@Test
	void findAll() {
		Set<Owner> returned = new HashSet<>();
		returned.add(Owner.builder().id(1L).build());
		returned.add(Owner.builder().id(2L).build());
		when(ownerRepository.findAll()).thenReturn(returned);
		Set<Owner> owners = service.findAll();
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}
	
	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = service.findById(1L);
		assertNull(owner);
	}
	
	@Test
	void save() {
		
		Owner toBeSaved = Owner.builder().id(1L).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner saved = service.save(toBeSaved);
		assertNotNull(saved);
	}
	
	@Test
	void delete() {
		service.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}
	
	@Test
	void deleteById() {
		service.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

}
