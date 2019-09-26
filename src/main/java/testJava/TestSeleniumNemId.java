package testJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;

public class TestSeleniumNemId {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://qa.signicat.com/std/method/signicat/?id=nemidjs:signicat-standard:en&trailId=james%3A0611201769hu6aoexemelgph8fpepylafg30dwu4r9bnop5s8fqnrez579&documentArtifact=2bsbfo2xs96f07df7mzwsryow&target=https%3A%2F%2Fqa.signicat.com%2Fjames%2Fresponse%3FdocumentArtifact%3D2bsbfo2xs96f07df7mzwsryow%26signatureServiceUrl%3Dhttps%253A%252F%252Fqa.signicat.com%252Fsignatureservice%252Fservices%252Fsignatureservice";

		String user = "//fieldset//input[@aria-label=\"Enter your user ID\"]";
		String pwd = "//fieldset//input[@type=\"password\"]";
		String iframe = "//*[@id=\"nemid_iframe\"]";
		String button = "#nui > div.Box-Content > div > form > div > button.Box-Button-Submit";
		String userToUse = "bettyrubble";
		String pwdToUse = "qwer1234";

		
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(url);
		Thread.sleep(2000);
		
		//switch to frame
		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframe))));

		// insert username
		for (WebElement we : driver.findElements(By.xpath(user))) {
			try {
				we.sendKeys(userToUse);
			} catch (Exception e) {
				System.out.println("Retrying typing user");
			}
			
		}

		//insert password
		for (WebElement we : driver.findElements(By.xpath(pwd))) {
			try {
				we.sendKeys(pwdToUse);
			} catch (Exception e) {
				System.out.println("Retrying typing password");
			}
		}

		//switch to frame again
		driver.findElement(By.cssSelector(button)).click();

		String cardSelector="#section > form > div:nth-child(5)";
		String otpSelector="//label[@class=\"normal-font-weight\"]";
		
//		//pich cardId
//		String otp=driver.findElement(By.xpath(cardSelector)).getText();
//		// pick otp
//		//String otp=driver.findElement(By.xpath(otpSelector)).getText();
//		
//		
//		
//		String otpField="//input[@aria-label=\"Enter code\"]";
//		
//		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframe))));
//		
//		RestAssured.baseURI = "https://appletk.danid.dk/developers/OtpCard?CardSerial="+otp;
//		
		
		
		
		
		Thread.sleep(7000);
		//driver.quit();
	}
}
