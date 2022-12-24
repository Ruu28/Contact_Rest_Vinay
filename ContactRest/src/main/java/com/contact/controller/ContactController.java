package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.contact.entity.ContactEntity;
import com.contact.service.IContactService;

@RestController
public class ContactController {

	@Autowired(required = true)
	private IContactService service;
	
	@PostMapping("/contact")
	public ResponseEntity<String> saveContact(@RequestBody ContactEntity contact){

		return new ResponseEntity<String>(service.addContact(contact), HttpStatus.CREATED);
	}
	@PutMapping("/contact")
	public ResponseEntity<String> updateContact(@RequestBody ContactEntity contact){

		return  new ResponseEntity<String>(service.updateContact(contact), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/contact/{contact_id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contact_id){

		return new ResponseEntity<String>(service.deleteContact(contact_id), HttpStatus.OK);
	}
	@GetMapping("/contact/{contact_id}")
	public ResponseEntity<ContactEntity> findContact(@PathVariable Integer contact_id){

		return new ResponseEntity<ContactEntity>(service.viewConatct(contact_id), HttpStatus.OK);
	}
	@GetMapping("/contact")
	public ResponseEntity<List<ContactEntity>> getAllContacts(){

		return new ResponseEntity<List<ContactEntity>>(service.getAllContacts(),HttpStatus.OK);
	}
}
