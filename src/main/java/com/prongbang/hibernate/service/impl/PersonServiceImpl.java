package com.prongbang.hibernate.service.impl;

import java.util.List;
 





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prongbang.hibernate.dao.PersonDao;
import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;
import com.prongbang.hibernate.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
 
	@Autowired
	private PersonDao personDao;
	
	@Transactional(readOnly = true)
	public Person findByPK(Integer pk) throws Exception {
		 
		return personDao.findByPK(pk);
	}

	@Transactional(rollbackFor = Exception.class)
	public void save(Person entity) throws Exception {

		personDao.save(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public void save(List<Person> entityList) throws Exception {

		personDao.save(entityList);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(Person entity) throws Exception {

		personDao.saveOrUpdate(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveOrUpdate(List<Person> entityList) throws Exception {

		personDao.saveOrUpdate(entityList);
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(Person entity) throws Exception {

		personDao.update(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public void update(List<Person> entityList) throws Exception {

		personDao.update(entityList);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Person entity) throws Exception {

		personDao.delete(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(List<Person> entityList) throws Exception {

		personDao.delete(entityList);
	}

	@Transactional(readOnly = true)
	public List<Person> findAll() throws Exception {
		
		return personDao.findAll();
	}

	@Override
	public List<Address> findPersonAddressByPersonId(Integer pk) throws Exception {
		
		return personDao.findPersonAddressByPersonId(pk);
	} 

}
