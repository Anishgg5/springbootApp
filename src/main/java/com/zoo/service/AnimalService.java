package com.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.entity.AnimalEntity;
import com.zoo.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repository;
	
	public List<AnimalEntity> getAllAnimals(){
		return (List<AnimalEntity>) repository.findAll();
	}
	
	public AnimalEntity getAnimalById(int aid) {
		return repository.findById(aid).get();
	}
	
	public AnimalEntity createAnimal(AnimalEntity animal) {
		return repository.save(animal);
	}
	
	public AnimalEntity updateAnimal(int aid, AnimalEntity animal) {
		AnimalEntity animal1 = repository.findById(aid).get();
		if(animal1 != null) {
			animal1.setAid(animal.getAid());
			animal1.setName(animal.getName());
			animal1.setLoc(animal.getLoc());
			return repository.save(animal1);
		}else {
			return null;
		}
	}
	
	public void deleteAnimal(int aid) {
		repository.deleteById(aid);
	}

}
