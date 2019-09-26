package testJava;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestRestAssuredStatusArrayJson {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://www.localhost:3000";
		String responseString=RestAssured.given().get("/status").asString();
		String responseStringInverted=RestAssured.given().get("/status_inverted").asString();				
		
		System.out.println(responseStringInverted);
		//System.out.println(responseStringInverted);
		
		String path = "documents";
		
		TaskStatus ts = JsonPath.from(responseString).getObject("$.", TaskStatus.class);
		
		System.out.println(ts.getDocumentStatus("doc-1").getOriginalUri());
		
		
	}

}
