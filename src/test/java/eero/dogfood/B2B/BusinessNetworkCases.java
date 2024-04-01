
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

import eero.dogfood.CaptivePortalPage;
import eero.dogfood.ClientConnectPage;
import eero.dogfood.HomePage;
import eero.dogfood.MultiSSIDPage;
import eero.dogfood.PingToolsPage;
import eero.dogfood.SettingsPage;
import eero.dogfood.eeroos.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BusinessNetworkCases extends BaseTest {

	// Create and enable Subnet A and configure it as Business network

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Create and enable Subnet A and configure it as Business network  ", dataProvider = "getData", priority = 1)
	private void C29192(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		while (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement)) {
			MultiSSIDPage.clickElement(MultiSSIDPage.subnetAElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.deleteWifiElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.confirmDelete);
		}
		MultiSSIDPage.clickaddWifi();
		MultiSSIDPage.addBusinessSSID();
		MultiSSIDPage.enterssidName(input.get("subnet A Business ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		MultiSSIDPage.clickSave();
		if (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement) == true) {
			System.out.println("Business network created successfully on subnet A");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("subnet A Business ssid"));
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			PingToolsPage PingToolsPage = new PingToolsPage(driver);
			PingToolsPage.clickElement(PingToolsPage.tabBarElement);
			PingToolsPage.clickElement(PingToolsPage.pingElement);
			PingToolsPage.clickElement(PingToolsPage.pingBtnElement);
			if (PingToolsPage.internetStatuscheck().equals("device online")) {
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
		homePage.clickElement(homePage.HOME_TAB);
		// click on settings
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		// click on multissid
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		while (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement)) {
			MultiSSIDPage.clickElement(MultiSSIDPage.subnetAElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.deleteWifiElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.confirmDelete);
			Thread.sleep(35000);
		}
		MultiSSIDPage.clickaddWifi();
		// click on add business ssid
		MultiSSIDPage.addIOTSSID();
		// Enter iot SSID name and password
		MultiSSIDPage.enterssidName(input.get("subnet A iot ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		// click on save
		MultiSSIDPage.clickSave();
		// Check whether Business SSID is created in APP
		if (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("iot network created successfully on subnet A");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
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
			PingToolsPage PingToolsPage = new PingToolsPage(driver);
			PingToolsPage.clickElement(PingToolsPage.tabBarElement);
			PingToolsPage.clickElement(PingToolsPage.pingElement);
			PingToolsPage.clickElement(PingToolsPage.pingBtnElement);
			if (PingToolsPage.internetStatuscheck().equals("device online")) {
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
		homePage.clickElement(homePage.HOME_TAB);
		// click on settings
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		// click on multissid
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		while (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement)) {
			MultiSSIDPage.clickElement(MultiSSIDPage.subnetAElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.deleteWifiElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.confirmDelete);
		}
		MultiSSIDPage.clickaddWifi();
		// click on add business ssid
		MultiSSIDPage.addIOTSSID();
		// Enter business SSID name and password
		MultiSSIDPage.enterssidName(input.get("subnet A iot ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		// click on save
		MultiSSIDPage.clickSave();
		MultiSSIDPage.clickaddWifi();
		MultiSSIDPage.addBusinessSSID();
		// Enter business SSID name and password
		MultiSSIDPage.enterssidName(input.get("subnet B Business ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		// click on save
		MultiSSIDPage.clickSave();
		// Check whether Business SSID is created in APP
		if (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetBElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("Business network created successfully on subnet B");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
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
			PingToolsPage PingToolsPage = new PingToolsPage(driver);
			PingToolsPage.clickElement(PingToolsPage.tabBarElement);
			PingToolsPage.clickElement(PingToolsPage.pingElement);
			PingToolsPage.clickElement(PingToolsPage.pingBtnElement);
			if (PingToolsPage.internetStatuscheck().equals("device online")) {
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
		homePage.clickElement(homePage.HOME_TAB);
		// click on settings
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		// click on multissid
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		while (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetAElement)) {
			MultiSSIDPage.clickElement(MultiSSIDPage.subnetAElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.deleteWifiElement);
			MultiSSIDPage.clickElement(MultiSSIDPage.confirmDelete);

		}
		MultiSSIDPage.clickaddWifi();
		// click on add business ssid
		MultiSSIDPage.addIOTSSID();
		// Enter business SSID name and password
		MultiSSIDPage.enterssidName(input.get("subnet A iot ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		// click on save
		MultiSSIDPage.clickSave();
		MultiSSIDPage.clickaddWifi();
		MultiSSIDPage.addIOTSSID();
		// Enter business SSID name and password
		MultiSSIDPage.enterssidName(input.get("subnet B iot ssid"));
		MultiSSIDPage.enterssidpassword(input.get("password"));
		// click on save
		MultiSSIDPage.clickSave();
		// Check whether Business SSID is created in APP
		if (MultiSSIDPage.isElementVisible(MultiSSIDPage.subnetBElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("iot network created successfully on subnet B");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
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
			PingToolsPage PingToolsPage = new PingToolsPage(driver);
			PingToolsPage.clickElement(PingToolsPage.tabBarElement);
			PingToolsPage.clickElement(PingToolsPage.pingElement);
			PingToolsPage.clickElement(PingToolsPage.pingBtnElement);
			if (PingToolsPage.internetStatuscheck().equals("device online")) {
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
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		MultiSSIDPage.clickGuest();
		String guestwifi = MultiSSIDPage.getWifiName();
		MultiSSIDPage.clickElement(MultiSSIDPage.enableCaptivePortalElement);
		MultiSSIDPage.clickElement(MultiSSIDPage.confirmDisablElement);
		MultiSSIDPage.clickSave();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetwork(guestwifi);
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(20000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(captivePortalPage.captiveportalnetworkElement));
			System.out.println("captive portal is still visible, Testcase failed");
			captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
			captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("captive portal is not visible after disabling captive portal");
		}
		driver.activateApp("com.eero.android.dogfood");
		Thread.sleep(10000);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage.clickGuest();
		MultiSSIDPage.clickElement(MultiSSIDPage.enableCaptivePortalElement);
		MultiSSIDPage.clickSave();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage.connectToNetwork(guestwifi);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(captivePortalPage.captiveportalnetworkElement));
			System.out.println("captive portal is  visible, Testcase pass");
			Thread.sleep(10000);
			captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
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
				captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
				captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
				Thread.sleep(10000);
				while (homePage.HOME_TAB.isDisplayed()) {
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
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage SettingsPage = new SettingsPage(driver);
		SettingsPage.clickElement(SettingsPage.MULTI_SSID_TAB);
		MultiSSIDPage MultiSSIDPage = new MultiSSIDPage(driver);
		MultiSSIDPage.clickGuest();
		String guestnameString = MultiSSIDPage.getWifiName();
		MultiSSIDPage.clickElement(MultiSSIDPage.toggleElement);
		MultiSSIDPage.clickElement(MultiSSIDPage.confirmDisablElement);
		MultiSSIDPage.clickSave();
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
