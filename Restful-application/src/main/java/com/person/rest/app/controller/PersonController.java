package com.person.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.rest.app.beans.Person;
import com.person.rest.app.service.PersonService;
/**
 * 
 * @author dhamodirand
 *
 */

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/")
	public String getMsg() {
		
		return "Person Controller";
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
		
		return personService.getPersonById(id);
		
	}
	
	@GetMapping("/person/all")
	public ResponseEntity<List<Person>> getAllPersons() {
		
		return personService.getAllPersons();
		
	}
	
	@PostMapping("/person/add")
	public ResponseEntity<Person> createPerson(@RequestBody Person prsn) {
			return personService.savePerson(prsn);
	}

}
