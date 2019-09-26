package testJava;

import java.util.List;

import io.restassured.RestAssured;

public class TestRestAssuredArrayJson {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://www.mocky.io/v2/5cd98c5c3000008320c016e7";
		System.out.println("ssss");
		// RestAssured.given().get().then().body("comments.id",
		// containsInAnyOrder(1,2));
		// RestAssured.given().get().then().body("documents.id",
		// containsInAnyOrder("doc-2","doc-1"))
		List<String> idList = RestAssured.given().get().jsonPath().getList("documents.id");
		idList.forEach(System.out::println);
		assert	(idList.contains("doc-3"));
		//assertThat(RestAssured.given().get().jsonPath().getList("documents.id"), contains("doc-1"));
		
	}

}
