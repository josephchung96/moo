package com.jc.moo;

import java.util.ArrayList;

public class ContactServiceListImpl implements ContactService {
	
	private ArrayList<Contact> contactList;
	
	public ContactServiceListImpl() {
		contactList = new ArrayList<>();
	}

	@Override
	public void addUser(Contact contact) {
		contactList.add(contact);
	}

	@Override
	public ArrayList<Contact> getUsers() {
		return contactList;
	}

	@Override
	public Contact getContactBySurname(String surname) {
		for (Contact contact : contactList) {
			if (contact.getSurname().equals(surname)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public void deleteUser(Contact contact) {
		contactList.remove(contact);
	}

}
