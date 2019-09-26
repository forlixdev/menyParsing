package testJava;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

public class TestSelenide {

	public static void main(String[] args) throws InterruptedException {
//		open("https://the-internet.herokuapp.com");
//		Thread.sleep(1000);
//		$(By.xpath("//*[@id=\"content\"]/ul/li[9]/a")).should(appear).shouldBe(visible).click();
//		Thread.sleep(1000);
//		$(By.xpath("/html//select[@id='dropdown']")).selectOption("Option 1");
//		Thread.sleep(1000);
//		open("https://the-internet.herokuapp.com/iframe");
//		$(By.cssSelector("#mce_0_ifr")).shouldBe(Condition.visible).sendKeys("AAAAAAAA");
//		Thread.sleep(2000);
		String aaa= "//*[@id=\"method\"]/div[2]/div/div/div/ul/li[7]/div[2]/a";
		open("https://qa.signicat.com/std/method/scid/?id=scid-establish-assure-paper:signicat-standard-global:en&target=https%3A%2F%2Fqa.signicat.com%2Fjames%2Fresponse&prefilled.externalRef=pendingAccountTest");
		$(By.xpath(aaa)).should(Condition.appear).click();
		Thread.sleep(2000);
		
	}

}
