package com.person.rest.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.person.rest.app.beans.Person;
import com.person.rest.app.repository.PersonRepository;

/**
 * 
 * @author dhamodirand
 *
 */

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	/**
	 * Get the person object using id
	 * @param id
	 * @return
	 */

	public ResponseEntity<Person> getPersonById(long id) {

		Optional<Person> personData = personRepository.findById(id);

		if (personData.isPresent()) {
			return new ResponseEntity<>(personData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	/**
	 * Get the list of persons
	 * @return
	 */

	public ResponseEntity<List<Person>> getAllPersons() {

		List<Person> personList = null;
		try {

			personList = personRepository.findAll();
			
			if(!personList.isEmpty()) {
				//fetch persons who's age grater than 35
				personList= personList.stream().filter(p->p.getAge()>35).collect(Collectors.toList());
			}

			if (personList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(personList, HttpStatus.OK);
	}
	
	/**
	 * create new person object and save it to db
	 * @param prsn
	 * @return
	 */
	
	public ResponseEntity<Person> savePerson(Person prsn) {
		try {
			Person person = personRepository.save(prsn);
			return new ResponseEntity<>(person, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
