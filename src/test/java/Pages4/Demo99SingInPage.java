package Pages4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Demo99SingInPage {
	WebDriver driver;
	WebElement signinlink;
	WebElement usernametext;
	WebElement passwordtext;
	WebElement submitbutton;

	public Demo99SingInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSigninlink() {
		setSigninlink();
		return signinlink;
	}

	public void setSigninlink() {
		this.signinlink = driver.findElement(By.xpath("//a[@href='login.php']"));
	}

	public WebElement getUsernametext() {
		setUsernametext();
		return usernametext;
	}

	public void setUsernametext() {
		this.usernametext = driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPasswordtext() {
		setPasswordtext();
		return passwordtext;
	}

	public void setPasswordtext() {
		this.passwordtext = driver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement getSubmitbutton() {
		setSubmitbutton();
		return submitbutton;
	}

	public void setSubmitbutton() {
		this.submitbutton = driver.findElement(By.xpath("//input[@name='submit']"));
	}
}
