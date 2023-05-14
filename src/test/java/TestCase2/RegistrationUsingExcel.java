package TestCase2;

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

public class RegistrationUsingExcel {
	WebDriver driver;
	NewToursHomePage newtourshomePage;
	RegistrationPage registrationPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		
		newtourshomePage = new NewToursHomePage(driver);
		registrationPage = new RegistrationPage(driver);
	}

	@Test(dataProvider = "registration")

	public void verifyregistration(String firstname, String lastname, String phone, String email) {
		
		newtourshomePage.clickOnRegistrationLink();
		registrationPage.getFirstNameTestField().sendKeys(firstname);
		registrationPage.getLastNameTestField().sendKeys(lastname);
		registrationPage.getPhoneTestField().sendKeys(phone);
		registrationPage.getEmailTestField().sendKeys(email);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

	@DataProvider(name = "registration")
	public String[][] registrationDataProvider() throws IOException {
		List<String> data = Utility2.readExcel();
		String[][] registration1 = new String[1][4];
		for (int i = 0; i < data.size(); i++) {
			registration1[0][i] = data.get(i);
		}
		return registration1;
	}

}
