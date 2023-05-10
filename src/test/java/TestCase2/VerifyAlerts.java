package TestCase2;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages2.HomePageAlerts;

public class VerifyAlerts {
	WebDriver driver;
	HomePageAlerts homepagealerts;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepagealerts = new HomePageAlerts(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle() {
		driver.getTitle();
		assertNotEquals(homepagealerts.getPageTitle().getText(), "DEMOQA");
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyAlert1() {
		homepagealerts.getAlert();
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyAlert2() {
		homepagealerts.getTimeralert();
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyAlert3() {
		homepagealerts.getTimeralert().sendKeys("nilesh wankhade");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
