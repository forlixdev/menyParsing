package testJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class TestYamlProperty {

	   private static final Logger log = LogManager.getLogger(TestYamlProperty.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		Files.readLines(new File("src/main/resources/prova.yaml"), Charsets.UTF_8).forEach(System.out::println);
		
		Yaml yaml = new Yaml();
		
		Map <String, Object> map = yaml.load(new FileInputStream(new File("src/main/resources/prova.yaml")));
		
		map.forEach((x,y)->System.out.println(x+" --> "+y));
		
		System.out.println(map.get("address"));
		
		
	}
	
}
