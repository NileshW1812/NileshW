package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaAlertPage {
	WebDriver driver;
	WebElement clickbutton;
	WebElement clickbuttoninsec;

	public DemoqaAlertPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getClickbutton() {
		setClickbutton();
		return (WebDriver) clickbutton;
	}

	public void setClickbutton() {
		this.clickbutton = driver.findElement(By.xpath("//button[@id='alertButton']"));
	}

	public WebElement getClickbuttoninsec() {
		setClickbuttoninsec();
		return clickbuttoninsec;
	}

	public void setClickbuttoninsec() {
		this.clickbuttoninsec = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
	}

}
