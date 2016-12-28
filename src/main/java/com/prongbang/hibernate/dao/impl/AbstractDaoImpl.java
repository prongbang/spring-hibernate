package com.prongbang.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.prongbang.hibernate.dao.AbstractDao;

public class AbstractDaoImpl<T, PK extends Serializable> implements AbstractDao<T, PK>, Serializable {
 
	private static final long serialVersionUID = -4991195044974573853L;

	@Autowired
    protected SessionFactory sessionFactory; 
	
    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    protected Session getCurrentSession() {
    	try {
    	    
    		return sessionFactory.getCurrentSession();
    	    
    	} catch (HibernateException e) {
    		
    		return sessionFactory.openSession();
    	}
    }
 
    @Override
    public T findByPK(PK pk) throws Exception {
        Session session = this.getCurrentSession();
        T entity = (T) session.get(this.persistentClass, pk);
        return entity;
    }

    @Override
    public void save(T entity) throws Exception {
        Session session = this.getCurrentSession();
        session.save(entity);
    }

    @Override
    public void save(List<T> entityList) throws Exception {
        Session session = this.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(T entity) throws Exception {
        Session session = this.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void update(List<T> entityList) throws Exception {
        Session session = this.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void delete(T entity) throws Exception {
        Session session = this.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public void delete(List<T> entityList) throws Exception {
        Session session = this.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.delete(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<T> findAll() throws Exception {
        Session session = this.getCurrentSession();
        List<T> entityList = session.createCriteria(this.persistentClass).list();
        return entityList;
    }

    @Override
    public void saveOrUpdate(T entity) throws Exception {
        Session session = this.getCurrentSession();
        session.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdate(List<T> entityList) throws Exception {
        Session session = this.getCurrentSession();
        try {
            for (T entity : entityList) {
                session.saveOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
}
