package eero.dogfood.B2B;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.captivePortalPage;
import eero.dogfood.clientConnectPage;
import eero.dogfood.multiSsidPage;
import eero.dogfood.pingToolsPage;
import eero.dogfood.settingsPage;
import eero.dogfood.eeroos.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BusinessNetworkCases extends BaseTest {
//code from branch
	// Create and enable Subnet A and configure it as Business network

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Create and enable Subnet A and configure it as Business network  ", dataProvider = "getData", priority = 1)
	private void C29192(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		while (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement)) {
			multiSsidPage.clickElement(multiSsidPage.subnetAElement);
			multiSsidPage.clickElement(multiSsidPage.deleteWifiElement);
			multiSsidPage.clickElement(multiSsidPage.confirmDelete);
		}
		multiSsidPage.clickaddWifi();
		multiSsidPage.addBusinessSSID();
		multiSsidPage.enterssidName(input.get("subnet A Business ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		multiSsidPage.clickSave();
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			System.out.println("Business network created successfully on subnet A");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("subnet A Business ssid"));
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				System.out.println("C29192 testcase pass");
			} else {
				System.out.println("C29192 testcase fail");

			}
			baseTest.getscreenshot(driver, "pingstatus");
		} else {
			System.out.println("Unable to create subnet A iot ssid");
			System.out.println("Testcase failed");
		}
		driver.activateApp("com.eero.android.dogfood");
	}

	// Create and enable Subnet A and configure it as IoT network
	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Create and enable Subnet A and configure it as IoT network ", priority = 2, dataProvider = "getData")

	private void C233647(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		// click on home
		homePage.clickElement(homePage.homeBtnElement);
		// click on settings
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		// click on multissid
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		while (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement)) {
			multiSsidPage.clickElement(multiSsidPage.subnetAElement);
			multiSsidPage.clickElement(multiSsidPage.deleteWifiElement);
			multiSsidPage.clickElement(multiSsidPage.confirmDelete);
			Thread.sleep(35000);
		}
		multiSsidPage.clickaddWifi();
		// click on add business ssid
		multiSsidPage.addIOTSSID();
		// Enter iot SSID name and password
		multiSsidPage.enterssidName(input.get("subnet A iot ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		// Check whether Business SSID is created in APP
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("iot network created successfully on subnet A");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet A iot ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("subnet A iot ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				System.out.println("C233647 testcase pass");
			} else {
				System.out.println("C233647 testcase fail");

			}
			baseTest.getscreenshot(driver, "pingstatus");
		} else {
			System.out.println("Unable to create subnet A iot ssid");
			System.out.println("Testcase failed");
		}
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "  Create and enable Subnet B and configure it as Business Subnet ", priority = 3, dataProvider = "getData")

	private void C235445(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		// click on home
		homePage.clickElement(homePage.homeBtnElement);
		// click on settings
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		// click on multissid
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		while (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement)) {
			multiSsidPage.clickElement(multiSsidPage.subnetAElement);
			multiSsidPage.clickElement(multiSsidPage.deleteWifiElement);
			multiSsidPage.clickElement(multiSsidPage.confirmDelete);
		}
		multiSsidPage.clickaddWifi();
		// click on add business ssid
		multiSsidPage.addIOTSSID();
		// Enter business SSID name and password
		multiSsidPage.enterssidName(input.get("subnet A iot ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		multiSsidPage.clickaddWifi();
		multiSsidPage.addBusinessSSID();
		// Enter business SSID name and password
		multiSsidPage.enterssidName(input.get("subnet B Business ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		// Check whether Business SSID is created in APP
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetBElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("Business network created successfully on subnet B");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet B Business ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("subnet B Business ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				System.out.println("C235445 testcase pass");
			} else {
				System.out.println("C235445 testcase fail");
			}
			baseTest.getscreenshot(driver, "pingstatus");
		}
		// If business network not created print testcase failed
		else {
			System.out.println("Unable to create Sub B as business ssid");
			System.out.println("Testcase failed");
		}
		// Reload the dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Create and enable Subnet B and configure it as IoT Subnet ", priority = 4, dataProvider = "getData") // 1

	private void C23963(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		// click on home
		homePage.clickElement(homePage.homeBtnElement);
		// click on settings
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		// click on multissid
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		while (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement)) {
			multiSsidPage.clickElement(multiSsidPage.subnetAElement);
			multiSsidPage.clickElement(multiSsidPage.deleteWifiElement);
			multiSsidPage.clickElement(multiSsidPage.confirmDelete);

		}
		multiSsidPage.clickaddWifi();
		// click on add business ssid
		multiSsidPage.addIOTSSID();
		// Enter business SSID name and password
		multiSsidPage.enterssidName(input.get("subnet A iot ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		multiSsidPage.clickaddWifi();
		multiSsidPage.addIOTSSID();
		// Enter business SSID name and password
		multiSsidPage.enterssidName(input.get("subnet B iot ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		// Check whether Business SSID is created in APP
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetBElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("iot network created successfully on subnet B");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet B iot ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("subnet B iot ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				System.out.println("C23963 testcase pass");
			} else {
				System.out.println("C23963 testcase fail");
			}
			baseTest.getscreenshot(driver, "pingstatus");
		}
		// If business network not created print testcase failed
		else

		{
			System.out.println("Unable to create Sub B as business ssid");
			System.out.println("Testcase failed");
		}
		// Reload the dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "Captive Portal - Enable/Disable Captive Portal", priority = 5)
	private void C37224() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		multiSsidPage.clickElement(multiSsidPage.enableCaptivePortalElement);
		multiSsidPage.clickElement(multiSsidPage.confirmDisablElement);
		multiSsidPage.clickSave();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetwork(guestwifi);
		captivePortalPage captivePortalPage = new captivePortalPage(driver);
		Thread.sleep(20000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(captivePortalPage.captiveportalnetworkElement));
			System.out.println("captive portal is still visible, Testcase failed");
			captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
			captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("captive portal is not visible after disabling captive portal");
		}
		driver.activateApp("com.eero.android.dogfood");
		Thread.sleep(10000);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage.clickGuest();
		multiSsidPage.clickElement(multiSsidPage.enableCaptivePortalElement);
		multiSsidPage.clickSave();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage.connectToNetwork(guestwifi);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(captivePortalPage.captiveportalnetworkElement));
			System.out.println("captive portal is  visible, Testcase pass");
			Thread.sleep(10000);
			captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
			captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
			Thread.sleep(10000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

		} catch (Exception e) {
			clientConnectPage.clickElement(clientConnectPage.disconnectElement);
			clientConnectPage.clickElement(clientConnectPage.connectelement);
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(captivePortalPage.captiveportalnetworkElement));
				System.out.println("captive portal is  visible after captive portal enabled,C37224 Testcase pass");
				Thread.sleep(10000);
				captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
				captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
				Thread.sleep(10000);
				while (homePage.homeBtnElement.isDisplayed()) {
					driver.pressKey(new KeyEvent(AndroidKey.BACK));
				}
			} catch (Exception e1) {
				System.out.println("captive portal is not visible, C37224 Testcase fail");
			}
		}

		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "Disable guest network", priority = 6)

	private void C28492() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		String guestnameString = multiSsidPage.getWifiName();
		multiSsidPage.clickElement(multiSsidPage.toggleElement);
		multiSsidPage.clickElement(multiSsidPage.confirmDisablElement);
		multiSsidPage.clickSave();
		Thread.sleep(30000);
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		try {
			driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ guestnameString + "\").instance(0))"));
			System.out.println("Guest network disable failed, C28492 Testcase failed");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Guest network disabled successfully,C28492 Testcase passed");
		}
		driver.activateApp("com.eero.android.dogfood");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\dogfood.json";
		List<HashMap<String, String>> data = getJsondata(filepath);
		// if need to run more than once add parameters to this and add more details
		return new Object[][] { { data.get(1) } };
	}

}
