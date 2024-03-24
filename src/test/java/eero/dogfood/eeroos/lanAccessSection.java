package eero.dogfood.eeroos;

import java.io.IOException;

import org.testng.annotations.Test;

import eero.dogfood.HomePage;
import eero.dogfood.PingToolsPage;

public class lanAccessSection extends BaseTest {

	@Test(description = " Perform Ping/Pause/Block on Wireless Clients connected to Wired Leaf on Main Network", enabled = true, priority = 1)

	public void C356577() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickElement(homePage.HOME_TAB);
		BaseTest baseTest = new BaseTest();
		PingToolsPage pingToolsPage = new PingToolsPage(driver1);
		pingToolsPage.clickElement(pingToolsPage.tabBarElement);
	}
}
