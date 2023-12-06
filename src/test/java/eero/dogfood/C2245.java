package eero.dogfood;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class C2245 {

	private AndroidDriver driver;

	// App1 capabilities
	String eeroAppPackageName = "com.eero.android.dogfood";
	String eeroAppActivityName = "com.eero.android.v3.features.splash.SplashActivity";

	// App2 capabilities
	String wifimanAppPackageName = "com.ubnt.usurvey";
	String wifimanAppActivityName = "com.ubnt.usurvey.ui.splash.SplashActivity";

	// App3 capabilities
	String networkSettingsApp = "com.android.settings";
	String networkSettingsActivity = "com.android.settings.homepage.SettingsHomepageActivity ";

	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:udid", "89FX09KX4");
		desiredCapabilities.setCapability("appium:appPackage", "com.eero.android.dogfood");
		desiredCapabilities.setCapability("appium:appActivity", "com.eero.android.v3.features.splash.SplashActivity");
		desiredCapabilities.setCapability("appium:noReset", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	@Test
	public void sampleTest() throws InterruptedException, IOException {
		driver.findElement(By.id("com.eero.android.dogfood:id/settings")).click();
		Thread.sleep(3000); // Sleep for 1000 milliseconds (1 second)

		// Enter guest access
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Guest Network')]")).click();

		Thread.sleep(3000);

		// switch on guest mode
		driver.findElement(By.xpath("//android.view.View[@resource-id=\"guest_access_screen_id_enable_switch\"]"))
				.click();
		Thread.sleep(50000);
		// grep password

		String myText = driver
				.findElement(By
						.xpath("//android.widget.EditText[@resource-id=\"guest_access_screen_id_network_name_field\"]"))
				.getText();
		System.out.println("Copied text: " + myText);
		Thread.sleep(3000);

		// launch wifiman to check change in ip address.
		DesiredCapabilities capabilities = new DesiredCapabilities(driver.getCapabilities().asMap());
		capabilities.setCapability("appium:appPackage", networkSettingsApp);
		capabilities.setCapability("appium:appActivity", networkSettingsActivity);
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, capabilities);
		capabilities.setCapability("appium:noReset", true);

		Thread.sleep(3000);

		// click wifi network to switch guest network.
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Network & internet\"]")).click();
		Thread.sleep(3000);
		// click guest network ssid
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[4]")).click();
		Thread.sleep(5000);
		// enter password
		driver.findElement(By.id("com.android.settings:id/password")).sendKeys(myText);
		Thread.sleep(5000);
		// enter connect after entering password
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(10000);

		// take screenshot

		// enter done to come back from wifipage
		driver.findElement(By.id("com.android.settings:id/done")).click();

		// Close wifiman app

		driver.terminateApp(wifimanAppPackageName);

		Thread.sleep(5000);

		// launch ping app to check ping

	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}