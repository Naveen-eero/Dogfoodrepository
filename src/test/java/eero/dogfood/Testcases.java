package eero.dogfood;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

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

	void TurnOnGuest() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickGuestconf();
		editGuestNetworkPage editguestpage = new editGuestNetworkPage(driver);
		editguestpage.clickenableGuestToggle();
		String guestname = editguestpage.getGuestNetworkName();
		String guestpassword = editguestpage.getGuestPassword();
		editguestpage.saveGuestChanges();
		Activity activity1 = new Activity("com.android.settings",
				"com.android.settings.homepage.SettingsHomepageActivity");
		driver.startActivity(activity1);
		clientConnectPage clientconnectpage = new clientConnectPage(driver);
		clientconnectpage.clickNetwork();
		clientconnectpage.clickInternet();
		Thread.sleep(5000);
		clientconnectpage.connectToGuest(guestname);
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();

		homePage.clickActivity();

	}

}
