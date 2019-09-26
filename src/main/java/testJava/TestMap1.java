package testJava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class TestMap1 {

	
	
    public static Map<String,String> quickMap(String...KeyValuePairs) {
    	Map <String, String> map = new HashMap<String,String>();
    	if (KeyValuePairs.length%2==0)  {
    	for(int i=0;i<KeyValuePairs.length;i+=2)
            map.put(KeyValuePairs[i], KeyValuePairs[i+1]);
    	}
    	else {
    		System.out.println("The parameters should be in a even number");
    	}
    	return map;	
    }
	
	
	public static void main(String[] args) throws InterruptedException {

		Map<String,String> map = ImmutableMap.<String, String>builder()
		.put("fields1", "value1")
		.put("fields2", "value2")
		.put("fields3", "value3")
		.build();
		
		map.forEach((k,v)->System.out.println(k+":"+v));
		
		Map<String,String> map2 = quickMap("fields1", "value1","fields2", "value2", "fields3", "value3");
		
		map2.forEach((k,v)->System.out.println(k+":"+v));
	}

}
