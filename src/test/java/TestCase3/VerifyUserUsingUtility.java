package TestCase3;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.RegistrationUserInformation;

public class VerifyUserUsingUtility {

	WebDriver driver;
	RegistrationUserInformation registrationuserinformation;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		registrationuserinformation = new RegistrationUserInformation(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyUserInformation() throws IOException {

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Utility2.getProperty("Username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Utility2.getProperty("Password"));
		driver.findElement(By.xpath("//input[@name='confirmPassword']"))
				.sendKeys(Utility2.getProperty("conformpassword"));

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyUserInformation2() {

		registrationuserinformation.getUsernametext().sendKeys(Utility2.getProperty("Username"));
		registrationuserinformation.getPasswordtext().sendKeys(Utility2.getProperty("password"));
		registrationuserinformation.getConformpasswordtext().sendKeys(Utility2.getProperty("conformpassword"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());

		}
		driver.quit();
	}
}