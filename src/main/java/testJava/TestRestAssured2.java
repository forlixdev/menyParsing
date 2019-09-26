package testJava;

import java.util.Arrays;import java.util.stream.Collector;
import java.util.stream.Collectors;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestRestAssured2 {

	
	
	
	
	public static void main(String[] args) {

		RestAssured.baseURI = "https://my-json-server.typicode.com/typicode/demo/posts";
		Response resp = RestAssured.given().get();
		JsonPath jp = resp.getBody().jsonPath();
		System.out.println("Resp:\n"+jp.prettyPrint());

		Book[] books = jp.getObject(".", Book[].class);
		
	 for (Book b: books) 
		 System.out.println(b.getTitle());
	 
	 	String s= "Post 2";
	 	Book myBook = Arrays.asList(books).stream().filter(x->x.getTitle().equalsIgnoreCase(s)).findAny().orElse(null);
	 	System.out.println(myBook.getTitle()+":"+myBook.getId());
		
	}

}
