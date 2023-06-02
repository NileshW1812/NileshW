package TestCase2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import pages2.HomePageOmayo;

public class VerifyIframe {
	WebDriver driver;
	HomePageOmayo homepageomayo;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepageomayo = new HomePageOmayo(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle() {
		driver.getTitle();
		assertEquals(homepageomayo.getPageTitle().getText(), "omayo (QAFox.com)");
	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void VerifyIframe() {
		driver.getTitle();
		assertNotEquals(homepageomayo.getIframe().getText(), "navbar-iframe");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}