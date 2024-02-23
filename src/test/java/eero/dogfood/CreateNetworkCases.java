package eero.dogfood;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.eeroos.BaseTest;
import io.appium.java_client.android.Activity;

public class CreateNetworkCases extends BaseTest {

	@Test(enabled = false, priority = 1, description = "Createnetwork dhcp network", dataProvider = "getData")

	void createNetwork(HashMap<String, String> input) throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		addOrReplaceEeroPage addorreplacepage = new addOrReplaceEeroPage(driver);
		homePage.clickStartSetup();
		homePage.clickStartBtn();
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickArrowBtn();
		homePage.clickNext();
		placementTestPage placementtest = new placementTestPage(driver);
		placementtest.selectLoc(input.get("Gateway place"));
		addorreplacepage.enterNetworkName(input.get("Main ssid"));
		addorreplacepage.setNetworkPassword(input.get("password"));
		addorreplacepage.clickArrowBtn();
		addorreplacepage.clickFinishSetup();
		homePage.clickSkip();
		homePage.clickJoinBtn();
		if (homePage.getInternetStatus().equals("Online")) {
			System.out.println("Network Online, Testcase passed");
		} else {
			System.out.println("Network is offline, Testcase failed");
		}

	}

	@Test(enabled = false, priority = 4, description = "Delete network")
	void DeleteNetwork() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickHome();
		settingsPage settingspage = new settingsPage(driver);
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		homepage.clickSettings();
		settingspage.clickNetworkSettings();
		networkSettingsPage.deleteNetwork();
		deleteNetworkPage deletenetworkpage = new deleteNetworkPage(driver);
		deletenetworkpage.keepsubscription();
		deletenetworkpage.confirmDelete();
		deletenetworkpage.clickDeleteBtn();
		deletenetworkpage.clickDeleteBtn();

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = true, priority = 3, description = "Turn On guest network")

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
		driver.runAppInBackground(Duration.ofSeconds(-1));
		BaseTest baseTest = new BaseTest();
		baseTest.configureAppTosettings();
		driver.startActivity(
				new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
		clientConnectPage clientconnectpage = new clientConnectPage(driver);
		clientconnectpage.clickNetwork();
		clientconnectpage.clickInternet();
		clientconnectpage.connectToNetwork(guestname);
		clientconnectpage.enterPassword(guestpassword);
		clientconnectpage.connectToNetwork(guestname);
		clientconnectpage.getClientIp();
		driver.startActivity(
				new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
		// Open ping tools app and check for interntet connectivity
		pingToolsPage pingToolsPage = new pingToolsPage(driver);
		pingToolsPage.clickTabBar();
		pingToolsPage.selectPingFromOptions();
		pingToolsPage.clickPingBtn();
		if (pingToolsPage.internetStatuscheck().equals("device online")) {
			System.out.println("Testcase pass");

		} else {
			System.out.println("testcase failed");
		}

		driver.activateApp("com.eero.android.dogfood");
	}

	@Test(enabled = false, priority = 4, dataProvider = "getData", description = "Set DHCP to custom range ")
	public void C2691(HashMap<String, String> input) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		homePage.clickHome();
		homePage.clickSettings();
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickNetworkSettings();
		NetworkSettingsPage networksettingspage = new NetworkSettingsPage(driver);
		networksettingspage.clickDhcpNat();
		dhcpNatConfPage dhcpnatconf = new dhcpNatConfPage(driver);
		dhcpnatconf.selectManualIpoption();
		dhcpnatconf.selectManulaIpaddr(input.get("Manual ip"));
		dhcpnatconf.clickSave();
		dhcpnatconf.clickReboot();
		homePage.clickHome();
		String internetstat = homePage.getInternetStatus();
		if (internetstat.equals("Online")) {
			System.out.println("Network is Online");
			driver.runAppInBackground(Duration.ofSeconds(-1));
			driver.startActivity(
					new Activity("com.android.settings", "com.android.settings.homepage.SettingsHomepageActivity"));
			clientConnectPage clientConnectPage = new clientConnectPage(driver);
			clientConnectPage.clickNetwork();
			clientConnectPage.clickInternet();
			clientConnectPage.connectToNetwork(input.get("Main ssid"));
			clientConnectPage.enterPassword(input.get("password"));
			clientConnectPage.connectToNetwork(input.get("Main ssid"));
			if (clientConnectPage.getClientIp().substring(0, 7).contains(input.get("Manual ip").substring(0, 7))) {
				System.out.println("Client got ip in Manual subnet");
				driver.startActivity(
						new Activity("ua.com.streamsoft.pingtools", "ua.com.streamsoft.pingtools.MainActivity_AA"));
				// Open ping tools app and check for interntet connectivity
				pingToolsPage pingToolsPage = new pingToolsPage(driver);
				pingToolsPage.clickTabBar();
				pingToolsPage.selectPingFromOptions();
				pingToolsPage.clickPingBtn();
				if (pingToolsPage.internetStatuscheck().equals("device online")) {
					System.out.println("Testcase pass");

				} else {
					System.out.println("testcase failed");
				}
			} else {
				System.out.println("Client ip not matched with manual ip,Testcase failed");
			}
			driver.activateApp("com.eero.android.dogfood");

		} else {
			System.out.println("Network Offline, Testcase failed");
		}
	}

	@Test(enabled = false, priority = 1, description = "Createnetwork static network", dataProvider = "getData")
	public void createStaticNetwork(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickStartSetup();
		homePage.clickStartBtn();
		addOrReplaceEeroPage addOrReplaceEeroPage = new addOrReplaceEeroPage(driver);
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickInternetSettings();
		addOrReplaceEeroPage.clickWanType();
		addOrReplaceEeroPage.selectStaticIp();
		addOrReplaceEeroPage.enterStaticIpdetails(input.get("static ip"), input.get("Subnet"), input.get("Router ip"));
		addOrReplaceEeroPage.clickApply();
		addOrReplaceEeroPage.clicksave();
		placementTestPage placementTestPage = new placementTestPage(driver);
		placementTestPage.selectLoc(input.get("Gateway place"));
		addOrReplaceEeroPage.enterNetworkName(input.get("Main ssid"));
		addOrReplaceEeroPage.setNetworkPassword(input.get("password"));
		addOrReplaceEeroPage.clickArrowBtn();
		addOrReplaceEeroPage.clickFinishSetup();
		homePage.clickSkip();
		homePage.clickJoinBtn();
		String intstatuString = homePage.getInternetStatus();
		if (intstatuString == "Online") {
			System.out.println("Network created successfully");
		} else {
			System.out.println("Network creation failed");
		}
		getscreenshot(driver, input.get("status filename"));
	}

	@Test(enabled = false, priority = 2, description = "Reboot static network")
	public void C2788() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickSettings();
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.restartNetwork();
		networkSettingsPage.clickRestartBtn();
		homePage.clickHome();
		if (homePage.getInternetStatus().equals("Online")) {
			System.out.println("Network rebooted successfully and online");
		} else {
			System.out.println("Network offline,Testcase failed");

		}
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsondata(
				"C:\\Users\\kunnavee\\Desktop\\Eero Automation\\EeroDogfoodApp\\EeroDogfoodApp\\src\\main\\java\\utilities\\dogfood.json");
		return new Object[][] { { data.get(0) } };
	}

}
