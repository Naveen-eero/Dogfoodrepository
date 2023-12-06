package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class deleteNetworkPage {
	AndroidDriver driver;

	public deleteNetworkPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/delete_network_button")
	private WebElement deleteNetworkBtnElement;

	@AndroidFindBy(id = "android.widget.ImageButton")
	private WebElement backBtnElement;
	@AndroidFindBy(xpath = "//android.widget.Button[@test=\"CANCEL\"]")
	private WebElement cancelBtnElement;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"DELETE NETWORK\"]")
	private WebElement deleteConfirmationElement;

	public void deleteNetwork() {
		deleteNetworkBtnElement.click();
	}

	public void goBack() {
		backBtnElement.click();
	}

	public void clickCancel() {
		// TODO Auto-generated method stub
		cancelBtnElement.click();
	}

	public void confirmDelete() {
		deleteConfirmationElement.click();
	}
}
