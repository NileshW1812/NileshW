package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoqaButtonAndLinks;

public class VerifyNoOfButtons {
	WebDriver driver;
	DemoqaButtonAndLinks demoqabuttonandlinks;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqabuttonandlinks = new DemoqaButtonAndLinks(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyButtons() {
		demoqabuttonandlinks.getAllButton();
	}
	@Test(priority = 5, groups = { "sanity" }, enabled = true)

	public void verifyLinks() {
		
		demoqabuttonandlinks.getAllLinks();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
