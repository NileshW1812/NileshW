package TestCase4;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages4.Demo99SingInPage;

public class VerifyUserSingIn {
	WebDriver driver;
	Demo99SingInPage demo99singinpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demo99singinpage = new Demo99SingInPage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifySingIn() {

		// demo99singinpage.getSigninlink().click();
		// driver.switchTo().alert().accept();

		demo99singinpage.getUsernametext().sendKeys("nrw@gamil.com");
		demo99singinpage.getPasswordtext().sendKeys("nilesh@123");
		demo99singinpage.getSubmitbutton().click();

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
	public String[][] signInDataprovider() {
		String[][] singindata = { { "nrw123@gmail.com", "nilesh3123" } };
		return singindata;

	}
}
