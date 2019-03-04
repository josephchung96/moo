package com.jc.moo;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import org.junit.ClassRule;

import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpClientException;
import com.despegar.http.client.HttpResponse;
import com.despegar.sparkjava.test.SparkServer;

import junit.framework.TestCase;
import spark.servlet.SparkApplication;

public class AppTest extends TestCase {
	
	protected ArrayList<Contact> contactList;
	
	public static class TestApp implements SparkApplication {
		@Override
		public void init() {
			new App();
		}
	}
	
	@ClassRule
	public static SparkServer<TestApp> testServer = new SparkServer<>(AppTest.TestApp.class, 4567);
	
	protected void setUp() {
		contactList = new ArrayList<>();
	}
    
    public void testApp() {
    	GetMethod welcomeGetMethod = testServer.get("/contact", false);
    	GetMethod addContactGetMethod = testServer.get("add/contact", false);
    	GetMethod addContactGetMethod2 = testServer.get("add/Joe/Brown", false);
    	GetMethod searchGetMethod = testServer.get("contact/Johnson", false);
    	GetMethod searchGetMethod2 = testServer.get("contact/Brown", false);
    	try {
			HttpResponse httpResponse = testServer.execute(welcomeGetMethod);
			assertEquals("Welcome to the Joe Chung's Address Book API", 
					new String(httpResponse.body())); // check if the server is up
			httpResponse = testServer.execute(searchGetMethod);
			assertEquals("{\"status\":\"FAIL\",\"message\":\"No contacts found with surname: Johnson\"}", 
					new String(httpResponse.body())); // check to see if user exists first (should fail)
			httpResponse = testServer.execute(addContactGetMethod);
			assertEquals("{\"status\":\"SUCCESS\",\"message\":\"Contact successfully added\"}", 
					new String(httpResponse.body())); // add the user in 
			httpResponse = testServer.execute(searchGetMethod);
			assertEquals("{\"status\":\"SUCCESS\",\"jsonMessage\":{\"forename\":\"Joe\",\"surname\":\"Johnson\"}}", 
					new String(httpResponse.body())); // check if the user details are displayed back
			httpResponse = testServer.execute(searchGetMethod2);
			assertEquals("{\"status\":\"FAIL\",\"message\":\"No contacts found with surname: Brown\"}", 
					new String(httpResponse.body()));
			httpResponse = testServer.execute(addContactGetMethod2);
			assertEquals("{\"status\":\"SUCCESS\",\"jsonMessage\":{\"Successfully added Joe Brown\"}}", 
					new String(httpResponse.body()));
			httpResponse = testServer.execute(searchGetMethod2);
			assertEquals("{\"status\":\"SUCCESS\",\"jsonMessage\":{\"forename\":\"Joe\",\"surname\":\"Brown\"}}", 
					new String(httpResponse.body()));
		} catch (HttpClientException e) {
			e.printStackTrace();
			fail("Error connecting");
		}
    }
}
