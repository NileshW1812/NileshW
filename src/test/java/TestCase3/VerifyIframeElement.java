package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.OmayoIframe;

public class VerifyIframeElement {
	WebDriver driver;
	OmayoIframe omayoiframe;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		omayoiframe = new OmayoIframe(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyIframe() {
		driver.switchTo().frame(omayoiframe.getIframe());
		omayoiframe.getLink().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
