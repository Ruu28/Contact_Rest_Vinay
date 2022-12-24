package com.contact.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contact.Exception.ContactNotFoundException;
import com.contact.dao.ContactJPAI;
import com.contact.entity.ContactEntity;
@Service
public class ContactServiceImpl implements IContactService {

	@Autowired(required = true)
	private ContactJPAI db;
	
	@Override
	public String addContact(ContactEntity contact) {
		String msg="CONTACT HAS BEEN SAVED SUCESSFULLY ";
		ContactEntity savedContact = db.save(contact);
		
		if(savedContact.getContactId()==null)
			msg="CONTACT HAS BEEN NOT BEEN SAVED";
		
		return msg;
	}

	@Override
	public ContactEntity viewConatct(Integer contact_id) {
		 ContactEntity contact = db.findById(contact_id)
				.orElseThrow(()->new ContactNotFoundException("Contact not found with id:"+contact_id));
			
		return contact;
	}

	@Override
	public String deleteContact(Integer contact_id) {
		if(db.existsById(contact_id))
		{
			db.deleteById(contact_id);
			return "CONTACT IS DELETED";
		}
		return "CONTACT IS NOT PRESENT";
	}

	@Override
	public String updateContact(ContactEntity contact) {
		if(db.existsById(contact.getContactId()))
		{
			db.save(contact);
			return "CONTACT SAVED SUCESSFULLY";
		}
		return "CONTACT IS NOT PRESENT";
	}

	@Override
	public List<ContactEntity> getAllContacts() {
		
		return db.findAll();
	}

}
