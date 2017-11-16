package com.coc.dao.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.coc.dao.PersonDAO;
import com.coc.entity.Person;
import com.coc.entity.User;

@Controller
public class PersonAction {
	
	@Resource
	private PersonDAO personDAOImpl;
	
	private User user;
	private List<Person> persons;
	private String name;
	private int personid;
	
	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		System.out.println(user);
		boolean ret = personDAOImpl.login(user);
		System.out.println(user.getRole());
		System.out.println(ret);
		if (ret) {
			return "success";
		}
		return "error";
	}
	
	public String add() {
		personDAOImpl.add(new Person(name));
		//return "success";
		return "success";
	}
	
	public String get() {
		persons = personDAOImpl.getPersons();
	
		return "persons";
	}
	
	public String del() {
		personDAOImpl.delete(personid);
		//return "success";
		return "success";
	}
	
	/*public String execute(){
		System.out.println("seussssss!!");
		return "error";
	}*/
	
	public String toLogin(){
		return "login1";
	}
	
	public String add1(){
		return "add1";
	}
}
