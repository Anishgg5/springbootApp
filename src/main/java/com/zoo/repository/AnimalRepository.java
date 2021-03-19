package com.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zoo.entity.AnimalEntity;

@Repository
public interface AnimalRepository extends CrudRepository<AnimalEntity, Integer> {

}
