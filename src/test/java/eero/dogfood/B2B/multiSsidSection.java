package eero.dogfood.B2B;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.captivePortalPage;
import eero.dogfood.clientConnectPage;
import eero.dogfood.multiSsidPage;
import eero.dogfood.pingToolsPage;
import eero.dogfood.settingsPage;
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
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.gatewayElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("Main ssid"));
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
		pingToolsPage.internetStatuscheck();
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Main network- WAN access - Devices connected to wireless leaf can reach the Internet when WAN_access is enabled ", priority = 2, dataProvider = "getData")
	private void C37208(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.wirelessleafElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("Main ssid"));
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
		pingToolsPage.internetStatuscheck();
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Main network- WAN access - Devices connected to wired leaf can reach the Internet when WAN_access is enabled  ", priority = 3, dataProvider = "getData")
	private void C385604(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("Main ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("Main ssid"));
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
		pingToolsPage.internetStatuscheck();
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Guest Network-  WAN access - Devices connected to gateway can reach the Internet when WAN_access is enabled ", priority = 4, dataProvider = "getData")
	private void C37146(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.gatewayElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
		captivePortalPage captivePortalPage = new captivePortalPage(driver);
		Thread.sleep(10000);
		captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
		captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
		captivePortalPage.guestSuccess();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(10000);
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		pingToolsPage pingToolsPage = new pingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		pingToolsPage.internetStatuscheck();
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "Guest Network-  WAN access - Devices connected to wired leaf can reach the Internet when WAN_access is enabled ", priority = 5, dataProvider = "getData")
	private void C37148(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
		captivePortalPage captivePortalPage = new captivePortalPage(driver);
		Thread.sleep(10000);
		captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
		captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
		captivePortalPage.guestSuccess();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(10000);
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		pingToolsPage pingToolsPage = new pingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		pingToolsPage.internetStatuscheck();
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "Guest Network-  WAN access - Devices connected to wireless leaf can reach the Internet when WAN_access is enabled ", priority = 5, dataProvider = "getData")
	private void C385605(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		String guestwifi = multiSsidPage.getWifiName();
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestwifi, sernumString);
		captivePortalPage captivePortalPage = new captivePortalPage(driver);
		Thread.sleep(10000);
		captivePortalPage.clickElement(captivePortalPage.nextBtnElement);
		captivePortalPage.clickElement(captivePortalPage.connectBtnElement);
		captivePortalPage.guestSuccess();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(10000);
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		pingToolsPage pingToolsPage = new pingToolsPage(driver);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
		pingToolsPage.internetStatuscheck();
		driver.activateApp("com.eero.android.dogfood");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = " Subnet A business network- WAN access - Devices connected to gateway can reach the Internet when WAN_access is enabled ", priority = 7, dataProvider = "getData")
	private void C37155(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.gatewayElement);
		homePage.clickElement(homePage.advancedElement);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		try {
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.Settings$WifiSettingsActivity"));
		} catch (Exception e) {

			driver.startActivity(new Activity("com.android.settings",
					"com.android.settings.Settings$NetworkProviderSettingsActivity"));

		}
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(input.get("subnet A Business ssid"), sernumString);
		clientConnectPage.enterPassword(input.get("password"));
		clientConnectPage.clickOnwifidetails(input.get("subnet A Business ssid"));
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
		pingToolsPage.internetStatuscheck();
		baseTest.getscreenshot(driver, "pingstatus");
		driver.activateApp("com.eero.android.dogfood");

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsondata(
				"C:\\Users\\kunnavee\\Desktop\\Eero Automation\\EeroDogfoodApp\\EeroDogfoodApp\\src\\main\\java\\utilities\\dogfood.json");
		// if need to run more than once add parameters to this and add more details
		return new Object[][] { { data.get(1) } };
	}
}
