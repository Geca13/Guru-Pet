package com.example.guru.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.guru.model.Speciality;
@Service
@Profile("springdatajpa")
public interface SpecialityService extends CrudService<Speciality, Long> {

}
