package Pages3;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaAlerts {
	WebDriver driver;
	WebElement alerButton;
	WebElement timeralertbutton;
	WebElement conformbutton;
	WebElement promtbutton;

	public DemoQaAlerts(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAlerButton() {
		setAlerButton();
		return alerButton;
	}

	public void setAlerButton() {
		this.alerButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
	}

	public WebElement getTimeralertbutton() {
		setTimeralertbutton();
		return timeralertbutton;
	}

	public void setTimeralertbutton() {
		this.timeralertbutton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
	}

	public WebElement getConformbutton() {
		setConformbutton();
		return conformbutton;
	}

	public void setConformbutton() {
		this.conformbutton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
	}

	public WebElement getPromtbutton() {
		setPromtbutton();
		return promtbutton;
	}

	public void setPromtbutton() {
		this.promtbutton = driver.findElement(By.xpath("//button[@id='promtButton']"));
	}

	public void implicitwaits() {
//		getAlerButton().click();
//		getConformbutton().click();
		getPromtbutton().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
//		getPromtbutton().sendKeys("Nilesh");
		driver.switchTo().alert().accept();
		getPromtbutton().sendKeys("Nilesh");
		System.out.println(driver.getTitle());
	}

	public void FluentWaits() {
		getAlerButton().click();
		FluentWait<WebDriver> fluentwaits = new FluentWait<WebDriver>(driver);
		fluentwaits.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println(driver.getCurrentUrl());

	}

}