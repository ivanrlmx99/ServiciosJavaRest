package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/greetingRb.do")
	public @ResponseBody Persona greetingRb(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		Persona p = new Persona();
		p.setIdPersona(3);
		p.setNombre("Mito Code_RequestBody");
		
		repo.save(p);
		
		model.addAttribute("name", name);
		
		return p;
	}
	
	@GetMapping("/greeting.do")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		Persona p = new Persona();
		p.setIdPersona(3);
		p.setNombre("Mito Code_3");
		
		repo.save(p);
		
		model.addAttribute("name", name);
		
		return "greeting";
	}
	
	@GetMapping("/listar.do")
	public String listar(Model model) {
		model.addAttribute("personas", repo.findAll());
		return "greeting";
	}

}
