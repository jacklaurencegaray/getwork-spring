package com.rococo.springboot.service;

import java.util.List;

import com.rococo.springboot.model.PersonModel;

public interface PersonService {
	
	public PersonModel getPersonInfo(PersonModel personModel);	
	public List<PersonModel> getAll();
	public void registerPerson(PersonModel personModel);
}
