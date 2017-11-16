package com.coc.dao;

import java.util.List;

import com.coc.entity.Person;
import com.coc.entity.User;


public interface PersonDAO {
	boolean login(User user);
	
	void add(Person person);
	
	void update(Person person);
	
	void delete(int personid);
	
	List<Person> getPersons();
}
