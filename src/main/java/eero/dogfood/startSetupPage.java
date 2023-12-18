package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class startSetupPage {
	AndroidDriver driver;

	public startSetupPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/next_button")
	private WebElement startBtnElement;

	@AndroidFindBy(id = "com.eero.android.dogfood:id/right_action")
	private WebElement skipElement;

	public void clickStartBtn() {
		startBtnElement.click();

	}

	public void clickSkip() {
		skipElement.click();
	}

}
