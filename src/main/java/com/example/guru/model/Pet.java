package com.example.guru.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Pet extends BaseEntety {

	private PetType petType;
	
	private Owner Owner;
	
	private LocalDate birthDate;
}
