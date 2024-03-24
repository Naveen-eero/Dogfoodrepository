
package eero.dogfood.B2B;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.BrowserScreen;
import eero.dogfood.CaptivePortalPage;
import eero.dogfood.ClientConnectPage;
import eero.dogfood.EditGuestNetworkPage;
import eero.dogfood.EditMainNetworkPage;
import eero.dogfood.HomePage;
import eero.dogfood.MultiSSIDPage;
import eero.dogfood.SettingsPage;
import eero.dogfood.eeroos.BaseTest;
import io.appium.java_client.android.Activity;

//Preconditions
//Network with 3 nodes gateway , wiredleaf and wirless leaf
//Network is added with add_serial_to_ssid feature flag

public class ClientRedirectionOnDifferentBrowsersSection extends BaseTest {
	String guestNameString;

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Open Captive portal using Chrome ", priority = 1, dataProvider = "getData", suiteName = "captive portal")

	private void C36850(HashMap<String, String> input) throws InterruptedException, AWTException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickElement(settingsPage.MultiSsid);
		MultiSSIDPage multiSsidPage = new MultiSSIDPage(driver);
		multiSsidPage.clickGuest();
		EditGuestNetworkPage editGuestNetworkPage = new EditGuestNetworkPage(driver);
		guestNameString = editGuestNetworkPage.getGuestNetworkName();
		homePage.clickElement(homePage.HOME_TAB);
		if (input.get("Topology").equalsIgnoreCase("CrHH")) {
			homePage.clickElement(homePage.wirelessleafElement);
		} else {
			homePage.clickElement(homePage.gatewayElement);
		}
		homePage.clickDeviceInfo();
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestNameString, sernumString);
		Thread.sleep(10000);
		String currentActivity = driver.currentActivity();
		String[] activityParts = currentActivity.split("\\.");
		String appName = activityParts[activityParts.length - 1];
		System.out.println("Current running app name: " + appName);
		if (appName == "CaptivePortalLoginActivity") {
			driver.runAppInBackground(Duration.ofSeconds(-1));
		}
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
		BrowserScreen chromeBrowserPages = new BrowserScreen(driver);
		chromeBrowserPages.clickElement(chromeBrowserPages.menuElement);
		chromeBrowserPages.clickElement(chromeBrowserPages.incognitotabElement);
		chromeBrowserPages.clickElement(chromeBrowserPages.searchBarElement);
		chromeBrowserPages.enterUrl(chromeBrowserPages.searchBarElement, input.get("captiveportal url1"));
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(10000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with first URL");
		} else {
			System.out.println("client didn't redirected to captive portal with first URL,Testcase failed");
		}
		chromeBrowserPages.clickElement(chromeBrowserPages.menuElement);
		chromeBrowserPages.clickElement(chromeBrowserPages.incognitotabElement);
		chromeBrowserPages.clickElement(chromeBrowserPages.searchBarElement);
		chromeBrowserPages.enterUrl(chromeBrowserPages.searchBarElement, input.get("captiveportal url2"));
		Thread.sleep(20000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with second URL,testcase pass");
		} else {
			System.out.println("client didn't redirected to captive portal with second URL,Testcase failed");
		}
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "  Open Captive portal using edge browser  ", priority = 2, dataProvider = "getData", suiteName = "captive portal")

	private void C36852(HashMap<String, String> input)
			throws InterruptedException, MalformedURLException, AWTException {
		BaseTest baseTest = new BaseTest();
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.wiredLeafElement);
		homePage.clickElement(homePage.deviceInfo);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestNameString, sernumString);
		Thread.sleep(10000);
		String currentActivity = driver.currentActivity();
		String[] activityParts = currentActivity.split("\\.");
		String appName = activityParts[activityParts.length - 1];
		System.out.println("Current running app name: " + appName);
		if (appName == "CaptivePortalLoginActivity") {
			driver.runAppInBackground(Duration.ofSeconds(-1));
		}
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(new Activity("com.microsoft.emmx", "com.microsoft.ruby.Main"));
		Thread.sleep(10000);
		BrowserScreen edgeBrowserPages = new BrowserScreen(driver);
		edgeBrowserPages.clickElement(edgeBrowserPages.edgeBrowerTabsElement);
		edgeBrowserPages.clickElement(edgeBrowserPages.edgeBrowserPrivateTabElement);
		edgeBrowserPages.clickElement(edgeBrowserPages.addIncogElement);
		edgeBrowserPages.enterUrl(edgeBrowserPages.searchBarElement, input.get("captiveportal url1"));
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(10000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with first URL");
		} else {
			System.out.println("client didn't redirected to captive portal with first URL,Testcase failed");
		}
		edgeBrowserPages.clickElement(edgeBrowserPages.edgeAddNewTabElement);
		edgeBrowserPages.enterUrl(edgeBrowserPages.searchBarElement, input.get("captiveportal url2"));
		Thread.sleep(20000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with second URL,testcase pass");
		} else {
			System.out.println("client didn't redirected to captive portal with second URL,Testcase failed");
		}
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "  Open Captive portal using Firefox browser  ", priority = 3, dataProvider = "getData", suiteName = "captive portal")

	private void C36853(HashMap<String, String> input)
			throws InterruptedException, MalformedURLException, AWTException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.wirelessleafElement);
		homePage.clickElement(homePage.deviceInfo);
		String sernumString = homePage.getSerial();
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));

		ClientConnectPage clientConnectPage = new ClientConnectPage(driver);
		clientConnectPage.connectToNetworkwithserial(guestNameString, sernumString);
		Thread.sleep(10000);
		String currentActivity = driver.currentActivity();
		String[] activityParts = currentActivity.split("\\.");
		String appName = activityParts[activityParts.length - 1];
		System.out.println("Current running app name: " + appName);
		if (appName == "CaptivePortalLoginActivity") {
			driver.runAppInBackground(Duration.ofSeconds(-1));
		}
		driver.runAppInBackground(Duration.ofSeconds(-1));
		driver.startActivity(new Activity("org.mozilla.firefox", "org.mozilla.firefox.App"));
		Thread.sleep(10000);
		BrowserScreen firefoxPage = new BrowserScreen(driver);
		if (firefoxPage.firefoxIncognitoElement.isDisplayed() == true) {
			firefoxPage.clickElement(firefoxPage.firefoxIncognitoElement);
		}
		firefoxPage.enterUrl(firefoxPage.firefoxSearchElement, input.get("captiveportal url1"));
		CaptivePortalPage captivePortalPage = new CaptivePortalPage(driver);
		Thread.sleep(10000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with first URL");
		} else {
			System.out.println("client didn't redirected to captive portal with first URL,Testcase failed");
		}
		firefoxPage.clickElement(firefoxPage.firefoxNewTabElement);
		firefoxPage.clickElement(firefoxPage.firefoxaddnewIncogElement);
		firefoxPage.enterUrl(firefoxPage.firefoxSearchElement, input.get("captiveportal url2"));
		Thread.sleep(10000);
		if (captivePortalPage.nextBtnElement.isDisplayed() == true) {
			System.out.println(" client redirected to captive portal with second URL,testcase pass");
		} else {
			System.out.println("client didn't redirected to captive portal with second URL,Testcase failed");
		}
		driver.activateApp("com.eero.android.dogfood");
		homePage.clickElement(homePage.HOME_TAB);
		homePage.clickElement(homePage.SETTINGS_TAB);
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickOnElement(settingsPage.wifinamePasswordElement);
		EditMainNetworkPage editMainNetworkPage = new EditMainNetworkPage(driver);
		String networkname = editMainNetworkPage.getNetworkName();
		String password = editMainNetworkPage.getNetworkPassword();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.Settings$NetworkProviderSettingsActivity"));
		clientConnectPage.connectToNetworkwithserial(networkname, sernumString);
		clientConnectPage.enterPassword(password);
		driver.runAppInBackground(Duration.ofSeconds(-1));
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
