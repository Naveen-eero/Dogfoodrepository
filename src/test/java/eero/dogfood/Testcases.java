package eero.dogfood;

import org.testng.annotations.Test;

public class Testcases extends BaseTest {
	@Test
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

	void CreateNetwork() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickAddBtn();
		homePage.clickOkBtn();
		homePage.clickaddnetwork();

	}

}
