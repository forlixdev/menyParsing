package testJava;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSeleniumTab {

	public static void openUrlOnaNewWindow(WebDriver wd, String baseUrl, String otherUrl, String finalUrl) {
		wd.get(baseUrl);
		By element = By.tagName("body");
		wd.findElement(element).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(wd.getWindowHandles());
		wd.switchTo().window(tabs.get(1)); // switches to new tab
		wd.get(otherUrl);
		wd.switchTo().window(tabs.get(0)); // switch back to main screen
		wd.get(finalUrl);
	}

	public static void switchWindow(WebDriver wd) {
		for (String winHandle : wd.getWindowHandles()) {
			wd.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your
												// newly opened window)
		}
	}

	public void closeWindow(WebDriver wd) {
		String windowsHandle = wd.getWindowHandle();
		wd.close();
		wd.switchTo().window(windowsHandle);
	}

	public static void main(String[] args) throws InterruptedException {

		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();


		// navigate to the url
		driver.get("https://chercher.tech/python/windows-selenium-python.php");
		// get the Session id of the Parent
		String parentGUID = driver.getWindowHandle();
		// click the button to open new window
		driver.findElement(By.id("two-window")).click();
		Thread.sleep(5000);
		// get the All the session id of the browsers
		Set<String> allGUID = driver.getWindowHandles();

		// pint the title of th epage
		System.out.println("Page title before Switching : " + driver.getTitle());
		System.out.println("Total Windows : " + allGUID.size());
		// iterate the values in the set
		for (String guid : allGUID) {
			if (!guid.equals(parentGUID)) {
				driver.switchTo().window(guid);
				break;
			}
		}

		driver.findElement(By.name("q")).sendKeys("success");
		System.out.println("Page title after Switching to goolge : " + driver.getTitle());
		Thread.sleep(5000);
		// close the browser
		driver.close();
		// switch back to the parent window
		driver.switchTo().window(parentGUID);
		// print the title
		System.out.println("Page title after switching back to Parent: " + driver.getTitle());
	}

}
