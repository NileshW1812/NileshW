package TestCase4;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages4.Demo99SingInPage;

public class VerifyDataUsingeExcel {
	WebDriver driver;
	Demo99SingInPage demo99singinpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demo99singinpage = new Demo99SingInPage(driver);

	}

	@Test(dataProvider = "singindata")
	public void verifySingIn2(String Username, String Password) {

		demo99singinpage.getUsernametext().sendKeys(Username);
		demo99singinpage.getPasswordtext().sendKeys(Password);
		demo99singinpage.getSubmitbutton().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

	@DataProvider(name = "singindata")

	public String[][] singhInDataProvider() throws IOException {
		List<String> data = null;
		data = Utility2.readExcel();
		String[][] singindata = new String[1][2];
		for (int i = 0; i < data.size(); i++) {
			singindata[0][i] = data.get(i);
		}
		return singindata;

	}
}
