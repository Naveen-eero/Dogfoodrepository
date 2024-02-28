package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class editGuestNetworkPage {
	AndroidDriver driver;

	public editGuestNetworkPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@resource-id=\"guest_access_screen_id_enable_switch\"]")
	public WebElement guestNetworkTogglElement;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"guest_access_screen_id_network_name_field\" or  @resource-id=\"com.eero.android.dogfood:id/wifi_network_name\"]")
	public WebElement guestNameElement;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"guest_access_screen_id_network_password_field\"  or  @resource-id=\"com.eero.android.dogfood:id/wifi_network_password\"]")
	public WebElement guestnetworkpasswordElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SAVE\"]")
	public WebElement saveBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Share QR code\"]")
	public WebElement shareQrCodElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Share wifi details\"]")
	public WebElement shareWifiDetailsElement;
	@AndroidFindBy(id = "guest_access_screen_id_back_button")
	public WebElement backBtnElement;

	public void clickenableGuestToggle() throws InterruptedException {
		guestNetworkTogglElement.click();
		Thread.sleep(2000);

	}

	public String getGuestNetworkName() {
		String guestname = guestNameElement.getText();
		System.out.println("Guest Network Name :" + guestname);
		return guestname;
	}

	public void changeGuestNetworkName(String newGuestName) {
		guestNameElement.clear();
		guestNameElement.sendKeys(newGuestName);
	}

	public String getGuestPassword() {
		try {
			String guestPassword = guestnetworkpasswordElement.getText();
			System.out.println("Guest Network Password: " + guestPassword);
			return guestPassword;
		} catch (Exception e) {
			// TODO: handle exception

		}
		return null;
	}

	public void changeGuestPassword(String newGuestPassword) {
		guestnetworkpasswordElement.clear();
		guestnetworkpasswordElement.sendKeys(newGuestPassword);

	}

	public void saveGuestChanges() {
		saveBtnElement.click();

	}
}
