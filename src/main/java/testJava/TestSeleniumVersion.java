package testJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSeleniumVersion {

	public static void main(String[] args) {
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
	    driver.get("http://www.javacodegeeks.com/");
		WebElement element = driver.findElement(By.name("s"));
		element.sendKeys("selenuim");
		element.submit();
		String title = driver.getTitle();
		System.out.println(title);
		assert (title.equals("You searched for selenuim | Java Code Geeks"));
		driver.quit();
		
		
		
	}
	
	
}
