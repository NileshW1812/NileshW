package pages2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAlerts {
	WebDriver driver;
	private WebElement pageTitle;
	WebElement alert;
	WebElement timeralert;
	WebElement textalert;

	public HomePageAlerts(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPageTitle() {
		setPageTitle();
		return pageTitle;
	}

	public void setPageTitle() {
		this.pageTitle = driver.findElement(By.xpath("//title[text()='DEMOQA']"));
	}

	public WebElement getAlert() {
		setAlert();
		return alert;
	}

	public void setAlert() {
		this.alert = driver.findElement(By.xpath("//button[@id='alertButton']"));
	}

	public WebElement getTimeralert() {
		setTimeralert();
		return timeralert;
	}

	public void setTimeralert() {
		this.timeralert = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
	}

	public WebElement getTextalert() {
		setTextalert();
		return textalert;
	}

	public void setTextalert() {
		this.textalert =driver.findElement(By.xpath("//button[@id='confirmButton']"));
	}

	public String handleAlerts(String name) {
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.sendKeys(name);
//		alert.accept();
		alert.dismiss();

		return name;
	}

}
