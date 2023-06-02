package TestCase3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages3.WaitsForAlerts;

public class VerifyWaitsForAlerts {
	WebDriver driver;
	WaitsForAlerts waitsforalerts;

	@BeforeMethod(alwaysRun = true)
	public void setup(){
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		waitsforalerts = new WaitsForAlerts(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyWaits() {

		waitsforalerts.getAlerbutton().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().alert().accept();
	}

	@Test(priority = -4, groups = { "sanity" }, enabled = true)
	public void verifyWaits2() {

		waitsforalerts.getAlerbutton().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
	}

	@Test(priority = 3, groups = { "sanity" }, enabled = true)
	public void verifyWaits3() {

		waitsforalerts.getAlerbutton().click();
		FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver);
		fluentwait.withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println(driver.getCurrentUrl());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
