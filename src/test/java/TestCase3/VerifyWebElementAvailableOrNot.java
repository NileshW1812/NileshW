package TestCase3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.RegistrationUserInformation;
import pages.HomePage;

public class VerifyWebElementAvailableOrNot {
	WebDriver driver;
	RegistrationUserInformation registrationuserinformation;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		registrationuserinformation = new RegistrationUserInformation(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyWebElement() {

		WebElement username = registrationuserinformation.getUsernametext();
		Dimension d = username.getSize();
		if (d.getHeight() > 0) {
			System.out.println("WebElemenet is Available");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

		driver.quit();
	}

}
