package TestCase3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoQaElement;
import pages.HomePage;

public class VerifyCheckBox {
	WebDriver driver;
	DemoQaElement demoqaelement;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaelement = new DemoQaElement(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled =true)
	public void verifyCheckBox() {
		assertTrue(demoqaelement.getCheckbox().isEnabled());
		assertTrue(demoqaelement.getCheckbox().isDisplayed());
		demoqaelement.getCheckbox().click();

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyToggleButton() {
		
		assertTrue(demoqaelement.getTogglebutton().isEnabled());
		assertTrue(demoqaelement.getTogglebutton().isDisplayed());
		demoqaelement.getTogglebutton().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
