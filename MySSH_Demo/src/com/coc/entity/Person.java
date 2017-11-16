package com.coc.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_person")
public class Person {
	
	private int personid;
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public Person(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
}