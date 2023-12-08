package eero.dogfood;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Testcases extends BaseTest {
	@Test(enabled = false)
	void DeleteNetwork() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		settingsPage settingspage = new settingsPage(driver);
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		homepage.clickHome();
		homepage.clickSettings();
		settingspage.clickNetworkSettings();
		networkSettingsPage.deleteNetwork();
		deleteNetworkPage deletenetworkpage = new deleteNetworkPage(driver);
		deletenetworkpage.deleteNetwork();
		deletenetworkpage.confirmDelete();

	}

	@Test

	void CreateNetwork() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickGuestconf();
		editGuestNetworkPage editguestpage = new editGuestNetworkPage(driver);
		editguestpage.changeGuestPassword("Naveen kumar");
		editguestpage.clickenableGuestToggle();
		editguestpage.saveGuestChanges();
		driver.act
		DesiredCapabilities capabilities = new DesiredCapabilities(driver.getCapabilities().asMap());
		capabilities.setCapability("appium:appPackage", "com.android.settings");
		capabilities.setCapability("appium:appActivity", );
		capabilities.setCapability("appium:noReset", true);
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, capabilities);
		clientConnectPage clientconnectpage = new clientConnectPage(driver);
		clientconnectpage.clickNetwork();
	}

}
