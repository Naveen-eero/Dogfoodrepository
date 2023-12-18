package eero.dogfood;

import org.testng.annotations.Test;

public class BridgModeSection extends BaseTest {

	@Test(description = "Enable Bridge Mode case", enabled = false)

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

	@Test(description = "Disable BridgeMode case", enabled = true)

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
