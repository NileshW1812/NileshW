package TestCase2;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.HomePageOmayo;

public class VerifyTextField {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyloginUsingSendText() {
		homepageomayo.getText().sendKeys("This is my text");
		homepageomayo.getPasswordtext().sendKeys("nrw@123");
		homepageomayo.getLoginbutton().click();
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = false)
	public void verifyLoginUsingUtilityClass() {
		homepageomayo.getText().sendKeys(Utility2.getProperty("UserName"));
		homepageomayo.getPasswordtext().sendKeys(Utility2.getProperty("PassWord"));
		homepageomayo.getLoginbutton().click();
	}

	@Test(priority = 10, groups = { "sanity" }, enabled = true)
	public void verifyPasswordTextDisplayed() {
		assertTrue(homepageomayo.getPasswordtext().isDisplayed());
		homepageomayo.getPasswordtext().sendKeys("nrw@123");
	}
	
	@Test(priority = 10, groups = { "sanity" }, enabled = true)
	public void verifyUserNameTextDisplayed() {
		assertTrue(homepageomayo.getText().isDisplayed());
		homepageomayo.getText().sendKeys("nilesh");
	}


	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
