package eero.dogfood;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
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
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"This will help you identify it later.\"]")
	private WebElement placementpagElement;

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

	public void selectLoc(String location) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(placementpagElement));
		String xpath_locator = String
				.format("//android.widget.TextView[contains(@text," + "\"" + "" + location + "\")]");
		WebElement ele = driver.findElement(AppiumBy.xpath(xpath_locator));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();

	}

}
