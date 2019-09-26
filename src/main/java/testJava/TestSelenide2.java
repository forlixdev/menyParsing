package testJava;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;

public class TestSelenide2 {

	public static void main(String[] args) throws InterruptedException {

		String documentLink = "/html/body/div[3]/div/div/section/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div/div/div[1]/button";
		String clickAcceptCheckbox = "body > div.wrapper.top.full_width_height > div > div > section > div > div > div.full_width_height.document_presentation.lm_view.lm_center > div > div > div > div > div.content.footer > div > div > div > div > div.column.left > div > label";
		String continueButton = "body > div.wrapper.top.full_width_height > div > div > section > div > div > div.full_width_height.document_presentation.lm_view.lm_center > div > div > div > div > div.content.footer > div > div > div > div > div.column.right > button > img";
		String iframe = "iframe[title='BankID']";
		String NbidTitle = "body > div.wrapper.top.full_width_height > div > div > header > div > div > div > div.column.left > div > div > div.full_width_height.lm_view.lm_center > div > div > div > div > h1";
				
		String  personalNumber="input[type='tel'";
		String  otp="input[type='text'";
		String  password="div.wrp > input[type='password']";
		String  nextButton="div.call_to_action_wrapper > button[type='submit']";
		
		
		//System.setProperty("selenide.browser", "org.openqa.selenium.firefox.FirefoxDriver");
		
		
		String url = "https://qa.signicat.com/std/docaction/signicat?request_id=101220181pkwxkalughblz2ntc8qugog4rnfldui6mc6smak1fo1quff54&task_id=1&artifact=263u22k3gdyukfmtvh842zq75";
		open(url);
		Thread.sleep(5000);
		switchTo().frame($(By.cssSelector(iframe)));
		//switchTo().frame(1);
		$(By.xpath(documentLink)).click();
		Thread.sleep(1000);
		switchTo().window(0);
		Thread.sleep(1000);
		switchTo().frame($(By.cssSelector(iframe)));
		$(By.cssSelector(clickAcceptCheckbox)).click();
		$(By.cssSelector(continueButton)).click();
		Thread.sleep(1000);
		switchTo().frame($(By.cssSelector(iframe)));
		$(By.cssSelector(personalNumber)).shouldBe(Condition.visible).sendKeys("10109001886");
		$(By.cssSelector(nextButton)).click();
		$(By.cssSelector(otp)).shouldBe(Condition.visible).sendKeys("otp");
		$(By.cssSelector(nextButton)).click();
		$(By.cssSelector(password)).shouldBe(Condition.visible).sendKeys("qwer1234");
		$(By.cssSelector(nextButton)).click();
		//switchTo().
		Thread.sleep(4000);
	}

}
