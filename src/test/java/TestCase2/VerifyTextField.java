package TestCase2;

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

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyloginUsingSendText() throws IOException {
		homepageomayo.getText().sendKeys("This is my text");
		homepageomayo.getPasswordtext().sendKeys("nrw@123");
		homepageomayo.getLoginbutton().click();
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verifyLoginUsingUtilityClass() throws IOException {
		homepageomayo.getText().sendKeys(Utility2.getProperty("UserName"));
		homepageomayo.getPasswordtext().sendKeys(Utility2.getProperty("PassWord"));
		homepageomayo.getLoginbutton().click();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
