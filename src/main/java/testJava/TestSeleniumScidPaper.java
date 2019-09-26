package testJava;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codeborne.selenide.Condition;

public class TestSeleniumScidPaper {

	public static void main(String[] args) throws InterruptedException {

		String paperElementXPath = "//a[text()=\"ID Paper verification\"]";
		String url = "https://qa.signicat.com/std/method/scid/?id=scid-establish-assure-paper:signicat-standard-global:en&target=https%3A%2F%2Fqa.signicat.com%2Fjames%2Fresponse&prefilled.externalRef=pendingAccountTest";

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(paperElementXPath));
		element.click();
		Thread.sleep(2000);
		driver.quit();

	}

}
