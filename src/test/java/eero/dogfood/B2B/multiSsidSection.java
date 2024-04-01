package eero.dogfood.B2B;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.BrowserScreen;
import eero.dogfood.CaptivePortalPage;
import eero.dogfood.ClientConnectPage;
import eero.dogfood.HomePage;
import eero.dogfood.MultiSSIDPage;
import eero.dogfood.PingToolsPage;
import eero.dogfood.SettingsPage;
import eero.dogfood.eeroos.BaseTest;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class multiSsidSection extends BaseTest {

	// WAN access - Devices connected to gateway can reach the Internet when
	// WAN_access is enabled

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Main network - WAN access - Devices connected to gateway can reach the Internet when WAN_access is enabled  ", priority = 1, dataProvider = "getData")
	private void C37206(HashMap<String, String> input) throws InterruptedException, IOException {

		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.HOME_TAB);
		if (input.get("Topology").equalsIgnoreCase("CrHH")) {
			System.out.println("Skipping C37206 test case since Crane doesn't have wifi radio");
		} else {
			homePage.clickElement(homePage.gatewayElement);
			homePage.clickElement(homePage.DEVICE_INFO);
			String sernumString = homePage.getSerial();
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
			clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.clickOnwifidetails(input.get("Main ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			PingToolsPage pingToolsPage = new PingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				driver.runAppInBackground(Duration.ofSeconds(-1));
				driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
				BrowserScreen chromeBrowserPages = new BrowserScreen(driver);
				chromeBrowserPages.clickElement(chromeBrowserPages.menuElement);
				chromeBrowserPages.clickElement(chromeBrowserPages.incognitotabElement);
				chromeBrowserPages.clickElement(chromeBrowserPages.searchBarElement);
				chromeBrowserPages.enterUrl(chromeBrowserPages.searchBarElement, input.get("internetCheckUrl1"));
				if (chromeBrowserPages.googlePageElement.isDisplayed() == true) {
					System.out.println("able to reach webpage");
					chromeBrowserPages.clickElement(chromeBrowserPages.menuElement);
					chromeBrowserPages.clickElement(chromeBrowserPages.incognitotabElement);
					chromeBrowserPages.clickElement(chromeBrowserPages.searchBarElement);
					chromeBrowserPages.enterUrl(chromeBrowserPages.searchBarElement, input.get("internetCheckUrl2"));
					if (chromeBrowserPages.googlePageElement.isDisplayed() == true) {
						System.out.println("able to reach webpage");
					} else {
						System.out.println("Unable to reacch webpage");
					}

				}
				System.out.println("Testcase C37206 pass");
			} else {
				System.out.println("Testcase C37206 fail");

			}
			baseTest.getscreenshot(driver, "pingstatus main network gateway");
			driver.activateApp("com.eero.android.dogfood");

		}
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Main network- WAN access - Devices connected to wireless leaf can reach the Internet when WAN_access is enabled ", priority = 2, dataProvider = "getData")
	private void C37208(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.WIRELESS_LEAF);
		homePage.clickElement(homePage.DEVICE_INFO);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		// Check for the IP connected to business network
		clientConnectPage.getClientIp();
		BaseTest baseTest = new BaseTest();
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		PingToolsPage pingToolsPage = new PingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		if (pingToolsPage.internetStatuscheck().equals("device online")) {
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
			BrowserScreen chromeBrowserPages = new BrowserScreen(driver);
			chromeBrowserPages.clickElement(chromeBrowserPages.menuElement);
			chromeBrowserPages.clickElement(chromeBrowserPages.incognitotabElement);
			chromeBrowserPages.clickElement(chromeBrowserPages.searchBarElement);
			chromeBrowserPages.enterUrl(chromeBrowserPages.searchBarElement, input.get("internetCheckUrl1"));
			System.out.println("Testcase C37208 pass");
		} else {
			System.out.println("Testcase C37208 fail");

		}
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Main network- WAN access - Devices connected to wired leaf can reach the Internet when WAN_access is enabled  ", priority = 3, dataProvider = "getData")
	private void C385604(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.DEVICE_INFO);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("Main ssid"));
		// Check for the IP connected to business network
		clientConnectPage.getClientIp();
		BaseTest baseTest = new BaseTest();
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		PingToolsPage pingToolsPage = new PingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		if (pingToolsPage.internetStatuscheck().equals("device online")) {
			System.out.println("Testcase C385604 pass");
		} else {
			System.out.println("Testcase C385604 fail");

		}
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Guest Network-  WAN access - Devices connected to gateway can reach the Internet when WAN_access is enabled ", priority = 4, dataProvider = "getData")
	private void C37146(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickElement(settingsPage.MULTI_SSID_TAB);
		MultiSSIDPage multiSsidPage = new MultiSSIDPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.HOME_TAB);
		if (input.get("Topology").equalsIgnoreCase("CrHH")) {
			System.out.println("Skipping C37206 test case since Crane doesn't have wifi radio");
		} else {
			homePage.clickElement(homePage.gatewayElement);
			homePage.clickElement(homePage.DEVICE_INFO);
			String sernumString = homePage.getSerial();
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
			clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
			CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
			Thread.sleep(10000);
			captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
			captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
			captivePortalPage.guestSuccess();
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(10000);
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			PingToolsPage pingToolsPage = new PingToolsPage(driver);
			pingToolsPage.clickElement(pingToolsPage.tabBarElement);
			pingToolsPage.clickElement(pingToolsPage.pingElement);
			pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
			if (pingToolsPage.internetStatuscheck().equals("device online")) {
				System.out.println("Testcase C37146 pass");
			} else {
				System.out.println("Testcase C37146 fail");
			}
			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));
			clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
			clientConnectPage.enterPassword(input.get("password"));
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.activateApp("com.eero.android.dogfood");
		}
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "Guest Network-  WAN access - Devices connected to wired leaf can reach the Internet when WAN_access is enabled ", priority = 5, dataProvider = "getData")
	private void C37148(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickElement(settingsPage.MULTI_SSID_TAB);
		MultiSSIDPage multiSsidPage = new MultiSSIDPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.DEVICE_INFO);
		String sernumString = homePage.getSerial();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(10000);
		captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
		captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
		captivePortalPage.guestSuccess();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(10000);
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		PingToolsPage pingToolsPage = new PingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		if (pingToolsPage.internetStatuscheck().equals("device online")) {
			System.out.println("Testcase C37148 pass");
		} else {
			System.out.println("Testcase C37148 fail");
		}
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "Guest Network-  WAN access - Devices connected to wireless leaf can reach the Internet when WAN_access is enabled ", priority = 6, dataProvider = "getData")
	private void C385605(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickElement(settingsPage.MULTI_SSID_TAB);
		MultiSSIDPage multiSsidPage = new MultiSSIDPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.WIRELESS_LEAF);
		homePage.clickElement(homePage.DEVICE_INFO);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));

		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));

		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(10000);
		captivePortalPage.clickElement(captivePortalPage.NEXT_BUTTON);
		captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
		captivePortalPage.guestSuccess();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(10000);
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		PingToolsPage pingToolsPage = new PingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		if (pingToolsPage.internetStatuscheck().equals("device online")) {
			System.out.println("Testcase  C385605 pass");
		} else {
			System.out.println("Testcase  C385605 fail");
		}
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Subnet A business network- WAN access - Devices connected to gateway can reach the Internet when WAN_access is enabled ", priority = 7, dataProvider = "getData")
	private void C37155(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.gatewayElement);
		homePage.clickElement(homePage.DEVICE_INFO);
		String sernumString = homePage.getSerial();

		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));

		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("subnet A Business ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("subnet A Business ssid"));
		// Check for the IP connected to business network
		clientConnectPage.getClientIp();
		BaseTest baseTest = new BaseTest();
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		PingToolsPage pingToolsPage = new PingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		pingToolsPage.internetStatuscheck();
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\utilities\\dogfood.json";
		List<HashMap<String, String>> data = getJsondata(filepath);
		// if need to run more than once add parameters to this and add more details
		return new Object[][] { { data.get(0) } };
	}
}
