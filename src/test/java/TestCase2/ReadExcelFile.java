package TestCase2;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import pages.NewToursHomePage;
import pages.RegistrationPage;

public class ReadExcelFile {
	WebDriver driver;
//	NewToursHomePage newtourshomePage;
	RegistrationPage registrationPage;

	@BeforeMethod(alwaysRun = true)
	
	public void setup() throws IOException {

		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
//		newtourshomePage = new NewToursHomePage(driver);
		registrationPage = new RegistrationPage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyExcelData() throws IOException {
		List<String> userData = Utility2.readExcel();

		registrationPage.getFirstNameTestField().sendKeys(userData.get(0));
		registrationPage.getLastNameTestField().sendKeys(userData.get(1));
		registrationPage.getPhoneTestField().sendKeys(userData.get(2));
		registrationPage.getEmailTestField().sendKeys(userData.get(3));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

}
