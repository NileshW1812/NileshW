package Pages4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoQaWebPage {
	WebDriver driver;

	public DemoQaWebPage(WebDriver driver) {
		this.driver = driver;
	}

	public static void SelectValueFromDropDown(WebElement dropdown, String selectbyvalue) {
		Select select = new Select(dropdown);
		select.selectByValue(selectbyvalue);
	}

}
