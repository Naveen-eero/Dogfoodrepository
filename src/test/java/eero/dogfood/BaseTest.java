package eero.dogfood;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	public AndroidDriver driver;
	String dogfoodAppName = "com.eero.android.dogfood";
	String dogfoodActivity = "com.eero.android.v3.common.activity.TabBarActivity}";

	@BeforeTest(alwaysRun = true)
	public void BaseConfig() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("platformname", "Android");
		desiredCapabilities.setCapability("appium:udid", "89FX09KX4");
		desiredCapabilities.setCapability("appium:appName", dogfoodAppName);
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

	public void configureAppToeero() throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:appPackage", "com.eero.android.dogfood");
		desiredCapabilities.setCapability("appium:appActivity", "com.eero.android.v3.common.activity.TabBarActivity");

	}

	public void getscreenshot(AndroidDriver driver, String filename) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destString = new File(
				"C://Users//kunnavee//Desktop//Eero Automation//Dogfoodrepository//src//main//java//reports//"
						+ filename + ".png");
		FileUtils.copyFile(source, destString);
	}

	public List<HashMap<String, String>> getJsondata(String jsonFilePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
}
