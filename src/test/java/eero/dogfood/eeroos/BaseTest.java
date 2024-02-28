package eero.dogfood.eeroos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

	@BeforeTest(alwaysRun = true)
	public void BaseConfig() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Navee");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("udid", getDeviceId());
		capabilities.setCapability("appPackage", "com.eero.android.dogfood");
		capabilities.setCapability("appActivity", "com.eero.android.v3.features.splash.SplashActivity");
		capabilities.setCapability("noReset", true);
		// Specify Appium server URL
		URL appiumServerURL = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(appiumServerURL, capabilities);
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
		File destString = new File(System.getProperty("user.dir") + "\\src\\main\\java\\reports\\" + filename + ".png");
		FileUtils.copyFile(source, destString);
	}

	public String getDeviceId() throws InterruptedException, IOException {
		String deviceId = null;
		String command = "adb devices -l";
		Process process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("device ")) {
				// Extract the device ID from the line
				String[] parts = line.split("\\s+");
				deviceId = parts[0];
				System.out.println("Device ID: " + deviceId);
				// Assuming only one device is connected
				process.waitFor();
				// Wait for the process to complete
			}

		}
		return deviceId;
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
