package com.person.rest.app.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.rest.app.beans.Person;

/**
 * 
 * @author dhamodirand
 *
 */

public interface PersonRepository extends JpaRepository<Person, Long> {

	public Optional<Person> findById(Long id);

	public List<Person> findAll();

}