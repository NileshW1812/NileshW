package TestCase3;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.RegistrationUserInformation;

public class VerifyUserInformationUsingExcel {
	WebDriver driver;
	RegistrationUserInformation registrationuserinformation;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		registrationuserinformation = new RegistrationUserInformation(driver);

	}

	@Test(dataProvider = "Userinformation")
	public void verifyUserInformation(String Username, String Password, String Conformpassword) {
		registrationuserinformation.getUsernametext().sendKeys("Username");
		registrationuserinformation.getPasswordtext().sendKeys("Password");
		registrationuserinformation.getConformpasswordtext().sendKeys("Conformpassword");
		registrationuserinformation.getButton().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

	@DataProvider(name = "Userinformation")

	public String[][] UserInformationDataProvider() throws IOException {
		List<String> data = Utility2.readExcel();
		String[][] userdata = new String[1][3];
		for (int i = 0; i < data.size(); i++) {
			userdata[0][i] = data.get(i);
		}
		return userdata;

	}

}