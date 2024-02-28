package eero.dogfood.eeroos;

import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.NetworkSettingsPage;
import eero.dogfood.dhcpNatConfPage;
import eero.dogfood.settingsPage;

public class BridgModeSection extends BaseTest {

	@Test(description = "Enable Bridge Mode case", enabled = false, priority = 1)

	private void enableBridgeMode() throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.clickDhcpNat();
		dhcpNatConfPage dhcpNatConfPage = new dhcpNatConfPage(driver);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.BridgeModeCheck);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.savebtnElement);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.rebootBtnElement);
		homePage.clickElement(homePage.homeBtnElement);
	}

	@Test(description = "Disable BridgeMode case", enabled = true, priority = 2)

	private void disableBridgeMode() throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.clickDhcpNat();
		dhcpNatConfPage dhcpNatConfPage = new dhcpNatConfPage(driver);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.AutomaticCheckBtn);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.savebtnElement);
		dhcpNatConfPage.clickElement(dhcpNatConfPage.rebootBtnElement);
		homePage.clickElement(homePage.homeBtnElement);

	}

}
