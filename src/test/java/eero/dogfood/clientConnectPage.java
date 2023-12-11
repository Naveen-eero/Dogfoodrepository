package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class clientConnectPage {
	AndroidDriver driver;

	public clientConnectPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Network & internet\"]")
	private WebElement netWorkElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Internet\"]")
	private WebElement interElement;

	@AndroidFindBy(xpath = "/android.widget.TextView[@text=\"+guestname+\"]")
	private WebElement networkNamElement;

	public void clickNetwork() throws InterruptedException {
		netWorkElement.click();
	}

	public void clickInternet() {
		interElement.click();

	}

	public void connectToGuest(String guestname) {
		networkNamElement.click();

	}

}
