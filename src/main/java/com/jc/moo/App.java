package com.jc.moo;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	before((request, response) -> response.type("application/json"));
    	get("/rest", (req, res) -> new Contact("Joe", "Chung"), new JsonTransformer());
    }
}
