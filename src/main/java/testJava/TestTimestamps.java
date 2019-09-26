package testJava;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestTimestamps {
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Thread.sleep(111);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println(estimatedTime);

		Files.lines(Paths.get("/tmp/testo.txt"))
			//.filter(x -> x.split("\\s+")[4] == "STREAM")
			.forEach(System.out::println);

	}
}
