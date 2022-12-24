package com.contact.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CONTACTS")
@Data
public class ContactEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private long contactNum;
}
