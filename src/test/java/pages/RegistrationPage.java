package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	WebDriver driver;
	WebElement firstNameTestField;
	WebElement lastNameTestField;
	WebElement phoneTestField;
	WebElement emailTestField;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameTestField() {
		setFirstNameTestField();
		return firstNameTestField;
	}

	public void setFirstNameTestField() {
		this.firstNameTestField = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getLastNameTestField() {
		setLastNameTestField();
		return lastNameTestField;
	}

	public void setLastNameTestField() {
		this.lastNameTestField = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

	public WebElement getPhoneTestField() {
		setPhoneTestField();
		return phoneTestField;
	}

	public void setPhoneTestField() {
		this.phoneTestField = driver.findElement(By.xpath("//input[@name='phone']"));
	}

	public WebElement getEmailTestField() {
		setEmailTestField();
		return emailTestField;
	}

	public void setEmailTestField() {
		this.emailTestField = driver.findElement(By.xpath("//input[@name='userName']"));
	}
}
