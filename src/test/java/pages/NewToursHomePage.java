package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {
	WebDriver driver;
	WebElement registrationLink;

	public NewToursHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRegistrationLink() {
		setRegistrationLink();
		return registrationLink;
	}

	public void setRegistrationLink() {
		this.registrationLink = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	}

	public void clickOnRegistrationLink() {
		getRegistrationLink().click();
	}

}
