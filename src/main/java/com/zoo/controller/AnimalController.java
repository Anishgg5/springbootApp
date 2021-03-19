package com.zoo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.entity.AnimalEntity;
import com.zoo.service.AnimalService;

@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	@GetMapping(value = "/home")
	public String welcome() {
		return "Welcome to Animal Zoo";
	}
	
	@GetMapping(value = "/getAnimals")
	public List<AnimalEntity> getAllAnimals(HttpServletRequest request){
		return service.getAllAnimals();
	}
	
	@GetMapping(value = "/getAnimalById/{aid}")
	public AnimalEntity getAnimalById(@PathVariable("aid")int aid, HttpServletRequest request) {
		return service.getAnimalById(aid);
	}
	
	@PutMapping(value = "/createAnimal")
	public AnimalEntity createAnimal(@RequestBody AnimalEntity animal, HttpServletRequest request) {
		return service.createAnimal(animal);
		
	}
	
	@PostMapping(value = "/updateAnimal/{aid}")
	public AnimalEntity updateAnimal(@PathVariable("aid")int aid,@RequestBody AnimalEntity animal, HttpServletRequest request) {
		return service.updateAnimal(aid, animal);
	}
	
	@DeleteMapping(value = "/deleteAnimal/{aid}")
	public void deleteAnimal(@PathVariable("aid")int aid, HttpServletRequest request) {
		service.deleteAnimal(aid);
	}

}
