package com.example.guru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.guru.services.OwnerService;

@RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	
	
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}


    @RequestMapping({"","/", "/index", "/index.html"})
	public String listOwners(Model model) {
    	model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

}
