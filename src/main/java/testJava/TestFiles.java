package testJava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.io.Files;

public class TestFiles {

	private static final Logger log = LogManager.getLogger(TestFiles.class.getName());
	
	public static void main(String[] args) throws IOException {
		
		String pippo="pippo";
		Files.write(pippo.getBytes(),new File("/tmp/pippo_test"));
	
		log.info(Paths.get("/tmp","pippo").toAbsolutePath().toString());
		
	}
	
}
