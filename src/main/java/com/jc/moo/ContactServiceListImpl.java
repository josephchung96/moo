package com.jc.moo;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.jc.moo.Response.WebResponse;

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
	public Response getContactBySurname(String surname) {
		for (Contact contact : contactList) {
			if (contact.getSurname().equals(surname)) {
				return new Response(WebResponse.SUCCESS, new Gson().toJsonTree(contact));
			}
		}
		return new Response(WebResponse.FAIL, "No contacts found with surname: " + surname);
	}

	@Override
	public void deleteUser(Contact contact) {
		contactList.remove(contact);
	}

}
