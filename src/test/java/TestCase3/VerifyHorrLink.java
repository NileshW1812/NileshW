package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.OmayoLinks;

public class VerifyHorrLink {
	WebDriver driver;
	OmayoLinks omayolinks;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		omayolinks = new OmayoLinks(driver);

	}

	@Test(priority = 5, groups = { "sanity" }, enabled = true)
	public void verifyHorrLinks() {
		omayolinks.getHorrinlinks().click();
		omayolinks.getLink().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
