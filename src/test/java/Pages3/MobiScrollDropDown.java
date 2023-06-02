package Pages3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobiScrollDropDown {
	WebDriver driver;
	WebElement mutipleselectdropdown;

	public MobiScrollDropDown(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMutipleselectdropdown() {
		setMutipleselectdropdown();
		return mutipleselectdropdown;
	}

	public void setMutipleselectdropdown() {
		this.mutipleselectdropdown = driver.findElement(By.xpath("//input[@id='multiple-select-input']"));
	}

	public static void selectDropdown2(WebElement dropdown, String string) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(string);

	}

	public void selectAllDropDon(String allDropDownName) {
		driver.findElement(By.xpath("//input[@id='multiple-select-input']")).click();
		List<WebElement> dd = driver.findElements(By.xpath("//select[@id='multiple-select-select']"));
		for (WebElement alldropdown : dd) {
			if (alldropdown.getText().equalsIgnoreCase(allDropDownName))
				;
			alldropdown.click();
		}
	}
}