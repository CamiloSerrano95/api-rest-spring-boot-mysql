package com.apirest.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dao.PersonDAO;
import com.apirest.model.Person;

@RestController
@RequestMapping("api/person")
public class PersonRest {
	@Autowired
	private PersonDAO personDAO;
	
	@PostMapping("/create")
	public void store(@RequestBody Person person){
		personDAO.save(person);
	}
	
	@GetMapping("/all")
	public List<Person> getAll() {
		return personDAO.findAll();
	}
	
	 @GetMapping("/{id}") 
	 public ResponseEntity<Person> getTutoriById(@PathVariable("id") Integer id) {
	    Optional<Person> personData = personDAO.findById(id);

	    if (personData.isPresent()) {
	      return new ResponseEntity<>(personData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 }
	
	@PutMapping("update")
	public void update(@RequestBody Person person){
		personDAO.save(person);
	}
	
	@DeleteMapping("/delete/{id}")
	public void destroy(@PathVariable("id") Integer id){
		personDAO.deleteById(id);
	}
}
