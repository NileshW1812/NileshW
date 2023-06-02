package TestCase3;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.CheckBoxPage;

public class VerifyCheckBoxes {
	WebDriver driver;
	CheckBoxPage checkobxpage;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		checkobxpage = new CheckBoxPage(driver);

	}

	@Test(priority = 1, groups = { "sanity" }, enabled = false)
	public void VerifySingleCheckbox() {
		checkobxpage.getRedcheckbox().click();
	}

	@Test(priority = 2, groups = { "sanity" }, enabled = true)
	public void VerifyAllCheckbox() {
		checkobxpage.selectAllCheckBox();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}
}
