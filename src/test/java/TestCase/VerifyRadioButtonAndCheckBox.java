package TestCase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.HomePage;

public class VerifyRadioButtonAndCheckBox {
	WebDriver driver;
	HomePage homepage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		homepage = new HomePage(driver);

	}

	@Test(priority = 1, groups = { "e2e" }, enabled = true)
	public void verifyCheckboxAndRadioButtonBehaviours() throws IOException {

		/*
		 * verify that male female checkbox is unchecked make sure that orange box
		 * checked and blue box is unchecked.
		 */

		assertFalse(homepage.getMaleRadioButton().isSelected());
		assertFalse(homepage.getFemaleRadioButton().isSelected());

		assertTrue(homepage.getOrangaeCheckbox().isSelected());
		assertFalse(homepage.getBlueCheclbox().isSelected());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
