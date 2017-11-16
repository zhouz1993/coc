package com.coc.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.coc.dao.PersonDAO;
import com.coc.entity.Person;
import com.coc.entity.User;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Resource 
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	public boolean login(User user){
		String hql = "from User where username=? and password=? ";
		
		String[] params = new String[]{user.getUsername(), user.getPassword()};
		
		//Type[] types = new Type[]{Hibernate.STRING,Hibernate.STRING,Hibernate.STRING};
		Type[] types = new Type[]{Hibernate.STRING,Hibernate.STRING};
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameters(params, types);
		Iterator<?> iter = query.iterate();
		if (iter.hasNext()) {
			return true;
		}
		return false;
	}

	public void add(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	public void update(Person person) {
		Person old = (Person)sessionFactory.getCurrentSession().get(Person.class, person.getPersonid());
		old.setName(person.getName());
	}

	public void delete(int personid) {
		Person person = (Person)sessionFactory.getCurrentSession().get(Person.class, personid);
		sessionFactory.getCurrentSession().delete(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}
}
