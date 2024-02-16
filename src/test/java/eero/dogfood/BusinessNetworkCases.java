package eero.dogfood;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class BusinessNetworkCases extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "Create an eB network with DHCP", priority = 1, dataProvider = "getData")
	private void createBusinessNetwork(HashMap<String, String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickStartSetup();
		homePage.selectBusiness();
		homePage.clickNext();
		homePage.EnterBusinessName(input.get("Business name"));
		homePage.clickQuickSetup();
		homePage.clickStartBtn();
		homePage.clickNext();
		// for jupiter or crane
		homePage.clickNext();
		placementTestPage placementTestPage = new placementTestPage(driver);
		placementTestPage.selectLoc(input.get("Gateway place"));
		addOrReplaceEeroPage addOrReplaceEeroPage = new addOrReplaceEeroPage(driver);
		addOrReplaceEeroPage.enterNetworkName(input.get("Main ssid"));
		addOrReplaceEeroPage.setNetworkPassword(input.get("password"));
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickFinishSetup();
		addOrReplaceEeroPage.clickMaybeLater();
		homePage.clickJoinBtn();
		homePage.clickLinkToCustmer();
		homePage.clickCloseIcon();
		homePage.clickJoinBtn();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		editMainNetworkPage editMainNetworkPage = new editMainNetworkPage(driver);
		editMainNetworkPage.getMainNetworkName();
		editMainNetworkPage.getMainNetworkPassword();
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();
		clientConnectPage.connectToNetwork(input.get("Main ssid"));
		clientConnectPage.enterPassword(input.get("password"));
		baseTest.getscreenshot(driver, "mainnetworkscreenshot");

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Create and enable Subnet A and configure it as Business network  ", dataProvider = "getData", priority = 1)
	private void C29192(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		// click on home
		homePage.clickHome();
		// click on settings
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		// click on multissid
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		// click on add wifi button
		multiSsidPage.clickaddWifi();
		// click on add business ssid
		multiSsidPage.addBusinessSSID();
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			multiSsidPage.clickSubnetA();
			multiSsidPage.deleteWifi();
			multiSsidPage.clickDelete();
		}
		multiSsidPage.clickaddWifi();
		// click on add business ssid
		multiSsidPage.addBusinessSSID();
		// Enter business SSID name and password
		multiSsidPage.enterssidName(input.get("subnet A Business ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		// Check whether Business SSID is created in APP
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("Business network created successfully on subnet A");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			// click on network settings
			clientConnectPage.clickNetwork();
			// click on internet from network settings
			clientConnectPage.clickInternet();
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickTabBar();
			pingToolsPage.selectPingFromOptions();
			pingToolsPage.clickPingBtn();
			pingToolsPage.internetStatuscheck();
			baseTest.getscreenshot(driver, "pingstatus");
		}
		// If business network not created print testcase failed
		else {
			System.out.println("Unable to create business ssid");
			System.out.println("Testcase failed");
		}
		// Reload the dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@Test(enabled = false, description = "disable Subnet A Business network  ", priority = 3)

	private void C23964() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		// click homebutton
		homePage.clickHome();
		// click settings
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		// goto multissid
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		// Click on the subnet A
		multiSsidPage.clickSubnetA();
		// Disable the toggle
		multiSsidPage.clickEnableToggle();
		// Click on confirm
		multiSsidPage.clickconfirm();
		// Click save btn
		multiSsidPage.clickSave();
		// Run eero in background
		driver.runAppInBackground(Duration.ofSeconds(-1));
		BaseTest baseTest = new BaseTest();
		// Open internet settings
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();
		try {
			// Check for business network in scan list
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(clientConnectPage.businessnetworkssidElement));
			System.out.println("Network not disabled ");
			System.out.println("Testcase failed");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Network is network disabled successfully");
		}
		// Relaunch eero dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = " Create and enable Subnet A and configure it as IoT network ", priority = 4, dataProvider = "getData")

	private void C233647(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			multiSsidPage.clickSubnetA();
			multiSsidPage.deleteWifi();
			multiSsidPage.clickDelete();
		}
		multiSsidPage.clickaddWifi();
		multiSsidPage.addIOTSSID();
		multiSsidPage.enterssidName(input.get("subnet A iot ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		// click on save
		multiSsidPage.clickSave();
		// Check whether Business SSID is created in APP
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			// If Network created in App goto android settings and connect client to
			// business ssid
			System.out.println("IOT subnetA network created successfully");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			// click on network settings
			clientConnectPage.clickNetwork();
			// click on internet from network settings
			clientConnectPage.clickInternet();
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet A iot ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.connectToNetwork(input.get("subnet A iot ssid"));
			// Check for the IP connected to iot network
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickTabBar();
			pingToolsPage.selectPingFromOptions();
			pingToolsPage.clickPingBtn();
			pingToolsPage.internetStatuscheck();
			baseTest.getscreenshot(driver, "Subnet a as iot");
		}
		// If business network not created print testcase failed
		else {
			System.out.println("Unable to create iot  ssid on subnet a");
			System.out.println("Testcase failed");
		}
		// Reload the dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, description = "  Create and enable Subnet B and configure it as Business Subnet ", priority = 2, dataProvider = "getData")

	private void C235445(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == false) {
			// create a subnet A network
			multiSsidPage.clickaddWifi();
			// click on add business ssid
			multiSsidPage.addBusinessSSID();
			// Enter business SSID name and password
			multiSsidPage.enterssidName(input.get("subnet A Business ssid"));
			multiSsidPage.enterssidpassword(input.get("password"));
			// click on save
			multiSsidPage.clickSave();
		}
		multiSsidPage.clickaddWifi();
		multiSsidPage.addIOTSSID();
		multiSsidPage.enterssidName(input.get("subnet B Business ssid"));
		multiSsidPage.enterssidpassword(input.get("password"));
		multiSsidPage.clickSave();
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetBElement) == true) {
			// If Network created in App goto android settings and connect client to
			// IOT ssid
			System.out.println("IOT network created successfully");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			BaseTest baseTest = new BaseTest();
			baseTest.configureAppTosettings();
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			clientConnectPage.clickNetwork();
			clientConnectPage.clickInternet();
			clientConnectPage.clickInternet();
			// click on business SSID enter password
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.connectToNetwork(input.get("subnet A Business ssid"));
			// Check for the IP connected to business network
			clientConnectPage.getClientIp();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			// Open ping tools app and check for interntet connectivity
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickTabBar();
			pingToolsPage.selectPingFromOptions();
			pingToolsPage.clickPingBtn();
			pingToolsPage.internetStatuscheck();
			baseTest.getscreenshot(driver, "pingstatus");
		}
		// If business network not created print testcase failed
		else {
			System.out.println("Unable to create business ssid");
			System.out.println("Testcase failed");
		}
		// Reload the dogfood app
		driver.activateApp("com.eero.android.dogfood");
	}

	@Test(enabled = false, description = "  Delete subnet B (IoT network) ", priority = 4)

	private void C37191() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickSubB();
		multiSsidPage.deleteWifi();
		multiSsidPage.clickDelete();
	}

	@Test(enabled = false, description = "Disable guest network", priority = 5)

	private void C28492() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickGuest();
		multiSsidPage.clickEnableToggle();
		multiSsidPage.clickconfirm();
		multiSsidPage.clickSave();
		Thread.sleep(30000);
		driver.runAppInBackground(Duration.ofSeconds(-1));

	}

	@Test(enabled = false, description = " Captive Portal - Doesn't support Captive Portal on Subnet A (Business Network) ", priority = 1)

	private void C37222() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickSubnetA();
		try {
			if (multiSsidPage.isElementVisible(multiSsidPage.enableCaptivePortalElement) == true) {
				System.out.println("element found");

			}
		} catch (Exception e) {
			System.out.println("element is not visible");
		}

	}

	@Test(enabled = false, description = "  Rate limit - Unable to enable rate limiting on Subnet A (Business network) ", priority = 1)
	private void C37220() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickSubnetA();
		if (multiSsidPage.isElementVisible(multiSsidPage.enableCaptivePortalElement) == true) {
			System.out.println("Element is present");
		} else {
			System.out.println("element not present");
		}

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsondata(
				"C:\\Users\\kunnavee\\Desktop\\Eero Automation\\EeroDogfoodApp\\EeroDogfoodApp\\src\\main\\java\\utilities\\dogfood.json");
		// if need to run more than once add parameters to this and add more details
		return new Object[][] { { data.get(1) } };
	}

}