package TestCase2;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.HomePage;
import pages2.HomePageOmayo;

public class VerifyMultipleDropdown<selectDropdown> {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);

	}

	String value = "Swift";

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyDropdown() {
		Utility2.selectValueFromDropdown(homepageomayo.getDropdown(), "Swift");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
