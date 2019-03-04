package com.jc.moo;

import static spark.Spark.*;

import com.google.gson.Gson;

public class App {
	
    public static void main( String[] args ) {
    	final ContactService contactService = new ContactServiceListImpl();
    	
    	before((request, response) -> response.type("application/json"));
    	
    	get("/contact", (req, res) -> "Welcome to the Address Book API");
    	
    	get("/contact/:surname", (req, res) -> {
    		return new Gson().toJson(contactService.getContactBySurname(req.params(":surname")));
    	});
    }
}
