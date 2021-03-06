package com.jc.moo;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
	
	private Gson gson = new Gson();

	@Override
	public String render(Object obj) throws Exception {
		return gson.toJson(obj);
	}

}
