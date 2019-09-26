package testJava;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAppium1 {


public static void main(String[] args) throws Exception {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.10.1");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus_5_7.1.1");
			//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//			capabilities.setCapability("launchActivity ", "com.android.browser");
			
			
			
			
			capabilities.setCapability("newCommandTimeout", 2000);
			AndroidDriver mobiledriver = new AndroidDriver<>(new URL("http://172.22.0.4:/wd/hub"), capabilities);
			mobiledriver.get("https://qa.signicat.com/james/app/");
			System.out.println(mobiledriver.getCurrentUrl());
			System.out.println(mobiledriver.getTitle());
			Thread.sleep(10_000);
			WebElement element = mobiledriver.findElement(By.className("android.widget.ScrollView"));
		    Actions actions = new Actions(mobiledriver);
		    actions.moveToElement(element);
			
			mobiledriver.findElement(By.cssSelector("body > div.wrapper-container > div > div.content > div > ul > li:nth-child(6) > a"));
			mobiledriver.findElement(By.cssSelector("#method > div.body > div > div > div > form > div.user-id > input")).sendKeys("frafor");
			mobiledriver.findElement(By.cssSelector("#method > div.body > div > div > div > form > div.password-form-controls > div > input")).sendKeys("gnegne");
			mobiledriver.findElement(By.cssSelector("#method > div.footer > div > div.right > button")).click();
			
	}

}
