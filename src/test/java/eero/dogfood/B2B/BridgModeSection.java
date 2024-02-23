package eero.dogfood.B2B;

import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.NetworkSettingsPage;
import eero.dogfood.dhcpNatConfPage;
import eero.dogfood.settingsPage;
import eero.dogfood.eeroos.BaseTest;

public class BridgModeSection extends BaseTest {

	@Test(description = "Enable Bridge Mode case", enabled = false, priority = 1)

	private void enableBridgeMode() throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.clickDhcpNat();
		dhcpNatConfPage dhcpNatConfPage = new dhcpNatConfPage(driver);
		dhcpNatConfPage.selectBridge();
		dhcpNatConfPage.clickSave();
		dhcpNatConfPage.clickReboot();
		homePage.clickHome();
	}

	@Test(description = "Disable BridgeMode case", enabled = false, priority = 2)

	private void disableBridgeMode() throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.clickDhcpNat();
		dhcpNatConfPage dhcpNatConfPage = new dhcpNatConfPage(driver);
		dhcpNatConfPage.selectAutomatic();
		dhcpNatConfPage.clickSave();
		dhcpNatConfPage.clickReboot();
		homePage.clickHome();

	}

}
