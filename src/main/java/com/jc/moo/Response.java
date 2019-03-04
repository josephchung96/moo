package com.jc.moo;

import com.google.gson.JsonElement;

public class Response {
	
	public enum HttpResponse {
		ERROR, 
		FAIL, 
		SUCCESS
	}
	
	private HttpResponse status;
	private String message;
	private JsonElement jsonMessage;
	
	public Response(HttpResponse status) {
		this.status = status;
	}
	
	public Response(HttpResponse status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Response(HttpResponse status, JsonElement jsonMessage) {
		this.status = status;
		this.jsonMessage = jsonMessage;
	}
	
	public HttpResponse getStatus() {
		return status;
	}

	public void setStatus(HttpResponse status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public JsonElement getJsonMessage() {
		return jsonMessage;
	}
	
	public void setJsonMessage(JsonElement jsonElement) {
		this.jsonMessage = jsonElement;
	}

}
