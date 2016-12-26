package com.prongbang.hibernate.service;

import java.util.List;

import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;

public interface PersonService extends AbstractService<Person, Integer> {

	public List<Address> findPersonAddressByPersonId(Integer pk) throws Exception;  
	
}
