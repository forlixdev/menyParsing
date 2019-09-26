package testJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSeleniumNbid {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://qa.signicat.com/std/docaction/signicat?request_id=190220195m88qgv2ke4ymnsqcy3zyd4ej7yzaejmddglld9kuwy1mxjzy0&task_id=1&artifact=cwd1u95d9ncpaolfuz8dsa9t7";

		String ndib_user1_name = "10109001886";
		String ndib_user1_otp = "otp";
		String ndib_user1_passord = "qwer1234";

		String buttonCss = "body > div > div.wrapper > start-overview > div.pop-up.overview-screen.start.active > div.task-overview.pop-up-wrapper > div:nth-child(3) > div > ul > li > i.material-icons.forward-icon";
		String acceptCss = "#document-wrapper > div:nth-child(5) > div > div.bottom-menu-wrapper > div.menu-buttons > button:nth-child(1)";
		String firstFrameCss = "iframe#method-frame";
		String secondFrameCss = "iframe[title='BankID']";
		String userCss = "input[type='tel']";
		String otpCss = "input[type='text'";
		String passwordCss = "div.wrp > input[type='password']";

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(url);
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(buttonCss)).click();
		driver.findElement(By.cssSelector(acceptCss)).click();

		Thread.sleep(3_000);
		
		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(firstFrameCss))));
		Thread.sleep(3_000);
		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(secondFrameCss))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userCss))).sendKeys(ndib_user1_name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(otpCss))).sendKeys(ndib_user1_otp);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(passwordCss))).sendKeys(ndib_user1_passord);
		
		
		
		// switch to frame
		// driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iframe))));

		Thread.sleep(7000);
		// driver.quit();
	}
}
