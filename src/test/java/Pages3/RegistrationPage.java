package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	WebDriver driver;
	WebElement userName;
	WebElement password;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserName() {
		setUserName();
		return userName;
	}

	public void setUserName() {
		this.userName = driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPassword() {
		setPassword();
		return password;
	}

	public void setPassword() {
		this.password = driver.findElement(By.xpath("//input[@name='password']"));
	}
}
