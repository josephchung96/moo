package com.jc.moo;

import static spark.Spark.*;

import com.google.gson.Gson;
import com.jc.moo.Response.WebResponse;

public class App {
	
	public App() {
    	final ContactService contactService = new ContactServiceListImpl();
    	
    	before((request, response) -> response.type("application/json"));
    	
    	get("/contact", (req, res) -> "Welcome to the Joe Chung's Address Book API");
    	
    	get("/contact/:surname", (req, res) -> {
    		return new Gson().toJson(contactService.getContactBySurname(req.params(":surname")));
    	});
    	
    	get("add/contact", (req, res) -> {
    		contactService.addUser(new Contact("Joe", "Johnson")); // adding a hard-coded contact
    		return new Gson().toJson(new Response(WebResponse.SUCCESS, "Contact successfully added"));
    	});	
	}
	
    public static void main( String[] args ) {
    	new App();
    }
}
