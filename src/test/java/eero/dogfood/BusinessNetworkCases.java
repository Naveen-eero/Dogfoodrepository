package eero.dogfood;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class BusinessNetworkCases extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "Create an eB network with DHCP", priority = 1)
	private void createBusinessNetwork() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickStartSetup();
		homePage.selectBusiness();
		homePage.clickNext();
		homePage.EnterBusinessName("Naveen");
		homePage.clickQuickSetup();
		homePage.clickStartbtn();
		homePage.clickNext();
		placementTestPage placementTestPage = new placementTestPage(driver);
		placementTestPage.selectLoc();
		addOrReplaceEeroPage addOrReplaceEeroPage = new addOrReplaceEeroPage(driver);
		addOrReplaceEeroPage.enterNetworkName("Naveen");
		addOrReplaceEeroPage.setNetworkPassword("11112222");
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickFinishSetup();
		addOrReplaceEeroPage.clickMaybeLater();
		homePage.clickJoinBtn();
		homePage.clickLinkToCustmer();
		homePage.clickCloseIcon();
		homePage.clickJoinBtn();
		if (homePage.getInternetStatus() == "Online") {
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
			clientConnectPage.connectToMain();
			baseTest.getscreenshot(driver, "mainnetworkscreenshot");
		} else {
			System.out.println("Network offline ");
		}

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, description = "  Create and enable Subnet A and configure it as Business network  ", priority = 2)
	private void C29192() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickaddWifi();
		multiSsidPage.addBusinessSSID();
		multiSsidPage.enterssidName("Business network");
		multiSsidPage.enterssidpassword("11112222");
		multiSsidPage.clickSave();
		Thread.sleep(30000);
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			System.out.println("Business network created successfully");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			clientConnectPage.clickNetwork();
			clientConnectPage.clickInternet();
			clientConnectPage.connectToBusiness();
			clientConnectPage.enterPassword("11112222");
			clientConnectPage.getClientIp();
			BaseTest baseTest = new BaseTest();
			driver.startActivity(
					new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
			pingToolsPage pingToolsPage = new pingToolsPage(driver);
			pingToolsPage.clickTabBar();
			pingToolsPage.selectPingFromOptions();
			pingToolsPage.clickPingBtn();
			pingToolsPage.internetStatuscheck();
			baseTest.getscreenshot(driver, "pingstatus");

		} else {
			System.out.println("Unable to create business ssid");
			System.out.println("Testcase failed");
		}
		driver.activateApp("com.eero.android.dogfood");
	}

	@Test(enabled = false, description = "disable Subnet A Business network  ", priority = 5)

	private void C23964() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		multiSsidPage.clickSubnetA();
		multiSsidPage.clickEnableToggle();
		multiSsidPage.clickconfirm();
		multiSsidPage.clickSave();
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();

	}

	@Test(enabled = false, description = " Create and enable Subnet A and configure it as IoT network ")

	private void C233647() throws InterruptedException, MalformedURLException {
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
		multiSsidPage.enterssidName("IOT network");
		multiSsidPage.enterssidpassword("12345678");
		multiSsidPage.clickSave();
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();

	}

	@Test(enabled = false, description = "  Create and enable Subnet B and configure it as Business Subnet ", priority = 3)

	private void C235445() throws InterruptedException, MalformedURLException {

		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickMultiSSID();
		multiSsidPage multiSsidPage = new multiSsidPage(driver);
		if (multiSsidPage.isElementVisible(multiSsidPage.subnetAElement) == true) {
			multiSsidPage.clickaddWifi();
			multiSsidPage.addIOTSSID();
			multiSsidPage.enterssidName("subnet B ssid as iot");
			multiSsidPage.enterssidpassword("11112222");
			multiSsidPage.clickSave();
		}

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

	@Test(enabled = false, description = "Disable guest network", priority = 1)

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
	}
}