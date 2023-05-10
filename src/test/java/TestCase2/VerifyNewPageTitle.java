package TestCase2;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages2.NewToursHomePage2;

public class VerifyNewPageTitle {
	WebDriver driver;
	NewToursHomePage2 newtourshomepage2;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		newtourshomepage2 = new NewToursHomePage2(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void VerifyNewToursTitle()throws IOException {
		driver.getTitle();
         assertEquals(newtourshomepage2.getPageTitle().getText(), "Welcome: Mercury Tours");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
