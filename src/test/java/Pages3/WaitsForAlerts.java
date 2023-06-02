package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WaitsForAlerts {
	WebDriver driver;
	WebElement alerbutton;

	public WaitsForAlerts(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAlerbutton() {
		setAlerbutton();
		return alerbutton;
	}

	public void setAlerbutton() {
		this.alerbutton = driver.findElement(By.xpath("//button[@id='alertButton']"));
	}
}
