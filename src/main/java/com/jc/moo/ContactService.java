package com.jc.moo;

import java.util.ArrayList;

public interface ContactService {
	
	public void addUser(Contact contact);
	
	public ArrayList<Contact> getUsers();
	
	public Contact getContactBySurname(String surname);
	
	public void deleteUser(Contact contact);

}
