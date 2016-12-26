package com.prongbang.hibernate.dao.impl;

import java.util.List; 

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.prongbang.hibernate.dao.PersonDao;
import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;

@Repository
public class PersonDaoImpl extends AbstractDaoImpl<Person, Integer> implements PersonDao {

	private static final long serialVersionUID = 7870033665374482545L;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Address> findPersonAddressByPersonId(Integer pk) throws Exception {

		String hql = "from Address a join fetch a.person where a.person.id = :id";
		Query<Address> query = getCurrentSession().createQuery(hql);
		query.setParameter("id", pk);
		
		return query.list();
	}

}
