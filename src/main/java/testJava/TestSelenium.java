package testJava;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codeborne.selenide.Condition;

public class TestSelenium {

	public static void main(String[] args) throws InterruptedException {

		String selector = "//*[@id=\"method\"]/div[2]/div/div/div/ul/li[7]/div[2]/a";
		String url = "https://qa.signicat.com/std/method/scid/?id=scid-establish-assure-paper:signicat-standard-global:en&target=https%3A%2F%2Fqa.signicat.com%2Fjames%2Fresponse&prefilled.externalRef=pendingAccountTest";

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement element = driver.findElement(By.xpath(selector));
		element.click();
		Thread.sleep(2000);
		driver.quit();

	}

}
