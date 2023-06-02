package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.RegistrationUserInformation;

public class VerifyMailingInformation {
	WebDriver driver;
	RegistrationUserInformation registrationuserinformation;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		registrationuserinformation = new RegistrationUserInformation(driver);

	}

	@Test(dataProvider = "Registration")
	public void verifyMailInformations(String address, String city, String state, String postalcode) {

		registrationuserinformation.getAddresstext().sendKeys(address);
		registrationuserinformation.getCitytext().sendKeys(city);
		registrationuserinformation.getStatetext().sendKeys(state);
		registrationuserinformation.getPostalcodetext().sendKeys(postalcode);
		registrationuserinformation.getDropdown().click();
		WebElement dd = registrationuserinformation.getDropdown();
		Select dropdown = new Select(dd);
		dropdown.selectByValue("INDIA");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

	@DataProvider(name = "Registration")
	public String[][] RegistrationDataProvider() {
		String[][] registration = { { "Nandede Phata", "Pune", "Maharashtra", "411041" } };
		return registration;

	}

}
