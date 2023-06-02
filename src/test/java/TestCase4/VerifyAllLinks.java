package TestCase4;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages4.DemoQaLinks;

public class VerifyAllLinks {
	WebDriver driver;
	DemoQaLinks demoqalinks;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqalinks = new DemoQaLinks(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyLinks() {

		demoqalinks.allLink();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
