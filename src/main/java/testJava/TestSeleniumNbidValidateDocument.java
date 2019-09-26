package testJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSeleniumNbidValidateDocument {

	public static void main(String[] args) throws InterruptedException {

		String iframe= "//iframe[contains(@src,'validator')]";
		
		String buttonFile = "#localfile";
		
		String verificationField = "body > div > div.sdoviewer_main > div.back_and_seal > div.verified > div";
		String url = "https://www.bankid.no/privat/los-mitt-bankid-problem/les-signerte-dokumenter";
		
		
		
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get(url);
		Thread.sleep(1_000);
		driver.switchTo().frame(driver.findElement((By.xpath(iframe))));
		driver.findElement(By.cssSelector(buttonFile)).sendKeys("/tmp/myfile");
		Thread.sleep(1_000);
		driver.quit();

	}

}
