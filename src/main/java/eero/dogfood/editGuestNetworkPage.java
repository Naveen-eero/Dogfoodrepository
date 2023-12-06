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
	private WebElement guestNetworkTogglElement;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"guest_access_screen_id_network_name_field\"]")
	private WebElement guestNameElement;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"guest_access_screen_id_network_password_field\"]")
	private WebElement guestnetworkpasswordElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SAVE\"]")
	private WebElement saveBtnElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Share QR code\"]")
	private WebElement shareQrCodElement;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Share wifi details\"]")
	private WebElement shareWifiDetailsElement;
	@AndroidFindBy(id = "guest_access_screen_id_back_button")
	private WebElement backBtnElement;

	public void clickenableGuestToggle() throws InterruptedException {
		guestNetworkTogglElement.click();
		Thread.sleep(2000);

	}

	public void getGuestNetworkName() {
		String guestname = guestNameElement.getText();
		System.out.println("Guest Network Name :" + guestname);
	}

	public void changeGuestNetworkName(String newGuestName) {
		guestNameElement.clear();
		guestNameElement.sendKeys(newGuestName);
	}

	public void getGuestPassword() {
		String guestPassword = guestnetworkpasswordElement.getText();
		System.out.println("Guest Network Password: " + guestPassword);

	}

	public void changeGuestPassword(String newGuestPassword) {
		guestnetworkpasswordElement.clear();
		guestnetworkpasswordElement.sendKeys(newGuestPassword);

	}

	public void saveGuestChanges() {
		saveBtnElement.click();

	}
}
