package eero.dogfood.eeroos;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {
	public static void main(String[] args) throws MalformedURLException {
		// Set up desired capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 3");
		caps.setCapability("platformName", "Android");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("udid", "89FX09KX4");
		caps.setCapability("automationName", "UiAutomator2");

		// Initialize the driver
		URL appiumServerURL = new URL("http://127.0.0.1:4723");
		AndroidDriver driver = new AndroidDriver(appiumServerURL, caps);
		// Navigate to a website
		driver.get("https://www.google.com");
		// Search for something
		WebElement searchBox = driver.findElement(By.id("searchbox")); // Replace with the ID of the search box element
		searchBox.sendKeys("Your search query");
		// Click on search button
		WebElement searchButton = driver.findElement(By.id("searchbutton")); // Replace with the ID of the search button
																				// element
		searchButton.click();
		// Wait for results and perform further actions
		// Close the browser
		driver.quit();
	}
}
