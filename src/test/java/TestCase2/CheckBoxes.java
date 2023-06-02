package TestCase2;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages.HomePage;

public class CheckBoxes {
	WebDriver driver;
	HomePage homepage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepage = new HomePage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyCheckBox() {
		assertTrue(homepage.getPenCheckbox().isDisplayed());
		assertTrue(homepage.getBagCheckbox().isDisplayed());
		assertTrue(homepage.getLaptopCheckbox().isDisplayed());
		assertTrue(homepage.getBookCheckbox().isDisplayed());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
