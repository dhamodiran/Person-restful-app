package com.person.rest.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

/**
 * 
 * @author dhamodirand
 *
 */

@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;
	
	@Column(name="Email" ,nullable =false,unique = true)
	@Size(max = 50)
	@Email
	String email;
	
	@Column(name="FirstName",nullable = false)
	@Size(max = 20)
	String firstName;
	
	@Column(name="LastName")
	@Size(max = 50)
	String lastName;
	
	@Column(name="Age",nullable = false)
	@Range(min = 18,max=50 )
	Integer age;
	
	public Person() {
		
	}
	
	public Person(Long id, String email, String firstName, String lastName, Integer age) {
		super();
		Id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
