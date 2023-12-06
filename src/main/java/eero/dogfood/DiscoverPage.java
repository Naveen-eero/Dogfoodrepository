package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DiscoverPage {

	AndroidDriver driver;

	public DiscoverPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/premium_capable")
	private WebElement eeroSecurElement;

	@AndroidFindBy(id = "com.eero.android.dogfood:id/amazon_connected_home")
	private WebElement amazonhomeElement;

	@AndroidFindBy(id = "com.eero.android.dogfood:id/eero_labs")
	private WebElement eeroLabsElement;

	public void clickeeroSecure() throws InterruptedException {
		eeroSecurElement.click();
		Thread.sleep(3000);
	}

	public void clickAmazonhome() throws InterruptedException {
		amazonhomeElement.click();
		Thread.sleep(3000);
	}

	public void clickeeroLabs() throws InterruptedException {
		eeroLabsElement.click();
		Thread.sleep(3000);
	}

}
