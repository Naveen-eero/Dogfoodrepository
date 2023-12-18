package eero.dogfood;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class editMainNetworkPage {
	AndroidDriver driver;

	public editMainNetworkPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_name")
	private WebElement mainNetWorkNameElement;
	@AndroidFindBy(id = "com.eero.android.dogfood:id/wifi_network_password")
	private WebElement mainNetworkPasswordElement;

	public String getMainNetworkName() {
		String mainnetworknameString = mainNetWorkNameElement.getText();
		System.out.println(mainnetworknameString);
		return mainnetworknameString;

	}

	public String getMainNetworkPassword() {
		String mainnetworkpassword = mainNetworkPasswordElement.getText();
		System.out.println(mainnetworkpassword);
		return mainnetworkpassword;

	}

}
