package com.example.guru.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit extends BaseEntety {
	
	private LocalDate date;
	
	private Pet pet;
	
	private String description;

}
