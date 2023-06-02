package Pages3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoQaElement {
	WebDriver driver;
	WebElement usernametext;
	WebElement emailText;
	WebElement currentaddress;
	WebElement permanentaddress;
	WebElement checkbox;
	WebElement togglebutton;
	WebElement yescheckbox;
	WebElement imperssivecheckbox;
	WebElement nocheckbox;

	public DemoQaElement(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernametext() {
		setUsernametext();
		return usernametext;
	}

	public void setUsernametext() {
		this.usernametext = driver.findElement(By.xpath("//input[@id='userName']"));
	}

	public WebElement getEmailText() {
		setEmailText();
		return emailText;
	}

	public void setEmailText() {
		this.emailText = driver.findElement(By.xpath("//input[@id='userEmail']"));
	}

	public WebElement getCurrentaddress() {
		setCurrentaddress();
		return currentaddress;
	}

	public void setCurrentaddress() {
		this.currentaddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
	}

	public WebElement getPermanentaddress() {
		setPermanentaddress();
		return permanentaddress;
	}

	public void setPermanentaddress() {
		this.permanentaddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
	}

	public WebElement getCheckbox() {
		setCheckbox();
		return checkbox;
	}

	public void setCheckbox() {
		this.checkbox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
	}

	public WebElement getTogglebutton() {
		setTogglebutton();
		return togglebutton;
	}

	public void setTogglebutton() {
		this.togglebutton = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
	}

	public WebElement getYescheckbox() {
		setYescheckbox();
		return yescheckbox;
	}

	public void setYescheckbox() {
		this.yescheckbox = driver.findElement(By.xpath("//input[@id='yesRadio']"));
	}

	public WebElement getImperssivecheckbox() {
		setImperssivecheckbox();
		return imperssivecheckbox;
	}

	public void setImperssivecheckbox() {
		this.imperssivecheckbox = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
	}

	public WebElement getNocheckbox() {
		setNocheckbox();
		return nocheckbox;
	}

	public void setNocheckbox() {
		this.nocheckbox = driver.findElement(By.xpath("//input[@id='noRadio']"));
	}

}
