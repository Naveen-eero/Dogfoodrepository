package eero.dogfood;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BusinessNetworkCases extends BaseTest {

	@SuppressWarnings("deprecation")
	@Test(priority = 1, enabled = true)

	private void createBusinessNetwork() throws InterruptedException, MalformedURLException {
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
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickWifiNameAndPassword();
		editMainNetworkPage editMainNetworkPage = new editMainNetworkPage(driver);
		editMainNetworkPage.getMainNetworkName();
		editMainNetworkPage.getMainNetworkPassword();
		String eerosourceString = driver.getPageSource();
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();
		clientConnectPage.connectToMain();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		homePage.clickHome();
		homePage.getInternetStatus();
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 2)
	private void createBusinessSSID() throws InterruptedException, MalformedURLException {
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
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientConnectPage = new clientConnectPage(driver);
		clientConnectPage.clickNetwork();
		clientConnectPage.clickInternet();
		clientConnectPage.connectToBusiness();
		clientConnectPage.enterPassword("11112222");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		clientConnectPage.connectToBusiness();
		clientConnectPage.getClientIp();
		baseTest.configureAppToPingTools();
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		pingToolsPage pingToolsPage = new pingToolsPage(driver);
		pingToolsPage.clickTabBar();
		pingToolsPage.selectPingFromOptions();
		pingToolsPage.clickPingBtn();
		pingToolsPage.internetStatuscheck();
	}
}