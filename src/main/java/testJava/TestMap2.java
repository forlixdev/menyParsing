package testJava;

import java.util.Arrays;
import java.util.List;

public class TestMap2 {

		
	public static void main(String[] args) throws InterruptedException {

		List<String> list = Arrays.asList("fields3","fields1","fields1","fields2","fields1","fields2","fields1");
		
		Long i = list.stream().filter(x->x.equals("fields2")).count();
		System.out.println(i);
	
		String a = "prima seconda terza quarta";
		System.out.println(a.substring(0,100));
		
		
	}

}
