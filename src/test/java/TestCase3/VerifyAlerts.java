package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoQaAlerts;

public class VerifyAlerts {
	WebDriver driver;
	DemoQaAlerts demoqaalerts;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaalerts = new DemoQaAlerts(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyAlertButton() {
		demoqaalerts.implicitwaits();
	}

	@Test(priority = 2, groups = { "sanity" }, enabled = true)
	public void verifyTimerAlertButton() {
		demoqaalerts.FluentWaits();
	}
	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verifyConformButton() {
		demoqaalerts.implicitwaits();
	}
	@Test(priority = -5, groups = { "sanity" }, enabled = true)
	public void verifyPromtButton() {
		demoqaalerts.implicitwaits();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
