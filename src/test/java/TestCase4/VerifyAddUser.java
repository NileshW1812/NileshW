package TestCase4;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;

import Pages4.DemoQaWebPage1;

public class VerifyAddUser {
	WebDriver driver;
	DemoQaWebPage1 demoqawebpage1;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqawebpage1 = new DemoQaWebPage1(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyAddUserSucessfully() {

		demoqawebpage1.getAddbutton().click();
		demoqawebpage1.getFirstnametext().sendKeys("Nilesh");
		demoqawebpage1.getLastnametext().sendKeys("Wankhade");
		demoqawebpage1.getUseremailtext().sendKeys("nre@gmail.com");
		demoqawebpage1.getAgetext().sendKeys("26");
		demoqawebpage1.getSalarytext().sendKeys("60000");
		demoqawebpage1.getDeparmenttext().sendKeys("Automation Engineer");
		demoqawebpage1.getSubmitbutton().click();
		
		demoqawebpage1.getSearchbox().click();
		demoqawebpage1.getSearchbox().sendKeys("Nilesh");
		demoqawebpage1.getSearchbutton().click();

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
