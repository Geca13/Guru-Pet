package com.example.guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.guru.model.Owner;
import com.example.guru.model.Vet;
import com.example.guru.services.OwnerService;
import com.example.guru.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		
		owner1.setFirstName("Marjan");
		owner1.setLastName("Geca");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		
		owner2.setFirstName("Geca");
		owner2.setLastName("Marjan");
		
		ownerService.save(owner2);
		
        Owner owner3 = new Owner();
		
		owner3.setFirstName("Mishel");
		owner3.setLastName("Rakel");
		
		ownerService.save(owner3);
		
		Vet vet1 = new Vet();
		
		vet1.setFirstName("Rakel");
		vet1.setLastName("Galeb");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		
		vet2.setFirstName("Galeb");
		vet2.setLastName("Rakel");
		
		vetService.save(vet2);
		
		System.out.println("Data Loaded");
	}

}
