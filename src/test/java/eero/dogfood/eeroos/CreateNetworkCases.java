package eero.dogfood.eeroos;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.NetworkSettingsPage;
import eero.dogfood.addOrReplaceEeroPage;
import eero.dogfood.clientConnectPage;
import eero.dogfood.deleteNetworkPage;
import eero.dogfood.dhcpNatConfPage;
import eero.dogfood.editGuestNetworkPage;
import eero.dogfood.pingToolsPage;
import eero.dogfood.placementTestPage;
import eero.dogfood.settingsPage;
import io.appium.java_client.android.Activity;

public class CreateNetworkCases extends BaseTest {

	@Test(enabled = false, priority = 1, description = "Createnetwork dhcp network", dataProvider = "getData")

	void createNetwork(HashMap<String, String> input) throws InterruptedException {
		// TODO Auto-generated method stub
		HomePage homePage = new HomePage(driver);
		addOrReplaceEeroPage addorreplacepage = new addOrReplaceEeroPage(driver);
		homePage.clickStartSetup();
		homePage.clickElement(homePage.startBtn);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		homePage.clickNext();
		placementTestPage placementtest = new placementTestPage(driver);
		placementtest.selectLoc(input.get("Gateway place"));
		addorreplacepage.enterNetworkName(input.get("Main ssid"));
		addorreplacepage.setNetworkPassword(input.get("password"));
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickFinishSetup();
		homePage.clickElement(homePage.skipElement);
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
		homepage.clickElement(homepage.homeBtnElement);
		settingsPage settingspage = new settingsPage(driver);
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		homepage.clickElement(homepage.settingBtn);
		settingspage.clickNetworkSettings();
		networkSettingsPage.deleteNetwork();
		deleteNetworkPage deletenetworkpage = new deleteNetworkPage(driver);
		deletenetworkpage.keepsubscription();
		deletenetworkpage.confirmDelete();
		deletenetworkpage.clickElement(deletenetworkpage.deleteConfirmationBtn);
		deletenetworkpage.clickElement(deletenetworkpage.deleteConfirmationBtn);

	}

	@SuppressWarnings("deprecation")
	@Test(enabled = false, priority = 3, description = "Turn On guest network")

	void TurnOnGuest() throws InterruptedException, MalformedURLException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
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
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
		pingToolsPage.clickElement(pingToolsPage.pingElement);
		pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
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
		homePage.clickElement(homePage.homeBtnElement);
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingspage = new settingsPage(driver);
		settingspage.clickNetworkSettings();
		NetworkSettingsPage networksettingspage = new NetworkSettingsPage(driver);
		networksettingspage.clickDhcpNat();
		dhcpNatConfPage dhcpnatconf = new dhcpNatConfPage(driver);
		dhcpnatconf.clickElement(dhcpnatconf.manualIpOptionElement);
		dhcpnatconf.selectManulaIpaddr(input.get("Manual ip"));
		dhcpnatconf.clickElement(dhcpnatconf.savebtnElement);
		dhcpnatconf.clickElement(dhcpnatconf.rebootBtnElement);
		homePage.clickElement(homePage.homeBtnElement);
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
				pingToolsPage.clickElement(pingToolsPage.tabBarElement);
				pingToolsPage.clickElement(pingToolsPage.pingElement);
				pingToolsPage.clickElement(pingToolsPage.pingBtnElement);
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

	@Test(enabled = true, priority = 1, description = "Createnetwork static network", dataProvider = "getData")
	public void createStaticNetwork(HashMap<String, String> input) throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickStartSetup();
		homePage.clickElement(homePage.startBtn);
		addOrReplaceEeroPage addorreplacepage = new addOrReplaceEeroPage(driver);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickInternetSettings();
		addorreplacepage.clickElement(addorreplacepage.wantypElement);
		addorreplacepage.clickElement(addorreplacepage.staticipElement);
		addorreplacepage.enterStaticIpdetails(input.get("static ip"), input.get("Subnet"), input.get("Router ip"));
		addorreplacepage.clickElement(addorreplacepage.applyBtn);
		addorreplacepage.clickElement(addorreplacepage.saveBtn);
		placementTestPage placementTestPage = new placementTestPage(driver);
		placementTestPage.selectLoc(input.get("Gateway place"));
		addorreplacepage.enterNetworkName(input.get("Main ssid"));
		addorreplacepage.setNetworkPassword(input.get("password"));
		addorreplacepage.clickElement(addorreplacepage.arrowBtn);
		addorreplacepage.clickFinishSetup();
		homePage.clickElement(homePage.skipElement);
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
		homePage.clickElement(homePage.settingBtn);
		settingsPage settingsPage = new settingsPage(driver);
		settingsPage.clickNetworkSettings();
		NetworkSettingsPage networkSettingsPage = new NetworkSettingsPage(driver);
		networkSettingsPage.restartNetwork();
		networkSettingsPage.clickRestartBtn();
		homePage.clickElement(homePage.homeBtnElement);
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
