package com.example.guru.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.Owner;
import com.example.guru.model.Pet;
import com.example.guru.services.OwnerService;
import com.example.guru.services.PetService;
import com.example.guru.services.PetTypeService;


@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {
		if(object != null) {
			if(object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if(pet.getPetType() != null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}else {
						throw new RuntimeException("PetType is required");
					}
					if (pet.getId() == null ) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save( object);
		}else {
			return null;
		}
		
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return this.findAll().stream()
				.filter(owner -> owner.getLastName()
				.equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
	}

}
