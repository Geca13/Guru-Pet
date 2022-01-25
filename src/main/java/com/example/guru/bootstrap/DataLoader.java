package com.example.guru.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.guru.model.Owner;
import com.example.guru.model.Pet;
import com.example.guru.model.PetType;
import com.example.guru.model.Speciality;
import com.example.guru.model.Vet;
import com.example.guru.services.OwnerService;
import com.example.guru.services.PetTypeService;
import com.example.guru.services.SpecialityService;
import com.example.guru.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialitiesService;
	
	

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Integer count = ownerService.findAll().size();
		if (count == 0) {
			loadData();
		}
		
		
		System.out.println("Data Loaded");
	}



	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		
		Owner owner1 = new Owner();
		
		owner1.setFirstName("Marjan");
		owner1.setLastName("Geca");
		owner1.setAddress("Pero Nakov");
		owner1.setCity("Negotino");
		owner1.setPhone("0789632156");
		
		ownerService.save(owner1);
		
		Pet marjanPet = new Pet();
		marjanPet.setBirthDate(LocalDate.now());
		marjanPet.setOwner(owner1);
		marjanPet.setPetType(savedDogPetType);
		marjanPet.setName("Puki");
		owner1.getPets().add(marjanPet);
		
		Owner owner2 = new Owner();
		
		owner2.setFirstName("Geca");
		owner2.setLastName("Marjan");
		owner2.setAddress("Geca Nakov");
		owner2.setCity("Skopje");
		owner2.setPhone("0789874123");
		
		ownerService.save(owner2);
		
		Pet gecaPet = new Pet();
		gecaPet.setBirthDate(LocalDate.now());
		gecaPet.setOwner(owner2);
		gecaPet.setPetType(savedCatPetType);
		gecaPet.setName("kuki");
		owner1.getPets().add(gecaPet);
		
        Owner owner3 = new Owner();
		
		owner3.setFirstName("Mishel");
		owner3.setLastName("Rakel");
		owner3.setAddress("Geca Nakovik");
		owner3.setCity("Skopje");
		owner3.setPhone("0789874587");
		
		ownerService.save(owner3);
		
		Pet mishPet = new Pet();
		mishPet.setBirthDate(LocalDate.now());
		mishPet.setOwner(owner3);
		mishPet.setPetType(savedCatPetType);
		gecaPet.setName("kuki");
		owner3.getPets().add(mishPet);
		
		
		Speciality radiology = new Speciality();
		radiology.setDescription("radiology");
		Speciality savedRad = specialitiesService.save(radiology);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDen = specialitiesService.save(dentistry);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality savedSur = specialitiesService.save(surgery);
		
		Vet vet1 = new Vet();
		
		vet1.setFirstName("Rakel");
		vet1.setLastName("Galeb");
		vet1.getSpecialities().add(savedRad);
		vet1.getSpecialities().add(savedSur);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		
		vet2.setFirstName("Galeb");
		vet2.setLastName("Rakel");
		vet1.getSpecialities().add(savedDen);
		
		vetService.save(vet2);
	}

}
