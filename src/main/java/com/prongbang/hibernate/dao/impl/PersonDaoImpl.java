package com.prongbang.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.prongbang.hibernate.dao.PersonDao;
import com.prongbang.hibernate.entities.Address;
import com.prongbang.hibernate.entities.Person;
import com.prongbang.hibernate.models.AddressModel;

/**
 * https://docs.jboss.org/hibernate/orm/
 */

@Repository
public class PersonDaoImpl extends AbstractDaoImpl<Person, Integer> implements
		PersonDao {

	private static final long serialVersionUID = 7870033665374482545L;

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Address> findPersonAddressByPersonId(Integer pk)
			throws Exception {

		String hql = "from Address a join fetch a.person where a.person.id = :id";
		Query<Address> query = getCurrentSession().createQuery(hql);
		query.setParameter("id", pk);

		return query.list();
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Address> findAddressByPersonId(Integer pk) throws Exception {

		String sql = "SELECT * FROM Address WHERE person_id = :id";
		NativeQuery<Address> query = getCurrentSession().createNativeQuery(sql, Address.class);
		query.setParameter("id", pk);

//		String sql = "SELECT id, person_id AS personId, address_name AS addressName FROM Address WHERE person_id = :id";
//		NativeQuery<AddressModel> query = getCurrentSession().createSQLQuery(sql);
//		query.setParameter("id", pk);
//		query.setResultTransformer(Transformers.aliasToBean(AddressModel.class));

		try {

			return query.list();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

}
