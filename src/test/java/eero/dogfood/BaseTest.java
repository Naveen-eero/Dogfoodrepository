package eero.dogfood;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	// Dogfood capabilities
	public AndroidDriver driver;
	String dogfoodAppName = "com.eero.android.dogfood";
	String dogfoodActivity = "com.eero.android.v3.common.activity.TabBarActivity";

	@BeforeTest
	public void BaseConfig() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("platformname", "Android");
		desiredCapabilities.setCapability("appium:udid", "89FX09KX4");
		desiredCapabilities.setCapability("appium:appPackage", dogfoodAppName);
		desiredCapabilities.setCapability("appium:appActivity", dogfoodActivity);
		desiredCapabilities.setCapability("appium:noReset", true);
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);

	}

	public void configureAppTosettings() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:appPackage", "com.android.settings");
		desiredCapabilities.setCapability("appium:appActivity",
				"com.android.settings.homepage.SettingsHomepageActivity");

	}

	public void configureAppToPingTools() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:appPackage", "ua.com.streamsoft.pingtools");
		desiredCapabilities.setCapability("appium:appActivity", "ua.com.streamsoft.pingtools.MainActivity_AA");

	}
}
