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

public class VerifyNewToursRegistration2WithExcel {
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

		List<String> data = null;
		try {
			data = Utility2.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[][] registration = new String[1][4];

		for (int i = 0; i < data.size(); i++) {

			registration[0][i] = data.get(i);

//			for (int j = 0; j < 4; j++) {
//				registration1[i][j] = data.get(i);
//			}
		}

//		registration1[0][0] = data.get(0);
//		registration1[0][1] = data.get(1);
//		registration1[0][2] = data.get(2);
//		registration1[0][3] = data.get(3);

//		String[][] registration = { { "sachin", "tendulkar", "08998989089", "sachin@email.com" } };
		return registration;

	}

}
