package com.contact.service;

import java.util.List;

import com.contact.entity.ContactEntity;

public interface IContactService {

	public String addContact(ContactEntity contact);
	public ContactEntity viewConatct(Integer contact_id);
	public String deleteContact (Integer contact_id);
	public String updateContact(ContactEntity contact);
	public List<ContactEntity> getAllContacts();
	
	
}
