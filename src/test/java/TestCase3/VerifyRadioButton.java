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
import Pages3.DemoqaRadioButton;

public class VerifyRadioButton {
	WebDriver driver;
	DemoqaRadioButton demoqaradiobutton;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaradiobutton = new DemoqaRadioButton(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyRadioButton() {
		
		assertTrue(demoqaradiobutton.getYesbutton().isEnabled());
		assertFalse(demoqaradiobutton.getNobutton().isEnabled());
		assertTrue(demoqaradiobutton.getImpressivebutton().isEnabled());

	}
	
	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyRadioButton2() {
		
		assertTrue(demoqaradiobutton.getYesbutton().isEnabled());
		assertFalse(demoqaradiobutton.getNobutton().isSelected());
		assertFalse(demoqaradiobutton.getImpressivebutton().isSelected());

	}


	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}
}
