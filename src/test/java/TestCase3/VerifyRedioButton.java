package TestCase3;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoQaElement;

public class VerifyRedioButton {
	WebDriver driver;
	DemoQaElement demoqaelement;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaelement = new DemoQaElement(driver);

	}

	@Test(priority = 0, groups = { "sanity" }, enabled = true)
	public void verifyRadioButton() {
		assertTrue(demoqaelement.getYescheckbox().isEnabled());
		assertFalse(demoqaelement.getNocheckbox().isEnabled());
		assertTrue(demoqaelement.getImperssivecheckbox().isEnabled());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
