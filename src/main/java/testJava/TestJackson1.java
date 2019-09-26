package testJava;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson1 {

	static String create(String field1, int field2) throws JsonProcessingException {
		ObjectToMap3 object3 = new ObjectToMap3.Builder().field1(field1).field2(field2).build();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object3);
	}

	public static void main(String[] args) throws JsonProcessingException {

//		ObjectMapper objectMapper = new ObjectMapper();
//		ObjectToMap2 ob2 = new ObjectToMap2.Builder().field1("AAAAH").array("Gino", "Pino", "Rino").build();
//		ObjectToMap object2 = new ObjectToMap.Builder().field1("yellow").field2(2).objectToMap2(ob2).build();
//		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object2));

		System.out.println(create("gino", 10));
		
	}

}
