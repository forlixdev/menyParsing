package testJava;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.commons.validator.routines.UrlValidator;

public class TestUrl {

	public static boolean urlValidator(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (URISyntaxException exception) {
			return false;
		} catch (MalformedURLException exception) {
			return false;
		}
	}
	
	public static boolean apacheUrlValidator(String url) {
		UrlValidator defaultValidator = new UrlValidator();
		return defaultValidator.isValid(url);
		}
	

	public static void main(String[] args) throws InterruptedException {

		String url = "https:/";

		// Validate an url
		if (urlValidator(url)) {
			System.out.println("The URL " + url + " is valid");
		} else {
			System.out.println("The URL " + url + " is not valid");
		}

		// Validate an url
		if (apacheUrlValidator(url)) {
			System.out.println("The URL " + url + " is valid with Apache");
		} else {
			System.out.println("The URL " + url + " is not valid with Apache");
		}
		
		

	}

}
