package TestCase3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nilesh.project.Utility2;
import Pages3.DemoqaForms;
import pages.HomePage;

public class VerifyFileUpload {
	WebDriver driver;
	DemoqaForms demoqaforms;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = Utility2.getDriver();
		driver.get(Utility2.getProperty("url"));
		driver.manage().window().maximize();
		demoqaforms = new DemoqaForms(driver);
		WebElement uploadFileDriver = demoqaforms.getChoosefile();
		uploadFileDriver.sendKeys(
				"C:\\Users\\Asus\\Desktop\\Downloads\\B4Myproject\\src\\CollctionFramwor\\nilesh\\src\\test\\resources\\Registration3.xls");
	}

	@Test(priority = 1, groups = { "sanity" }, enabled = true)
	public void verifyFileUpload() {

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Utility2.getScreenshot(driver, result.getName());
		}

//		driver.quit();
	}

}
