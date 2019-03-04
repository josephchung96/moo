package com.jc.moo;

import java.util.ArrayList;

public interface ContactService {
	
	public void addUser(Contact contact);
	
	public ArrayList<Contact> getUsers();
	
	public Response getContactBySurname(String surname);
	
	public void deleteUser(Contact contact);

}
