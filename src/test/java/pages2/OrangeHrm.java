package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHrm {
	WebDriver driver;
	WebElement usernametext;
	WebElement passwordtext;

	public OrangeHrm(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernametext() {
		setUsernametext();
		return usernametext;
	}

	public void setUsernametext() {
		this.usernametext = driver.findElement(By.id("txtUsername"));
	}

	public WebElement getPasswordtext() {
		setPasswordtext();
		return passwordtext;
	}

	public void setPasswordtext() {
		this.passwordtext = driver.findElement(By.id("txtPassword"));
	}

}
