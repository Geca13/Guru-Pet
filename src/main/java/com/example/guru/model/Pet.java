package com.example.guru.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Pet extends BaseEntety {

	private PetType petType;
	
	private Owner Owner;
	
	private String name;
	
	private LocalDate birthDate;

	
	public Pet() {
		super();
	}

	public Pet(PetType petType, Owner owner, String name, LocalDate birthDate) {
		super();
		this.petType = petType;
		Owner = owner;
		this.name = name;
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return Owner;
	}

	public void setOwner(Owner owner) {
		Owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	
}
