package com.rococo.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.rococo.springboot.model.PersonModel;

public interface PersonRepository extends CrudRepository<PersonModel, Integer>{

}
