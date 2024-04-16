package eero.dogfood.eeroos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AndroidDriver driver1;
	public AppiumDriverLocalService service;

	@BeforeSuite
	public void startServer() {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\tkarthis\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
	}

	@BeforeTest(alwaysRun = true)
	public void BaseConfig() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("udid", getDeviceIds().get(0));
		System.out.println("device id: " + getDeviceIds().get(0));
		capabilities.setCapability("platformversion", getAndroidVersion(getDeviceIds().get(0)));
		System.out.println("device android version:" + getAndroidVersion(getDeviceIds().get(0)));
		capabilities.setCapability("deviceName", getDeviceName(getDeviceIds().get(0)));
		System.out.println("device android version:" + getDeviceName(getDeviceIds().get(0)));
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "com.eero.android.dogfood");
		capabilities.setCapability("appActivity", "com.eero.android.v3.features.splash.SplashActivity");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoGrantPermissions", true); // Specify Appium server URL
		URL appiumServerURL = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(appiumServerURL, capabilities);
		Thread.sleep(10000);
		if (getDeviceIds().size() > 1) {
			try {
				DesiredCapabilities capabilities1 = new DesiredCapabilities();
				capabilities1.setCapability("platformName", "Android");
				capabilities1.setCapability("udid", getDeviceIds().get(1));
				System.out.println("device id: " + getDeviceIds().get(1));
				capabilities1.setCapability("platformversion", getAndroidVersion(getDeviceIds().get(1)));
				System.out.println("device android version:" + getAndroidVersion(getDeviceIds().get(1)));
				capabilities1.setCapability("deviceName", getDeviceName(getDeviceIds().get(1)));
				System.out.println("device name:" + getDeviceName(getDeviceIds().get(1)));
				capabilities1.setCapability("automationName", "UiAutomator2");
				capabilities1.setCapability("appPackage", "ua.com.streamsoft.pingtools");
				capabilities1.setCapability("appActivity", "ua.com.streamsoft.pingtools.MainActivity_AA");
				capabilities1.setCapability("noReset", true);
				// Specify Appium server URL
				URL appiumServerURL1 = new URL("http://127.0.0.1:4724");
				driver1 = new AndroidDriver(appiumServerURL1, capabilities1);
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("second device not found");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void configureTochrome(AndroidDriver driver) throws MalformedURLException {
		UiAutomator2Options desiredCapabilities = new UiAutomator2Options();
		desiredCapabilities.setCapability("browserName", "Chrome");
		URL appiumServerURL = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(appiumServerURL, desiredCapabilities);
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

	public static List<String> getDeviceIds() throws IOException, InterruptedException {
		List<String> deviceIds = new ArrayList<>();
		String command = "adb devices -l";
		Process process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains("device prod")) {
				// Extract the device ID from the line
				String[] parts = line.split("\\s+");
				// Store the device ID
				deviceIds.add(parts[0]);
			}
		}
		process.waitFor();
		// Wait for the process to complete
		return deviceIds;
	}

	public String getAndroidVersion(String deviceID) throws IOException {
		String adbCommand = "adb -s " + deviceID + " shell getprop ro.build.version.release";
		Process process = Runtime.getRuntime().exec(adbCommand);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		return reader.readLine();

	}

	public String getDeviceName(String deviceID) throws IOException {
		String adbCommand = "adb -s " + deviceID + " shell getprop ro.product.model";
		Process process = Runtime.getRuntime().exec(adbCommand);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		return reader.readLine();

	}

	public String getDevicemanufacturer(String deviceID) throws IOException {
		String adbCommand = "adb -s " + deviceID + " shell getprop ro.product.brand";
		Process process = Runtime.getRuntime().exec(adbCommand);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		return reader.readLine();

	}

	public void changeCountryCode() {
		try {
			String curlCommand = "curl -L -X POST \"https://admin.stage.e2ro.com/api/networks/networkid/country_code\" -H \"x-admin-token: admin token\" -H \"Content-Type: application/json\" --data-raw \"{\\\"country_code\\\": \\\"CA\\\"}\"";
			// Execute the curl command
			ProcessBuilder processBuilder = new ProcessBuilder(curlCommand.split("\\s+"));
			Process process = processBuilder.start();
			// Get the output
			InputStream inputStream = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			// Get the error stream
			InputStream errorStream = process.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
			while ((line = errorReader.readLine()) != null) {
				System.out.println("Error: " + line);
			}
			// Wait for the process to complete
			int exitCode = process.waitFor();
			System.out.println("Exit Code: " + exitCode);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
		service.stop();
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
