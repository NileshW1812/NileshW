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
import Pages3.RegistrationPage;

public class VerifyPageTitle {
	WebDriver driver;
	RegistrationPage registrationpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		registrationpage = new RegistrationPage(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyPageTitle1() {

		String Expected = "Welcome: Mercury Tours";

		assertEquals(Expected, driver.getTitle());

	}

	@Test(priority = 2, groups = { "sanity" }, enabled = true)
	public void verifyUserNameText() {
		assertTrue(registrationpage.getUserName().isDisplayed());
		registrationpage.getUserName().sendKeys("Nilesh123");

	}

	@Test(priority = -1, groups = { "sanity" }, enabled = true)
	public void verifyPasswordText() {
		
		assertTrue(registrationpage.getPassword().isDisplayed());
		registrationpage.getPassword().sendKeys("Nrw@12345");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

}
