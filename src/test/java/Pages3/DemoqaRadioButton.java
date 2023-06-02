package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaRadioButton {
	WebDriver driver;
	WebElement yesbutton;
	WebElement nobutton;
	WebElement impressivebutton;

	public DemoqaRadioButton(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getYesbutton() {
		setYesbutton();
		return yesbutton;
	}

	public void setYesbutton() {
		this.yesbutton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
	}

	public WebElement getNobutton() {
		setNobutton();
		return nobutton;
	}

	public void setNobutton() {
		this.nobutton = driver.findElement(By.xpath("//input[@id='noRadio']"));
	}

	public WebElement getImpressivebutton() {
		setImpressivebutton();
		return impressivebutton;
	}

	public void setImpressivebutton() {
		this.impressivebutton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
	}
}
