package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class chromePage {
	AndroidDriver driver;

	public chromePage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.android.chrome:id/menu_button")
	private WebElement menuElement;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"New Incognito tab\"]")
	private WebElement incognitotabElement;

	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private WebElement urlbarElement;

	public void clickmenu() {
		menuElement.click();
	}

	public void clickIncog() {
		incognitotabElement.click();
	}

	public void enterUrl() {
		driver.get("www.google.com");
	}
}
