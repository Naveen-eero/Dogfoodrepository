package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class placementTestPage {
	AndroidDriver driver;

	public placementTestPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/text_button")
	private WebElement testNewPlacementBtn;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/button_next")
	private WebElement nextButton;
	@AndroidFindBy(xpath = "//android.widget.ImageButton")
	private WebElement closeBtnElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/info_button")
	private WebElement infoBtnElement;
	@AndroidFindBy(xpath = "(//android.widget.FrameLayout[@resource-id=\"com.eero.android.dogfood:id/room_picker_card_view\"])[5]")
	private WebElement selectLocationElement;

	public void clickNewPlacement() {
		testNewPlacementBtn.click();

	}

	public void clickNext() {
		nextButton.click();

	}

	public void clickClose() {
		closeBtnElement.click();

	}

	public void clickInfo() {
		infoBtnElement.click();
	}

	public void selectLoc() {

		selectLocationElement.click();

	}

}
