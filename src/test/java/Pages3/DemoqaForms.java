package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaForms {
	WebDriver driver;
	WebElement choosefile;

	public DemoqaForms(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getChoosefile() {
		setChoosefile();
		return choosefile;
	}

	public void setChoosefile() {
		this.choosefile = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
	}

}
