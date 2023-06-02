package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationUserInformation {
	WebDriver driver;
	WebElement usernametext;
	WebElement passwordtext;
	WebElement conformpasswordtext;
	WebElement button;
	WebElement addresstext;
	WebElement citytext;
	WebElement statetext;
	WebElement postalcodetext;
	WebElement dropdown;

	public RegistrationUserInformation(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernametext() {
		setUsernametext();
		return usernametext;
	}

	public void setUsernametext() {
		this.usernametext = driver.findElement(By.xpath("//input[@id='email']"));
	}

	public WebElement getPasswordtext() {
		setPasswordtext();
		return passwordtext;
	}

	public void setPasswordtext() {
		this.passwordtext = driver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement getConformpasswordtext() {
		setConformpasswordtext();
		return conformpasswordtext;
	}

	public void setConformpasswordtext() {
		this.conformpasswordtext = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
	}

	public WebElement getButton() {
		setButton();
		return button;
	}

	public void setButton() {
		this.button = driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public WebElement getCitytext() {
		setCitytext();
		return citytext;
	}

	public void setCitytext() {
		this.citytext = driver.findElement(By.xpath("//input[@name='city']"));
	}

	public WebElement getStatetext() {
		setStatetext();
		return statetext;
	}

	public void setStatetext() {
		this.statetext = driver.findElement(By.xpath("//input[@name='state']"));
	}

	public WebElement getPostalcodetext() {
		setPostalcodetext();
		return postalcodetext;
	}

	public void setPostalcodetext() {
		this.postalcodetext = driver.findElement(By.xpath("//input[@name='postalCode']"));
	}

	public void setUsernametext(WebElement usernametext) {
		this.usernametext = usernametext;
	}

	public WebElement getAddresstext() {
		setAddresstext();
		return addresstext;
	}

	public void setAddresstext() {
		this.addresstext = driver.findElement(By.xpath("//input[@name='address1']"));
	}

	public WebElement getDropdown() {
		setDropdown();
		return dropdown;
	}

	public void setDropdown() {
		this.dropdown = driver.findElement(By.xpath("//select[@name='country']"));
	}
}