package com.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.model.Person;

public interface PersonDAO extends JpaRepository<Person, Integer> {

}
