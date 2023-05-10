package pages2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownHomePage {
	WebDriver driver;
	WebElement dropdown;

	public DropDownHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void allCountrySelect(String allcountryname) {
		driver.findElement(By.xpath("//button[@id='select-country-dropdown']")).click();
		List<WebElement> country = driver.findElements(By.xpath("//div[@id='modal-list-country']"));
		for (WebElement country1 : country) {
			if (country1.getText().equalsIgnoreCase(allcountryname))
				;
			country1.click();
		}
	}

}
