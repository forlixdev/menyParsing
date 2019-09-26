package testJava;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import com.google.common.collect.ImmutableMap;

import io.restassured.path.xml.XmlPath;

public class TestJTwig {

	   private static final Logger log = LogManager.getLogger(TestJTwig.class.getName());
	
	public static void main(String[] args) {
		
		
		JtwigTemplate template = JtwigTemplate.inlineTemplate("Ciao {{ default(name, 'Tizio')}}");
		JtwigModel model = JtwigModel
							.newModel(
									ImmutableMap.<String, Object>builder()
									//.put("name","Francesco")
									.build()
									);
		String xmlBody = template.render(model);
		log.debug(xmlBody);   
		
	}
	
}
