package TestCase2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.HomePage;
import pages2.DropDownHomePage;

public class VerifyDropdown {
	WebDriver driver;
	HomePage dropdownhomwpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		dropdownhomwpage = new HomePage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle() throws IOException {
		DropDownHomePage dropdown = new DropDownHomePage(driver);
		dropdown.allCountrySelect("India");
		dropdown.allCountrySelect("UK");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
