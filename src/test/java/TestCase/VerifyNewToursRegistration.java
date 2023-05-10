package TestCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.NewToursHomePage;
import pages.RegistrationPage;

public class VerifyNewToursRegistration {
	WebDriver driver;
	NewToursHomePage newToursHomePage;
	RegistrationPage registrationPage;

	@BeforeMethod
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		newToursHomePage = new NewToursHomePage(driver);
		registrationPage = new RegistrationPage(driver);
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void verifyPageTitle() throws IOException {
		driver.getTitle();
//		assertEquals(homepage.getPageTitle().getText(), "omayo (QAFox.com)");

		Utility2.getScreenshot(driver, "snap_" + System.currentTimeMillis()); // take screenshot
	}

	@Test(dataProvider = "registraion")
	public void VerifyRegistration(String firstName, String lastName, String phone, String email) {
		newToursHomePage.clickOnRegistrationLink();
		registrationPage.getFirstNameTestField().sendKeys(firstName);
		registrationPage.getLastNameTestField().sendKeys(lastName);
		registrationPage.getPhoneTestField().sendKeys(phone);
		registrationPage.getEmailTestField().sendKeys(email);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();

	}

	@DataProvider(name = "registraion")
	public String[][] registrationDataProvider() {
		String[][] registration = { { "sachin", "tendulkar", "08998989089", "sachin@email.com" } };
		return registration;

	}

}
