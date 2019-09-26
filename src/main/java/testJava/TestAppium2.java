package testJava;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class TestAppium2 {

	public static void main(String[] args) throws Exception {

		int a = 1;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		WebDriver driver = null;
		long startTime = System.currentTimeMillis();
		if (a == 1) {
			//capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.1");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "nexus_5_7.1.1");
			capabilities.setCapability("browserName", "chrome");
			//driver = new RemoteWebDriver(new URL("http://172.22.0.2:4723/wd/hub"), capabilities);
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} else {
			capabilities=DesiredCapabilities.chrome();
			capabilities.setCapability("version","70.0.3538.102");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		}
		driver.get("https://qa.signicat.com/james/app/");
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Got James title : \"" + driver.getTitle() + "\" in "+estimatedTime+" ms");
		Thread.sleep(5_000);
		driver.quit();

	}

}
