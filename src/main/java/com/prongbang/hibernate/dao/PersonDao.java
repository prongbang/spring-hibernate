package com.prongbang.hibernate.dao;

import java.util.List;

import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;

public interface PersonDao extends AbstractDao<Person, Integer>{

	public List<Address> findPersonAddressByPersonId(Integer pk) throws Exception;  
	
}
