package testJava;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSeleniumBrowserCamera {

	public static void main(String[] args) {
		
		//WebDriver driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "use-fake-ui-for-media-stream"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://qa.signicat.com/std/method/scid/?id=scid-proof-assure-paper::&trailId=james%3A240920149caq2ig65rcvcibtp6a5zqqvrhx5wfjq6xwfnhm4t97k5vfqu&target=https%3A%2F%2Fqa.signicat.com%2Fjames%2Fresponse");
		WebElement element = driver.findElement(By.cssSelector("#method > div.body > div > div > div:nth-child(1) > div:nth-child(7) > button.button.secondary"));
		element.click();
		//driver.quit();
		
		
		
	}
	
	
}
