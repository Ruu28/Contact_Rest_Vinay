package com.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.entity.ContactEntity;

public interface ContactJPAI extends JpaRepository<ContactEntity, Integer> {

}
