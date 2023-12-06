package eero.dogfood;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class BridgeModecases extends BaseTest {
	String networkSettingsApp = "com.android.settings";
	String networkSettingsActivity = "com.android.settings.homepage.SettingsHomepageActivity ";

	@Test
	public void turnonBridge() throws InterruptedException, MalformedURLException {

		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.clickDhcpNat();
		dhcpNatConf dhcpnatconf = new dhcpNatConf(driver);
		dhcpnatconf.selectBridge();
		dhcpnatconf.clickSave();
		dhcpnatconf.clickReboot();
		Thread.sleep(50000);
		DesiredCapabilities capabilities = new DesiredCapabilities(driver.getCapabilities().asMap());
		capabilities.setCapability("appium:appPackage", networkSettingsApp);
		capabilities.setCapability("appium:appActivity", networkSettingsActivity);
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, capabilities);
		capabilities.setCapability("appium:noReset", true);
		Thread.sleep(3000);
		clientConnectPage clientconnectpage = new clientConnectPage(driver);
		clientconnectpage.clickNetwork();

	}

}
