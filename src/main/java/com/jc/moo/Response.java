package com.jc.moo;

import com.google.gson.JsonElement;

public class Response {
	
	public enum WebResponse {
		ERROR, 
		FAIL, 
		SUCCESS
	}
	
	private WebResponse status;
	private String message;
	private JsonElement jsonMessage;
	
	public Response(WebResponse status) {
		this.status = status;
	}
	
	public Response(WebResponse status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public Response(WebResponse status, JsonElement jsonMessage) {
		this.status = status;
		this.jsonMessage = jsonMessage;
	}
	
	public WebResponse getStatus() {
		return status;
	}

	public void setStatus(WebResponse status) {
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
